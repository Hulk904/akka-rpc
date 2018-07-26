package com.jd.akka.client;


/**
 * Created by yangyuan on 7/26/18.
 */
public class Client {

    public <T> T getBean(Class<T> clazz){
       return (T) new ObjectProxy().proxy(clazz, ActorFactory.getActor());
    }



}
