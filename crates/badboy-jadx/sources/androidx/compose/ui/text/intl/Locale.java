package androidx.compose.ui.text.intl;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\u0008\u0000\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\u0008\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0015\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000b¨\u0006\u001a", d2 = {"Landroidx/compose/ui/text/intl/Locale;", "", "languageTag", "", "(Ljava/lang/String;)V", "platformLocale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Ljava/util/Locale;)V", "language", "getLanguage", "()Ljava/lang/String;", "getPlatformLocale", "()Ljava/util/Locale;", "region", "getRegion", "script", "getScript", "equals", "", "other", "hashCode", "", "toLanguageTag", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Locale {

    public static final int $stable;
    public static final androidx.compose.ui.text.intl.Locale.Companion Companion;
    private final Locale platformLocale;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/intl/Locale$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/Locale;", "getCurrent", "()Landroidx/compose/ui/text/intl/Locale;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.intl.Locale getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0);
        }
    }
    static {
        Locale.Companion companion = new Locale.Companion(0);
        Locale.Companion = companion;
    }

    public Locale(String languageTag) {
        super(PlatformLocaleKt.getPlatformLocaleDelegate().parseLanguageTag(languageTag));
    }

    public Locale(Locale platformLocale) {
        super();
        this.platformLocale = platformLocale;
    }

    public boolean equals(Object other) {
        int i = 0;
        if (other == null) {
            return i;
        }
        if (!other instanceof Locale) {
            return i;
        }
        if (this == other) {
            return 1;
        }
        return Intrinsics.areEqual(toLanguageTag(), (Locale)other.toLanguageTag());
    }

    public final String getLanguage() {
        return this.platformLocale.getLanguage();
    }

    public final Locale getPlatformLocale() {
        return this.platformLocale;
    }

    public final String getRegion() {
        return PlatformLocale_jvmKt.getRegion(this.platformLocale);
    }

    public final String getScript() {
        return this.platformLocale.getScript();
    }

    public int hashCode() {
        return toLanguageTag().hashCode();
    }

    public final String toLanguageTag() {
        return PlatformLocale_jvmKt.getLanguageTag(this.platformLocale);
    }

    public String toString() {
        return toLanguageTag();
    }
}
