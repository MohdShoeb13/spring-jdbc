package com.springcore.springjdbcmodule;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.springjdbcmodule.dao.EmployeeDaoImpl;
import com.springcore.springjdbcmodule.entity.Employee;

/**
 * @author Mohd Shoeb
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

       EmployeeDaoImpl bean = context.getBean("employeeDao",EmployeeDaoImpl.class);
       
//       Employee employee = new Employee(112,"Shoeb","Full stack Dev");
//       int insert = bean.insert(employee);
//       System.out.println(insert);
       
//          Employee employee = new Employee(113,"Saif","SDET");
//          
//          int update = bean.delete(113);
//          System.out.println(update);
//            Employee employee = bean.getEmployee(114);
         List<Employee> employees = bean.getEmployees();
         employees.forEach(System.out::println);
             
    }
}
