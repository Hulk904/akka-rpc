package com.jd.akka.client;

import akka.actor.UntypedActor;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ClientActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof String){
            System.out.println(o);
        }
        System.out.println("not string");
    }
}
