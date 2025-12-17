package androidx.compose.foundation.text.input.internal;

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
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002\u001ax\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CursorAnchorInfoBuilder_androidKt {
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder $this$addCharacterBounds, int startOffset, int endOffset, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds) {
        int i;
        long l;
        int flags;
        int offset;
        int left;
        boolean inclusive;
        float top;
        float bottom;
        float right;
        float bottom2;
        int i2;
        Rect rect;
        float[] fArr = new float[i3 *= 4];
        textLayoutResult.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(startOffset, endOffset), obj3, fArr);
        offset = i;
        while (offset < endOffset) {
            i5 *= 4;
            Rect rect2 = new Rect(fArr[i], fArr[i + 1], fArr[i + 2], fArr[i + 3]);
            rect = rect2;
            if (innerTextFieldBounds.overlaps(rect)) {
            }
            if (LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(innerTextFieldBounds, rect.getLeft(), rect.getTop())) {
            } else {
            }
            flags |= 2;
            if (textLayoutResult.getBidiRunDirection(offset) == ResolvedTextDirection.Rtl) {
            } else {
            }
            i2 = flags;
            $this$addCharacterBounds.addCharacterBounds(offset, rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), i2);
            offset++;
            i2 = flags;
            if (!LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(innerTextFieldBounds, rect.getRight(), rect.getBottom())) {
            }
            flags |= 1;
        }
        return $this$addCharacterBounds;
    }

    public static final CursorAnchorInfo build-vxqZcH0(CursorAnchorInfo.Builder $this$build_u2dvxqZcH0, java.lang.CharSequence text, long selection, TextRange composition, TextLayoutResult textLayoutResult, Matrix matrix, Rect innerTextFieldBounds, Rect decorationBoxBounds, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        int max-impl;
        int min-impl;
        long subSequence;
        $this$build_u2dvxqZcH0.reset();
        $this$build_u2dvxqZcH0.setMatrix(innerTextFieldBounds);
        final int min-impl2 = TextRange.getMin-impl(selection);
        $this$build_u2dvxqZcH0.setSelectionRange(min-impl2, TextRange.getMax-impl(selection));
        if (includeCharacterBounds) {
            CursorAnchorInfoBuilder_androidKt.setInsertionMarker($this$build_u2dvxqZcH0, min-impl2, matrix, decorationBoxBounds);
        }
        if (includeEditorBounds) {
            if (textLayoutResult != null) {
                min-impl = TextRange.getMin-impl(textLayoutResult.unbox-impl());
            } else {
                min-impl = max-impl;
            }
            if (textLayoutResult != null) {
                max-impl = TextRange.getMax-impl(textLayoutResult.unbox-impl());
            }
            subSequence = 0;
            if (min-impl >= 0 && min-impl < max-impl) {
                if (min-impl < max-impl) {
                    subSequence = 1;
                }
            }
            if (subSequence != 0) {
                $this$build_u2dvxqZcH0.setComposingText(min-impl, text.subSequence(min-impl, max-impl));
                CursorAnchorInfoBuilder_androidKt.addCharacterBounds($this$build_u2dvxqZcH0, min-impl, max-impl, matrix, decorationBoxBounds);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && includeLineBounds) {
            if (includeLineBounds) {
                CursorAnchorInfoApi33Helper.setEditorBoundsInfo($this$build_u2dvxqZcH0, includeInsertionMarker);
            }
        }
        if (Build.VERSION.SDK_INT >= 34 && obj18 != null) {
            if (obj18 != null) {
                CursorAnchorInfoApi34Helper.addVisibleLineBounds($this$build_u2dvxqZcH0, matrix, decorationBoxBounds);
            }
        }
        return $this$build_u2dvxqZcH0.build();
    }

    public static CursorAnchorInfo build-vxqZcH0$default(CursorAnchorInfo.Builder cursorAnchorInfo$Builder, java.lang.CharSequence charSequence2, long l3, TextRange textRange4, TextLayoutResult textLayoutResult5, Matrix matrix6, Rect rect7, Rect rect8, boolean z9, boolean z10, boolean z11, boolean z12, int i13, Object object14) {
        int obj10;
        int obj11;
        int obj12;
        int obj13;
        final int i = 1;
        if (object14 & 128 != 0) {
            obj10 = i;
        }
        if (object14 & 256 != 0) {
            obj11 = i;
        }
        if (object14 & 512 != 0) {
            obj12 = i;
        }
        if (object14 &= 1024 != 0) {
            obj13 = i;
        }
        return CursorAnchorInfoBuilder_androidKt.build-vxqZcH0(builder, charSequence2, l3, textRange4, textLayoutResult5, matrix6, rect7, rect8, z9, obj10, obj11, obj12);
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder $this$setInsertionMarker, int selectionStart, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds) {
        int i;
        int flags;
        if (selectionStart < 0) {
            return $this$setInsertionMarker;
        }
        final Rect cursorRect = textLayoutResult.getCursorRect(selectionStart);
        final float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0, (float)width-impl);
        boolean inclusive = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(innerTextFieldBounds, coerceIn, cursorRect.getTop());
        boolean inclusive2 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(innerTextFieldBounds, coerceIn, cursorRect.getBottom());
        i = textLayoutResult.getBidiRunDirection(selectionStart) == ResolvedTextDirection.Rtl ? 1 : 0;
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
