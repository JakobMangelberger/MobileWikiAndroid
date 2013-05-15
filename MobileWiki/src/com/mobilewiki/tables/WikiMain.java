package com.mobilewiki.tables;

public class WikiMain implements IWikiMain {
	
	private int main_id;
	private String wiki_name;
	private String wiki_logo;
	
	public WikiMain()
	{
		this.main_id = -1;
		this.wiki_name = "";
		this.wiki_logo = "";
	}
	
	public WikiMain(int main_id, String wiki_name, String wiki_logo)
	{
		this.main_id = main_id;
		this.wiki_name = wiki_name;
		this.wiki_logo = wiki_logo;
	}

	@Override
	public int getMain_id() {
		return main_id;
	}

	@Override
	public void setMain_id(int main_id) {
		this.main_id = main_id;
	}

	@Override
	public String getWiki_name() {
		return wiki_name;
	}

	@Override
	public void setWiki_name(String wiki_name) {
		this.wiki_name = wiki_name;
	}

	@Override
	public String getWiki_logo() {
		return wiki_logo;
	}

	@Override
	public void setWiki_logo(String wiki_logo) {
		this.wiki_logo = wiki_logo;
	}
	
	
}
