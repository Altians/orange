package com.example.facadecontroller.demo.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class parent {

    protected Lock lock=new ReentrantLock(); //可重入锁

    public void test(){
        lock.lock();
        try{
            System.out.println("Parent");
        }finally{
            lock.unlock();
        }
    }


}

class Sub extends parent{

    @Override
    public void test() {
        // TODO Auto-generated method stub
        lock.lock();
        try{
            super.test();
            System.out.println("Sub");

        }finally{
            lock.unlock();
        }
    }


}

 class LockTest{

    public static void main(String[] args){

        Sub s=new Sub();
        s.test();

    }
}