package net.time4j.g1.z;

import java.util.List;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* compiled from: TimezoneIDProcessor.java */
/* loaded from: classes3.dex */
enum c0 implements h<k> {

    INSTANCE;
    @Override // java.lang.Enum
    public net.time4j.engine.p<k> getElement() {
        return b0.TIMEZONE_ID;
    }

    @Override // java.lang.Enum
    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int i = 0;
        int i2;
        int i3;
        char charAt;
        char c2;
        int length = charSequence.length();
        i2 = sVar.f();
        if (i2 >= length) {
            sVar.k(i2, "Missing timezone name.");
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        char c = '-';
        while (i2 < length) {
            charAt = charSequence.charAt(i2);
            c2 = 'a';
        }
        if (!Character.isLetter(stringBuilder2.charAt(stringBuilder2.length() - 1))) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            i2 = i2 - 1;
        }
        String str7 = stringBuilder2.toString();
        if (str7.isEmpty()) {
            sVar.k(i2, "Missing valid timezone id.");
            return;
        }
        if (str7.startsWith("Etc/GMT")) {
            sVar.k(i2, "Inverse Etc/GMT-Offsets are not supported, use UTC-Offsets instead.");
            return;
        }
        if (str7.equals("Z")) {
            tVar.K(b0.TIMEZONE_OFFSET, p.C);
            sVar.l(i2);
            return;
        }
        if (!str7.equals("UTC") && !str7.equals("GMT")) {
            if (!(str7.equals("UT"))) {
                List list = l.u("INCLUDE_ALIAS");
                i = 0;
                i3 = list.size() - 1;
                while (p.C <= i3) {
                    int i6 = (i + i3) >>> 1;
                    Object item = list.get(i6);
                    int compareTo = item.a().compareTo(str7);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "Cannot parse to timezone id: ";
            str3 = str6 + str7;
            sVar.k(i2, str3);
            return;
        }
        if (length > i2) {
            char charAt2 = charSequence.charAt(i2);
            sVar.l(i2);
            e0.x.parse(charSequence, sVar, dVar, tVar, z);
            return;
        }
        tVar.K(b0.TIMEZONE_OFFSET, p.C);
        sVar.l(i2);
    }

    @Override // java.lang.Enum
    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        int z52;
        if (!oVar.j()) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Cannot extract timezone id from: ";
            oVar = str2 + oVar;
            throw new IllegalArgumentException(oVar);
        } else {
            z52 = -1;
            if (appendable instanceof CharSequence) {
                z52 = (CharSequence)appendable.length();
            } else {
            }
            String str = oVar.t().a();
            appendable.append(str);
            int length = str.length();
            if (z52 != z52 && length > 0 && set != null) {
                i = z52 + length;
                set.add(new g(b0.TIMEZONE_ID, z52, i));
            }
            return length;
        }
    }

    @Override // java.lang.Enum
    public h<k> quickPath(c<?> cVar, d dVar, int i) {
        return c0.INSTANCE;
    }

    @Override // java.lang.Enum
    public h<k> withElement(net.time4j.engine.p<k> pVar) {
        return c0.INSTANCE;
    }

    @Override // java.lang.Enum
    public boolean isNumerical() {
        return false;
    }
}
