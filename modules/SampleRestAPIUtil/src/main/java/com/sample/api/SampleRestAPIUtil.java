package com.sample.api;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sample.api.domain.User;

/**
 * @author sudhanshu
 */
public class SampleRestAPIUtil {

	public static List<User> getAllSampleUsers() throws Exception {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet getRequest = new HttpGet("https://reqres.in/api/users?page=2");
			getRequest.addHeader("content-type", "application/json");

			CloseableHttpResponse response = httpClient.execute(getRequest);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode > 200 && statusCode < 300) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}

			String data = EntityUtils.toString(response.getEntity());
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(data);
			JSONArray dataJsonArr = jsonObject.getJSONArray("data");
			Map<String, Object> dataJsonMap =(Map<String, Object>)JSONFactoryUtil.looseDeserialize(dataJsonArr.toString(), Map.class);
			System.out.println(dataJsonMap.toString());
//			ObjectMapper mapper = new ObjectMapper();
//			List<User> users = mapper.readValue(dataJsonArr.toString(), new TypeReference<List<User>>() {
//			});

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

}