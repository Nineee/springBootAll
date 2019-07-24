package com.nineee.springboot.web;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.nineee.springboot.Utils.JedisConfig;
import com.nineee.springboot.Utils.RedisUtils;
import com.nineee.springboot.enity.Mans;
import com.nineee.springboot.enity.Womans;
import com.nineee.springboot.response.CustomException;
import com.nineee.springboot.response.Result;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

import java.util.concurrent.*;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @Author: ljj
 * @Date: 2019/6/18 14:45
 * @Desc
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource(name = "man")
    private Mans mann;

    @Resource(name = "woman")
    private Womans womans;

    @GetMapping("/one")
    public Result testone(@RequestParam("name") String name){
        if(name.equals("Ninee")){
            throw new NullPointerException();
        }
        if("-1".equals(name)){
            return Result.success(1/0);
        }
        if(name.equals("Nine")){
            throw new CustomException("name不正确");
        }

        if(name.equals("person")){
            womans.say();
            mann.say();
        }

        return Result.success();
    }
    public static void main(String[] args) throws InterruptedException {

        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("test_synclock-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 150, 20L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), build);
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
                /*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
               RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
                /*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
               /* try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
                /*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
                /*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
                /*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });
        executor.execute(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程："+thread.getName()+"正在抢占锁");
            boolean b = RedisUtils.tryGetSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName(), 5);
            if(b){
                System.out.println("当前线程："+thread.getName()+"抢占锁成功");
               /* try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                RedisUtils.tryRealseSyncLock(JedisConfig.getJedis(), "test_synclock", "test_synclock_"+thread.getName());
            }else {System.out.println("当前线程："+thread.getName()+"抢占锁失败");}
        });

        executor.shutdown();

        /*final int[] a = {0};
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("thread-spmoneyrepair-runner-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 8, 20L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), build);
        long start = System.currentTimeMillis();
        Future<?> result1 = threadPoolExecutor.submit(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    System.out.println("多---------1："+a[0]++);
                }
            }
        });

        Future<?> result2  = threadPoolExecutor.submit(() -> {
            for (int i = 0; i < 5000; i++) {
                System.out.println("多-----------2："+a[0]++);
            }
        });
        long end = System.currentTimeMillis();

        Future<?> result3 = threadPoolExecutor.submit(() -> {
            long start2 = System.currentTimeMillis();
            int[] b = {0};
            for (int i = 0; i < 5000; i++) {
                System.out.println("单1："+b[0]++);
            }
            for (int i = 0; i < 5000; i++) {
                System.out.println("单2："+b[0]++);
            }
            long end2 = System.currentTimeMillis();
            System.out.println(">>>>>>单线程耗时：" + String.valueOf(end2 - start2));
            System.out.println(">>>>>>多线程耗时："+String.valueOf(end-start));

        });

       threadPoolExecutor.shutdown();*/
    }





    }
//        ThreadLocal.withInitial();
     /* ThreadLocal<Integer> s = ThreadLocal.withInitial(()->initdd(1));
        for (int i = 0; i < 10; i++) {
            new Thread((new Runnable() {
                @Override
                public void run() {
                    s.set(s.get()+1);
                    Integer s1 = s.get();
                    System.out.println(s1);
                }
            })).start();
        }



    }
    static int initdd(int i){
        return i;
    };*/


