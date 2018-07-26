package com.jd.akka.client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.jd.akka.server.ServerActor;
import com.typesafe.config.ConfigFactory;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ActorFactory {

    private static ActorSystem system = ActorSystem.create("sys", ConfigFactory.load("client.conf"));

    public static ActorRef getActor(){
        return system.actorOf(Props.create(ServerActor.class), "remoteActor");
    }
}
