import '../../CSS/BodyStyle.css'
import React, { useState, useEffect } from 'react';
import GerenciarLocalizacaoDisponiveis from './GerenciarLocalizacaoDisponiveis';
import GerenciarLocalizacaoTodos from './GerenciarLocalizacaoTodos'

function Gerencia_Localizacao() {
  const [showModal, setShowModal] = useState(false);
  const [modalContent, setModalContent] = useState(null);
  const [checkboxDisponivel, setCheckboxDisponivel] = useState('disponivel');

  const handleChangeDisponivel = (e) => {
    setCheckboxDisponivel(e.target.checked ? e.target.value: 'Todos');
  }

  const handleOpenModal = (content) => {
      setModalContent(content);
      setShowModal(true);
  };

  const UrlGetList = "http://192.168.0.24:8080/Localizacao/ListarSubareas"
  const [lista, setLista] = useState([]);

  
  const getLista = async () => {
    try {
      const response = await fetch(UrlGetList);
      const data = await response.json();
      setLista(data);
    } catch (error) {
      console.error('Erro ao buscar lista de subáreas:', error);
    }
  };

  useEffect(() => {
    getLista();
  }, []);

 const [dataRequest, setDataRequest] = useState({
      'nomeIdentificador': '',
      'codigo': ''
  })

  const handleRowSelect = (data) => {
    setDataRequest({
      'nomeIdentificador': data.nomeAreaPlantio,
      'codigo': data.codigo
    });
  }

  return (
    <>
        <div className="form-check">
          <input 
            className="form-check-input" 
            type="checkbox" 
            id="flexCheckDefault"
            checked={checkboxDisponivel === 'disponivel'}
            value="disponivel"
            onChange={handleChangeDisponivel}
          />
          <label className="form-check-label" htmlFor="flexCheckDefault">
            Disponivel
          </label>
        </div>
        <br/>
        {checkboxDisponivel === "Todos" ?(<><GerenciarLocalizacaoTodos/></>) : (<></>)}
        {checkboxDisponivel === "disponivel" ?(<><GerenciarLocalizacaoDisponiveis/></>) : (<></>)}
    </>
  );
}

export default Gerencia_Localizacao;