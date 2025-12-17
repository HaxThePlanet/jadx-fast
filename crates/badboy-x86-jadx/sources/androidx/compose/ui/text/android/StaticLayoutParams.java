package androidx.compose.ui.text.android;

import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0008!\u0008\u0002\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010 R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010$R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010$R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010$R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010$R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010$R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010$R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00102R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010$R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010.R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010<R\u0011\u0010\u0018\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010+R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010$¨\u0006?", d2 = {"Landroidx/compose/ui/text/android/StaticLayoutParams;", "", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;Landroid/text/Layout$Alignment;ILandroid/text/TextUtils$TruncateAt;IFFIZZIIII[I[I)V", "getAlignment", "()Landroid/text/Layout$Alignment;", "getBreakStrategy", "()I", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getEllipsizedWidth", "getEnd", "getHyphenationFrequency", "getIncludePadding", "()Z", "getJustificationMode", "getLeftIndents", "()[I", "getLineBreakStyle", "getLineBreakWordStyle", "getLineSpacingExtra", "()F", "getLineSpacingMultiplier", "getMaxLines", "getPaint", "()Landroid/text/TextPaint;", "getRightIndents", "getStart", "getText", "()Ljava/lang/CharSequence;", "getTextDir", "()Landroid/text/TextDirectionHeuristic;", "getUseFallbackLineSpacing", "getWidth", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StaticLayoutParams {

    private final Layout.Alignment alignment;
    private final int breakStrategy;
    private final TextUtils.TruncateAt ellipsize;
    private final int ellipsizedWidth;
    private final int end;
    private final int hyphenationFrequency;
    private final boolean includePadding;
    private final int justificationMode;
    private final int[] leftIndents;
    private final int lineBreakStyle;
    private final int lineBreakWordStyle;
    private final float lineSpacingExtra;
    private final float lineSpacingMultiplier;
    private final int maxLines;
    private final TextPaint paint;
    private final int[] rightIndents;
    private final int start;
    private final java.lang.CharSequence text;
    private final TextDirectionHeuristic textDir;
    private final boolean useFallbackLineSpacing;
    private final int width;
    public StaticLayoutParams(java.lang.CharSequence text, int start, int end, TextPaint paint, int width, TextDirectionHeuristic textDir, Layout.Alignment alignment, int maxLines, TextUtils.TruncateAt ellipsize, int ellipsizedWidth, float lineSpacingMultiplier, float lineSpacingExtra, int justificationMode, boolean includePadding, boolean useFallbackLineSpacing, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle, int hyphenationFrequency, int[] leftIndents, int[] rightIndents) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i;
        int i2;
        final Object obj = this;
        super();
        obj.text = text;
        obj.start = start;
        obj.end = end;
        obj.paint = paint;
        obj.width = width;
        obj.textDir = textDir;
        obj.alignment = alignment;
        obj.maxLines = maxLines;
        obj.ellipsize = ellipsize;
        obj.ellipsizedWidth = ellipsizedWidth;
        obj.lineSpacingMultiplier = lineSpacingMultiplier;
        obj.lineSpacingExtra = lineSpacingExtra;
        obj.justificationMode = justificationMode;
        obj.includePadding = includePadding;
        obj.useFallbackLineSpacing = useFallbackLineSpacing;
        obj.breakStrategy = breakStrategy;
        obj.lineBreakStyle = lineBreakStyle;
        obj.lineBreakWordStyle = lineBreakWordStyle;
        obj.hyphenationFrequency = hyphenationFrequency;
        obj.leftIndents = leftIndents;
        obj.rightIndents = rightIndents;
        int start2 = obj.start;
        i2 = 1;
        final int i24 = 0;
        if (start2 >= 0 && start2 <= obj.end) {
            i3 = start2 <= obj.end ? i2 : i24;
        } else {
        }
        if (i3 == 0) {
        } else {
            int end3 = obj.end;
            if (end3 >= 0 && end3 <= obj.text.length()) {
                i4 = end3 <= obj.text.length() ? i2 : i24;
            } else {
            }
            if (i4 == 0) {
            } else {
                i5 = obj.maxLines >= 0 ? i2 : i24;
                if (i5 == 0) {
                } else {
                    i6 = obj.width >= 0 ? i2 : i24;
                    if (i6 == 0) {
                    } else {
                        i = obj.ellipsizedWidth >= 0 ? i2 : i24;
                        if (i == 0) {
                        } else {
                            if (Float.compare(lineSpacingMultiplier2, i18) >= 0) {
                            } else {
                                i2 = i24;
                            }
                            if (i2 == 0) {
                            } else {
                            }
                            int i13 = 0;
                            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("invalid lineSpacingMultiplier value".toString());
                            throw illegalArgumentException3;
                        }
                        int i14 = 0;
                        IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("invalid ellipsizedWidth value".toString());
                        throw illegalArgumentException4;
                    }
                    int i15 = 0;
                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("invalid width value".toString());
                    throw illegalArgumentException5;
                }
                int i12 = 0;
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("invalid maxLines value".toString());
                throw illegalArgumentException2;
            }
            int i11 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid end value".toString());
            throw illegalArgumentException;
        }
        int i16 = 0;
        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("invalid start value".toString());
        throw illegalArgumentException6;
    }

    public StaticLayoutParams(java.lang.CharSequence charSequence, int i2, int i3, TextPaint textPaint4, int i5, TextDirectionHeuristic textDirectionHeuristic6, Layout.Alignment layout$Alignment7, int i8, TextUtils.TruncateAt textUtils$TruncateAt9, int i10, float f11, float f12, int i13, boolean z14, boolean z15, int i16, int i17, int i18, int i19, int[] i20Arr20, int[] i21Arr21, int i22, DefaultConstructorMarker defaultConstructorMarker23) {
        int i;
        int i4;
        i4 = i22 & 2 != 0 ? i : i2;
        super(charSequence, i4, i3, textPaint4, i5, textDirectionHeuristic6, alignment7, i8, truncateAt9, i10, f11, f12, i13, z14, z15, i16, i17, i18, i19, i20Arr20, i21Arr21);
    }

    public final Layout.Alignment getAlignment() {
        return this.alignment;
    }

    public final int getBreakStrategy() {
        return this.breakStrategy;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final int getEllipsizedWidth() {
        return this.ellipsizedWidth;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    public final int[] getLeftIndents() {
        return this.leftIndents;
    }

    public final int getLineBreakStyle() {
        return this.lineBreakStyle;
    }

    public final int getLineBreakWordStyle() {
        return this.lineBreakWordStyle;
    }

    public final float getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public final float getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final TextPaint getPaint() {
        return this.paint;
    }

    public final int[] getRightIndents() {
        return this.rightIndents;
    }

    public final int getStart() {
        return this.start;
    }

    public final java.lang.CharSequence getText() {
        return this.text;
    }

    public final TextDirectionHeuristic getTextDir() {
        return this.textDir;
    }

    public final boolean getUseFallbackLineSpacing() {
        return this.useFallbackLineSpacing;
    }

    public final int getWidth() {
        return this.width;
    }
}
