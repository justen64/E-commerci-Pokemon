package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Type;

public class TypesDTO {

	private Integer slot;
	
	private Type type;

	
	
	public TypesDTO() {
		super();
	}

	public TypesDTO(Integer slot, Type type) {
		super();
		this.slot = slot;
		this.type = type;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
