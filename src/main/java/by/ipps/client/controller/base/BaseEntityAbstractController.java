package by.ipps.client.controller.base;

import by.ipps.client.custom.CustomPage;
import by.ipps.client.entity.BaseEntity;
import by.ipps.client.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;


public abstract class BaseEntityAbstractController<T extends BaseEntity, S extends BaseEntityRestTemplate<T>>
        implements BaseEntityController<T> {

    protected final S baseEntityRestTemplate;
    protected String url;

    protected BaseEntityAbstractController(S s, String url) {
        this.baseEntityRestTemplate = s;
        this.url = url;
    }

    @Override
    public ResponseEntity<T> getById(Long id, String language, String section, String department) {
        return baseEntityRestTemplate.findById(id, url, language, section, department);
    }


    @Override
    public ResponseEntity<CustomPage<T>> getAllByPage(int page, int size, String sort, String language, String section,
                                                      String department) {
        return baseEntityRestTemplate.findPagingRecords(page, size, sort, language, url, section, department);
    }

    @Override
    public ResponseEntity<List<T>> getAll(String language, String section, String department) {
        return baseEntityRestTemplate.findAll(language, url, section, department);
    }

}
