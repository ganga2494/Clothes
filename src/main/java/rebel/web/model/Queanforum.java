package rebel.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Queanforum")
public class Queanforum {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int questId;
	private String questTitle;
	private String questDescription;
	
	

	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public String getQuestTitle() {
		return questTitle;
	}
	public void setQuestTitle(String questTitle) {
		this.questTitle = questTitle;
	}
	public String getQuestDescription() {
		return questDescription;
	}
	public void setQuestDescription(String questDescription) {
		this.questDescription = questDescription;
	}

}
