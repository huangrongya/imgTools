package com.royle.img;

import java.util.Collection;

public class CollectionUtils {

    /**
     * @Author royle.huang
     * @Date 17:28 2019/10/24
     * @Description 集合是否为空
     **/
    public static boolean isEmptyCollection(Collection collection){
        if (collection==null||collection.isEmpty()){
            return true;
        }
        return false;
    }


    public static boolean isNotEmptyCollection(Collection collection) {
        return !isEmptyCollection(collection);
    }
}
