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

        // 3.1 - inserir todos os funcionários na mesma ordem da tabela;
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(
                "Maria", LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"), "Operador"));

        funcionarios.add(new Funcionario(
                "João", LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"), "Operador"));

        funcionarios.add(new Funcionario(
                "Caio", LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"), "Coordenador"));

        funcionarios.add(new Funcionario(
                "Miguel", LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"), "Diretor"));

        funcionarios.add(new Funcionario(
                "Alice", LocalDate.of(1995, 1, 5),
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
        
        // 3.2 - remover o funcionário João;
        funcionarios.removeIf(funcionario ->
                funcionario.getNome().equalsIgnoreCase("João"));

        // 3.3 - imprimir todos os funcionários;
        System.out.println("========== 3.3 - FUNCIONÁRIOS ==========");
        imprimirFuncionarios(funcionarios);

        // 3.4 - aumentar todos os salários em 10%;
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario()
                    .multiply(new BigDecimal("1.10"))
                    .setScale(2, RoundingMode.HALF_UP);

            funcionario.setSalario(novoSalario);
        });

        // 3.5 - agrupar por função em map;
        Map<String, List<Funcionario>> funcionariosPorFuncao =
                funcionarios.stream()
                        .collect(Collectors.groupingBy(
                                Funcionario::getFuncao,
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        // 3.6 - imprimir funcionários agrupados por função;
        System.out.println("\n========== 3.6 - AGRUPADOS POR FUNÇÃO ==========");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(Principal::imprimirFuncionario);
        });

        // 3.8 - funcionários que fazem aniversário nos meses 10 e 12;
        System.out.println("\n========== 3.8 - ANIVERSARIANTES DE OUTUBRO E DEZEMBRO ==========");
        funcionarios.stream()
                .filter(funcionario -> {
                    int mes = funcionario.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(Principal::imprimirFuncionario);

        // 3.9 - funcionário com maior idade;
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        int idade = calcularIdade(funcionarioMaisVelho.getDataNascimento());

        System.out.println("\n========== 3.9 - FUNCIONÁRIO COM MAIOR IDADE ==========");
        System.out.println("Nome: " + funcionarioMaisVelho.getNome());
        System.out.println("Idade: " + idade + " anos");

        // 3.10 - lista em ordem alfabética;
        System.out.println("\n========== 3.10 - ORDEM ALFABÉTICA ==========");
        funcionarios.stream()
                .sorted(Comparator.comparing(
                        Funcionario::getNome,
                        String.CASE_INSENSITIVE_ORDER
                ))
                .forEach(Principal::imprimirFuncionario);

        // 3.11 - total dos salários;
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n========== 3.11 - TOTAL DOS SALÁRIOS ==========");
        System.out.println("Total: R$ " + formatarNumero(totalSalarios));

        // 3.12 - quantos salários mínimos ganha cada funcionário;
        System.out.println("\n========== 3.12 - SALÁRIOS MÍNIMOS POR FUNCIONÁRIO ==========");
        funcionarios.forEach(funcionario -> {
            BigDecimal quantidade = funcionario.getSalario()
                    .divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);

            System.out.println(funcionario.getNome()
                    + " ganha aproximadamente "
                    + formatarNumero(quantidade)
                    + " salários mínimos.");
        });
    }
    
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
