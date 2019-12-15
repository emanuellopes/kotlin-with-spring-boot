package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Empresa
import com.emanuelx.pontointeligente.repositories.EmpresaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.lang.Exception


@SpringBootTest
class EmpresaServiceTest {

    @Autowired
    val empresaService: EmpresaService? = null

    @MockBean
     val empresaRepository: EmpresaRepository? = null

    private val CNPJ = "123456789012"

    @BeforeEach
    @Throws(Exception::class)
     fun setUp() {
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testFindEmpresaByCnpj() {
        val empresa: Empresa? = empresaService?.findByCnpj(CNPJ)
        Assertions.assertNotNull(empresa)
    }


    @Test
    fun testPersistEmpresa() {
        val empresa: Empresa? = empresaService?.persist(empresa())
        Assertions.assertNotNull(empresa)
    }


    private fun empresa(): Empresa = Empresa("Razao Social", CNPJ, "1")
}