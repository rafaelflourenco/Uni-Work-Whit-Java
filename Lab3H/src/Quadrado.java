import java.util.Arrays;

/**
 * Classe que extende do Retangulo e forma um quadrado
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Quadrado extends Retangulo{
    private final Ponto[] pontosQuadrado;
    public Quadrado(Ponto[] pontos){
        super(pontos);
        if(!isQuadrado(pontos)){
            System.out.println("Quadrado:vi");
            System.exit(0);
        }
        this.pontosQuadrado = pontos;
    }

    /**
     * @param pontos array de pontos
     * @return true se o conjunto de pontos formar um quadrado, false se não
     */
    public boolean isQuadrado(Ponto[] pontos){
        if(pontos.length != 4){
            return false;
        }
        SegmentoReta[] segmentoRetangulo = new SegmentoReta[4];
        for(int i = 0; i < 4; i++){
            segmentoRetangulo[i] = new SegmentoReta(pontos[i], pontos[(i+1)%4]);
        }

        for(int i = 0; i < 4; i++){
            if(segmentoRetangulo[i].angleBetweenSegments(segmentoRetangulo[(i+1)%4]) != 90){
                return false;
            }
        }

        int aresta = pontos[0].dist(pontos[1]);
        for(int i = 1; i < 4 ; i++){
            if(pontos[i].dist(pontos[(i+1)%4]) != aresta) return false;
        }

        return true;
    }

    /**
     * @return String formatada do Quadrado
     */
    @Override
    public String toString() {
        return "Quadrado: " + Arrays.toString(pontosQuadrado);
    }


    public Ponto[] getPontosQuadrado() {
        return pontosQuadrado;
    }
}
