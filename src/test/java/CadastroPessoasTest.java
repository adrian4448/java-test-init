import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas() {
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Adrian");
        cadastro.adicionar(pessoa);

        Assertions.assertThat(cadastro.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNotException.class)
    public void naoDeveAdicionarPessoaSemNome() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        cadastro.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Adrian");
        cadastro.adicionar(pessoa);

        cadastro.remover(pessoa);

        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test(expected = PessoaNotFoundException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Adrian");

        cadastro.remover(pessoa);
    }

}
