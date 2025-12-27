package app.dogo.com.dogo_android.service;

import android.app.ActivityManager.ProcessErrorStateInfo;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.y.q0;

/* compiled from: LocaleService.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u000c\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\r\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/service/LocaleService;", "", "()V", "supportedLocales", "", "", "getLanguageFromLocaleString", "locale", "getLocale", "Ljava/util/Locale;", "code", "getLocaleFullString", "getLocaleString", "validateLocaleForContentful", "SupportedLocales", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n2, reason: from kotlin metadata */
public final class LocaleService {

    /* renamed from: a, reason: from kotlin metadata */
    public static final n2 supportedLocales = new n2();
    private static final Set<String> b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0013\u0008\u0086\u0001\u0018\u0000 \u00152\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/service/LocaleService$SupportedLocales;", "", "localeTag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "localeFullTag", "getLocaleFullTag", "()Ljava/lang/String;", "getLocaleTag", "LITHUANIAN", "GERMAN", "SPANISH", "RUSSIAN", "PORTUGUESE", "FRENCH", "ENGLISH", "DUTCH", "POLISH", "SWEDISH", "JAPAN", "ITALIAN", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum a {

        DUTCH,
        ENGLISH,
        FRENCH,
        GERMAN,
        ITALIAN,
        JAPAN,
        LITHUANIAN,
        POLISH,
        PORTUGUESE,
        RUSSIAN,
        SPANISH,
        SWEDISH;

        private final String localeTag;
        @Override // java.lang.Enum
        public final String getLocaleFullTag() {
            return LocaleService.supportedLocales.validateLocaleForContentful(this.localeTag);
        }

        @Override // java.lang.Enum
        public final String getLocaleTag() {
            return this.localeTag;
        }

        private static final /* synthetic */ n2.a[] $values() {
            app.dogo.com.dogo_android.service.n2.a[] arr = new n2.a[12];
            return new n2.a[] { LocaleService_SupportedLocales.LITHUANIAN, LocaleService_SupportedLocales.GERMAN, LocaleService_SupportedLocales.SPANISH, LocaleService_SupportedLocales.RUSSIAN, LocaleService_SupportedLocales.PORTUGUESE, LocaleService_SupportedLocales.FRENCH, LocaleService_SupportedLocales.ENGLISH, LocaleService_SupportedLocales.DUTCH, LocaleService_SupportedLocales.POLISH, LocaleService_SupportedLocales.SWEDISH, LocaleService_SupportedLocales.JAPAN, LocaleService_SupportedLocales.ITALIAN };
        }
    }
    static {
        LocaleService.b = q0.g(new String[] { "lt", "de", "es", "ru", "pt", "fr", "nl", "pl", "sv", "ja", "it" });
    }

    private n2() {
        super();
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final Locale getLanguageFromLocaleString(String locale) {
        Locale forLanguageTag = Locale.forLanguageTag(LocaleService.getLocale(locale));
        n.e(forLanguageTag, "forLanguageTag(getLocaleString(code))");
        return forLanguageTag;
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static final String getLocale(String code) {
        String language;
        if (code == null) {
            language = Locale.getDefault().getLanguage();
        }
        code = !p.N(LocaleService.b, language) || language == null ? "en-US" : language;
        return (!p.N(LocaleService.b, language) || language == null ? "en-US" : language);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final String getLocaleFullString(String code) {
        Object code2;
        String str;
        boolean z;
        boolean z2;
        if (code == null) {
            String language = Locale.getDefault().getLanguage();
        } else {
            code2 = code;
        }
        str = "en-US";
        if (!n.b(LocaleService_SupportedLocales.JAPAN.getLocaleTag(), code)) {
            if (n.b(LocaleService_SupportedLocales.ITALIAN.getLocaleTag(), code)) {
            }
        }
        return str;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final String getLocaleString(String code) {
        String language;
        if (code == null) {
            language = Locale.getDefault().getLanguage();
        }
        code = !p.N(LocaleService.b, language) || language == null ? "en" : language;
        return (!p.N(LocaleService.b, language) || language == null ? "en" : language);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final String validateLocaleForContentful(String code) {
        String str;
        String language;
        String str2;
        if (code == null) {
            language = Locale.getDefault().getLanguage();
        }
        if (language != null) {
            switch (language.hashCode()) {
                case 3201:
                    str = "de";
                    str2 = "Deutsch";
                    str2 = "English";
                    break;
                case 3246:
                    str = "es";
                    str2 = "Español";
                    str2 = "English";
                    break;
                case 3276:
                    str = "fr";
                    str2 = "Français";
                    str2 = "English";
                    break;
                case 3371:
                    str = "it";
                    str2 = "Italiano";
                    str2 = "English";
                    break;
                case 3383:
                    str = "ja";
                    str2 = "日本語";
                    str2 = "English";
                    break;
                case 3464:
                    str = "lt";
                    str2 = "Lietuvių";
                    str2 = "English";
                    break;
                case 3518:
                    str = "nl";
                    str2 = "Nederlands";
                    str2 = "English";
                    break;
                case 3580:
                    str = "pl";
                    str2 = "Polski";
                    str2 = "English";
                    break;
                case 3588:
                    str = "pt";
                    str2 = "Português";
                    str2 = "English";
                    break;
                case 3651:
                    str = "ru";
                    str2 = "Русский";
                    str2 = "English";
                    break;
                case 3683:
                    str = "sv";
                    str2 = "Svenska";
                    str2 = "English";
                    break;
                default:
                    str2 = "English";
            }
        }
        return str2;
    }
}
