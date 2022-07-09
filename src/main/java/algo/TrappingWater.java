package algo;

public class TrappingWater {
    int totalwater=0;
    //Optimal solution
    public int trapewater (int heights[]) {
        int left=0, right= heights.length-1,maxleft=0,maxRight=0;
        while(left < right) {
            if(heights[left] <= heights[right]) {
                if(heights[left] >= maxleft) {
                    maxleft = heights[left];
                }else {
                    totalwater = totalwater + maxleft - heights[left];
                }
                left++;
            }else {
                if(heights[right] >= maxRight) {
                    maxRight = heights[right];
                }else {
                    totalwater = totalwater + maxRight-heights[right];
                }
                right--;
            }
        }

        return totalwater;
    }


//BruteForce solution in java script
      /*const elevationArray = [0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2]

            const getTrappedRainwater = function(heights) {
        let totalWater = 0;

        for(let p = 0; p < heights.length; p++) {
            let leftP = p, rightP = p, maxLeft = 0, maxRight = 0;

            while(leftP >= 0) {
                maxLeft = Math.max(maxLeft, heights[leftP]);
                leftP--;
            }

            while(rightP < heights.length) {
                maxRight = Math.max(maxRight, heights[rightP]);
                rightP++;
            }

    const currentWater = Math.min(maxLeft, maxRight) - heights[p];

            if(currentWater >= 0) {
                totalWater += currentWater;
            }
        }

        return totalWater;
    }

console.log(getTrappedRainwater(elevationArray));*/
}
