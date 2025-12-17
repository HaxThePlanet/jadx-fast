package androidx.compose.ui.text.intl;

import android.os.LocaleList;
import android.util.Log;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000c\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI24;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "lastLocaleList", "lastPlatformLocaleList", "Landroid/os/LocaleList;", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "parseLanguageTag", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidLocaleDelegateAPI24 implements androidx.compose.ui.text.intl.PlatformLocaleDelegate {

    public static final int $stable = 8;
    private androidx.compose.ui.text.intl.LocaleList lastLocaleList;
    private LocaleList lastPlatformLocaleList;
    private final SynchronizedObject lock;
    static {
        final int i = 8;
    }

    public AndroidLocaleDelegateAPI24() {
        super();
        this.lock = Synchronization_jvmKt.createSynchronizedObject();
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public androidx.compose.ui.text.intl.LocaleList getCurrent() {
        int i;
        LocaleList lastPlatformLocaleList;
        int i2;
        int i4;
        int i3;
        androidx.compose.ui.text.intl.Locale locale;
        Locale locale2;
        final LocaleList default = LocaleList.getDefault();
        final SynchronizedObject lock = this.lock;
        final int i5 = 0;
        androidx.compose.ui.text.intl.LocaleList lastLocaleList = this.lastLocaleList;
        synchronized (lock) {
            i = 0;
            if (default == this.lastPlatformLocaleList) {
                return lastLocaleList;
            }
            int size = default.size();
            ArrayList arrayList = new ArrayList(size);
            i2 = 0;
            while (i2 < size) {
                i3 = 0;
                locale = new Locale(default.get(i2));
                arrayList.add(locale);
                i2++;
            }
            LocaleList localeList = new LocaleList((List)arrayList);
            this.lastPlatformLocaleList = default;
            this.lastLocaleList = localeList;
            return localeList;
        }
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public Locale parseLanguageTag(String languageTag) {
        boolean equal;
        String string;
        String str;
        final Locale forLanguageTag = Locale.forLanguageTag(languageTag);
        if (Intrinsics.areEqual(forLanguageTag.toLanguageTag(), "und")) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.e(AndroidLocaleDelegate_androidKt.access$getTAG$p(), stringBuilder.append("The language tag ").append(languageTag).append(" is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.").toString());
        }
        return forLanguageTag;
    }
}
