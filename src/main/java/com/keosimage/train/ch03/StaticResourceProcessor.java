package com.keosimage.train.ch03;

import java.io.IOException;

import com.keosimage.train.ch03.connector.http.HttpRequest;
import com.keosimage.train.ch03.connector.http.HttpResponse;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
