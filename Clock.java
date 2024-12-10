class Jam {
    int h= 0;
    int m= 0;
    int s= 0;

    public Jam(int h,int m, int s){
        this.h = h;
        this.m = m ;
        this.s = s;
    }

    public boolean isFaldi(){
        boolean valid = true;
        
        if ((this.h<0) || (this.h>23)) {
            valid= false;
        }
        
        return valid;
    }
}