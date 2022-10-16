package com.tpro.domain;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=25, nullable=false)
	private String firstName;
	@Column(length=25, nullable=false)
	private String lastName;
	@Column(length=25, nullable=false,unique=true)
	private String userName;
	
	@Column(length=255, nullable=false)
	private String password;
	
	@JoinTable(name="tbl_user_role",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	@ManyToMany(fetch=FetchType.EAGER)// az veri olacagi icin cok tablo yok diye EAGER yaptik
	private Set<Role> roles=new HashSet<>();//Set yapmamizin sebebi Unique olmasi
	
	@JsonIgnore
	@OneToOne(mappedBy="user")//her ogrencinin tek user i olsun
	private Student student;
	
	
}