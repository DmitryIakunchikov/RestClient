
package com.amazontest.steps;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class ApacheHttpClientPost {

   // http://localhost:8080/RESTfulExample/json/product/post
   public void thm(String url) {

       try {

           DefaultHttpClient httpClient = new DefaultHttpClient();
           HttpPost postRequest = new HttpPost(
                   "http://www.google.com");
           postRequest.addHeader("accept", "application/json");

           StringEntity input = new StringEntity(
                   "{\"qty\":100,\"name\":\"iPad 4\"}");
           input.setContentType("application/json");
           postRequest.setEntity(input);

           HttpResponse response = httpClient.execute(postRequest);

           if (response.getStatusLine().getStatusCode() != 201) {
               throw new RuntimeException("Failed : HTTP error code : "
                       + response.getStatusLine().getStatusCode());
           }

           BufferedReader br = new BufferedReader(new InputStreamReader(
                   (response.getEntity().getContent())));

           String output;
           System.out.println("Output from Server .... \n");
           while ((output = br.readLine()) != null) {

               System.out.println(output);
           }

           httpClient.getConnectionManager().shutdown();

       } catch (MalformedURLException e) {

           e.printStackTrace();
       } catch (IOException e) {

           e.printStackTrace();

       }

   }

}