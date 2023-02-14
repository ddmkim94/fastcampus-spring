package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword() {
        return "eunbining"; // 9자리 패스워드 반환
    }
}
