package com.tci.readers.listener;

import com.tci.readers.dao.SSHConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    private SSHConnection conexionssh;

    public MyContextListener()
    {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized ... !");
        try
        {
            conexionssh = new SSHConnection();
        }
        catch (Throwable e)
        {
            e.printStackTrace(); // error connecting SSH server
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed ... !");
        conexionssh.closeSSH(); // disconnect
    }
}
