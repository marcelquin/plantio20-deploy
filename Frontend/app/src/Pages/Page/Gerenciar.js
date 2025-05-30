import '../CSS/reset.css'
import '../CSS/BodyStyle.css'
import React, { useState, useEffect } from 'react';
import Gerencia_AreaPlantio from './AreaPlantio/Gerencia_AreaPlantio';
import Gerencia_Planta from './Planta/Gerencia_Planta';
import Cad_AreaPlantio from './AreaPlantio/Cad_AreaPlantio';
import Cad_Planta from './Planta/Cad_Planta';
import Gerencia_Localizacao from './Localizacao/Gerencia_Localizacao';
import { Link } from 'react-router-dom';

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