package XueXi.SheBei;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MyDbs {
    ArrayList<SheBei> sheBeiList;
    int num;
    int pos;

    String pathname;

    JTextField jt1,jt2;
    String in,out;
    MyDbs(){
        sheBeiList = new ArrayList<SheBei>();
        num=0;
        pos=-1;
        in=out="";
        pathname="./DBS.txt";
    }
    void upload() {
        try {
            FileWriter fw = new FileWriter(pathname);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<num;i++){
                bw.write( sheBeiList.get(i).toString() );
                System.out.print(sheBeiList.get( sheBeiList.size()-1 ) );
            }
            bw.close();
        } catch (Exception ex){
        }
    }
    void download(){
        try{
            FileReader fr = new FileReader(pathname);
            BufferedReader br = new BufferedReader(fr);
            String str ;
            while( ( str=br.readLine() )!=null   ){
                sheBeiList.add(new SheBei(str) );
                System.out.print(sheBeiList.get( sheBeiList.size()-1 ) );
                num++;
            }
            br.close();
        } catch (Exception ex) {
            try {
                FileWriter fw = new FileWriter(pathname);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.close();
                jt1.setText("已创建数据库于"+new File("").getAbsolutePath()+pathname);
            } catch(Exception e) {
                jt1.setText("数据库创建失败");
            }
        }
    }

    void Find(){
        in=jt1.getText();
        int i;
        for(i=0;i<num;i++){
            if(in.equals( sheBeiList.get(i).node )){
                break;
            }
        }
        if(i<num){
            pos=i;
            out = sheBeiList.get(i).toString();
        }else {
            pos=-1;
            out = "not found!";
        }
        jt2.setText(out);
    }
    void Modify(){
        if(pos!=-1){
            out=jt2.getText();
            sheBeiList.get(pos).setString(out);
        }
        else
            jt2.setText("请先进行查询，以选定设备");

    }
    void Add(){
        out=jt2.getText();
        sheBeiList.add(new SheBei(out) );
        num ++;
    }
    void Delete(){
        if(pos!=-1){
            sheBeiList.remove(pos);
            num--;
            pos = -1;
        }else {
            jt2.setText("请先进行查询，以选定设备");
        }
    }
    void setJFrame(MyJFrame mj){
        jt1 = mj.getJt1();
        jt2 = mj.getJt2();
    }
}
