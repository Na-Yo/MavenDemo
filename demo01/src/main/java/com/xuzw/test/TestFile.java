package com.xuzw.test;

import java.io.File;
import java.io.FileOutputStream;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("D:\\testFile\\a.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try(FileOutputStream _fos = new FileOutputStream(file);){
            System.out.println(_fos);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
