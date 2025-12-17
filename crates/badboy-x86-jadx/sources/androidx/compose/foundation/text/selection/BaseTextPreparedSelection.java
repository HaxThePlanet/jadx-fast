package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008)\u0008 \u0018\u0000 a*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001aB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J$\u0010(\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\u0008,¢\u0006\u0002\u0010-J$\u0010.\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\u0008,¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u00101\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\r\u00103\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020&J\r\u00105\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00106\u001a\u00020&J\r\u00107\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0008\u00108\u001a\u000209H\u0002J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010;\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010<\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010=\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\r\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010A\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010J\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0010\u0010N\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0004J\u0018\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020&H\u0004J\u0008\u0010R\u001a\u00020&H\u0002J\u0008\u0010S\u001a\u00020&H\u0002J\u0008\u0010T\u001a\u00020&H\u0002J;\u0010U\u001a\u00028\u0000\"\u0004\u0008\u0001\u0010V*\u0002HV2\u0008\u0008\u0002\u0010W\u001a\u0002092\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\u0008,H\u0084\u0008¢\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u00020&*\u00020\u00082\u0008\u0008\u0002\u0010[\u001a\u00020&H\u0002J\u0016\u0010\\\u001a\u00020&*\u00020\u00082\u0008\u0008\u0002\u0010[\u001a\u00020&H\u0002J\u0017\u0010]\u001a\u00020&*\u00020\u00082\u0008\u0008\u0002\u0010[\u001a\u00020&H\u0082\u0010J\u0017\u0010^\u001a\u00020&*\u00020\u00082\u0008\u0008\u0002\u0010[\u001a\u00020&H\u0082\u0010J\u0014\u0010_\u001a\u00020&*\u00020\u00082\u0006\u0010`\u001a\u00020&H\u0002R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0010R\"\u0010\u001b\u001a\u00020\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\u0008\u001c\u0010\u0018\"\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006b", d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getOriginalSelection-d9O1mEE", "()J", "J", "getOriginalText", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "charOffset", "", "offset", "collapseLeftOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "deselect", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffset", "()Ljava/lang/Integer;", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "", "moveCursorDownByLine", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "selectAll", "selectMovement", "setCursor", "setSelection", "start", "end", "transformedEndOffset", "transformedMaxOffset", "transformedMinOffset", "apply", "U", "resetCachedX", "block", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffset", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseTextPreparedSelection<T extends androidx.compose.foundation.text.selection.BaseTextPreparedSelection<T>>  {

    public static final int $stable = 0;
    public static final androidx.compose.foundation.text.selection.BaseTextPreparedSelection.Companion Companion = null;
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final androidx.compose.foundation.text.selection.TextPreparedSelectionState state;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        BaseTextPreparedSelection.Companion companion = new BaseTextPreparedSelection.Companion(0);
        BaseTextPreparedSelection.Companion = companion;
        BaseTextPreparedSelection.$stable = 8;
    }

    private BaseTextPreparedSelection(AnnotatedString originalText, long originalSelection, TextLayoutResult layoutResult, OffsetMapping offsetMapping, androidx.compose.foundation.text.selection.TextPreparedSelectionState state) {
        super();
        this.originalText = originalText;
        this.originalSelection = originalSelection;
        this.layoutResult = offsetMapping;
        this.offsetMapping = state;
        this.state = obj8;
        this.selection = this.originalSelection;
        this.annotatedString = this.originalText;
    }

    public BaseTextPreparedSelection(AnnotatedString annotatedString, long l2, TextLayoutResult textLayoutResult3, OffsetMapping offsetMapping4, androidx.compose.foundation.text.selection.TextPreparedSelectionState textPreparedSelectionState5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(annotatedString, l2, textLayoutResult3, offsetMapping4, textPreparedSelectionState5, defaultConstructorMarker6);
    }

    public static androidx.compose.foundation.text.selection.BaseTextPreparedSelection apply$default(androidx.compose.foundation.text.selection.BaseTextPreparedSelection $this, Object $receiver, boolean resetCachedX, Function1 block, int i5, Object object6) {
        androidx.compose.foundation.text.selection.TextPreparedSelectionState state;
        int obj3;
        int obj6;
        if (object6 != null) {
        } else {
            if (i5 &= obj6 != 0) {
                obj3 = 1;
            }
            int obj5 = 0;
            if (obj3 != null) {
                $this.getState().resetCachedX();
            }
            if ((CharSequence)$this.getText$foundation_release().length() > 0) {
            } else {
                obj6 = 0;
            }
            if (obj6 != null) {
                block.invoke($receiver);
            }
            Intrinsics.checkNotNull($receiver, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
            return (BaseTextPreparedSelection)$receiver;
        }
        obj5 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
        throw obj5;
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, length--);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult $this$getLineEndByOffsetForLayout, int currentOffset) {
        return this.offsetMapping.transformedToOriginal($this$getLineEndByOffsetForLayout.getLineEnd($this$getLineEndByOffsetForLayout.getLineForOffset(currentOffset), true));
    }

    static int getLineEndByOffsetForLayout$default(androidx.compose.foundation.text.selection.BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = baseTextPreparedSelection.transformedMaxOffset();
            }
            return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        throw obj0;
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult $this$getLineStartByOffsetForLayout, int currentOffset) {
        return this.offsetMapping.transformedToOriginal($this$getLineStartByOffsetForLayout.getLineStart($this$getLineStartByOffsetForLayout.getLineForOffset(currentOffset)));
    }

    static int getLineStartByOffsetForLayout$default(androidx.compose.foundation.text.selection.BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = baseTextPreparedSelection.transformedMinOffset();
            }
            return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        throw obj0;
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult $this$getNextWordOffsetForLayout, int currentOffset) {
        long wordBoundary--jx7JFs;
        int end-impl;
        int obj6;
        while (obj6 >= this.originalText.length()) {
            wordBoundary--jx7JFs = $this$getNextWordOffsetForLayout.getWordBoundary--jx7JFs(charOffset(obj6));
            obj6++;
        }
        return this.originalText.length();
    }

    static int getNextWordOffsetForLayout$default(androidx.compose.foundation.text.selection.BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        throw obj0;
    }

    private final int getPrevWordOffset(TextLayoutResult $this$getPrevWordOffset, int currentOffset) {
        long wordBoundary--jx7JFs;
        int start-impl;
        int obj6;
        while (obj6 <= 0) {
            wordBoundary--jx7JFs = $this$getPrevWordOffset.getWordBoundary--jx7JFs(charOffset(obj6));
            obj6--;
        }
        return 0;
    }

    static int getPrevWordOffset$default(androidx.compose.foundation.text.selection.BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        throw obj0;
    }

    private final boolean isLtr() {
        ResolvedTextDirection paragraphDirection;
        int transformedEndOffset;
        int i;
        TextLayoutResult layoutResult = this.layoutResult;
        if (layoutResult != null) {
            paragraphDirection = layoutResult.getParagraphDirection(transformedEndOffset());
        } else {
            paragraphDirection = 0;
        }
        i = paragraphDirection != ResolvedTextDirection.Rtl ? 1 : 0;
        return i;
    }

    private final int jumpByLinesOffset(TextLayoutResult $this$jumpByLinesOffset, int linesAmount) {
        Object cachedX;
        Float valueOf;
        int ltr;
        final int transformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf($this$jumpByLinesOffset.getCursorRect(transformedEndOffset).getLeft()));
        }
        lineForOffset += linesAmount;
        if (i < 0) {
            return 0;
        }
        if (i >= $this$jumpByLinesOffset.getLineCount()) {
            return getText$foundation_release().length();
        }
        int i4 = 1;
        Float cachedX2 = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX2);
        float floatValue2 = (Number)cachedX2.floatValue();
        int i6 = 0;
        if (isLtr()) {
            if (Float.compare(floatValue2, lineRight) < 0 && !isLtr() && Float.compare(floatValue2, lineLeft) <= 0) {
                if (!isLtr()) {
                    if (Float.compare(floatValue2, lineLeft) <= 0) {
                    }
                }
            }
            return $this$jumpByLinesOffset.getLineEnd(i, i4);
        } else {
        }
        int i5 = 0;
        return this.offsetMapping.transformedToOriginal($this$jumpByLinesOffset.getOffsetForPosition-k-4lQ0M(OffsetKt.Offset(cachedX2.floatValue(), lineBottom -= f)));
    }

    private final T moveCursorNext() {
        int i2;
        int i3;
        int nextCharacterIndex;
        int i;
        int i4 = 1;
        final int i5 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i2 = this;
        i3 = 0;
        nextCharacterIndex = (BaseTextPreparedSelection)i2.getNextCharacterIndex();
        if (i2 != 0 && nextCharacterIndex != -1) {
            i2 = this;
            i3 = 0;
            nextCharacterIndex = (BaseTextPreparedSelection)i2.getNextCharacterIndex();
            if (nextCharacterIndex != -1) {
                i2.setCursor(nextCharacterIndex);
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    private final T moveCursorNextByWord() {
        int i3;
        int i2;
        Integer nextWordOffset;
        int i;
        int i4 = 1;
        final int i5 = 0;
        getState().resetCachedX();
        i3 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i3 = this;
        i2 = 0;
        nextWordOffset = (BaseTextPreparedSelection)i3.getNextWordOffset();
        if (i3 != 0 && nextWordOffset != null) {
            i3 = this;
            i2 = 0;
            nextWordOffset = (BaseTextPreparedSelection)i3.getNextWordOffset();
            if (nextWordOffset != null) {
                i = 0;
                i3.setCursor((Number)nextWordOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    private final T moveCursorPrev() {
        int i;
        int i2;
        int precedingCharacterIndex;
        int i3;
        int i4 = 1;
        final int i5 = 0;
        getState().resetCachedX();
        i = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i = this;
        i2 = 0;
        precedingCharacterIndex = (BaseTextPreparedSelection)i.getPrecedingCharacterIndex();
        if (i != 0 && precedingCharacterIndex != -1) {
            i = this;
            i2 = 0;
            precedingCharacterIndex = (BaseTextPreparedSelection)i.getPrecedingCharacterIndex();
            if (precedingCharacterIndex != -1) {
                i.setCursor(precedingCharacterIndex);
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    private final T moveCursorPrevByWord() {
        int i2;
        int i;
        Integer previousWordOffset;
        int i3;
        int i4 = 1;
        final int i5 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i2 = this;
        i = 0;
        previousWordOffset = (BaseTextPreparedSelection)i2.getPreviousWordOffset();
        if (i2 != 0 && previousWordOffset != null) {
            i2 = this;
            i = 0;
            previousWordOffset = (BaseTextPreparedSelection)i2.getPreviousWordOffset();
            if (previousWordOffset != null) {
                i3 = 0;
                i2.setCursor((Number)previousWordOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getMax-impl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getMin-impl(this.selection));
    }

    protected final <U> T apply(U $this$apply, boolean resetCachedX, Function1<? super U, Unit> block) {
        androidx.compose.foundation.text.selection.TextPreparedSelectionState state;
        int i;
        final int i2 = 0;
        if (resetCachedX) {
            getState().resetCachedX();
        }
        i = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i != 0) {
            block.invoke($this$apply);
        }
        Intrinsics.checkNotNull($this$apply, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)$this$apply;
    }

    public final T collapseLeftOr(Function1<? super T, Unit> or) {
        int i2;
        int i;
        int min-impl;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if (TextRange.getCollapsed-impl(i2.selection)) {
                Intrinsics.checkNotNull((BaseTextPreparedSelection)i2, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda$4");
                or.invoke(i2);
            } else {
                if (i2.isLtr()) {
                    i2.setCursor(TextRange.getMin-impl(i2.selection));
                } else {
                    i2.setCursor(TextRange.getMax-impl(i2.selection));
                }
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T collapseRightOr(Function1<? super T, Unit> or) {
        int i2;
        int i;
        int max-impl;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if (TextRange.getCollapsed-impl(i2.selection)) {
                Intrinsics.checkNotNull((BaseTextPreparedSelection)i2, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda$5");
                or.invoke(i2);
            } else {
                if (i2.isLtr()) {
                    i2.setCursor(TextRange.getMax-impl(i2.selection));
                } else {
                    i2.setCursor(TextRange.getMin-impl(i2.selection));
                }
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T deselect() {
        int i;
        int i2;
        int end-impl;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            (BaseTextPreparedSelection)i.setCursor(TextRange.getEnd-impl(i.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult lineEndByOffsetForLayout$default;
        int valueOf;
        int i2;
        int i;
        lineEndByOffsetForLayout$default = this.layoutResult;
        if (lineEndByOffsetForLayout$default != null) {
            valueOf = Integer.valueOf(BaseTextPreparedSelection.getLineEndByOffsetForLayout$default(this, lineEndByOffsetForLayout$default, 0, 1, 0));
        }
        return valueOf;
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult lineStartByOffsetForLayout$default;
        int valueOf;
        int i;
        int i2;
        lineStartByOffsetForLayout$default = this.layoutResult;
        if (lineStartByOffsetForLayout$default != null) {
            valueOf = Integer.valueOf(BaseTextPreparedSelection.getLineStartByOffsetForLayout$default(this, lineStartByOffsetForLayout$default, 0, 1, 0));
        }
        return valueOf;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult nextWordOffsetForLayout$default;
        int valueOf;
        int i;
        int i2;
        nextWordOffsetForLayout$default = this.layoutResult;
        if (nextWordOffsetForLayout$default != null) {
            valueOf = Integer.valueOf(BaseTextPreparedSelection.getNextWordOffsetForLayout$default(this, nextWordOffsetForLayout$default, 0, 1, 0));
        }
        return valueOf;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final long getOriginalSelection-d9O1mEE() {
        return this.originalSelection;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection));
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult prevWordOffset$default;
        int valueOf;
        int i2;
        int i;
        prevWordOffset$default = this.layoutResult;
        if (prevWordOffset$default != null) {
            valueOf = Integer.valueOf(BaseTextPreparedSelection.getPrevWordOffset$default(this, prevWordOffset$default, 0, 1, 0));
        }
        return valueOf;
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final androidx.compose.foundation.text.selection.TextPreparedSelectionState getState() {
        return this.state;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public final T moveCursorDownByLine() {
        int i;
        int jumpByLinesOffset;
        int i2;
        TextLayoutResult layoutResult;
        int i3 = 0;
        final Object obj = this;
        final int i4 = 0;
        jumpByLinesOffset = 1;
        i = (CharSequence)this.getText$foundation_release().length() > 0 ? jumpByLinesOffset : 0;
        i = obj;
        i2 = 0;
        layoutResult = i.layoutResult;
        if (i != 0 && layoutResult != null) {
            i = obj;
            i2 = 0;
            layoutResult = i.layoutResult;
            if (layoutResult != null) {
                layoutResult = 0;
                i.setCursor((BaseTextPreparedSelection)(BaseTextPreparedSelection)i.jumpByLinesOffset(layoutResult, jumpByLinesOffset));
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)obj;
    }

    public final T moveCursorLeft() {
        int i2;
        int i;
        boolean ltr;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if ((BaseTextPreparedSelection)i2.isLtr()) {
                i2.moveCursorPrev();
            } else {
                i2.moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorLeftByWord() {
        int i2;
        int i;
        boolean ltr;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if ((BaseTextPreparedSelection)i2.isLtr()) {
                i2.moveCursorPrevByWord();
            } else {
                i2.moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorNextByParagraph() {
        int i2;
        int i;
        int paragraphEnd;
        int text$foundation_release;
        long l;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i2 = this;
        i = 0;
        paragraphEnd = StringHelpersKt.findParagraphEnd((CharSequence)(BaseTextPreparedSelection)i2.getText$foundation_release(), TextRange.getMax-impl(i2.selection));
        if (i2 != 0 && paragraphEnd == TextRange.getMax-impl(i2.selection) && paragraphEnd != i2.getText$foundation_release().length()) {
            i2 = this;
            i = 0;
            paragraphEnd = StringHelpersKt.findParagraphEnd((CharSequence)(BaseTextPreparedSelection)i2.getText$foundation_release(), TextRange.getMax-impl(i2.selection));
            if (paragraphEnd == TextRange.getMax-impl(i2.selection)) {
                if (paragraphEnd != i2.getText$foundation_release().length()) {
                    paragraphEnd = StringHelpersKt.findParagraphEnd((CharSequence)i2.getText$foundation_release(), paragraphEnd + 1);
                }
            }
            i2.setCursor(paragraphEnd);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorPrevByParagraph() {
        int i;
        int i2;
        int paragraphStart;
        int text$foundation_release;
        long l;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i = this;
        i2 = 0;
        paragraphStart = StringHelpersKt.findParagraphStart((CharSequence)(BaseTextPreparedSelection)i.getText$foundation_release(), TextRange.getMin-impl(i.selection));
        if (i != 0 && paragraphStart == TextRange.getMin-impl(i.selection) && paragraphStart != 0) {
            i = this;
            i2 = 0;
            paragraphStart = StringHelpersKt.findParagraphStart((CharSequence)(BaseTextPreparedSelection)i.getText$foundation_release(), TextRange.getMin-impl(i.selection));
            if (paragraphStart == TextRange.getMin-impl(i.selection)) {
                if (paragraphStart != 0) {
                    paragraphStart = StringHelpersKt.findParagraphStart((CharSequence)i.getText$foundation_release(), paragraphStart + -1);
                }
            }
            i.setCursor(paragraphStart);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorRight() {
        int i2;
        int i;
        boolean ltr;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if ((BaseTextPreparedSelection)i2.isLtr()) {
                i2.moveCursorNext();
            } else {
                i2.moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorRightByWord() {
        int i;
        int i2;
        boolean ltr;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((BaseTextPreparedSelection)i.isLtr()) {
                i.moveCursorNextByWord();
            } else {
                i.moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorToEnd() {
        int i2;
        int i;
        int length;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            i2.setCursor((BaseTextPreparedSelection)i2.getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorToHome() {
        int i2;
        int i;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        final int i5 = 0;
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : i5;
        if (i2 != 0) {
            i = 0;
            (BaseTextPreparedSelection)this.setCursor(i5);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorToLineEnd() {
        int i2;
        int i;
        Integer lineEndByOffset;
        int i3;
        int i4 = 1;
        final int i5 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i2 = this;
        i = 0;
        lineEndByOffset = (BaseTextPreparedSelection)i2.getLineEndByOffset();
        if (i2 != 0 && lineEndByOffset != null) {
            i2 = this;
            i = 0;
            lineEndByOffset = (BaseTextPreparedSelection)i2.getLineEndByOffset();
            if (lineEndByOffset != null) {
                i3 = 0;
                i2.setCursor((Number)lineEndByOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorToLineLeftSide() {
        int i2;
        int i;
        boolean ltr;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            if ((BaseTextPreparedSelection)i2.isLtr()) {
                i2.moveCursorToLineStart();
            } else {
                i2.moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorToLineRightSide() {
        int i;
        int i2;
        boolean ltr;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        i = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        if (i != 0) {
            i = this;
            i2 = 0;
            if ((BaseTextPreparedSelection)i.isLtr()) {
                i.moveCursorToLineEnd();
            } else {
                i.moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorToLineStart() {
        int i2;
        int i;
        Integer lineStartByOffset;
        int i3;
        int i4 = 1;
        final int i5 = 0;
        getState().resetCachedX();
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : 0;
        i2 = this;
        i = 0;
        lineStartByOffset = (BaseTextPreparedSelection)i2.getLineStartByOffset();
        if (i2 != 0 && lineStartByOffset != null) {
            i2 = this;
            i = 0;
            lineStartByOffset = (BaseTextPreparedSelection)i2.getLineStartByOffset();
            if (lineStartByOffset != null) {
                i3 = 0;
                i2.setCursor((Number)lineStartByOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T moveCursorUpByLine() {
        int i2;
        int i3;
        TextLayoutResult jumpByLinesOffset;
        int i;
        int i4 = 0;
        final Object obj = this;
        final int i5 = 0;
        i2 = (CharSequence)this.getText$foundation_release().length() > 0 ? 1 : 0;
        i2 = obj;
        i3 = 0;
        jumpByLinesOffset = i2.layoutResult;
        if (i2 != 0 && jumpByLinesOffset != null) {
            i2 = obj;
            i3 = 0;
            jumpByLinesOffset = i2.layoutResult;
            if (jumpByLinesOffset != null) {
                i = 0;
                i2.setCursor((BaseTextPreparedSelection)(BaseTextPreparedSelection)i2.jumpByLinesOffset(jumpByLinesOffset, -1));
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)obj;
    }

    public final T selectAll() {
        int i2;
        int i;
        int length;
        int i3 = 1;
        final int i4 = 0;
        getState().resetCachedX();
        final int i5 = 0;
        i2 = (CharSequence)getText$foundation_release().length() > 0 ? 1 : i5;
        if (i2 != 0) {
            i2 = this;
            i = 0;
            i2.setSelection(i5, (BaseTextPreparedSelection)i2.getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)this;
    }

    public final T selectMovement() {
        int i2;
        int i;
        long l;
        long end-impl;
        int i3 = 0;
        final Object obj = this;
        final int i4 = 0;
        i2 = (CharSequence)this.getText$foundation_release().length() > 0 ? 1 : 0;
        if (i2 != 0) {
            i2 = obj;
            i = 0;
            i2.selection = TextRangeKt.TextRange(TextRange.getStart-impl(i2.originalSelection), TextRange.getEnd-impl(i2.selection));
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection)obj;
    }

    public final void setAnnotatedString(AnnotatedString <set-?>) {
        this.annotatedString = <set-?>;
    }

    protected final void setCursor(int offset) {
        setSelection(offset, offset);
    }

    protected final void setSelection(int start, int end) {
        this.selection = TextRangeKt.TextRange(start, end);
    }

    public final void setSelection-5zc-tL8(long <set-?>) {
        this.selection = <set-?>;
    }
}
