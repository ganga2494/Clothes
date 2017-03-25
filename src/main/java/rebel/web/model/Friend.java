package rebel.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private UserDetails user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="friendId")
	private UserDetails friend;
	private String status;
	private boolean isOnline;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public UserDetails getFriend() {
		return friend;
	}
	public void setFriend(UserDetails friend) {
		this.friend = friend;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	

}
