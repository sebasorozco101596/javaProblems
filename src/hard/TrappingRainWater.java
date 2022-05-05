package hard;

import java.util.ArrayList;

// 42. Trapping Rain Water
public class TrappingRainWater {
    public int trap(int[] height) {

        ArrayList<Integer> areas = new ArrayList<>();

        int left = 0;
        int right = 1;
        int water = 0;
        int cont = 0;

        if (height.length == 1) {
            return 0;
        }

        while (left < height.length && right < height.length) {

            System.out.println("Left = " + left + " Right = " + right);


            if (height[right] < height[left] && right < height.length - 1) {

                if (cont == 0) areas.add(height[left]);
                areas.add(height[right]);
                cont++;
                right++;
            } else {
                System.out.println("Left = " + left + " Right = " + right);
                if (areas.size() > 0) areas.add(height[right]);
                if (areas.size() > 2) {
                    water += calcWater(areas);
                    areas.clear();
                    left = right;
                    cont = 0;
                } else {
                    left++;
                }

                if (left < height.length - 2) {
                    right = left + 1;
                }
                else {
                    break;
                }
            }

        }

        return water;
    }

    public int calcWater(ArrayList<Integer> bars) {


        int left = 0;
        int right = bars.size() - 1;

        while (true) {

            if (right - 1 < 0) {
                return 0;
            }

            if (bars.get(right) > bars.get(right-1) ) {
                break;
            } else {
                bars.remove(right);
                right--;
            }
        }

        while (bars.get(left) > bars.get(right) && bars.size() > 3) {
            left++;
        }

        if (bars.get(left) < bars.get(right) && left >= 1) {
            System.out.println("GERRR");
            --left;
        }

        System.out.println("first = " + bars.get(left) + " of height, last = " + bars.get(right) + " of height");

        int maxBar = Math.min(bars.get(left), bars.get(right));
        System.out.println("min bar is between: " + bars.get(left) + ", " + bars.get(right));
        int area = maxBar * (bars.size() - 2 - left);
        System.out.println("bars size: " + bars.size() );
        int toMinus = 0;


        for (int i = left + 1; i < right; i++) {
            if (bars.get(i) > 0) {
                toMinus += bars.get(i);
            }
        }

        System.out.println(" Area is : " + area + " Minus: " + toMinus);
        System.out.println("------------------------------");
        return area - toMinus;
    }

    public int trapOptimal(int[] height) {
        // time : O(n)
        // space : O(1)
        if (height.length==0) return 0;
        int left = 0, right = height.length-1;
        int leftMax=0, rightMax=0;
        int ans = 0;
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]);
                left++;
            } else {
                ans += Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return ans;
    }
}
