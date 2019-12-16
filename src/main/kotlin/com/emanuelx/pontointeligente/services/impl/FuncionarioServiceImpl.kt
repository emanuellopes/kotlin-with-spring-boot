package com.emanuelx.pontointeligente.services.impl

import com.emanuelx.pontointeligente.documents.Funcionario
import com.emanuelx.pontointeligente.repositories.FuncionarioRepository
import com.emanuelx.pontointeligente.services.FuncionarioService
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.stereotype.Service
import javax.swing.text.Document

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository): FuncionarioService {
    override fun persist(funcionario: Funcionario): Funcionario  =
            funcionarioRepository.save(funcionario)

    override fun findByCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

    override fun findByEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)

    override fun findById(id: String): Funcionario? = funcionarioRepository
            .findById(id).get()
}