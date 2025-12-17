package com.google.firebase.firestore.auth;

/* loaded from: classes2.dex */
public final class User {

    public static final com.google.firebase.firestore.auth.User UNAUTHENTICATED;
    private final String uid;
    static {
        User user = new User(0);
        User.UNAUTHENTICATED = user;
    }

    public User(String string) {
        super();
        this.uid = string;
    }

    public boolean equals(Object object) {
        int equals;
        Class<com.google.firebase.firestore.auth.User> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (User.class != object.getClass()) {
            } else {
                String uid = this.uid;
                final String obj5 = object.uid;
                if (uid != null) {
                    equals = uid.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int i;
        String uid = this.uid;
        if (uid != null) {
            i = uid.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isAuthenticated() {
        int i;
        i = this.uid != null ? 1 : 0;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User(uid:");
        stringBuilder.append(this.uid);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
