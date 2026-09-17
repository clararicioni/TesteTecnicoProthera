package testetecnicoprothera;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author Clara Bergamo
 */
public class Principal {

    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final NumberFormat FORMATO_NUMERO =
            NumberFormat.getNumberInstance(new Locale("pt", "BR"));

    private static final BigDecimal SALARIO_MINIMO =
            new BigDecimal("1212.00");

    public static void main(String[] args) {

        // 3.1 - Inserir todos os funcionários na mesma ordem da tabela.
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(
                "Maria", LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"), "Operador"));

        funcionarios.add(new Funcionario(
                "João", LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"), "Operador"));

        funcionarios.add(new Funcionario(
                "Caio", LocalDate.of(1961, 2, 2),
                new BigDecimal("9836.14"), "Coordenador"));

        funcionarios.add(new Funcionario(
                "Miguel", LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"), "Diretor"));

        funcionarios.add(new Funcionario(
                "Alice", LocalDate.of(1995, 5, 1),
                new BigDecimal("2234.68"), "Recepcionista"));

        funcionarios.add(new Funcionario(
                "Heitor", LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"), "Operador"));

        funcionarios.add(new Funcionario(
                "Arthur", LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"), "Contador"));

        funcionarios.add(new Funcionario(
                "Laura", LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"), "Gerente"));

        funcionarios.add(new Funcionario(
                "Heloísa", LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"), "Eletricista"));

        funcionarios.add(new Funcionario(
                "Helena", LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"), "Gerente"));
        };
    
    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(Principal::imprimirFuncionario);
    }

    private static void imprimirFuncionario(Funcionario funcionario) {
        System.out.println(
                "Nome: " + funcionario.getNome()
                        + " | Data de nascimento: "
                        + funcionario.getDataNascimento().format(FORMATO_DATA)
                        + " | Salário: R$ "
                        + formatarNumero(funcionario.getSalario())
                        + " | Função: " + funcionario.getFuncao()
        );
    }

    private static int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    private static String formatarNumero(BigDecimal valor) {
        FORMATO_NUMERO.setMinimumFractionDigits(2);
        FORMATO_NUMERO.setMaximumFractionDigits(2);
        return FORMATO_NUMERO.format(valor);
    }
}
