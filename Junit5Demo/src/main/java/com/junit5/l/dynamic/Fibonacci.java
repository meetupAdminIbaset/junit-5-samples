package com.junit5.l.dynamic;

public class Fibonacci {
	public static int compute(int n) {
        int t1 = 0, t2 = 1,t3=0;
        for (int i = 1; i <= n; ++i)
        {
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }
        return t1;
    }
}