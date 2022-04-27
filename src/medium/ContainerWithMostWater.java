package medium;

// 11. Container With Most Water
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        return calcMaxArea(height, 0,height.length-1);
    }

    public int calcMaxArea(int[] height,int start, int end)  {

        if (start > end) {
            return 0;
        }

        System.out.println("Start: " + height[start] + ", End: " + height[end]);

        int mid = start + (end - start) / 2;
        int area;
        int areaY = Math.min(height[start],height[end]);
        int areaX = end - start;
        int thisArea = areaY * areaX;
        area = Math.max(thisArea, calcMaxArea(height,++start, mid));
        area = Math.max(area, calcMaxArea(height,++mid, end));

        return area;
    }


    // O(n)
    public int maxAreaOptimal(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    // O(nˆ2)
    public int maxAreaOptimalTwo(int[] height) {
        int maxVol = 0;
        int left = 0, right = height.length - 1;
        while(right > left){

            int minH = Math.min(height[left], height[right]);
            maxVol = Math.max(maxVol, (right - left) * minH);
            while (height[left] <= minH && left < right) left += 1;
            while (height[right] <= minH && left < right) right -= 1;

        }
        return maxVol;
    }


}
