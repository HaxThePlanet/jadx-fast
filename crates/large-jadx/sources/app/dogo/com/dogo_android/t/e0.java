package app.dogo.com.dogo_android.t;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsScreenConfiguration;", "", "canResubscribe", "", "signedIn", "signedInAs", "", "(ZZLjava/lang/String;)V", "getCanResubscribe", "()Z", "getSignedIn", "getSignedInAs", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e0 {

    private final boolean a;
    private final boolean b;
    private final String c;
    public e0() {
        super(0, 0, 0, 7, 0);
    }

    public e0(boolean z, boolean z2, String string3) {
        n.f(string3, "signedInAs");
        super();
        this.a = z;
        this.b = z2;
        this.c = string3;
    }

    public e0(boolean z, boolean z2, String string3, int i4, g g5) {
        int obj2;
        int obj3;
        String obj4;
        final int i = 0;
        obj2 = i4 & 1 != 0 ? i : obj2;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? "" : obj4;
        super(obj2, obj3, obj4);
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof e0) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        boolean z;
        int i;
        if (this.a) {
            z = i;
        }
        final boolean z2 = this.b;
        if (z2) {
        } else {
            i = z2;
        }
        return i4 += i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SettingsScreenConfiguration(canResubscribe=");
        stringBuilder.append(this.a);
        stringBuilder.append(", signedIn=");
        stringBuilder.append(this.b);
        stringBuilder.append(", signedInAs=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
