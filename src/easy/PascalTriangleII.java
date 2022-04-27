package easy;

import java.util.*;

//119. Pascal's Triangle II
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> rows = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        int sum;

        rows.add(List.of(1));
        rows.add(List.of(1,1));

        for(int i = 2; i<=rowIndex; i++) {
            values.add(1);
            for(int j = 1; j < rows.get(i-1).size(); j++) {
                sum = rows.get(i -1).get(j - 1) + rows.get(i-1).get(j);
                values.add(sum);
            }
            values.add(1);
            rows.add(values);
            values = new ArrayList<>();
        }
        System.out.println(rows.size());
        return rows.get(rowIndex);
    }


    /*
    Optimal solution
     */

    public List<Integer> getRowOptimal(int rowIndex) {

        List<Integer> row= new ArrayList<>();
        row.add(1);
        for(int i=0; i < rowIndex; i++){
            for(int j=i; j>0; j--) {
                row.set(j, row.get(j-1)+row.get(j));
            }
            row.add(1);
        }
        return row;
    }
}
