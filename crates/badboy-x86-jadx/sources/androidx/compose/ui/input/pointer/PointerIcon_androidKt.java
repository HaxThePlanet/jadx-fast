package androidx.compose.ui.input.pointer;

import android.view.PointerIcon;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000c\u001a\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0003\"\u0014\u0010\u0008\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0003¨\u0006\u000f", d2 = {"pointerIconCrosshair", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getPointerIconCrosshair", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "pointerIconDefault", "getPointerIconDefault", "pointerIconHand", "getPointerIconHand", "pointerIconText", "getPointerIconText", "PointerIcon", "pointerIcon", "Landroid/view/PointerIcon;", "pointerIconType", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerIcon_androidKt {

    private static final androidx.compose.ui.input.pointer.PointerIcon pointerIconCrosshair;
    private static final androidx.compose.ui.input.pointer.PointerIcon pointerIconDefault;
    private static final androidx.compose.ui.input.pointer.PointerIcon pointerIconHand;
    private static final androidx.compose.ui.input.pointer.PointerIcon pointerIconText;
    static {
        AndroidPointerIconType androidPointerIconType = new AndroidPointerIconType(1000);
        PointerIcon_androidKt.pointerIconDefault = (PointerIcon)androidPointerIconType;
        AndroidPointerIconType androidPointerIconType2 = new AndroidPointerIconType(1007);
        PointerIcon_androidKt.pointerIconCrosshair = (PointerIcon)androidPointerIconType2;
        AndroidPointerIconType androidPointerIconType3 = new AndroidPointerIconType(1008);
        PointerIcon_androidKt.pointerIconText = (PointerIcon)androidPointerIconType3;
        AndroidPointerIconType androidPointerIconType4 = new AndroidPointerIconType(1002);
        PointerIcon_androidKt.pointerIconHand = (PointerIcon)androidPointerIconType4;
    }

    public static final androidx.compose.ui.input.pointer.PointerIcon PointerIcon(int pointerIconType) {
        AndroidPointerIconType androidPointerIconType = new AndroidPointerIconType(pointerIconType);
        return (PointerIcon)androidPointerIconType;
    }

    public static final androidx.compose.ui.input.pointer.PointerIcon PointerIcon(PointerIcon pointerIcon) {
        AndroidPointerIcon androidPointerIcon = new AndroidPointerIcon(pointerIcon);
        return (PointerIcon)androidPointerIcon;
    }

    public static final androidx.compose.ui.input.pointer.PointerIcon getPointerIconCrosshair() {
        return PointerIcon_androidKt.pointerIconCrosshair;
    }

    public static final androidx.compose.ui.input.pointer.PointerIcon getPointerIconDefault() {
        return PointerIcon_androidKt.pointerIconDefault;
    }

    public static final androidx.compose.ui.input.pointer.PointerIcon getPointerIconHand() {
        return PointerIcon_androidKt.pointerIconHand;
    }

    public static final androidx.compose.ui.input.pointer.PointerIcon getPointerIconText() {
        return PointerIcon_androidKt.pointerIconText;
    }
}
