package com.jd.akka.server;

import akka.actor.UntypedActor;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ServerActor  extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception{
        if(o instanceof String){
            System.out.println( "发送者:" + getSender()  + ", message =" + o);
            getSender().tell("hello:" + o, getSelf());
        }
        unhandled(o);
    }

}