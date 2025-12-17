package androidx.compose.ui.hapticfeedback;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedbackType;", "", "()V", "LongPress", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getLongPress-5zf0vsI", "()I", "I", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformHapticFeedbackType {

    public static final int $stable;
    public static final androidx.compose.ui.hapticfeedback.PlatformHapticFeedbackType INSTANCE;
    private static final int LongPress;
    private static final int TextHandleMove;
    static {
        PlatformHapticFeedbackType platformHapticFeedbackType = new PlatformHapticFeedbackType();
        PlatformHapticFeedbackType.INSTANCE = platformHapticFeedbackType;
        PlatformHapticFeedbackType.LongPress = HapticFeedbackType.constructor-impl(0);
        PlatformHapticFeedbackType.TextHandleMove = HapticFeedbackType.constructor-impl(9);
    }

    public final int getLongPress-5zf0vsI() {
        return PlatformHapticFeedbackType.LongPress;
    }

    public final int getTextHandleMove-5zf0vsI() {
        return PlatformHapticFeedbackType.TextHandleMove;
    }
}
