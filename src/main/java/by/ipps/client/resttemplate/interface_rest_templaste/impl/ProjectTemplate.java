package by.ipps.client.resttemplate.interface_rest_templaste.impl;

import by.ipps.client.entity.Project;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.interface_rest_templaste.ProjectRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProjectTemplate extends AbstractBaseEntityRestTemplate<Project> implements ProjectRestTemplate {
}
