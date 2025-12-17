package androidx.compose.ui.text.android;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0003\u0010\u0013\u001a\u00020\u000c2\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0003\u0010\u0016\u001a\u00020\u000c2\u0008\u0008\u0003\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000c2\u0008\u0008\u0002\u0010 \u001a\u00020\u000c2\u0008\u0008\u0002\u0010!\u001a\u00020\u000c2\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "start", "end", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "isFallbackLineSpacingEnabled", "layout", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StaticLayoutFactory {

    public static final int $stable = 8;
    public static final androidx.compose.ui.text.android.StaticLayoutFactory INSTANCE;
    private static final androidx.compose.ui.text.android.StaticLayoutFactoryImpl delegate;
    static {
        StaticLayoutFactory staticLayoutFactory = new StaticLayoutFactory();
        StaticLayoutFactory.INSTANCE = staticLayoutFactory;
        StaticLayoutFactory23 staticLayoutFactory23 = new StaticLayoutFactory23();
        StaticLayoutFactory.delegate = (StaticLayoutFactoryImpl)staticLayoutFactory23;
        int i = 8;
    }

    public static StaticLayout create$default(androidx.compose.ui.text.android.StaticLayoutFactory staticLayoutFactory, java.lang.CharSequence charSequence2, TextPaint textPaint3, int i4, int i5, int i6, TextDirectionHeuristic textDirectionHeuristic7, Layout.Alignment layout$Alignment8, int i9, TextUtils.TruncateAt textUtils$TruncateAt10, int i11, float f12, float f13, int i14, boolean z15, boolean z16, int i17, int i18, int i19, int i20, int[] i21Arr21, int[] i22Arr22, int i23, Object object24) {
        int length;
        int dEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release;
        int dEFAULT_LAYOUT_ALIGNMENT$ui_text_release;
        int i7;
        int i3;
        int i30;
        int i26;
        int i15;
        int i8;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout.Alignment alignment;
        int i21;
        int i12;
        int i16;
        int i22;
        int i29;
        int i2;
        int i24;
        int i27;
        int i31;
        int i28;
        int i13;
        int i10;
        int i25;
        int i;
        int i32 = i23;
        final int i50 = 0;
        i15 = i32 & 8 != 0 ? i50 : i5;
        if (i32 & 16 != 0) {
            i8 = length;
        } else {
            i8 = i6;
        }
        if (i32 & 32 != 0) {
            textDirectionHeuristic = dEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release;
        } else {
            textDirectionHeuristic = textDirectionHeuristic7;
        }
        if (i32 & 64 != 0) {
            alignment = dEFAULT_LAYOUT_ALIGNMENT$ui_text_release;
        } else {
            alignment = alignment8;
        }
        i21 = i32 & 128 != 0 ? i7 : i9;
        int i51 = 0;
        i12 = i32 & 256 != 0 ? i51 : truncateAt10;
        i16 = i32 & 512 != 0 ? i4 : i11;
        i22 = i32 & 1024 != 0 ? i3 : f12;
        i29 = i32 & 2048 != 0 ? i30 : f13;
        i2 = i32 & 4096 != 0 ? i50 : i14;
        i24 = i32 & 8192 != 0 ? i50 : z15;
        i27 = i32 & 16384 != 0 ? i26 : z16;
        i31 = i39 &= i32 != 0 ? i50 : i17;
        i28 = i41 &= i32 != 0 ? i50 : i18;
        i13 = i43 &= i32 != 0 ? i50 : i19;
        i10 = i45 &= i32 != 0 ? i50 : i20;
        i25 = i47 &= i32 != 0 ? i51 : i21Arr21;
        i = i32 &= i49 != 0 ? i51 : i22Arr22;
        return staticLayoutFactory.create(charSequence2, textPaint3, i4, i15, i8, textDirectionHeuristic, alignment, i21, i12, i16, i22, i29, i2, i24, i27, i31, i28, i13, i10, i25, i);
    }

    public final StaticLayout create(java.lang.CharSequence text, TextPaint paint, int width, int start, int end, TextDirectionHeuristic textDir, Layout.Alignment alignment, int maxLines, TextUtils.TruncateAt ellipsize, int ellipsizedWidth, float lineSpacingMultiplier, float lineSpacingExtra, int justificationMode, boolean includePadding, boolean useFallbackLineSpacing, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle, int hyphenationFrequency, int[] leftIndents, int[] rightIndents) {
        StaticLayoutParams staticLayoutParams = new StaticLayoutParams(text, start, end, paint, width, textDir, alignment, maxLines, ellipsize, ellipsizedWidth, lineSpacingMultiplier, lineSpacingExtra, justificationMode, includePadding, useFallbackLineSpacing, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphenationFrequency, leftIndents, rightIndents);
        return StaticLayoutFactory.delegate.create(staticLayoutParams);
    }

    public final boolean isFallbackLineSpacingEnabled(StaticLayout layout, boolean useFallbackLineSpacing) {
        return StaticLayoutFactory.delegate.isFallbackLineSpacingEnabled(layout, useFallbackLineSpacing);
    }
}
