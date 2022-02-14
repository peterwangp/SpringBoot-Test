package com.wpy.simpleTest.service;

import com.wpy.simpleTest.entity.Employee;
import com.wpy.simpleTest.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee employee = new Employee();
        employee.setName("PeterW");

        Mockito.when(employeeRepository.findByName(employee.getName()))
                .thenReturn(employee);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "PeterW";
        Employee found = employeeService.getEmployeeByName(name);

        Assert.assertEquals(found.getName(),name);
    }
}
