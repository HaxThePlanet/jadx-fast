package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J$\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J\u0013\u0010*\u001a\u00020\n2\u0008\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u00100\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aJ\u0016\u00101\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u0018\u00106\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\u0008\u0008\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0010J\u000e\u0010;\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010<\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010=\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010>\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020Aø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ\u000e\u0010D\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001aJ\u001b\u0010I\u001a\u00020J2\u0006\u0010.\u001a\u00020\u001aø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u0008\u0010M\u001a\u00020\u001aH\u0016J\u000e\u0010N\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001aJ\u0008\u0010O\u001a\u00020PH\u0016R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u000cR\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008$\u0010%\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/ui/text/TextLayoutResult;", "", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "didOverflowHeight", "", "getDidOverflowHeight", "()Z", "didOverflowWidth", "getDidOverflowWidth", "firstBaseline", "", "getFirstBaseline", "()F", "hasVisualOverflow", "getHasVisualOverflow", "lastBaseline", "getLastBaseline", "getLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "lineCount", "", "getLineCount", "()I", "getMultiParagraph", "()Landroidx/compose/ui/text/MultiParagraph;", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "getSize-YbymL2g", "()J", "J", "copy", "copy-O0kMr_c", "(Landroidx/compose/ui/text/TextLayoutInput;J)Landroidx/compose/ui/text/TextLayoutResult;", "equals", "other", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "hashCode", "isLineEllipsized", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutResult {

    public static final int $stable = 8;
    private final float firstBaseline;
    private final float lastBaseline;
    private final androidx.compose.ui.text.TextLayoutInput layoutInput;
    private final androidx.compose.ui.text.MultiParagraph multiParagraph;
    private final List<Rect> placeholderRects;
    private final long size;
    static {
        final int i = 8;
    }

    private TextLayoutResult(androidx.compose.ui.text.TextLayoutInput layoutInput, androidx.compose.ui.text.MultiParagraph multiParagraph, long size) {
        super();
        this.layoutInput = layoutInput;
        this.multiParagraph = multiParagraph;
        this.size = size;
        this.firstBaseline = this.multiParagraph.getFirstBaseline();
        this.lastBaseline = this.multiParagraph.getLastBaseline();
        this.placeholderRects = this.multiParagraph.getPlaceholderRects();
    }

    public TextLayoutResult(androidx.compose.ui.text.TextLayoutInput textLayoutInput, androidx.compose.ui.text.MultiParagraph multiParagraph2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(textLayoutInput, multiParagraph2, l3, defaultConstructorMarker4);
    }

    public static androidx.compose.ui.text.TextLayoutResult copy-O0kMr_c$default(androidx.compose.ui.text.TextLayoutResult textLayoutResult, androidx.compose.ui.text.TextLayoutInput textLayoutInput2, long l3, int i4, Object object5) {
        androidx.compose.ui.text.TextLayoutInput obj1;
        long obj2;
        if (object5 & 1 != 0) {
            obj1 = textLayoutResult.layoutInput;
        }
        if (object5 &= 2 != 0) {
            obj2 = textLayoutResult.size;
        }
        return textLayoutResult.copy-O0kMr_c(obj1, obj2);
    }

    public static int getLineEnd$default(androidx.compose.ui.text.TextLayoutResult textLayoutResult, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return textLayoutResult.getLineEnd(i2, obj2);
    }

    public final androidx.compose.ui.text.TextLayoutResult copy-O0kMr_c(androidx.compose.ui.text.TextLayoutInput layoutInput, long size) {
        TextLayoutResult textLayoutResult = new TextLayoutResult(layoutInput, this.multiParagraph, size, obj4, 0);
        return textLayoutResult;
    }

    public boolean equals(Object other) {
        int i2;
        int i;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (other instanceof TextLayoutResult == null) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.layoutInput, obj2.layoutInput)) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.multiParagraph, obj3.multiParagraph)) {
            return i4;
        }
        if (!IntSize.equals-impl0(this.size, obj4)) {
            return i4;
        }
        i2 = Float.compare(firstBaseline, firstBaseline2) == 0 ? i3 : i4;
        if (i2 == 0) {
            return i4;
        }
        i = Float.compare(lastBaseline, lastBaseline2) == 0 ? i3 : i4;
        if (i == 0) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.placeholderRects, obj6.placeholderRects)) {
            return i4;
        }
        return i3;
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        return this.multiParagraph.getBidiRunDirection(offset);
    }

    public final Rect getBoundingBox(int offset) {
        return this.multiParagraph.getBoundingBox(offset);
    }

    public final Rect getCursorRect(int offset) {
        return this.multiParagraph.getCursorRect(offset);
    }

    public final boolean getDidOverflowHeight() {
        int i;
        boolean didExceedMaxLines;
        float height;
        if (!this.multiParagraph.getDidExceedMaxLines()) {
            if (Float.compare(f, height) < 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean getDidOverflowWidth() {
        int i;
        i = Float.compare(f, width) < 0 ? 1 : 0;
        return i;
    }

    public final float getFirstBaseline() {
        return this.firstBaseline;
    }

    public final boolean getHasVisualOverflow() {
        int i;
        boolean didOverflowHeight;
        if (!getDidOverflowWidth()) {
            if (getDidOverflowHeight()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        return this.multiParagraph.getHorizontalPosition(offset, usePrimaryDirection);
    }

    public final float getLastBaseline() {
        return this.lastBaseline;
    }

    public final androidx.compose.ui.text.TextLayoutInput getLayoutInput() {
        return this.layoutInput;
    }

    public final float getLineBaseline(int lineIndex) {
        return this.multiParagraph.getLineBaseline(lineIndex);
    }

    public final float getLineBottom(int lineIndex) {
        return this.multiParagraph.getLineBottom(lineIndex);
    }

    public final int getLineCount() {
        return this.multiParagraph.getLineCount();
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        return this.multiParagraph.getLineEnd(lineIndex, visibleEnd);
    }

    public final int getLineForOffset(int offset) {
        return this.multiParagraph.getLineForOffset(offset);
    }

    public final int getLineForVerticalPosition(float vertical) {
        return this.multiParagraph.getLineForVerticalPosition(vertical);
    }

    public final float getLineLeft(int lineIndex) {
        return this.multiParagraph.getLineLeft(lineIndex);
    }

    public final float getLineRight(int lineIndex) {
        return this.multiParagraph.getLineRight(lineIndex);
    }

    public final int getLineStart(int lineIndex) {
        return this.multiParagraph.getLineStart(lineIndex);
    }

    public final float getLineTop(int lineIndex) {
        return this.multiParagraph.getLineTop(lineIndex);
    }

    public final androidx.compose.ui.text.MultiParagraph getMultiParagraph() {
        return this.multiParagraph;
    }

    public final int getOffsetForPosition-k-4lQ0M(long position) {
        return this.multiParagraph.getOffsetForPosition-k-4lQ0M(position);
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        return this.multiParagraph.getParagraphDirection(offset);
    }

    public final Path getPathForRange(int start, int end) {
        return this.multiParagraph.getPathForRange(start, end);
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final long getSize-YbymL2g() {
        return this.size;
    }

    public final long getWordBoundary--jx7JFs(int offset) {
        return this.multiParagraph.getWordBoundary--jx7JFs(offset);
    }

    public int hashCode() {
        return result4 += i12;
    }

    public final boolean isLineEllipsized(int lineIndex) {
        return this.multiParagraph.isLineEllipsized(lineIndex);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextLayoutResult(layoutInput=").append(this.layoutInput).append(", multiParagraph=").append(this.multiParagraph).append(", size=").append(IntSize.toString-impl(this.size)).append(", firstBaseline=").append(this.firstBaseline).append(", lastBaseline=").append(this.lastBaseline).append(", placeholderRects=").append(this.placeholderRects).append(')').toString();
    }
}
