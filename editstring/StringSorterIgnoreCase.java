package editstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringSorterIgnoreCase {

    public void sortAlphabeticallyIgnoreCase(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
    }


}

