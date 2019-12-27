package com.emanuelx.pontointeligente.services.impl

import com.emanuelx.pontointeligente.documents.Lancamento
import com.emanuelx.pontointeligente.repositories.LancamentoRepository
import com.emanuelx.pontointeligente.services.LancamentoService
import org.springframework.data.domain.AbstractPageRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository): LancamentoService {
    override fun findByFuncionarioId(funcionarioId: String, pageRequest: AbstractPageRequest): Page<Lancamento> =


    override fun findById(id: String): Lancamento? =


    override fun persist(lancamento: Lancamento): Lancamento =


    override fun remover(id: String) =
}