package com.jd.akka.client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.jd.akka.server.ServerActor;
import com.typesafe.config.ConfigFactory;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ClientBootstrap {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys", ConfigFactory.load("client.conf"));
        ActorRef actorRef = system.actorOf(Props.create(ServerActor.class), "reomteActor");
        actorRef.tell("hi , i'm  client.", actorRef);
    }

}
