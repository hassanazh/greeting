package com.greeting.service;

import com.greeting.util.Account;
import com.greeting.util.AccountType;
import com.greeting.util.GreetingConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GreetingApiServiceTest {
    @InjectMocks
    private GreetingApiService greetingApiService = new GreetingApiService();

    @Test
    public void testGreetingByPersonalAccountWithId() {
        int userId = 123;
        String greetingMessage = greetingApiService.getGreetingById(Account.Personal.name(), userId);
        assertEquals(greetingMessage, GreetingConstant.HELLO_MESSAGE + userId);
    }

    @Test(expected = ResponseStatusException.class)
    public void testGreetingByPersonalAccountWithInvalidId() {
        greetingApiService.getGreetingById(Account.Personal.name(), -123);
    }

    @Test(expected = ResponseStatusException.class)
    public void testGreetingByInvalidAccountWithInvalidId() {
        int userId = -123;
        greetingApiService.getGreetingById("Invalid", userId);
    }

    @Test(expected = ResponseStatusException.class)
    public void testGreetingByBusinessAccountWithId() {
        greetingApiService.getGreetingById(Account.Business.name(), 123);
    }

    @Test
    public void testGreetingByBusinessAccountWithType() {
        String greetingMessage = greetingApiService.getGreetingByType(Account.Business.name(), AccountType.Big.name());
        assertEquals(greetingMessage, GreetingConstant.WELCOME_MESSAGE);
    }

    @Test(expected = ResponseStatusException.class)
    public void testGreetingByPersonalAccountWithType() {
        greetingApiService.getGreetingByType(Account.Personal.name(), AccountType.Small.name());
    }

    @Test(expected = ResponseStatusException.class)
    public void testGreetingByPersonalAccountWithTypeBig() {
        greetingApiService.getGreetingByType(Account.Business.name(), AccountType.Small.name());
    }
}
