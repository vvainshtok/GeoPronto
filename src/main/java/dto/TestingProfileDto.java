package dto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class TestingProfileDto {

    boolean withContract;
    int materialErrorsCount;
    int photosErrorsCount;
    String[] macList;
    String[] phoneSeriesList;
    String taskType;
}
