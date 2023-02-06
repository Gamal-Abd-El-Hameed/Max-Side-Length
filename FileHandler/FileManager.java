package FileHandler;

import MaximumSideLength.Solver;

import java.awt.*;
import java.io.*;
import java.util.*;

public class FileManager {
    public void controller(String inputPath, String outputPath) throws FileNotFoundException {
        writeFile(outputPath, readFile(inputPath));
    }
    public ArrayList<Integer> readFile(String filePath) throws FileNotFoundException {
        ArrayList<Integer> ans = new ArrayList<>();
        Solver solver = new Solver();
        Scanner scanner = new Scanner(new File(filePath));
        Point[] points;
        int n, i, x, y;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            points = new Point[n];
            for (i = 0; i < n; ++i) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                points[i] = new Point(x, y);
            }
            ans.add(solver.findMaximumSideLength(points));
        }
        scanner.close();
        return ans;
    }

    public void writeFile(String filePath, ArrayList<Integer> arr) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for(int x: arr)
                fileWriter.write(x + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
