import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import { PagPrincipal } from "./pages/homePage/Home";
import { ListarPokemon } from "./pages/teste/pokemons";
import { Carrinho } from "./pages/carrinho/Carrinho";
import { CartProvider } from "./context/CarrinhoContext";
import { Login } from "./pages/Login/Login";
import { Rotas } from "./routes/Routes";
import { Sobre } from "./pages/sobre/sobre";

function App() {
  return (
    <>

      <CartProvider>
        <Rotas />
      </CartProvider>

    </>
  );
}

export default App;
