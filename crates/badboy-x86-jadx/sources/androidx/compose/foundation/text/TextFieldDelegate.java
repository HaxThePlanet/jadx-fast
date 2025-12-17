package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Builder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate;", "", "()V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDelegate {

    public static final int $stable;
    public static final androidx.compose.foundation.text.TextFieldDelegate.Companion Companion;

    @Metadata(d1 = "\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\tJR\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ:\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 JH\u0010!\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00150\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\n\u0008\u0002\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,JE\u0010-\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00084J1\u00105\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b09H\u0001¢\u0006\u0002\u0008:JA\u0010;\u001a\u00020\u000b2\u000c\u0010<\u001a\u0008\u0012\u0004\u0012\u00020>0=2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b092\u0008\u0010?\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\u0008@JU\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020C2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b092\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000b09H\u0001¢\u0006\u0002\u0008HJU\u0010I\u001a\u0002012\u0006\u0010B\u001a\u00020C2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b092\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000b09H\u0001¢\u0006\u0002\u0008JJF\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020M2\u0006\u0010\u0014\u001a\u00020N2\u0006\u00106\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b09H\u0001ø\u0001\u0000¢\u0006\u0004\u0008O\u0010PJ-\u0010Q\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u0010R\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020NH\u0001¢\u0006\u0002\u0008S\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006T", d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate$Companion;", "", "()V", "applyCompositionDecoration", "Landroidx/compose/ui/text/input/TransformedText;", "compositionRange", "Landroidx/compose/ui/text/TextRange;", "transformed", "applyCompositionDecoration-72CqOWE", "(JLandroidx/compose/ui/text/input/TransformedText;)Landroidx/compose/ui/text/input/TransformedText;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "selectionPreviewHighlightRange", "deletionPreviewHighlightRange", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "draw-Q1vqE60$foundation_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/text/input/TextFieldValue;JJLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;J)V", "drawHighlight", "range", "paint", "drawHighlight-Le-punE", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;)V", "layout", "Lkotlin/Triple;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevResultText", "layout-_EkL_-Y$foundation_release", "(Landroidx/compose/foundation/text/TextDelegate;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Lkotlin/Triple;", "notifyFocusedRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "hasFocus", "", "notifyFocusedRect$foundation_release", "onBlur", "editProcessor", "Landroidx/compose/ui/text/input/EditProcessor;", "onValueChange", "Lkotlin/Function1;", "onBlur$foundation_release", "onEditCommand", "ops", "", "Landroidx/compose/ui/text/input/EditCommand;", "session", "onEditCommand$foundation_release", "onFocus", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "onFocus$foundation_release", "restartInput", "restartInput$foundation_release", "setCursorOffset", "position", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setCursorOffset-ULxng0E$foundation_release", "(JLandroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/ui/text/input/EditProcessor;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/jvm/functions/Function1;)V", "updateTextLayoutResult", "textFieldValue", "updateTextLayoutResult$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final void drawHighlight-Le-punE(Canvas canvas, long range, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint) {
            androidx.compose.ui.graphics.Path pathForRange;
            int originalToTransformed = textLayoutResult.originalToTransformed(TextRange.getMin-impl(range));
            int originalToTransformed2 = textLayoutResult.originalToTransformed(TextRange.getMax-impl(range));
            if (originalToTransformed != originalToTransformed2) {
                canvas.drawPath(paint.getPathForRange(originalToTransformed, originalToTransformed2), obj9);
            }
        }

        public static Triple layout-_EkL_-Y$foundation_release$default(androidx.compose.foundation.text.TextFieldDelegate.Companion textFieldDelegate$Companion, androidx.compose.foundation.text.TextDelegate textDelegate2, long l3, LayoutDirection layoutDirection4, TextLayoutResult textLayoutResult5, int i6, Object object7) {
            int i;
            int obj11;
            i = object7 &= 8 != 0 ? obj11 : i6;
            return companion.layout-_EkL_-Y$foundation_release(textDelegate2, l3, obj3, textLayoutResult5);
        }

        public final TransformedText applyCompositionDecoration-72CqOWE(long compositionRange, TransformedText transformed) {
            int originalToTransformed = obj33.getOffsetMapping().originalToTransformed(TextRange.getStart-impl(compositionRange));
            int originalToTransformed2 = obj33.getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(compositionRange));
            AnnotatedString.Builder builder = new AnnotatedString.Builder(obj33.getText());
            int i3 = 0;
            SpanStyle spanStyle = new SpanStyle(0, obj9, 0, obj11, 0, 0, 0, 0, 0, 0, obj18, 0, 0, 0, 0, obj23, TextDecoration.Companion.getUnderline(), 0, 0, 0, 61439, 0);
            builder.addStyle(spanStyle, Math.min(originalToTransformed, originalToTransformed2), Math.max(originalToTransformed, originalToTransformed2));
            TransformedText transformedText = new TransformedText(builder.toAnnotatedString(), obj33.getOffsetMapping());
            return transformedText;
        }

        @JvmStatic
        public final void draw-Q1vqE60$foundation_release(Canvas canvas, TextFieldValue value, long selectionPreviewHighlightRange, long deletionPreviewHighlightRange, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint highlightPaint, long selectionBackgroundColor) {
            boolean copy-wmQWz5c$default;
            Color box-impl;
            long black-0d7_KjU;
            long l2;
            Canvas canvas2;
            long selection-d9O1mEE;
            OffsetMapping map;
            TextLayoutResult textLayoutResult2;
            Paint paint;
            Object obj;
            int i;
            long l;
            int i2;
            if (!TextRange.getCollapsed-impl(selectionPreviewHighlightRange)) {
                obj19.setColor-8_81llA(obj20);
                this.drawHighlight-Le-punE(canvas, selectionPreviewHighlightRange, obj4, highlightPaint, selectionBackgroundColor);
            } else {
                if (!TextRange.getCollapsed-impl(offsetMapping)) {
                    int i4 = 0;
                    int i6 = 0;
                    i = Long.compare(l4, i8) == 0 ? 1 : 0;
                    if (i == 0) {
                    } else {
                        box-impl = 0;
                    }
                    if (box-impl != null) {
                        black-0d7_KjU = box-impl.unbox-impl();
                    } else {
                        black-0d7_KjU = Color.Companion.getBlack-0d7_KjU();
                    }
                    long l3 = black-0d7_KjU;
                    int i3 = 1045220557;
                    map = alpha-impl * i3;
                    obj = obj19;
                    l = l3;
                    obj.setColor-8_81llA(Color.copy-wmQWz5c$default(l3, i4, map, 0, 0, 0, 14));
                    this.drawHighlight-Le-punE(canvas, offsetMapping, map, highlightPaint, selectionBackgroundColor);
                } else {
                    if (!TextRange.getCollapsed-impl(value.getSelection-d9O1mEE())) {
                        obj19.setColor-8_81llA(obj20);
                        this.drawHighlight-Le-punE(canvas, value.getSelection-d9O1mEE(), obj4, highlightPaint, selectionBackgroundColor);
                    }
                }
            }
            TextPainter.INSTANCE.paint(canvas, selectionBackgroundColor);
        }

        @JvmStatic
        public final Triple<Integer, Integer, TextLayoutResult> layout-_EkL_-Y$foundation_release(androidx.compose.foundation.text.TextDelegate textDelegate, long constraints, LayoutDirection layoutDirection, TextLayoutResult prevResultText) {
            final TextLayoutResult layout-NN6Ew-U = textDelegate.layout-NN6Ew-U(constraints, layoutDirection, prevResultText);
            Triple triple = new Triple(Integer.valueOf(IntSize.getWidth-impl(layout-NN6Ew-U.getSize-YbymL2g())), Integer.valueOf(IntSize.getHeight-impl(layout-NN6Ew-U.getSize-YbymL2g())), layout-NN6Ew-U);
            return triple;
        }

        @JvmStatic
        public final void notifyFocusedRect$foundation_release(TextFieldValue value, androidx.compose.foundation.text.TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean hasFocus, OffsetMapping offsetMapping) {
            Rect defaultSize;
            TextStyle style;
            Rect rect;
            float f;
            int i4;
            int i;
            int i2;
            int i3;
            if (!hasFocus) {
            }
            int originalToTransformed = offsetMapping.originalToTransformed(TextRange.getMax-impl(value.getSelection-d9O1mEE()));
            if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
                defaultSize = textLayoutResult.getBoundingBox(originalToTransformed);
            } else {
                if (originalToTransformed != 0) {
                    defaultSize = textLayoutResult.getBoundingBox(originalToTransformed + -1);
                } else {
                    style = textDelegate.getStyle();
                    i4 = 0;
                    rect = new Rect(i4, i4, 1065353216, (float)height-impl);
                    defaultSize = rect;
                }
            }
            float top = defaultSize.getTop();
            long localToRoot-MK-Hz9U = layoutCoordinates.localToRoot-MK-Hz9U(OffsetKt.Offset(defaultSize.getLeft(), top));
            float y-impl = Offset.getY-impl(localToRoot-MK-Hz9U);
            float height = defaultSize.getHeight();
            textInputSession.notifyFocusedRect(RectKt.Rect-tz77jQw(OffsetKt.Offset(Offset.getX-impl(localToRoot-MK-Hz9U), y-impl), y-impl));
        }

        @JvmStatic
        public final void onBlur$foundation_release(TextInputSession textInputSession, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> onValueChange) {
            onValueChange.invoke(TextFieldValue.copy-3r_uNRQ$default(editProcessor.toTextFieldValue(), 0, 0, obj3, 0, 3));
            textInputSession.dispose();
        }

        @JvmStatic
        public final void onEditCommand$foundation_release(List<? extends EditCommand> ops, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> onValueChange, TextInputSession session) {
            int i;
            final TextFieldValue apply = editProcessor.apply(ops);
            if (session != null) {
                session.updateState(0, apply);
            }
            onValueChange.invoke(apply);
        }

        @JvmStatic
        public final TextInputSession onFocus$foundation_release(TextInputService textInputService, TextFieldValue value, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> onValueChange, Function1<? super ImeAction, Unit> onImeActionPerformed) {
            return restartInput$foundation_release(textInputService, value, editProcessor, imeOptions, onValueChange, onImeActionPerformed);
        }

        @JvmStatic
        public final TextInputSession restartInput$foundation_release(TextInputService textInputService, TextFieldValue value, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> onValueChange, Function1<? super ImeAction, Unit> onImeActionPerformed) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TextFieldDelegate.Companion.restartInput.1 anon = new TextFieldDelegate.Companion.restartInput.1(editProcessor, onValueChange, objectRef);
            objectRef.element = textInputService.startInput(value, imeOptions, (Function1)anon, onImeActionPerformed);
            return (TextInputSession)objectRef.element;
        }

        @JvmStatic
        public final void setCursorOffset-ULxng0E$foundation_release(long position, androidx.compose.foundation.text.TextLayoutResultProxy textLayoutResult, EditProcessor editProcessor, OffsetMapping offsetMapping, Function1<? super TextFieldValue, Unit> onValueChange) {
            final int i3 = 2;
            final int i4 = 0;
            obj14.invoke(TextFieldValue.copy-3r_uNRQ$default(offsetMapping.toTextFieldValue(), 0, TextRangeKt.TextRange(onValueChange.transformedToOriginal(TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(editProcessor, position, obj2, 0, i3))), i3, i4, 5));
        }

        @JvmStatic
        public final void updateTextLayoutResult$foundation_release(TextInputSession textInputSession, TextFieldValue textFieldValue, OffsetMapping offsetMapping, androidx.compose.foundation.text.TextLayoutResultProxy textLayoutResult) {
            int i;
            LayoutCoordinates decorationBoxCoordinates;
            int i2;
            Object textInputSession2;
            TextFieldValue field2;
            OffsetMapping map;
            TextLayoutResult value;
            androidx.compose.foundation.text.TextFieldDelegate.Companion.updateTextLayoutResult.1.1.1 field;
            Rect visibleBounds;
            Rect localBoundingBoxOf;
            final LayoutCoordinates innerTextFieldCoordinates = textLayoutResult.getInnerTextFieldCoordinates();
            if (innerTextFieldCoordinates != null) {
                i = 0;
                if (!innerTextFieldCoordinates.isAttached()) {
                }
                decorationBoxCoordinates = textLayoutResult.getDecorationBoxCoordinates();
                if (decorationBoxCoordinates != null) {
                    i2 = 0;
                    TextFieldDelegate.Companion.updateTextLayoutResult.1.1.1 anon = new TextFieldDelegate.Companion.updateTextLayoutResult.1.1.1(innerTextFieldCoordinates);
                    textInputSession.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult.getValue(), (Function1)anon, SelectionManagerKt.visibleBounds(innerTextFieldCoordinates), innerTextFieldCoordinates.localBoundingBoxOf(decorationBoxCoordinates, false));
                } else {
                    textInputSession2 = textInputSession;
                    field2 = textFieldValue;
                    map = offsetMapping;
                }
            } else {
                textInputSession2 = textInputSession;
                field2 = textFieldValue;
                map = offsetMapping;
            }
        }
    }
    static {
        TextFieldDelegate.Companion companion = new TextFieldDelegate.Companion(0);
        TextFieldDelegate.Companion = companion;
    }

    @JvmStatic
    public static final void draw-Q1vqE60$foundation_release(Canvas canvas, TextFieldValue textFieldValue2, long l3, long l4, OffsetMapping offsetMapping5, TextLayoutResult textLayoutResult6, Paint paint7, long l8) {
        TextFieldDelegate.Companion.draw-Q1vqE60$foundation_release(canvas, textFieldValue2, l3, obj4, offsetMapping5, obj6, paint7, l8);
    }

    @JvmStatic
    public static final Triple<Integer, Integer, TextLayoutResult> layout-_EkL_-Y$foundation_release(androidx.compose.foundation.text.TextDelegate textDelegate, long l2, LayoutDirection layoutDirection3, TextLayoutResult textLayoutResult4) {
        return TextFieldDelegate.Companion.layout-_EkL_-Y$foundation_release(textDelegate, l2, obj3, textLayoutResult4);
    }

    @JvmStatic
    public static final void notifyFocusedRect$foundation_release(TextFieldValue textFieldValue, androidx.compose.foundation.text.TextDelegate textDelegate2, TextLayoutResult textLayoutResult3, LayoutCoordinates layoutCoordinates4, TextInputSession textInputSession5, boolean z6, OffsetMapping offsetMapping7) {
        TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(textFieldValue, textDelegate2, textLayoutResult3, layoutCoordinates4, textInputSession5, z6, offsetMapping7);
    }

    @JvmStatic
    public static final void onBlur$foundation_release(TextInputSession textInputSession, EditProcessor editProcessor2, Function1<? super TextFieldValue, Unit> function13) {
        TextFieldDelegate.Companion.onBlur$foundation_release(textInputSession, editProcessor2, function13);
    }

    @JvmStatic
    public static final void onEditCommand$foundation_release(List<? extends EditCommand> list, EditProcessor editProcessor2, Function1<? super TextFieldValue, Unit> function13, TextInputSession textInputSession4) {
        TextFieldDelegate.Companion.onEditCommand$foundation_release(list, editProcessor2, function13, textInputSession4);
    }

    @JvmStatic
    public static final TextInputSession onFocus$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue2, EditProcessor editProcessor3, ImeOptions imeOptions4, Function1<? super TextFieldValue, Unit> function15, Function1<? super ImeAction, Unit> function16) {
        return TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue2, editProcessor3, imeOptions4, function15, function16);
    }

    @JvmStatic
    public static final TextInputSession restartInput$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue2, EditProcessor editProcessor3, ImeOptions imeOptions4, Function1<? super TextFieldValue, Unit> function15, Function1<? super ImeAction, Unit> function16) {
        return TextFieldDelegate.Companion.restartInput$foundation_release(textInputService, textFieldValue2, editProcessor3, imeOptions4, function15, function16);
    }

    @JvmStatic
    public static final void setCursorOffset-ULxng0E$foundation_release(long l, androidx.compose.foundation.text.TextLayoutResultProxy textLayoutResultProxy2, EditProcessor editProcessor3, OffsetMapping offsetMapping4, Function1<? super TextFieldValue, Unit> function15) {
        TextFieldDelegate.Companion.setCursorOffset-ULxng0E$foundation_release(l, obj2, editProcessor3, offsetMapping4, function15);
    }

    @JvmStatic
    public static final void updateTextLayoutResult$foundation_release(TextInputSession textInputSession, TextFieldValue textFieldValue2, OffsetMapping offsetMapping3, androidx.compose.foundation.text.TextLayoutResultProxy textLayoutResultProxy4) {
        TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(textInputSession, textFieldValue2, offsetMapping3, textLayoutResultProxy4);
    }
}
