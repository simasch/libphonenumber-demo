package ch.martinelli;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class Main {

    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    public static void main(String[] args) throws NumberParseException {
        Phonenumber.PhoneNumber swissPhoneNumber = new Phonenumber.PhoneNumber();
        swissPhoneNumber.setCountryCode(41);
        swissPhoneNumber.setNationalNumber(324556677L);

        print(swissPhoneNumber);

        Phonenumber.PhoneNumber usPhoneNumber = new Phonenumber.PhoneNumber();
        usPhoneNumber.setCountryCode(1);
        usPhoneNumber.setNationalNumber(5121112233L);

        print(usPhoneNumber);

        Phonenumber.PhoneNumber parsedSwissPhoneNumber = phoneNumberUtil.parse("032 631 11 22", "CH");
        print(parsedSwissPhoneNumber);

        Phonenumber.PhoneNumber parsedGermanPhoneNumber = phoneNumberUtil.parse("030 12345678", "DE");
        print(parsedGermanPhoneNumber);
    }

    private static void print(Phonenumber.PhoneNumber phoneNumber) {
        System.out.println(phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
        System.out.println(phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
    }
}