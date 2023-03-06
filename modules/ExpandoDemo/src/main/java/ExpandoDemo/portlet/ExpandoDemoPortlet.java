package ExpandoDemo.portlet;

import ExpandoDemo.constants.ExpandoDemoPortletKeys;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoRow;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoRowLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ExpandoDemo", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + ExpandoDemoPortletKeys.EXPANDODEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ExpandoDemoPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(BlogsEntry.class.getName());

		ExpandoTable expandoTable= ExpandoTableLocalServiceUtil.fetchDefaultTable(themeDisplay.getCompanyId(), classNameId);
		
		System.out.println("Table id "+expandoTable.getClassName()+" "+expandoTable.getTableId());
		
		List<ExpandoColumn> columns =ExpandoColumnLocalServiceUtil.getColumns(expandoTable.getTableId());
		
		for (ExpandoColumn expandoColumn : columns) {
			System.out.println("Expando Column name is : "+expandoColumn.getName()+" with id "+expandoColumn.getColumnId());
			List<ExpandoRow> expandoRows=ExpandoRowLocalServiceUtil.getRows(expandoColumn.getTableId(), -1, -1);
			for (ExpandoRow expandoRow : expandoRows) {
				ExpandoValue expandoValue=ExpandoValueLocalServiceUtil.getValue(expandoTable.getTableId(), expandoColumn.getColumnId(), expandoRow.getClassPK());
				System.out.println("Expando Value is : "+expandoValue.getData());
			}
			
		}
		
			/*
			 * ExpandoColumn expandoColumn =
			 * ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(),
			 * "librariyanName", ExpandoColumnConstants.STRING); ExpandoRow expandoRow =
			 * ExpandoRowLocalServiceUtil.addRow(expandoTable.getTableId(),
			 * expandoTable.getClassNameId()); ExpandoValue expandoValColumn =
			 * ExpandoValueLocalServiceUtil.addValue(classNameId, expandoTable.getTableId(),
			 * expandoColumn.getColumnId(), expandoRow.getClassPK(), "Sudhanshu");
			 */
																					
		}catch (Exception e) {
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}

}