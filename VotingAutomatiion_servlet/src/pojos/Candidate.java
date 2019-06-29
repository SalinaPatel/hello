package pojos;

public class Candidate {
	private int cid;
	private String name;
	private String party;
	private int votes;
	public Candidate(int cid, String name, String party, int votes) {
		super();
		this.cid = cid;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
	
}
