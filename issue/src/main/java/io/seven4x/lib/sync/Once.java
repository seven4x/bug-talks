package io.seven4x.lib.sync;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Once {

    private final AtomicBoolean done = new AtomicBoolean(false);
    private final ReentrantLock lock = new ReentrantLock();

    public void Do(Silent func) {
        if (!done.get()) {
            doSlow(func);
        }
    }

    private void doSlow(Silent func) {
        try {
            lock.lock();
            if (!done.get()) {
                func.apply();
                done.set(true);
            }
        } finally {
            lock.unlock();
        }
    }


}

@FunctionalInterface
interface Silent {
    void apply();
}

class Example {

    Once once = new Once();

    public void test(String s) {
        once.Do(() -> {
            System.out.println("once...只执行一次");
        });
        //业务方法
        System.out.println(s);
    }

    public static void main(String[] args) {
        Example example = new Example();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                example.test(Thread.currentThread().getName());
            });
            t.setName("t_" + i);
            t.start();
        }
    }
}