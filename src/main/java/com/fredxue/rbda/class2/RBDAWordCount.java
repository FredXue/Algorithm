package com.fredxue.rbda.class2;

import java.util.*;
import java.io.*;

/**
 * Created by fredxue on 19/09/2017.
 */


public class RBDAWordCount {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> wcMap = new LinkedHashMap<>();
        wcMap.put("hackathon", 0);
        wcMap.put("Dec", 0);
        wcMap.put("Chicago", 0);
        wcMap.put("Java", 0);
        File file = new File("/Users/fredxue/Workspace/project/Algorithm/resources/rbda/wc_input");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().toLowerCase();
            for(Map.Entry<String, Integer> entry : wcMap.entrySet()) {
                if (line.contains(entry.getKey().toLowerCase())) {
                    wcMap.put(entry.getKey(), entry.getValue()+1);
                }
            }

        }
        for(Map.Entry<String, Integer> entry : wcMap.entrySet()) {
            System.out.printf("%s %d%n", entry.getKey(), entry.getValue());
        }
        sc.close();

    }
}