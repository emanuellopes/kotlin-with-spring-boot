package com.emanuelx.pontointeligente.documents

import com.emanuelx.pontointeligente.enums.PerfilEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Funcionario(
        val nome: String,
        val email: String,
        val password: String,
        val cpf: String,
        val perfil: PerfilEnum,
        val empresaId: String,
        val valorHora: Double? = 0.0,
        val quantidadeHorasTrabalho: Float? = 0.0f,
        val quantidadeHorasAlmoco: Float? = 0.0f,
        @Id val id: String? = null
)