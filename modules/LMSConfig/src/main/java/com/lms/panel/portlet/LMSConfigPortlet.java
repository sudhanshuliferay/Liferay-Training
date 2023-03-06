package com.lms.panel.portlet;

import com.lms.model.LibraryStore;
import com.lms.panel.constants.LMSConfigPortletKeys;
import com.lms.service.LibraryStoreLocalServiceUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=LMSConfig",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LMSConfigPortletKeys.LMSCONFIG,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
	},
	service = Portlet.class
)
public class LMSConfigPortlet extends MVCPortlet {

	private Log log=LogFactoryUtil.getLog(LMSConfigPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String propertyName="sample.webservice.url";
		
		Configuration configuration=ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
		String value=configuration.get(propertyName);
		
		/*
		 * List<User> list =UserLocalServiceUtil.getUsers(-1, -1);
		 * 
		 * list.stream().filter((u)->{ return u.getFirstName().contains("s") ||
		 * u.getEmailAddress().contains("t"); }).collect(Collectors.toList());
		 */
		
		
		
		DynamicQuery dynamicQuery= getConjuction();
		
		//select * from User_ where firstName like '%s%' OR emailAddress like '%t%';
		
		//executeProjectionAndRestrict();
		
		DynamicQuery orgDQ=OrganizationLocalServiceUtil.dynamicQuery();
		
		dynamicQuery.setProjection(PropertyFactoryUtil.forName("userId"));
		
		orgDQ.add(PropertyFactoryUtil.forName("userId").in(dynamicQuery));
		
		List<Organization> orgList=OrganizationLocalServiceUtil.dynamicQuery(orgDQ);
		log.info("The Org Resuilt size is L: "+orgList.size());
		for (Organization organization : orgList) {
			log.info("org Name : "+organization.getName());
		}
		
		
		renderRequest.setAttribute("sampleurl", value);
		
		super.render(renderRequest, renderResponse);
	}

	private DynamicQuery getConjuction() {
		//select * from User_ where firstName like '%s%' and emailAddress like '%t%';
		DynamicQuery dynamicQuery = getDynamicQuery();
		//dynamicQuery.add(PropertyFactoryUtil.forName("firstName").like("%s%"));
		
		//dynamicQuery.add(RestrictionsFactoryUtil.like("emailAddress", "%t%"));
	
		//select * from User_ where firstName like '%s%' AND emailAddress like '%t%';
		
	//	Criterion firstNameOrClause=RestrictionsFactoryUtil.eq("firstName", "sudhanshu");
	//	Criterion emailAddressOrClause=RestrictionsFactoryUtil.eq("emailAddress", "test@liferay.com");
		
		Conjunction conjunction=RestrictionsFactoryUtil.conjunction();
		//conjunction.add(firstNameOrClause);
		conjunction.add(PropertyFactoryUtil.forName("emailAddress").like("%t%"));
		log.info("Result For Conjection");
		dynamicQuery.add(conjunction);
		
		
		
		/*
		 * List<User> list=UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		 * 
		 * log.info("iteration the list with size :"+list.size()); for(User user:list) {
		 * log.info("First name : "+user.getFirstName()+" UserId : "+user.getUserId());
		 * }
		 */
		return dynamicQuery;
	}

	private void executeProjectionAndRestrict() {
		DynamicQuery disDynamicQuery = getDynamicQuery();
		Disjunction disJunction=RestrictionsFactoryUtil.disjunction();
//		disJunction.add(firstNameOrClause);
//		disJunction.add(emailAddressOrClause);
		//Projection projection=ProjectionFactoryUtil.rowCount();
		//dynamicQuery.setProjection(projection);
		ProjectionList proList=ProjectionFactoryUtil.projectionList();

		proList.add(ProjectionFactoryUtil.property("emailAddress"));
		proList.add(ProjectionFactoryUtil.property("firstName"));
		Order order=OrderFactoryUtil.desc("modifiedDate");
		
		disDynamicQuery.setProjection(proList);
		disDynamicQuery.addOrder(order);
		
		//ProjectionFactoryUtil.sqlGroupProjection("rank()>1", groupBy, columnAliases, types);
		
		
		log.info("Result For disJunction");
		//disDynamicQuery.add(disJunction);
		List<Object> disList=UserLocalServiceUtil.dynamicQuery(disDynamicQuery);
		
		log.info("iteration the list with size :"+disList.size());
		for(Object user:disList) {
			if(user instanceof User) {
				User user2=(User)user;
				log.info("First name : "+user2.getFirstName()+" UserId : "+user2.getUserId());
			}else{
				log.info("Object type : "+user.getClass().getTypeName());
			}
		}
	}
	
	

	private DynamicQuery getDynamicQuery() {
		DynamicQuery dynamicQuery=UserLocalServiceUtil.dynamicQuery();
		return dynamicQuery;
	}
	
}