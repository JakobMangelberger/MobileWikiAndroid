package com.mobilewiki;

/**
 * 
 * @author Irfan Sehic
 *
 * This class serves as the interface between the Class which gets the content
 * and the Class which shows the content
 * 
 * User can select via parameter the way s/he wants the content to be shown and
 * parsed (XML, HTML)
 *
 */
public class ContentHandler {

	private int layout_;
	private String alignment_;
	private String markup_;
	
	public void setContentLayout(int layout){
		layout_ = layout;
	}
	
	public void setContentAlignment(String alignment){
		alignment_ = alignment;
	}
	
	public void setContentMarkup(String markup){
		markup_ = markup;
	}
	
}
