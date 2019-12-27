package com.emanuelx.pontointeligente.services

import com.emanuelx.pontointeligente.documents.Funcionario
import com.emanuelx.pontointeligente.enums.PerfilEnum
import com.emanuelx.pontointeligente.repositories.FuncionarioRepository
import com.emanuelx.pontointeligente.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.lang.Exception
import java.util.*

@SpringBootTest
class FuncionarioServiceTest {

    private val email: String = "johndoe@gmail.com"
    private val cpf: String = "12321321321321"
    private val id: String = "1"

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null


    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
                .willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
    }

    @Test
    fun testPersistFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persist(funcionario())
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testFindByCpf() {
        val funcionario: Funcionario? = this.funcionarioService?.findByCpf(cpf)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testFindByEmail() {
        val funcionario: Funcionario? = this.funcionarioService?.findByEmail(email)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testFindById() {
        val funcionario: Funcionario? = this.funcionarioService?.findById(id)
        Assertions.assertNotNull(funcionario)
    }


    private fun funcionario(): Funcionario = Funcionario("john", email,
            SenhaUtils().gerarBCrypt("123456"), cpf,
            PerfilEnum.ROLE_USER, id)
}