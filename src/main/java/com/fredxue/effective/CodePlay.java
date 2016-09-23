package com.fredxue.effective;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * Created by fred on 9/8/16.
 */
public class CodePlay {
    public static void main(String[] args){
        //can't select from parameterized type
//        ArrayList<Foo> list = new Gson().fromJson("[{x:1}]", ArrayList<Foo>.class);
      Foo foo = new Foo();
      Laugh proxy = (Laugh) Proxy.newProxyInstance(Handler.class.getClassLoader(),
              new Class[]{Laugh.class},  new Handler(foo));

      proxy.smile();
    }


}



class Foo implements Laugh{

    public void smile() {
        System.out.println("哈哈哈哈哈");
        return;
    }
}



class Handler implements InvocationHandler{

    private Object proxied;

    public Handler( Object proxied){
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("sad");

        method.invoke(proxied, args);

        System.out.println("sad again");
        return null;
    }
}



