//This class is used to answer question 3 & 4 of the assignment. It is then called upon in the ReadFilmData main method
package Andrew_English_Code;

import Andrew_English_Code.ReadFilmData;

public class BinarySearchFilm {

    static int binarySearchRecursion(Film[] films, int first, int last, String filmInput) {
        //base case
        if (last >= first) {
            //first index set to 0. last set to end of array.
            int mid = (first + last) / 2;

            //if filmInput is mid, return mid
            if (films[mid].getTitle().equals(filmInput))
                return mid;
            //check if searchKey is on the left or the right
            if (films[mid].getTitle().compareTo(filmInput)>0)
                return binarySearchRecursion(films, first, mid - 1, filmInput);
            else
                return binarySearchRecursion(films, mid + 1, last, filmInput);
        }
        return -1;
    }
}
