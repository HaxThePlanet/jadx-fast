package net.time4j.calendar.t;

import java.util.Locale;
import net.time4j.engine.x;
import net.time4j.g1.b;
import net.time4j.g1.e;
import net.time4j.h1.e;

/* loaded from: classes3.dex */
public final class a {
    public static String a(String string, x x2, Locale locale3) {
        e obj2;
        e obj3 = e.ofStyle(x2.getStyleValue());
        if (string.equals("iso8601")) {
            return b.r(obj3, locale3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("F(");
        stringBuilder.append(Character.toLowerCase(obj3.name().charAt(0)));
        stringBuilder.append(')');
        obj3 = stringBuilder.toString();
        if (!b.g(string, locale3).b(obj3)) {
            obj2 = b.g("generic", locale3);
        }
        return obj2.f(obj3);
    }
}
