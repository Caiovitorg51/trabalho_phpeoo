package peoo_trabalho;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main3 {
    
    public void main () throws InterruptedException {

        System.out.println("O objetivo desse jogo e um robo chegar ao alimento, que voce escolhe onde colocar.\nO robo rosa, o inteligente, comeca no 5,5. O azul, no 0,0. Ambos tentarao chegar la sem sua ajuda.\n");
        
        Random random = new Random();
        Random random2 = new Random();
        int aux = random2.nextInt(2); //escolher quem vai comecar, aleatoriamente
        
        Scanner ler = new Scanner(System.in);

        Robo robo1 = new Robo("azul");
        RoboInteligente robo2 = new RoboInteligente("rosa");
        
        robo2.setPosX(5);
        robo2.setPosY(5);
        
        System.out.print("Digite a coordenada x do alimento: ");
        int xAlimento = ler.nextInt();
        System.out.print("\nDigite a coordenada y do alimento: ");
        int yAlimento = ler.nextInt();

        if ((xAlimento < 0 || xAlimento > 5) || (yAlimento < 0 || yAlimento > 5)){ //evitar que o alimento fique fora do terreno
            System.out.println("Entrada invalida, execute o programa novamente");
            System.exit(0);
        }
         
        while((robo1.getPosX() != xAlimento || robo1.getPosY() != yAlimento) && (robo2.getPosX() != xAlimento || robo2.getPosY() != yAlimento)) {
            
            for(int i=5; i>=0; i--){
                for(int j=0; j<6; j++) {
                    boolean ocupado = false;

                    if(j == robo1.getPosX() && i == robo1.getPosY()) {
                        System.out.print("robo azul  ");
                        ocupado = true;
                    }

                    if (j == robo2.getPosX() && i == robo2.getPosY()) {
                        System.out.print("robo rosa  ");
                        ocupado = true;
                    }

                    if(j == xAlimento && i == yAlimento) {
                        System.out.print("alimento   ");
                        ocupado = true;
                    }

                    if(!ocupado) 
                        System.out.print("*          ");
                }

                System.out.println("");
            }
            
            System.out.println("");
            
            int comando = random.nextInt(4);
            comando++;  
            
            if (aux % 2 == 0){
                try {
                    robo1.mover(comando);
                }
                catch (MovimentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                while(comando == robo2.getComando1() || comando == robo2.getComando2() || comando == robo2.getComando3() || comando == robo2.getComando4()) {
                    comando = random.nextInt(4);
                    comando++;
                }

                try {
                    robo2.mover(comando);
                }
                catch(MovimentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }          
            }
            
            TimeUnit.SECONDS.sleep(3);

            aux++;
        }
        
        if (robo2.getPosX() == xAlimento || robo2.getPosY() == yAlimento) {
            System.out.println("\nO robo rosa venceu com " + robo2.getMov() + " movimentos validos!!\n");
            System.out.println("O robo azul perdeu com " + robo1.getMov() + " movimentos validos.");
        }
        else {
            System.out.println("\nO robo azul venceu com " + robo1.getMov() + " movimentos validos!!\n");
            System.out.println("O robo rosa perdeu com " + robo2.getMov() + " movimentos validos.");
        }

    }

}