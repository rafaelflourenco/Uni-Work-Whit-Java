class Ponto {

    double x, y;

    Ponto(double x, double y){
        checkFirstQuadrant(x,y);
    }
    void checkFirstQuadrant (double x, double y){
        if(x >= 0 && y >= 0){
            this.x = x;
            this.y = y;
        }
        else{
            System.out.println("iv");
            System.exit(0);
        }

    }
    double dist (Ponto p) {

        double dx = x - p.x;

        double dy = y - p.y;

        return Math.sqrt(dx*dx + dy*dy);

    }


}