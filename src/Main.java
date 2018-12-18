import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
public class Main extends JFrame {
    public static MyJPanel panel=new MyJPanel();
    public static Assign blocks1=new Assign();//按照地址从小到大排的
    public static Assign blocks2=new Assign();
    public static Assign blocks3=new Assign();//按照大小从小到大排的
    public static Assign blocks4=new Assign();//按照大小从大到小排的
    public static JButton confirm=new JButton("分配");
    public static JButton recycle=new JButton("回收");
    public static JTextField recycleId=new JTextField();
//    public static JTextField BlockInput=new JTextField();
    public static JTextField CapacityInput=new JTextField();
    public static JLabel [][]FFLable=new JLabel[10][3];
    public static JTextField[]FFText=new JTextField[100];

    public static JLabel [][]NFLabel=new JLabel[10][3];
    public static JTextField[]NFText=new JTextField[100];

    public static JLabel [][]BFLabel=new JLabel[10][3];
    public static JTextField[]BFText=new JTextField[100];

    public static JLabel [][]WFLabel=new JLabel[10][3];
    public static JTextField[]WFText=new JTextField[100];
//    public static PCB apply=new PCB(-1,-1,-1);//初始化
    public static int countFFnum=6;
    public static int countNFnum=6;
    public static int countBFnum=6;
    public static int countWFnum=6;
    public static int NFcount=0;
    public static int reveive=-1;
    public static void main(String[] args){
        JFrame jFrame=new JFrame("动态分区分配");

        jFrame.setSize(1280,1600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel panel=new JPanel();
//        MyJPanel panel=new MyJPanel();
        placeComponent(panel);
        jFrame.add(panel);
        jFrame.setVisible(true);
//        jFrame.add(new MyJPanel(panel));
        actionHandler();
    }
    public static void placeComponent(MyJPanel panel){
        panel.setLayout(null);
        panel.setBackground(Color.white);
        JLabel Capacity=new JLabel("分区大小：");
        Capacity.setBounds(300,10,80,30);
        panel.add(Capacity);
//        JTextField CapacityInput=new JTextField();
        CapacityInput.setBounds(380,10,80,30);
        panel.add(CapacityInput);

        confirm.setBounds(500,10,80,30);
        panel.add(confirm);

        JLabel recycleBlock=new JLabel("分区号：");
        recycleBlock.setBounds(880,10,80,30);
        panel.add(recycleBlock);
//        JTextField recycleId=new JTextField();
        recycleId.setBounds(960,10,80,30);
        panel.add(recycleId);
        recycle.setBounds(1040,10,80,30);
        panel.add(recycle);


        JLabel FirstFit=new JLabel("首次适应算法");
        FirstFit.setBounds(80,40,100,30);
        panel.add(FirstFit);

        JLabel NextFit=new JLabel("循环首次适应算法");
        NextFit.setBounds(400,40,150,30);
        panel.add(NextFit);

        JLabel BestFit=new JLabel("最佳适应算法");
        BestFit.setBounds(720,40,100,30);
        panel.add(BestFit);

        JLabel WorstFit=new JLabel("最坏适应算法");
        WorstFit.setBounds(1040,40,100,30);
        panel.add(WorstFit);

        JLabel FFId=new JLabel("分区号");
        FFId.setBounds(20,80,50,30);
        panel.add(FFId);
        JLabel FFSize=new JLabel("区大小");
        FFSize.setBounds(100,80,50,30);
        panel.add(FFSize);
        JLabel FFAdd=new JLabel("首地址");
        FFAdd.setBounds(170,80,50,30);
        panel.add(FFAdd);

        JLabel NFId=new JLabel("分区号");
        NFId.setBounds(340,80,50,30);
        panel.add(NFId);
        JLabel NFSize=new JLabel("区大小");
        NFSize.setBounds(420,80,50,30);
        panel.add(NFSize);
        JLabel NFAdd=new JLabel("首地址");
        NFAdd.setBounds(490,80,50,30);
        panel.add(NFAdd);

        JLabel BFId=new JLabel("分区号");
        BFId.setBounds(660,80,50,30);
        panel.add(BFId);
        JLabel BFSize=new JLabel("区大小");
        BFSize.setBounds(740,80,50,30);
        panel.add(BFSize);
        JLabel BFAdd=new JLabel("首地址");
        BFAdd.setBounds(810,80,50,30);
        panel.add(BFAdd);

        JLabel WFId=new JLabel("分区号");
        WFId.setBounds(980,80,50,30);
        panel.add(WFId);
        JLabel WFSize=new JLabel("区大小");
        WFSize.setBounds(1060,80,50,30);
        panel.add(WFSize);
        JLabel WFAdd=new JLabel("首地址");
        WFAdd.setBounds(1130,80,50,30);
        panel.add(WFAdd);

        placeFF(panel);
        placeNF(panel);
        placeBF(panel);
        placeWF(panel);
    }

    public static void placeFF(MyJPanel panel){
        CompareAddress addInc=new CompareAddress();
        Collections.sort(blocks1.FreeProcess,addInc);//排序
//        JPanel pan=new JPanel();
//        pan.setBounds(20,110,200,520);
        for(int i=0;i<blocks1.FreeProcess.size();i++){
//            System.out.println(blocks1.FreeProcess.get(i).Id+"");
            JLabel temp1=new JLabel();
            temp1.setText(blocks1.FreeProcess.get(i).Id+"");
            temp1.setBounds(20,110+i*50,50,30);
            panel.add(temp1);
            FFLable[i][0]=temp1;
        }
        for(int i=0;i<blocks1.FreeProcess.size();i++){
//            System.out.println(blocks1.FreeProcess.get(i).size+"K");
            JLabel temp2=new JLabel();
            temp2.setText(blocks1.FreeProcess.get(i).size+"K");
            temp2.setBounds(100,110+i*50,50,30);
            panel.add(temp2);
            FFLable[i][1]=temp2;
        }
        for(int i=0;i<blocks1.FreeProcess.size();i++){
//            System.out.println(blocks1.FreeProcess.get(i).address+"K");
            JLabel temp3=new JLabel();
            temp3.setText(blocks1.FreeProcess.get(i).address+"K");
            temp3.setBounds(170,110+i*50,50,30);
            panel.add(temp3);
            FFLable[i][2]=temp3;
        }
//        panel.add(pan);

        for(int i=0;i<blocks1.process.size();i++){
//            System.out.println(blocks1.process.get(i).address+"K");
            JTextField container=new JTextField(blocks1.process.get(i).size+"K, "+blocks1.process.get(i).Id);
            container.setBounds(245,blocks1.process.get(i).address,70,blocks1.process.get(i).size);
            container.setBackground(Color.pink);
            panel.add(container);
            FFText[i]=container;
//            panel.add(FFText[i]);
        }
    }

    public static void placeNF(MyJPanel panel){
        CompareAddress addInc=new CompareAddress();
        Collections.sort(blocks2.FreeProcess,addInc);//排序
        for(int i=0;i<blocks2.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).Id+"");
            JLabel temp=new JLabel(blocks2.FreeProcess.get(i).Id+"");
            temp.setBounds(350,110+i*50,50,30);
            panel.add(temp);
            NFLabel[i][0]=temp;
        }

