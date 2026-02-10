package com.webdev.sdc.controller;

import com.webdev.sdc.model.ApiResponse;
import com.webdev.sdc.model.BankEntity;
import com.webdev.sdc.service.BankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/bank")
    public class BankController {
        private final BankService service;

        public BankController(BankService service) {
            this.service = service;
        }

        @GetMapping
        public ApiResponse<List<BankEntity>> getBanks() {
            List<BankEntity> entities = service.getAll();
            return new ApiResponse<>(entities, entities.size());
        }
    }
