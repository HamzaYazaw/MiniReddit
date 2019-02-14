package aspire.tech.web.test.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//This is created for the composite primary key for the many to one relationship 

@Embeddable
public class CommentId implements Serializable{			

	
	private static final long serialVersionUID = -8883535925962968982L;
	@ManyToOne
	private User user;
	@ManyToOne
	private Feature feature;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
	
}
