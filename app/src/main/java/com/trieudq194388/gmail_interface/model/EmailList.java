package com.trieudq194388.gmail_interface.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class EmailList {
    public static List<Email> eList = new ArrayList<>();

    public static void init(){
        Faker faker = new Faker();
        for(int i=0; i<30; i++){
            Email email = new Email();
            email.setAccountName(faker.name.name());
            email.setEmailTitle(faker.name.title());
            email.setEmailContent(faker.lorem.paragraph());
            email.setAvatarColor(faker.color.hexColor());
            email.setTime(faker.number.between(1, 12) + ":" + faker.number.between(10, 59) + " " +
                    (faker.number.positive() % 2 == 0 ? "AM" : "PM"));
            email.setFavEmail(faker.bool.bool());
            eList.add(email);
        }

    }
}
