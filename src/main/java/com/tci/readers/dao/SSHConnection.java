package com.tci.readers.dao;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHConnection {
    //local ppk file
    private final static String S_PATH_FILE_PRIVATE_KEY = "d:\\software\\clee.ppk";
    //always 22
    private final static int SSH_REMOTE_PORT = 22;
    //login in user name
    private final static String SSH_USER = "clee";
    //remote server ip
    private final static String MYSQL_REMOTE_SERVER = "52.10.174.225";

    private Session sesion; //represents each ssh session

    public void closeSSH ()
    {
        sesion.disconnect();
    }

    public SSHConnection () throws Throwable
    {
        //init jsch
        JSch jsch = null;

        jsch = new JSch();
        jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY);
        sesion = jsch.getSession(SSH_USER, MYSQL_REMOTE_SERVER, SSH_REMOTE_PORT);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        sesion.setConfig(config);
        sesion.connect(); //ssh connection established!
        //mapping port, remote mysql internal ip, remote mysql server internal port
        sesion.setPortForwardingL(3307, "10.0.10.150", 3306);
    }
}
