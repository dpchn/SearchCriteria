package com.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BuildFactory {

	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {
		if (null == factory) {
			factory = new Configuration().configure().buildSessionFactory();
			return factory;
		} else {
			return factory;
		}
	}

}
