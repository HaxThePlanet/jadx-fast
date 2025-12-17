package net.time4j.g1;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface i {

    public static final net.time4j.g1.i a;

    static class a implements net.time4j.g1.i {
        private DecimalFormatSymbols g(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }

        @Override // net.time4j.g1.i
        public net.time4j.g1.j a(Locale locale) {
            return j.ARABIC;
        }

        @Override // net.time4j.g1.i
        public String b(Locale locale) {
            if (locale.getLanguage().equals("ar")) {
                return "‏-";
            }
            return String.valueOf(g(locale).getMinusSign());
        }

        @Override // net.time4j.g1.i
        public Locale[] c() {
            return DecimalFormatSymbols.getAvailableLocales();
        }

        @Override // net.time4j.g1.i
        public char d(Locale locale) {
            return g(locale).getDecimalSeparator();
        }

        @Override // net.time4j.g1.i
        public String e(Locale locale) {
            if (locale.getLanguage().equals("ar")) {
                return "‏+";
            }
            return String.valueOf('+');
        }

        @Override // net.time4j.g1.i
        public char f(Locale locale) {
            return g(locale).getZeroDigit();
        }
    }
    static {
        i.a aVar = new i.a();
        i.a = aVar;
    }

    public abstract net.time4j.g1.j a(Locale locale);

    public abstract String b(Locale locale);

    public abstract Locale[] c();

    public abstract char d(Locale locale);

    public abstract String e(Locale locale);

    public abstract char f(Locale locale);
}
