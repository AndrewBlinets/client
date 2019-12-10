package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Language extends BaseEntity implements Serializable {

    private String nameLanguage;
    private String codeLanguage;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "language")
//    private ProjectLanguageVersion projectLanguageVersion;
}
