package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Lancamento
import com.emanuelx.pontointeligente.repositories.LancamentoRepository
import org.junit.jupiter.api.BeforeEach
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

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
                lancamentoRepository?.findByFuncionarioId(id, PageRequest(0,10, Sort.unsorted())))
                .willReturn(PageImpl(ArrayList<Lancamento>()))
    }

    private fun lancamento(): Lancamento? = Lancamento()


}