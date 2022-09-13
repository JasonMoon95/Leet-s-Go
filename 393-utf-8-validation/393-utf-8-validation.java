import java.util.ArrayList; 

class Solution {
    static String DecimalToBinary(int number) {
        String res = new String();
        // an array which will store the binary number
        int[] Binary_Number = new int[1000];
        int x = 0;
        while (number > 0) {
            // store the remainder in the array
        	Binary_Number[x] = number % 2;
            number = number / 2;
            x++;
        }
        // print the final array in reverse order
        for (int y = 7; y >= 0; y--) res = res + Binary_Number[y];
        return res;
    }

    public boolean validUtf8(int[] data) {
        ArrayList<String> binaryData = new ArrayList<>();
        for(int i=0; i<data.length; i++)
        {
            binaryData.add(DecimalToBinary(data[i]));
        }

        int idx = 0;
        int cnt;
        while(idx < binaryData.size())
        {
            cnt = 0;
            //System.out.println(binaryData.get(idx));
            for(int j=0; j<binaryData.get(idx).length(); j++)
            {
                if(binaryData.get(idx).charAt(j) == '1') cnt++;
                else if(binaryData.get(idx).charAt(j) == '0') break;
            }
            if(idx+cnt-1 >= binaryData.size() || cnt == 1 || cnt >= 5) return false;
            if(cnt == 0) idx++;
            for(int j=0; j<cnt-1; j++)
            {
                if(binaryData.get(idx+j+1).charAt(0) != '1' || 
                   binaryData.get(idx+j+1).charAt(1) != '0')
                {
                    return false;
                }
            }
            idx += cnt;
        }

        return true;
    }
}