package by.ipps.client.resttemplate;

import by.ipps.client.entity.Department;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class DepartmentTemplate extends AbstractBaseEntityRestTemplate<Department> implements DepartmentRestTemplate {

}
