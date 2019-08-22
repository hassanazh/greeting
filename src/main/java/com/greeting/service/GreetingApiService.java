package com.greeting.service;

import com.greeting.util.Account;
import com.greeting.util.AccountType;
import com.greeting.util.GreetingConstant;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GreetingApiService {
    /**
     * Get greeting message by id
     *
     * @param account Which account is this Business/Personal
     * @param id      Id of the account
     * @return Greeting message
     */
    public String getGreetingById(String account, int id) {
        if (isValidAccount(account) && isValidateAccountId(id)
            && EnumUtils.getEnumIgnoreCase(Account.class, account).equals(Account.Personal)) {

            return GreetingConstant.HELLO_MESSAGE + id;
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_IMPLEMENTED, "The path is not yet implemented.");
    }

    /**
     * Get greeting message by type
     *
     * @param account Which account is this. Valid values: [Business, Personal]
     * @param accountType      Type of the account. Valid Values: [Big, Small]
     * @return Greeting message
     */
    public String getGreetingByType(String account, String accountType) {
        if (isValidAccount(account) && isValidateAccountType(accountType) &&
            EnumUtils.getEnumIgnoreCase(Account.class, account).equals(Account.Business) &&
            EnumUtils.getEnumIgnoreCase(AccountType.class, accountType).equals(AccountType.Big)) {

            return GreetingConstant.WELCOME_MESSAGE;
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_IMPLEMENTED, "The path is not yet implemented.");
    }

    private boolean isValidateAccountId(int id) {
        if (id <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, id + " is not valid. Must be a positive value");
        }
        return true;
    }

    private boolean isValidAccount(String account) {
        if (!EnumUtils.isValidEnumIgnoreCase(Account.class, account)) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, account + " is not valid account. " +
                "Valid accounts are " + EnumUtils.getEnumList(Account.class));
        }

        return true;
    }

    private boolean isValidateAccountType(String accountType) {
        if (!EnumUtils.isValidEnumIgnoreCase(AccountType.class, accountType)) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, accountType + " is not valid account type. " +
                "Valid account types are " + EnumUtils.getEnumList(AccountType.class));
        }

        return true;
    }
}
