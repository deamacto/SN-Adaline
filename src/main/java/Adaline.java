public class Adaline {

    double w1;
    double w2;
    double alpha;
    double wTheta;
    double errorSquared;

    public Adaline(double w1, double w2, double alpha, double wTheta) {
        this.w1 = w1;
        this.w2 = w2;
        this.alpha = alpha;
        this.wTheta = wTheta;
        errorSquared = 0;
    }

    public void learn(Input input) {
        double sum = input.x1 * w1 + input.x2 * w2 + 1 * wTheta;
        double delta = input.d - sum;
        errorSquared += delta * delta;

        w1 = w1 + alpha * delta * input.x1;
        w2 = w2 + alpha * delta * input.x2;
        wTheta = wTheta + alpha * delta;
    }
}
