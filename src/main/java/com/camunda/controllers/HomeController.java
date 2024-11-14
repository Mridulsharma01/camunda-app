package com.camunda.controllers;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "This is camunda test";
    }
    @GetMapping("/execute/{processId}")
    public String executeBPMN(@PathVariable("processId") String processId){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance =  engine.getRuntimeService().createProcessInstanceByKey(processId);
        String item = "Mridul Sharma";
        instance.setVariable("itemName", item);
        instance.businessKey("execute-endpoint");
        instance.executeWithVariablesInReturn();
        return "BPMN is executed";
    }
}
