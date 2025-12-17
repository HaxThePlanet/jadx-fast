package androidx.compose.ui.platform;

import android.view.PointerIcon;
import android.view.View;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethodsN;", "", "()V", "setPointerIcon", "", "view", "Landroid/view/View;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidComposeViewVerificationHelperMethodsN {

    public static final androidx.compose.ui.platform.AndroidComposeViewVerificationHelperMethodsN INSTANCE;
    static {
        AndroidComposeViewVerificationHelperMethodsN androidComposeViewVerificationHelperMethodsN = new AndroidComposeViewVerificationHelperMethodsN();
        AndroidComposeViewVerificationHelperMethodsN.INSTANCE = androidComposeViewVerificationHelperMethodsN;
    }

    public final void setPointerIcon(View view, PointerIcon icon) {
        PointerIcon pointerIcon;
        int type;
        if (icon instanceof AndroidPointerIcon) {
            pointerIcon = (AndroidPointerIcon)icon.getPointerIcon();
        } else {
            if (icon instanceof AndroidPointerIconType) {
                pointerIcon = PointerIcon.getSystemIcon(view.getContext(), (AndroidPointerIconType)icon.getType());
            } else {
                pointerIcon = PointerIcon.getSystemIcon(view.getContext(), 1000);
            }
        }
        if (!Intrinsics.areEqual(view.getPointerIcon(), pointerIcon)) {
            view.setPointerIcon(pointerIcon);
        }
    }
}
