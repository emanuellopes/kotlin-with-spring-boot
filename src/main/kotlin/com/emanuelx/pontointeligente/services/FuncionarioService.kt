package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Funcionario

interface FuncionarioService {

    fun persist(funcionario: Funcionario): Funcionario

    fun findByCpf(cpf: String): Funcionario?

    fun findByEmail(email: String): Funcionario?

    fun findById(id: String): Funcionario?
}