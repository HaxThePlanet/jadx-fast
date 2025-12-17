package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\nH\u0007J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0004H\u0007¨\u0006\u001d", d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory33;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "alignment", "Landroid/text/Layout$Alignment;", "lineSpacingMultiplier", "", "lineSpacingExtra", "metrics", "Landroid/text/BoringLayout$Metrics;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isBoring", "textDir", "Landroid/text/TextDirectionHeuristic;", "isFallbackLineSpacingEnabled", "layout", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BoringLayoutFactory33 {

    public static final androidx.compose.ui.text.android.BoringLayoutFactory33 INSTANCE;
    static {
        BoringLayoutFactory33 boringLayoutFactory33 = new BoringLayoutFactory33();
        BoringLayoutFactory33.INSTANCE = boringLayoutFactory33;
    }

    @JvmStatic
    public static final BoringLayout create(java.lang.CharSequence text, TextPaint paint, int width, Layout.Alignment alignment, float lineSpacingMultiplier, float lineSpacingExtra, BoringLayout.Metrics metrics, boolean includePadding, boolean useFallbackLineSpacing, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        BoringLayout boringLayout = new BoringLayout(text, paint, width, alignment, lineSpacingMultiplier, lineSpacingExtra, metrics, includePadding, ellipsize, ellipsizedWidth, useFallbackLineSpacing);
        return boringLayout;
    }

    public static BoringLayout create$default(java.lang.CharSequence charSequence, TextPaint textPaint2, int i3, Layout.Alignment layout$Alignment4, float f5, float f6, BoringLayout.Metrics boringLayout$Metrics7, boolean z8, boolean z9, TextUtils.TruncateAt textUtils$TruncateAt10, int i11, int i12, Object object13) {
        int i;
        int i2;
        int i4;
        int i5 = i12;
        i2 = i5 & 512 != 0 ? i : truncateAt10;
        i4 = i5 &= 1024 != 0 ? i3 : i11;
        return BoringLayoutFactory33.create(charSequence, textPaint2, i3, alignment4, f5, f6, metrics7, z8, z9, i2, i4);
    }

    @JvmStatic
    public static final BoringLayout.Metrics isBoring(java.lang.CharSequence text, TextPaint paint, TextDirectionHeuristic textDir) {
        return BoringLayout.isBoring(text, paint, textDir, true, 0);
    }

    @JvmStatic
    public static final boolean isFallbackLineSpacingEnabled(BoringLayout layout) {
        return layout.isFallbackLineSpacingEnabled();
    }
}
