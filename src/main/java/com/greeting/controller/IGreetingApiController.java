package com.greeting.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/greeting")
interface IGreetingApiController {

    @GetMapping("account/{account}/id/{accountId}")
    String getGreetingById(@PathVariable("account") @NotNull String account, @PathVariable("accountId") @NotNull Integer id);

    @GetMapping("account/{account}/type/{accountType}")
    String getGreetingByType(@PathVariable("account") @NotNull String account, @PathVariable("accountType") @NotNull String accountType);
}
