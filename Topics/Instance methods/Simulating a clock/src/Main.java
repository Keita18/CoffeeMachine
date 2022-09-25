import java.util.Arrays;

class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        minutes++;
        if (minutes > 59) {
            hours++;
            if (hours > 12) hours = 1;
            minutes = 0;
        }
    }

    public static void main(String[] args) {
        String s = new String("Abu");
        int[] a = {1};
        nameC(s, a);
        System.out.println(s);
        System.out.println(Arrays.toString(a));

    }

    static void nameC(String s, int ...a) {
        s += " Keita";
        a[0] = 200;
    }
}