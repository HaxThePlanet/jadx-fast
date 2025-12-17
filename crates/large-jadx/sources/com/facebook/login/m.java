package com.facebook.login;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\"\n\u0002\u0008\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0008\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B+\u0008\u0016\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0010", d2 = {"Lcom/facebook/login/LoginConfiguration;", "", "permissions", "", "", "nonce", "(Ljava/util/Collection;Ljava/lang/String;)V", "codeVerifier", "(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)V", "getCodeVerifier", "()Ljava/lang/String;", "getNonce", "", "getPermissions", "()Ljava/util/Set;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class m {

    private final Set<String> a;
    private final String b;
    static {
    }

    public m(Collection<String> collection) {
        final int i = 0;
        super(collection, i, 2, i);
    }

    public m(Collection<String> collection, String string2) {
        n.f(string2, "nonce");
        super(collection, string2, v.a());
    }

    public m(Collection collection, String string2, int i3, g g4) {
        String obj2;
        int obj3;
        if (i3 &= 2 != 0) {
            n.e(UUID.randomUUID().toString(), "UUID.randomUUID().toString()");
        }
        super(collection, obj2);
    }

    public m(Collection<String> collection, String string2, String string3) {
        Object obj4;
        n.f(string2, "nonce");
        n.f(string3, "codeVerifier");
        super();
        if (u.a(string2) && v.b(string3)) {
            obj4 = v.b(string3) ? 1 : 0;
        } else {
        }
        if (obj4 == null) {
        } else {
            if (collection != null) {
                obj4 = new HashSet(collection);
            } else {
                super();
            }
            obj4.add("openid");
            Set obj2 = Collections.unmodifiableSet(obj4);
            n.e(obj2, "Collections.unmodifiableSet(permissions)");
            this.a = obj2;
            this.b = string2;
        }
        obj2 = new IllegalArgumentException("Failed requirement.".toString());
        throw obj2;
    }

    public final String a() {
        return this.b;
    }

    public final Set<String> b() {
        return this.a;
    }
}
