package com.keosimage.train.ch03.startup;

import com.keosimage.train.ch03.connector.http.Constants;
import com.keosimage.train.ch03.connector.http.HttpConnector;

public class Bootstrap {

	public static void main(String[] args) {
		System.out.println("webroot:" + Constants.WEB_ROOT);
		HttpConnector connector = new HttpConnector();
	    connector.start();
	}

}
