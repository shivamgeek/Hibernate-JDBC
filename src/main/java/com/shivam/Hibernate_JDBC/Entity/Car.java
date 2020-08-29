package com.shivam.Hibernate_JDBC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="brand")
	private String brand;
	
	@OneToOne
	Person carOwner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Person getCarOwner() {
		return carOwner;
	}

	public void setCar_owner(Person carOwner) {
		this.carOwner = carOwner;
	}

	public Car(String brand) {
		super();
		this.brand = brand;
	}
	
	public Car() {

	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + "]";
	}
	
	
}
