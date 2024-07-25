import { createContext, useState, useEffect } from "react";
import { postCarrinho } from "../services/carrinho";

const cartContext = createContext();

const CartProvider = (props) => {
  const [carrinho, setCarrinho] = useState([]);
  const [valorTotal, setValorTotal] = useState(0);

  useEffect(() => {
    const savedCarrinho = JSON.parse(localStorage.getItem("carrinho")) || [];
    setCarrinho(savedCarrinho);
  }, []);
  useEffect(() => {
    valorTotalCarrinho(carrinho);
  }, [carrinho]);

  function valorTotalCarrinho() {
    let total = 0;
    carrinho.forEach((item) => {
      total += item.quantidade * item.valorUnitario;
    });
    setValorTotal(total);
  }

  function adicionarItem(item) {
    const itemadd = {
      index: carrinho.length + 1,
      ...item,
      quantidade: 1,
    };

    const itens = [...carrinho];
    adicionando();
    function adicionando() {
      if (itens.length < 1) {
        itens.push(itemadd);
      } else {
        for (let i = 0; i < itens.length; i++) {
          if (itens[i].name.toLowerCase() === itemadd.name.toLowerCase()) {
            itens[i].quantidade += 1;
            return;
          }
        }
        itens.push(itemadd);
      }
    }

    setCarrinho(itens);
    localStorage.setItem("carrinho", JSON.stringify(itens));  
    alert("item Adicionado ao carrinho");
  }
  function alterarQuantidade(quantidade, item) {
    const itens = [...carrinho];
    for (let i = 0; i < itens.length; i++) {
      if (itens[i].name.toLowerCase() === item.name.toLowerCase()) {
        itens[i].quantidade = quantidade;
      }
    }
    setCarrinho(itens);
    localStorage.setItem("carrinho", JSON.stringify(itens));
  }
  function removeritem(item) {
    const itens = [...carrinho];
    for (let i = 0; i < itens.length; i++) {
      if (itens[i].name.toLowerCase() === item.name.toLowerCase()) {
        itens.splice(i, 1);
      }
    }
    setCarrinho(itens);
    localStorage.setItem("carrinho", JSON.stringify(itens));
  }
  function saveCarrinho() {
   const cliente = JSON.parse(localStorage.getItem("dadosUsuario"));
    const itens = [...carrinho];
    const produtos = itens.map(item => ({
      idPokemon: item.pokeDex,
      quantidade: item.quantidade,
    }));
    const pedido ={
      dataPedido: "2024-06-10",
      status: "ENVIADO",
      idCliente: cliente.id,
      produtos,
    }
    postCarrinho(pedido)
      .then(response => {
        console.log('Pedido enviado com sucesso:', response.data);
      })
      .catch(error => {
        console.error('Erro ao enviar o pedido:', error);
      });
      alert("Compra finalizada!");
      limparCarrinho();
      addEventListener(location.reload());
  }

  function limparCarrinho() {
    localStorage.setItem("carrinho", JSON.stringify([]));
  }
  return (
    <cartContext.Provider
      value={{
        carrinho,
        adicionarItem,
        removeritem,
        limparCarrinho,
        valorTotalCarrinho,
        valorTotal,
        alterarQuantidade,
        saveCarrinho,
      }}
    >
      {props.children}
    </cartContext.Provider>
  );
};
export { cartContext, CartProvider };
