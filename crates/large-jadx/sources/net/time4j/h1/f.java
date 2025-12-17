package net.time4j.h1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.g1.i;
import net.time4j.g1.j;

/* loaded from: classes3.dex */
public final class f implements i {

    private static final Locale[] b;
    public static final Set<String> c;
    public static final net.time4j.h1.f d;
    private static final Map<String, j> e;
    static {
        int i;
        j jVar;
        String code;
        f.b = new Locale[0];
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, e.h("i18n/numbers/symbol", Locale.ROOT).f("locales").split(" "));
        f.c = Collections.unmodifiableSet(hashSet);
        f fVar = new f();
        f.d = fVar;
        HashMap hashMap = new HashMap();
        j[] values = j.values();
        while (i < values.length) {
            jVar = values[i];
            hashMap.put(jVar.getCode(), jVar);
            i++;
        }
        f.e = Collections.unmodifiableMap(hashMap);
    }

    private static net.time4j.h1.e g(Locale locale) {
        if (f.c.contains(d.getAlias(locale))) {
            return e.h("i18n/numbers/symbol", locale);
        }
        return null;
    }

    private static char h(Locale locale, String string2, char c3) {
        boolean z;
        net.time4j.h1.e obj1 = f.g(locale);
        if (obj1 != null && obj1.b(string2)) {
            if (obj1.b(string2)) {
                return obj1.f(string2).charAt(0);
            }
        }
        return c3;
    }

    private static String i(Locale locale, String string2, String string3) {
        boolean z;
        net.time4j.h1.e obj1 = f.g(locale);
        if (obj1 != null && obj1.b(string2)) {
            if (obj1.b(string2)) {
                return obj1.f(string2);
            }
        }
        return string3;
    }

    @Override // net.time4j.g1.i
    public j a(Locale locale) {
        String str = f.i(locale, "numsys", j.ARABIC.getCode());
        Object obj = f.e.get(str);
        if ((j)obj == null) {
        } else {
            return (j)obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized number system: ");
        stringBuilder.append(str);
        stringBuilder.append(" (locale=");
        stringBuilder.append(locale);
        stringBuilder.append(')');
        IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
        throw obj4;
    }

    @Override // net.time4j.g1.i
    public String b(Locale locale) {
        return f.i(locale, "minus", i.a.b(locale));
    }

    @Override // net.time4j.g1.i
    public Locale[] c() {
        return f.b;
    }

    @Override // net.time4j.g1.i
    public char d(Locale locale) {
        return f.h(locale, "separator", i.a.d(locale));
    }

    @Override // net.time4j.g1.i
    public String e(Locale locale) {
        return f.i(locale, "plus", i.a.e(locale));
    }

    @Override // net.time4j.g1.i
    public char f(Locale locale) {
        return f.h(locale, "zero", i.a.f(locale));
    }

    @Override // net.time4j.g1.i
    public String toString() {
        return "SymbolProviderSPI";
    }
}
