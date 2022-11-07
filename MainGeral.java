package peoo_trabalho;

import java.util.Scanner;

public class MainGeral {

    public static void main (String [] args) throws InterruptedException {
        
        Scanner ler = new Scanner(System.in);

        System.out.println("Esse e o trabalho sobre tratamento de excecoes da equipe formada pelos alunos Yago, Jamile e Caio Vitor.");

        int opcao;
        boolean rodar = true;

        while(rodar) {
            System.out.println("Para visualizar o exemplo com apenas um robo movimentando-se com comandos do usuario, digite 1.");
            System.out.println("Para visualizar o exemplo com dois robos movimentando-se aleatoriamente digite 2.");
            System.out.println("Para visualizar o exemplo com um robo normal e um robo inteligente movendo-se aleatoriamente digite 3.");
            System.out.println("Para parar a execucao do programa digite 4.");

            opcao = ler.nextInt();

            if(opcao == 1){
                Main1 e1 = new Main1();
                e1.main();
            }
            else if(opcao == 2) {
                Main2 e2 = new Main2();
                e2.main();
            }
            else if(opcao == 3){
                Main3 e3 = new Main3();
                e3.main();
            }
            else if(opcao == 4)
                rodar = false;

            System.out.println("");
        }

        ler.close();

    }
}