package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Partners extends BaseEntity implements Serializable {

    private String name;
    private long image;
    private String url;

    public void setImage(BaseEntity image) {
        this.image = image.getId();
    }
}
