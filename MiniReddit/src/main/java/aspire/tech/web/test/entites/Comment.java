package aspire.tech.web.test.entites;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Comment {

	@EmbeddedId
	private CommentId priK;		//Embedded because having composite primary keys
	
	@Column(length=5000)		//LENGTH of characters for the comment 
	private String text;
	
	public CommentId getPriK() {
		return priK;
	}
	public void setPriK(CommentId priK) {
		this.priK = priK;
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
