package by.ipps.client.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project extends BaseEntity implements Serializable {
    private String title;
    private String content;
    private long mainImage;
    private List<Long> images;
    private String shortTitle;
    private String entrySpeech;
}
