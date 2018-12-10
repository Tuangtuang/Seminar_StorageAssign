import java.util.ArrayList;

public class Assign {
    public ArrayList<PCB> process=new ArrayList<PCB>();
    public ArrayList<PCB> FreeProcess=new ArrayList<PCB>();
    Assign(){
        FreeProcess.add(new PCB(1,32,100));
        FreeProcess.add(new PCB(2,10,150));
        FreeProcess.add(new PCB(3,5,200));
        FreeProcess.add(new PCB(4,218,220));
        FreeProcess.add(new PCB(5,96,530));

        process.add(new PCB(1,50,50));
        process.add(new PCB(2,18,132));
        process.add(new PCB(3,40,160));
        process.add(new PCB(4,15,205));
        process.add(new PCB(5,92,438));
        process.add(new PCB(6,24,626));
    }

}
