package com.royle.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;


public class ImgBean {

    //图片文件
    private File file;

    private InputStream stream;

    private BufferedImage bufferedImage;

    //距左距离
    private int left;

    //距上距离
    private int top;

    //图片宽度
    private int img_height;

    //图片高度
    private int img_width;

    public ImgBean(File file, int left, int top) {
        this.file = file;
        this.left = left;
        this.top = top;

    }

    public ImgBean(File file, int left, int top, int img_height, int img_width) {
        this.file = file;
        this.left = left;
        this.top = top;
        this.img_height = img_height;
        this.img_width = img_width;
    }

    public ImgBean() {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getImg_height() {
        return img_height;
    }

    public void setImg_height(int img_height) {
        this.img_height = img_height;
    }

    public int getImg_width() {
        return img_width;
    }

    public void setImg_width(int img_width) {
        this.img_width = img_width;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    //控制最高和最宽，如果是图片不够
    public void setMaxWidthAndHeight(int maxWidth, int maxHeight) {
        BufferedImage bufferedImage = getBufferedImageByFileAndStream();
        if (null == bufferedImage) {
            return;
        }

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        //首先计算宽度
        if (maxWidth > 0) {
            //计算宽的比例
            BigDecimal bili_w = new BigDecimal(maxWidth).divide(new BigDecimal(width), 2, BigDecimal.ROUND_HALF_UP);
            width = maxWidth;

            //得到比例后的高
            height = bili_w.multiply(new BigDecimal(height)).intValue();
        }

        //在判断高度
        if (maxHeight > 0 && height > maxHeight) {
            //计算高的比例
            BigDecimal bili_w = new BigDecimal(maxHeight).divide(new BigDecimal(height), 2, BigDecimal.ROUND_HALF_UP);
            height = maxHeight;

            //得到比例后的宽
            width = bili_w.multiply(new BigDecimal(width)).intValue();
        }
        if (width > 0) {
            setImg_width(width);
        }
        if (height > 0) {
            setImg_height(height);
        }
    }


    //得到图片
    public BufferedImage getBufferedImageByFileAndStream() {
        if (null == file) {
            return null;
        }

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null == bufferedImage || bufferedImage.getHeight() < 1 || bufferedImage.getWidth() < 1) {
            return null;
        }
        return bufferedImage;
    }

    //根据宽度放大图片
    public void toWidthUpperCase(int maxWidth) {
        BufferedImage bfimg = getBufferedImageByFileAndStream();
        if (null == bfimg) {
            return;
        }

        int height = bfimg.getHeight();
        int width = bfimg.getWidth();

        //如果小于才进行放大操作，否则不操作
        if (width < maxWidth) {
            try {
                //计算比例
                BigDecimal bili_w = new BigDecimal(maxWidth).divide(new BigDecimal(width), 2, BigDecimal.ROUND_HALF_UP);
                width = maxWidth;

                //得到比例后的宽
                height = bili_w.multiply(new BigDecimal(height)).intValue();

                //进行图片处理
                Image srcImg = ImageIO.read(getFile());

                BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                buffImg.getGraphics().drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

                ImageIO.write(buffImg, "JPEG", file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
