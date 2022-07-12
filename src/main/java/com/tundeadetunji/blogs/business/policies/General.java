package com.tundeadetunji.blogs.business.policies;

public class General {
    public static enum userRoles{
        USER, //can only view blogs or login
        ADMIN, //can do and undo
        //BLOGGER //aka manager, can delete blogs

        //these for API section - could have used it for the UI as-is, but Spring complained that ROLE_ was auto-appended, so had to remove the prefix
        ROLE_USER,
        ROLE_ADMIN

    }
}
