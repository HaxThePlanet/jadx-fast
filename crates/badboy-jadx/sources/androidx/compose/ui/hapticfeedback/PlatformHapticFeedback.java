package androidx.compose.ui.hapticfeedback;

import android.view.View;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformHapticFeedback implements androidx.compose.ui.hapticfeedback.HapticFeedback {

    public static final int $stable = 8;
    private final View view;
    static {
        final int i = 8;
    }

    public PlatformHapticFeedback(View view) {
        super();
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    public void performHapticFeedback-CdsT49E(int hapticFeedbackType) {
        View view;
        int i;
        if (HapticFeedbackType.equals-impl0(hapticFeedbackType, HapticFeedbackType.Companion.getLongPress-5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else {
            if (HapticFeedbackType.equals-impl0(hapticFeedbackType, HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI())) {
                this.view.performHapticFeedback(9);
            }
        }
    }
}
