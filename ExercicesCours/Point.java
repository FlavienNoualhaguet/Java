package ExercicesCours;

public class Point {

    private int x, y;

    Point(int i, int j) {
        this.x = i;
        this.y = j;
    }

    public void translater(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }

    @Override
    public String toString() {
        return "Point : " + x + "," + y;
    }
}