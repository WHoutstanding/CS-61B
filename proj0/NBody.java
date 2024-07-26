public class NBody {

    public static double readRadius(String path) {
        In in = new In(path);
        int numbers = in.readInt();
        double r = in.readDouble();
        return r;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int numbers = in.readInt();
        double r = in.readDouble();

        Planet[] p = new Planet[numbers];
        for (int i = 0; i < numbers; i++) {
            p[i] = new Planet(in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readString());
        }
        return p;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String Path = args[2];

        double radius = NBody.readRadius(Path);
        Planet[] p = NBody.readPlanets(Path);

        String imageToDraw = "./images/starfield.jpg";

        double t = 0;
        while (t < T) {
            double[] xForces = new double[p.length];
            double[] yForces = new double[p.length];

            for(int i = 0; i < p.length; i++) {
                Planet tmp = p[i];
                xForces[i] = tmp.calcNetForceExertedByX(p);
                yForces[i] = tmp.calcNetForceExertedByY(p);
            }

            for(int i = 0; i < p.length; i++) {
                Planet tmp = p[i];
                tmp.update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, imageToDraw);

            for (int i = 0; i < p.length; i++) {
                p[i].draw();
            }

            StdDraw.enableDoubleBuffering();
            StdDraw.show();

            StdDraw.pause(10);
            t = t + dt;
        }

        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}
