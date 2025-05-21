import '../../CSS/BodyStyle.css'
import React, { useState, useEffect } from 'react';
import GerenciaPlantaTodos from './GerenciarPlantaTodos'
import GenreicaPlantaGerminacao from './GerenciarPlantaGerminacao'
import GerenciaPlantaMuda from './GerenciarPlantaMuda'
import GerenciaPlantaCrescimento from './GerenciarPlantaCrescimento'
import GerneciaPlantaFloracao from './GerenciarPlantaFloracao'
import GerenciaPlantaFrutiricacao from './GerenciarPlantaFrutificacao'
import GerenciaPlantaMaturacao from './GerenciarPlantaMaturacao'
import GerenciaPlantaFimCiclo from './GerenciarPlantaFimCiclo'
import GerenciarPlantaGerminacao from './GerenciarPlantaGerminacao';
import GerenciarPlantaCrescimento from './GerenciarPlantaCrescimento';
import GerenciarPlantaFloracao from './GerenciarPlantaFloracao';
import GerenciarPlantaMaturacao from './GerenciarPlantaMaturacao';

function Gerencia_Planta() {


  const [opcao, setopcao] = useState("Todos")




  const handleChange = (e) => {
    setopcao(e.target.value);
  }

  return (
    <>

<div className='BoxHome'>
        <div className='boxopcao'>
          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioTodos" 
              value="Todos"
              checked={opcao === "Todos"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioTodos">
              Todos
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioGerminacao" 
              value="Germinação"
              checked={opcao === "Germinação"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioGerminacao">
              Germinação
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioMuda" 
              value="Muda"
              checked={opcao === "Muda"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioMuda">
              Muda
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioCrescimento" 
              value="Crescimento"
              checked={opcao === "Crescimento"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioCrescimento">
              Crescimento
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioFloracao" 
              value="Floração"
              checked={opcao === "Floração"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioFloracao">
              Floração
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioFrutificacao" 
              value="Frutificação"
              checked={opcao === "Frutificação"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioFrutificacao">
              Frutificaçao
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioMaturacao" 
              value="Maturação"
              checked={opcao === "Maturação"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioMaturacao">
              Maturação
            </label>
          </div>

          <div className="form-check">
            <input 
              className="form-check-input" 
              type="radio" 
              name="opcao" 
              id="radioFim" 
              value="Fim"
              checked={opcao === "Fim"}
              onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="radioFim">
              Fim
            </label>
          </div>
        </div>
        <br/>
        <br/>
        <div className='boxTable'>

        {opcao === "Todos" ? (<><GerenciaPlantaTodos/></>) : (<></>)} 
        {opcao === "Germinação" ? (<><GerenciarPlantaGerminacao/></>) : (<></>)}
        {opcao === "Muda" ? (<><GerenciaPlantaMuda/></>) : (<></>)}
        {opcao === "Crescimento" ? (<><GerenciarPlantaCrescimento/></>) : (<></>)}
        {opcao === "Floração" ? (<><GerenciarPlantaFloracao/></>) : (<></>)}
        {opcao === "Frutificação" ? (<><GerenciaPlantaFrutiricacao/></>) : (<></>)}
        {opcao === "Maturação" ? (<><GerenciarPlantaMaturacao/></>) : (<></>)}
        {opcao === "Fim" ? (<><GerenciaPlantaFimCiclo/></>) : (<></>)}
        
        </div>
      </div>    
    </>
  );
}

export default Gerencia_Planta;