import React, { useState } from "react";
import { Container, TextField, Button, Typography } from "@mui/material";
import { VscEye, VscEyeClosed } from "react-icons/vsc";
import { NavBarPadrao } from "../../components/NavBar/NavBarP";
import Footer from "../../components/Footer/footer";
import { postCliente } from "../../services/clientes";
export function FormPage() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  const [cpf, setCpf] = useState("");
  const [senha, setSenha] = useState("");
  const [confirmarSenha, setConfirmarSenha] = useState("");
  const [Cep, setCep] = useState("");
  const [cadastrado, setCadastrado] = useState(false);
  const [mostrarSenha, setMostrarSenha] = useState(false);

  const handleCadastrar = () => {
   
    if (
      !nome ||
      !telefone ||
      !email ||
      !cpf ||
      !senha ||
      !confirmarSenha ||
      !Cep
    ) {
      alert("Todos os campos são obrigatórios.");
      return;
    }
  
    if (!/\S+@\S+\.\S+/.test(email)) {
      alert("Por favor, insira um email válido.");
      return;
    }
   
    if (!/^\d{10}$/.test(telefone)) {
      alert("Por favor, insira um número de telefone válido com 10 dígitos.");
      return;
    }
   
    if (!/^\d{11}$/.test(cpf)) {
      alert("Por favor, insira um CPF válido com 11 dígitos.");
      return;
    }
   
    if (senha !== confirmarSenha) {
      alert("As senhas não coincidem.");
      return;
    }
  
    console.log("Informações do usuário:");
    console.log("Nome:", nome);
    console.log("Telefone:", telefone);
    console.log("Email:", email);
    console.log("CPF:", cpf);
    console.log("Endereço:", Cep);
    setCadastrado(true);
    saveCliente();
  };

  function saveCliente(){
    const newCliente ={
     nome: nome,
    telefone1: telefone,
    email: email,
    cpf: cpf,
    senha: senha,
    confirmaSenha: confirmarSenha,
    cep: Cep,
    numero: 0

    }
    postCliente(newCliente)
    .then(response=>{
      console.log('enviado'+response.data);
    })
    .catch(error=>{
      console.error('erro '+error);
    })
  }
  const mostrarOuOcultarSenha = () => {
    setMostrarSenha(!mostrarSenha);
  };

  return (
    <>
      <div>
        <NavBarPadrao />
      </div>
      <Container maxWidth="sm" component="article" className="form">
        <h1>Formulário</h1>
        <form
          onSubmit={(event) => {
            event.preventDefault();
          }}
        >
          <TextField
            id="nome"
            label="Nome"
            variant="outlined"
            margin="dense"
            fullWidth
            value={nome}
            onChange={(event) =>
              setNome(event.target.value.replace(/[^a-zA-Z\s]/g, "").trim())
            }
          />
          <TextField
            id="telefone"
            label="Telefone"
            variant="outlined"
            margin="dense"
            fullWidth
            value={telefone}
            onChange={(event) =>
              setTelefone(event.target.value.replace(/\D/g, "").substr(0, 10))
            }
          />
          <TextField
            id="email"
            label="Email"
            type="email"
            variant="outlined"
            margin="dense"
            fullWidth
            value={email}
            onChange={(event) => setEmail(event.target.value.trim())}
          />
          <TextField
            id="cpf"
            label="CPF"
            variant="outlined"
            margin="dense"
            fullWidth
            value={cpf}
            onChange={(event) =>
              setCpf(event.target.value.replace(/\D/g, "").substr(0, 11))
            }
          />
          <TextField
            id="senha"
            label="Senha"
            type={mostrarSenha ? "text" : "password"}
            variant="outlined"
            margin="dense"
            fullWidth
            value={senha}
            onChange={(event) => setSenha(event.target.value)}
            InputProps={{
              endAdornment: (
                <>
                  {mostrarSenha ? (
                    <VscEyeClosed
                      onClick={mostrarOuOcultarSenha}
                      className="iconeOlho"
                    />
                  ) : (
                    <VscEye
                      onClick={mostrarOuOcultarSenha}
                      className="iconeOlho"
                    />
                  )}
                </>
              ),
            }}
          />
          <TextField
            id="confirmarSenha"
            label="Confirmar Senha"
            type={mostrarSenha ? "text" : "password"}
            variant="outlined"
            margin="dense"
            fullWidth
            value={confirmarSenha}
            onChange={(event) => setConfirmarSenha(event.target.value)}
          />
          <TextField
            id="Cep"
            label="Cep"
            variant="outlined"
            margin="dense"
            fullWidth
            value={Cep}
            onChange={(event) => setCep(event.target.value)}
          />
          <Button
            type="button"
            className="btn-form"
            variant="contained"
            color="primary"
            onClick={handleCadastrar}
          >
            Cadastrar
          </Button>
        </form>
        {cadastrado && (
          <Typography variant="h6" color="secondary" className="mensagem-sucesso">
            Usuário cadastrado com sucesso!
          </Typography>
        )}
      </Container>
      <div>
        <Footer />
      </div>
    </>
  );
}

export default FormPage;
