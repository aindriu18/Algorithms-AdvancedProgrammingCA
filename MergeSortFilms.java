//This class is used to answer question 1 & 2 of the assignment. It is then called upon in the ReadFilmData main method

package Andrew_English_Code;

public class MergeSortFilms {

    //left and upper B and indecies within array
    //left will be 0, right will be size of array - 1.
    static void mergeSort(Film[] films, int left, int right){

        if (left + 1 < right){
            //lower B 0, upper b size of array/2
            int mid = (left + right)/2;
            ///recursion
            //start at 0 until middle of array
            mergeSort(films, left, mid);
            //start from mid to end of array
            mergeSort(films, mid, right);

            merge(films, left, mid, right);
        }
    }
    static void merge(Film[] f, int left, int mid, int right){

        int i = left;
        int j = mid;
        //temp array stores all sorted elements - do not want to store these in Film
        Film temp [] = new Film[right - left];
        //keeps track of how many items we added into temp array - we then say t++
        int t = 0;

        while(i < mid && j < right){
            //checking elements from first half, then the second half. i is left, j is mid
            if (f[i].getTitle().compareTo(f[j].getTitle()) <= 0){

                temp[t] = f[i]; i++; t++;
            }
            else{
                temp[t] = f[j]; j++; t++;
            }
        }
        while(i < mid){
            temp[t] = f[i]; i++; t++;
        }
        while(j < right){
            temp[t] = f[j]; j++; t++;
        }

        //copy temp back to Film
        i = left;
        t=0;

        //run loop to copy temp array back to Film which is now sorted.
        while (t < temp.length){
            f[i] = temp[t];
            i++; t++;
        }
    }
}
