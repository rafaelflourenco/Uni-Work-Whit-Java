import java.rmi.server.RemoteRef;

public class Retangulo {
    int xGrande, xPequeno, yGrande, yPequeno;
    private final Ponto[] pontosRetangulo;
    public Retangulo(int xGrande,int xPequeno, int yGrande,int yPequeno,Ponto[] pontos){
        this.xGrande = xGrande;
        this.xPequeno = xPequeno;
        this.yGrande = yGrande;
        this.yPequeno = yPequeno;
        this.pontosRetangulo = pontos;
    }
    public boolean intercptaRetangulo(Retangulo r){
        if((xGrande == r.xGrande && xPequeno == r.xPequeno) && ((yPequeno < r.yGrande && r.yGrande <= yGrande) || (r.yPequeno <= yGrande && yGrande <= r.yGrande))){
            return true;
        }
        else if ((yGrande == r.yGrande && yPequeno == r.yPequeno) && ((xPequeno < r.xGrande && r.xGrande < xGrande) || (r.xPequeno < xGrande && xGrande < r.xGrande))){
            return true;
        }
        else if(((xPequeno < r.xGrande && r.xGrande < xGrande) || (r.xPequeno < xGrande && xGrande < r.xGrande)) && ((yPequeno < r.yGrande && r.yGrande < yGrande) || (r.yPequeno < yGrande && yGrande < r.yGrande))){
           return true;
        }
        return false;

    }

    public Ponto[] getPontosRetangulo() {
        return pontosRetangulo;
    }
}
