package com.mty.food.truck.exception;

import com.mty.food.truck.common.R;
import com.mty.food.truck.common.ResultCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

//异常处理
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {
    //注解中的value可以指定捕获的异常类型，可以支持多个异常

    @ExceptionHandler(value = Exception.class)  //内部错误
    @ResponseBody
    public Object handle(HttpServletRequest req, Exception e) {
        log.error("---exception Handler---Host {} invokes url {} ERROR: ", req.getRemoteHost(), req.getRequestURL(), e);
        if (e.getMessage().contains("ClientAbortException")) {
            return R.fail(ResultCode.FAILURE.getCode(), "当前访问量过大，请稍后重试!");
        }
        if (e.getMessage().contains("SQLIntegrityConstraintViolationException")) {
            return R.fail(ResultCode.FAILURE.getCode(), "数据已存在,请勿重复提交保存");
        }
        return R.fail(ResultCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MobileFoodException.class)
    @ResponseBody
    public Object handleOilException(HttpServletRequest req, MobileFoodException e) {
//        log.error("---exception handleOilException---Host {} invokes url {} ERROR: ", req.getRemoteHost(), req.getRequestURL(), e);
        return R.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object parameterBodyMissingExceptionHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
//        log.error("---exception parameterBodyMissingExceptionHandler---Host {} invokes url {} ERROR: ", req.getRemoteHost(), req.getRequestURL(), e);
        return  R.fail(ResultCode.PARAMS.getCode(), "参数体不能为空");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object parameterMissingExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException e) {
//        log.error("---exception parameterMissingExceptionHandler---Host {} invokes url {} ERROR: ", req.getRemoteHost(), req.getRequestURL(), e);
        return R.fail(ResultCode.PARAMS.getCode(), "请求参数 " + e.getParameterName() + " 不能为空");
    }

    /**
     *Validated抛出的参数验证异常，不会进入到aop中
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) {
//        log.error("---exception handleMethodArgumentNotValidException---Host {} invokes url {} ERROR: ", req.getRemoteHost(), req.getRequestURL(), e);
        String errMsg = Optional.ofNullable(e.getBindingResult().getFieldError()).map(FieldError::getDefaultMessage).orElse("");
        return R.fail(ResultCode.PARAMS.getCode(), errMsg);
    }


    @ExceptionHandler(value = BindException.class)
    public Object buildBindException(HttpServletRequest req,BindException e) {
//        log.error("---exception buildBindException---Host {} invokes url {} ERROR: ", req.getRemoteHost(), req.getRequestURL(), e);
        String errMsg = Optional.ofNullable(e.getBindingResult().getFieldError()).map(FieldError::getDefaultMessage).orElse("");
        return R.fail(ResultCode.PARAMS.getCode(), errMsg);
    }

}

