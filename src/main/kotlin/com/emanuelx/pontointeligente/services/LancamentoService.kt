package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Lancamento
import org.springframework.data.domain.AbstractPageRequest
import org.springframework.data.domain.Page

interface LancamentoService {

    fun findByFuncionarioId(funcionarioId: String, pageRequest: AbstractPageRequest): Page<Lancamento>

    fun findById(id: String): Lancamento?

    fun persist(lancamento: Lancamento): Lancamento

    fun remover(id: String)
}