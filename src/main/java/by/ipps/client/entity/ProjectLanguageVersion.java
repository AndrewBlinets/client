package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLanguageVersion extends BaseEntity implements Serializable {

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "language")
//    private Language language;

    private String title;
    private String shortTitle;
    private String content;
    private String entrySpeech;
    private String codeLanguage;

}
