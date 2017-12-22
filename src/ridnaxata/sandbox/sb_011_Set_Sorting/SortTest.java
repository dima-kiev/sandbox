package ridnaxata.sandbox.sb_011_Set_Sorting;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) {

        Set<Point> points = new HashSet<>();
        points.add(new Point(9, 0));
        points.add(new Point(1, 1));
        points.add(new Point(5, 6));
        points.add(new Point(3, 3));
        points.add(new Point(2, 7));
        points.add(new Point(1, 8));
        points.add(new Point(6, 1));


        Set<Point> sortedPoints = points
                                    //.stream()
                                    .parallelStream()
                                    .sorted(Comparator.comparing(Point::getX))
                                    .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println();

    }

}
