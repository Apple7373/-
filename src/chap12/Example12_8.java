package chap12;
/*
 *   chap12
 *   Author：fjs
 *   2022-05-25
 *   10:44
 */


public class Example12_8 {
  public static void main(String[] args) throws InterruptedException {
    TicketHouse o = new TicketHouse();
    Thread zhangfei = new Thread(o);
   zhangfei.setName("张飞");
   Thread likui = new Thread(o);
   likui.setName("李逵");
   likui.start();
   Thread.sleep(100);
   zhangfei.start();
  }
}

class TicketHouse implements Runnable {
  int fiveAmount = 2, tenAmount = 0, twentyAmount = 0;

  public  void run() {
    if (Thread.currentThread().getName().equals("张飞")) {
      saleTicket(5);
    }
    else if(Thread.currentThread().getName().equals("李逵")) {
      saleTicket(20);
    }
  }

  public synchronized void saleTicket(int money) {
    if (money == 5) {
      fiveAmount += 1;
      System.out.println("给" + Thread.currentThread().getName()+"票");
    }
    else if(money==20) {
      while (fiveAmount < 3) {
        try {
          System.out.println(Thread.currentThread().getName() + "靠边等");
          wait();
          System.out.println(Thread.currentThread().getName() + "继续买票");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      fiveAmount -= 3;
      twentyAmount += 1;
      System.out.println("给" + Thread.currentThread().getName() + "piao");
    }
    notifyAll();
  }
}
