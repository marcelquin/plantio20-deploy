import './Pages/CSS/Style.css'
import './Pages/CSS/reset.css'
import { Routes, Route } from 'react-router-dom';
import HeaderComponent from './Pages/Components/header'
import Home from './Pages/Page/Home';
import Gerenciar from './Pages/Page/Gerenciar';

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
              <Route path="/nova_area" element={<Cad_AreaPlantio />} />
              <Route path="/nova_planta" element={<Cad_Planta />} />
              <Route path="/planta" element={<Planta />} />
            </Routes>
          </div>

      </div>
      

    </>
  );
}

export default App;
