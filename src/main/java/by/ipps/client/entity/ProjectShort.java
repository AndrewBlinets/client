package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectShort extends BaseEntity implements Serializable {
        private String shortTitle;
        private String entrySpeech;
        private long mainImage;
}
