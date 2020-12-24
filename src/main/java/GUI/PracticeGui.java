package GUI;

import csvfile.CsvFile;
import equation.AdditionEquations;
import equation.Equation;
import exercise.Exercise;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.Random;

import static context.NUM.NUM;

public class PracticeGui extends JFrame {
    private static final long serialVersionUID = -639767039479761232L;
    static final int WINDOW_WIDTH = 580; //窗口宽度
    static final int WINDOW_HEIGHT = 300;  //窗口高度
    static final int OP_AMOUNT = 20;  //窗口内显示的算式数量
    static final int OP_COLUMN = 5; //算式的列数
    static final int OP_WIDTH = 65; //算式的宽度
    static final int ANSWER_WIDTH = 35; //答案的宽度
    static final int COMPONET_HEIGHT = 25; //算式、答案的高度

    private JPanel contentPane;
    private JTextField[] tfOp; //显示的算式组件数组
    private JTextField[] tfAns; //显示的答案组件数组
    private JLabel labelStatus; //状态标签
    private JLabel labelStat; //状态标签
    private JLabel labelCurrent; //当前页号标签
    private JLabel labelTotal; //总页数标签
    private JMenuItem mntmPre; //前一页 菜单项
    private JMenuItem mntmNext; //后一页 菜单项
    private JButton btnPre; //前一页 工具栏按钮
    private JButton btnNext; //后一页 工具栏按钮
    private int totalPages; //总页数
    private int currentPage; //当前页码
    private int select=0;
    private boolean submitted;
    Exercise exercise=new Exercise();
    Equation[] equations=new AdditionEquations[500];
    Equation[] exercises=new AdditionEquations[150];
    CsvFile csvFile = new CsvFile();
    public static String[] answer;
    static {
        answer=new String[100];
    }
    private Equation[] exercise1=new Equation[150];


    private final ButtonGroup buttonGroupTypes = new ButtonGroup();
    private final ButtonGroup buttonGroupAmount = new ButtonGroup();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PracticeGui frame = new PracticeGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public PracticeGui() {
        setResizable(false);

        setTitle("\u53E3\u7B97\u7EC3\u4E60");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 234, 564, 4);
        contentPane.add(separator);

        //以下为“第X页 共X页”标签
        JLabel label_1 = new JLabel("\u7B2C");
        label_1.setBounds(196, 201, 23, 23);
        contentPane.add(label_1);
        labelCurrent = new JLabel("1");
        labelCurrent.setBounds(218, 201, 23, 23);
        contentPane.add(labelCurrent);
        JLabel label_2 = new JLabel("\u9875");
        label_2.setBounds(240, 201, 23, 23);
        contentPane.add(label_2);
        JLabel label_3 = new JLabel("\u5171");
        label_3.setBounds(270, 201, 23, 23);
        contentPane.add(label_3);
        labelTotal = new JLabel("3");
        labelTotal.setBounds(293, 201, 23, 23);
        contentPane.add(labelTotal);
        JLabel label_4 = new JLabel("\u9875");
        label_4.setBounds(316, 201, 23, 23);
        contentPane.add(label_4);



