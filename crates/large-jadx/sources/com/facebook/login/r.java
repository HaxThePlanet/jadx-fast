package com.facebook.login;

import com.facebook.a;
import com.facebook.g;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B7\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010¨\u0006\u001d", d2 = {"Lcom/facebook/login/LoginResult;", "", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "recentlyGrantedPermissions", "", "", "recentlyDeniedPermissions", "(Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/util/Set;Ljava/util/Set;)V", "getAccessToken", "()Lcom/facebook/AccessToken;", "getAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "getRecentlyDeniedPermissions", "()Ljava/util/Set;", "getRecentlyGrantedPermissions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class r {

    private final a a;
    private final g b;
    private final Set<String> c;
    private final Set<String> d;
    public r(a a, g g2, Set<String> set3, Set<String> set4) {
        n.f(a, "accessToken");
        n.f(set3, "recentlyGrantedPermissions");
        n.f(set4, "recentlyDeniedPermissions");
        super();
        this.a = a;
        this.b = g2;
        this.c = set3;
        this.d = set4;
    }

    public final a a() {
        return this.a;
    }

    public final Set<String> b() {
        return this.c;
    }

    public boolean equals(Object object) {
        boolean z;
        Object obj;
        Object obj3;
        if (this != (r)object && object instanceof r && n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c) && n.b(this.d, object.d)) {
            if (object instanceof r) {
                if (n.b(this.a, object.a)) {
                    if (n.b(this.b, object.b)) {
                        if (n.b(this.c, object.c)) {
                            if (n.b(this.d, object.d)) {
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        a aVar = this.a;
        i2 = 0;
        if (aVar != null) {
            i = aVar.hashCode();
        } else {
            i = i2;
        }
        g gVar = this.b;
        if (gVar != null) {
            i3 = gVar.hashCode();
        } else {
            i3 = i2;
        }
        Set set = this.c;
        if (set != null) {
            i4 = set.hashCode();
        } else {
            i4 = i2;
        }
        Set set2 = this.d;
        if (set2 != null) {
            i2 = set2.hashCode();
        }
        return i9 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoginResult(accessToken=");
        stringBuilder.append(this.a);
        stringBuilder.append(", authenticationToken=");
        stringBuilder.append(this.b);
        stringBuilder.append(", recentlyGrantedPermissions=");
        stringBuilder.append(this.c);
        stringBuilder.append(", recentlyDeniedPermissions=");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
