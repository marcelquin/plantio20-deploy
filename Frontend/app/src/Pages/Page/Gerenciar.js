import '../CSS/reset.css'
import '../CSS/BodyStyle.css'
import { Link } from 'react-router-dom';
import React from 'react';


function Gerenciar() {

  return (
    <div className='boxAdicionarGerenciar'>
      <div className='boxSubMenu'>
        <Link to="/area"><div className='menuArea'>
          <h1>Área</h1>
          </div>
        </Link>
        <Link to="/planta"><div className='menuPlanta'><h1>Planta</h1></div></Link>
      </div>
    </div>  
  );
}

export default Gerenciar; 