        for(int i=0;i<blocks2.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).size+"K");
            JLabel temp=new JLabel(blocks2.FreeProcess.get(i).size+"K");
            temp.setBounds(420,110+i*50,50,30);
            panel.add(temp);
            NFLabel[i][1]=temp;
        }

        for(int i=0;i<blocks2.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).size+"K");
            JLabel temp=new JLabel(blocks2.FreeProcess.get(i).address+"K");
            temp.setBounds(490,110+i*50,50,30);
            panel.add(temp);
            NFLabel[i][2]=temp;
        }

        for(int i=0;i<blocks2.process.size();i++){
            JTextField container=new JTextField(blocks2.process.get(i).size+"K, "+blocks2.process.get(i).Id);
            container.setBounds(565,blocks2.process.get(i).address,70,blocks2.process.get(i).size);
            container.setBackground(Color.pink);
            panel.add(container);
            NFText[i]=container;
        }
    }

    public static void placeBF(MyJPanel panel){
        CompareSize inc=new CompareSize();
        Collections.sort(blocks3.FreeProcess,inc);
        for(int i=0;i<blocks3.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).Id+"");
            JLabel temp=new JLabel(blocks3.FreeProcess.get(i).Id+"");
            temp.setBounds(670,110+i*50,50,30);
            panel.add(temp);
            BFLabel[i][0]=temp;
        }

        for(int i=0;i<blocks3.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).size+"K");
            JLabel temp=new JLabel(blocks3.FreeProcess.get(i).size+"K");
            temp.setBounds(740,110+i*50,50,30);
            panel.add(temp);
            BFLabel[i][1]=temp;
        }

        for(int i=0;i<blocks3.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).size+"K");
            JLabel temp=new JLabel(blocks3.FreeProcess.get(i).address+"K");
            temp.setBounds(810,110+i*50,50,30);
            panel.add(temp);
            BFLabel[i][2]=temp;
        }

        for(int i=0;i<blocks3.process.size();i++){
            JTextField container=new JTextField(blocks3.process.get(i).size+"K, "+blocks3.process.get(i).Id);
            container.setBounds(885,blocks3.process.get(i).address,70,blocks3.process.get(i).size);
            container.setBackground(Color.pink);
            panel.add(container);
            BFText[i]=container;
        }
    }

    public static void placeWF(MyJPanel panel){
        CompareSizeDec dec=new CompareSizeDec();
        Collections.sort(blocks4.FreeProcess,dec);
        for(int i=0;i<blocks4.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).Id+"");
            JLabel temp=new JLabel(blocks4.FreeProcess.get(i).Id+"");
            temp.setBounds(990,110+i*50,50,30);
            panel.add(temp);
            WFLabel[i][0]=temp;
        }

        for(int i=0;i<blocks4.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).size+"K");
            JLabel temp=new JLabel(blocks4.FreeProcess.get(i).size+"K");
            temp.setBounds(1060,110+i*50,50,30);
            panel.add(temp);
            WFLabel[i][1]=temp;
        }

        for(int i=0;i<blocks4.FreeProcess.size();i++){
//            System.out.println(blocks.process.get(i).size+"K");
            JLabel temp=new JLabel(blocks4.FreeProcess.get(i).address+"K");
            temp.setBounds(1130,110+i*50,50,30);
            panel.add(temp);
            WFLabel[i][2]=temp;
        }

        for(int i=0;i<blocks4.process.size();i++){
            JTextField container=new JTextField(blocks4.process.get(i).size+"K, "+blocks4.process.get(i).Id);
            container.setBounds(1205,blocks4.process.get(i).address,70,blocks4.process.get(i).size);
            container.setBackground(Color.pink);
            panel.add(container);
            WFText[i]=container;
        }
    }
    //数字判断
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void actionHandler(){
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //分配
                if(e.getSource()==confirm){
                    PCB apply=new PCB(-1,0,-1);
//                    apply.Id=-1;
//                    apply.size=0;
//                    apply.address=-1;
                    String SizeValue=CapacityInput.getText();
                    if(isNumeric(SizeValue)==true){
                        apply.size=Integer.parseInt(SizeValue);
//                        apply.Id=count+1;
//                        count++;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"大小输入不合法！");
                    }
                    int FFid=FirstFit(apply);
                    if(FFid>=0){
                        apply.Id=countFFnum+1;
                        countFFnum++;
                        ModifyFF(FFid,apply);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"首次适应算法分配不成功");
                        return;
                    }

                    int NFid=NextFit(apply);
                    if(NFid>=0){
                        apply.Id=countNFnum+1;
                        countNFnum++;
                        ModifyNF(NFid,apply);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"循环首次适应算法分配不成功");
                        return;
                    }

                    int BFid=BestFit(apply);
                    if(BFid>=0){
                        apply.Id=countBFnum+1;
                        countBFnum++;
                        ModifyBF(apply);
//                        for(int j=0;j<apply.Id;j++){
//                            System.out.println(BFText[j].getText());
//                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"最佳适应算法分配不成功");
                        return;
                    }

                    int WFid=WorstFit(apply);
                    if(WFid>=0){
                        apply.Id=countWFnum+1;
                        countWFnum++;
                        ModifyWF(apply);
//                        for(int j=0;j<apply.Id;j++){
//                            System.out.println(WFText[j].getText());
//                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"最坏适应算法分配不成功");
                        return;
                    }
                }
            }
        });
        recycle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //回收
                if(e.getSource()==recycle){
                    String revValue=recycleId.getText();
                    if(isNumeric(revValue)==true){
                        reveive=Integer.parseInt(revValue);
                        //FF算法
                        int k;
                        if((k=IsExist(reveive,blocks1))>=0){
                            panel.remove(FFText[k]);
                            panel.repaint();
                            panel.revalidate();
                            FFrecycle(k,blocks1,FFLable);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"FF算法中该分区不存在");
                        }
                        //NF算法
                        if((k=IsExist(reveive,blocks2))>=0){
                            panel.remove(NFText[k]);
                            panel.repaint();
                            panel.revalidate();
                            FFrecycle(k,blocks2,NFLabel);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"NF算法中该分区不存在");
                        }
                        //BF算法
                        if((k=IsExist(reveive,blocks3))>=0){
                            System.out.println("出鬼了？"+BFText[k].getX());
                            panel.remove(BFText[k]);
                            panel.repaint();
                            panel.revalidate();
                            BFrecycle(k,blocks3,BFLabel);
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"BF算法中该分区不存在");
                        }
                        //WF算法
                        if((k=IsExist(reveive,blocks4))>=0){
                            panel.remove(WFText[k]);
                            panel.repaint();
                            panel.revalidate();
                            WFrecycle(k,blocks4,WFLabel);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"WF算法中该分区不存在");
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"分区号输入不合法");
                    }

                }
            }
        });
    }


    public static int FirstFit(PCB apply){
        for(int i=0;i<blocks1.FreeProcess.size();i++){
            if(apply.size<=blocks1.FreeProcess.get(i).size){
                apply.address=blocks1.FreeProcess.get(i).address;
//                System.out.println(apply.address+"??");
                //修改原来空闲块的大小
                PCB newFreeBlock=new PCB(blocks1.FreeProcess.get(i).Id,blocks1.FreeProcess.get(i).size-apply.size,blocks1.FreeProcess.get(i).address+apply.size);
                blocks1.FreeProcess.set(i,newFreeBlock);
//                System.out.println(blocks1.FreeProcess.get(i).address+"---");
                blocks1.process.add(apply);
//                System.out.println(apply.Id);
//                for(int j=0;j<blocks1.process.size();j++){
//                    System.out.println(blocks1.process.get(j).Id+" "+blocks1.process.get(j).address);
//                }
                Collections.sort(blocks1.FreeProcess,new CompareAddress());//放到正确位置
                return i;
            }
        }
        return -1;
    }

    public static void ModifyFF(int id,PCB apply){
        FFLable[id][1].setText(blocks1.FreeProcess.get(id).size+"K");
        FFLable[id][2].setText(blocks1.FreeProcess.get(id).address+"K");
        JTextField container=new JTextField(blocks1.process.get(blocks1.process.size()-1).size+"K, "+apply.Id);
        container.setBounds(245,blocks1.process.get(blocks1.process.size()-1).address,70,blocks1.process.get(blocks1.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        FFText[blocks1.process.size()-1]=container;
    }

    public static int NextFit(PCB apply){
        int c=0;
        for(int i=NFcount;c<blocks2.FreeProcess.size();i=(i+1)%blocks2.FreeProcess.size()){
            if(apply.size<=blocks2.FreeProcess.get(i).size){
                apply.address=blocks2.FreeProcess.get(i).address;
                PCB tmp=new PCB(apply.Id,blocks2.FreeProcess.get(i).size-apply.size,blocks2.FreeProcess.get(i).address+apply.size);
                blocks2.FreeProcess.set(i,tmp);
                blocks2.process.add(apply);
                Collections.sort(blocks2.FreeProcess,new CompareAddress());//放到正确位置
                NFcount=(i+1)%blocks2.FreeProcess.size();
                return i;
            }
        }
        return -1;
    }

    public static void ModifyNF(int id,PCB apply){
        NFLabel[id][1].setText(blocks2.FreeProcess.get(id).size+"K");
        NFLabel[id][2].setText(blocks2.FreeProcess.get(id).address+"K");
        JTextField container=new JTextField(blocks2.process.get(blocks2.process.size()-1).size+"K, "+apply.Id);
        container.setBounds(565,blocks2.process.get(blocks2.process.size()-1).address,70,blocks2.process.get(blocks2.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        NFText[blocks2.process.size()-1]=container;
    }

    public static int BestFit(PCB apply){
        for(int i=0;i<blocks3.FreeProcess.size();i++){
            if(apply.size<=blocks3.FreeProcess.get(i).size){
                //修改原来空闲块的大小
                PCB newFreeBlock=new PCB(blocks3.FreeProcess.get(i).Id,blocks3.FreeProcess.get(i).size-apply.size,blocks3.FreeProcess.get(i).address+apply.size);
                apply.address=blocks3.FreeProcess.get(i).address;
                blocks3.FreeProcess.set(i,newFreeBlock);
                blocks3.process.add(apply);
                Collections.sort(blocks3.FreeProcess,new CompareSize());//放到正确位置
                return i;
            }
        }
        return -1;
    }

    public static void ModifyBF(PCB apply){
//        System.out.println("IN!!!!!!!!!!!!!!!!!!!!!!!");
        for(int i=0;i<blocks3.FreeProcess.size();i++){
            BFLabel[i][0].setText(blocks3.FreeProcess.get(i).Id+"");
            BFLabel[i][1].setText(blocks3.FreeProcess.get(i).size+"K");
            BFLabel[i][2].setText(blocks3.FreeProcess.get(i).address+"K");
        }
        JTextField container=new JTextField(blocks3.process.get(blocks3.process.size()-1).size+"K, "+apply.Id);
        container.setBounds(885,blocks3.process.get(blocks3.process.size()-1).address,70,blocks3.process.get(blocks3.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        BFText[blocks3.process.size()-1]=container;
    }

    public static int WorstFit(PCB apply){
        Collections.sort(blocks4.FreeProcess,new CompareSizeDec());//放到正确位置
        for(int i=0;i<blocks4.FreeProcess.size();i++){
            if(apply.size<=blocks4.FreeProcess.get(i).size){
                apply.address=blocks4.FreeProcess.get(i).address;
//                System.out.println(apply.address+"??");
                //修改原来空闲块的大小
                PCB newFreeBlock=new PCB(blocks4.FreeProcess.get(i).Id,blocks4.FreeProcess.get(i).size-apply.size,blocks4.FreeProcess.get(i).address+apply.size);
                blocks4.FreeProcess.set(i,newFreeBlock);
//                System.out.println(blocks4.FreeProcess.get(i).address+"---");
                blocks4.process.add(apply);
//                Collections.sort(blocks4.FreeProcess,new CompareSizeDec());//放到正确位置
                return i;
            }
        }
        return -1;
    }

    public static void ModifyWF(PCB apply){
        for(int i=0;i<blocks4.FreeProcess.size();i++){
            WFLabel[i][0].setText(blocks4.FreeProcess.get(i).Id+"");
            WFLabel[i][1].setText(blocks4.FreeProcess.get(i).size+"K");
            WFLabel[i][2].setText(blocks4.FreeProcess.get(i).address+"K");
        }
        JTextField container=new JTextField(blocks4.process.get(blocks4.process.size()-1).size+"K, "+apply.Id);
        container.setBounds(1205,blocks4.process.get(blocks4.process.size()-1).address,70,blocks4.process.get(blocks4.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        WFText[blocks4.process.size()-1]=container;//!!!!!!!!!!!
    }

    //查找该分区是否存在
    public static int IsExist(int num,Assign blocks){
        for(int i=0;i<blocks.process.size();i++){
            if(num==blocks.process.get(i).Id){
                System.out.println("位置："+i);
                return i;
            }
        }
        return -1;
    }
    //回收操作操作
    public static void FFrecycle(int num,Assign blocks,JLabel [][] label){
        System.out.println("回收分区号："+num);
        blocks.FreeProcess.add(blocks.process.get(num));
        blocks.process.set(num,new PCB(-1,-1,-1));
        MergeInFF(blocks);//合并空闲块
        RecycleFFDisplay(blocks,label);
    }

    public static void MergeInFF(Assign blocks){
        Collections.sort(blocks.FreeProcess,new CompareAddress());//按照地址排序
        for(int i=0;i<blocks.FreeProcess.size()-1;i++){
            if(blocks.FreeProcess.get(i).address+blocks.FreeProcess.get(i).size>=blocks.FreeProcess.get(i+1).address){
                PCB temp=new PCB(blocks.FreeProcess.get(i).Id,blocks.FreeProcess.get(i).size+blocks.FreeProcess.get(i+1).size,blocks.FreeProcess.get(i).address);
                blocks.FreeProcess.remove(i+1);
                blocks.FreeProcess.set(i,temp);
                i--;//仍然从当前块比较
            }
        }
    }

    public static void BFrecycle(int num,Assign blocks,JLabel [][] label){
        System.out.println("回收分区号："+num);
        blocks.FreeProcess.add(blocks.process.get(num));
        blocks.process.set(num,new PCB(-1,-1,-1));
        MergeInFF(blocks);//合并空闲块
        Collections.sort(blocks.FreeProcess,new CompareSize());//重新排序
        RecycleFFDisplay(blocks,label);
    }

    public static void WFrecycle(int num,Assign blocks,JLabel [][] label){
        System.out.println("回收分区号："+num);
        blocks.FreeProcess.add(blocks.process.get(num));
        blocks.process.set(num,new PCB(-1,-1,-1));
        MergeInFF(blocks);//合并空闲块
        Collections.sort(blocks.FreeProcess,new CompareSizeDec());//重新排序
        RecycleFFDisplay(blocks,label);
    }
//
    public static void RecycleFFDisplay(Assign blocks,JLabel [][]Label) {
        int i;
        for (i=0; i < blocks.FreeProcess.size(); i++) {
            try {
                Label[i][0].setText(blocks.FreeProcess.get(i).Id + "");
                Label[i][1].setText(blocks.FreeProcess.get(i).size + "K");
                Label[i][2].setText(blocks.FreeProcess.get(i).address + "K");
            }
            catch (NullPointerException e){
                System.out.println("");
            }

        }
        for(int k=i;k<Label.length;k++){
            if(Label[k][0]!=null){
                Label[k][0].setText("");
            }
            if(Label[k][1]!=null){
                Label[k][1].setText("");
            }
            if(Label[k][2]!=null){
                Label[k][2].setText("");
            }

        }
    }


}
