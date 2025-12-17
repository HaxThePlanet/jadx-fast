package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/ui/focus/FocusInteropUtils;", "", "()V", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusInteropUtils {

    public static final androidx.compose.ui.focus.FocusInteropUtils.Companion Companion;
    private static final int[] tempCoordinates;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/focus/FocusInteropUtils$Companion;", "", "()V", "tempCoordinates", "", "getTempCoordinates", "()[I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int[] getTempCoordinates() {
            return FocusInteropUtils.access$getTempCoordinates$cp();
        }
    }
    static {
        FocusInteropUtils.Companion companion = new FocusInteropUtils.Companion(0);
        FocusInteropUtils.Companion = companion;
        FocusInteropUtils.tempCoordinates = new int[2];
    }

    public static final int[] access$getTempCoordinates$cp() {
        return FocusInteropUtils.tempCoordinates;
    }
}
