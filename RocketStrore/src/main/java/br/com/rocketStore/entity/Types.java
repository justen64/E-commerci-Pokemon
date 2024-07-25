package br.com.rocketStore.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;


@Embeddable
public class Types {


	
	
	private Integer slot1;
	
	
	private Integer slot2;
	
	private String name1;
	
	private String name2;
	
	public Types() {
		super();
	}
	
	public Types(Integer slot1, Integer slot2, String name1, String name2) {
		super();
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.name1 = name1;
		this.name2 = name2;
	}
	public Integer getSlot1() {
		return slot1;
	}

	public void setSlot1(Integer slot1) {
		this.slot1 = slot1;
	}

	public Integer getSlot2() {
		return slot2;
	}

	public void setSlot2(Integer slot2) {
		this.slot2 = slot2;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	
	
}
