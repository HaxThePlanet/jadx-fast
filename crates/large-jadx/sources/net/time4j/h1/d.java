package net.time4j.h1;

import java.util.Locale;

/* loaded from: classes3.dex */
public enum d {

    tl("fil"),
    no("nb"),
    in("id"),
    iw("he");

    private final String alias;
    public static String getAlias(Locale locale) {
        boolean equals;
        String str;
        int i;
        net.time4j.h1.d dVar;
        boolean equals2;
        boolean obj5;
        final String language = locale.getLanguage();
        if (language.equals("no") && locale.getVariant().equals("NY") && locale.getCountry().equals("NO")) {
            if (locale.getVariant().equals("NY")) {
                if (locale.getCountry().equals("NO")) {
                    return "nn";
                }
            }
        }
        obj5 = d.ALIASES;
        i = 0;
        while (i < obj5.length) {
            dVar = obj5[i];
            i++;
        }
        return language;
    }
}
