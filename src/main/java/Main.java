
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) throws Exception{
        List<JSONObject> jsonData = (List<JSONObject>) readJsonFile("./src/main/resources/input.json");

        System.out.println("jsonData from input file ************\n"+jsonData);

        List<Employee> employeeList = new ArrayList<>();
        for(JSONObject jsonObject: jsonData){
            employeeList.add(convertJsonToObject(jsonObject));
       }

        System.out.println("\n Parsed Employee Details  from jsonData ************\n");
        for(Employee emp: employeeList){
            System.out.println(emp);
        }

        Collections.sort(employeeList);

        List<JSONObject> jsonOutput = new ArrayList<>();
        System.out.println("\n Sorted Employee Details  from employeeList ************\n");
        for(Employee emp: employeeList){
            System.out.println(emp);
            jsonOutput.add(converObjectToJson(emp));
        }


        System.out.println("\n JSON from input file ************\n"+jsonOutput);



        FileWriter jsonFileWriter = new FileWriter("./src/main/resources/output.json");
        jsonFileWriter.write(jsonOutput.toString());
        jsonFileWriter.flush();
        jsonFileWriter.close();


    }

    public static Object readJsonFile(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }



    private static Employee convertJsonToObject(JSONObject employee) {

        String firstName = (String) employee.get("firstName");
        String lastName = (String) employee.get("lastName");
        String role = (String) employee.get("role");

        int baseSalary = Integer.valueOf((String) employee.get("baseSalary"));
        int bonus = Integer.valueOf((String) employee.get("bonus"));
        int totalSalary = baseSalary+bonus;

        int empId = Integer.valueOf((String) employee.get("EmployeeId"));

        Employee emp = new Employee(firstName, lastName, role, totalSalary, empId);

        return emp;
    }



    private static JSONObject converObjectToJson(Employee employee) {

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("firstName", employee.getFirstName());
        jsonObj.put("lastName", employee.getLastName());
        jsonObj.put("totalSalary", employee.getTotalSalary());
        jsonObj.put("EmployeeId", employee.getEmployeeID());
        return jsonObj;
    }
}