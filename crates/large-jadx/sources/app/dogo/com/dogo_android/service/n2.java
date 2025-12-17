package app.dogo.com.dogo_android.service;

import android.app.ActivityManager.ProcessErrorStateInfo;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u000c\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\r\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/service/LocaleService;", "", "()V", "supportedLocales", "", "", "getLanguageFromLocaleString", "locale", "getLocale", "Ljava/util/Locale;", "code", "getLocaleFullString", "getLocaleString", "validateLocaleForContentful", "SupportedLocales", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n2 {

    public static final app.dogo.com.dogo_android.service.n2 a;
    private static final Set<String> b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0013\u0008\u0086\u0001\u0018\u0000 \u00152\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/service/LocaleService$SupportedLocales;", "", "localeTag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "localeFullTag", "getLocaleFullTag", "()Ljava/lang/String;", "getLocaleTag", "LITHUANIAN", "GERMAN", "SPANISH", "RUSSIAN", "PORTUGUESE", "FRENCH", "ENGLISH", "DUTCH", "POLISH", "SWEDISH", "JAPAN", "ITALIAN", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum a {

        LITHUANIAN("lt"),
        GERMAN("lt"),
        SPANISH("lt"),
        RUSSIAN("lt"),
        PORTUGUESE("lt"),
        FRENCH("lt"),
        ENGLISH("lt"),
        DUTCH("lt"),
        POLISH("lt"),
        SWEDISH("lt"),
        JAPAN("lt"),
        ITALIAN("lt");

        private final String localeTag;
        private static final app.dogo.com.dogo_android.service.n2.a[] $values() {
            app.dogo.com.dogo_android.service.n2.a[] arr = new n2.a[12];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getLocaleFullTag() {
            return n2.a.c(this.localeTag);
        }

        @Override // java.lang.Enum
        public final String getLocaleTag() {
            return this.localeTag;
        }
    }
    static {
        n2 n2Var = new n2();
        n2.a = n2Var;
        n2.b = q0.g(/* result */);
    }

    public static final Locale b(String string) {
        Locale obj1 = Locale.forLanguageTag(n2.d(string));
        n.e(obj1, "forLanguageTag(getLocaleString(code))");
        return obj1;
    }

    public static final String d(String string) {
        String obj2;
        if (string == null) {
            obj2 = Locale.getDefault().getLanguage();
        }
        if (p.N(n2.b, obj2)) {
            if (obj2 == null) {
                obj2 = str;
            }
        } else {
        }
        return obj2;
    }

    public static final String e(String string) {
        Object language;
        boolean localeTag;
        String str;
        Object obj3;
        if (string == null) {
            language = Locale.getDefault().getLanguage();
        } else {
            language = string;
        }
        if (!n.b(n2.a.JAPAN.getLocaleTag(), string)) {
            if (n.b(n2.a.ITALIAN.getLocaleTag(), string)) {
                language = str;
            }
        } else {
        }
        if (p.N(n2.b, language)) {
            if (language == null) {
            } else {
                str = language;
            }
        }
        return str;
    }

    public final String a(String string) {
        String obj3;
        if (string == null) {
            obj3 = Locale.getDefault().getLanguage();
        }
        if (p.N(n2.b, obj3)) {
            if (obj3 == null) {
                obj3 = str;
            }
        } else {
        }
        return obj3;
    }

    public final String c(String string) {
        String str;
        String obj2;
        if (string == null) {
            obj2 = Locale.getDefault().getLanguage();
        }
        if (obj2 != null) {
            switch (obj2) {
                case "de":
                    obj2 = "Deutsch";
                    obj2 = "English";
                    break;
                case "es":
                    obj2 = "Español";
                    obj2 = "English";
                    break;
                case "fr":
                    obj2 = "Français";
                    obj2 = "English";
                    break;
                case "it":
                    obj2 = "Italiano";
                    obj2 = "English";
                    break;
                case "ja":
                    obj2 = "日本語";
                    obj2 = "English";
                    break;
                case "lt":
                    obj2 = "Lietuvių";
                    obj2 = "English";
                    break;
                case "nl":
                    obj2 = "Nederlands";
                    obj2 = "English";
                    break;
                case "pl":
                    obj2 = "Polski";
                    obj2 = "English";
                    break;
                case "pt":
                    obj2 = "Português";
                    obj2 = "English";
                    break;
                case "ru":
                    obj2 = "Русский";
                    obj2 = "English";
                    break;
                case "sv":
                    obj2 = "Svenska";
                    obj2 = "English";
                    break;
                default:
                    obj2 = "English";
            }
        } else {
        }
        return obj2;
    }
}
