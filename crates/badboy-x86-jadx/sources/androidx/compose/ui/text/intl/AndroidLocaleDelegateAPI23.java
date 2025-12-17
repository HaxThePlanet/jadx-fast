package androidx.compose.ui.text.intl;

import android.util.Log;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00060\u0008j\u0002`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI23;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "parseLanguageTag", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidLocaleDelegateAPI23 implements androidx.compose.ui.text.intl.PlatformLocaleDelegate {

    public static final int $stable;
    static {
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public androidx.compose.ui.text.intl.LocaleList getCurrent() {
        Locale locale = new Locale(Locale.getDefault());
        LocaleList localeList = new LocaleList(CollectionsKt.listOf(locale));
        return localeList;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public Locale parseLanguageTag(String languageTag) {
        boolean equal;
        String string;
        String str;
        final Locale forLanguageTag = Locale.forLanguageTag(languageTag);
        if (Intrinsics.areEqual(forLanguageTag.toLanguageTag(), "und")) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.e(AndroidLocaleDelegate_androidKt.access$getTAG$p(), stringBuilder.append("The language tag ").append(languageTag).append(" is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtags delimiter and must be replaced with '-'.").toString());
        }
        return forLanguageTag;
    }
}
