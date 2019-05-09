package com.kovalevich.pismlab6ck;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
    public static void main(String[] args) throws NamingException {

        InitialContext ctx = new InitialContext();
        MyBeanRemote bean = (MyBeanRemote) ctx.lookup(Config.MAPPED_NAME);

        System.out.println(bean.getWorkers());
    }
}
