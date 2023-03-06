package com.rest.application;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author sudhanshu
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest" }, service = Application.class)
public class DemoJaxRSWebServciesApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@POST
	@Path("/morningNew")
	@Produces("application/json")
	@Consumes("application/json")
	public String morning(/*
								 * @PathParam("name") String name,
								 * 
								 * @QueryParam("drink") String drink
								 */String json) {
		JSONObject jsonObject;
		try {
			if (Validator.isNotNull(json)) {
				jsonObject = JSONFactoryUtil.createJSONObject(json);

				String name = jsonObject.getString("name");
				String drink = jsonObject.getString("drink");
				JSONObject resultJson = JSONFactoryUtil.createJSONObject();
				String greeting = "Good Morning " + name;
				resultJson.put("welcomeMsg", greeting);
				if (drink != null) {
					resultJson.put("welcomeMsgWithDrink", greeting += ". Would you like some " + drink + "?");
				}

				return resultJson.toString();
			} else {
				System.out.println("request Json is null");
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONObject().toString();
	}

}