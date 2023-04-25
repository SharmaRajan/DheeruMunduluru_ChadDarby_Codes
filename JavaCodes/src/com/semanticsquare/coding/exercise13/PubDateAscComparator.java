
/**
 * @Author: Rajan Kumar Sharma
 * Date: 24/04/2023
 */

package com.semanticsquare.coding.exercise13;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator {

    public PubDateAscComparator(){}

    @Override
    public int compare(Object obj1, Object obj2) {

        int yearBook1 = ((Book)obj1).getYear();
        int yearBook2 = ((Book)obj2).getYear();

        String titleBook1 = ((Book)obj1).getTitle();
        String titleBook2 = ((Book)obj2).getTitle();

        int compareVal = 0;

        if(yearBook1 < yearBook2) {
            return compareVal = -1;
        }else if(yearBook1 > yearBook2) {
            return compareVal = 1;
        }

//			if(titleBook1.compareTo(titleBook2) < 1) {
//				compareVal = -1;
//			}else if(titleBook1.compareTo(titleBook2) > 1) {
//				compareVal = 1;
//			}
//				return compareVal;
//

        return ((Book)obj1).getTitle().compareTo(((Book)obj2).getTitle());
//		return compareVal;
    }

}
