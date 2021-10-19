package om.clientwebservice.call.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import om.clientwebservice.call.domain.User;

/**
 * @author sudhanshu
 */
public class ClientWebServices {

	public static void main(String[] args) {
		try {
			//demoGetRESTAPI();
			
			User sudhanshu=new User();
			sudhanshu.setEmail("asdasd");
			sudhanshu.setFirst_name("sudhanshu");
			sudhanshu.setLast_name("last_name");

			
			User user2=new User();
			sudhanshu.setEmail("asdasd");
			sudhanshu.setFirst_name("sudhanshu");
			sudhanshu.setLast_name("last_name");
			
			User user3=new User();
			sudhanshu.setEmail("asdasd");
			sudhanshu.setFirst_name("sudhanshu");
			sudhanshu.setLast_name("last_name");
			
			User user4=new User();
			sudhanshu.setEmail("asdasd");
			sudhanshu.setFirst_name("sudhanshu");
			sudhanshu.setLast_name("last_name");
			
			List<User> list=new ArrayList<User>();
			
			list.add(sudhanshu);
			list.add(sudhanshu);
			list.add(sudhanshu);
			list.add(sudhanshu);
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void demoGetRESTAPI() throws Exception {
		
		//HttpClient => to initalize the request or to open open connection client and server.
		//HttpGet, HttpPost, => to prepare the request 
		
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

			HttpGet getRequest = new HttpGet("https://reqres.in/api/users?page=2");
//			URI uri= URIBuilder.create("https://reqres.in/api/users?page=2").build();
			
//			getRequest.setParams(params);
			getRequest.addHeader("content-type", "application/json");
			
			CloseableHttpResponse response = httpClient.execute(getRequest);
			
			int statusCode = response.getStatusLine().getStatusCode();
			//200  Success 200, 201, 202
			//300  redirection 301,302
			//400  bad request/client side error  401,402,403,404
			//500  server error
			
			// pojo/bean class to hold the data.
			// unmarshelling the converting the data from string to xml/json/userdefined objects
			// marshelling the converting the from xml/json/userdefined  to string
			
			if (statusCode > 200 && statusCode <300 ) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}
			
			String data=EntityUtils.toString(response.getEntity());
			
			Gson gson=new Gson();
			JsonObject dataJson=gson.fromJson(data, JsonObject.class);
			System.out.println(dataJson.toString());
			
			JsonArray dataArr=dataJson.getAsJsonArray("data");
			System.out.println("\n\n\ndata Json : "+dataArr.toString());
			
			java.lang.reflect.Type typeOfT = new TypeToken<List<User>>(){}.getType();
			List<User> users=gson.fromJson(dataArr.toString(), typeOfT);
			for (User user : users) {
				System.out.println(" id : "+user.getId());
			}
			/*
			 * JsonArray dataArr=dataJson.getAsJsonArray("data");
			 * 
			 * for (JsonElement jsonElement : dataArr) { JsonObject
			 * jsonObject=jsonElement.getAsJsonObject();
			 * System.out.println("id : "+jsonObject.get("id").getAsString());
			 * System.out.println("email : "+jsonObject.get("email").getAsString());
			 * System.out.println("first_name : "+jsonObject.get("first_name").getAsString()
			 * );
			 * System.out.println("last_name : "+jsonObject.get("last_name").getAsString());
			 * System.out.println("avatar Url : "+jsonObject.get("avatar").getAsString()); }
			 */
			
			
			
		} catch (Exception e) {
			// Important: Close the connect
			// httpClient.getConnectionManager().shutdown();
			e.printStackTrace();
		}
	}

}