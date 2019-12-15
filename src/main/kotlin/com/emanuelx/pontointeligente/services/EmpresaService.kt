package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Empresa

interface EmpresaService {

    fun findByCnpj(cnpj: String): Empresa?

    fun persist(empresa: Empresa): Empresa

}