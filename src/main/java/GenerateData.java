import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateData implements Serializable {
    ArrayList<Input> data = new ArrayList<>();

    public GenerateData() {
        data.add(new Input(1, 1, 1));
        data.add(new Input(1, -1, 0));
        data.add(new Input(-1, 1, 0));
        data.add(new Input(-1, 0, 0));

        while(data.size() <= 50) {
            Input input = generateInput();

            if(input != null) {
                data.add(input);
            }
        }
    }

    private Input generateInput() {
        double x1 = Math.random() * 2 - 1;
        double x2 = Math.random() * 2 - 1;

        if(x1 > 0.6 && x2 > 0.6) {
            return new Input(x1, x2, 1);
        } else if(x1 > 0.6 && x2 < -0.6) {
            return new Input(x1, x2, -1);
        } else if(x1 < -0.6 && x2 > 0.6) {
            return new Input(x1, x2, -1);
        } else if(x1 < -0.6 && x2 < -0.6) {
            return new Input(x1, x2, -1);
        } else {
            return null;
        }
    }
}
