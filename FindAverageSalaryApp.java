import java.util.HashMap;
import java.util.List;
 
 

public class FindAverageSalaryApp {

  public void findAverageSalary(List<Employee> employees){

  //store key = city@designation and value = count@salary
    HashMap<String, String> locRoleSalMap = new HashMap<>();
    
    for (Employee e : employees) {
      if (locRoleSalMap.containsKey(e.getOfficeLocation()+"@"+e.getDesignation())) {
          String value = locRoleSalMap.get(e.getOfficeLocation()+"@"+e.getDesignation());
          int empCount = new Integer(value.split("@")[0]).intValue() + 1;
          Double salary = new Double(value.split("@")[1]) + e.getSalary();
          locRoleSalMap.put(e.getOfficeLocation()+"@"+e.getDesignation(),empCount+"@"+salary);
      } else
          locRoleSalMap.put(e.getOfficeLocation()+"@"+e.getDesignation(),1+"@"+e.getSalary());
    }
    
     
    
    for (String key : locRoleSalMap.keySet()) {
        String value = locRoleSalMap.get(key);
        String location = key.split("@")[0];
        String designation = key.split("@")[1];
        Double avgSal = new Double(value.split("@")[1])/new Double(value.split("@")[0]);
        
        
        System.out.println(location + " --> " + designation + " --> " + avgSal);
    }

}

}
