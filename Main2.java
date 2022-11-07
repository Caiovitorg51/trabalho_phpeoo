package peoo_trabalho;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main2 {
    
    public void main () throws InterruptedException {

        System.out.println("Escolha onde quer colocar o alimento, os dois robos localizados nos pontos 0,0 e 5,5 tentarao chegar la sozinhos.");
        
        Random random = new Random();
        Random random2 = new Random();
        int aux = random2.nextInt(2); //escolher quem vai comecar, aleatoriamente
        
        Scanner ler = new Scanner(System.in);

        Robo robo1 = new Robo("azul");
        Robo robo2 = new Robo("verde");
        
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

                    if(j == robo2.getPosX() && i == robo2.getPosY()) {
                        System.out.print("robo verde ");
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
                try {
                    robo2.mover(comando);
                }
                catch (MovimentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            TimeUnit.SECONDS.sleep(3);

            aux++;
        }
        
        if (robo2.getPosX() == xAlimento || robo2.getPosY() == yAlimento) {
            System.out.println("\nO robo verde venceu com " + robo2.getMov() + " movimentos)!!\n");
            System.out.println("O robo azul perdeu com " + robo1.getMov() + " movimentos.");
        }
        else {
            System.out.println("\nO robo azul venceu com " + robo1.getMov() + " movimentos!!\n");
            System.out.println("O robo verde perdeu com " + robo2.getMov() + " movimentos.");
        }

    }

}