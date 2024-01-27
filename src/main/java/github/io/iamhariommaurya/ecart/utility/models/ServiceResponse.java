package github.io.iamhariommaurya.ecart.utility.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse{
    private String code;
    private String message;

}
