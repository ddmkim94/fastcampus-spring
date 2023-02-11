package org.example;

public class WrongFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword() {
        return "eunbin"; // 6자리 패스워드 반환
    }
}
