package JPMorgan_Internship_OA;

import java.util.Arrays;
import java.util.HashSet;

public class getTriangleArea {
    public static int solution(int[] x, int[] y) {
        return Math.abs(x[0] * (y[1] - y[2]) + x[1] * (y[2] - y[0]) + x[2] * (y[0] - y[1])) / 2;
    }
}
