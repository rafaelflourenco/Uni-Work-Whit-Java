class Ponto {

    double x, y;

    double dist (Ponto p) {

        double dx = x - p.x;

        double dy = y - p.y;

        return Math.sqrt(dx*dx + dy*dy);

    }

}