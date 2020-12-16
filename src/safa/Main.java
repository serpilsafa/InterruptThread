package safa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started...");

                for(int i = 0; i<10000000; i++){

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread was interrupted");
                        return;
                    }


                    list.add(i);
                }

                System.out.println("Thread finished and list size: "+ list.size());
            }
        });


        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        System.out.println("Main thread finished");
    }
}
