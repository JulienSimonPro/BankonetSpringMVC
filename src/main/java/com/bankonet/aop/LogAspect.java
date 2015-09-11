package com.bankonet.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("logAspect")
// @Aspect
public class LogAspect {

	final String pointCutString = "(execution(* com.bankonet.dao.*.*(..)) || execution(* com.bankonet.metier.*.*(..)))";

	@Before(pointCutString)
	@Order(0)
	public void logBefore(JoinPoint point) {
		System.out.println("--------------- AOP/before/1 ---------------");
		System.out.println("Appel de " + point.getSignature().getName());
		System.out.println("--------------- AOP/before/2 ---------------");
	}

	@AfterReturning(pointcut = pointCutString, returning = "result")
	@Order(1)
	public void logAfterReturning(JoinPoint point, Object result) {
		System.out.println("--------------- AOP/after/1 ---------------");
		System.out.println("Appel de " + point.getSignature().getName() + " retourne " + result);
		System.out.println("--------------- AOP/after/2 ---------------");
	}

	@Around(pointCutString)
	@Order(2)
	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		try {
			System.out.println("--------------- AOP/around/1 ---------------");
			Object result = point.proceed();
			System.out.println("--------------- AOP/around/2/ok ---------------");
			return result;
		} catch (Throwable t) {
			System.out.println("--------------- AOP/around/2/exception ---------------");
			throw t;
		}
	}
}
