package com.company;
import main.GameProgress;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        File dir1 = new File("D://Games2/src");
        dir1.mkdir();
        str.append("Создан каталог - " + dir1.getName() + "! ");
        File dir2 = new File("D://Games2/res");
        dir2.mkdir();
        str.append("Создан каталог - " + dir2.getName() + "! ");
        File dir3 = new File("D://Games2/savegames");
        dir3.mkdir();
        str.append("Создан каталог - " + dir3.getName() + "! ");
        File dir4 = new File("D://Games2/temp");
        dir4.mkdir();
        str.append("Создан каталог - " + dir4.getName() + "! ");
        File dir5 = new File("D://Games2/src/main");
        dir5.mkdir();
        str.append("Создан каталог - " + dir5.getName() + "! ");
        File dir6 = new File("D://Games2/src/test");
        dir6.mkdir();
        str.append("Создан каталог - " + dir6.getName() + "! ");
        File file1 = new File("D://Games2/src/main/","Main.java");
        try {
            if(file1.createNewFile());
            str.append("Создан файл - " + file1.getName() + "! ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File file2 = new File("D://Games2/src/main/","Utils.java");
        try {
            if(file2.createNewFile());
            str.append("Создан файл - " + file2.getName() + "! ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File dir7 = new File("D://Games2/res/drawables");
        dir7.mkdir();
        str.append("Создан каталог - " + dir7.getName() + "! ");
        File dir8 = new File("D://Games2/res/vectors");
        dir8.mkdir();
        str.append("Создан каталог - " + dir8.getName() + "! ");
        File dir9 = new File("D://Games2/res/icons");
        dir9.mkdir();
        str.append("Создан каталог - " + dir9.getName() + "! ");
        File file3 = new File("D://Games2/temp","temp.txt");
        try {
            if(file3.createNewFile());
            str.append("Создан файл - " + file1.getName() + "! ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String s = str.toString();
        try (FileWriter fw = new FileWriter("D://Games2/temp/temp.txt",false)) {
           fw.write(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        GameProgress gm1 = new GameProgress(100,4,3,10);
        savegame("D://Games2/savegames/save1.dat", gm1);
        GameProgress gm2 = new GameProgress(80,6,7,20);
        savegame("D://Games2/savegames/save2.dat", gm2);
        GameProgress gm3 = new GameProgress(55,2,1,5);
        savegame("D://Games2/savegames/save3.dat", gm3);
        zipFiles("D://Games2/savegames/zip.zip", Arrays.asList("D://Games2/savegames/save1.dat",
                "D://Games2/savegames/save2.dat","D://Games2/savegames/save3.dat"));


    }

    public static void savegame(String path, GameProgress gm) {
        try(FileOutputStream fl = new FileOutputStream(path);
            ObjectOutputStream obj = new ObjectOutputStream(fl)) {
            obj.writeObject(gm);
        }   catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void zipFiles(String zipPath, List<String> filesPath) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (int i = 0; i < filesPath.size(); i++) {
                try(FileInputStream fl = new FileInputStream(filesPath.get(i))){
                    ZipEntry ze = new ZipEntry(filesPath.get(i));
                    zos.putNextEntry(ze);
                    byte[] buffer = new byte[fl.available()];
                    fl.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            }
            catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
