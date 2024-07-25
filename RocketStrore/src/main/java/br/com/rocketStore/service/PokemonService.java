package br.com.rocketStore.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.rocketStore.DTO.PokemonDTO;
import br.com.rocketStore.DTO.PokemonResponseDTO;
import br.com.rocketStore.DTO.SpritesDTO;
import br.com.rocketStore.DTO.TypesDTO;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Types;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repository;

	public List<PokemonResponseDTO> inserir() throws Exception {
		List<Pokemon> pokemons = new ArrayList<>();
		
		for (int i = 1; i <= 1025; i++) {
			Random random = new Random();
	        Double numero = random.nextDouble(5000)+1;
	        NumberFormat formatter = new DecimalFormat("#0.00");
	        
	        
			URL url = new URL("https://pokeapi.co/api/v2/pokemon-form/" + i + "/");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			Pokemon pokemon1 = new Pokemon();
			String pokemon = "";
			StringBuilder jsonPokemon = new StringBuilder();

			while ((pokemon = br.readLine()) != null) {
				jsonPokemon.append(pokemon);
			}

			PokemonDTO pokemonAux = new Gson().fromJson(jsonPokemon.toString(), PokemonDTO.class);

			pokemon1.setNome(pokemonAux.getName());
			pokemon1.setOrdem(pokemonAux.getId());
			SpritesDTO sprite = new SpritesDTO(pokemonAux.getSprites().getFront_default());

			TypesDTO typesSave1 = new TypesDTO(1, pokemonAux.getTypes().get(0).getType());
			if (pokemonAux.getTypes().size() < 2) {
				Types typeSkill = new Types(typesSave1.getSlot(), 2, typesSave1.getType().getName(), "Nulo");
				Pokemon save = new Pokemon(pokemonAux.getName(), pokemonAux.getId(), typeSkill,sprite.getFront_default());
				String formattedNumber = formatter.format(numero);
				formattedNumber = formattedNumber.replace(",", ".");
				Double num = Double.parseDouble(formattedNumber);
				save.setValorUnitario(num);
				save.setDataCadastro(LocalDateTime.now());
				repository.save(save);
				pokemons.add(save);
			} else {
				TypesDTO typesSave2 = new TypesDTO(2, pokemonAux.getTypes().get(1).getType());
				Types typeSkill = new Types(typesSave1.getSlot(), typesSave2.getSlot(), typesSave1.getType().getName(),
						typesSave2.getType().getName());
				Pokemon save = new Pokemon(pokemonAux.getName(), pokemonAux.getId(), typeSkill,sprite.getFront_default());
				String formattedNumber = formatter.format(numero);
				formattedNumber = formattedNumber.replace(",", ".");
				Double num = Double.parseDouble(formattedNumber);
				save.setValorUnitario(num);
				save.setDataCadastro(LocalDateTime.now());
				repository.save(save);
				pokemons.add(save);
			}
		}
		return pokemons.stream().map(pok -> new PokemonResponseDTO(pok)).collect(Collectors.toList());
	}

	public List<PokemonResponseDTO> listarPokemon() {
		List<Pokemon> pokemon = repository.findAll();
		return pokemon.stream().map((pok) -> new PokemonResponseDTO(pok)).collect(Collectors.toList());
               
	}
	
	
	public Pokemon buscar(Long id) {
		Pokemon pokemon = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pokemon não encontrado!"));
		return pokemon;
	}

	public List<PokemonResponseDTO> listarPagina(Pageable page){
		if(page == null) new ResourceNotFoundException("Recurso não encontrado");
		return repository.findAll(page).stream().map(i-> new PokemonResponseDTO(i)).collect(Collectors.toList());
	}
	
}
