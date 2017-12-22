package task_02;

public class Shipping {

    private static final int LARGE_CAPACITY = 5;

    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {

        if ((availableLargePackages * LARGE_CAPACITY + availableSmallPackages) < items) return -1;

        int totalBoxes = 0;

        int neededLargeBoxes = items / LARGE_CAPACITY;
        int packagesForSmallBoxesLeft = items - neededLargeBoxes * LARGE_CAPACITY;

        if (availableLargePackages - neededLargeBoxes == 0) {
            totalBoxes = neededLargeBoxes;
        } else if (availableLargePackages - neededLargeBoxes > 0) {
             if (packagesForSmallBoxesLeft == 0) {
                 totalBoxes = neededLargeBoxes;
             } else {
                 totalBoxes = neededLargeBoxes + packagesForSmallBoxesLeft;
             }
        } else if (availableLargePackages - neededLargeBoxes < 0) {
            packagesForSmallBoxesLeft = items - availableLargePackages * LARGE_CAPACITY;
            totalBoxes = availableLargePackages + packagesForSmallBoxesLeft;
        }

        return totalBoxes;

    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}