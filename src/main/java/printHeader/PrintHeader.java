package printHeader;

import java.util.Scanner;

import static context.NUM.NUM;
//此模块用于输出程序开始时的介绍信息
public  final class  PrintHeader {
    public static  int  print_Header(){
        int select;
        System.out.println("加减法口算练习系统-v2.0");
        //System.out.println("请输入一套题的题数：");
        Scanner in=new Scanner(System.in);
        //NUM=in.nextInt();
        System.out.println("程序将输出"+NUM+"道100以内的加减法算式习题");
        System.out.println("每次运行程序可得到三套"+NUM+"道题的习题及答案");
        System.out.println("是否更新习题库？");
        System.out.println("1.是    2.否");
        select=in.nextInt();
        if (select==1) {
            System.out.println("请输入你要选择的功能：");
            System.out.println("1.加法算式   2.减法算式   3.加减混合算式");
            select = in.nextInt();
        }else select=0;
        return select;
        }
    }

