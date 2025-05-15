import React from 'react';
import AlunoForm from './components/AlunoForm';
import EmpresaForm from './components/EmpresaForm';

function App() {
  return (
    <div style={{ padding: '2rem' }}>
      <AlunoForm />
      <hr />
      <EmpresaForm />
    </div>
  );
}

export default App;
