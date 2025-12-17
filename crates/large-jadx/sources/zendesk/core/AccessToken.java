package zendesk.core;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
class AccessToken {

    private String accessToken;
    @SerializedName("user_id")
    private String userId;
    AccessToken(String string, String string2) {
        super();
        this.accessToken = string;
        this.userId = string2;
    }

    public boolean equals(Object object) {
        boolean equals;
        boolean accessToken;
        Class class;
        Object accessToken2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                String accessToken3 = this.accessToken;
                if (accessToken3 != null) {
                    if (!accessToken3.equals(object.accessToken)) {
                        return i;
                    }
                } else {
                    if (object.accessToken != null) {
                    }
                }
                String userId = this.userId;
                final String obj5 = object.userId;
                if (userId != null) {
                    equals = userId.equals(obj5);
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

    String getAccessToken() {
        return this.accessToken;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i2;
        int i;
        String accessToken = this.accessToken;
        if (accessToken != null) {
            i2 = accessToken.hashCode();
        } else {
            i2 = i;
        }
        final String userId = this.userId;
        if (userId != null) {
            i = userId.hashCode();
        }
        return i3 += i;
    }
}
