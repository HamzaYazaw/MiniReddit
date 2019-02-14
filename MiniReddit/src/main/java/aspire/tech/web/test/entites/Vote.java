package aspire.tech.web.test.entites;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity

public class Vote {

	
	@EmbeddedId
	private VoteId priK;
	
	private Boolean upvote;
	
	
	public Boolean getUpvote() {
		return upvote;
	}

	public void setUpvote(Boolean upvote) {
		this.upvote = upvote;
	}

	public VoteId getPriK() {
		return priK;
	}

	public void setPriK(VoteId priK) {
		this.priK = priK;
	}
	
	
	
}
