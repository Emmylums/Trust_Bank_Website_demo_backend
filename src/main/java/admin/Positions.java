package admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Positions {
    private Long positionID;
    private String positionTitle;
    private boolean positionAvailable;
}
