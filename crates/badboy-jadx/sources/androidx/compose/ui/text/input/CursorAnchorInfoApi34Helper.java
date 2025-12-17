package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo.Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007¨\u0006\n", d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoApi34Helper;", "", "()V", "addVisibleLineBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CursorAnchorInfoApi34Helper {

    public static final androidx.compose.ui.text.input.CursorAnchorInfoApi34Helper INSTANCE;
    static {
        CursorAnchorInfoApi34Helper cursorAnchorInfoApi34Helper = new CursorAnchorInfoApi34Helper();
        CursorAnchorInfoApi34Helper.INSTANCE = cursorAnchorInfoApi34Helper;
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder addVisibleLineBounds(CursorAnchorInfo.Builder builder, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds) {
        boolean lineForVerticalPosition;
        int lineForVerticalPosition2;
        int index;
        float lineLeft;
        float lineTop;
        float lineRight;
        float lineBottom;
        lineForVerticalPosition2 = textLayoutResult.getLineForVerticalPosition(innerTextFieldBounds.getBottom());
        if (!innerTextFieldBounds.isEmpty() && textLayoutResult.getLineForVerticalPosition(innerTextFieldBounds.getTop()) <= lineForVerticalPosition2) {
            lineForVerticalPosition2 = textLayoutResult.getLineForVerticalPosition(innerTextFieldBounds.getBottom());
            if (textLayoutResult.getLineForVerticalPosition(innerTextFieldBounds.getTop()) <= lineForVerticalPosition2) {
            }
        }
        return builder;
    }
}
