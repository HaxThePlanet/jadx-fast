package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008g\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0003À\u0006\u0001", d2 = {"Landroidx/compose/ui/input/pointer/PointerIcon;", "", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PointerIcon {

    public static final androidx.compose.ui.input.pointer.PointerIcon.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006¨\u0006\r", d2 = {"Landroidx/compose/ui/input/pointer/PointerIcon$Companion;", "", "()V", "Crosshair", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getCrosshair", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "Default", "getDefault", "Hand", "getHand", "Text", "getText", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.input.pointer.PointerIcon.Companion $$INSTANCE;
        private static final androidx.compose.ui.input.pointer.PointerIcon Crosshair;
        private static final androidx.compose.ui.input.pointer.PointerIcon Default;
        private static final androidx.compose.ui.input.pointer.PointerIcon Hand;
        private static final androidx.compose.ui.input.pointer.PointerIcon Text;
        static {
            PointerIcon.Companion companion = new PointerIcon.Companion();
            PointerIcon.Companion.$$INSTANCE = companion;
            PointerIcon.Companion.Default = PointerIcon_androidKt.getPointerIconDefault();
            PointerIcon.Companion.Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();
            PointerIcon.Companion.Text = PointerIcon_androidKt.getPointerIconText();
            PointerIcon.Companion.Hand = PointerIcon_androidKt.getPointerIconHand();
        }

        public final androidx.compose.ui.input.pointer.PointerIcon getCrosshair() {
            return PointerIcon.Companion.Crosshair;
        }

        public final androidx.compose.ui.input.pointer.PointerIcon getDefault() {
            return PointerIcon.Companion.Default;
        }

        public final androidx.compose.ui.input.pointer.PointerIcon getHand() {
            return PointerIcon.Companion.Hand;
        }

        public final androidx.compose.ui.input.pointer.PointerIcon getText() {
            return PointerIcon.Companion.Text;
        }
    }
    static {
        PointerIcon.Companion = PointerIcon.Companion.$$INSTANCE;
    }
}
