package dto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class LocationDto {
    private double lat;
    private double long_;
}
