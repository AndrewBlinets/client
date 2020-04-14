package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section extends BaseEntity implements Serializable {
  private String name;
  private int type;
  private int index;
  private List<Block> blocks;
  private List<Long> files;

  public void setFiles(List<FileManager> files) {
    this.files = new ArrayList<>();
    if (files != null)
      for (FileManager fileManager : files) {
        this.files.add(fileManager.getId());
      }
  }
}
