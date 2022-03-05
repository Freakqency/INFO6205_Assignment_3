package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {

    public static int count(int n) {
        int edges = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n, true);
        Random rand = new Random();
        while(uf.components() > 1) {
            int p = rand.nextInt(n);
            int q = rand.nextInt(n);
            if (!uf.connected(p, q)) uf.union(p, q);
            edges++;
        }
        return edges;
    }

    public double mean(int[] edges) {
        double meanValue = 0.0;
        for (int i = 0; i < edges.length; i++) meanValue += edges[i];
        return meanValue / edges.length;
    }

    public static void main(String args[]){
        int[] n = new int[13];
        n[0] = 100;
        for (int i = 1; i < 13; i++) n[i] = n[i - 1] * 2;
        int trials = 1000;
        int[] edges = new int[trials];
        UFClient ufc = new UFClient();
        System.out.println("N            \t\t\tM" );
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < trials; j++) edges[j] = count(n[i]);
//            System.out.println(n[i] + "\t" + 0.5 * n[i] * Math.log(n[i]) + "\t" + ufc.mean(edges) + "\t");
            System.out.println(n[i] + "           \t\t\t" + ufc.mean(edges));
        }
    }
}
