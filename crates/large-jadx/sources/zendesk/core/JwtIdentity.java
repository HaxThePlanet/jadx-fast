package zendesk.core;

import f.g.c.a;
import f.g.e.g;

/* loaded from: classes3.dex */
public final class JwtIdentity implements zendesk.core.Identity {

    private static final String LOG_TAG = "JwtIdentity";
    private final String token;
    public JwtIdentity(String string) {
        boolean arr;
        String str2;
        String str;
        super();
        if (g.e(string)) {
            a.e("JwtIdentity", "A null or empty JWT was specified. This will not work. Please check your initialisation of JwtIdentity!", new Object[0]);
        }
        this.token = string;
    }

    @Override // zendesk.core.Identity
    public boolean equals(Object object) {
        Class<zendesk.core.JwtIdentity> obj;
        Class class;
        boolean obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (JwtIdentity.class != object.getClass()) {
            } else {
                String token = this.token;
                obj5 = object.token;
                if (token != null) {
                    if (!token.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // zendesk.core.Identity
    public String getJwtUserIdentifier() {
        return this.token;
    }

    @Override // zendesk.core.Identity
    public int hashCode() {
        int i;
        String token = this.token;
        if (token != null) {
            i = token.hashCode();
        } else {
            i = 0;
        }
        return i;
    }
}
