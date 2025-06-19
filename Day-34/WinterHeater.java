import java.util.*;

public class WinterHeater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] houseInput = sc.nextLine().split(" ");
        int[] houses = new int[houseInput.length];
        for (int i = 0; i < houseInput.length; i++) {
            houses[i] = Integer.parseInt(houseInput[i]);
        }

        String[] heaterInput = sc.nextLine().split(" ");
        int[] heaters = new int[heaterInput.length];
        for (int i = 0; i < heaterInput.length; i++) {
            heaters[i] = Integer.parseInt(heaterInput[i]);
        }

        Arrays.sort(heaters);

        int maxRadius = 0;

        for (int house : houses) {
            int minDistance = Integer.MAX_VALUE;

            int pos = Arrays.binarySearch(heaters, house);

            if (pos >= 0) {
                minDistance = 0;
            } else {
                pos = -(pos + 1);

                if (pos < heaters.length) {
                    minDistance = Math.min(minDistance, heaters[pos] - house);
                }

                if (pos > 0) {
                    minDistance = Math.min(minDistance, house - heaters[pos - 1]);
                }
            }

            maxRadius = Math.max(maxRadius, minDistance);
        }

        System.out.println(maxRadius);
    }
}
