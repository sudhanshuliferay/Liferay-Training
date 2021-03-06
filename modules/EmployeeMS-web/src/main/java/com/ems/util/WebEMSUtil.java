package com.ems.util;

import java.util.List;

import javax.portlet.PortletRequest;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.service.DepartmentLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.service.TeamLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

public class WebEMSUtil {

	private static final Log LOG = LogFactoryUtil.getLog(WebEMSUtil.class);

	public static ThemeDisplay getThemeDisplay(PortletRequest portletRequest) {
		/*
		 * Enumeration<String> enumeration=portletRequest.getAttributeNames(); while
		 * (enumeration.hasMoreElements()) { String string = (String)
		 * enumeration.nextElement();
		 * LOG.info("name : "+string+"value : "+portletRequest.getAttribute(string));
		 * 
		 * }
		 */
		if (Validator.isNotNull(portletRequest)) {
			return (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		} else {
			return null;
		}
	}

	public static JSONArray getTeams(int start, int end) {
		JSONArray teamsJsonArr = getJsonArray(StringPool.BLANK);
		List<Team> teams = TeamLocalServiceUtil.getTeams(start, end);
		for (Team team : teams) {
			JSONObject teamJson = JSONFactoryUtil.createJSONObject();
			teamJson.put("teamId", team.getTeamId());
			teamJson.put("teamName", team.getName());
			teamsJsonArr.put(teamJson);
		}
		return teamsJsonArr;
	}

	public static JSONArray getDepartments(int start, int end) {
		JSONArray deptsJsonArr = getJsonArray(StringPool.BLANK);
		List<Department> depts = DepartmentLocalServiceUtil.getDepartments(start, end);
		for (Department dept : depts) {
			JSONObject deptJson = JSONFactoryUtil.createJSONObject();
			deptJson.put("deptId", dept.getDeptId());
			deptJson.put("deptName", dept.getDeptName());
			deptsJsonArr.put(deptJson);
		}
		return deptsJsonArr;
	}

	/**
	 * create json string or pass null to get empty json object.
	 * 
	 * @param json
	 * @return jsonObject
	 */
	public static JSONObject getJsonObject(String json) {
		if (Validator.isNotNull(json)) {
			try {
				JSONFactoryUtil.createJSONObject(json);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return JSONFactoryUtil.createJSONObject();
	}

	/**
	 * create jsonArr string or pass null to get empty json array.
	 * 
	 * @param json
	 * @return jsonArray
	 */
	public static JSONArray getJsonArray(String jsonArr) {
		if (Validator.isNotNull(jsonArr)) {
			try {
				JSONFactoryUtil.createJSONArray(jsonArr);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return JSONFactoryUtil.createJSONArray();
	}

	/**
	 * 
	 */
	public static String getValue(Employee employee, String columName) {
		if (Validator.isNotNull(employee) && Validator.isNotNull(columName)) {
			if (columName.equalsIgnoreCase("ename")) {
				return employee.getEname();
			} else if (columName.equalsIgnoreCase("emailAddress")) {
				return employee.getEmailAddress();
			} else if (columName.equalsIgnoreCase("hrName")) {
				return employee.getHrName();
			} else if (columName.equalsIgnoreCase("deptName")) {
				return String.valueOf(employee.getDeptId());
			}
		}
		LOG.info("employee is null or column name is null.");
		return StringPool.BLANK;
	}
}
