package app.dogo.com.dogo_android.i;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "", "id", "", "isSelected", "", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q0 {

    private final String a;
    private boolean b;
    public q0(String string, boolean z2) {
        n.f(string, "id");
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

    public final void c(boolean z) {
        this.b = z;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof q0) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        boolean z;
        if (this.b) {
            z = 1;
        }
        return i2 += z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonArrayEditItem(id=");
        stringBuilder.append(this.a);
        stringBuilder.append(", isSelected=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
