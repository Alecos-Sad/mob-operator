package by.sadovnick.moboperator.aop;

import by.sadovnick.moboperator.dto.ClientDto;
import by.sadovnick.moboperator.exception.NotNullException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Aspect for class ClientServiceImpl with logging
 * @see ClientDto
 * @see by.sadovnick.moboperator.service.impl.ClientServiceImpl
 */
@Aspect
@Log4j2
@Component
public class ClientAspect {

    /**
     * Aspecting Methods for Saving Entities to a Database
     * @param joinPoint method interception point
     * @return result of the aspect
     */
    @Around("Pointcuts.saveMethods()")
    public Object aroundSavingAdvise(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ClientDto clientDto = null;
        if (methodSignature.getName().equals("save")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof ClientDto) {
                    clientDto = (ClientDto) arg;
                    log.info("Try to add client with name: {}", clientDto.getName());
                }
            }
        }
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            result = new NotNullException("EXCEPTION");
        }
        log.info("Client with name {} and surname {} is added", clientDto.getName(), clientDto.getSurName());
        return result;
    }
}
