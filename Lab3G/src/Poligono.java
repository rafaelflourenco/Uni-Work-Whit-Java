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
     * @param size Numero de segmentos
     */
    public Poligono(Ponto[] p, int size) {

        if(size <= 2 ) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
        Reta reta =  new Reta(p,size);
        SegmentoReta[] s = new SegmentoReta[size];
        for(int i = 0; i < size; i++){
            s[i] = new SegmentoReta(reta.getRetas()[i], reta.getRetas()[(i+1)%size]);

        }

        for(int i = 0; i < size; i++){
            if(reta.onSegment(p[i]))// %n serve para os ultimos pontos poderem ligar aos primeiros no fim do fora
            {
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }

        for (int i = 0; i < size; i++) { // Verifica se 1 aresta do poligono se interceta com qualquer outra
            for (int j = i + 1; j < size ; j++) {
                if (s[i].intersects(s[j])) {
                    System.out.println("Poligono:vi");
                    System.exit(0);
                }

            }
        }
        this.segmentoPol = s;
        Ponto[] mediano = new Ponto[size]; // Array de transição
        int index = 0;
        for (int i = 0; i < size - 1; i++) { // Cria os próprios pontos a partir dos segmentos
            if (i == 0) {
                mediano[index] = s[i].getA();
                index++;
                mediano[index] = s[i].getB();
                index++;

            } else {
                mediano[index] = s[i].getB(); // a partir do primeiro segmento basta apenas adicionar o ponto final pois o inicial já foi adiciionado pelo anterior
                if (index != size - 1) index++;

            }

        }

        this.poligonos = mediano;
    }


    public boolean Poligonosintersect(Poligono p){
        for (int pontoIndex = 0; pontoIndex < this.poligonos.length; pontoIndex++) { // for que itera para cada segmento da reta
            for (int poliIndex = 0; poliIndex < p.getPoligonos().length; poliIndex++) { // for que itera para cada segmento do obstaculo
                if (this.getSegmentoPol()[pontoIndex].intersects(p.getSegmentoPol()[poliIndex])) {
                    return true;
                }
            }
        }

        return false;
    }

    public Ponto[] getPoligonos() {
        return poligonos;
    }

    public SegmentoReta[] getSegmentoPol() {
        return segmentoPol;
    }

}






