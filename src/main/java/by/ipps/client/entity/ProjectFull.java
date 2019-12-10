package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectFull extends BaseEntity implements Serializable {
    private String title;
    private String content;
    private long mainImage;
    private List<Long> images;
}
