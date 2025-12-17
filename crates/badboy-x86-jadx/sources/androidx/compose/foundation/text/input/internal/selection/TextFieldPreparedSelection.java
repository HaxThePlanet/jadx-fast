package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008*\u0008\u0000\u0018\u0000 P2\u00020\u0001:\u0001PB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ,\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00072\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\u0008\u001fH\u0082\u0008J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u001f\u0010#\u001a\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\u0008\u001fJ\u001f\u0010%\u001a\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\u0008\u001fJ\u0019\u0010&\u001a\u00020\u001e2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120'H\u0086\u0008J\u0006\u0010(\u001a\u00020\u0000J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u0006\u0010.\u001a\u00020!J\u0008\u0010/\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020!H\u0002J\u0006\u00102\u001a\u00020\u0000J\u0006\u00103\u001a\u00020\u0000J\u0006\u00104\u001a\u00020\u0000J\u0006\u00105\u001a\u00020\u0000J\u0008\u00106\u001a\u00020\u0000H\u0002J\u0006\u00107\u001a\u00020\u0000J\u0008\u00108\u001a\u00020\u0000H\u0002J\u0008\u00109\u001a\u00020\u0000H\u0002J\u0006\u0010:\u001a\u00020\u0000J\u0008\u0010;\u001a\u00020\u0000H\u0002J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u0000J\u0006\u0010D\u001a\u00020\u0000J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0002J\u0016\u0010I\u001a\u00020!*\u00020\u00052\u0008\u0008\u0002\u0010J\u001a\u00020!H\u0002J\u0016\u0010K\u001a\u00020!*\u00020\u00052\u0008\u0008\u0002\u0010J\u001a\u00020!H\u0002J\u0017\u0010L\u001a\u00020!*\u00020\u00052\u0008\u0008\u0002\u0010J\u001a\u00020!H\u0082\u0010J\u0017\u0010M\u001a\u00020!*\u00020\u00052\u0008\u0008\u0002\u0010J\u001a\u00020!H\u0082\u0010J\u0014\u0010N\u001a\u00020!*\u00020\u00052\u0006\u0010O\u001a\u00020!H\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u00020\u0012X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "text", "", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "charOffset", "", "offset", "collapseLeftOr", "or", "collapseRightOr", "deleteIfSelectedOr", "Lkotlin/Function0;", "deselect", "getLineEndByOffset", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "jumpByPagesOffset", "pagesAmount", "moveCursorDownByLine", "moveCursorDownByPage", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "moveCursorUpByPage", "selectAll", "selectMovement", "setCursor", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffsetForLayout", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldPreparedSelection {

    public static final int $stable = 0;
    public static final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection.Companion Companion = null;
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    private final boolean isFromSoftKeyboard;
    private long selection;
    private final TransformedTextFieldState state;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection$Companion;", "", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        TextFieldPreparedSelection.Companion companion = new TextFieldPreparedSelection.Companion(0);
        TextFieldPreparedSelection.Companion = companion;
        TextFieldPreparedSelection.$stable = 8;
    }

    public TextFieldPreparedSelection(TransformedTextFieldState state, TextLayoutResult textLayoutResult, boolean isFromSoftKeyboard, float visibleTextLayoutHeight, androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState textPreparedSelectionState) {
        Function1 readObserver;
        super();
        this.state = state;
        this.textLayoutResult = textLayoutResult;
        this.isFromSoftKeyboard = isFromSoftKeyboard;
        this.visibleTextLayoutHeight = visibleTextLayoutHeight;
        this.textPreparedSelectionState = textPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.Companion;
        final int i = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        final int i2 = 0;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        this.initialValue = this.state.getVisualText();
        this.selection = this.initialValue.getSelection-d9O1mEE();
        this.text = this.initialValue.toString();
    }

    public static final TransformedTextFieldState access$getState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection $this) {
        return $this.state;
    }

    public static final String access$getText$p(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection $this) {
        return $this.text;
    }

    public static final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState access$getTextPreparedSelectionState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection $this) {
        return $this.textPreparedSelectionState;
    }

    public static final boolean access$isFromSoftKeyboard$p(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection $this) {
        return $this.isFromSoftKeyboard;
    }

    private final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection applyIfNotEmpty(boolean resetCachedX, Function1<? super androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection, Unit> block) {
        androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState field;
        int i;
        final int i2 = 0;
        if (resetCachedX) {
            TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        }
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            block.invoke(this);
        }
        return this;
    }

    static androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection applyIfNotEmpty$default(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection $this, boolean resetCachedX, Function1 block, int i4, Object object5) {
        androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState field;
        int obj2;
        int obj5;
        if (i4 &= obj5 != 0) {
            obj2 = 1;
        }
        int obj4 = 0;
        if (obj2 != null) {
            TextFieldPreparedSelection.access$getTextPreparedSelectionState$p($this).resetCachedX();
        }
        if ((CharSequence)TextFieldPreparedSelection.access$getText$p($this).length() > 0) {
        } else {
            obj5 = 0;
        }
        if (obj5 != null) {
            block.invoke($this);
        }
        return $this;
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, length--);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult $this$getLineEndByOffsetForLayout, int currentOffset) {
        return $this$getLineEndByOffsetForLayout.getLineEnd($this$getLineEndByOffsetForLayout.getLineForOffset(currentOffset), true);
    }

    static int getLineEndByOffsetForLayout$default(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        i4 &= 1;
        if (obj3 != null) {
            obj2 = TextRange.getMax-impl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult2, obj2);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult $this$getLineStartByOffsetForLayout, int currentOffset) {
        return $this$getLineStartByOffsetForLayout.getLineStart($this$getLineStartByOffsetForLayout.getLineForOffset(currentOffset));
    }

    static int getLineStartByOffsetForLayout$default(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        i4 &= 1;
        if (obj3 != null) {
            obj2 = TextRange.getMin-impl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult2, obj2);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult $this$getNextWordOffsetForLayout, int currentOffset) {
        long wordBoundary--jx7JFs;
        int end-impl;
        int obj5;
        while (obj5 >= this.initialValue.length()) {
            wordBoundary--jx7JFs = $this$getNextWordOffsetForLayout.getWordBoundary--jx7JFs(charOffset(obj5));
            obj5++;
        }
        return this.initialValue.length();
    }

    static int getNextWordOffsetForLayout$default(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        i4 &= 1;
        if (obj3 != null) {
            obj2 = TextRange.getEnd-impl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getNextWordOffsetForLayout(textLayoutResult2, obj2);
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult $this$getPrevWordOffsetForLayout, int currentOffset) {
        long wordBoundary--jx7JFs;
        int start-impl;
        int obj5;
        while (obj5 <= 0) {
            wordBoundary--jx7JFs = $this$getPrevWordOffsetForLayout.getWordBoundary--jx7JFs(charOffset(obj5));
            obj5--;
        }
        return 0;
    }

    static int getPrevWordOffsetForLayout$default(androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        i4 &= 1;
        if (obj3 != null) {
            obj2 = TextRange.getEnd-impl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getPrevWordOffsetForLayout(textLayoutResult2, obj2);
    }

    private final boolean isLtr() {
        Object paragraphDirection;
        int i;
        int end-impl;
        paragraphDirection = this.textLayoutResult;
        if (paragraphDirection != null) {
            paragraphDirection = paragraphDirection.getParagraphDirection(TextRange.getEnd-impl(this.selection));
            if (paragraphDirection == null) {
            } else {
                if (paragraphDirection == ResolvedTextDirection.Ltr) {
                } else {
                    i = 0;
                }
            }
            return i;
        }
        return 1;
    }

    private final int jumpByLinesOffset(TextLayoutResult $this$jumpByLinesOffset, int linesAmount) {
        boolean textPreparedSelectionState;
        float left;
        int ltr;
        int end-impl = TextRange.getEnd-impl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX($this$jumpByLinesOffset.getCursorRect(end-impl).getLeft());
        }
        lineForOffset += linesAmount;
        if (i < 0) {
            return 0;
        }
        if (i >= $this$jumpByLinesOffset.getLineCount()) {
            return this.text.length();
        }
        int i4 = 1;
        float cachedX2 = this.textPreparedSelectionState.getCachedX();
        float f2 = cachedX2;
        if (isLtr()) {
            if (Float.compare(f2, lineRight) < 0 && !isLtr() && Float.compare(f2, lineLeft) <= 0) {
                if (!isLtr()) {
                    if (Float.compare(f2, lineLeft) <= 0) {
                    }
                }
            }
            return $this$jumpByLinesOffset.getLineEnd(i, i4);
        } else {
        }
        return $this$jumpByLinesOffset.getOffsetForPosition-k-4lQ0M(OffsetKt.Offset(cachedX2, lineBottom -= f));
    }

    private final int jumpByPagesOffset(int pagesAmount) {
        TextLayoutResult textLayoutResult;
        int offsetForPosition-k-4lQ0M;
        long bottomLeft-F1C5BW0;
        int end-impl = TextRange.getEnd-impl(this.initialValue.getSelection-d9O1mEE());
        if (this.textLayoutResult != null) {
            if (Float.isNaN(this.visibleTextLayoutHeight)) {
            } else {
                Rect translate = this.textLayoutResult.getCursorRect(end-impl).translate(0, visibleTextLayoutHeight2 *= f);
                float lineBottom = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(translate.getTop()));
                if (Float.compare(f2, f3) > 0) {
                    offsetForPosition-k-4lQ0M = this.textLayoutResult.getOffsetForPosition-k-4lQ0M(translate.getTopLeft-F1C5BW0());
                } else {
                    offsetForPosition-k-4lQ0M = this.textLayoutResult.getOffsetForPosition-k-4lQ0M(translate.getBottomLeft-F1C5BW0());
                }
            }
            return offsetForPosition-k-4lQ0M;
        }
        return end-impl;
    }

    private final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorNext() {
        int i;
        int adjacentCursorPosition;
        int i2;
        int end-impl;
        long text;
        TransformedTextFieldState state;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        adjacentCursorPosition = 1;
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? adjacentCursorPosition : 0;
        i = this;
        i2 = 0;
        end-impl = TextRange.getEnd-impl(i.selection);
        adjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(i.text, end-impl, adjacentCursorPosition, i.state);
        if (i != 0 && adjacentCursorPosition != end-impl) {
            i = this;
            i2 = 0;
            end-impl = TextRange.getEnd-impl(i.selection);
            adjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(i.text, end-impl, adjacentCursorPosition, i.state);
            if (adjacentCursorPosition != end-impl) {
                (TextFieldPreparedSelection)(TextFieldPreparedSelection)i.setCursor(adjacentCursorPosition);
            }
        }
        return this;
    }

    private final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorNextByWord() {
        int i;
        int i2;
        int nextWordOffset;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            i.setCursor((TextFieldPreparedSelection)i.getNextWordOffset());
        }
        return this;
    }

    private final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorPrev() {
        int i2;
        int adjacentCursorPosition;
        int i;
        int end-impl;
        long text;
        TransformedTextFieldState state;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        adjacentCursorPosition = 0;
        i2 = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : adjacentCursorPosition;
        i2 = this;
        i = 0;
        end-impl = TextRange.getEnd-impl(i2.selection);
        adjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(i2.text, end-impl, adjacentCursorPosition, i2.state);
        if (i2 != 0 && adjacentCursorPosition != end-impl) {
            i2 = this;
            i = 0;
            end-impl = TextRange.getEnd-impl(i2.selection);
            adjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(i2.text, end-impl, adjacentCursorPosition, i2.state);
            if (adjacentCursorPosition != end-impl) {
                (TextFieldPreparedSelection)(TextFieldPreparedSelection)i2.setCursor(adjacentCursorPosition);
            }
        }
        return this;
    }

    private final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorPrevByWord() {
        int i2;
        int i;
        int previousWordOffset;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i2 = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            i2.setCursor((TextFieldPreparedSelection)i2.getPreviousWordOffset());
        }
        return this;
    }

    private final void setCursor(int offset) {
        this.selection = TextRangeKt.TextRange(offset, offset);
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection collapseLeftOr(Function1<? super androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection, Unit> or) {
        int i;
        int i2;
        int collapsed-impl;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if (TextRange.getCollapsed-impl(i.selection)) {
                or.invoke((TextFieldPreparedSelection)i);
            } else {
                if (i.isLtr()) {
                    i.setCursor(TextRange.getMin-impl(i.selection));
                } else {
                    i.setCursor(TextRange.getMax-impl(i.selection));
                }
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection collapseRightOr(Function1<? super androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection, Unit> or) {
        int i;
        int i2;
        int collapsed-impl;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if (TextRange.getCollapsed-impl(i.selection)) {
                or.invoke((TextFieldPreparedSelection)i);
            } else {
                if (i.isLtr()) {
                    i.setCursor(TextRange.getMax-impl(i.selection));
                } else {
                    i.setCursor(TextRange.getMin-impl(i.selection));
                }
            }
        }
        return this;
    }

    public final void deleteIfSelectedOr(Function0<TextRange> block) {
        boolean invoke;
        String str;
        TransformedTextFieldState field;
        String str2;
        long selection-d9O1mEE;
        int i;
        int i2;
        int i4;
        int i3;
        final int i5 = 0;
        str = "";
        if (!TextRange.getCollapsed-impl(getSelection-d9O1mEE())) {
            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(this), (CharSequence)str, getSelection-d9O1mEE(), obj6, false, invoke ^ 1, 4);
        } else {
            invoke = block.invoke();
            if ((TextRange)invoke != null) {
                invoke = 0;
                TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(this), (CharSequence)str, (TextRange)invoke.unbox-impl(), obj6, false, str ^ 1, 4);
            }
        }
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection deselect() {
        int i;
        int i2;
        int end-impl;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            (TextFieldPreparedSelection)i.setCursor(TextRange.getEnd-impl(i.selection));
        }
        return this;
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final int getLineEndByOffset() {
        int lineEndByOffsetForLayout$default;
        int i;
        int i2;
        int i3;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            lineEndByOffsetForLayout$default = TextFieldPreparedSelection.getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, 0);
        } else {
            lineEndByOffsetForLayout$default = this.text.length();
        }
        return lineEndByOffsetForLayout$default;
    }

    public final int getLineStartByOffset() {
        int lineStartByOffsetForLayout$default;
        int i;
        int i2;
        final TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            lineStartByOffsetForLayout$default = TextFieldPreparedSelection.getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, 0);
        }
        return lineStartByOffsetForLayout$default;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.getEnd-impl(this.selection));
    }

    public final int getNextWordOffset() {
        int nextWordOffsetForLayout$default;
        int i2;
        int i;
        int i3;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            nextWordOffsetForLayout$default = TextFieldPreparedSelection.getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, 0);
        } else {
            nextWordOffsetForLayout$default = this.text.length();
        }
        return nextWordOffsetForLayout$default;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.getEnd-impl(this.selection));
    }

    public final int getPreviousWordOffset() {
        int prevWordOffsetForLayout$default;
        int i2;
        int i;
        final TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            prevWordOffsetForLayout$default = TextFieldPreparedSelection.getPrevWordOffsetForLayout$default(this, textLayoutResult, 0, 1, 0);
        }
        return prevWordOffsetForLayout$default;
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorDownByLine() {
        int i;
        int jumpByLinesOffset;
        int i2;
        TextLayoutResult textLayoutResult;
        if (this.textLayoutResult == null) {
            return this;
        }
        int i3 = 0;
        final Object obj = this;
        final int i4 = 0;
        jumpByLinesOffset = 1;
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(obj).length() > 0 ? jumpByLinesOffset : 0;
        if (i != 0) {
            i = obj;
            i2 = 0;
            textLayoutResult = i.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult);
            i.setCursor((TextFieldPreparedSelection)i.jumpByLinesOffset(textLayoutResult, jumpByLinesOffset));
        }
        return obj;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorDownByPage() {
        int i;
        int jumpByPagesOffset;
        int i2;
        final int i3 = 0;
        final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection field = this;
        final int i4 = 0;
        jumpByPagesOffset = 1;
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(field).length() > 0 ? jumpByPagesOffset : 0;
        if (i != 0) {
            i = field;
            i2 = 0;
            i.setCursor((TextFieldPreparedSelection)i.jumpByPagesOffset(jumpByPagesOffset));
        }
        return field;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorLeft() {
        int i;
        int i2;
        boolean ltr;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((TextFieldPreparedSelection)i.isLtr()) {
                i.moveCursorPrev();
            } else {
                i.moveCursorNext();
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorLeftByWord() {
        int i;
        int i2;
        boolean ltr;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((TextFieldPreparedSelection)i.isLtr()) {
                i.moveCursorPrevByWord();
            } else {
                i.moveCursorNextByWord();
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorNextByParagraph() {
        int i;
        int i2;
        int paragraphEnd;
        int max-impl;
        long l;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        i = this;
        i2 = 0;
        paragraphEnd = StringHelpersKt.findParagraphEnd((CharSequence)i.text, TextRange.getMax-impl(i.selection));
        if (i != 0 && paragraphEnd == TextRange.getMax-impl(i.selection) && paragraphEnd != i.text.length()) {
            i = this;
            i2 = 0;
            paragraphEnd = StringHelpersKt.findParagraphEnd((CharSequence)i.text, TextRange.getMax-impl(i.selection));
            if (paragraphEnd == TextRange.getMax-impl(i.selection)) {
                if (paragraphEnd != i.text.length()) {
                    paragraphEnd = StringHelpersKt.findParagraphEnd((CharSequence)i.text, paragraphEnd + 1);
                }
            }
            (TextFieldPreparedSelection)(TextFieldPreparedSelection)i.setCursor(paragraphEnd);
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorPrevByParagraph() {
        int i;
        int i2;
        int paragraphStart;
        int min-impl;
        long l;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        i = this;
        i2 = 0;
        paragraphStart = StringHelpersKt.findParagraphStart((CharSequence)i.text, TextRange.getMin-impl(i.selection));
        if (i != 0 && paragraphStart == TextRange.getMin-impl(i.selection) && paragraphStart != 0) {
            i = this;
            i2 = 0;
            paragraphStart = StringHelpersKt.findParagraphStart((CharSequence)i.text, TextRange.getMin-impl(i.selection));
            if (paragraphStart == TextRange.getMin-impl(i.selection)) {
                if (paragraphStart != 0) {
                    paragraphStart = StringHelpersKt.findParagraphStart((CharSequence)i.text, paragraphStart + -1);
                }
            }
            (TextFieldPreparedSelection)(TextFieldPreparedSelection)i.setCursor(paragraphStart);
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorRight() {
        int i;
        int i2;
        boolean ltr;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((TextFieldPreparedSelection)i.isLtr()) {
                i.moveCursorNext();
            } else {
                i.moveCursorPrev();
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorRightByWord() {
        int i2;
        int i;
        boolean ltr;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i2 = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if ((TextFieldPreparedSelection)i2.isLtr()) {
                i2.moveCursorNextByWord();
            } else {
                i2.moveCursorPrevByWord();
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorToEnd() {
        int i;
        int i2;
        int length;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            (TextFieldPreparedSelection)i.setCursor(i.text.length());
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorToHome() {
        int i2;
        int i;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        final int i5 = 0;
        i2 = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : i5;
        if (i2 != 0) {
            i = 0;
            (TextFieldPreparedSelection)this.setCursor(i5);
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorToLineEnd() {
        int i;
        int i2;
        int lineEndByOffset;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            i.setCursor((TextFieldPreparedSelection)i.getLineEndByOffset());
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorToLineLeftSide() {
        int i;
        int i2;
        boolean ltr;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((TextFieldPreparedSelection)i.isLtr()) {
                i.moveCursorToLineStart();
            } else {
                i.moveCursorToLineEnd();
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorToLineRightSide() {
        int i;
        int i2;
        boolean ltr;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((TextFieldPreparedSelection)i.isLtr()) {
                i.moveCursorToLineEnd();
            } else {
                i.moveCursorToLineStart();
            }
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorToLineStart() {
        int i;
        int i2;
        int lineStartByOffset;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            i.setCursor((TextFieldPreparedSelection)i.getLineStartByOffset());
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorUpByLine() {
        int i2;
        int i;
        int jumpByLinesOffset;
        int i3;
        if (this.textLayoutResult == null) {
            return this;
        }
        int i4 = 0;
        final Object obj = this;
        final int i5 = 0;
        i2 = (CharSequence)TextFieldPreparedSelection.access$getText$p(obj).length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = obj;
            i = 0;
            TextLayoutResult textLayoutResult2 = i2.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult2);
            i2.setCursor((TextFieldPreparedSelection)i2.jumpByLinesOffset(textLayoutResult2, -1));
        }
        return obj;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection moveCursorUpByPage() {
        int i;
        int i2;
        int jumpByPagesOffset;
        final int i3 = 0;
        final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection field = this;
        final int i4 = 0;
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(field).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = field;
            i2 = 0;
            i.setCursor((TextFieldPreparedSelection)i.jumpByPagesOffset(-1));
        }
        return field;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection selectAll() {
        int i;
        int i2;
        long l;
        final int i3 = 1;
        final int i4 = 0;
        TextFieldPreparedSelection.access$getTextPreparedSelectionState$p(this).resetCachedX();
        final int i5 = 0;
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(this).length() > 0 ? 1 : i5;
        if (i != 0) {
            i = this;
            i2 = 0;
            i.selection = TextRangeKt.TextRange(i5, i.text.length());
        }
        return this;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection selectMovement() {
        int i;
        int i2;
        long l;
        long end-impl;
        final int i3 = 0;
        final androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection field = this;
        final int i4 = 0;
        i = (CharSequence)TextFieldPreparedSelection.access$getText$p(field).length() > 0 ? 1 : 0;
        if (i != 0) {
            i = field;
            i2 = 0;
            i.selection = TextRangeKt.TextRange(TextRange.getStart-impl(i.initialValue.getSelection-d9O1mEE()), TextRange.getEnd-impl(i.selection));
        }
        return field;
    }

    public final void setSelection-5zc-tL8(long <set-?>) {
        this.selection = <set-?>;
    }
}
