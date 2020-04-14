package by.ipps.client.resttemplate.interface_rest_templaste.impl;

import by.ipps.client.entity.News;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.interface_rest_templaste.NewsRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsTemplate extends AbstractBaseEntityRestTemplate<News> implements NewsRestTemplate {

}
