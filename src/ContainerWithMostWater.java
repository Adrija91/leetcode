class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxWater = 0;
        while(start<end)
        {
            int width = end-start;
            int ht = Math.min(height[start],height[end]);
            int vol = width*ht;
            maxWater = Math.max(maxWater,vol);
            if(height[start]<height[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height)); // Output: 49
    }
}

//time=o(n) space o(1)