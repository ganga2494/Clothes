package rebel.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jobstable",schema="prabhas")
public class Jobs {
	@Id
	@GeneratedValue
	private int jobId;
	private String company;
	private String role;
	private String  skillsRequired;
	private String eligibilityCriteria;
	private String ctc;
	private String dateofInterview;
	private String addressOfTheCompany;
	private String urlOFTheCompany;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getDateofInterview() {
		return dateofInterview;
	}
	public void setDateofInterview(String dateofInterview) {
		this.dateofInterview = dateofInterview;
	}
	public String getAddressOfTheCompany() {
		return addressOfTheCompany;
	}
	public void setAddressOfTheCompany(String addressOfTheCompany) {
		this.addressOfTheCompany = addressOfTheCompany;
	}
	public String getUrlOFTheCompany() {
		return urlOFTheCompany;
	}
	public void setUrlOFTheCompany(String urlOFTheCompany) {
		this.urlOFTheCompany = urlOFTheCompany;
	}
	

}
