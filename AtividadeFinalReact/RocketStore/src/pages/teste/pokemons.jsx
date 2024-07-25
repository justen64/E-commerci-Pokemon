import { useEffect, useState } from "react";
import { GetPokemonPage } from "../../services/produto";

export function ListarPokemon(){
    const [pokemons, setPokemons]= useState([]);

    function obterPokemons() {
        GetPokemonPage()
            .then((r) => {
                setPokemons(r.data);
                if(localStorage.getItem("carrinho")== null){
                    localStorage.setItem("carrinho", JSON.stringify(r.data));
                    console.log(localStorage.getItem("carrinho"));
                }
            })
            .catch((err) => {
                console.error('Erro ao obter pokemons:', err);
            });
    }

    useEffect(()=>{
        obterPokemons();
     },[]);
     return(
        <>
        <h1>Lista de Pokemons</h1>
        </>
     )
}