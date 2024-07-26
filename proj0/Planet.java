public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    public Planet (double xP, double yP, double xV,
                    double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = "./images/" + img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double square_x = (p.xxPos - xxPos) * (p.xxPos - xxPos);
        double square_y = (p.yyPos - yyPos) * (p.yyPos - yyPos);
        double r = Math.sqrt(square_x + square_y);
        return r;
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        double f = G * mass * p.mass / (r * r);
        return f;
    }

    public double calcForceExertedByX(Planet p) {
        double f_x = 0;
        Planet tmp = p;
        if (!this.equals(tmp)) {
            double r = calcDistance(tmp);
            double dx = tmp.xxPos - xxPos;
            double f = calcForceExertedBy(tmp);
            f_x += f * dx / r;
        }
        return f_x;
    }

    public double calcForceExertedByY(Planet p) {
        double f_y = 0;
        Planet tmp = p;
        if (!this.equals(tmp)) {
            double r = calcDistance(tmp);
            double dy = tmp.yyPos - yyPos;
            double f = calcForceExertedBy(tmp);
            f_y += f * dy / r;
        }
        return f_y;
    }


    public void update(double dt, double fX, double fY) {
        double a_x = fX / mass, a_y = fY / mass;
        xxVel += a_x * dt;
        yyVel += a_y * dt;

        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public double calcNetForceExertedByX(Planet p[]) {
        double f_x = 0;
        for (int i = 0; i < p.length; i++) {
            Planet tmp = p[i];
            if (!this.equals(tmp)) {
                double f = calcForceExertedByX(tmp);
                f_x += f;
            }
        }
        return f_x;
    }

    public double calcNetForceExertedByY(Planet p[]) {
        double f_y = 0;
        for (int i = 0; i < p.length; i++) {
            Planet tmp = p[i];
            if (!this.equals(tmp)) {
                double f = calcForceExertedByY(tmp);
                f_y += f;
            }
        }
        return f_y;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }
}
