package androidx.compose.ui.text.android;

import android.os.Build.VERSION;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0008H\u0016¨\u0006\u000b", d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StaticLayoutFactory23 implements androidx.compose.ui.text.android.StaticLayoutFactoryImpl {
    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(androidx.compose.ui.text.android.StaticLayoutParams params) {
        int lineBreakStyle;
        int lineBreakWordStyle;
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(params.getText(), params.getStart(), params.getEnd(), params.getPaint(), params.getWidth());
        StaticLayout.Builder builder = obtain;
        int i = 0;
        builder.setTextDirection(params.getTextDir());
        builder.setAlignment(params.getAlignment());
        builder.setMaxLines(params.getMaxLines());
        builder.setEllipsize(params.getEllipsize());
        builder.setEllipsizedWidth(params.getEllipsizedWidth());
        builder.setLineSpacing(params.getLineSpacingExtra(), params.getLineSpacingMultiplier());
        builder.setIncludePad(params.getIncludePadding());
        builder.setBreakStrategy(params.getBreakStrategy());
        builder.setHyphenationFrequency(params.getHyphenationFrequency());
        builder.setIndents(params.getLeftIndents(), params.getRightIndents());
        StaticLayoutFactory26.setJustificationMode(builder, params.getJustificationMode());
        StaticLayoutFactory28.setUseLineSpacingFromFallbacks(builder, params.getUseFallbackLineSpacing());
        if (Build.VERSION.SDK_INT >= 33) {
            StaticLayoutFactory33.setLineBreakConfig(builder, params.getLineBreakStyle(), params.getLineBreakWordStyle());
        }
        return obtain.build();
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean isFallbackLineSpacingEnabled(StaticLayout layout, boolean useFallbackLineSpacing) {
        boolean fallbackLineSpacingEnabled;
        if (Build.VERSION.SDK_INT >= 33) {
            fallbackLineSpacingEnabled = StaticLayoutFactory33.isFallbackLineSpacingEnabled(layout);
        } else {
            fallbackLineSpacingEnabled = useFallbackLineSpacing;
        }
        return fallbackLineSpacingEnabled;
    }
}
