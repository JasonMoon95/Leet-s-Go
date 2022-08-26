class Solution {
    static List<Integer> rn = new ArrayList<Integer>();

    static int arrToInt(int[] arr, int depth)
    {
        int res=0;
        for(int i=0; i<depth; i++)
        {
            res+=arr[depth-i-1]*Math.pow(10,i);
        }
        //System.out.print(res+"\n");
        return res;
    }
    static boolean permutation(int[] arr, int depth, int n) {
        if(arr[0] == 0) return false;
        if (depth == n) {
            if(isPowerOf2(arrToInt(arr, depth))) return true;
            return false;
        }
     
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            if(permutation(arr, depth + 1, n)) return true;
            swap(arr, depth, i); //원래대로 다시 스왑
        }
        return false;
    }
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static boolean isPowerOf2(int n)
    {
        return (n&(n-1))==0;
    }
    
    public boolean reorderedPowerOf2(int n) {
        String temp = Integer.toString(n);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return permutation(newGuess, 0, temp.length());
    }
}