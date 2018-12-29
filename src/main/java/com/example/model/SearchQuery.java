package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="searchQuery")
public class SearchQuery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	int id;
	@Column(name ="min_bedroom")
	int minBedroom;
	@Column(name ="max_bedroom")
	int maxBedroom;
	@Column(name ="min_bathroom")
	int minBathroom;
	@Column(name ="max_bathroom")
	int maxBathroom;
	@Column(name ="lang")	
	double longitude;
	@Column(name ="lat")
	double latitude;
	@Column(name ="min_budget")
	double minBudget;
	@Column(name ="max_budget")
	double maxBudget;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinBedroom() {
		return minBedroom;
	}

	public void setMinBedroom(int minBedroom) {
		this.minBedroom = minBedroom;
	}

	public int getMaxBedroom() {
		return maxBedroom;
	}

	public void setMaxBedroom(int maxBedroom) {
		this.maxBedroom = maxBedroom;
	}

	public int getMinBathroom() {
		return minBathroom;
	}

	public void setMinBathroom(int minBathroom) {
		this.minBathroom = minBathroom;
	}

	public int getMaxBathroom() {
		return maxBathroom;
	}

	public void setMaxBathroom(int maxBathroom) {
		this.maxBathroom = maxBathroom;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(double minBudget) {
		this.minBudget = minBudget;
	}

	public double getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(double maxBudget) {
		this.maxBudget = maxBudget;
	}

}
