import React from 'react';
import '../CSS/BodyStyle.css';
import Gerencia_Localizacao from './Localizacao/Gerencia_Localizacao';


function Localizacao() {
    return (
        <div className='BoxHome'>
            <div className='bodyconteudo'><Gerencia_Localizacao/></div>
        </div>
    );
}

export default Localizacao;