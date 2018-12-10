import sun.plugin2.message.JavaObjectOpMessage;
import sun.tools.jps.Jps;

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
    public static PCB apply=new PCB(-1,-1,-1);//初始化
    public static int count=6;
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
//        JLabel BlockId=new JLabel("分区号：");
//        BlockId.setBounds(100,10,80,30);
//        panel.add(BlockId);
//        JTextField BlockInput=new JTextField();
//        BlockInput.setBounds(180,10,80,30);
//        panel.add(BlockInput);
        System.out.println("!!!!!!!!!!!!!!!!");
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
                    apply.Id=-1;
                    apply.size=0;
                    apply.address=-1;
                    String SizeValue=CapacityInput.getText();
                    if(isNumeric(SizeValue)==true){
                        apply.size=Integer.parseInt(SizeValue);
                        apply.Id=count+1;
                        count++;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"大小输入不合法！");
                    }
                    int FFid=FirstFit();
                    if(FFid>=0){
                        ModifyFF(FFid);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"首次适应算法分配不成功");
                    }
                    int NFid=NextFit();
                    if(NFid>=0){
                        ModifyNF(NFid);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"循环首次适应算法分配不成功");
                    }
                    int BFid=BestFit();
                    if(BFid>=0){
                        ModifyBF();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"最佳适应算法分配不成功");
                    }
                    int WFid=WorstFit();
                    if(WFid>=0){
                        ModifyWF();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"最坏适应算法分配不成功");
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
                        int recycleID=ReceiveInFF(reveive);
                        if(recycleID<0){
                            JOptionPane.showMessageDialog(null,"分区不存在");
                        }
                        else{
                            RecycleFFDisplay();
                            removeFFTextDisplay(recycleID);
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"分区号输入不合法");
                    }

                }
            }
        });
    }


    public static int FirstFit(){
        for(int i=0;i<blocks1.FreeProcess.size();i++){
            if(apply.size<=blocks1.FreeProcess.get(i).size){
                apply.address=blocks1.FreeProcess.get(i).address;
//                System.out.println(apply.address+"??");
                //修改原来空闲块的大小
                PCB newFreeBlock=new PCB(blocks1.FreeProcess.get(i).Id,blocks1.FreeProcess.get(i).size-apply.size,blocks1.FreeProcess.get(i).address+apply.size);
                blocks1.FreeProcess.set(i,newFreeBlock);
//                System.out.println(blocks1.FreeProcess.get(i).address+"---");
                blocks1.process.add(apply);
                Collections.sort(blocks1.FreeProcess,new CompareAddress());//放到正确位置
                return i;
            }
        }
        return -1;
    }

    public static void ModifyFF(int id){
        FFLable[id][1].setText(blocks1.FreeProcess.get(id).size+"K");
        FFLable[id][2].setText(blocks1.FreeProcess.get(id).address+"K");
        JTextField container=new JTextField(blocks1.process.get(blocks1.process.size()-1).size+"K, "+apply.Id);
        container.setBounds(245,blocks1.process.get(blocks1.process.size()-1).address,70,blocks1.process.get(blocks1.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        FFText[blocks1.process.size()-1]=container;
    }

    public static int NextFit(){
//        NFcount=(NFcount+1)%blocks2.FreeProcess.size();
//        System.out.println("NFcount："+NFcount);
        for(int i=NFcount;i<blocks2.FreeProcess.size();i++){
            if(apply.size<=blocks2.FreeProcess.get(i).size){
                apply.address=blocks2.FreeProcess.get(i).address;
                PCB tmp=new PCB(apply.Id,blocks2.FreeProcess.get(i).size-apply.size,blocks2.FreeProcess.get(i).address+apply.size);
                blocks2.FreeProcess.set(i,tmp);
                blocks2.process.add(apply);
                Collections.sort(blocks2.FreeProcess,new CompareAddress());//放到正确位置
                NFcount=(i+1)%5;
                return i;
            }
        }
        return -1;
    }

    public static void ModifyNF(int id){
        NFLabel[id][1].setText(blocks2.FreeProcess.get(id).size+"K");
        NFLabel[id][2].setText(blocks2.FreeProcess.get(id).address+"K");
        JTextField container=new JTextField(blocks2.process.get(blocks2.process.size()-1).size+"K, "+apply.Id);
        container.setBounds(565,blocks2.process.get(blocks2.process.size()-1).address,70,blocks2.process.get(blocks2.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        NFText[blocks2.process.size()-1]=container;
    }

    public static int BestFit(){
        for(int i=0;i<blocks3.FreeProcess.size();i++){
            if(apply.size<=blocks3.FreeProcess.get(i).size){
//                apply.address=blocks3.FreeProcess.get(i).address;
//                System.out.println(apply.address+"??");
                //修改原来空闲块的大小
                PCB newFreeBlock=new PCB(blocks3.FreeProcess.get(i).Id,blocks3.FreeProcess.get(i).size-apply.size,blocks3.FreeProcess.get(i).address+apply.size);
                blocks3.FreeProcess.set(i,newFreeBlock);
//                System.out.println(blocks3.FreeProcess.get(i).address+"---");
                blocks3.process.add(apply);
                Collections.sort(blocks3.FreeProcess,new CompareSize());//放到正确位置
                return i;
            }
        }
        return -1;
    }

    public static void ModifyBF(){
        for(int i=0;i<blocks3.FreeProcess.size();i++){
            BFLabel[i][0].setText(blocks3.FreeProcess.get(i).Id+"");
            BFLabel[i][1].setText(blocks3.FreeProcess.get(i).size+"");
            BFLabel[i][2].setText(blocks3.FreeProcess.get(i).address+"");
        }
        JTextField container=new JTextField(blocks3.process.get(blocks3.process.size()-1).size+", "+apply.Id);
        container.setBounds(885,blocks3.process.get(blocks3.process.size()-1).address,70,blocks3.process.get(blocks3.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        BFText[blocks3.process.size()-1]=container;
    }

    public static int WorstFit(){
        for(int i=0;i<blocks4.FreeProcess.size();i++){
            if(apply.size<=blocks4.FreeProcess.get(i).size){
                apply.address=blocks4.FreeProcess.get(i).address;
//                System.out.println(apply.address+"??");
                //修改原来空闲块的大小
                PCB newFreeBlock=new PCB(blocks4.FreeProcess.get(i).Id,blocks4.FreeProcess.get(i).size-apply.size,blocks4.FreeProcess.get(i).address+apply.size);
                blocks4.FreeProcess.set(i,newFreeBlock);
//                System.out.println(blocks4.FreeProcess.get(i).address+"---");
                blocks4.process.add(apply);
                Collections.sort(blocks4.FreeProcess,new CompareSizeDec());//放到正确位置
                return i;
            }
        }
        return -1;
    }

    public static void ModifyWF(){
        for(int i=0;i<blocks4.FreeProcess.size();i++){
            WFLabel[i][0].setText(blocks4.FreeProcess.get(i).Id+"");
            WFLabel[i][1].setText(blocks4.FreeProcess.get(i).size+"");
            WFLabel[i][2].setText(blocks4.FreeProcess.get(i).address+"");
        }
        JTextField container=new JTextField(blocks4.process.get(blocks4.process.size()-1).size+", "+apply.Id);
        container.setBounds(1205,blocks4.process.get(blocks4.process.size()-1).address,70,blocks4.process.get(blocks4.process.size()-1).size);
        container.setBackground(Color.pink);
        panel.add(container);
        BFText[blocks4.process.size()-1]=container;
    }

    public static int ReceiveInFF(int id){
        for(int i=0;i<blocks1.process.size();i++){
            if(blocks1.process.get(i).Id==id){
                blocks1.FreeProcess.add(blocks1.process.get(i));//空闲块数组加上该块
                MergeInFF();//合并空闲块
                blocks1.process.remove(i);//该块成为了空闲块
                removeFFTextDisplay(i);
                return i;
            }
        }
        return -1;
    }

    public static void MergeInFF(){
        Collections.sort(blocks1.FreeProcess,new CompareAddress());//按照地址排序
        for(int i=0;i<blocks1.FreeProcess.size()-1;i++){
            if(blocks1.FreeProcess.get(i).address+blocks1.FreeProcess.get(i).size>=blocks1.FreeProcess.get(i+1).address){
                PCB temp=new PCB(blocks1.FreeProcess.get(i).Id,blocks1.FreeProcess.get(i).size+blocks1.FreeProcess.get(i+1).size,blocks1.FreeProcess.get(i).address);
                blocks1.FreeProcess.remove(i+1);
                blocks1.FreeProcess.set(i,temp);
                i--;//仍然从当前块比较
            }
        }
    }

    public static void RecycleFFDisplay() {
        int i;
        for (i=0; i < blocks1.FreeProcess.size(); i++) {
            FFLable[i][0].setText(blocks1.FreeProcess.get(i).Id + "");
            FFLable[i][1].setText(blocks1.FreeProcess.get(i).size + "");
            FFLable[i][2].setText(blocks1.FreeProcess.get(i).address + "");
        }
        for(int k=i;k<FFLable.length;k++){
            if(FFLable[k][0]!=null){
                FFLable[k][0].setText("");
            }
            if(FFLable[k][1]!=null){
                FFLable[k][1].setText("");
            }
            if(FFLable[k][2]!=null){
                FFLable[k][2].setText("");
            }

        }
    }

    public static void removeFFTextDisplay(int id){
//        panel.repaint();
        System.out.println("?");
//        panel.remove(FFText[id]);//移除相应分配块
//        panel.revalidate();
//        panel.repaint();
            FFText[id].setText("");
        System.out.println(FFText[id].getText());
        System.out.println("!");
        //重新设置对应关系
        int i;
        for(i=0;i<blocks1.process.size();i++){
//            System.out.println(blocks1.process.get(i).address+"K");
            JTextField container=new JTextField(blocks1.process.get(i).size+"K, "+blocks1.process.get(i).Id);
            container.setBounds(245,blocks1.process.get(i).address,70,blocks1.process.get(i).size);
            container.setBackground(Color.pink);
            FFText[i]=container;
        }
        System.out.println("非空闲块：");
        for(int k=0;k<blocks1.process.size();k++){
            System.out.println(blocks1.process.get(k).Id);
            System.out.println(FFText[k].getText());
        }

    }
}
