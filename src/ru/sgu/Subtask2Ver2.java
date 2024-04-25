package ru.sgu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.*;
        import java.util.ArrayList;
import java.util.zip.*;

public class Subtask2Ver2 {

    private Path dir;
    private String str;

    public Subtask2Ver2(String dirName, String strName) {
        this.dir = Paths.get(dirName);
        this.str = strName.toLowerCase();
    }

    public boolean isCorrectName(Path file) {
        return file.getFileName().toString().toLowerCase().contains(str);
    }

    public static void zip(Path dir, ArrayList<File> filesToZip) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(dir + ".zip"));) {
            for (File file : filesToZip) {
                if(file.isDirectory()) {
                    zipSubDirectory(dir, file, zipOut);
                } else {
                    zipFile(dir, file, zipOut);
                }
            }
        }
    }

    private static void zipFile(Path dir, File file, ZipOutputStream zipOut) throws IOException {
        zipOut.putNextEntry(new ZipEntry(dir.relativize(file.toPath()).toString()));
        Files.copy(file.toPath(), zipOut);
        zipOut.closeEntry();
    }


    private static void zipSubDirectory(Path dir, File subDir, ZipOutputStream zipOut) throws IOException {
        Files.walkFileTree(subDir.toPath(), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                zipOut.putNextEntry(new ZipEntry(dir.relativize(file).toString()));
                Files.copy(file, zipOut);
                zipOut.closeEntry();
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void run() throws IOException {

        ArrayList<File> filesToZip = new ArrayList<>();

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (isCorrectName(file)) {
                    filesToZip.add(file.toFile());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (isCorrectName(dir)) {
                    filesToZip.add(dir.toFile());
                }
                return FileVisitResult.CONTINUE;
            }

        });

        zip(dir, filesToZip);
    }
}
