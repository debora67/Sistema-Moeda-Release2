import React, { useState } from 'react';
import api from '../services/api';
import './Form.css';

export default function EmpresaForm() {
  const [form, setForm] = useState({
    nomeFantasia: '', email: '', senha: '', cnpj: ''
  });

  const handleChange = e =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async e => {
    e.preventDefault();
    try {
      await api.post('/empresas', form);
      alert('Empresa cadastrada com sucesso!');
      setForm({ nomeFantasia: '', email: '', senha: '', cnpj: '' });
    } catch (err) {
      alert('Erro ao cadastrar empresa.');
    }
  };

  return (
    <div className="form-container">
      <form onSubmit={handleSubmit}>
        <h2>Cadastro de Empresa Parceira</h2>
        <input name="nomeFantasia" placeholder="Nome Fantasia" value={form.nomeFantasia} onChange={handleChange} />
        <input name="email" placeholder="Email" value={form.email} onChange={handleChange} />
        <input name="senha" type="password" placeholder="Senha" value={form.senha} onChange={handleChange} />
        <input name="cnpj" placeholder="CNPJ" value={form.cnpj} onChange={handleChange} />
        <button type="submit">Cadastrar</button>
      </form>
    </div>
  );
}
