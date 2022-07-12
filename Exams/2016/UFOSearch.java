public class UFOSerach {
    public static int[] findUFO(Space sp){
        int butC =0 , butR = 0, topC = sp.getSize()-1, topR = sp.getSize() -1, midC = 0,midR =0;

        while(butC <= topC && butR <= topR){
            midC = (butC + topC)/2;
            midR = (butR + topR)/2;
            int[] tempAsk = sp.ask(midC, midR);


            if(tempAsk[0] == 0 && tempAsk[1] ==0){
                butC = topC+1;
                butR = topR+1;
            } else {
                if(tempAsk[0] == 1)
                    butC = midC +1;
                else if(tempAsk[0] == -1) 
                    topC = midC -1;

                if(tempAsk[1] == 1)
                    butR = midR +1;
                else if( tempAsk[1] == -1)
                    topR = midR -1;
            }

        }
        int[] loc = {midC,midR};
        return loc;
    }

    public static boolean isPy(int[] arr){
        int a,b ,c = arr.length-1, sumAB=0;

        for(int i = arr.length-2; i > 0; i--){
            a = 0;
            b = i;
            sumAB = arr[a] +  arr[b];
            while(a < b && sumAB <= arr[c]){
                if(sumAB == arr[c])
                    return true;
                else
                    a++;
                sumAB = arr[a] +  arr[b];
            }
            c--;

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,16,25,36,81,144,167,196};
        System.out.println(isPy(arr));
    }
    
}
