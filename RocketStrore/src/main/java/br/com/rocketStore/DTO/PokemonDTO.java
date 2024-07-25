package br.com.rocketStore.DTO;

import java.util.List;

public class PokemonDTO {

private String name;
	
	private Long id;
	
	private List<TypesDTO> types;
	private SpritesDTO sprites;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TypesDTO> getTypes() {
		return types;
	}

	public void setTypes(List<TypesDTO> types) {
		this.types = types;
	}

	public SpritesDTO getSprites() {
		return sprites;
	}

	public void setSprites(SpritesDTO sprites) {
		this.sprites = sprites;
	}

	
	
	
	
}
