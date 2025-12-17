package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import android.text.Layout.Alignment;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0000\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"EllipsisChar", "", "getEllipsizedLeftPadding", "", "Landroid/text/Layout;", "lineIndex", "", "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IndentationFixSpan_androidKt {

    private static final String EllipsisChar = "…";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            IndentationFixSpan_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final float getEllipsizedLeftPadding(Layout $this$getEllipsizedLeftPadding, int lineIndex, Paint paint) {
        boolean paragraphDirection;
        int i3;
        int i4;
        int i;
        int i2;
        int[] $EnumSwitchMapping$0;
        final float lineLeft = $this$getEllipsizedLeftPadding.getLineLeft(lineIndex);
        int i6 = 0;
        i3 = 1;
        if (TextLayout_androidKt.isLineEllipsized($this$getEllipsizedLeftPadding, lineIndex) && $this$getEllipsizedLeftPadding.getParagraphDirection(lineIndex) == i3 && Float.compare(lineLeft, i6) < 0) {
            i3 = 1;
            if ($this$getEllipsizedLeftPadding.getParagraphDirection(lineIndex) == i3) {
                if (Float.compare(lineLeft, i6) < 0) {
                    i7 += measureText;
                    Layout.Alignment paragraphAlignment = $this$getEllipsizedLeftPadding.getParagraphAlignment(lineIndex);
                    if (paragraphAlignment == null) {
                        i = -1;
                    } else {
                        i = IndentationFixSpan_androidKt.WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
                    }
                    if (i == i3) {
                        f += i2;
                    } else {
                        f2 += i2;
                    }
                    return i4;
                }
            }
        }
        return i6;
    }

    public static float getEllipsizedLeftPadding$default(Layout layout, int i2, Paint paint3, int i4, Object object5) {
        android.text.TextPaint obj2;
        if (i4 &= 2 != 0) {
            obj2 = layout.getPaint();
        }
        return IndentationFixSpan_androidKt.getEllipsizedLeftPadding(layout, i2, obj2);
    }

    public static final float getEllipsizedRightPadding(Layout $this$getEllipsizedRightPadding, int lineIndex, Paint paint) {
        boolean paragraphDirection;
        int i2;
        int i3;
        float lineRight;
        int paragraphAlignment;
        int i4;
        int i;
        if (TextLayout_androidKt.isLineEllipsized($this$getEllipsizedRightPadding, lineIndex) && $this$getEllipsizedRightPadding.getParagraphDirection(lineIndex) == -1 && Float.compare(f, lineRight) < 0) {
            if ($this$getEllipsizedRightPadding.getParagraphDirection(lineIndex) == -1) {
                if (Float.compare(f, lineRight) < 0) {
                    i8 += measureText;
                    paragraphAlignment = $this$getEllipsizedRightPadding.getParagraphAlignment(lineIndex);
                    if (paragraphAlignment == null) {
                    } else {
                        i2 = IndentationFixSpan_androidKt.WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
                    }
                    if (i2 == 1) {
                        i6 -= i4;
                    } else {
                        i7 -= i4;
                    }
                    return i3;
                }
            }
        }
        return 0;
    }

    public static float getEllipsizedRightPadding$default(Layout layout, int i2, Paint paint3, int i4, Object object5) {
        android.text.TextPaint obj2;
        if (i4 &= 2 != 0) {
            obj2 = layout.getPaint();
        }
        return IndentationFixSpan_androidKt.getEllipsizedRightPadding(layout, i2, obj2);
    }
}
