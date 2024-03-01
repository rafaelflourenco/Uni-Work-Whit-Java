/**
 * Classe que tem como argumentos um array de pontos que formam um poligno.
 * @author (Rafael Lourenço 79771)
 * @version (1.0.0 - 25/02/2024)
 * @inv Poligono:vi quando dois segmentos de reta se intercetam
 */
public class Poligono {
    private final Ponto[] poligonos;
    private final SegmentoReta[] segmentoPol;


    /**
     * Construtor que recebe um array de segmentos de reta e o numero de segmentos do poligno
     * @param p Array de Pontos
     * @param lines Numero de segmentos
     */
    public Poligono(Ponto[] p, int lines) {
        Reta reta =  new Reta(p,lines);

        if(lines <= 2 ) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }

        SegmentoReta[] s = new SegmentoReta[lines];
        for(int i = 0; i < lines; i++){
            s[i] = new SegmentoReta(reta.getRetas()[i], reta.getRetas()[(i+1)%lines]); // Passa para o segmento o array de pontos que já sabemos que são retas

        }



        for (int i = 0; i < lines; i++) { // Verifica se 1 aresta do poligono se interceta com qualquer outra
            for (int j = i + 1; j < lines ; j++) {
                if (s[i].intersects(s[j])) {

                    System.out.println("Poligono:vi");
                    System.exit(0);
                }
            }
        }
        this.segmentoPol = s;
        Ponto[] mediano = new Ponto[lines]; // Array de transição
        int index = 0;
        for (int i = 0; i < lines - 1; i++) { // Cria os próprios pontos a partir dos segmentos
            if (i == 0) {
                mediano[index] = s[i].getA();
                index++;
                mediano[index] = s[i].getB();
                index++;

            } else {
                mediano[index] = s[i].getB(); // a partir do primeiro segmento basta apenas adicionar o ponto final pois o inicial já foi adiciionado pelo anterior
                if (index != lines - 1) index++;

            }

        }
        for(int i = 0; i < lines; i++){
            if(reta.onSegment(p[i],p[(i+1)%lines],p[(i+2)%lines])) // %n serve para os ultimos pontos poderem ligar aos primeiros no fim do for
            {
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }


        this.poligonos = mediano;
    }


    public Ponto[] getPoligonos() {
        return poligonos;
    }

    public SegmentoReta[] getSegmentoPol() {
        return segmentoPol;
    }
}






