package androidx.compose.ui.platform;

import android.view.ViewConfiguration;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/AndroidViewConfigurationApi34;", "", "()V", "getScaledHandwritingGestureLineMargin", "", "viewConfiguration", "Landroid/view/ViewConfiguration;", "getScaledHandwritingSlop", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidViewConfigurationApi34 {

    public static final androidx.compose.ui.platform.AndroidViewConfigurationApi34 INSTANCE;
    static {
        AndroidViewConfigurationApi34 androidViewConfigurationApi34 = new AndroidViewConfigurationApi34();
        AndroidViewConfigurationApi34.INSTANCE = androidViewConfigurationApi34;
    }

    public final float getScaledHandwritingGestureLineMargin(ViewConfiguration viewConfiguration) {
        return (float)scaledHandwritingGestureLineMargin;
    }

    public final float getScaledHandwritingSlop(ViewConfiguration viewConfiguration) {
        return (float)scaledHandwritingSlop;
    }
}
