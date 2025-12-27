package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: Privacy.java */
/* loaded from: classes2.dex */
public class Privacy implements Serializable {

    public static final String PRIVACY_ANYBODY = "anybody";
    private static final String PRIVACY_CONTACTS = "contacts";
    private static final String PRIVACY_DISABLE = "disable";
    private static final String PRIVACY_NOBODY = "nobody";
    private static final String PRIVACY_PASSWORD = "password";
    private static final String PRIVACY_UNLISTED = "unlisted";
    private static final String PRIVACY_USERS = "users";
    private static final String PRIVACY_VOD = "ptv";
    private static final long serialVersionUID = -1679908652622815871L;
    public boolean add;
    public Privacy.PrivacyValue comments;
    public boolean download;
    public String embed;
    public Privacy.PrivacyValue view;

    public enum PrivacyValue {

        ANYBODY,
        CONTACTS,
        DISABLE,
        NOBODY,
        PASSWORD,
        UNLISTED,
        USERS,
        VOD;

        private final String text;
        public static Privacy.PrivacyValue privacyValueFromString(String str) {
            int i = 0;
            com.vimeo.networking.model.Privacy.PrivacyValue privacyValue;
            boolean equalsIgnoreCase;
            if (str != null) {
                com.vimeo.networking.model.Privacy.PrivacyValue[] values = Privacy.PrivacyValue.values();
                length = values.length;
                i = 0;
                for (com.vimeo.networking.model.Privacy.PrivacyValue privacyValue : values) {
                    if (str.equalsIgnoreCase(privacyValue.text)) {
                        return privacyValue;
                    }
                }
            }
            return null;
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.text;
        }
    }
}
