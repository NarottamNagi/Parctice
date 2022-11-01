package com.example.securityApp.model;

import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_FLAT_DETAIL")
public class FlatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "flat_number")
	private String flatnumber;

	@Column(name = "Flat_Owner_Name")
	public String flatOwnerName;

	@Column(name = "Entry_Date")
	private Date entryDate;

	@Column(name = "Exit_Date")
	private Date exitDate;

	@Column(name = "Ssn ")
	private UUID SSN;

	@Column(nullable = true, name = "photo")
	private String photo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlatnumber() {
		return flatnumber;
	}

	public void setFlatnumber(String flatnumber) {
		this.flatnumber = flatnumber;
	}

	public String getLastName() {
		return flatOwnerName;
	}

	public void setLastName(String flatOwnerName) {
		this.flatOwnerName = flatOwnerName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public UUID getSSN() {
		return SSN;
	}

	public void setSSN(UUID sSN) {
		SSN = sSN;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "FlatEntity [id=" + id + ", flatnumber=" + flatnumber + ", flatOwnerName=" + flatOwnerName
				+ ", entryDate=" + entryDate + ", exitDate=" + exitDate + ", SSN=" + SSN + ", photo=" + photo + "]";
	}

}
