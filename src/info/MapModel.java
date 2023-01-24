package info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MapModel extends JFrame {

    JFrame jf = this;

    /**
     * 地图模型宽度
     */
    int width;

    /**
     * 地图模型高度
     */
    int height;

    /**
     * 飞机模型
     */
    AircraftModel aircraftModel;

    /**
     * 是否开启窗体边框的体积碰撞
     */
    boolean is_windowEdge = false;

    /**
     * @param width 窗体宽度
     * @param height 窗体高度
     * @param aircraftModel 飞机模型
     */
    public MapModel(int width,int height,AircraftModel aircraftModel){
        // 赋值
        this.width=width;
        this.height=height;
        this.aircraftModel=aircraftModel;

        this.setBounds(100,100,width,height);
        this.setLayout(null);

        init();

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() {
        this.add(aircraftModel);
        /*
          按键控制
         * 可以使用util.TestKeyBoardID获取键盘id
         */
        Toolkit.getDefaultToolkit().addAWTEventListener(event ->  {
                if ((event).getID() == KeyEvent.KEY_PRESSED) {
                    int code = ((KeyEvent) event).getKeyCode();
                    if (code == aircraftModel.up){
                        aircraftModel.setY(aircraftModel.getY()-aircraftModel.step);
                    } else if (code == aircraftModel.down){
                        aircraftModel.setY(aircraftModel.getY()+aircraftModel.step);
                    } else if (code == aircraftModel.left){
                        aircraftModel.setX(aircraftModel.getX()-aircraftModel.step);
                    } else if (code == aircraftModel.light){
                        aircraftModel.setX(aircraftModel.getX()+aircraftModel.step);
                    }

                    // 检测碰撞到周围
                    checkBoundary(aircraftModel, is_windowEdge);

                    // 刷新窗体
                    SwingUtilities.updateComponentTreeUI(jf);
                    jf.invalidate();
                    jf.validate();
                    jf.repaint();
                }
        }, AWTEvent.KEY_EVENT_MASK);
    }

    /**
     * 检测碰撞到周围
     * @param aircraft 飞机模型对象
     */
    public void checkBoundary(AircraftModel aircraft,boolean is_windowEdge) {
        if (!is_windowEdge) {
            return;
        }

        if (aircraft.getX() < 0) {
            aircraft.setX(0);
        }
        if (aircraft.getY() < 0) {
            aircraft.setY(0);
        }
        if (aircraft.getX() > width - aircraft.getWidth()) {
            aircraft.setX(width - aircraft.getWidth());
        }
        if (aircraft.getY() > height - aircraft.getHeight()) {
            aircraft.setY(height - aircraft.getHeight());
        }
    }


    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AircraftModel getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(AircraftModel aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public boolean isIs_windowEdge() {
        return is_windowEdge;
    }

    public void setIs_windowEdge(boolean is_windowEdge) {
        this.is_windowEdge = is_windowEdge;
    }
}
