package com.lgj.webapp.dto;

import java.util.List;

// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class InscripcionAreaRequest {
    @NotNull
    List<AreaInscripcionRequest> areas;
}
