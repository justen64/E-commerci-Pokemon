import React from "react"
import { NavBarPadrao } from "../../components/NavBar/NavBarP"
import Julia from "../../assets/img/Julia.png";
import Amanda from "../../assets/img/Amanda.png";
import Guido from "../../assets/img/Guido.png";
import Jose from "../../assets/img/Jose.png";
import Robert from "../../assets/img/Robert.png";
import Rodrigo from "../../assets/img/Rodrigo.png";
import style from "./style.module.css"


export function Sobre(){
return(
    /**<h1>SOCORRO D:</h1> */
<>
<NavBarPadrao/>
<div>
    <div>
        <img src alt="" />
    </div>
</div>


<div className={style.caixaPg}>
    <h1>Pokdex</h1>
    <h2>Sobre nós</h2>
    <div className={style.caixa1}>
    <img src={Julia} className={style.julia} />
    <img src={Amanda} className={style.amanda} />
    <img src={Guido} className={style.guido} />
    </div>
    <div className={style.caixa2}>
    <img src={Jose} className={style.jose} />
    <img src={Robert} className={style.robert} />
    <img src={Rodrigo} className={style.rodrigo} />
    </div>
</div>
</>
)

}
