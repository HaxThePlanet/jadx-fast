package androidx.compose.ui.text.intl;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002", d2 = {"createPlatformLocaleDelegate", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPlatformLocale_androidKt {
    public static final androidx.compose.ui.text.intl.PlatformLocaleDelegate createPlatformLocaleDelegate() {
        AndroidLocaleDelegateAPI24 androidLocaleDelegateAPI24 = new AndroidLocaleDelegateAPI24();
        return (PlatformLocaleDelegate)androidLocaleDelegateAPI24;
    }
}
