package com.emanuelx.pontointeligente.services.impl

import com.emanuelx.pontointeligente.documents.Lancamento
import com.emanuelx.pontointeligente.repositories.LancamentoRepository
import com.emanuelx.pontointeligente.services.LancamentoService
import org.springframework.data.domain.AbstractPageRequest
import org.springframework.data.domain.Page
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {
    override fun findByFuncionarioId(funcionarioId: String, pageRequest: AbstractPageRequest): Page<Lancamento> =
            lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun findById(id: String): Lancamento? = lancamentoRepository.findByIdOrNull(id)


    override fun persist(lancamento: Lancamento): Lancamento =
            lancamentoRepository.save(lancamento)


    override fun remover(id: String) = lancamentoRepository.deleteById(id)
}