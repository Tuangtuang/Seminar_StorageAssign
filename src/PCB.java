public class PCB {
    public int Id;
    public int size;
    public int address;
    PCB(int x,int y,int z){
        Id=x;
        size=y;
        address=z;
    }
    public int getSize(){
        return size;
    }

}
