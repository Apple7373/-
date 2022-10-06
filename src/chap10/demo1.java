package chap10;
/*
 *   chap10
 *   Author：fjs
 *   2022-05-30
 *   10:55
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class demo1 {
    public static void main(String[] args) {
        int n = -1;
        byte[] a = new byte[100];
        File file = new File("d:/new.txt");
        try {
            InputStream fin = new FileInputStream(file);
            while ((n = fin.read(
                    a,0,100)) != -1) {
                String s = new String(a,0,n);
                System.out.print(s);
            }
            fin.close();
        }catch (IOException e) {
            System.out.println("file error!");
        }
    }
    public static void doSome() {
        System.out.println("doSome");
    }
    public static void doOther() {
        System.out.println("do Other");
    }
    public void B(){
        System.out.println("b");
    }

}
