import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    private Calculadora calculadora;

    @Before()
    public void init() {
        this.calculadora = new Calculadora();
    }

    @Test
    public void deveSomar() {
        Double numero1 = 2.0, numero2 = 2.0;

        Double resultado = calculadora.somar(numero1, numero2);

        Assertions.assertThat(resultado).isEqualTo(4);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomar() {
        Double numero1 = -2.0, numero2 = -2.0;

        calculadora.somar(numero1, numero2);
    }

    @Test()
    public void deveSubtrair() {
        Double numero1 = 2.0, numero2 = 2.0;

        Double resultado = calculadora.subtrair(numero1, numero2);

        Assertions.assertThat(resultado).isEqualTo(0);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSubtrair() {
        Double numero1 = -2.0, numero2 = -2.0;

        calculadora.subtrair(numero1, numero2);
    }

    @Test()
    public void deveMultiplicar() {
        Double numero1 = 3.0, numero2 = 2.0;

        Double resultado = calculadora.multiplicar(numero1, numero2);

        Assertions.assertThat(resultado).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveMultiplicar() {
        Double numero1 = -2.0, numero2 = -2.0;

        calculadora.multiplicar(numero1, numero2);
    }

    @Test()
    public void deveDividir() {
        Double numero1 = 2.0, numero2 = 2.0;

        Double resultado = calculadora.dividir(numero1, numero2);

        Assertions.assertThat(resultado).isEqualTo(1);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveDividir() {
        Double numero1 = 0.0, numero2 = -2.0;

        calculadora.multiplicar(numero1, numero2);
    }
}

class Calculadora {

    Double somar(Double numero1, Double numero2) {
        if(numero1 < 0 || numero2 < 0) {
            throw new RuntimeException("Não é possivel somar números negativos");
        }

        return numero1 + numero2;
    }

    Double subtrair(Double numero1, Double numero2) {
        if(numero1 < 0 || numero2 < 0) {
            throw new RuntimeException("Não é possivel somar números negativos");
        }

        return numero1 - numero2;
    }

    Double multiplicar(Double numero1, Double numero2) {
        if(numero1 < 0 || numero2 < 0) {
            throw new RuntimeException("Não é possivel somar números negativos");
        }

        return numero1 * numero2;
    }

    Double dividir(Double numero1, Double numero2) {
        if(numero1 <= 0 || numero2 <= 0) {
            throw new RuntimeException("Não é possivel somar números negativos");
        }

        return numero1 / numero2;
    }

}
