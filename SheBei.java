package XueXi.SheBei;

public class SheBei {
    String node;
    String name;
    String year,moon,day;
    String age;
    String color;
    String note;
    SheBei(){}
    SheBei(String str){
        setString(str);
    }
    public String toString(){
        String str;
        str = node+","+name+","+year+"."+moon+"."+day+","+age+","+color+","+note+"\n";
        return str;
    }
    public void setString(String str){
        //if(str.charAt(str.length()-1)!='\n'){str+='\n';}
        int i,j,k,len;
        char c;
        String []strlist = new String[8] ;
        len=str.length();
        j=i=0;
        k=0;
        do{
            for (; i < len; i++) {
                c = str.charAt(i);
                if (c == ',' || c == '.' || c == ' ' || c == '\n' || c == '\t')
                    break;
            }
            if(j<i){
                strlist[k++]=str.substring(j,i);
            }
            else {
                strlist[k++]="";
            }
            i++;
            j=i;
        }while(i<len && k<8);
        if(k==8) {
            node = strlist[0];
            name = strlist[1];
            year = strlist[2];
            moon = strlist[3];
            day = strlist[4];
            age = strlist[5];
            color = strlist[6];
            note = strlist[7];
        }
    }
}