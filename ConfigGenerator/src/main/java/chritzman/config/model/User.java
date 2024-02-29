package chritzman.config.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class User {

	@Id
	private String userId;
	
	private String userSession;

	public String getUserIp() {
		return userId;
	}

	public void setUserIp(String userId) {
		this.userId = userId;
	}

	public String getUserSession() {
		return userSession;
	}

	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}
	
	
}
