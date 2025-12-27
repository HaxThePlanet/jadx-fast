package net.time4j.h1;

import java.util.Locale;

/* compiled from: LanguageMatch.java */
/* loaded from: classes3.dex */
public enum d {

    in,
    iw,
    no,
    tl;

    private final String alias;
    public static String getAlias(Locale locale) {
        int i = 0;
        final String language = locale.getLanguage();
        if (language.equals("no")) {
            str = "NY";
            if (locale.getVariant().equals(str)) {
                if (locale.getCountry().equals("NO")) {
                    return "nn";
                }
            }
        }
        net.time4j.h1.d[] aLIASES2 = d.ALIASES;
        i = 0;
        for (net.time4j.h1.d dVar : aLIASES2) {
            if (language.equals(dVar.name())) {
                return dVar.alias;
            }
        }
        return language;
    }
}
