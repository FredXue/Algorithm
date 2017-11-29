package com.fredxue.LeetCode;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.hadoop.io.Text;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SixEightSeven {
    int ans = 0;
    public int solution(int[] A, int[] E) {
        // write your code in Java SE 8
        TreeNode[] nodes = new TreeNode[A.length];
        boolean[] visited = new boolean[A.length];
        for(int i = 0; i < A.length; i++) {
            nodes[i] = new TreeNode(i, A[i]);
        }
        for(int i = 0; i < A.length-1; i++) {
            nodes[E[i*2]-1].adj.add(nodes[E[i*2+1]-1]);
            nodes[E[i*2+1]-1].adj.add(nodes[E[i*2]-1]);
        }
        dfs(nodes[0], visited);

        return ans;
    }

    public int dfs(TreeNode node, boolean[] visited) {
        visited[node.key] = true;
        int biggest = 0, bigger = 0;
        for(int i = 0; i<node.adj.size(); i++) {
            TreeNode child = node.adj.get(i);
            if(!visited[child.key]) {
                int len =  dfs(child, visited);
                if(child.val == node.val) {
                    len++;
                    if(len >= biggest) {
                        bigger = biggest;
                        biggest = len;
                    } else if(len >= bigger) {
                        bigger = len;
                    }
                }
            }
        }
        ans = Math.max(ans, biggest+bigger);
        return biggest;
    }



}

class TreeNode {
    int val;
    int key;
    List<TreeNode> adj;
    public TreeNode(int key, int v) {
        this.key = key;
        this.val = v;
        adj = new ArrayList<TreeNode>();
    }
}