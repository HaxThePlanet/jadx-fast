package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.EditorBoundsInfo.Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoApi33Helper;", "", "()V", "setEditorBoundsInfo", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CursorAnchorInfoApi33Helper {

    public static final androidx.compose.ui.text.input.CursorAnchorInfoApi33Helper INSTANCE;
    static {
        CursorAnchorInfoApi33Helper cursorAnchorInfoApi33Helper = new CursorAnchorInfoApi33Helper();
        CursorAnchorInfoApi33Helper.INSTANCE = cursorAnchorInfoApi33Helper;
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder setEditorBoundsInfo(CursorAnchorInfo.Builder builder, Rect decorationBoxBounds) {
        EditorBoundsInfo.Builder builder2 = new EditorBoundsInfo.Builder();
        return builder.setEditorBoundsInfo(builder2.setEditorBounds(RectHelper_androidKt.toAndroidRectF(decorationBoxBounds)).setHandwritingBounds(RectHelper_androidKt.toAndroidRectF(decorationBoxBounds)).build());
    }
}
