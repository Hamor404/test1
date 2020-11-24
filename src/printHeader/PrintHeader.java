package printHeader;

import static context.NUM.NUM;
//此模块用于输出程序开始时的介绍信息
public class PrintHeader {
    public static void print_Header(){
        System.out.println("加减法口算练习系统-v0.1");
        System.out.println("程序将输出"+ NUM+"道100以内的加减法算式习题");
        System.out.println("每次运行程序可得到一套50道题的习题及答案");
    }
}
