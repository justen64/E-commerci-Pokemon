import React, { useState, useEffect, useContext } from "react";
import { NavBarPadrao } from "../../components/NavBar/NavBarP";
import { Container, Grid, Box } from "@mui/material";
import styles from './styles.module.css';
import PokemonCard from "../../components/pokeCard";
import { GetAllPokemon } from "../../services/produto";
import { cartContext } from "../../context/CarrinhoContext";
import Footer from "../../components/Footer/footer";

export const PagPrincipal = () => {
  const [pokemons, setPokemons] = useState([]);
  const [pokemonsPorPagina, setPokemonsPorPagina] = useState(30);
  const [paginaAtual, setPaginaAtual] = useState(0);
  const { adicionarItem } = useContext(cartContext);
  const pages = Math.ceil(pokemons.length / pokemonsPorPagina);
  const startIndex = paginaAtual * pokemonsPorPagina;
  const endIndex = startIndex + pokemonsPorPagina;
  const pokemonPagina = pokemons.slice(startIndex, endIndex);

  function addCarrinho(item) {
    adicionarItem(item);
    console.log(item);
  }

  function obterPokemons() {
    GetAllPokemon()
      .then((r) => {
        setPokemons(r.data);
      })
      .catch((err) => {
        console.error(err);
      });
  }

  useEffect(() => {
    obterPokemons();
  }, []);

  useEffect(() => {
    setPaginaAtual(0);
  }, [pokemonsPorPagina]);

  const resetarPaginacao = () => {
    setPaginaAtual(0);
  };

  const pokemonFiltro = (name) => {
    if (name === "") {
      obterPokemons();
      resetarPaginacao();
      return;
    }

    const filtroPokemon = pokemons.filter((pokemon) =>
      pokemon.name.toLowerCase().includes(name.toLowerCase())
    );
    setPokemons(filtroPokemon);
    resetarPaginacao();
  };

  return (
    <>
      <div className={styles.body}>
        <NavBarPadrao pokemonFiltro={pokemonFiltro} />
      </div>
      <div>
        <div className={styles.menuQ}>
          <select
            className={styles.selectMenu}
            value={pokemonsPorPagina}
            onChange={(e) => setPokemonsPorPagina(Number(e.target.value))}
          >
            <option value={30}>padrão</option>
            <option value={10}>10</option>
            <option value={20}>20</option>
            <option value={40}>40</option>
            <option value={50}>50</option>
            <option value={60}>60</option>
          </select>
        </div>
        <Container maxWidth="100vw">
          <Grid container spacing={3}>
            {pokemonPagina.map((pokemon) => (
              <Grid item xs={12} sm={6} md={4} lg={3} xl={2} key={pokemon.name}>
                <PokemonCard
                  name={pokemon.name}
                  image={pokemon.imagem}
                  type1={pokemon.tipoPrimario}
                  type2={pokemon.tipoSecundario}
                  valor={pokemon.valorUnitario}
                  click={() => addCarrinho(pokemon)}
                />
              </Grid>
            ))}
          </Grid>
        </Container>
        <Box>
          {Array.from(Array(pages), (pokemons, index) => {
            return (
              <button
                key={index}
                className={`${styles.botaoPaginacao} ${paginaAtual === index ? styles.botaoSelecionado : ""}`}
                value={index}
                onClick={(e) => setPaginaAtual(Number(e.target.value))}
              >
                {index + 1}
              </button>
            );
          })}
        </Box>
        <Footer/>
      </div>
    </>
  );
};
