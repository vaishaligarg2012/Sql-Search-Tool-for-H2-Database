package com.Cmail.Listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class RedirectToLoginCheck implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("check listeners ");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Session Destroyed");

    }

}
