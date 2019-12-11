package by.ipps.client.resttemplate.interface_rest_templaste.impl;

import by.ipps.client.entity.Vacancy;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.interface_rest_templaste.VacancyRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class VacancyTemplate extends AbstractBaseEntityRestTemplate<Vacancy> implements VacancyRestTemplate {
}