        //以下为菜单
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 564, 25);
        contentPane.add(menuBar);
        JMenu menuFile = new JMenu("文件(重启后生效)");
        menuBar.add(menuFile);
        JMenu mntnIn = new JMenu("更新等式文件");
        menuFile.add(mntnIn);
        JRadioButtonMenuItem rbtnAdd = new JRadioButtonMenuItem("加法题目");
        rbtnAdd.setSelected(true);
        buttonGroupTypes.add(rbtnAdd);
        mntnIn.add(rbtnAdd);
        JRadioButtonMenuItem rbtnSub = new JRadioButtonMenuItem("减法题目");
        buttonGroupTypes.add(rbtnSub);
        mntnIn.add(rbtnSub);
        JRadioButtonMenuItem rbtnBin = new JRadioButtonMenuItem("加减混合");
        buttonGroupTypes.add(rbtnBin);
        mntnIn.add(rbtnBin);
        JMenuItem mntmOut = new JMenuItem("更新习题文件");
        menuFile.add(mntmOut);


        JMenu menuOption = new JMenu("题目设置");
        menuBar.add(menuOption);


        JMenu mnAmount = new JMenu("根据数量生成");
        menuOption.add(mnAmount);
        JRadioButtonMenuItem rbtnA20 = new JRadioButtonMenuItem("20");
        rbtnA20.setSelected(true);
        buttonGroupAmount.add(rbtnA20);
        mnAmount.add(rbtnA20);
        JRadioButtonMenuItem rbtnA40 = new JRadioButtonMenuItem("40");
        buttonGroupAmount.add(rbtnA40);
        mnAmount.add(rbtnA40);
        JRadioButtonMenuItem rbtnA60 = new JRadioButtonMenuItem("60");
        buttonGroupAmount.add(rbtnA60);
        mnAmount.add(rbtnA60);
        JRadioButtonMenuItem rbtnA80 = new JRadioButtonMenuItem("80");
        buttonGroupAmount.add(rbtnA80);
        mnAmount.add(rbtnA80);
        /*JRadioButtonMenuItem rbtnA100 = new JRadioButtonMenuItem("100");
        buttonGroupAmount.add(rbtnA100);
        mnAmount.add(rbtnA100);

         */

        JMenu menuOpration = new JMenu("题目操作");
        menuBar.add(menuOpration);
        JMenuItem mntmGenerate = new JMenuItem("重新生成题目");
        menuOpration.add(mntmGenerate);

        JMenuItem mntmClear = new JMenuItem("清空答案");
        menuOpration.add(mntmClear);
        JMenuItem mntmSubmit = new JMenuItem("提交答案");
        menuOpration.add(mntmSubmit);

        JMenu menuView = new JMenu("查看");
        menuBar.add(menuView);
        mntmPre = new JMenuItem("上一页");
        menuView.add(mntmPre);
        mntmNext = new JMenuItem("下一页");
        menuView.add(mntmNext);

        //以下为菜单的动作

        mntmOut.addActionListener(new ActionListener() { //更新习题文件
            public void actionPerformed(ActionEvent e) {
                expExercise();
            }
        });
        rbtnAdd.addActionListener(new ActionListener() { //选择仅加法
            public void actionPerformed(ActionEvent e) {
                equations=exercise.gernAddequation(500);
                csvFile.writeEquationsfile(equations);
                updateComponets();
            }
        });
        rbtnSub.addActionListener(new ActionListener() { //选择仅减法
            public void actionPerformed(ActionEvent e) {
                equations=exercise.gernSubequation(500);
                csvFile.writeEquationsfile(equations);
                updateComponets();
            }
        });
        rbtnBin.addActionListener(new ActionListener() { //选择加减混合
            public void actionPerformed(ActionEvent e) {
                equations=exercise.gernequatExercise(500);
                csvFile.writeEquationsfile(equations);
                updateComponets();
            }
        });

        rbtnA20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NUM=20;
                try {
                    exercises=csvFile.readExercisesfile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvFile.writeExercisefile(exercises);


                updateComponets();
            }
        });
        rbtnA40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NUM=40;
                try {
                    exercises=csvFile.readExercisesfile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvFile.writeExercisefile(exercises);
                updateComponets();
            }
        });
        rbtnA60.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NUM=60;
                try {
                    exercises=csvFile.readExercisesfile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvFile.writeExercisefile(exercises);
                updateComponets();
            }
        });
        rbtnA80.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NUM=80;
                try {
                    exercises=csvFile.readExercisesfile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvFile.writeExercisefile(exercises);
                updateComponets();
            }
        });
        /*rbtnA100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NUM=100;
                try {
                    exercises=csvFile.readExercisefile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvFile.writeExercisefile(exercises);
                updateComponets();
            }
        });

         */
        mntmGenerate.addActionListener(new ActionListener() {  //重新生成题目
            public void actionPerformed(ActionEvent e) {
                generateExercise();
            }
        });
        mntmClear.addActionListener(new ActionListener() { //清空答案
            public void actionPerformed(ActionEvent e) {
                clearAnswers();
            }
        });
        mntmSubmit.addActionListener(new ActionListener() { //提交答案
            public void actionPerformed(ActionEvent e) {
                judgeAnswer();
            }
        });
        mntmPre.addActionListener(new ActionListener() { //上一页
            public void actionPerformed(ActionEvent e) {
                prePage();
            }
        });
        mntmNext.addActionListener(new ActionListener() { //下一页
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });

        //以下为工具栏
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 24, 564, 25);
        toolBar.setFloatable(false);
        contentPane.add(toolBar);
        toolBar.addSeparator();
        JButton btnGenrate = new JButton("重新生成");
        toolBar.add(btnGenrate);

        JButton btnClear = new JButton("清空");
        toolBar.add(btnClear);
        JButton btnSubmit = new JButton("提交");
        toolBar.add(btnSubmit);
        toolBar.addSeparator();
        btnPre = new JButton("上一页");
        toolBar.add(btnPre);
        btnNext = new JButton("下一页");
        toolBar.add(btnNext);

        //以下为工具栏上的按钮动作

        btnGenrate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { //重新生成题目 按钮动作
                generateExercise();
            }
        });
        btnClear.addActionListener(new ActionListener() { // 清空答案
            public void actionPerformed(ActionEvent e) {
                clearAnswers();
            }
        });
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //提交答案 按钮动作
                judgeAnswer();
            }
        });
        btnPre.addActionListener(new ActionListener() { //上一页 按钮动作
            public void actionPerformed(ActionEvent e) {
                prePage();
            }
        });
        btnNext.addActionListener(new ActionListener() { //下一页 按钮动作
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });
        readfile();
        initComponets();
        updateComponets();
    }

    private void expExercise(){  //更新习题文件
        try {
            equations=csvFile.readEquationsfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        csvFile.writeExercisesfile(equations);
    }
    private void generateExercise(){ //重新生成题目
        this.select=1;
        updateComponets();
    }

    private void judgeAnswer(){ //提交答案，判题
        this.submitted = true;
        getAnswers(this.currentPage);
        updateComponets();
    }
    private void prePage(){ //上翻一页
        if(this.currentPage == this.totalPages) this.leaveEnd();
        if(--currentPage == 1) this.reachBegin();
        this.labelCurrent.setText(String.valueOf(currentPage));
        updateComponets();
    }
    private void nextPage(){ //下翻一页
        getAnswers(this.currentPage);

        if(this.currentPage == 1) this.leaveBegin();
        if(++currentPage == this.totalPages) this.reachEnd();
        this.labelCurrent.setText(String.valueOf(currentPage));
        updateComponets();

    }
    private void getAnswers(int pageIndex){
        for(int i=0; i<OP_AMOUNT; i++){
            answer[(pageIndex-1)*OP_AMOUNT + i]=tfAns[i].getText();
            //exercise.setAnswer((pageIndex-1)*OP_AMOUNT + i, tfAns[i].getText());
        }
    }
    private void clearAnswers(){
        for (int i = 0; i < NUM; i++) {
            answer[i]="";
        }
        this.submitted = false;
        updateComponets();
    }
    private void initComponets(){
        this.submitted = false;

        this.currentPage = 1;
        this.totalPages = 1;
        this.reachBegin();
        this.reachEnd();

        tfOp = new JTextField[OP_AMOUNT];
        tfAns = new JTextField[OP_AMOUNT];
        for(int i=0; i<OP_AMOUNT; i++){
            tfOp[i] = new JTextField();
            tfOp[i].setBounds(20 + (i%OP_COLUMN)*(OP_WIDTH+ANSWER_WIDTH+5),
                    60 + (i/OP_COLUMN)*(COMPONET_HEIGHT+10),
                    OP_WIDTH,
                    COMPONET_HEIGHT);
            tfOp[i].setHorizontalAlignment(JTextField.RIGHT);
            tfOp[i].setEditable(false);
            contentPane.add(tfOp[i]);

            tfAns[i] = new JTextField();
            tfAns[i].setBounds(20+OP_WIDTH+(i%OP_COLUMN)*(OP_WIDTH+ANSWER_WIDTH+5),
                    60+(i/OP_COLUMN)*(COMPONET_HEIGHT+10),
                    ANSWER_WIDTH,
                    COMPONET_HEIGHT);
            contentPane.add(tfAns[i]);
        }
    }


    private void reachBegin(){
        this.btnPre.setEnabled(false);
        this.mntmPre.setEnabled(false);
    }
    private void reachEnd(){
        this.btnNext.setEnabled(false);
        this.mntmNext.setEnabled(false);
    }
    private void leaveBegin(){
        this.btnPre.setEnabled(true);
        this.mntmPre.setEnabled(true);
    }
    private void leaveEnd(){
        this.btnNext.setEnabled(true);
        this.mntmNext.setEnabled(true);
    }
private void upexercise() {

        if(select==1){
            Equation swap=new AdditionEquations();
            Random random=new Random();
            for (int i = 0; i < 200; i++) {
                int x=random.nextInt(150);
                int y=random.nextInt(150);
                swap=exercise1[x];
                exercise1[x]=exercise1[y];
                exercise1[y]=swap;
            }
            select=0;
        }
            for (int i = 0; i < OP_AMOUNT; i++) {
                tfOp[i].setText(exercise.getequation(exercise1, (currentPage - 1) * OP_AMOUNT + i).toString());
                if (!submitted) {
                    tfAns[i].setBackground(Color.WHITE);
                    tfAns[i].setText("");
                } else {
                    if (("" + exercise1[(currentPage - 1) * OP_AMOUNT + i].getAnswer()).equals(answer[(currentPage - 1) * OP_AMOUNT + i])) {
                        tfAns[i].setBackground(Color.GREEN);
                        tfAns[i].setText("" + exercise1[(currentPage - 1) * OP_AMOUNT + i].getAnswer());
                    } else
                        tfAns[i].setBackground(Color.RED);
                    tfAns[i].setText("" + exercise1[(currentPage - 1) * OP_AMOUNT + i].getAnswer());
                }
            }


    }
private void readfile() {
    try {
        this.exercise1=csvFile.readExercisesfile();
    } catch (IOException p) {
        p.printStackTrace();
    }
}

    private void updateComponets() {
        this.totalPages = NUM / OP_AMOUNT;
        this.labelCurrent.setText(String.valueOf(this.currentPage));
        this.labelTotal.setText(String.valueOf(this.totalPages));
        if (this.currentPage == 1) this.reachBegin();
        else this.leaveBegin();
        if (this.currentPage == this.totalPages) this.reachEnd();
        else this.leaveEnd();
        upexercise();
    }
}
