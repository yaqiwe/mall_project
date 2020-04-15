package com.yaqiwe.mall.handler;

import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.util.ResoultUtil;
import com.yaqiwe.mall.vo.Resoult;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 13:48
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
public class MallExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resoult errorHandler(Exception e){
        /*自定义的错误类型*/
        if (e instanceof MallException) {
            MallException ce = (MallException) e;
            return ResoultUtil.error(ce.getCode(), ce.getMessage());
        }
        //其他异常，打印控制台
        e.printStackTrace();
        return ResoultUtil.error(MallEnums.UNKNOWN_ERROR);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Resoult missingServletRequestParameterException(MissingServletRequestParameterException e){
        return ResoultUtil.error(MallEnums.PARAMETER_NOT_PRESENT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Resoult httpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResoultUtil.error(MallEnums.PARAMETER_NOT_PRESENT);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Resoult httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ResoultUtil.error(MallEnums.NOT_SUPPORTED);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Resoult methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return ResoultUtil.error(MallEnums.TYPE_MISMATCH);
    }
    /**
     * 单个参数校验
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Resoult handleBindGetException(ConstraintViolationException ex){
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return  ResoultUtil.error(MallEnums.PARAMETER_ERROR.getCode(),defaultMsg.toString());
    }
}
