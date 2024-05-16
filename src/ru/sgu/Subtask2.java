package ru.sgu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Subtask2 {

    private Path sourceFolderPath;
    private String keyword;

    public Subtask2(String dirName, String strName) {
        this.sourceFolderPath = Paths.get(dirName);
        this.keyword = strName.toLowerCase();
    }

    public void zipFolder() throws Exception {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(sourceFolderPath + ".zip"));
        Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileName = sourceFolderPath.relativize(file).toString();
                if (fileName.toLowerCase().contains(keyword)) {
                    zos.putNextEntry(new ZipEntry(fileName));
                    Files.copy(file, zos);
                    zos.closeEntry();
                }
                return FileVisitResult.CONTINUE;
            }
        });
        zos.close();
    }
}
