package com.runpowerback.runpowerback.exposition.exception;

import com.runpowerback.runpowerback.domaine.exception.MyProjectException400;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException404;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.RunpowerbackApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.runpowerback.runpowerback")
public class MyExceptionHandler {

    private static final Logger logger = LogManager.getLogger(RunpowerbackApplication.class);


    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Set<String> handleSpringSurfaceException(MethodArgumentNotValidException exception) {
        Set<String> surfaceErrors = exception.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toSet());

        logger.debug(surfaceErrors.toString());
        return new TreeSet<>(surfaceErrors);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = MyProjectException500.class)
    public Set<String> handleBusinessException(MyProjectException500 exceptions) {
        Set<String> exceptionsErrors = exceptions.getCodeErreurs();

        logger.debug(exceptionsErrors.toString());
        return new TreeSet<>(exceptionsErrors);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = MyProjectException404.class)
    public Set<String> handleBusinessException(MyProjectException404 exceptions) {
        Set<String> exceptionsErrors = exceptions.getCodeErreurs();

        logger.debug(exceptionsErrors.toString());
        return new TreeSet<>(exceptionsErrors);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MyProjectException400.class)
    public Set<String> handleBusinessException(MyProjectException400 exceptions) {
        Set<String> exceptionsErrors = exceptions.getCodeErreurs();

        logger.debug(exceptionsErrors.toString());
        return new TreeSet<>(exceptionsErrors);
    }

}