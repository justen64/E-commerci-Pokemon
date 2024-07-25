import React from "react";
import styles from './styles.module.css';
export function FormaPagamento({valor}){
    
    const avista = ".Por apenas R$"+(valor*0.9).toFixed(2)+".";
 
   
    
    const parcelado=" R$"+(valor*1.20).toFixed(2)+ " em 12 vezes de  R$"+((valor*1.20)/12).toFixed(2)+".";  
 

    return (
        <>
        <div className={styles.container}>
        <div className={styles.titulo}>
        <h2>Formas de Pagamento</h2>
        </div>
        <div className={styles.FormaPagamento}>
        
      <br />
      <input type="radio" id="a-vista" className="a-vista" name="opcao" value="a-vista" />
      <label htmlFor="a-vista" id="aVista">
      <s> R${(valor).toFixed(2)}</s> {avista}
        </label>
      <br />
      <br />
      <input type="radio" id="a-prazo" className="a-prazo" name="opcao" value="a-prazo" />
      <label htmlFor="a-prazo" id="aPrazo">{parcelado} </label>
      <br />
        </div>
        </div>
       
        </>
    )
}