package com.tundeadetunji.blogs.business.policies;

public class General {
    public static enum userRoles{
        USER, //can only view blogs or login
        ADMIN, //can do and undo
        BLOGGER //aka manager, can delete blogs
    }
}
