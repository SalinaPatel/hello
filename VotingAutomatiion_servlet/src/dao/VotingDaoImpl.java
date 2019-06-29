package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojos.Voter;
import utils.DBUtils;

public class VotingDaoImpl implements VoterDao{
	Connection con;
	PreparedStatement ps1,ps2,ps3,ps4,ps5;
	
	public VotingDaoImpl() throws Exception{
		Connection con=DBUtils.fetchConnection();
		ps1=con.prepareStatement("select*from voter where email=? and password=?");
		System.out.println("query ready");
		ps2=con.prepareStatement("insert into voter(name,email,password) values(?,?,?)");
		ps3=con.prepareStatement("select name from candidate");
		ps4=con.prepareStatement("update candidate set votes=votes+1 where name=?");
		ps5=con.prepareStatement("update voter set status=1 where name=?");
	}
	
	@Override
	public void cleanUp() throws Exception {
		if(ps1!=null)
			ps1.close();
		if(ps2!=null)
			ps2.close();
		if(con!=null)
			con.close();
		if(ps3!=null)
			ps3.close();
		if(ps4!=null)
			ps4.close();
		if(ps5!=null)
			ps5.close();
	}

	@Override
	public Voter validate(String username,String password)throws Exception {
		System.out.println("values passed to validate");
		//Retrieving the session ref
		ps1.setString(1,username);
		ps1.setString(2, password);
		//System.out.println("values set");
		try(ResultSet rs=ps1.executeQuery()){
		//System.out.println("query executed");
			if(rs.next()) {
				return new Voter(rs.getInt(1),rs.getString(2),username,password,rs.getInt(5));//status has been set to zero for testing
			}
		}
		return null;
	}

	@Override
	public int register(String name,String email,String password) throws Exception{
		ps2.setString(1,name);
		ps2.setString(2,email);
		ps2.setString(3,password);
		int i=ps2.executeUpdate();
		System.out.println("rows affected"+i);
		if(i==1)
			return 1;
		
		else
			return 0;
	}

	@Override
	public ArrayList<String> vote() throws Exception {
		ArrayList<String> al=new ArrayList<>();
		try(ResultSet rs=ps3.executeQuery()){
			while(rs.next()) {
				al.add(rs.getString(1));
			}
			return al;
		}
	}

	@Override
	public int insertVote(String cand,String voter) throws Exception {
		
		ps4.setString(1,cand);
		int i= ps4.executeUpdate();
		ps5.setString(1,voter);
		ps5.executeUpdate();
		return i;
	}



	
	
}
