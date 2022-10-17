import java.io.Serializable;

public class Input implements Serializable {
    double x1;
    double x2;
    int d;

    public Input(double x1, double x2, int d) {
        this.x1 = x1;
        this.x2 = x2;
        this.d = d;
    }
}
