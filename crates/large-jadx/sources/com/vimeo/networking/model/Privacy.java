package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

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
    public com.vimeo.networking.model.Privacy.PrivacyValue comments;
    public boolean download;
    public String embed;
    public com.vimeo.networking.model.Privacy.PrivacyValue view;

    public static enum PrivacyValue {

        NOBODY("nobody"),
        USERS("users"),
        ANYBODY("anybody"),
        VOD("ptv"),
        CONTACTS("contacts"),
        PASSWORD("password"),
        UNLISTED("unlisted"),
        DISABLE(5);

        private final String text;
        public static com.vimeo.networking.model.Privacy.PrivacyValue privacyValueFromString(String string) {
            com.vimeo.networking.model.Privacy.PrivacyValue[] values;
            int length;
            int i;
            com.vimeo.networking.model.Privacy.PrivacyValue privacyValue;
            boolean equalsIgnoreCase;
            if (string != null) {
                values = Privacy.PrivacyValue.values();
                i = 0;
                while (i < values.length) {
                    privacyValue = values[i];
                    i++;
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
