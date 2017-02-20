import java.util.Random;

public class Tools {

    int randomBetweenInt(int min, int max) {
        Random rn = new Random();
        int answer = rn.nextInt(max) + min;
        return answer;
    }
}
