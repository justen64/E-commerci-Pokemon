import {Api} from './api'

export const GetAllPokemon = ()=>{
    const url = '/pokemon'
    return Api.get(url);
}
export const GetPokemonPage = ()=>{
    const url = '/pokemon/listar'
    return Api.get(url);
}
export const PostCarrinho= (pedido)=>{
    return Api.post(pedido)
}
