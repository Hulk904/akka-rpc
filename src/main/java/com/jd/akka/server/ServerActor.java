package com.jd.akka.server;

import akka.actor.UntypedActor;
import com.jd.akka.Request;
import com.jd.akka.test.UserService;
import com.jd.akka.test.UserServiceImpl;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 7/26/18.
 */
public class ServerActor  extends UntypedActor {


    @Override
    public void onReceive(Object o) throws Exception{
        if(o instanceof Request){
            getSender().tell(handle((Request)o), getSelf());
        }
        if(o instanceof String){
            System.out.println(o);
        }
        unhandled(o);
    }

    private Map<String, Object> getServerMap(){
        Map<String, Object> serverMap = new HashMap<String, Object>();
        serverMap.put(UserService.class.getName(), new UserServiceImpl());
        return serverMap;
    }

    private Object handle(Request request) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String serviceName = request.getClassName();
        Object serviceImpl = getServerMap().get(serviceName);
        if(serviceImpl == null){
            throw new RuntimeException(serviceName + " service found !");
        }

        //todo 报错  未解决
//        FastClass serviceFastClass = FastClass.create(serviceImpl.getClass());
//        FastMethod serviceFastMethod = serviceFastClass.getMethod(request.getMethodName(),
//                request.getParamTypes());
//        return serviceFastMethod.invoke(serviceImpl, request.getParamValues());

        Method method = serviceImpl.getClass().getMethod(request.getMethodName(), request.getParamTypes());
        return method.invoke(serviceImpl, request.getParamValues());
    }

}