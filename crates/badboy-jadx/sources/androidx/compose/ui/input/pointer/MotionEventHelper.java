package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"Landroidx/compose/ui/input/pointer/MotionEventHelper;", "", "()V", "toRawOffset", "Landroidx/compose/ui/geometry/Offset;", "motionEvent", "Landroid/view/MotionEvent;", "index", "", "toRawOffset-dBAh8RU", "(Landroid/view/MotionEvent;I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MotionEventHelper {

    public static final androidx.compose.ui.input.pointer.MotionEventHelper INSTANCE;
    static {
        MotionEventHelper motionEventHelper = new MotionEventHelper();
        MotionEventHelper.INSTANCE = motionEventHelper;
    }

    public final long toRawOffset-dBAh8RU(MotionEvent motionEvent, int index) {
        return OffsetKt.Offset(motionEvent.getRawX(index), motionEvent.getRawY(index));
    }
}
