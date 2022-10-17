import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Input> data = deserializeData();
        for(int i = 0; i < 10; i++) {
            learn(data);
        }
    }

    public static void learn(ArrayList<Input> data) {
        double w1 = ThreadLocalRandom.current().nextDouble(-0.05, 0.05);
        double w2 = ThreadLocalRandom.current().nextDouble(-0.05, 0.05);
        double wTheta = ThreadLocalRandom.current().nextDouble(-0.05, 0.05);
        double maxError = 0.27;
        Adaline adaline = new Adaline(w1, w2, 0.01, wTheta);
        boolean hasLearned = false;
        int generationCounter = 0;

        while(!hasLearned) {
            adaline.errorSquared = 0;
            generationCounter++;
            for(Input input : data) {
                adaline.learn(input);
            }

            if(adaline.errorSquared / data.size() < maxError) {
                hasLearned = true;
            }
        }

        System.out.print(generationCounter);
        System.out.println("\t" + adaline.errorSquared / data.size());
    }

    public static void serializeData(GenerateData data) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            outputStream.writeObject(data);
        } catch(Exception e) {
            return;
        }
    }

    public static ArrayList<Input> deserializeData() {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.bin"))) {
            GenerateData data = (GenerateData) inputStream.readObject();
            return data.data;
        } catch(Exception e) {
            return null;
        }
    }
}
