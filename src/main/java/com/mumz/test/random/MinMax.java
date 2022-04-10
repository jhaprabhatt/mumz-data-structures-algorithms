package com.mumz.test.random;

public class MinMax<N extends Integer> {

    private N min, max;

    public N getMin(){
        return min;
    }

    public N getMax() {
        return max;
    }

    public void add(N added){
        if(min == null || added.doubleValue() < min.doubleValue()){
            min = added;
        }
        if(max == null || added.doubleValue() < max.doubleValue()){
            max = added;
        }
    }
}
