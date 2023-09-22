// some errors in code. need major modification. 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len2 < len1) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;

            int t = len2; 
            len2 = len1;
            len1 = t;
        }

        int total = len1 + len2;
        int half = (int) total / 2;

        int l = 0, r = len1 - 1;

        while (true) {
            int i = (int) (l + r) / 2;  // A
            int j = half - i - 2;       // B

            double Aleft = (i>=0) ? nums1[i] : Double.MIN_VALUE; 
            double Aright = ((i+1) < len1) ? nums1[i+1] : Double.MAX_VALUE;
            double Bleft = (j >= 0) ? nums2[j] : Double.MIN_VALUE;
            double Bright = ((j+1) < len2) ? nums2[j+1] : Double.MAX_VALUE;

            // partition is correct 
            if ((Aleft <= Bright) && (Bleft <= Aright)) {
                // odd 
                if ((total & 1) == 1) {
                    return Math.min(Aright, Bright);
                } else {
                    // even 
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
                }
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        
    }
}