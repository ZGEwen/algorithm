package test;

/**
 * @Classname RemoveLines
 * @Created by zgw
 * @Date 2020-08-29 19:45
 * @Description 删除字符串中的多余的下划线及字符串两侧的下划线
 */
public class RemoveLines {
    public static void main(String[] args) {
        String s = "___aaa__b_c___d__";
        char[] str=s.toCharArray();
        int i=0,j=0;
        while(str[i]=='_'){
            i++;
        }
        while(i<=str.length-1){
            if(str[i]=='_'&&(i==str.length-1||str[i+1]=='_')){ //如果中间空格的之后还存在空格的话，或者是结尾的话。
                i++;
                continue;
            }
            str[j++]=str[i++];

        }
        for(int o=0;o<j;o++){
            System.out.print(str[o]);
        }
    }

}
