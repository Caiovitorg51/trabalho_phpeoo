package peoo_trabalho;

public class Robo {
    protected int posX;
    protected int posY;
    protected int mov;
    protected String cor;

    public Robo(final String cor) {
        this.cor = cor;
        posX = 0;
        posY = 0;
        mov = 0;
    }
    
    public void setMov(final int mov){
        this.mov = mov;
        
    }
    
    public int getMov(){
        return mov;
    }

    public void setPosX(final int posX) {
        this.posX = posX;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosY(final int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public void mover(String movimento) throws MovimentoInvalidoException {
        if (movimento.equals("up")){
            posY += 1;            
            mov++;
            if(posY > 5) {
                mov--;
                posY--;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento.equals("down")){
            posY -= 1;
            mov++;
            if(posY < 0) {
                mov--;
                posY++;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento.equals("right")){
            posX += 1;
            mov++;
            if(posX > 5) {
                mov--;
                posX--;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento.equals("left")){
            posX -= 1;
            mov++;
            if(posX < 0) {
                mov--;
                posX++;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else
            throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover mas, o movimento " + movimento + " é invalido para ele.\n");   
    }
    
     public void mover(int movimento) throws MovimentoInvalidoException {
        if (movimento == 1){
            posY += 1;          
            mov++;
            if(posY > 5) {
                mov--;
                posY--;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento == 2){
            posY -= 1;
            mov++;
            if(posY < 0) {
                mov--;
                posY++;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento == 3){
            posX += 1;
            mov++;
            if(posX > 5) {
                mov--;
                posX--;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else if (movimento == 4){
            posX -= 1;
            mov++;
            if(posX < 0) {
                mov--;
                posX++;
                throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");
            }
        }
        else
            throw new MovimentoInvalidoException("O robo " + this.cor + " tentou se mover, mas o movimento " + movimento + " é invalido para ele.\n");   
    }
     
    public boolean encontrou(int xAlimento, int yAlimento) {
        if(posX == xAlimento && posY == yAlimento)
            return true;
        return false;
    }
}