import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


public class MyCalculator {
    Font font;
    JFrame jFrame;
    JPanel linear;
    JTextField text;
    JPanel jPanel;

    CircleButton add;
    CircleButton returnZero;
    CircleButton reduce;
    CircleButton multiple;
    CircleButton except;
    CircleButton residual;
    CircleButton delete;
    CircleButton num1;
    CircleButton num2;
    CircleButton num3;
    CircleButton num4;
    CircleButton num5;
    CircleButton num6;
    CircleButton num7;
    CircleButton num8;
    CircleButton num9;
    CircleButton num0;
    CircleButton dot;
    CircleButton result;

    private int cal(int n1, int n2, String opt){
        return switch (opt) {
            case "＋" -> n1 + n2;
            case "－" -> n1 - n2;
            case "×" -> n1 * n2;
            case "÷" -> n1 / n2;
            case "%" -> n1 % n2;
            default -> -1;
        };
    }

    public void start(){

        font = new Font("楷书",Font.PLAIN,30);
        UIManager.put("Button.font",font);
        UIManager.put("TextField.font",font);
        //顶层布局

        jFrame = new JFrame("Calculator");
        //内容布局

        linear = new JPanel(new BorderLayout());

        //算式文本框

        text = new JTextField();
        text.setPreferredSize(new Dimension(400,200));
        linear.add(text,BorderLayout.NORTH);
        text.setEditable(false);
        text.setText("0");

        //键盘

        jPanel = new JPanel(new GridLayout(5,4,10,10));
        jPanel.setBackground(Color.LIGHT_GRAY);

        AtomicReference<String> param1 = new AtomicReference<>("");
        AtomicReference<String> param2 = new AtomicReference<>("");
        AtomicReference<String> opt = new AtomicReference<>("");

        //初始化按键

        returnZero = new CircleButton("C");
        returnZero.addActionListener(e -> {
            text.setText("0");
            param1.set("");
            param2.set("");
            opt.set("");
        });


        add = new CircleButton("＋");
        add.addActionListener(e -> {
            if (!Objects.equals(param1.get(), "") && Objects.equals(param2.get(), "")) {
                opt.set("＋");
            }else if (!Objects.equals(param1.get(), "") && !Objects.equals(param2.get(), "") && !Objects.equals(opt.get(), "")){
                int n1 = Integer.parseInt(param1.get());
                int n2 = Integer.parseInt(param2.get());
                text.setText(String.valueOf(cal(n1,n2,opt.get())));
                param1.set(text.getText());
                param2.set("");
                opt.set("＋");
            }
        });


        reduce = new CircleButton("－");
        reduce.addActionListener(e -> {
            if (!Objects.equals(param1.get(), "") && Objects.equals(param2.get(), "")) {
                opt.set("－");
            }else if (!Objects.equals(param1.get(), "") && !Objects.equals(param2.get(), "") && !Objects.equals(opt.get(), "")){
                int n1 = Integer.parseInt(param1.get());
                int n2 = Integer.parseInt(param2.get());
                text.setText(String.valueOf(cal(n1,n2,opt.get())));
                param1.set(text.getText());
                param2.set("");
                opt.set("－");
            }
        });

        multiple = new CircleButton("×");
        multiple.addActionListener(e -> {
            if (!Objects.equals(param1.get(), "") && Objects.equals(param2.get(), "")) {
                opt.set("×");
            }else if (!Objects.equals(param1.get(), "") && !Objects.equals(param2.get(), "") && !Objects.equals(opt.get(), "")){
                int n1 = Integer.parseInt(param1.get());
                int n2 = Integer.parseInt(param2.get());
                text.setText(String.valueOf(cal(n1,n2,opt.get())));
                param1.set(text.getText());
                param2.set("");
                opt.set("×");
            }
        });


        except = new CircleButton("÷");
        except.addActionListener(e -> {
            if (!Objects.equals(param1.get(), "") && Objects.equals(param2.get(), "")) {
                opt.set("÷");
            }else if (!Objects.equals(param1.get(), "") && !Objects.equals(param2.get(), "") && !Objects.equals(opt.get(), "")){
                int n1 = Integer.parseInt(param1.get());
                int n2 = Integer.parseInt(param2.get());
                text.setText(String.valueOf(cal(n1,n2,opt.get())));
                param1.set(text.getText());
                param2.set("");
                opt.set("÷");
            }
        });


        residual = new CircleButton("%");
        residual.addActionListener(e -> {
            if (!Objects.equals(param1.get(), "") && Objects.equals(param2.get(), "")) {
                opt.set("%");
            }else if (!Objects.equals(param1.get(), "") && !Objects.equals(param2.get(), "") && !Objects.equals(opt.get(), "")){
                int n1 = Integer.parseInt(param1.get());
                int n2 = Integer.parseInt(param2.get());
                text.setText(String.valueOf(cal(n1,n2,opt.get())));
                param1.set(text.getText());
                param2.set("");
                opt.set("%");
            }
        });


        delete = new CircleButton("<");
        delete.addActionListener(e -> {
            try {
                text.setText(text.getText(0,text.getText().length()-1));
            } catch (BadLocationException badLocationException) {
                badLocationException.printStackTrace();
            }
        });


        num1 = new CircleButton("1");
        num1.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("1");
                else
                    text.setText(text.getText() + "1");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("1");
                }else {
                    text.setText(text.getText() + "1");
                }
                param2.set(text.getText());
            }
        });

        num2 = new CircleButton("2");
        num2.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("2");
                else
                    text.setText(text.getText() + "2");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("2");
                }else {
                    text.setText(text.getText() + "2");
                }
                param2.set(text.getText());
            }
        });


        num3 = new CircleButton("3");
        num3.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("3");
                else
                    text.setText(text.getText() + "3");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("3");
                }else {
                    text.setText(text.getText() + "3");
                }
                param2.set(text.getText());
            }
        });


        num4 = new CircleButton("4");
        num4.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("4");
                else
                    text.setText(text.getText() + "4");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("4");
                }else {
                    text.setText(text.getText() + "4");
                }
                param2.set(text.getText());
            }
        });


        num5 = new CircleButton("5");
        num5.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("5");
                else
                    text.setText(text.getText() + "5");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("5");
                }else {
                    text.setText(text.getText() + "5");
                }
                param2.set(text.getText());
            }
        });


        num6 = new CircleButton("6");
        num6.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("6");
                else
                    text.setText(text.getText() + "6");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("6");
                }else {
                    text.setText(text.getText() + "6");
                }
                param2.set(text.getText());
            }
        });


        num7 = new CircleButton("7");
        num7.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("7");
                else
                    text.setText(text.getText() + "7");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("7");
                }else {
                    text.setText(text.getText() + "7");
                }
                param2.set(text.getText());
            }
        });


        num8 = new CircleButton("8");
        num8.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("8");
                else
                    text.setText(text.getText() + "8");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("8");
                }else {
                    text.setText(text.getText() + "8");
                }
                param2.set(text.getText());
            }
        });


        num9 = new CircleButton("9");
        num9.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("9");
                else
                    text.setText(text.getText() + "9");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("9");
                }else {
                    text.setText(text.getText() + "9");
                }
                param2.set(text.getText());
            }
        });


        num0 = new CircleButton("0");
        num0.addActionListener(e -> {
            if (Objects.equals(opt.get(), "")){
                if (Objects.equals(text.getText(), "0"))
                    text.setText("0");
                else
                    text.setText(text.getText() + "0");
                param1.set(text.getText());
            }else {
                if (Objects.equals(param2.get(), "")){
                    text.setText("0");
                }else {
                    text.setText(text.getText() + "0");
                }
                param2.set(text.getText());
            }
        });



        dot = new CircleButton(".");
        dot.addActionListener(e -> text.setText(text.getText()+"."));


        result = new CircleButton("＝");
        result.addActionListener(e -> {
            if (!Objects.equals(param1.get(), "") && !Objects.equals(param2.get(), "") && !Objects.equals(opt.get(), "")){
                int n1 = Integer.parseInt(param1.get());
                int n2 = Integer.parseInt(param2.get());
                text.setText(String.valueOf(cal(n1,n2,opt.get())));
                param1.set(text.getText());
            }
        });

        jPanel.add(returnZero);
        jPanel.add(except);
        jPanel.add(multiple);
        jPanel.add(delete);

        jPanel.add(num7);
        jPanel.add(num8);
        jPanel.add(num9);
        jPanel.add(reduce);

        jPanel.add(num4);
        jPanel.add(num5);
        jPanel.add(num6);
        jPanel.add(add);

        jPanel.add(num1);
        jPanel.add(num2);
        jPanel.add(num3);
        jPanel.add(result);

        jPanel.add(residual);
        jPanel.add(num0);
        jPanel.add(dot);

        linear.add(jPanel,BorderLayout.CENTER);

        //设置键盘左右边距
        JPanel leftWhite = new JPanel();
        leftWhite.setPreferredSize(new Dimension(15,500));
        leftWhite.setBackground(Color.lightGray);
        linear.add(leftWhite,BorderLayout.WEST);
        JPanel rightWhite = new JPanel();
        rightWhite.setPreferredSize(new Dimension(15,500));
        rightWhite.setBackground(Color.lightGray);
        linear.add(rightWhite,BorderLayout.EAST);

        //设置内容布局到顶层布局
        jFrame.add(linear);
        jFrame.setBounds(600,80,420,700);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new MyCalculator().start();
    }
}
