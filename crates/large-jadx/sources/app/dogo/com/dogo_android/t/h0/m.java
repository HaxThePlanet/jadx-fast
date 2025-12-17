package app.dogo.com.dogo_android.t.h0;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectedCommandItem;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectionCommandItem;", "selectedLocale", "", "(Ljava/lang/String;)V", "getSelectedLocale", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends app.dogo.com.dogo_android.t.h0.n {

    private final String a;
    public m(String string) {
        n.f(string, "selectedLocale");
        super(0);
        this.a = string;
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    public final String a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof m) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LanguageSelectedCommandItem(selectedLocale=");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
