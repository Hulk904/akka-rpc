package com.jd.akka.client;

import akka.actor.ActorRef;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.jd.akka.Request;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ObjectProxy implements InvocationHandler{

    private ActorRef actorRef;

    public Object proxy(Class service, ActorRef actorRef){
        this.actorRef = actorRef;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{service}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParamTypes(method.getParameterTypes());
        request.setParamValues(args);
        Future<Object> futureResult = Patterns.ask(actorRef, request, Timeout.apply(1, TimeUnit.SECONDS));
        return Await.result(futureResult, Duration.create(1, TimeUnit.SECONDS));
    }

    public ActorRef getActorRef() {
        return actorRef;
    }

    public void setActorRef(ActorRef actorRef) {
        this.actorRef = actorRef;
    }
}
