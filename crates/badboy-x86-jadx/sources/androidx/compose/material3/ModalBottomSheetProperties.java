package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0008\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008B\u0019\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u00032\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0012", d2 = {"Landroidx/compose/material3/ModalBottomSheetProperties;", "", "shouldDismissOnBackPress", "", "(Z)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isFocusable", "(Landroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheetProperties {

    public static final int $stable;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;
    static {
    }

    public ModalBottomSheetProperties() {
        final int i3 = 0;
        super(i3, 0, 3, i3);
    }

    public ModalBottomSheetProperties(SecureFlagPolicy securePolicy, boolean shouldDismissOnBackPress) {
        super();
        this.securePolicy = securePolicy;
        this.shouldDismissOnBackPress = shouldDismissOnBackPress;
    }

    public ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        SecureFlagPolicy obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? SecureFlagPolicy.Inherit : obj1;
        obj2 = i3 &= 2 != 0 ? 1 : obj2;
        super(obj1, obj2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'isFocusable' param is no longer used. Use constructor without this parameter.", replaceWith = @ReplaceWith(...))
    public ModalBottomSheetProperties(SecureFlagPolicy securePolicy, boolean isFocusable, boolean shouldDismissOnBackPress) {
        super(securePolicy, shouldDismissOnBackPress);
    }

    public ModalBottomSheetProperties(boolean shouldDismissOnBackPress) {
        super(SecureFlagPolicy.Inherit, shouldDismissOnBackPress);
    }

    public ModalBottomSheetProperties(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        final int obj3 = 1;
        obj1 = i2 &= obj3 != 0 ? obj3 : obj1;
        super(obj1);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ModalBottomSheetProperties) {
            return i2;
        }
        if (this.securePolicy != obj.securePolicy) {
            return i2;
        }
        return i;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public int hashCode() {
        return i2 += i4;
    }
}
