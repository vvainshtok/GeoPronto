package dto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class RequestDto {
    private String source;
    private int client_id;
    private String customer_code;
    private int group_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String mobile;
    private String email;
    private LocationDto location;
    private String installation_date;
    private String contractor_name;
    private int contractor_id;
    private TestingProfileDto testingProfile;
}
