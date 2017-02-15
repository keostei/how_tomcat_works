package com.keosimage.train.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

		Socket socket = new Socket("127.0.0.1", 9001);
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw.println("GET /cloud/how_tomcat_works HTTP/1.1");
//		pw.println("Content-Type: text/plain");
//		pw.println("Accept: text/plain");
		pw.println("Host: localhost:9001");
		pw.println("Connection: Keep-Alive");
		pw.println("User-Agent: Apache-HttpClient/4.5.2 (Java/1.8.0_112)");
		pw.println("Accept-Encoding: gzip,deflate");
		pw.println();
		pw.println("lastName=Chao");

		boolean loop = true;
		StringBuffer sb = new StringBuffer(8096);
		while (loop) {
			if (br.ready()) {
				int i = 0;
				while (i != -1) {
					i = br.read();
					sb.append((char) i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
		}
		// display the response to the out console
		System.out.println(sb.toString());
		socket.close();

	}

}
