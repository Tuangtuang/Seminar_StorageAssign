import java.util.Comparator;

public class CompareAddress implements Comparator<PCB> {
    @Override
    public int compare(PCB p1, PCB p2) {
        // TODO Auto-generated method stub
        if(p1.address>p2.address){
            return 1;
        }
        else {
            return -1;
        }
    }

}
