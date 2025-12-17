package androidx.core.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    private androidx.core.os.g a;
    static {
        e.a(new Locale[0]);
    }

    private e(androidx.core.os.g g) {
        super();
        this.a = g;
    }

    public static androidx.core.os.e a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = new LocaleList(localeArr);
            return e.e(localeList);
        }
        f fVar = new f(localeArr);
        e eVar = new e(fVar);
        return eVar;
    }

    static Locale b(String string) {
        String[] split;
        int length;
        String str = "-";
        int i = -1;
        final int i2 = 2;
        final int i3 = 0;
        final int i4 = 1;
        if (string.contains(str)) {
            split = string.split(str, i);
            if (split.length > i2) {
                Locale obj6 = new Locale(split[i3], split[i4], split[i2]);
                return obj6;
            }
            if (split.length > i4) {
                obj6 = new Locale(split[i3], split[i4]);
                return obj6;
            }
            if (split.length != i4) {
            } else {
                obj6 = new Locale(split[i3]);
                return obj6;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not parse language tag: [");
            stringBuilder.append(string);
            stringBuilder.append("]");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        } else {
            String str5 = "_";
            split = string.split(str5, i);
            if (string.contains(str5) && split.length > i2) {
                split = string.split(str5, i);
                if (split.length > i2) {
                    obj6 = new Locale(split[i3], split[i4], split[i2]);
                    return obj6;
                }
                if (split.length > i4) {
                    obj6 = new Locale(split[i3], split[i4]);
                    return obj6;
                }
                if (split.length != i4) {
                } else {
                    obj6 = new Locale(split[i3]);
                    return obj6;
                }
            }
        }
        Locale locale = new Locale(string);
        return locale;
    }

    public static androidx.core.os.e d() {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.e(LocaleList.getAdjustedDefault());
        }
        Locale[] arr = new Locale[1];
        return e.a(Locale.getDefault());
    }

    public static androidx.core.os.e e(LocaleList localeList) {
        h hVar = new h(localeList);
        e eVar = new e(hVar);
        return eVar;
    }

    public Locale c(int i) {
        return this.a.get(i);
    }

    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof e && this.a.equals(object.a)) {
            obj2 = this.a.equals(object.a) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
