package com.student.config.aop;


import com.student.api.response.ApiResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class CustomValidatorAspect {

    @Pointcut("@annotation(com.student.config.aop.AutoValidator))")
    public void autoValidator() {

    }

    @Around("autoValidator()")
    public Object validationCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if ( arg instanceof BindingResult ) {
                BindingResult bindingResult = (BindingResult) arg;

                if ( bindingResult.hasErrors()) {
                    return ApiResponse.bindError("잘못된 요청입니다.", bindingResult);
                }
            }
        }
        return joinPoint.proceed();
    }
}
