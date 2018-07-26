package com.jd.akka.server;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.*;


/**
 * Created by yangyuan on 7/26/18.
 */
public class ServerBootstrap {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys", ConfigFactory.load("application.conf"));
        ActorRef actorRef = system.actorOf(Props.create(ServerActor.class), "rmtActor");
    }
}
