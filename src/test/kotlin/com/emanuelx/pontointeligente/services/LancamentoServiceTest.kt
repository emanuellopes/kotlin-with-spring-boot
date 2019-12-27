package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Funcionario
import com.emanuelx.pontointeligente.documents.Lancamento
import com.emanuelx.pontointeligente.enums.TipoEnum
import com.emanuelx.pontointeligente.repositories.LancamentoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import java.util.*
import kotlin.collections.ArrayList

@SpringBootTest
class LancamentoServiceTest {

    @Autowired
    private val lancamentoService: LancamentoService? = null

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    private val id: String = "1"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given<Page<Lancamento>>(
                lancamentoRepository?.findByFuncionarioId(id, PageRequest.of(0, 10, Sort.unsorted())))
                .willReturn(PageImpl(ArrayList<Lancamento>()))

        BDDMockito.given(lancamentoRepository?.findById(id))
                .willReturn(Optional.of(lancamento()))

        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java)))
                .willReturn(lancamento())
    }

    @Test
    fun testFindLancamentoById() {
        val lancamento: Lancamento? = lancamentoService?.findById(id)
        Assertions.assertNotNull(lancamento)
    }


    @Test
    fun testPersistLancamento() {
        val lancamento: Lancamento? = lancamentoService?.persist(lancamento())
        Assertions.assertNotNull(lancamento)
    }

    private fun lancamento(): Lancamento = Lancamento(Date(), TipoEnum.INICIO_TRABALHO, id)
}