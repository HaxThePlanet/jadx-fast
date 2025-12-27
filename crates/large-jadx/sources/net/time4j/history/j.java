package net.time4j.history;

import java.util.Locale;
import net.time4j.engine.i;
import net.time4j.f1.c;
import net.time4j.g1.b;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* compiled from: HistoricEra.java */
/* loaded from: classes3.dex */
public enum j implements i {

    AB_URBE_CONDITA,
    AD,
    BC,
    BYZANTINE,
    HISPANIC;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[j.values().length];
            j.a.a = iArr;
            try {
                iArr[j.BC.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.a.a[j.AD.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.a.a[j.HISPANIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.a.a[j.BYZANTINE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.a.a[j.AB_URBE_CONDITA.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    @Override // java.lang.Enum
    public int annoDomini(int i) {
        int i4;
        try {
            int i2 = j.a.a[ordinal()];
            int i7 = 1;
            if (j.a.a != i7) {
                int i3 = 2;
                if (j.a.a != 2 && j.a.a != 3) {
                    if (j.a.a != 4 && j.a.a == 5) {
                        return c.l(i, 753);
                    }
                    return c.l(i, 5508);
                }
                return i4;
            }
        } catch (java.lang.ArithmeticException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        }
        return c.l(i7, i);
    }

    @Override // java.lang.Enum
    public String getAlternativeName(Locale locale, v vVar) {
        String str;
        String[] strArr = new String[2];
        vVar = vVar == v.WIDE ? "w" : "a";
        return b.d(locale).o(d.E().i(), strArr).g(this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v vVar) {
        return b.d(locale).b(vVar).g(this);
    }

    @Override // java.lang.Enum
    int yearOfEra(j jVar, int i) {
        int annoDomini;
        annoDomini = jVar.annoDomini(i);
        try {
            i = j.a.a[ordinal()];
            int i6 = 1;
            if (j.a.a != i6) {
                int i3 = 2;
                if (j.a.a != 2 && j.a.a != 3) {
                    if (j.a.a != 4 && j.a.a == 5) {
                        return c.e(annoDomini, 753);
                    }
                    return c.e(annoDomini, 5508);
                }
                return annoDomini;
            }
        } catch (java.lang.ArithmeticException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Out of range: ";
            i = str + i;
            jVar = new IllegalArgumentException(i);
            throw jVar;
        }
        return c.l(i6, annoDomini);
    }
}
