package com.keosimage.train.ch05.startup;

import org.apache.catalina.Context;
import org.apache.catalina.Loader;
import org.apache.catalina.Mapper;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;

import com.keosimage.train.ch05.core.SimpleContext;
import com.keosimage.train.ch05.core.SimpleContextMapper;
import com.keosimage.train.ch05.core.SimpleLoader;
import com.keosimage.train.ch05.core.SimpleWrapper;
import com.keosimage.train.ch05.valves.ClientIPLoggerValve;
import com.keosimage.train.ch05.valves.HeaderLoggerValve;

public final class Bootstrap2 {
	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		Wrapper wrapper1 = new SimpleWrapper();
		wrapper1.setName("Primitive");
		wrapper1.setServletClass("com.keosimage.train.servlet.PrimitiveServlet");
		Wrapper wrapper2 = new SimpleWrapper();
		wrapper2.setName("Modern");
		wrapper2.setServletClass("com.keosimage.train.servlet.ModernServlet");

		Context context = new SimpleContext();
		context.addChild(wrapper1);
		context.addChild(wrapper2);

		Valve valve1 = new HeaderLoggerValve();
		Valve valve2 = new ClientIPLoggerValve();

		((Pipeline) context).addValve(valve1);
		((Pipeline) context).addValve(valve2);

		Mapper mapper = new SimpleContextMapper();
		mapper.setProtocol("http");
		context.addMapper(mapper);
		Loader loader = new SimpleLoader();
		context.setLoader(loader);
		// context.addServletMapping(pattern, name);
		context.addServletMapping("/Primitive", "Primitive");
		context.addServletMapping("/Modern", "Modern");
		connector.setContainer(context);
		try {
			connector.initialize();
			connector.start();

			// make the application wait until we press a key.
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}