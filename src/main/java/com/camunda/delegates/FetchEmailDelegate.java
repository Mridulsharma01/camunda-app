package com.camunda.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmailDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Coming from Java Delegate");
        System.out.println("Global variabe userObj2: "+ delegateExecution.getVariable("userObj2"));
        System.out.println("input variabe inputObj: "+ delegateExecution.getVariable("inputObj"));
        delegateExecution.setVariable("email","acbd@gamil.com");
        delegateExecution.setVariable("name","Arnav Koul");
//        delegateExecution.setVariable("usero","acbd@gamil.com");
    }
}
