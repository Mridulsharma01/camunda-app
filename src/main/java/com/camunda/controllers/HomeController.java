package com.camunda.controllers;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "This is camunda test";
    }
    @GetMapping("/execute")
    public String executeBPMN(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance =  engine.getRuntimeService().createProcessInstanceByKey("firstBPMN");
        String item = "Mridul Sharma";
        instance.setVariable("itemName", item);
        instance.businessKey("execute-endpoint");
        instance.executeWithVariablesInReturn();
        return "BPMN is executed";
    }
    @GetMapping("/tasks")
    public String executeTasks(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("task_execute");
        instance.executeWithVariablesInReturn();
        return "all Tasks BPMN executed";
    }
}
