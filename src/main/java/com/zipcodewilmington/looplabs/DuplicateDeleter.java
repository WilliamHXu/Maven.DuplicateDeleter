package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected final T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
        Arrays.sort(array);
    }

    public T[] removeDuplicates(int maxNumberOfDuplications){
        T[] result = array.clone();
        for (int i = maxNumberOfDuplications; i <= array.length; i++) {
            result = removeDuplicatesExactly(i, result);
        }
        return result;
    }
    
    public int countNumberOfOccurrences(T objectToEvaluate){
        int count = 0;
        for (T t: array) {
            if (t.equals(objectToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T[] removeDuplicatesExactly(int exactNumberOfDuplications, T[] arrayToSort){
        T[] clone = arrayToSort.clone();
        int resultIndex = 0;
        for(int i = 0; i < arrayToSort.length; i++){
            if(countNumberOfOccurrences(arrayToSort[i]) != exactNumberOfDuplications){
                clone[resultIndex++] = arrayToSort[i];
            }
        }
        return Arrays.copyOf(clone, resultIndex);
    }

    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return removeDuplicatesExactly(exactNumberOfDuplications, this.array);
    }
}
