package zendesk.answerbot;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public final class Deflection {

    @SerializedName("auth_token")
    private final String authToken;
    @SerializedName("id")
    private final long id;
    Deflection(long l, String string2) {
        super();
        this.id = l;
        this.authToken = obj3;
    }

    public boolean equals(Object object) {
        int equals;
        Class<zendesk.answerbot.Deflection> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (Deflection.class != object.getClass()) {
            } else {
                if (Long.compare(l, l2) != 0) {
                    return i;
                }
                String authToken = this.authToken;
                final String obj7 = object.authToken;
                if (authToken != null) {
                    equals = authToken.equals(obj7);
                } else {
                    if (obj7 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    String getAuthToken() {
        return this.authToken;
    }

    public long getId() {
        return this.id;
    }

    public int hashCode() {
        int i;
        long l = this.id;
        String authToken = this.authToken;
        if (authToken != null) {
            i = authToken.hashCode();
        } else {
            i = 0;
        }
        return i4 += i;
    }
}
