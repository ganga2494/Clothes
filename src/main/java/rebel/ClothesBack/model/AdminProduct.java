package rebel.ClothesBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class AdminProduct 
{
	
	@Id
	private int aproductId;
	@Column
	private String aprodName;
	@Column
	private String adesciption;
	@Column
	private int astock;
	@Column
	private int aprice;
	@Column
	private String asupplierId;
	@Column
	private String acategoryId;
	@Transient
	private MultipartFile pimage;
	
	

	public int getAproductId() {
		return aproductId;
	}

	public void setAproductId(int aproductId) {
		this.aproductId = aproductId;
	}

	public String getAprodName() {
		return aprodName;
	}

	public void setAprodName(String aprodName) {
		this.aprodName = aprodName;
	}

	public String getAdesciption() {
		return adesciption;
	}

	public void setAdesciption(String adesciption) {
		this.adesciption = adesciption;
	}

	public int getAstock() {
		return astock;
	}

	public void setAstock(int astock) {
		this.astock = astock;
	}

	public int getAprice() {
		return aprice;
	}

	public void setAprice(int aprice) {
		this.aprice = aprice;
	}

	public String getAsupplierId() {
		return asupplierId;
	}

	public void setAsupplierId(String asupplierId) {
		this.asupplierId = asupplierId;
	}

	public String getAcategoryId() {
		return acategoryId;
	}

	public void setAcategoryId(String acategoryId) {
		this.acategoryId = acategoryId;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}


}
