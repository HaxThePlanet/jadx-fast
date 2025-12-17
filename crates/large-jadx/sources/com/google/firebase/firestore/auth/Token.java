package com.google.firebase.firestore.auth;

/* loaded from: classes2.dex */
public final class Token {

    private final com.google.firebase.firestore.auth.User user;
    private final String value;
    public Token(String string, com.google.firebase.firestore.auth.User user2) {
        super();
        this.value = string;
        this.user = user2;
    }

    public com.google.firebase.firestore.auth.User getUser() {
        return this.user;
    }

    public String getValue() {
        return this.value;
    }
}
