package info;


import javax.swing.*;

public class AircraftModel extends JLabel {
    /**
     * 飞机图片的路径
     */
    String src = "picture/aircraft.png";

    JLabel label = this;
    /**
     * 距离窗口顶端的位置
     */
    int x;

    /**
     * 距离窗口右边的位置
     */
    int y;

    /**
     * 飞机步长
     */
    public int step = 1;

    /**
     * 飞机向上的按键的id
     * 可以使用util.TestKeyBoardID获取键盘id
     */
    int up = 87;

    /**
     * 飞机向下的按键的id
     * 可以使用util.TestKeyBoardID获取键盘id
     */
    int down = 83;

    /**
     * 飞机向左的按键的id
     * 可以使用util.TestKeyBoardID获取键盘id
     */
    int left = 65;

    /**
     * 飞机向右的按键
     * 可以使用util.TestKeyBoardID获取键盘id
     */
    int right = 68;


    /**
     * @param x 飞机与窗口右边的距离
     * @param y 飞机与窗口顶端的距离
     */
    public AircraftModel(int x,int y){
        // 赋值
        this.x=x;
        this.y=y;

        ImageIcon image=new ImageIcon(src);
        label.setIcon(image);
        label.setBounds(this.x,this.y,100,100);
    }


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

}
