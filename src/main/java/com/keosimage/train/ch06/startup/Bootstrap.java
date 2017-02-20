package com.keosimage.train.ch06.startup;

import org.apache.catalina.Connector;
import org.apache.catalina.Context;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Loader;
import org.apache.catalina.Mapper;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;

import com.keosimage.train.ch06.core.SimpleContext;
import com.keosimage.train.ch06.core.SimpleContextLifecycleListener;
import com.keosimage.train.ch06.core.SimpleContextMapper;
import com.keosimage.train.ch06.core.SimpleLoader;
import com.keosimage.train.ch06.core.SimpleWrapper;

public final class Bootstrap {
	public static void main(String[] args) {
		Connector connector = new HttpConnector();
		Wrapper wrapper1 = new SimpleWrapper();
		wrapper1.setName("Primitive");
		wrapper1.setServletClass("com.keosimage.train.servlet.PrimitiveServlet");
		Wrapper wrapper2 = new SimpleWrapper();
		wrapper2.setName("Modern");
		wrapper2.setServletClass("com.keosimage.train.servlet.ModernServlet");

		Context context = new SimpleContext();
		context.addChild(wrapper1);
		context.addChild(wrapper2);

		Mapper mapper = new SimpleContextMapper();
		mapper.setProtocol("http");
		LifecycleListener listener = new SimpleContextLifecycleListener();
		((Lifecycle) context).addLifecycleListener(listener);
		context.addMapper(mapper);
		Loader loader = new SimpleLoader();
		context.setLoader(loader);
		// context.addServletMapping(pattern, name);
		context.addServletMapping("/Primitive", "Primitive");
		context.addServletMapping("/Modern", "Modern");
		connector.setContainer(context);
		try {
			connector.initialize();
			((Lifecycle) connector).start();
			((Lifecycle) context).start();

			// make the application wait until we press a key.
			System.in.read();
			((Lifecycle) context).stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}