package com.jd.akka.test;

import com.jd.akka.client.Client;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ClientBootstrap {
    public static void main(String[] args) {
        Client client = new Client();
        UserService userService = client.getBean(UserService.class);
        long start = System.currentTimeMillis();
        new Thread(()->{
            for(int i = 1;i <10; i++) {
                userService.getPersonById(12);
            }
        }).start();
        new Thread(()->{
            for(int i = 1;i <10; i++) {
                userService.getPersonById(12);
            }
        }).start();
        System.out.println((System.currentTimeMillis() - start)/1000.0);
    }
}
