package com.belong.smart.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import com.belong.smart.entity.ResultBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 断点异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResultBean handler(IllegalArgumentException e) throws IOException {
        log.error("Assert异常:-------------->",e);
        return ResultBean.fail(e.getMessage());
    }

    // 实体类校验异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultBean handler(MethodArgumentNotValidException e) throws IOException {
        log.error("实体类校验异常:-------------->",e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return ResultBean.fail("401", objectError.getDefaultMessage(), null);
    }

    // 处理运行时异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResultBean handler(RuntimeException e) throws IOException {
        log.error("运行时异常:-------------->",e);
        return ResultBean.fail(e.getMessage());
    }
}
