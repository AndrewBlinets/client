package by.ipps.client.resttemplate.base;

import by.ipps.client.custom.CustomPage;
import org.springframework.http.ResponseEntity;

public interface BaseEntityRestTemplate<T> {

    ResponseEntity<T> findById(Long id, String url);
    ResponseEntity<CustomPage<T>> findPagingRecords(long page, int size, String sort, String language,
                                                    String url);
    ResponseEntity<T> create(T entity, String url);
    ResponseEntity<T> update(T entity, String url);
    ResponseEntity<Boolean> delete(long byId, String url);
}
