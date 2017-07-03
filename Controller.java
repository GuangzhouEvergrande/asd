package sample;

import java.lang.reflect.Field;

public class Controller {
    private double CNY = 1.0000;//人民币
    private double HKD = 1.1417;//1 人民币 = 1.1417 港元(HKD)
    private double MOP = 1.1763;//1 人民币 = 1.1763 澳门元(MOP)
    private double TWD = 4.4643;//1 人民币 = 4.4643 台币(TWD)
    private double EUR = 0.1315;//1 人民币 = 0.1315 欧元(EUR)
    private double USD = 0.1464;//1 人民币 = 0.1464 美元(USD)
    private double GBP = 0.1162;//1 人民币 = 0.1162 英镑(GBP)
    private double KRW = 167.5350;//1 人民币 = 167.5350 韩元(KRW)
    private double AUD = 0.1890;//1 人民币 = 0.1890 澳元(AUD)
    private double JPY = 16.2560;//1 人民币 = 16.2560 日元(JPY)
    private double CAD = 0.1943;//1 人民币 = 0.1943 加拿大元(CAD)
    private double RUB = 8.7916;//1 人民币 = 8.7916 俄罗斯卢布(RUB)
    private double THB = 4.9862;//1 人民币 = 4.9862 泰国铢(THB)
    private double PHP = 7.3845;//1 人民币 = 7.3845 菲律宾比索(PHP)

    //转换
    public double change(double resource,String option1,String option2){
        Class clazz = this.getClass();
        try {
            Field field1 = clazz.getDeclaredField(option1);
            Field field2 = clazz.getDeclaredField(option2);
            double num1 = (double)field1.get(this);
            double num2 = (double)field2.get(this);
            return ((resource/num1)*num2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public double getHKD() {
        return HKD;
    }

    public void setHKD(double HKD) {
        this.HKD = HKD;
    }

    public double getMOP() {
        return MOP;
    }

    public void setMOP(double MOP) {
        this.MOP = MOP;
    }

    public double getTWD() {
        return TWD;
    }

    public void setTWD(double TWD) {
        this.TWD = TWD;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getGBP() {
        return GBP;
    }

    public void setGBP(double GBP) {
        this.GBP = GBP;
    }

    public double getKRW() {
        return KRW;
    }

    public void setKRW(double KRW) {
        this.KRW = KRW;
    }

    public double getAUD() {
        return AUD;
    }

    public void setAUD(double AUD) {
        this.AUD = AUD;
    }

    public double getJPY() {
        return JPY;
    }

    public void setJPY(double JPY) {
        this.JPY = JPY;
    }

    public double getCAD() {
        return CAD;
    }

    public void setCAD(double CAD) {
        this.CAD = CAD;
    }

    public double getRUB() {
        return RUB;
    }

    public void setRUB(double RUB) {
        this.RUB = RUB;
    }

    public double getTHB() {
        return THB;
    }

    public void setTHB(double THB) {
        this.THB = THB;
    }

    public double getPHP() {
        return PHP;
    }

    public void setPHP(double PHP) {
        this.PHP = PHP;
    }

    public double getCNY() {
        return CNY;
    }

    public void setCNY(double CNY) {
        this.CNY = CNY;
    }
}
