package test;

import java.util.Scanner;

/**
 * @Classname Pass
 * @Created by zgw
 * @Date 2020-09-08 18:27
 * @Description TODO
 */
public class Pass {
    //数字
    public static final String REG_NUMBER = ".*\\d+.*";
    //小写字母
    public static final String REG_UPPERCASE = ".*[A-Z]+.*";
    //大写字母
    public static final String REG_LOWERCASE = ".*[a-z]+.*";
    //特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)
    public static final String REG_SYMBOL = "\\p{Punct}+";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] sa=s.split(" ");
        for (int i=0;i<sa.length;i++){
            System.out.println(checkPasswordRule(sa[i]));
        }

    }
    public static int checkPasswordRule(String password){
        //密码为空及长度大于8位小于120位判断
        if (password == null || password.length() <8 || password.length()>120) return 1;
        int i = 0;
        if (password.matches(Pass.REG_NUMBER)) i++;
        if (password.matches(Pass.REG_LOWERCASE))i++;
        if (password.matches(Pass.REG_UPPERCASE)) i++;
        if (password.matches(Pass.REG_SYMBOL)) i++;
        if (i  < 3 )  return 2;

        return 0;
    }
}
