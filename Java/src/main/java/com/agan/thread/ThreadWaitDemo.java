package com.agan.thread;

public class ThreadWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName()+" start t1");
                t1.start();
                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName()+" wait()");
                t1.wait();  //  不是使t1线程等待，而是当前执行wait的线程等待
                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread{
        public ThreadA(String name) {
            super(name);
        }
        public void run() {
            synchronized (this) {
                try {
                    Thread.sleep(10000); //  使当前线阻塞 10 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" call notify()");
                // 唤醒当前的wait线程
                this.notify();
            }
        }
    }
}

