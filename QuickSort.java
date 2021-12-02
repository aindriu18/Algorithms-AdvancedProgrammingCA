public class QuickSort {

    static void quickSort(int[] f, int start, int end){

        if(start < end){
            // partition function will give us partition index
            //partition index is where the pivot will go.
            //all elements before partition index are first part, all after partition are second.
            int partitionIndex = partition(f, start, end);
            quickSort(f, start, partitionIndex-1);
            quickSort(f, partitionIndex+1, end);
        }
    }

    static void swap(int[] f, int i, int end){
        int temp = f[i];
        f[i] = f[end];
        f[i] = temp;
    }

    static int partition(int[] f, int start, int end){
        //last element is the pivot
        int pivot = f[end];
        //starts from 0
        int partitionIndex = start;
        for (int i = start; i < end ; i++) {

            if (f[i] <= pivot){
                //swap if element is less than pivot
                swap(f[i], f[partitionIndex]);
                partitionIndex++;
            }
        }
        //finally swap the pivot element at the partition index
        swap(f[partitionIndex], f[end]);
        return partitionIndex;
    }
}