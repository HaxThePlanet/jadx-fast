package net.time4j.g1;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: NumberSymbolProvider.java */
/* loaded from: classes3.dex */
public interface i {

    public static final i a = new i$a();

    static class a implements i {
        a() {
            super();
        }

        private DecimalFormatSymbols g(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }

        public j a(Locale locale) {
            return j.ARABIC;
        }

        public String b(Locale locale) {
            if (locale.getLanguage().equals("ar")) {
                return "‏-";
            }
            return String.valueOf(g(locale).getMinusSign());
        }

        public Locale[] c() {
            return DecimalFormatSymbols.getAvailableLocales();
        }

        public char d(Locale locale) {
            return g(locale).getDecimalSeparator();
        }

        public String e(Locale locale) {
            if (locale.getLanguage().equals("ar")) {
                return "‏+";
            }
            return String.valueOf('+');
        }

        public char f(Locale locale) {
            return g(locale).getZeroDigit();
        }
    }

    j a(Locale locale);

    String b(Locale locale);

    Locale[] c();

    char d(Locale locale);

    String e(Locale locale);

    char f(Locale locale);
}
