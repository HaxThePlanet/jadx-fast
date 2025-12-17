package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Landroidx/compose/material3/ModalBottomSheetDefaults;", "", "()V", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "getProperties", "()Landroidx/compose/material3/ModalBottomSheetProperties;", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isFocusable", "", "shouldDismissOnBackPress", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheetDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.ModalBottomSheetDefaults INSTANCE;
    private static final androidx.compose.material3.ModalBottomSheetProperties properties;
    static {
        ModalBottomSheetDefaults modalBottomSheetDefaults = new ModalBottomSheetDefaults();
        ModalBottomSheetDefaults.INSTANCE = modalBottomSheetDefaults;
        ModalBottomSheetProperties modalBottomSheetProperties = new ModalBottomSheetProperties(0, 1, 0);
        ModalBottomSheetDefaults.properties = modalBottomSheetProperties;
    }

    public static androidx.compose.material3.ModalBottomSheetProperties properties$default(androidx.compose.material3.ModalBottomSheetDefaults modalBottomSheetDefaults, SecureFlagPolicy secureFlagPolicy2, boolean z3, boolean z4, int i5, Object object6) {
        SecureFlagPolicy obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 = SecureFlagPolicy.Inherit;
        }
        final int i = 1;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return modalBottomSheetDefaults.properties(obj2, obj3, obj4);
    }

    public final androidx.compose.material3.ModalBottomSheetProperties getProperties() {
        return ModalBottomSheetDefaults.properties;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'isFocusable' param is no longer used. Use value without this parameter.", replaceWith = @ReplaceWith(...))
    public final androidx.compose.material3.ModalBottomSheetProperties properties(SecureFlagPolicy securePolicy, boolean isFocusable, boolean shouldDismissOnBackPress) {
        ModalBottomSheetProperties modalBottomSheetProperties = new ModalBottomSheetProperties(securePolicy, shouldDismissOnBackPress);
        return modalBottomSheetProperties;
    }
}
