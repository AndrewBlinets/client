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
public class Company extends BaseEntity implements Serializable {
    private String adress;
    private String name;
    private String shortName;
    private String phoneFax;
    private String email;
    private String hotLine;
    private String coordX;
    private String coordY;
    private String hotLinePhone;
}
