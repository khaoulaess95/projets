package com.web.actions.authentification;

import org.hibernate.sql.ordering.antlr.Factory;

import com.bo.Client;


public class LoginAction{
 
	private static final long serialVersionUID = 1L;
	private Client user;
    private String login;
    private String pwd;
 
 
	/**
         * @param pwd the pwd to set
         */
    public void setPwd(String pwd) {
		this.pwd = pwd;
	}
 
	/**
         * @return the pwd
         */
	public String getPwd() {
		return pwd;
	}
 
      /**
         * @param login the login to set
         */
 
    public void setLogin(String login) {
		this.login = login;
	}
 
	/**
         * @return the login
         */
	public String getLogin() {
		return login;
	}
 
	/**
         * @param user the user to set
         */
	public void setUser(Client user) {
		this.user = user;
	}
	/**
         * @return the user
         */
	public Client getUser() {
		return user;
	}
 
 
    public String execute()  {
    	try
    	{	user=(Client)Factory.getInstance().getUserService().log(getLogin(), getPwd());
    		if(user!=null)
    	        return SUCCESS;
    		else{ 
    		addActionError(getText("error.login.user"));
    		return ERROR;
    		}
    	}
    	catch (Exception e) {
    		e.printstacktrace();
    		return ERROR;
		}
 
 
    }
 
}
