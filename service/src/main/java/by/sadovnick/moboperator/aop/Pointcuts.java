package by.sadovnick.moboperator.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Сlass describing the entry points for the aspect.
 */
public class Pointcuts {

    /**
     * Entry point for "save" methods.
     */
    @Pointcut("execution(* by.sadovnick.moboperator.service.ClientService.save(..))")
    public void saveMethods() {
    }

    /**
     * Entry point for "add" methods
     */
    @Pointcut("execution(* by.sadovnick.moboperator.service.ClientService.add*(..))")
    public void allAddMethods() {
    }
}
