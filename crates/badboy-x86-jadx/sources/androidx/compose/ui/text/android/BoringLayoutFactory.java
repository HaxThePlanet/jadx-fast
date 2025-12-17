package androidx.compose.ui.text.android;

import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JZ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004J \u0010\u0017\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019¨\u0006\u001a", d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "metrics", "Landroid/text/BoringLayout$Metrics;", "alignment", "Landroid/text/Layout$Alignment;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "measure", "textDir", "Landroid/text/TextDirectionHeuristic;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BoringLayoutFactory {

    public static final int $stable;
    public static final androidx.compose.ui.text.android.BoringLayoutFactory INSTANCE;
    static {
        BoringLayoutFactory boringLayoutFactory = new BoringLayoutFactory();
        BoringLayoutFactory.INSTANCE = boringLayoutFactory;
    }

    public static BoringLayout create$default(androidx.compose.ui.text.android.BoringLayoutFactory boringLayoutFactory, java.lang.CharSequence charSequence2, TextPaint textPaint3, int i4, BoringLayout.Metrics boringLayout$Metrics5, Layout.Alignment layout$Alignment6, boolean z7, boolean z8, TextUtils.TruncateAt textUtils$TruncateAt9, int i10, int i11, Object object12) {
        Layout.Alignment aLIGN_NORMAL;
        int i6;
        int i7;
        int i8;
        Layout.Alignment alignment;
        int i3;
        int i5;
        int i2;
        int i;
        int i9 = i11;
        alignment = i9 & 16 != 0 ? aLIGN_NORMAL : alignment6;
        i3 = i9 & 32 != 0 ? i6 : z7;
        i5 = i9 & 64 != 0 ? i7 : z8;
        i2 = i9 & 128 != 0 ? i8 : truncateAt9;
        i = i9 &= 256 != 0 ? i4 : i10;
        return boringLayoutFactory.create(charSequence2, textPaint3, i4, metrics5, alignment, i3, i5, i2, i);
    }

    public final BoringLayout create(java.lang.CharSequence text, TextPaint paint, int width, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean includePadding, boolean useFallbackLineSpacing, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        int i4;
        BoringLayout create;
        java.lang.CharSequence i3;
        int i;
        Object obj;
        int i2;
        Layout.Alignment alignment2;
        int i5;
        int i6;
        BoringLayout.Metrics metrics2;
        boolean z;
        TextUtils.TruncateAt truncateAt;
        int i7;
        TextUtils.TruncateAt truncateAt2;
        int i8;
        int i11 = 0;
        i = width >= 0 ? i4 : i11;
        if (i == 0) {
        } else {
            if (ellipsizedWidth >= 0) {
            } else {
                i4 = i11;
            }
            if (i4 == 0) {
            } else {
                if (Build.VERSION.SDK_INT >= 33) {
                    create = BoringLayoutFactory33.create(text, paint, width, alignment, 1065353216, 0, metrics, includePadding, useFallbackLineSpacing, ellipsize, ellipsizedWidth);
                } else {
                    create = BoringLayoutFactoryDefault.create(text, paint, width, alignment, 1065353216, 0, metrics, includePadding, ellipsize, ellipsizedWidth);
                }
                return create;
            }
            int i10 = 0;
            IllegalArgumentException $i$a$RequireBoringLayoutFactory$create$2 = new IllegalArgumentException("negative ellipsized width".toString());
            throw $i$a$RequireBoringLayoutFactory$create$2;
        }
        int i9 = 0;
        IllegalArgumentException $i$a$RequireBoringLayoutFactory$create$1 = new IllegalArgumentException("negative width".toString());
        throw $i$a$RequireBoringLayoutFactory$create$1;
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout layout) {
        if (Build.VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.isFallbackLineSpacingEnabled(layout);
        }
        return 0;
    }

    public final BoringLayout.Metrics measure(java.lang.CharSequence text, TextPaint paint, TextDirectionHeuristic textDir) {
        BoringLayout.Metrics boring;
        if (Build.VERSION.SDK_INT >= 33) {
            boring = BoringLayoutFactory33.isBoring(text, paint, textDir);
        } else {
            boring = BoringLayoutFactoryDefault.isBoring(text, paint, textDir);
        }
        return boring;
    }
}
