public class Main {

    public static void main(String[] args) {
        int counter = 0;
        // write your code here
        for (Secret secret1 : Secret.values()) {
            if (secret1.name().startsWith("STAR")) counter++;
        }

        System.out.println(counter);
    }
}

// sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}
