import java.util.Scanner;

public class MovementSegmentCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String log = scanner.nextLine();
        scanner.close();

        int segments = countMovementSegments(log);
        System.out.println(segments);
    }

    public static int countMovementSegments(String log) {
        int segments = 0;
        boolean inSegment = false;

        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '1') {
                if (!inSegment) {
                    segments++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }

        return segments;
    }
}
