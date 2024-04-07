import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RetaTest {

    @Test
    public void testPositive() // Testa a função OnSegment, para verificar se um Ponto é colinear com a reta
    {
        Ponto[] pontos = new Ponto[2];
        pontos[0] = new Ponto(1,0);
        pontos[1] = new Ponto(8,0);
        Reta reta = new Reta(pontos, pontos.length);
        Ponto terceiroPonto = new Ponto(5,0);
        assertTrue(reta.onSegment(terceiroPonto));
    }

    @Test
    public void testNegative() // Testa a função OnSegment, para verificar se um Ponto é colinear com a reta
    {
        Ponto[] pontos = new Ponto[2];
        pontos[0] = new Ponto(1,0);
        pontos[1] = new Ponto(8,0);
        Reta reta = new Reta(pontos, pontos.length);
        Ponto terceiroPonto = new Ponto(3,4);
        assertFalse(reta.onSegment(terceiroPonto));
    }

}