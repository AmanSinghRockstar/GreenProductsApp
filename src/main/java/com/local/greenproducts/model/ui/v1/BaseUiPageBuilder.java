package com.local.greenproducts.model.ui.v1;

import com.local.greenproducts.model.product.v1.Product;

public class BaseUiPageBuilder {
	
	private StringBuilder htmlContent;
	private HtmlSection lastOpenHtmlSection = HtmlSection.NONE;

	public BaseUiPageBuilder() {
		htmlContent = new StringBuilder();
		htmlContent.append("<HTML>").append("\n");
	}
	
	public BaseUiPageBuilder withHead() {
		htmlContent.append("<HEAD>").append("\n");
		lastOpenHtmlSection = HtmlSection.HEAD;
		return this;
	}
	
	public BaseUiPageBuilder withStyle(Style style) {
		htmlContent.append("<STYLE>").append("\n").append(style.toString()).append("</STYLE>").append("\n");
		return this;
	}
	
	public BaseUiPageBuilder withScript(String content, boolean isExternal) {
		if (isExternal)
			htmlContent.append("<SCRIPT src=\"").append(content).append("\">").append("\n");
		else
			htmlContent.append("<SCRIPT>").append("\n").append(content);
		htmlContent.append("</SCRIPT>").append("\n");
		return this;
	}
	
	public BaseUiPageBuilder withBody() {
		switch (lastOpenHtmlSection) {
			case HEAD: htmlContent.append("</HEAD>").append("\n");
				htmlContent.append("<BODY>").append("\n");
				break;
			case BODY: break;
			case NONE:
				htmlContent.append("<BODY>").append("\n");
				break;
		}
		lastOpenHtmlSection = HtmlSection.BODY;
		return this;
	}
	
	public BaseUiPageBuilder withHeading(String heading) {
		htmlContent.append("<H1>").append(heading).append("</H1>").append("\n");
		return this;
	}
	
	public BaseUiPageBuilder withSubHeading(String subHeading) {
		htmlContent.append("<H3>").append(subHeading).append("</H3>").append("\n");
		return this;
	}
	
	public BaseUiPageBuilder withProductsMenu(Iterable<Product> listOfProducts) {
		htmlContent.append("<TABLE class='productMenu'>").append("\n")
			.append("<TR>").append("\n");
		
		htmlContent.append(getTableHeaderHtml(getAHrefLinkHtml("/index", "Home")));

		for (Product product : listOfProducts) {
			htmlContent.append(getTableHeaderHtml(getAHrefLinkHtml("/product/" + product.getId(), product.getName())));
		}
		
		htmlContent.append(getTableHeaderHtml(getAHrefLinkHtml("/orders", "Orders")));
		
		htmlContent.append("</TR>").append("\n")
			.append("</TABLE>").append("\n");
		
		return this;
	}
	
	public BaseUiPageBuilder withContentHeading(String contentHeading) {
		htmlContent.append("<H2>").append(contentHeading).append("</H2>").append("\n");
		return this;
	}
	
	public BaseUiPageBuilder withContentPageSection(String content) {
		htmlContent.append("<DIV class=\"pageSection\">").append(content).append("</DIV>").append("\n");
		return this;
	}
	
	public BaseUiPageBuilder withContentPageSection(String content, String heading) {
		htmlContent.append("<DIV class=\"pageSection\">")
			.append("<H3>").append(heading).append("</H3>")
			.append(content)
			.append("</DIV>").append("\n");
		return this;
	}
	
	public BaseUiPage build() {
		switch (lastOpenHtmlSection) {
			case HEAD: htmlContent.append("</HEAD>").append("\n");
				break;
			case BODY: htmlContent.append("</BODY>").append("\n");
				break;
			case NONE:
				break;
		}
		
		htmlContent.append("</HTML>").append("\n");
		BaseUiPage page = new BaseUiPage();
		page.setContent(htmlContent.toString());
		return page;
	}
	
	private String getAHrefLinkHtml(String link, String tagContent) {
		StringBuilder content = new StringBuilder();
		content.append("<A href='" + link + "'>")
			.append(tagContent)
			.append("</A>");
		
		return content.toString();
	}
	
	private String getTableHeaderHtml(String headerContent) {
		StringBuilder content = new StringBuilder();
		content.append("<TH>")
			.append(headerContent)
			.append("</TH>").append("\n");
		
		return content.toString();
	}
}
