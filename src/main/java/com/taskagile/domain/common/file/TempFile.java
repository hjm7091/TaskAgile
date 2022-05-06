package com.taskagile.domain.common.file;

import lombok.Getter;

import java.io.File;
import java.nio.file.Path;

@Getter
public class TempFile {

    private String rootTempPath;
    private String fileRelativePath;

    public static TempFile create(String rootTempPath, Path fileAbsolutePath) {
        TempFile tempFile = new TempFile();
        tempFile.rootTempPath = rootTempPath;
        tempFile.fileRelativePath = fileAbsolutePath.toString().replaceFirst(rootTempPath + "\\\\", "");
        return tempFile;
    }

    public File getFile() {
        return new File(rootTempPath + "\\" + fileRelativePath);
    }

//    public static void main(String[] args) {
//        String rootTempPath = "E:\\\\data\\\\temp\\\\";
//        String fileAbsolutePath = "E:\\data\\temp\\attachments\\1650178241154.9cf0f85a-faa9-4857-b93e-f4505308cb93.png";
//        String result = fileAbsolutePath.replaceFirst(rootTempPath, "");
//        System.out.println(result);
//    }
}
