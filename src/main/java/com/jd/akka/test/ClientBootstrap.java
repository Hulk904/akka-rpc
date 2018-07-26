package com.jd.akka.test;

import com.jd.akka.client.Client;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ClientBootstrap {
    public static void main(String[] args) {
        Client client = new Client();
        UserService userService = client.getBean(UserService.class);
        System.out.println(userService.getPersonById(12));
    }
}
