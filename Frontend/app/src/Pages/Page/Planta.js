import React from 'react';
import '../CSS/BodyStyle.css';
import { Link } from 'react-router-dom';
import Gerencia_Planta from './Planta/Gerencia_Planta';

function Planta() {
    return (
        <div className='BoxHome'>
            <div className='topMenu'>
                 <Link to="/nova_planta"><button type="button" class="btn btn-outline-success">NOVA PLANTA</button></Link>
            </div>
            <div className='bodyconteudo'><Gerencia_Planta/></div>
        </div>
    );
}

export default Planta;