package com.royle.img;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        try {
            URL url= new URL("http://ww1.sinaimg.cn/mw600/785f6650gy1gjj4oxr86tj20u00u0acl.jpg");
            URL zbygUrl= new URL("http://img.sjgo365.com/sjgo/unified-platform/miniApp/liveCloud/zbyg.png");
            ImgBean bean1 = new ImgBean();
            bean1.setStream(zbygUrl.openStream());
            bean1.setLeft(0);
            bean1.setTop(0);

            URL url2= new URL("http://img.mx.cqssds.com/unified-platform/upload/qrCode/2020/10/6FACE3DBB4E583FBBA5A882473972515.png");
            ImgBean bean2 = new ImgBean();
            bean2.setStream(url2.openStream());
            bean2.setLeft(100);
            bean2.setTop(200);

            List<ImgBean> imgBeans = new ArrayList<ImgBean>();
            imgBeans.add(bean1);
            imgBeans.add(bean2);
            ImgJoinUtil.createColorImg(800, 800, new Color(255,255,255), "C:\\temp\\test.png", imgBeans, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
