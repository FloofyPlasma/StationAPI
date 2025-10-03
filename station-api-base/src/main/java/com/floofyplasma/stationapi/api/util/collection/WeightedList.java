package com.floofyplasma.stationapi.api.util.collection;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightedList<T> {
    private final List<T> objects = new ArrayList<>();
    private final IntList weights = new IntArrayList();
    private int maxWeight;

    public void add(T object, int weight) {
        objects.add(object);
        maxWeight += weight;
        weights.add(maxWeight);
    }
    
    public void addAll(WeightedList<T> list) {
        objects.addAll(list.objects);
        int start = weights.size();
        weights.addAll(list.weights);
        for (int i = start; i < weights.size(); i++) {
            weights.set(i, weights.getInt(i) + maxWeight);
        }
        maxWeight += list.maxWeight;
    }

    public void clear() {
        objects.clear();
        weights.clear();
        maxWeight = 0;
    }

    public T get(Random random) {
        if (maxWeight == 0 || objects.isEmpty()) return null;
        int weight = random.nextInt(maxWeight);
        for (int i = 0; i < objects.size(); i++) {
            if (weight < weights.getInt(i)) return objects.get(i);
        }
        return objects.get(0);
    }
    
    public boolean isEmpty() {
        return maxWeight == 0;
    }
}
