import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcessionariaKarroNovo {
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Cadastrar novo veículo");
            System.out.println("2 - Editar veículo");
            System.out.println("3 - Ver informações de um veículo específico");
            System.out.println("4 - Excluir um veículo");
            System.out.println("5 - Ver todos os veículos");
            System.out.println("6 - Sair");
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    exibirMenuCadastro();
                    break;
                case 2:
                    editarVeiculo();
                    break;
                case 3:
                    exibirInformacoesVeiculo();
                    break;
                case 4:
                    excluirVeiculo();
                    break;
                case 5:
                    exibirTodosVeiculos();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 6);
    }

    private static void exibirMenuCadastro() {
        int opcao;
        do {
            System.out.println("Qual tipo de veículo será cadastrado?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Caminhão");
            System.out.println("4 - Bicicleta");
            System.out.println("5 - Voltar ao menu inicial");
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    cadastrarMoto();
                    break;
                case 3:
                    cadastrarCaminhao();
                    break;
                case 4:
                    cadastrarBicicleta();
                    break;
                case 5:
                    System.out.println("Voltando ao menu inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void cadastrarCarro() {
        System.out.println("Digite os dados do carro:");
        String codigo = lerString("Código (Placa): ");
        String cor = lerString("Cor: ");
        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");
        double valor = lerDouble("Valor: ");
        String combustivel = lerCombustivel();
        int portas = lerInteiro("Quantidade de portas: ");

        Carro carro = new Carro(codigo, cor, marca, modelo, valor, combustivel, portas);
        veiculos.add(carro);
        System.out.println("Carro cadastrado com sucesso!");
    }

    private static void cadastrarMoto() {
        System.out.println("Digite os dados da moto:");
        String codigo = lerString("Código (Placa): ");
        String cor = lerString("Cor: ");
        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");
        double valor = lerDouble("Valor: ");
        String combustivel = lerCombustivel();
        boolean partidaEletrica = lerBooleano("Possui partida elétrica? ");
        int cilindradas = lerInteiro("Cilindradas: ");

        Moto moto = new Moto(codigo, cor, marca, modelo, valor, combustivel, partidaEletrica, cilindradas);
        veiculos.add(moto);
        System.out.println("Moto cadastrada com sucesso!");
    }

    private static void cadastrarCaminhao() {
        System.out.println("Digite os dados do caminhão:");
        String codigo = lerString("Código (Placa): ");
        String cor = lerString("Cor: ");
        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");
        double valor = lerDouble("Valor: ");
        String combustivel = lerCombustivel();
        int cargaMaxima = lerInteiro("Carga máxima (kg): ");
        int numeroEixos = lerInteiro("Número de eixos: ");

        Caminhao caminhao = new Caminhao(codigo, cor, marca, modelo, valor, combustivel, cargaMaxima, numeroEixos);
        veiculos.add(caminhao);
        System.out.println("Caminhão cadastrado com sucesso!");
    }

    private static void cadastrarBicicleta() {
        System.out.println("Digite os dados da bicicleta:");
        String codigo = lerString("Código (Número de série): ");
        String cor = lerString("Cor: ");
        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");
        double valor = lerDouble("Valor: ");
        String tipoFreio = lerTipoFreio();

        Bicicleta bicicleta = new Bicicleta(codigo, cor, marca, modelo, valor, tipoFreio);
        veiculos.add(bicicleta);
        System.out.println("Bicicleta cadastrada com sucesso!");
    }

    private static void editarVeiculo() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
            return;
        }

        System.out.println("Digite o código do veículo que deseja editar:");
        String codigo = scanner.nextLine();

        Veiculo veiculo = buscarVeiculo(codigo);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
        } else {
            System.out.println("Digite os novos dados do veículo:");
            String cor = lerString("Cor: ");
            String marca = lerString("Marca: ");
            String modelo = lerString("Modelo: ");
            double valor = lerDouble("Valor: ");

            veiculo.setCor(cor);
            veiculo.setMarca(marca);
            veiculo.setModelo(modelo);
            veiculo.setValor(valor);

            System.out.println("Veículo atualizado com sucesso!");
        }
    }

    private static void exibirInformacoesVeiculo() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
            return;
        }

        System.out.println("Digite o código do veículo que deseja consultar:");
        String codigo = scanner.nextLine();

        Veiculo veiculo = buscarVeiculo(codigo);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
        } else {
            System.out.println("Informações do veículo:");
            System.out.println(veiculo.toString());
        }
    }

    private static void excluirVeiculo() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
            return;
        }

        System.out.println("Digite o código do veículo que deseja excluir:");
        String codigo = scanner.nextLine();

        Veiculo veiculo = buscarVeiculo(codigo);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
        } else {
            veiculos.remove(veiculo);
            System.out.println("Veículo removido com sucesso!");
        }
    }

    private static void exibirTodosVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
        } else {
            System.out.println("Todos os veículos cadastrados:");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.toString());
            }
        }
    }

    private static Veiculo buscarVeiculo(String codigo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCodigo().equalsIgnoreCase(codigo)) {
                return veiculo;
            }
        }
        return null;
    }

    private static int lerOpcao() {
        System.out.print("Digite sua opção: ");
        return scanner.nextInt();
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine(); // Limpar o buffer do Scanner
        return scanner.nextLine();
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    private static boolean lerBooleano(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextBoolean();
    }

    private static String lerCombustivel() {
        String combustivel;
        do {
            combustivel = lerString("Combustível (G - Gasolina, A - Álcool, F - Flex, E - Elétrico, D - Diesel): ");
            if (!combustivel.matches("[GAFED]")) {
                System.out.println("Combustível inválido. Por favor, escolha uma opção válida.");
            }
        } while (!combustivel.matches("[GAFED]"));
        return combustivel;
    }

    private static String lerTipoFreio() {
        String tipoFreio;
        do {
            tipoFreio = lerString("Tipo de freio (C - Cantilever, V - Brake, F - Ferradura, M - Disco Mecânico, H - Disco Hidráulico): ");
            if (!tipoFreio.matches("[CVFMH]")) {
                System.out.println("Tipo de freio inválido. Por favor, escolha uma opção válida.");
            }
        } while (!tipoFreio.matches("[CVFMH]"));
        return tipoFreio;
    }
}

