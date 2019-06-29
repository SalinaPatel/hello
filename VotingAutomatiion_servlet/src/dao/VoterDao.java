package dao;

import java.util.ArrayList;

import pojos.Voter;

public interface VoterDao {
	Voter validate(String username,String password)throws Exception;
	int register(String name,String email,String password)throws Exception;
	void cleanUp()throws Exception;
	ArrayList<String> vote()throws Exception;
	int insertVote(String cand,String voter)throws Exception;
}
