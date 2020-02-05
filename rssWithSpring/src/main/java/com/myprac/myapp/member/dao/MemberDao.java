package com.myprac.myapp.member.dao;

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
import com.myprac.myapp.member.Member;

@Repository
public class MemberDao implements IMemberDao {
	
	private JdbcTemplate template;
	
	@Autowired
	public MemberDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	

	@Override
	public int memberInsert(final Member member) {
		int result = 0;
		final String sql = "insert into member (id, memId, memPw, memMail, memNickname) values (member_seq.nextval,?,?,?,?)";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
				pstmt.setString(3, member.getMemMail());
				pstmt.setString(4, member.getMemNickname());
			}
			
		});
		
		return result;
	}

	@Override
	public Member memberSelect(final Member member) {
		List<Member> members = null;
		
		final String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";
		members = template.query(sql, new Object[]{member.getMemId(), member.getMemPw()}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemNickname(rs.getString("memNickname"));
				mem.setMemIdx(rs.getInt("id"));
				return mem;
			}
			
		});
		
		if(members.isEmpty()) 
			return null;
		
		return members.get(0);
	}

	@Override
	public int memberUpdate(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