class Veiculo {
    private String codigo;
    private String cor;
    private String marca;
    private String modelo;
    private double valor;

    public Veiculo(String codigo, String cor, String marca, String modelo, double valor) {
        this.codigo = codigo;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Cor: " + cor +
                ", Marca: " + marca +
                ", Modelo: " + modelo +
                ", Valor: " + valor;
    }
}

class Automotor extends Veiculo {
    private String combustivel;

    public Automotor(String codigo, String cor, String marca, String modelo, double valor, String combustivel) {
        super(codigo, cor, marca, modelo, valor);
        this.combustivel = combustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Combustível: " + combustivel;
    }
}

class Carro extends Automotor {
    private int qtdePortas;

    public Carro(String codigo, String cor, String marca, String modelo, double valor, String combustivel, int qtdePortas) {
        super(codigo, cor, marca, modelo, valor, combustivel);
        this.qtdePortas = qtdePortas;
    }

    public int getQtdePortas() {
        return qtdePortas;
    }

    public void setQtdePortas(int qtdePortas) {
        this.qtdePortas = qtdePortas;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Quantidade de portas: " + qtdePortas;
    }
}

class Moto extends Automotor {
    private boolean partidaEletrica;
    private int cilindradas;

    public Moto(String codigo, String cor, String marca, String modelo, double valor, String combustivel, boolean partidaEletrica, int cilindradas) {
        super(codigo, cor, marca, modelo, valor, combustivel);
        this.partidaEletrica = partidaEletrica;
        this.cilindradas = cilindradas;
    }

    public boolean hasPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Partida Elétrica: " + partidaEletrica +
                ", Cilindradas: " + cilindradas;
    }
}

class Caminhao extends Automotor {
    private int cargaMaxima;
    private int numeroEixos;

    public Caminhao(String codigo, String cor, String marca, String modelo, double valor, String combustivel, int cargaMaxima, int numeroEixos) {
        super(codigo, cor, marca, modelo, valor, combustivel);
        this.cargaMaxima = cargaMaxima;
        this.numeroEixos = numeroEixos;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Carga Máxima: " + cargaMaxima +
                ", Número de Eixos: " + numeroEixos;
    }
}

class Bicicleta extends Veiculo {
    private String tipoFreio;

    public Bicicleta(String codigo, String cor, String marca, String modelo, double valor, String tipoFreio) {
        super(codigo, cor, marca, modelo, valor);
        this.tipoFreio = tipoFreio;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo de Freio: " + tipoFreio;
    }
}

