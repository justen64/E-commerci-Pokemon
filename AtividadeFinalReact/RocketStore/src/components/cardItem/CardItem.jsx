import styles from './style.module.css';
import { useState,useContext } from 'react';
import { cartContext } from "../../context/CarrinhoContext";


export function CardItem({imagem,nome,tipo1,tipo2,quantidadeInicial,input,valor,item,click}){
    const [quantidade, setQuantidade] = useState(quantidadeInicial);
    const {alterarQuantidade} = useContext(cartContext);
    const handleInputChange = (e) => {
        const novaQuantidade = e.target.value;
        setQuantidade(novaQuantidade);
        alterarQuantidade(novaQuantidade, item);
    };

    const tipo = () => {
        const resposta = tipo2 !== "Nulo" ? tipo2 : "";
        return tipo1 + (resposta ?  `/ ${resposta}` : "");
    };
   
    const getBackgroundClass = (tipo1) => {
        switch (tipo1.toLowerCase()) {
          case 'bug':
            return styles['card-bug'];
          case 'dark':
            return styles['card-dark'];
          case 'dragon':
            return styles['card-dragon'];
          case 'electric':
            return styles['card-electric'];
          case 'fairy':
            return styles['card-fairy'];
          case 'fighting':
            return styles['card-fighting'];
          case 'fire':
            return styles['card-fire'];
          case 'flying':
            return styles['card-flying'];
          case 'ghost':
            return styles['card-ghost'];
          case 'grass':
            return styles['card-grass'];
          case 'ground':
            return styles['card-ground'];
          case 'ice':
            return styles['card-ice'];
          case 'normal':
            return styles['card-normal'];
          case 'poison':
            return styles['card-poison'];
          case 'psychic':
            return styles['card-psychic'];
          case 'rock':
            return styles['card-rock'];
          case 'steel':
            return styles['card-steel'];
          case 'water':
            return styles['card-water'];
          default:
            return '';
        }
      };

        const background = getBackgroundClass(tipo1);
 
    return(
        <>
        <div className={`${styles.card} ${background}`}>
        <div className={styles.divImg}>
        <img src={imagem} alt={nome}className={styles.img}/>
        </div>
        <div className={styles.infos}>

        <p><strong> Nome: {nome}</strong></p>
        <p><strong>Type: {tipo()}</strong></p>
        <p><strong>Valor: R${valor}</strong></p>
        <input type={input} value={quantidade} className={styles.input} onChange={handleInputChange}/>

        </div>
        <button className={styles.botaoRemove} onClick={click}>remover</button>
        </div>
        </>
    )
}