package com.dq.portlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.dq.constants.DQUserPortletKeys;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DQUser",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DQUserPortletKeys.DQUSER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DQUserPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		//first way from which we can get DQ object.
		DynamicQuery userDyQuery=UserLocalServiceUtil.dynamicQuery();
		//portallevelclassloader
		//portrletlevelclassloader
		
		//second way from which we can get DQ object.
		//DynamicQuery userDyQuery2=DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
		
		//conjection || disjunction  where and || OR (clause)
		//projection || columns ,joins multiple condition.
		//userDyQuery.add(RestrictionsFactoryUtil.like("screenName", "fau"));
		
		//and condition 
		userDyQuery.add(fetchUserByConjection());
		// order by clause into or query.
		userDyQuery.addOrder(OrderFactoryUtil.asc("screenName"));
		
		//or condition
		userDyQuery.add(fetchUserByDisConjection());
		
		System.out.println("querying data from DQ................");
		try {
			List<User> userList=UserLocalServiceUtil.dynamicQuery(userDyQuery);
			for (User user : userList) {
				System.out.println("user name : "+user.getScreenName()+" email Address : "+user.getEmailAddress()+" enc password : "+user.getPasswordEncrypted());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nafter applying projection ..............");
		
		userDyQuery.setProjection(getUserColumns());
		
		try {
			List<Object[]> userProList=UserLocalServiceUtil.dynamicQuery(userDyQuery);
			for (Object[] columns : userProList) {
				if(columns[0] instanceof Long) {
					System.out.println("user id : "+columns[0]);
				}else {
					System.out.println("Emailaddress : "+columns[1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end of querying data from DQ.");
		
		
		System.out.println("getting data from roles and user from dyanmic query.");
		List<Role> roles=getRolesBasedOnUserIds();
		 
		renderRequest.setAttribute("roles", roles);
		
		
		super.render(renderRequest, renderResponse);
	}
	
	public Conjunction fetchUserByConjection(){
		Conjunction conjunction= RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.like("passwordEncrypted", true));
		conjunction.add(RestrictionsFactoryUtil.in("userId", Arrays.asList(20105l,20129l,3019l)));
		return conjunction;
	}
	
	public Disjunction fetchUserByDisConjection(){
		Disjunction disjunction= RestrictionsFactoryUtil.disjunction();
		disjunction.add(RestrictionsFactoryUtil.like("screenName", "test"));
		return disjunction;
	}
	
	public Projection getUserColumns() {
		ProjectionList columnProjections= ProjectionFactoryUtil.projectionList();
		columnProjections.add(PropertyFactoryUtil.forName("userId"));
		columnProjections.add(PropertyFactoryUtil.forName("emailAddress"));
		return columnProjections;
		
	}
	
	public List<Role> getRolesBasedOnUserIds(){
		
		DynamicQuery userDynamicQuery=UserLocalServiceUtil.dynamicQuery();
		ProjectionList userIdProjection=ProjectionFactoryUtil.projectionList();
		userIdProjection.add(PropertyFactoryUtil.forName("userId"));
		userDynamicQuery.setProjection(userIdProjection);
		
		DynamicQuery roleDynamicQuery=RoleLocalServiceUtil.dynamicQuery();
		roleDynamicQuery.add(RestrictionsFactoryUtil.in("userId", UserLocalServiceUtil.dynamicQuery(userDynamicQuery)));
		
		//select * from role_ r where userId in(select userId from user_ u);
		// from the aggerate data for upto 2 tables join
		try {
			List<Role> roles=RoleLocalServiceUtil.dynamicQuery(roleDynamicQuery);
			for (Role role : roles) {
				System.out.println("Role name "+role.getRoleId()+" for user id : "+role.getUserId());
			}
			return roles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Collections.EMPTY_LIST;
	}
	
	
}