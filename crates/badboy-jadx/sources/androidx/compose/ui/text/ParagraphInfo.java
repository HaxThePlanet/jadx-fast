package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u001d\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0080\u0008\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003JO\u0010&\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010'\u001a\u00020(2\u0008\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\n\u0010-\u001a\u00020.*\u00020.J\n\u0010-\u001a\u00020/*\u00020/J\u001e\u0010-\u001a\u000200*\u0002002\u0008\u0008\u0002\u00101\u001a\u00020(ø\u0001\u0000¢\u0006\u0004\u00082\u00103J\n\u00104\u001a\u00020\u0005*\u00020\u0005J\n\u00105\u001a\u00020\u0005*\u00020\u0005J\n\u00106\u001a\u00020\n*\u00020\nJ\u0014\u00107\u001a\u000208*\u000208ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\n\u00107\u001a\u00020.*\u00020.J\n\u0010;\u001a\u00020\u0005*\u00020\u0005J\n\u0010<\u001a\u00020\u0005*\u00020\u0005J\n\u0010=\u001a\u00020\n*\u00020\nR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0008\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012\"\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0012\"\u0004\u0008\u001c\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u000e\"\u0004\u0008\u001e\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006>", d2 = {"Landroidx/compose/ui/text/ParagraphInfo;", "", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "startIndex", "", "endIndex", "startLineIndex", "endLineIndex", "top", "", "bottom", "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "getBottom", "()F", "setBottom", "(F)V", "getEndIndex", "()I", "getEndLineIndex", "setEndLineIndex", "(I)V", "length", "getLength", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "getStartIndex", "getStartLineIndex", "setStartLineIndex", "getTop", "setTop", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "toGlobal", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "treatZeroAsNull", "toGlobal-xdX6-G0", "(JZ)J", "toGlobalIndex", "toGlobalLineIndex", "toGlobalYPosition", "toLocal", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "(J)J", "toLocalIndex", "toLocalLineIndex", "toLocalYPosition", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParagraphInfo {

    public static final int $stable = 8;
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    private final androidx.compose.ui.text.Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;
    static {
        final int i = 8;
    }

    public ParagraphInfo(androidx.compose.ui.text.Paragraph paragraph, int startIndex, int endIndex, int startLineIndex, int endLineIndex, float top, float bottom) {
        super();
        this.paragraph = paragraph;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.startLineIndex = startLineIndex;
        this.endLineIndex = endLineIndex;
        this.top = top;
        this.bottom = bottom;
    }

    public ParagraphInfo(androidx.compose.ui.text.Paragraph paragraph, int i2, int i3, int i4, int i5, float f6, float f7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int obj5;
        int obj6;
        int obj7;
        int obj9;
        int i = -1;
        obj5 = i8 & 8 != 0 ? i : obj5;
        obj6 = i8 & 16 != 0 ? i : obj6;
        int i6 = -1082130432;
        obj7 = i8 & 32 != 0 ? i6 : obj7;
        obj9 = i8 &= 64 != 0 ? i6 : f7;
        super(paragraph, i2, i3, obj5, obj6, obj7, obj9);
    }

    public static androidx.compose.ui.text.ParagraphInfo copy$default(androidx.compose.ui.text.ParagraphInfo paragraphInfo, androidx.compose.ui.text.Paragraph paragraph2, int i3, int i4, int i5, int i6, float f7, float f8, int i9, Object object10) {
        androidx.compose.ui.text.Paragraph obj1;
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        float obj6;
        float obj7;
        if (i9 & 1 != 0) {
            obj1 = paragraphInfo.paragraph;
        }
        if (i9 & 2 != 0) {
            obj2 = paragraphInfo.startIndex;
        }
        if (i9 & 4 != 0) {
            obj3 = paragraphInfo.endIndex;
        }
        if (i9 & 8 != 0) {
            obj4 = paragraphInfo.startLineIndex;
        }
        if (i9 & 16 != 0) {
            obj5 = paragraphInfo.endLineIndex;
        }
        if (i9 & 32 != 0) {
            obj6 = paragraphInfo.top;
        }
        if (i9 &= 64 != 0) {
            obj7 = paragraphInfo.bottom;
        }
        return paragraphInfo.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static long toGlobal-xdX6-G0$default(androidx.compose.ui.text.ParagraphInfo paragraphInfo, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        final int obj5 = 1;
        if (object5 &= obj5 != 0) {
            obj3 = obj5;
        }
        return paragraphInfo.toGlobal-xdX6-G0(l2, z3);
    }

    public final androidx.compose.ui.text.Paragraph component1() {
        return this.paragraph;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final int component4() {
        return this.startLineIndex;
    }

    public final int component5() {
        return this.endLineIndex;
    }

    public final float component6() {
        return this.top;
    }

    public final float component7() {
        return this.bottom;
    }

    public final androidx.compose.ui.text.ParagraphInfo copy(androidx.compose.ui.text.Paragraph paragraph, int i2, int i3, int i4, int i5, float f6, float f7) {
        ParagraphInfo paragraphInfo = new ParagraphInfo(paragraph, i2, i3, i4, i5, f6, f7);
        return paragraphInfo;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ParagraphInfo) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.paragraph, obj.paragraph)) {
            return i2;
        }
        if (this.startIndex != obj.startIndex) {
            return i2;
        }
        if (this.endIndex != obj.endIndex) {
            return i2;
        }
        if (this.startLineIndex != obj.startLineIndex) {
            return i2;
        }
        if (this.endLineIndex != obj.endLineIndex) {
            return i2;
        }
        if (Float.compare(this.top, obj.top) != 0) {
            return i2;
        }
        if (Float.compare(this.bottom, obj.bottom) != 0) {
            return i2;
        }
        return i;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final int getLength() {
        return endIndex -= startIndex;
    }

    public final androidx.compose.ui.text.Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public int hashCode() {
        return i6 += i19;
    }

    public final void setBottom(float <set-?>) {
        this.bottom = <set-?>;
    }

    public final void setEndLineIndex(int <set-?>) {
        this.endLineIndex = <set-?>;
    }

    public final void setStartLineIndex(int <set-?>) {
        this.startLineIndex = <set-?>;
    }

    public final void setTop(float <set-?>) {
        this.top = <set-?>;
    }

    public final Rect toGlobal(Rect $this$toGlobal) {
        final float top = this.top;
        return $this$toGlobal.translate-k-4lQ0M(OffsetKt.Offset(0, top));
    }

    public final Path toGlobal(Path $this$toGlobal) {
        final float top = this.top;
        $this$toGlobal.translate-k-4lQ0M(OffsetKt.Offset(0, top));
        return $this$toGlobal;
    }

    public final long toGlobal-xdX6-G0(long $this$toGlobal_u2dxdX6_u2dG0, boolean treatZeroAsNull) {
        boolean equals-impl0;
        if (obj5 != null && TextRange.equals-impl0($this$toGlobal_u2dxdX6_u2dG0, treatZeroAsNull)) {
            if (TextRange.equals-impl0($this$toGlobal_u2dxdX6_u2dG0, treatZeroAsNull)) {
                return TextRange.Companion.getZero-d9O1mEE();
            }
        }
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.getStart-impl($this$toGlobal_u2dxdX6_u2dG0)), toGlobalIndex(TextRange.getEnd-impl($this$toGlobal_u2dxdX6_u2dG0)));
    }

    public final int toGlobalIndex(int $this$toGlobalIndex) {
        return startIndex += $this$toGlobalIndex;
    }

    public final int toGlobalLineIndex(int $this$toGlobalLineIndex) {
        return startLineIndex += $this$toGlobalLineIndex;
    }

    public final float toGlobalYPosition(float $this$toGlobalYPosition) {
        return top += $this$toGlobalYPosition;
    }

    public final Rect toLocal(Rect $this$toLocal) {
        final int i2 = 0;
        return $this$toLocal.translate-k-4lQ0M(OffsetKt.Offset(i2, -top));
    }

    public final long toLocal-MK-Hz9U(long $this$toLocal_u2dMK_u2dHz9U) {
        return OffsetKt.Offset(Offset.getX-impl($this$toLocal_u2dMK_u2dHz9U), y-impl -= top);
    }

    public final int toLocalIndex(int $this$toLocalIndex) {
        return coerceIn -= startIndex2;
    }

    public final int toLocalLineIndex(int $this$toLocalLineIndex) {
        return $this$toLocalLineIndex - startLineIndex;
    }

    public final float toLocalYPosition(float $this$toLocalYPosition) {
        return $this$toLocalYPosition - top;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ParagraphInfo(paragraph=").append(this.paragraph).append(", startIndex=").append(this.startIndex).append(", endIndex=").append(this.endIndex).append(", startLineIndex=").append(this.startLineIndex).append(", endLineIndex=").append(this.endLineIndex).append(", top=").append(this.top).append(", bottom=").append(this.bottom).append(')').toString();
    }
}
