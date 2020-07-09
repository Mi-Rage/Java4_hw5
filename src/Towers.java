import java.util.Arrays;
import java.util.Stack;

public class Towers {
    public static void main(String[] args){
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        Stack<Integer> third = new Stack<>();
        int volume = 30;
        // С 30 дисками я получил 1073741823 ходов и ждал прилично по времени.
        // Хотел попробовать с 64 дисками, но испугался что вызову конец света.

        // Надеваем диски на первый штырь
        for (int i = volume; i > 0; i--) {
            first.push(i);
        }

        // Поехали!!
        System.out.println("Start position:");
        printTower(first,second,third);
        moveDisk(first, second, third, volume);
        System.out.println("Finish position:");
        printTower(first,second,third);
        System.out.println("Перекладываний:" + count);


    }

    static int count = 0;
    private static void moveDisk(Stack<Integer> first, Stack<Integer> second, Stack<Integer> third, int volume) {
        if (volume > 0){
            moveDisk(first,third,second,volume - 1); // переносим набор из n−1 дисков на 2-й штырь
            count++;
            third.push(first.pop()); // переносим самый большой диск на 3-й штырь
            moveDisk(second,first,third,volume - 1); // переносим набор из n−1 дисков на 3-й штырь
        }
    }

    public static void printTower(Stack<Integer> first, Stack<Integer> second, Stack<Integer> third) {
        System.out.println("1:" + Arrays.toString(first.toArray()));
        System.out.println("2:" + Arrays.toString(second.toArray()));
        System.out.println("3:" + Arrays.toString(third.toArray()));
    }
}