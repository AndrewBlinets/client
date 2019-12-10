package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NewsLanguageVersion extends BaseEntity implements Serializable {

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "language")
//    private Language language;

    private String title;
    private String content;
    private String shortTitle;
    private String entrySpeech;
    private String codeLanguage;
}
