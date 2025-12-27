package net.time4j.calendar.t;

import java.util.Locale;
import net.time4j.engine.x;
import net.time4j.g1.b;

/* compiled from: GenericDatePatterns.java */
/* loaded from: classes3.dex */
public final class a {
    public static String a(String str, x xVar, Locale locale) {
        net.time4j.h1.e eVar;
        net.time4j.g1.e style = e.ofStyle(xVar.getStyleValue());
        if (str.equals("iso8601")) {
            return b.r(style, locale);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "F(";
        char lowerCase = Character.toLowerCase(style.name().charAt(0));
        str7 = str3 + lowerCase + 41;
        if (!b.g(str, locale).b(str7)) {
            eVar = b.g("generic", locale);
        }
        return eVar.f(str7);
    }
}
