package peoo_trabalho;

import java.util.Scanner;

public class Main1 {
    
    public void main () throws InterruptedException {

        System.out.println("Como jogar:"
                + "\nSeu objetivo e levar o robô da havan até a comida dele!"
                + "\nPrimeiro, escolha um numero de 0 a 6 para colocar o alimento do seu robo! ATENCAO: o terreno tem apenas 5 metros e comeca do 0!"
                + "\nDepois, escolha se voce quer dar os comandos com palavras ou com numeros. Mas você pode alternar entre os numeros e os comandos de palavra sempre que quiser."
                + "\nSe voce escolher dar o comando com frases você terá as seguintes opções: com a palavra 'up' seu robo irá para cima, com 'down' para baixo, com 'left' para esquerda e com 'right' para direita."
                + "\nMas se voce escolher dar o comando com numeros: com o numero 1 seu robo irá para cima, com 2 para baixo, com 3 para direita e com 4 para a esquerda."
                + "\nlembre-se... Voce so pode andar uma casinha por vez!"
                + "\n"
                + "\nseja rápido, o robô está com fome (se é que isto é possivel...)\n");
                
        Scanner ler = new Scanner(System.in);

        Robo r = new Robo("azul");
        
        System.out.print("Digite a coordenada x do alimento: ");
        int xAlimento = ler.nextInt();
        System.out.print("Digite a coordenada y do alimento: ");
        int yAlimento = ler.nextInt();
        
        if ((xAlimento < 0 || xAlimento > 5) || (yAlimento < 0 || yAlimento > 5)){ //evitar que o alimento fique fora do terreno
            System.out.println("Entrada invalida, execute o programa novamente");
            System.exit(0);
        }

        while(r.getPosX() != xAlimento || r.getPosY() != yAlimento) {
            System.out.print("\n");
            for(int i=5; i>=0; i--){
                for(int j=0; j<6; j++) {
                    if(i == r.getPosY() && j == r.getPosX())
                        System.out.print("robo azul  "); 
                    else if(i == yAlimento && j == xAlimento)
                        System.out.print("alimento   ");
                    else 
                        System.out.print("*          "); 
                }

                System.out.println("\n");
            }
            
            System.out.print("Dê seu comando ao robo: ");
            String comando = ler.next();
            if(comando.length() == 1) {
                int c = Integer.parseInt(comando);
                try {
                    r.mover(c);
                }
                catch (MovimentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                try {
                    r.mover(comando);
                }
                catch (MovimentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("Voce achou o alimento!");

    }

}