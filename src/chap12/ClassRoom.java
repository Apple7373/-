package chap12;
/*
 *   chap12
 *   Author：fjs
 *   2022-05-25
 *   10:21
 */


import javax.swing.*;

public class ClassRoom implements Runnable{

    Thread teacher, student;
    ClassRoom() {
        teacher = new Thread(this);
        student = new Thread(this);
        teacher.setName("王教授");
        student.setName("张三");
    }
    public void run() {
        if(Thread.currentThread() == student) {
            try {
                System.out.println(student.getName() + "正在睡觉，不听课！");
                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) {
                System.out.println(student.getName() + "被唤醒");
            }
            System.out.println("开始听课");
        }
        else if (Thread.currentThread() == teacher) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("上课");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            student.interrupt();
        }
    }

}
