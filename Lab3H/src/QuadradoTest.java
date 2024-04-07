import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QuadradoTest {
    @Test
    public void testQuadrado1(){ // Teste para verificar se a funçao da false quando os polignos não se tocam

        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(1,0);
        pontos[1] = new Ponto(3,0);
        pontos[2] = new Ponto(3,4);
        pontos[3] = new Ponto(1,4);
        Quadrado q1 = new Quadrado(pontos);

        assertFalse(q1.isQuadrado(pontos));

    }
    @Test
    public void testQuadrado2(){ //Teste para verificar a função paraString do Quadrado
        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(1,0);
        pontos[1] = new Ponto(3,0);
        pontos[2] = new Ponto(3,2);
        pontos[3] = new Ponto(1,2);
        Quadrado p1 = new Quadrado(pontos);
        assertEquals("Quadrado: [(1,0), (3,0), (3,2), (1,2)]",p1.toString());


        // Expected: Quadrado: [(1,0), (3,0), (3,2), (1,2)]
    }

}