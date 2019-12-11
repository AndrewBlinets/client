package by.ipps.client.controller;

import by.ipps.client.controller.base.BaseEntityAbstractController;
import by.ipps.client.controller.base.BaseEntityController;
import by.ipps.client.entity.News;
import by.ipps.client.resttemplate.interface_rest_templaste.NewsRestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController extends BaseEntityAbstractController<News, NewsRestTemplate>
        implements BaseEntityController<News> {

    protected NewsController(NewsRestTemplate newsRestTemplate) {
        super(newsRestTemplate, "/news/client");
    }
}
