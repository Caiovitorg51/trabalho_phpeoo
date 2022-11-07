package peoo_trabalho;

public class RoboInteligente extends Robo {
    private String movimentoInvalidoV1 = "";
    private String movimentoInvalidoV2 = "";
    private String movimentoInvalidoH1 = "";
    private String movimentoInvalidoH2 = "";
    private int comandoInvalidoH1 = 0;
    private int comandoInvalidoH2 = 0;
    private int comandoInvalidoV1 = 0;
    private int comandoInvalidoV2 = 0;
    
    public RoboInteligente(String cor) {
        super(cor);
        posX = 0;
        posY = 0;
        mov = 0;
    }

    public int getComando1() {
        return comandoInvalidoH1;
    }

    public int getComando2() {
        return comandoInvalidoH2;
    }

    public int getComando3() {
        return comandoInvalidoV1;
    }

    public int getComando4() {
        return comandoInvalidoV2;
    }

    public void mover(String movimento) throws MovimentoInvalidoException{
        if (movimento.equals("up") && movimentoInvalidoV1.isEmpty()) {
            posY += 1;
            mov += 1;
            if(movimentoInvalidoV2.equals("down")) {
                movimentoInvalidoV2 = "";
            }
            else if(posY > 5) {
                posY -= 1;
                mov -= 1;
                movimentoInvalidoV1 = "up";
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover,, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        
        else if (movimento.equals("down") && movimentoInvalidoV2.isEmpty()) {
            posY -= 1;
            mov += 1;
            if(posY < 0) {
                posY += 1;
                mov -= 1;
                movimentoInvalidoV2 = "down";
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
            else if(movimentoInvalidoV1.equals("up")) {
                movimentoInvalidoV1 = "";
            }
        }
        else if (movimento.equals("right") && movimentoInvalidoH1.isEmpty()) {
            posX += 1;
            mov += 1;
            if(movimentoInvalidoH2.equals("left")) {
                movimentoInvalidoH2 = "";
            }
            else if(posX > 5) {
                posX -= 1;
                mov -= 1;
                movimentoInvalidoH1 = "right";
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento.equals("left") && movimentoInvalidoH2.isEmpty()) {
            posX -= 1;
            mov += 1;
            if(posX < 0) {
                posX += 1;
                mov -= 1;
                movimentoInvalidoH2 = "left";
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
            else if(movimentoInvalidoH1.equals("right")) {
                movimentoInvalidoH1 = "";
            }
        }
    }

    public void mover(int movimento) throws MovimentoInvalidoException{
        if (movimento == 1 && comandoInvalidoV1 == 0) {
            posY += 1;
            mov += 1;
            if(comandoInvalidoV2 == 2) {
                comandoInvalidoV2 = 0;
            }
            else if(posY > 5) {
                posY -= 1;
                mov -= 1;
                comandoInvalidoV1 = 1;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento == 2 && comandoInvalidoV2 == 0) {
            posY -= 1;
            mov += 1;
            if(posY < 0) {
                posY += 1;
                mov -= 1;
                comandoInvalidoV2 = 2;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
            else if(comandoInvalidoV1 == 1) {
                comandoInvalidoV1 = 0;
            }
        }
        else if (movimento == 3 && comandoInvalidoH1 == 0) {
            posX += 1;
            mov += 1;
            if(comandoInvalidoH2 == 4) {
                comandoInvalidoH2 = 0;
            }
            else if(posX > 5) {
                posX -= 1;
                mov -= 1;
                comandoInvalidoH1 = 3;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento == 4 && comandoInvalidoH2 == 0) {
            posX -= 1;
            mov += 1;
            if(posX < 0) {
                posX += 1;
                mov -= 1;
                comandoInvalidoH2 = 4;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
            else if(comandoInvalidoH1 == 3) {
                comandoInvalidoH1 = 0;
            }
        }
    }
    
}