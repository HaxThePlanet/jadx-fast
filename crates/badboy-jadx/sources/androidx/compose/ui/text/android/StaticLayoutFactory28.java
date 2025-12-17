package androidx.compose.ui.text.android;

import android.text.StaticLayout.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory28;", "", "()V", "setUseLineSpacingFromFallbacks", "", "builder", "Landroid/text/StaticLayout$Builder;", "useFallbackLineSpacing", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StaticLayoutFactory28 {

    public static final androidx.compose.ui.text.android.StaticLayoutFactory28 INSTANCE;
    static {
        StaticLayoutFactory28 staticLayoutFactory28 = new StaticLayoutFactory28();
        StaticLayoutFactory28.INSTANCE = staticLayoutFactory28;
    }

    @JvmStatic
    public static final void setUseLineSpacingFromFallbacks(StaticLayout.Builder builder, boolean useFallbackLineSpacing) {
        builder.setUseLineSpacingFromFallbacks(useFallbackLineSpacing);
    }
}
