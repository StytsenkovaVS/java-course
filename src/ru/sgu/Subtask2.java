package ru.sgu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.*;
import java.util.zip.*;

public class Subtask2 {

    private Path dir;
    private String str;
    private ZipOutputStream zipOut;
    private boolean inTargetDir = false;

    public Subtask2(String dirName, String strName) {
        this.dir = Paths.get(dirName);
        this.str = strName.toLowerCase();
    }

    public boolean isCorrectName(Path file) {
        return file.getFileName().toString().toLowerCase().contains(str);
    }

    public void run() {
        try {
            zipOut = new ZipOutputStream(new FileOutputStream(dir + ".zip"));
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (isCorrectName(dir) || dir.equals(Subtask2.this.dir)) {
                        inTargetDir = true;
                        zipOut.putNextEntry(new ZipEntry(Subtask2.this.dir.relativize(dir) + "/"));
                        zipOut.closeEntry();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (inTargetDir || isCorrectName(file)) {
                        zipOut.putNextEntry(new ZipEntry(dir.relativize(file).toString()));
                        Files.copy(file, zipOut);
                        zipOut.closeEntry();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (isCorrectName(dir) || dir.equals(Subtask2.this.dir)) {
                        inTargetDir = false;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            zipOut.close();
            System.out.println("Архивация прошла успешно");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
