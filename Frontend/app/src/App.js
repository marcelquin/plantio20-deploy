import './Pages/CSS/Style.css'
import './Pages/CSS/reset.css'
import { Routes, Route } from 'react-router-dom';
import HeaderComponent from './Pages/Components/header'
import Home from './Pages/Page/Home';
import Gerenciar from './Pages/Page/Gerenciar';
import Area from './Pages/Page/Area';
import Gerencia_Localizacao from './Pages/Page/Localizacao/Gerencia_Localizacao';
import Planta from './Pages/Page/Planta';
import Cad_Planta from './Pages/Page/Planta/Cad_Planta';
import Cad_AreaPlantio from './Pages/Page/AreaPlantio/Cad_AreaPlantio';

function App() {
  return (
    <>
      <div className='BackgroundGeral'>
          <div className='BoxHeader'>
            <HeaderComponent />
          </div>
          <div className='BoxBody'>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/gerenciar" element={<Gerenciar />} />
              <Route path="/area" element={<Area />} />
              <Route path="/localizacao" element={<Gerencia_Localizacao />} />
              <Route path="/planta" element={<Planta />} />
              <Route path="/nova_area" element={<Cad_AreaPlantio />} />
              <Route path="/nova_planta" element={<Cad_Planta />} />
            </Routes>
          </div>

      </div>
      

    </>
  );
}

export default App;
