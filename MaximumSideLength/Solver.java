package MaximumSideLength;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solver {
    public int findMaximumSideLength(Point[] X) {
        Point[] Y = X.clone();
        Arrays.sort(X, (p1, p2) -> {
            if (p1.x == p2.x)
                return (p1.y - p2.y);
            return (p1.x - p2.x);
        });
        Arrays.sort(Y, (p1, p2) -> {
            if (p1.y == p2.y)
                return (p1.x - p2.x);
            return (p1.y - p2.y);
        });
        return findMaximumSideLength(X, Y, 0, X.length - 1);
    }

    private int findMaximumSideLength(Point[] X, Point[] Y, int low, int high) {
        int n = high - low + 1;
        if(n == 2)
            return calculateSideLength(X[low], X[low + 1]);
        if(n == 3) {
            return Math.min(
                    calculateSideLength(X[low], X[low + 1]),
                    Math.min(
                            calculateSideLength(X[low + 1], X[low + 2]),
                            calculateSideLength(X[low], X[low + 2])
                    )
            );
        }
        int mid = low + (high - low) / 2;
        int n1 = mid - low + 1, n2 = high - mid;
        Point smallestP = X[low], midP = X[mid];
        int midX = midP.x;
        Point[] YL = new Point[n1];
        Point[] YR = new Point[n2];
        int i = 0, j = 0, pointsOnTheDividingLine = 0;
        for(int k = mid; k >= low; --k) {
            if (isInTheDividingLine(X[k], midP))
                ++pointsOnTheDividingLine;
            else
                break;
        }
        for(Point p: Y) {
            if(isInLeft(p, smallestP, midP))
                YL[i++] = p;
            else if(pointsOnTheDividingLine > 0 && isInTheDividingLine(p, midP)) {
                YL[i++] = p;
                --pointsOnTheDividingLine;
            }
            else
                YR[j++] = p;
        }
        int sigma = Math.min(
                findMaximumSideLength(X, YL, low, mid),
                findMaximumSideLength(X, YR, mid + 1, high)
        );
        ArrayList<Point> YDash = new ArrayList<>();
        for(Point p : Y)
            if(Math.abs(p.x - midX) <= sigma)
                YDash.add(p);
        for(i = 0; i < YDash.size() - 1; ++i)
            for(j = i + 1; j <= i + 7 && j < YDash.size(); ++j)
                sigma = Math.min(sigma, calculateSideLength(YDash.get(i), YDash.get(j)));
        return sigma;
    }

    private int calculateSideLength(Point p1, Point p2) {
        return Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
    }

    private boolean isInLeft(Point p, Point low, Point mid) {
        return (p.x >= low.x && p.x < mid.x);
    }

    private boolean isInTheDividingLine(Point p, Point mid) {
        return (p.x == mid.x);
    }
}
