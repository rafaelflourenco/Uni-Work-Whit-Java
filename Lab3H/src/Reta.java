/**
 * Classe tem como argumento um array de pontos, tem um método para a verificaçao se 2 pontos formam uma reta e para ver se 3 pontos são colineares
 * @author (Rafael Lourenço 79771)
 * @version (1.0.0 - 25/02/2024)
 * @inv Reta:vi - 2 pontos não formam uma reta
 * @inv Poligno:vi - uma reta tem 3 pontos pertencentes ao poligno (colineares)
 */

public class Reta{

    private Ponto[] retas;

    /**
     * Construtor que tem como objetivo verificar se um conjuto de pontos formam retas válidas e se essas retas contêm 3 ou mais pontos(colineares)
     * @param pontos
     * @param n
     */
    public Reta(Ponto[] pontos, int n){
        if(pontos[0].getX() == pontos[n -1].getX() && pontos[0].getY() == pontos[n - 1].getY()){  // Descobrir logo se o ultimo ponto liga com o primeiro
            System.out.println("Reta:vi");
            System.exit(0);
        }
        for(int i = 0; i < n; i++){

            Ponto a = pontos[i%n];
            Ponto b = pontos[(i + 1)%n];
            if(a.getX() == b.getX() && a.getY() == b.getY()){ // Descobrir se 2 pontos estão sobrepostos
                System.out.println("Reta:vi");
                System.exit(0);
            }
            else{
                this.retas = pontos;
            }
        }

    }

    /**
     * Método que recebe 3 pontos e verifica se eles estão na mesma reta
     * @param p3 Ponto 3
     * @return true se estão na mesma reta e false se não estão
     * @see <a href="https://www.geeksforgeeks.org/program-check-three-points-collinear/">...</a>
     */
    public boolean onSegment(Ponto p3)
    {

        int area = (this.getRetas()[0].getX() * (this.getRetas()[1].getY() - p3.getY())) + (this.getRetas()[1].getX() * (p3.getY() - this.getRetas()[0].getY())) + (p3.getX() * (this.getRetas()[0].getY() - this.getRetas()[1].getY()));
        return Math.abs(area) < 1e-9;
    }

    public Ponto[] getRetas() {
        return retas;
    }
}