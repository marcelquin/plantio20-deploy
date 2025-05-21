import '../../CSS/BodyStyle.css'
import EditarInfo from './EditarInfo';
import React, { useState, useEffect } from 'react';

function GerenciarPlantaMuda() {
  const UrlGetList = "http://localhost:8080/planta/ListarPlantasMuda"
  const [listAll, setListAll] = useState([]);
  const [pesquisaInput, setPesquisaInput] = useState('')
  const [showModal, setShowModal] = useState(false);
  const [modalContent, setModalContent] = useState(null);

  const handleOpenModal = (content) => {
    setModalContent(content);
    setShowModal(true);
  };

  const response = pesquisaInput.length > 0 ?
    listAll.filter(dados => dados.nomePopular.includes(pesquisaInput)) :
    []

  const handleChange = (e) => {
    setPesquisaInput(e.target.value);
  }

  const getLista = async () => {
    try {
      const response = await fetch(UrlGetList);
      const data = await response.json();
      // Filtrar apenas plantas na fase de muda
      const plantasMuda = data.filter(planta => planta.ciclo.ciclo === 'MUDA');
      setListAll(plantasMuda);
    } catch (error) {
      console.error('Erro ao buscar lista de plantas:', error);
    }
  };

  useEffect(() => {
    getLista();
  }, []);

  const [dataRequest, setDataRequest] = useState({
    'idPlanta': '',
    'nomecientifico': '',
    'nomePopular': '',
    'instrucoes': '',
    'localizacao': '',
    'ciclo': '',
})

const handleRowSelect = (data) => {
  setDataRequest({
    'idPlanta': data.id,
    'nomeCientifico': data.nomeCientifico,
    'nomePopular': data.nomePopular,
    'instrucoes': data.instrucoes,
    'localizacao': data.localizacao.referencia,
    'ciclo': data.ciclo.ciclo,
  });
}

  return (
    <>
      <div className="input-group mb-3">
        <button className="btn btn-outline-secondary" type="button" id="button-addon1">Nome Popular</button>
        <input type="text" className="form-control" name='pesquisaInput' onChange={handleChange} placeholder="Digite o nome para pesquisa" aria-label="Example text with button addon" aria-describedby="button-addon1"/>
      </div>  
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Nome Popular</th>
            <th scope="col">Ciclo Atual</th>
            <th scope="col">Data Último Ciclo</th>
            <th scope="col">Data Ciclo Atual</th>
            <th scope="col">Localização</th>
            <th scope="col">Orientações</th>
          </tr>
        </thead>
        
        {pesquisaInput.length > 0 ? (
          <>
            {response.map((data, i) => (
              <tbody key={i}>
                <tr>
                    <td scope="row">{data.nomePopular}</td>
                    <td>{data.ciclo.ciclo}</td>
                    <td>{data.ciclo.dataUltimoCiclo}</td>
                    <td>{data.ciclo.dataCicloAtual}</td>
                    <td>{data.localizacao ? (<>{data.localizacao.referencia}</>) : (<></>)}</td>
                    <td>{data.instrucoes}</td>
                  <td><a onClick={() =>{handleOpenModal('Editar'); handleRowSelect(data);} } className='opcaoExtra'>Editar informações</a></td>
                </tr>
              </tbody>
            ))}
          </>
        ) : (
          <>
            {listAll.map((data, i) => (
              <tbody key={i}>
                <tr>
                    <td scope="row">{data.nomePopular}</td>
                    <td>{data.ciclo.ciclo}</td>
                    <td>{data.ciclo.dataUltimoCiclo}</td>
                    <td>{data.ciclo.dataCicloAtual}</td>
                    <td>{data.localizacao ? (<>{data.localizacao.referencia}</>) : (<></>)}</td>
                    <td>{data.instrucoes}</td>
                  <td><a onClick={() =>{handleOpenModal('Editar'); handleRowSelect(data);} } className='opcaoExtra'>Editar informações</a></td>
                </tr>
              </tbody>
            ))}
          </>
        )}
      </table>

      {showModal && (
        <div className="modal-overlay">
          <div className="modal-content">
            <div className="modal-header">
              <button 
                className="modal-close-button"
                onClick={() => setShowModal(false)}
              >
                ✕
              </button>
            </div>
            <div className="modal-body">
              {modalContent === 'Editar' && <EditarInfo data={dataRequest}/>}
            </div>
          </div>
        </div>
      )}
    </>
  );
}

export default GerenciarPlantaMuda;