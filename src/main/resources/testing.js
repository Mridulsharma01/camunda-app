print("coming from service task java delegate global variable email ::", JSON.stringify(email))
print("updated name using execution.setVariable in service task " + execution.getVariable("name"))
userObj.email = email
//print("coming from init user task" + execution.getVariable("user"))


