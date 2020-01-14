
package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Guideregister")
public class Guide
{
	private String first_name;
	private String last_name;
	private String contact_number;
	private String address_proof;
	private String gmail;
	private String gender;
	@Id
	private String user_id;
	private String password;
	public Guide()
	{	
	}
	
	public Guide(String firstName, String lastName, String contact_number, String addressProof, String gmail,
			String gender,String userId,String password) {
		super();
		this.first_name = firstName;
		this.last_name = lastName;
		this.contact_number = contact_number;
		this.address_proof = addressProof;
		this.gmail = gmail;
		this.gender = gender;
		this.user_id=userId;
		this.password=password;
	}
	public String getUserId() {
		return user_id;
	}

	public void setUserId(String userId) {
		this.user_id = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	public String getcontact_number() {
		return contact_number;
	}
	public void setcontact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getAddressProof() {
		return address_proof;
	}
	public void setAddressProof(String addressProof) {
		this.address_proof = addressProof;
	}
	public String getgmail() {
		return gmail;
	}
	public void setgmail(String gmail) {
		this.gmail = gmail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Guide [firstName=" + first_name + ", lastName=" + last_name + ", contact_number=" + contact_number
				+ ", addressProof=" + address_proof + ", gmail=" + gmail + ", gender=" + gender + ", userId=" + user_id
				+ ", password=" + password + "]";
	}

	
}