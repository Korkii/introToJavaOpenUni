public class Space {
    int _len ;
    int[] _UFOPos = new int[2];
    public Space(int n,int i, int j){
        _len = n;
        _UFOPos[0] = i;
        _UFOPos[1] = j;
    }
    public int getSize(){
        return _len;
    }
    public int[] ask(int i, int j){
        int x, y;
        if(i == _UFOPos[0])
            x = 0;
        else if(_UFOPos[0] > i)
            x = 1;
        else
            x = -1;
        
        if(j == _UFOPos[1])
            y = 0;
        else if(_UFOPos[1] > j)
            y = 1;
        else
            y = -1;

        int[] a = {x,y};

        return a;

    }
    
}
