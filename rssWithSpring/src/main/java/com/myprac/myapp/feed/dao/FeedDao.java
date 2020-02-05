package com.myprac.myapp.feed.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.myprac.myapp.feed.FeedInfo;

@Repository
public class FeedDao implements IFeedDao {
	
	private JdbcTemplate template;
	

	@Autowired
	public FeedDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int feedInsert(final FeedInfo feedInfo, Number memIdx) {
		int result = 0;
		
		final String sql = "insert into url(id, memIdx, name, rssUrl, summary) values (url_seq.nextval,?,?,?,?)";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, (int) memIdx);
				pstmt.setString(2, feedInfo.getSiteTitle());
				pstmt.setString(3, feedInfo.getRssAddress());
				pstmt.setString(4, feedInfo.getDesc());
			}			
		});
		
		return result;
	}	
	
	@Override
	public List<FeedInfo> feedSelect(Number memIdx) {
		List<FeedInfo> feedInfos = null;
		
		final String sql = "select * from url where memIdx = ? order by id";
		
		
		feedInfos = template.query(sql, new Object[]{memIdx}, new RowMapper<FeedInfo>() {

			@Override
			public FeedInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				FeedInfo feedInfo = new FeedInfo();
				feedInfo.setSiteTitle(rs.getString("name"));
				feedInfo.setRssAddress(rs.getString("rssUrl"));
				feedInfo.setDesc(rs.getString("summary"));
				feedInfo.setId(rs.getInt("id"));
				return feedInfo;
			}
			
		});
		
		if(feedInfos.isEmpty())
			return null;
		
		return feedInfos;
	}
	
	@Override
	public int feedUpdate(FeedInfo feedInfo) {
		int result = 0;
		
		final String sql = "UPDATE url SET name = ?, rssUrl = ?, summary = ? WHERE id = ?";
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, feedInfo.getSiteTitle());
				pstmt.setString(2, feedInfo.getRssAddress());
				pstmt.setString(3, feedInfo.getDesc());
				pstmt.setInt(4, feedInfo.getId());
			}
		});
		return result;
	}
	
	@Override
	public int feedDelete(int urlId) {
		int result = 0;
		final String sql = "delete from url where id = ?";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, urlId);
			}
		});
		
		return result;
	}
}
