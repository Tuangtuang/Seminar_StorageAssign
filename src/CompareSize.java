import java.util.Comparator;

public class CompareSize implements Comparator<PCB> {
    @Override
    public int compare(PCB p1, PCB p2) {
        // TODO Auto-generated method stub
        if(p1.getSize()>p2.getSize()){
            return 1;
        }
        else {
            return -1;
        }
    }

}
