import axios from 'axios'
export const api = axios.create({
    baseURL: "http://www.localhost:8080/",
  });
export const postCarrinho= (pedido)=>{
   const enviaURL= "pedidos";
    return api.post(enviaURL,pedido);
}
