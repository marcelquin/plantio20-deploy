import React from 'react';
import '../CSS/BodyStyle.css';
import Gerenciar_AreaPlantio from '../Page/AreaPlantio/Gerencia_AreaPlantio'
import { Link, Links } from 'react-router-dom';


function Area() {
    return (
        <div className='BoxHome'>
            <div className='topMenu'>
                 <Link to="/nova_area"><button type="button" class="btn btn-outline-success">NOVA ÁREA</button></Link>
                 <Link to="/localizacao"><button type="button" class="btn btn-outline-success">LOCALIZAÇÕES</button></Link>
            </div>
            <div className='bodyconteudo'><Gerenciar_AreaPlantio/></div>
        </div>
    );
}

export default Area;