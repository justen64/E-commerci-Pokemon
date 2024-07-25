package br.com.rocketStore.DTO;

public class SpritesDTO {
	
	private String front_default;

	
	public SpritesDTO() {
		super();
	}

	public SpritesDTO(String front_default) {
		super();
		this.front_default = front_default;
	}

	public String getFront_default() {
		return front_default;
	}

	public void setFront_default(String front_default) {
		this.front_default = front_default;
	}
	
	
}
