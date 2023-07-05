package com.example.backend7team.domain.accident.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateAccidentRequest {

    @NotBlank
    @Size(max = 25)
    private String title;

    @NotBlank
    @Size(max = 1000)
    private String content;

    @NotBlank
    private String imageUrl;

}
