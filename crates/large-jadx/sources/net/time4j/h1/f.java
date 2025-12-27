package net.time4j.h1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.g1.i;
import net.time4j.g1.j;

/* compiled from: SymbolProviderSPI.java */
/* loaded from: classes3.dex */
public final class f implements i {

    private static final Locale[] b;
    public static final Set<String> c;
    public static final f d = new f();
    private static final Map<String, j> e;
    static {
        int i = 0;
        i = 0;
        f.b = new Locale[i];
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, e.h("i18n/numbers/symbol", Locale.ROOT).f("locales").split(" "));
        f.c = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap();
        j[] values = j.values();
        for (j jVar : values) {
            hashMap.put(jVar.getCode(), jVar);
        }
        f.e = Collections.unmodifiableMap(hashMap);
    }

    private static e g(Locale locale) {
        if (f.c.contains(d.getAlias(locale))) {
            return e.h("i18n/numbers/symbol", locale);
        }
        return null;
    }

    private static char h(Locale locale, String str, char c) {
        net.time4j.h1.e eVar = f.g(locale);
        if (eVar != null && eVar.b(str)) {
            return eVar.f(str).charAt(0);
        }
        return c;
    }

    private static String i(Locale locale, String str, String str2) {
        net.time4j.h1.e eVar = f.g(locale);
        if (eVar != null && eVar.b(str)) {
            return eVar.f(str);
        }
        return str2;
    }

    public j a(Locale locale) {
        String str = f.i(locale, "numsys", j.ARABIC.getCode());
        Object value = f.e.get(str);
        if (value == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str4 = "Unrecognized number system: ";
            String str2 = " (locale=";
            r0 = str4 + str + str2 + locale + 41;
            throw new IllegalStateException(r0);
        } else {
            return value;
        }
    }

    public String b(Locale locale) {
        return f.i(locale, "minus", i.a.b(locale));
    }

    public Locale[] c() {
        return f.b;
    }

    public char d(Locale locale) {
        return f.h(locale, "separator", i.a.d(locale));
    }

    public String e(Locale locale) {
        return f.i(locale, "plus", i.a.e(locale));
    }

    public char f(Locale locale) {
        return f.h(locale, "zero", i.a.f(locale));
    }

    @Override // java.lang.Object
    public String toString() {
        return "SymbolProviderSPI";
    }
}
