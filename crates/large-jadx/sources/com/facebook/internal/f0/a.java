package com.facebook.internal.f0;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeper;", "", "name", "", "value", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private final String a;
    private final boolean b;
    public a(String string, boolean z2) {
        n.f(string, "name");
        super();
        this.a = string;
        this.b = z2;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean z;
        String str;
        Object obj3;
        if (this != (a)object && object instanceof a && n.b(this.a, object.a) && this.b == object.b) {
            if (object instanceof a) {
                if (n.b(this.a, object.a)) {
                    if (this.b == object.b) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public int hashCode() {
        int i;
        boolean z;
        String str = this.a;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        if (this.b) {
            z = 1;
        }
        return i2 += z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GateKeeper(name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", value=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
