package com.emanuelx.pontointeligente.services.impl

import com.emanuelx.pontointeligente.documents.Empresa
import com.emanuelx.pontointeligente.repositories.EmpresaRepository
import com.emanuelx.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun findByCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persist(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}