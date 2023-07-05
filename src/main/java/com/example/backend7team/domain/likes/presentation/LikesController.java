package com.example.backend7team.domain.likes.presentation;

import com.example.backend7team.domain.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/likes")
@RestController
public class LikesController {

    private final LikesService likesService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{accident-information-id}")
    public void likes(@PathVariable("accident-information-id") Long accidentInformationId) {
        likesService.execute(accidentInformationId);
    }
}
