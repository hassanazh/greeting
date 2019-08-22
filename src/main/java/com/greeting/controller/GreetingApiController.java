package com.greeting.controller;

import javax.validation.constraints.NotNull;

import com.greeting.service.GreetingApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingApiController implements IGreetingApiController {

    @Autowired
    private GreetingApiService greetingApiService;

    @Override
    public String getGreetingById(@NotNull String account, @NotNull Integer id) {
        return greetingApiService.getGreetingById(account, id);
    }

    @Override
    public String getGreetingByType(@NotNull String account, @NotNull String accountType) {
        return greetingApiService.getGreetingByType(account, accountType);
    }
}
