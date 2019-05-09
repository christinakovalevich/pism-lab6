package com.kovalevich.pismlab6ck;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
    public static void main(String[] args) throws NamingException {

        InitialContext context = new InitialContext();
        MyBeanRemote bean = (MyBeanRemote) context.lookup(Config.MAPPED_NAME);

        System.out.println(bean.getWorkers());
    }
}
