package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class h implements androidx.core.os.g {

    private final LocaleList a;
    h(LocaleList localeList) {
        super();
        this.a = localeList;
    }

    @Override // androidx.core.os.g
    public Object a() {
        return this.a;
    }

    @Override // androidx.core.os.g
    public boolean equals(Object object) {
        return this.a.equals((g)object.a());
    }

    @Override // androidx.core.os.g
    public Locale get(int i) {
        return this.a.get(i);
    }

    @Override // androidx.core.os.g
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // androidx.core.os.g
    public String toString() {
        return this.a.toString();
    }
}
