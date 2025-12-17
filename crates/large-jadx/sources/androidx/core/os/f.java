package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
final class f implements androidx.core.os.g {

    private static final Locale[] b;
    private final Locale[] a;
    static {
        f.b = new Locale[0];
        Locale locale = new Locale("en", "XA");
        Locale locale2 = new Locale("ar", "XB");
        e.b("en-Latn");
    }

    f(Locale... localeArr) {
        ArrayList arrayList;
        HashSet hashSet;
        StringBuilder stringBuilder;
        int i;
        int length;
        int contains;
        Object[] obj7;
        super();
        if (localeArr.length == 0) {
            this.a = f.b;
        } else {
            arrayList = new ArrayList();
            hashSet = new HashSet();
            stringBuilder = new StringBuilder();
            i = 0;
            for (Object length : localeArr) {
                if (hashSet.contains(length)) {
                } else {
                }
                length = length.clone();
                arrayList.add((Locale)length);
                f.b(stringBuilder, length);
                if (i < length2--) {
                }
                hashSet.add(length);
                stringBuilder.append(',');
            }
            this.a = (Locale[])arrayList.toArray(new Locale[arrayList.size()]);
            stringBuilder.toString();
        }
    }

    static void b(StringBuilder stringBuilder, Locale locale2) {
        String country;
        String obj2;
        stringBuilder.append(locale2.getLanguage());
        country = locale2.getCountry();
        if (country != null && !country.isEmpty()) {
            if (!country.isEmpty()) {
                stringBuilder.append('-');
                stringBuilder.append(locale2.getCountry());
            }
        }
    }

    @Override // androidx.core.os.g
    public Object a() {
        return null;
    }

    @Override // androidx.core.os.g
    public boolean equals(Object object) {
        int i;
        int length;
        Locale locale;
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        final int i3 = 0;
        if (!object instanceof f) {
            return i3;
        }
        final Locale[] obj6 = object.a;
        if (objArr.length != obj6.length) {
            return i3;
        }
        i = i3;
        Locale[] objArr2 = this.a;
        for (Object locale2 : obj3) {
            objArr2 = this.a;
        }
        return i2;
    }

    @Override // androidx.core.os.g
    public Locale get(int i) {
        Locale[] objArr;
        int length;
        int obj3;
        objArr = this.a;
        if (i >= 0 && i < objArr.length) {
            objArr = this.a;
            obj3 = i < objArr.length ? objArr[i] : 0;
        } else {
        }
        return obj3;
    }

    @Override // androidx.core.os.g
    public int hashCode() {
        int i2;
        int i;
        int i3;
        int length;
        i2 = 1;
        i = 0;
        Locale[] objArr = this.a;
        for (Object locale : obj2) {
            i4 += i3;
            objArr = this.a;
        }
        return i2;
    }

    @Override // androidx.core.os.g
    public String toString() {
        int i2;
        int i;
        int length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        i2 = 0;
        Locale[] objArr = this.a;
        while (i2 < objArr.length) {
            stringBuilder.append(objArr[i2]);
            if (i2 < length2--) {
            }
            i2++;
            objArr = this.a;
            stringBuilder.append(',');
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
