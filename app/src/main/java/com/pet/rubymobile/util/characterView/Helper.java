package com.pet.rubymobile.util.characterView;

import android.content.Context;

public class Helper {

    public static String fetchNameInitialsFromFullName(Context context) {
        String lastName = "...", firstName = "Test";
        String name = "";
        try {
//            if (AfinozApp.getUserName(context) != null && AfinozApp.getUserName(context).length() > 1) {
//                name = AfinozApp.getUserName(context);
                if (name.split("\\w+").length > 1) {
                    lastName = name.substring(name.lastIndexOf(" ") + 1);
                    firstName = name.substring(0, name.lastIndexOf(' '));
                } else {
                    firstName = name;
                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return firstName.substring(0, 1) + (lastName.trim().equals("") ? "" : lastName.substring(0, 1));
    }

}
