package com.mobilewiki.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobilewiki.db.DatabaseController;

public class MobileWiki {
	private DatabaseController db_controller = new DatabaseController();
	private String query = "";
	private ResultSet rs = null;
	
	public String respondMessage(String message) {
		return "Received message: " + message;
	}
	
    public List<Integer> getArticleIds() {
    	List<Integer> article_ids = new ArrayList<Integer>();
    	
    	query = "Select article_id from wiki_article";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null) {
	        	while (rs.next()) {
	        		article_ids.add(rs.getInt("article_id"));
	        	}
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getArticleIds()");
			}
			db_controller.closeConnectionStatement();
		}

        return article_ids;
    }

    public String getTitleForArticleId(int article_id) {
    	String title = "";
    	
    	query = "Select title from wiki_article where article_id = '" + article_id + "'";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null && rs.next()) {
	        	title = rs.getString("title");
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getTitleForArticleId(" + article_id + ")");
			}
			db_controller.closeConnectionStatement();
		}

        return title;
    }

    public List<Integer> getContentIdsforArticleId(int article_id) {
    	List<Integer> content_ids = new ArrayList<Integer>();
    	
    	query = "Select content_id from wiki_content where article_id = '" + article_id + "'";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null) {
	        	while (rs.next()) {
	        		content_ids.add(rs.getInt("content_id"));
	        	}
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getContentIdsforArticleId(" + article_id + ")");
			}
			db_controller.closeConnectionStatement();
		}

        return content_ids;
    }

    public String getDateChangeForContentId(int content_id) {       
    	String date_change = "";
    	
    	query = "Select date_change from wiki_content where content_id = '" + content_id + "'";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null && rs.next()) {
	        	date_change = rs.getString("date_change");
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getDateChangeForContentId(" + content_id + ")");
			}
			db_controller.closeConnectionStatement();
		}

        return date_change;
    }

    public int getArticleIdForContentId(int content_id) {
    	int article_id = -1;
    	
    	query = "Select article_id from wiki_content where content_id = '" + content_id + "'";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null && rs.next()) {
	        	article_id = rs.getInt("article_id");
	        	
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getArticleIdForContentId(" + content_id + ")");
			}
			db_controller.closeConnectionStatement();
		}

        return article_id;
    }

    public String getContentForContentId(int content_id) {
    	String content = "";
    	
    	query = "Select content from wiki_content where content_id = '" + content_id + "'";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null && rs.next()) {
	        	content = rs.getString("content");
	        	
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getContentForContentId(" + content_id + ")");
			}
			db_controller.closeConnectionStatement();
		}

        return content;
    }

    public String getTagForContentId(int content_id) {
        String tag = "";

    	query = "Select tag from wiki_content where content_id = '" + content_id + "'";
        try {
			rs = db_controller.getResultSet(query);
			
	        if (rs != null && rs.next()) {
	        	tag = rs.getString("content");
	        	
	        }
		
        } catch (SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error executing the Query: " + query);
		
        } finally {
			try {
				if (rs != null) {
					rs.close();
				}
			
			} catch (SQLException e) {
				System.err.println(e.toString());
				System.out.println("Error closing ResultSet: getTagForContentId(" + content_id + ")");
			}
			db_controller.closeConnectionStatement();
		}

        return tag;
    }
}