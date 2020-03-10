package com.twelvefactor.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

//	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
//    /**
//     * Pointcut that matches all repositories, services and Web REST endpoints.
//     */
//    @Pointcut("within(@org.springframework.stereotype.Repository *)"
//            + " || within(@org.springframework.stereotype.Service *)"
//            + " || within(@org.springframework.web.bind.annotation.RestController *)")
//    public void springBeanPointcut() {
//        // Method is empty as this is just a Pointcut, the implementations are in the advices.
//    }
//
//    /**
//     * Pointcut that matches all Spring beans in the application's main packages.
//     */
//    @Pointcut("within(com.twelvefactor.entity..*)" +
//        " || within(com.twelvefactor.service..*)" +
//        " || within(com.twelvefactor.repository..*)" +
//        " || within(com.twelvefactor.controller..*)")
//    public void applicationPackagePointcut() {
//        // Method is empty as this is just a Pointcut, the implementations are in the advices.
//    }
//
//    /**
//     * Advice that logs methods throwing exceptions.
//     *
//     * @param joinPoint join point for advice
//     * @param e exception
//     */
//    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
//            joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
//    }
//
    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	      System.out.println("applicationPackagePointcut");
	  try {
	      Object result = joinPoint.proceed();
//	          log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//	              joinPoint.getSignature().getName(), result);
	      return result;
	  } catch (IllegalArgumentException e) {
//	      log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//	          joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
	      throw e;
	  }
	  
//        if (log.isDebugEnabled()) {
//            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//        }
//        try {
//            Object result = joinPoint.proceed();
//            if (log.isDebugEnabled()) {
//                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), result);
//            }
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//            throw e;
//        }
    }
	
}
