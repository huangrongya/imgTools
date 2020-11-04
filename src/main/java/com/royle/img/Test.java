package com.royle.img;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        try {
            String img = "http://wx1.sinaimg.cn/mw600/72453b34gy1gkb7oirmv2j20gi0gg7iu.jpg";

            ImgBean anchorImgBean = new ImgBean();
            anchorImgBean.setBufferedImage(CopeImgUtil.cutHeadImages(img));
            anchorImgBean.setLeft(27*3);
            anchorImgBean.setTop(15*3);
            anchorImgBean.setImg_width(32*3);
            anchorImgBean.setImg_height(32*3);

            URL posterUrl = new URL("http://wx2.sinaimg.cn/mw600/00869HDlly1gkd38r2l2yj30fl0flam1.jpg");
            ImgBean posterBean = new ImgBean();
            posterBean.setStream(posterUrl.openStream());
            posterBean.setLeft(27*3);
            posterBean.setTop(60*3);
            posterBean.setImg_width(215*3);
            posterBean.setImg_height(215*3);

            URL zbygUrl= new URL("http://img.sjgo365.com/sjgo/unified-platform/miniApp/liveCloud/zbyg.png");
            ImgBean zbygBean = new ImgBean();
            zbygBean.setStream(zbygUrl.openStream());
            zbygBean.setLeft(24*3);
            zbygBean.setTop(310*3);
            zbygBean.setImg_height(15*3);
            zbygBean.setImg_width(55*3);

            URL qrCodeUrl= new URL("http://img.mx.cqssds.com/unified-platform/upload/qrCode/2020/10/6FACE3DBB4E583FBBA5A882473972515.png");
            ImgBean qrCodeBean = new ImgBean();
            qrCodeBean.setStream(qrCodeUrl.openStream());
            qrCodeBean.setLeft(92*3);
            qrCodeBean.setTop(347*3);
            qrCodeBean.setImg_height(85*3);
            qrCodeBean.setImg_width(85*3);

            //文字
            TextBean anchorNameBean = new TextBean();
            anchorNameBean.setText("重百主播9527");
            anchorNameBean.setLeft(67*3);
            anchorNameBean.setTop(35*3);
            Font anchorNameFont = new Font("PingFang SC Regular", Font.PLAIN, 13*3);
            anchorNameBean.setFont(anchorNameFont);
            anchorNameBean.setColor(Color.black);

            TextBean roomNameBean = new TextBean();
            roomNameBean.setText("重百百年大促直播间");
            roomNameBean.setLeft(27*3);
            roomNameBean.setTop(300*3);
            Font roomNameFont = new Font("PingFang SC Regular", Font.PLAIN, 15*3);
            roomNameBean.setFont(roomNameFont);
            roomNameBean.setColor(Color.black);

            TextBean timeBean = new TextBean();
            timeBean.setText("2020年07月11日 12:00");
            timeBean.setLeft(82*3);
            timeBean.setTop(322*3);
            Font timeFont = new Font("PingFang SC Regular", Font.PLAIN, 12*3);
            timeBean.setFont(timeFont);
            timeBean.setColor(Color.black);

            TextBean enterBean = new TextBean();
            enterBean.setText("长按扫码进入直播间");
            enterBean.setLeft(85*3);
            enterBean.setTop(450*3);
            Font enterFont = new Font("PingFang SC Regular", Font.PLAIN, 11*3);
            enterBean.setFont(enterFont);
            enterBean.setColor(new Color(0xA4686868, true));

            List<ImgBean> imgBeans = new ArrayList<ImgBean>();
            imgBeans.add(anchorImgBean);
            imgBeans.add(posterBean);
            imgBeans.add(zbygBean);
            imgBeans.add(qrCodeBean);

            List<TextBean> textBeans = new ArrayList<TextBean>();
            textBeans.add(anchorNameBean);
            textBeans.add(roomNameBean);
            textBeans.add(timeBean);
            textBeans.add(enterBean);
            ImgJoinUtil.createColorImg(269*3, 481*3, new Color(255,255,255), "C:\\temp\\test.png", imgBeans, textBeans);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
