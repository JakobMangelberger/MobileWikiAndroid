package com.mobilewiki.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		query = "Select article_id from mobilewikia.wiki_article";
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
			//db_controller.closeConnectionStatement();
		}

		return article_ids;
	}

	public String getTitleForArticleId(int article_id) {
		String title = "";

		query = "Select title from mobilewikia.wiki_article where article_id = '"
				+ article_id + "'";
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
				System.out
						.println("Error closing ResultSet: getTitleForArticleId("
								+ article_id + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return title;
	}

	public int getArticleIdForTitle(String title) {
		int article_id = 0;

		query = "Select article_id from mobilewikia.wiki_article where title = '"
				+ title + "'";
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
				System.out
						.println("Error closing ResultSet: getArticleIdForTitle("
								+ title + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return article_id;
	}	
	
	public List<Integer> getContentIdsforArticleId(int article_id) {
		List<Integer> content_ids = new ArrayList<Integer>();
		
		query = "Select content_id from mobilewikia.wiki_content where article_id = '"
				+ article_id + "'";
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
				System.out
						.println("Error closing ResultSet: getContentIdsforArticleId("
								+ article_id + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return content_ids;
	}

	public String getDateChangeForContentId(int content_id) {
		String date_change = "";

		query = "Select date_change from mobilewikia.wiki_content where content_id = '"
				+ content_id + "'";
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
				System.out
						.println("Error closing ResultSet: getDateChangeForContentId("
								+ content_id + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return date_change;
	}

	public int getArticleIdForContentId(int content_id) {
		int article_id = -1;

		query = "Select article_id from mobilewikia.wiki_content where content_id = '"
				+ content_id + "'";
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
				System.out
						.println("Error closing ResultSet: getArticleIdForContentId("
								+ content_id + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return article_id;
	}

	public String getContentForContentId(int content_id) {
		String content = "";

		query = "Select content from mobilewikia.wiki_content where content_id = '"
				+ content_id + "'";
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
				System.out
						.println("Error closing ResultSet: getContentForContentId("
								+ content_id + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return content;
	}

	public String getTagForContentId(int content_id) {
		String tag = "";

		query = "Select tag from mobilewikia.wiki_content where content_id = '"
				+ content_id + "'";
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
				System.out
						.println("Error closing ResultSet: getTagForContentId("
								+ content_id + ")");
			}
			//db_controller.closeConnectionStatement();
		}

		return tag;
	}

    public Map<String, List<String>> getAllTitlesWithTags() {
        Map<String, List<String>> result = new HashMap<String, List<String>>();

        query = "SELECT a.article_id, a.title, c.tag, c.date_change FROM mobilewikia.wiki_article a, mobilewikia.wiki_content c WHERE c.article_id = a.article_id";

        try {
            rs = db_controller.getResultSet(query);
            if(null == rs)
                return null;

            while (rs.next()) {
                List<String> tags = new ArrayList<String>();
                for(String tag : rs.getString("c.tag").split(" ")) {
                    tags.add(tag);
                }
                result.put(rs.getString("a.title"), tags);
            }

        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }

        return result;
    }
}
