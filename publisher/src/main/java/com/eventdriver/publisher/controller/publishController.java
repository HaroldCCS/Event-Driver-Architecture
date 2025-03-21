package com.eventdriver.publisher.controller;

import com.eventdriver.publisher.dto.ApiResponse;
import com.eventdriver.publisher.dto.RequestPublishMessage;
import com.eventdriver.publisher.service.PublishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publisher")
public class publishController {

    @Autowired
    private PublishService publishService;


    @PostMapping("/publish")
    public ResponseEntity<ApiResponse<Boolean>> publishMessage(@Valid @RequestBody RequestPublishMessage params) {
        boolean request = publishService.publishMessage(params);

        ApiResponse<Boolean> response = new ApiResponse<Boolean>(200, request ? "Published" : "Unpublished", request);
        return ResponseEntity.ok(response);
    }
}
