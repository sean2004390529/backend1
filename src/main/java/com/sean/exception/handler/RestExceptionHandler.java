package com.sean.exception.handler;


import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.utils.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public DataResult exception(Exception e){
//        log.error("Exception,{},{}",e.getLocalizedMessage(),e);
    	System.out.println("Exception: " + e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = BusinessException.class)
    public DataResult businessException(BusinessException e){
//        log.error("businessException,{},{}",e.getLocalizedMessage(),e);
    	System.out.println("BusinessException: " + e.getLocalizedMessage());
        return DataResult.getResult(e.getCode(),e.getDefaultMessage());
    }
    
    // 数据校验 异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> DataResult<T> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

//        log.error("methodArgumentNotValidExceptionHandler bindingResult.allErrors():{},exception:{}", e.getBindingResult().getAllErrors(), e);
    	System.out.println("methodArgumentNotValidExceptionHandler: " + e.getLocalizedMessage());
    	List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return createValidExceptionResp(errors);
    }
    
    private <T> DataResult<T> createValidExceptionResp(List<ObjectError> errors) {
        String[] msgs = new String[errors.size()];
        int i = 0;
        for (ObjectError error : errors) {
            msgs[i] = error.getDefaultMessage();
//            log.info("msg={}",msgs[i]);
            System.out.println("msg=" + msgs[i]);
            i++;
        }
        return DataResult.getResult(BaseResponseCode.METHOD_IDENTITY_ERROR.getCode(), msgs[0]);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public DataResult unauthorizedException(UnauthorizedException e){
//        log.error("UnauthorizedException,{},{}",e.getLocalizedMessage(),e);
    	System.out.println("UnauthorizedException: " + e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.NOT_PERMISSION);
    }
}
