import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import styles from './styles.module.css';

export default function PokemonCard({name, image, type1, type2, valor ,click}) { 
  const tipo = () => {
    const resposta = type2 !== "Nulo" ? type2 : "";
    return type1 + (resposta ? ` / ${resposta}` : "");
  };
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="200"
          image={image}
          alt="pokemon"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            { name }
          </Typography>
          <Typography variant="body2" color="text.secondary">
          Type: {tipo()}
          <br />
          Valor: R$ {valor}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button sx={{backgroundColor: '#D3D3D3'}} onClick={click}>
          Adicionar ao carrinho
        </Button>
      </CardActions>
    </Card>
  );
}
