package com.yaqiwe.mall.util;

import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.vo.Resoult;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:33
 * @Version 1.0
 */
public class ResoultUtil {

    //成功
    public static Resoult success(Object data){
        Resoult resoult=new Resoult();
        resoult.setCode(200);
        resoult.setMessage("成功");
        resoult.setData(data);
        return resoult;
    }

    public static Resoult success(){
        return success(null);
    }

    //失败
    public static Resoult error(Integer code,String msg){
        Resoult resoult=new Resoult();
        resoult.setCode(code);
        resoult.setMessage(msg);
        return resoult;
    }

    public static Resoult error(MallEnums emuns){
        return error(emuns.getCode(),emuns.getMsg());
    }

}
