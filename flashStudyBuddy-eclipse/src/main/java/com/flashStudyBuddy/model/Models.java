package com.flashStudyBuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table
public class Models {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String definition;
	
	public Models() {}
	
	public Models(long id,String name,String definition) {
		super();
		this.id=id;
		this.name=name;
		this .definition=definition;
	}
	
	public Models(String name,String definition) {
		super();
		this.name=name;
		this.definition=definition;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public void setDefinition(String definition) {
		this.definition=definition;
	}
	
	@Override
	public String toString() {
		return("Card displayed-> \nPrimary key: "+id+",Name: "+name
				+", Definition: "+definition);
	}
}
