package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002\u001ad\u0010\u000b\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0013H\u0001\u001a\u001c\u0010\u0017\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a,\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u001d", d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "containsInclusive", "x", "", "y", "setInsertionMarker", "selectionStart", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CursorAnchorInfoBuilder_androidKt {
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder $this$addCharacterBounds, int startOffset, int endOffset, androidx.compose.ui.text.input.OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds) {
        int originalToTransformed;
        long rect2;
        int offset;
        int left;
        int flags;
        float top;
        boolean inclusive;
        float right;
        float bottom2;
        float bottom;
        int i2;
        int i;
        Rect rect;
        final int i3 = endOffset;
        final Object obj = offsetMapping;
        final Rect rect3 = innerTextFieldBounds;
        final int originalToTransformed2 = obj.originalToTransformed(startOffset);
        final int originalToTransformed3 = obj.originalToTransformed(i3);
        float[] fArr = new float[i5 *= 4];
        textLayoutResult.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(originalToTransformed2, originalToTransformed3), obj9, fArr);
        offset = originalToTransformed;
        while (offset < i3) {
            originalToTransformed = obj.originalToTransformed(offset);
            i = i7 * 4;
            Rect rect4 = new Rect(fArr[i], fArr[i + 1], fArr[i + 2], fArr[i + 3]);
            if (rect3.overlaps(rect4)) {
            }
            if (CursorAnchorInfoBuilder_androidKt.containsInclusive(rect3, rect4.getLeft(), rect4.getTop())) {
            } else {
            }
            flags |= 2;
            if (textLayoutResult.getBidiRunDirection(originalToTransformed) == ResolvedTextDirection.Rtl) {
            } else {
            }
            i2 = flags;
            rect = rect4;
            $this$addCharacterBounds.addCharacterBounds(offset, rect4.getLeft(), rect4.getTop(), rect4.getRight(), rect4.getBottom(), i2);
            offset++;
            i2 = flags;
            if (!CursorAnchorInfoBuilder_androidKt.containsInclusive(rect3, rect4.getRight(), rect4.getBottom())) {
            }
            flags |= 1;
        }
        return $this$addCharacterBounds;
    }

    @Deprecated(message = "Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this function in foundation is used by the legacy BasicTextField.")
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder $this$build, androidx.compose.ui.text.input.TextFieldValue textFieldValue, androidx.compose.ui.text.input.OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect innerTextFieldBounds, Rect decorationBoxBounds, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        int min-impl;
        TextRange composition-MzsxiRA;
        int subSequence;
        Rect rect;
        int max-impl;
        long unbox-impl;
        long i2;
        int i;
        androidx.compose.ui.text.input.OffsetMapping map;
        TextLayoutResult textLayoutResult2;
        Rect rect2;
        $this$build.reset();
        $this$build.setMatrix(matrix);
        int min-impl2 = TextRange.getMin-impl(textFieldValue.getSelection-d9O1mEE());
        $this$build.setSelectionRange(min-impl2, TextRange.getMax-impl(textFieldValue.getSelection-d9O1mEE()));
        if (includeInsertionMarker) {
            CursorAnchorInfoBuilder_androidKt.setInsertionMarker($this$build, min-impl2, offsetMapping, textLayoutResult, innerTextFieldBounds);
        }
        if (includeCharacterBounds) {
            TextRange composition-MzsxiRA2 = textFieldValue.getComposition-MzsxiRA();
            max-impl = -1;
            if (composition-MzsxiRA2 != null) {
                min-impl = TextRange.getMin-impl(composition-MzsxiRA2.unbox-impl());
            } else {
                min-impl = max-impl;
            }
            i2 = min-impl;
            composition-MzsxiRA = textFieldValue.getComposition-MzsxiRA();
            if (composition-MzsxiRA != null) {
                max-impl = TextRange.getMax-impl(composition-MzsxiRA.unbox-impl());
            }
            i = max-impl;
            subSequence = 0;
            if (i2 >= 0 && i2 < i) {
                if (i2 < i) {
                    subSequence = 1;
                }
            }
            if (subSequence != 0) {
                $this$build.setComposingText(i2, textFieldValue.getText().subSequence(i2, i));
                CursorAnchorInfoBuilder_androidKt.addCharacterBounds($this$build, i2, i, offsetMapping, textLayoutResult, innerTextFieldBounds);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && includeEditorBounds) {
            if (includeEditorBounds) {
                CursorAnchorInfoApi33Helper.setEditorBoundsInfo($this$build, decorationBoxBounds);
            } else {
                rect = decorationBoxBounds;
            }
        } else {
        }
        if (Build.VERSION.SDK_INT >= 34 && includeLineBounds) {
            if (includeLineBounds) {
                CursorAnchorInfoApi34Helper.addVisibleLineBounds($this$build, textLayoutResult, innerTextFieldBounds);
            }
        }
        return $this$build.build();
    }

    public static CursorAnchorInfo build$default(CursorAnchorInfo.Builder cursorAnchorInfo$Builder, androidx.compose.ui.text.input.TextFieldValue textFieldValue2, androidx.compose.ui.text.input.OffsetMapping offsetMapping3, TextLayoutResult textLayoutResult4, Matrix matrix5, Rect rect6, Rect rect7, boolean z8, boolean z9, boolean z10, boolean z11, int i12, Object object13) {
        int obj8;
        int obj9;
        int obj10;
        int obj11;
        final int i = 1;
        if (i12 & 64 != 0) {
            obj8 = i;
        }
        if (i12 & 128 != 0) {
            obj9 = i;
        }
        if (i12 & 256 != 0) {
            obj10 = i;
        }
        if (i12 &= 512 != 0) {
            obj11 = i;
        }
        return CursorAnchorInfoBuilder_androidKt.build(builder, textFieldValue2, offsetMapping3, textLayoutResult4, matrix5, rect6, rect7, obj8, obj9, obj10, obj11);
    }

    private static final boolean containsInclusive(Rect $this$containsInclusive, float x, float y) {
        float left;
        int i2;
        float top;
        int cmp;
        int i;
        i = 1;
        final int i3 = 0;
        if (Float.compare(x, right) <= 0 && Float.compare(left, x) <= 0) {
            i2 = Float.compare(left, x) <= 0 ? i : i3;
        } else {
        }
        if (i2 != 0) {
            if (Float.compare(y, bottom) <= 0 && Float.compare(top, y) <= 0) {
                i2 = Float.compare(top, y) <= 0 ? i : i3;
            } else {
            }
            if (i2 != 0) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder $this$setInsertionMarker, int selectionStart, androidx.compose.ui.text.input.OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds) {
        int i;
        int flags;
        if (selectionStart < 0) {
            return $this$setInsertionMarker;
        }
        final int originalToTransformed = offsetMapping.originalToTransformed(selectionStart);
        final Rect cursorRect = textLayoutResult.getCursorRect(originalToTransformed);
        final float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0, (float)width-impl);
        boolean inclusive = CursorAnchorInfoBuilder_androidKt.containsInclusive(innerTextFieldBounds, coerceIn, cursorRect.getTop());
        boolean inclusive2 = CursorAnchorInfoBuilder_androidKt.containsInclusive(innerTextFieldBounds, coerceIn, cursorRect.getBottom());
        i = textLayoutResult.getBidiRunDirection(originalToTransformed) == ResolvedTextDirection.Rtl ? 1 : 0;
        if (!inclusive) {
            if (inclusive2) {
                flags |= 1;
            }
        } else {
        }
        if (inclusive) {
            if (!inclusive2) {
                flags |= 2;
            }
        } else {
        }
        if (i != 0) {
            flags |= 4;
        }
        Object obj = $this$setInsertionMarker;
        obj.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), flags);
        return obj;
    }
}
