package rest.com;

/**
 * Created by Janith on 5/8/2015.
 */
public class Captcha {

    public String captcha = null;
    public int width =0;
    public int height =0;

    public void setCaptcha(String cpatcha){
        this.captcha =captcha;
    }

    public String getCaptcha(){
        return this.captcha;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return this.height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return this.width;
    }

}
