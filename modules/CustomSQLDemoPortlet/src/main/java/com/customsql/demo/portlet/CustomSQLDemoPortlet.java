package com.customsql.demo.portlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.customsql.demo.constants.CustomSQLDemoPortletKeys;
import com.demo.customsql.model.CustomSQLTest;
import com.demo.customsql.service.CustomSQLTestLocalService;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.training.customsql.model.Training;
import com.training.customsql.service.TrainingLocalServiceUtil;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomSQLDemo", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomSQLDemoPortletKeys.CUSTOMSQLDEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class CustomSQLDemoPortlet extends MVCPortlet {

	@Reference
	private CustomSQLTestLocalService customSQlTestService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// jdbc call

		try (Connection connection = DataAccess.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String screenName = resultSet.getString("screenName");
				System.out.println("Screen name is : " + screenName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<CustomSQLTest> users = customSQlTestService.findByScreenNameLikeUser("test_Sudhanshu");
		System.out.println("total users list is : " + users.size());
		renderRequest.setAttribute("users", users);

		List<Training> trainings = TrainingLocalServiceUtil.findTrainingByName("Training");

		for (Training training : trainings) {
			System.out.println("tarining name is : " + training.getTrainingName());
		}

		super.render(renderRequest, renderResponse);
	}

}