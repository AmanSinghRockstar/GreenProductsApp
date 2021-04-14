package com.local.greenproducts.model.ui.v1;

public class BaseUiPage {

	private String content;
	
	public static BaseUiPageBuilder builder() {
		return new BaseUiPageBuilder();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public static Style getDefaultStyle() {
		Style baseUiPageDefaultStyle = new Style();
		
		// Body style
		baseUiPageDefaultStyle.addProperty("body", "background-color", "#ddffbc");
		baseUiPageDefaultStyle.addProperty("body", "margin", "0px");
		baseUiPageDefaultStyle.addProperty("body", "padding", "0px");
		
		// Title bar style
		baseUiPageDefaultStyle.addProperty("h1", "display", "block");
		baseUiPageDefaultStyle.addProperty("h1", "background-color", "#52734d");
		baseUiPageDefaultStyle.addProperty("h1", "color", "#feffde");
		baseUiPageDefaultStyle.addProperty("h1", "padding", "10px");
		baseUiPageDefaultStyle.addProperty("h1", "font-face", "Calibri");
		baseUiPageDefaultStyle.addProperty("h1", "font-size", "50");
		baseUiPageDefaultStyle.addProperty("h1", "margin", "0px");
		
		// Sub-heading style
		baseUiPageDefaultStyle.addProperty("h3", "display", "block");
		baseUiPageDefaultStyle.addProperty("h3", "background-color", "#ddffbc");
		baseUiPageDefaultStyle.addProperty("h3", "color", "#52734d");
		baseUiPageDefaultStyle.addProperty("h3", "padding", "10px");
		baseUiPageDefaultStyle.addProperty("h3", "font-face", "Calibri");
		baseUiPageDefaultStyle.addProperty("h3", "font-size", "15");
		baseUiPageDefaultStyle.addProperty("h3", "margin", "0px");
		
		// Content heading style
		baseUiPageDefaultStyle.addProperty("h2", "display", "block");
		baseUiPageDefaultStyle.addProperty("h2", "background-color", "#feffde");
		baseUiPageDefaultStyle.addProperty("h2", "color", "#52734d");
		baseUiPageDefaultStyle.addProperty("h2", "padding", "10px");
		baseUiPageDefaultStyle.addProperty("h2", "font-face", "Calibri");
		baseUiPageDefaultStyle.addProperty("h2", "font-size", "40");
		baseUiPageDefaultStyle.addProperty("h2", "margin", "0px");
		baseUiPageDefaultStyle.addProperty("h2", "border-style", "solid none none none");
		baseUiPageDefaultStyle.addProperty("h2", "border-width", "10px 0px 0px 0px");
		
		// Menu links
		baseUiPageDefaultStyle.addProperty("a", "display", "block");
		baseUiPageDefaultStyle.addProperty("a", "background-color", "#91c788");
		baseUiPageDefaultStyle.addProperty("a", "color", "#ddffbc");
		baseUiPageDefaultStyle.addProperty("a", "padding", "20px");
		baseUiPageDefaultStyle.addProperty("a", "font-face", "Calibri");
		baseUiPageDefaultStyle.addProperty("a", "font-size", "larger");
		baseUiPageDefaultStyle.addProperty("a", "margin", "0px");
		baseUiPageDefaultStyle.addProperty("a", "border", "0px solid black");
		baseUiPageDefaultStyle.addProperty("a", "text-decoration", "none");
		
		// Menu links on hover
		baseUiPageDefaultStyle.addProperty("a:hover", "background-color", "#ddffbc");
		baseUiPageDefaultStyle.addProperty("a:hover", "color", "#52734d");
		
		// Table, tbody and tr
		baseUiPageDefaultStyle.addProperty("table.productMenu, table.productMenu tbody, table.productMenu tr", "display", "block");
		baseUiPageDefaultStyle.addProperty("table.productMenu, table.productMenu tbody, table.productMenu tr", "padding", "0px");
		baseUiPageDefaultStyle.addProperty("table.productMenu, table.productMenu tbody, table.productMenu tr", "margin", "0px");
		baseUiPageDefaultStyle.addProperty("table.productMenu, table.productMenu tbody, table.productMenu tr", "border", "0px solid black");
		baseUiPageDefaultStyle.addProperty("table.productMenu, table.productMenu tbody, table.productMenu tr", "background-color", "#91c788");
		
		// Table headers
		baseUiPageDefaultStyle.addProperty("table.productMenu th", "display", "inline-block");
		baseUiPageDefaultStyle.addProperty("table.productMenu th", "padding", "0px");
		baseUiPageDefaultStyle.addProperty("table.productMenu th", "margin", "0px");
		baseUiPageDefaultStyle.addProperty("table.productMenu th", "border", "0px solid black");
		baseUiPageDefaultStyle.addProperty("table.productMenu th", "vertical-align", "bottom");
		
		// Paragraph
		baseUiPageDefaultStyle.addProperty("div.pageSection", "display", "inline-block");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "padding", "10px");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "margin", "10px 0px 0px 10px");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "font-face", "Calibri");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "font-size", "20");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "color", "#52734d");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "border", "5px solid #91c788");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "background-color", "#feffde");
		baseUiPageDefaultStyle.addProperty("div.pageSection", "border-radius", "15px");
		
		return baseUiPageDefaultStyle;
	}
}
