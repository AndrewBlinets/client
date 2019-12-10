package by.ipps.client.resttemplate.impl;

import by.ipps.client.entity.Department;
import by.ipps.client.resttemplate.DepartmentRestTemplate;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class DepartmentTemplate extends AbstractBaseEntityRestTemplate<Department> implements DepartmentRestTemplate {

}
