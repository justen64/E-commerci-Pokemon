import React, { useState, useContext } from "react";
import axios from "axios";
import { logar } from "../../services/clientes";
import { Link, useNavigate } from "react-router-dom";
import { Navigate } from "react-router-dom";
import { Input } from "../../components/INPUT/Input";
import { Botao } from "../../components/BOTAO/Botao";

import style from "./Styles/login.module.css";

export function Login() {
  //variáveis e seus sets para login e senha
  const [login, setLogin] = useState("");
  const [senha, setSenha] = useState("");

  //variáveis e sets para as labels de erro
  const [loginErro, setLoginErro] = useState("");
  const [senhaErro, setSenhaErro] = useState("");
  const [erroGeral, setErroGeral] = useState("");

  const navigate = useNavigate();

  //Ação do Botão Entrar
  const onSubmitClick = async (e) => {
    e.preventDefault();
    setLoginErro("");
    setSenhaErro("");
    setErroGeral("");

    if ("" === login.trim()) {
      setLoginErro("Campo E-mail não preenchido");
      return;
    }

    if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(login)) {
      setLoginErro("Digite um E-mail válido.");
      return;
    }

    if ("" === senha.trim()) {
      setSenhaErro("Campo Senha não preenchido.");
      return;
    }

    if (senha.length !== 0 && senha.length < 4) {
      setSenhaErro("Senha inferior a 4 ou mais caracteres.");
      return;
    }

    // <método de login usando o axios - Obrigatório?>
    try {
      /*  const response = await axios.post(
        "http://127.0.0.1:8080/clientes/login",
        {
          login,
          senha,
        }
      ); */

      const response = await logar(login, senha);

      console.log("Login bem-sucedido", response.data);

      const usuario = response.data;

      localStorage.setItem("dadosUsuario", JSON.stringify(usuario));

      alert(
        "Login efetuado com sucesso. Aproveite suas compras, " +
          usuario.nome +
          "."
      );
      // Redirecionar após login bem-sucedido
      navigate("/");
    } catch (error) {
      console.error("Erro no login:", error);
      if (error.response) {
        const { status, data } = error.response;
        if (status === 401) {
          setErroGeral("Usuário não Autorizado");
        } else if (status === 404) {
          setErroGeral(data.message || "Login ou senha incorretos.");
        } else {
          setErroGeral(data.message || "Erro no login");
        }
      } else {
        setErroGeral(
          "Erro ao se conectar ao servidor. Por favor, tente mais tarde."
        );
      }
    }
    // </método de login usando o axios - Obrigatório?>
  };

  //retorno da tela que será lido pelo ReactJS
  return (
    <>
      <form onSubmit={onSubmitClick} className={style.mainContainer}>
        <div className={style.titleContainer}>
          <div>
            <img
              src="../src/assets/img/logoPokestore.png"
              alt="Logo Pokéstore"
            />
          </div>
        </div>
        <br />
        <div className={style.inputContainer}>
          <Input
            type="text"
            value={login}
            placeholder="Digite seu e-mail"
            onChange={(ev) => setLogin(ev.target.value)}
          ></Input>
          <label className={style.errorLabel}>{loginErro}</label>
        </div>
        <br />
        <div className={style.inputContainer}>
          <Input
            type="password"
            value={senha}
            placeholder="Digite sua senha"
            onChange={(ev) => setSenha(ev.target.value)}
          ></Input>
          <label className={style.errorLabel}>{senhaErro}</label>
          <label className={style.errorLabel}>{erroGeral}</label>
        </div>
        <br />
        <div className={style.inputContainer}>
          <Botao
            type="submit"
            value={"ENTRAR"}
            className={style.inputButton}
          ></Botao>
        </div>
        <Link to="/cadastro">Faça seu cadastro</Link>
      </form>
      <div className={style.botaoVoltar}>
        <Link to="/">
          <img
            src="../src/assets/img/botaoVoltar.png"
            alt="Voltar a página inicial"
          />
        </Link>
      </div>
    </>
  );
}
