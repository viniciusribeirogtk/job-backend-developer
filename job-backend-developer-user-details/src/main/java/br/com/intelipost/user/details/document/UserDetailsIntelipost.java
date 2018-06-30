package br.com.intelipost.user.details.document;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user-details-intelipost")
public class UserDetailsIntelipost implements Serializable {

	private static final long serialVersionUID = 2251876147849323164L;

	@Id
	private ObjectId id;

	private Long userId;
	private String fullName;
	private String nickName;
	private String address;
	private String city;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserDetailsIntelipost [id=" + id + ", userId=" + userId + ", fullName=" + fullName + ", nickName="
				+ nickName + ", address=" + address + ", city=" + city + "]";
	}

}