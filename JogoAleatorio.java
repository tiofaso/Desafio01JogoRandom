import java.util.ArrayList;
import java.util.Scanner;

public class JogoAleatorio {
    public static void main(String[] args){
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|           Vamos brincar de adivinhar números?           |");
        System.out.println("+---------------------------------------------------------+");

        //Pegando número digitado pelo usuário
        System.out.println("\nEscolha um dos números para selecionar a dificuldade:");
        System.out.println("1 Easy  |  2 Medium  | 3 Hard  | 4 Joy has no mercy");
        Scanner entrada = new Scanner(System.in);
        int numeroUsuario = entrada.nextInt();

        //verificando se o usuário fez uma opção válida
        if(numeroUsuario < 1 || numeroUsuario > 4 ) {
            int numErrado = 1;
            while(numErrado == 1) {

                System.out.println("+---------------------------------------------------------+");
                System.out.println("| AVISO! É preciso escolher um grau de dificuldade válido |");
                System.out.println("+---------------------------------------------------------+\n");

                System.out.println("Escolha um dos números para selecionar a dificuldade:");
                System.out.println("1 Easy  |  2 Medium  | 3 Hard  | 4 Joy has no mercy");

                numeroUsuario = entrada.nextInt();

                if(numeroUsuario >= 1 && numeroUsuario <= 4){numErrado = 0;}

            }
        }

        System.out.println("\n---------------------------------------------------------");

        //Definindo o grau de dificuldade da partida
        int numDificuldade = numeroUsuario;
        String msgNivel = "";

        switch (numDificuldade){
            case 1:
                System.out.println("Você escolheu o nível EASY. Escolha entre 0 - 10 números");
                msgNivel = "EASY";
                numDificuldade = 10;
                break;
            case 2:
                System.out.println("Você escolheu o nível MEDIUM. Escolha entre 0 - 100 números");
                msgNivel = "MEDIUM";
                numDificuldade = 100;
                break;
            case 3:
                System.out.println("Você escolheu o nível HARD. Escolha entre 0 - 1000 números");
                msgNivel = "HARD";
                numDificuldade = 1000;
                break;
            case 4:
                System.out.println("Você escolheu o nível JOY HAS NO MERCY. Escolha entre 0 - 10000 números");
                msgNivel = "JOY HAS NO MERCY";
                numDificuldade = 10000;
                break;
        }
        //Setando variáveis
        String msgExit = "n"; //flag para interromper o jogo
        int numScore = 0; //score do jogo
        int numJogadas = 0; //numero de vezes que o usuário jogou
        int contSaida = 0; //contador de jogadas para mostrar ao usuário a opção de sair
        String fgMsgExit = "\u001B[31m"; //Cor do texto de escolha para sair
        String fgMsgTab = "\u001B[30m"; //Cor do texto da tabela

        //Histórico de jogadas do usuário e do computador
        ArrayList<Integer> jogadaUsr = new ArrayList<>();
        ArrayList<Integer> jogadaComp = new ArrayList<>();
        ArrayList<Integer> jogadaPonto = new ArrayList<>();


        do{

            System.out.println("\nDigite um número [" + msgNivel + "]:");
            numeroUsuario = entrada.nextInt();

            //Separando o número digitado pelo usuário para comparação
            int numeroUsuarioAntes = numeroUsuario - 1;
            int numeroUsuarioDepois = numeroUsuario + 1;
            int numPontosInstantaneo = 0; //flag para informar quanto o jogador ganhou naquele instante

            //Gerando números aleatórios
            int numRandom = (int) (Math.random() * (numDificuldade+1));

            //Adicionando dados ao histórico
            jogadaUsr.add(numeroUsuario);
            jogadaComp.add(numRandom);

            //Comparando o que o usuário digitou com o que o computador gerou
            if(numeroUsuario == numRandom){
                numScore = numScore + 10;
                numJogadas = numJogadas + 1;
                numPontosInstantaneo = 10;
                jogadaPonto.add(numPontosInstantaneo);
            }else if(numeroUsuarioAntes == numRandom || numeroUsuarioDepois == numRandom){
                numScore = numScore + 5;
                numJogadas = numJogadas + 1;
                numPontosInstantaneo = 5;
                jogadaPonto.add(numPontosInstantaneo);
            }else{
                numJogadas = numJogadas + 1;
                numPontosInstantaneo = 0;
                jogadaPonto.add(numPontosInstantaneo);
            }

            System.out.println("\nVocê digitou " + numeroUsuario);
            System.out.println("O computador selecionou o número " + numRandom);
            System.out.println("Você ganhou " + numPontosInstantaneo + " pontos");

            if(contSaida == 4){//Após cinco jogadas pergunta se o usuário quer parar
                contSaida = 0;
                System.out.println("\n"+ fgMsgExit + "> Deseja sair? [S/N]");
                msgExit = entrada.next();
            }else{contSaida++;}

        }while (msgExit.equals("n") || msgExit.equals("N"));

        //exibindo o histórico de jogadas e sua pontuação
        int contHistoricoMax = jogadaUsr.size();
        int contHistorico = 0;
        String tabelaHistorico = "|  %-12s  |    %-6d    |    %-6d    |    %-4d  |%n";

        //System.out.println("\nHistórico de jogadas");
        System.out.format(fgMsgTab + "+---------------------------------------------------------+%n");
        System.out.format("|                   HISTÓRICO DE JOGADAS                  |%n");
        System.out.format("+---------------------------------------------------------+%n");
        System.out.format("|    jogadas     |  computador  |    usuário   |  pontos  |%n");
        System.out.format("+----------------|--------------|--------------|----------|%n");

        while(contHistorico < contHistoricoMax){

            System.out.format(tabelaHistorico, " jogada n°" + contHistorico,jogadaComp.get(contHistorico),jogadaUsr.get(contHistorico), jogadaPonto.get(contHistorico)  );
//            System.out.println("Jogada n°" + contHistorico);
//            System.out.println("Computador jogou: " + jogadaComp.get(contHistorico));
//            System.out.println("Você jogou: " + jogadaUsr.get(contHistorico));
//            System.out.println("Nessa jogada você recebeu "+ jogadaPonto.get(contHistorico)  + " pontos\n");
            contHistorico++;
        }
        System.out.format("+---------------------------------------------------------+%n");
        System.out.println("Seu score final é de: " + numScore + " pontos");
        System.out.println("As suas jogadas foram: " + jogadaUsr);
        System.out.println("As jogadas do computador: " + jogadaComp);

    }
}
