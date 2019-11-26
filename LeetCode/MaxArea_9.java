public class MaxArea_9 {

//TO-DO more optimal solution
    public int maxArea(int[] height) {
        int maxHeight = 0;
        int maxArea = 0;
        for(int i=0; i<height.length; i++){
            if(height[i]<=maxHeight) continue;
            maxHeight = height[i];
            for(int j=i+1; j<height.length; j++){
                int area = (j-i) * Math.min(height[i], height[j]);
                if(maxArea<area){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
