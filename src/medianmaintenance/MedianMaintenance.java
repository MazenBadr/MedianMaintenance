/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianmaintenance;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

/**
 *
 * @author mazenbadr
 */
public class MedianMaintenance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        InputStream stream = ClassLoader.getSystemResourceAsStream("Median.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
        String line;
        int midSum = 0;
        try {
            line = buffer.readLine();
            int num1 = Integer.parseInt(line);
            line = buffer.readLine();
            int num2 = Integer.parseInt(line);
            midSum += num1;
            if (num1 < num2) {
                minHeap.add(num2);
                maxHeap.add(num1 * -1);
                midSum += num1;
            } else {
                minHeap.add(num1);
                maxHeap.add(num2 * -1);
                midSum += num2;
            }

            while ((line = buffer.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (number <= maxHeap.peek() * -1) {
                    maxHeap.add(number * -1);
                } else {
                    minHeap.add(number);
                }
                if (minHeap.size() + 1 < maxHeap.size()) {
                    minHeap.add(maxHeap.poll() * -1);
                } else if (maxHeap.size() + 1 < minHeap.size()) {
                    maxHeap.add(minHeap.poll() * -1);
                }

                if (minHeap.size() <= maxHeap.size()) {
                    midSum += maxHeap.peek() * -1;
                } else {
                    midSum += minHeap.peek();
                }
                
            }
        } catch (IOException ex) {
        }
        System.out.println(midSum%10000);
    }

}
