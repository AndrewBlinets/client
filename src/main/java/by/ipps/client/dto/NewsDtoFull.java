package by.ipps.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDtoFull extends BaseDto implements Serializable {

    private Date datePublic;
    private long mainImage;
    private int countView;
    private String title;
    private String content;
}
