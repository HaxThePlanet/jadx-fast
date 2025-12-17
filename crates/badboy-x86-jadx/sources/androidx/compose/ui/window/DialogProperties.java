package androidx.compose.ui.window;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B%\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tB7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0013\u001a\u00020\u00032\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\r¨\u0006\u0017", d2 = {"Landroidx/compose/ui/window/DialogProperties;", "", "dismissOnBackPress", "", "dismissOnClickOutside", "usePlatformDefaultWidth", "(ZZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;)V", "decorFitsSystemWindows", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "getDecorFitsSystemWindows", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "equals", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogProperties {

    public static final int $stable;
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final androidx.compose.ui.window.SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;
    static {
    }

    public DialogProperties() {
        super(0, 0, 0, 0, 0, 31, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public DialogProperties(boolean dismissOnBackPress, boolean dismissOnClickOutside, androidx.compose.ui.window.SecureFlagPolicy securePolicy) {
        super(dismissOnBackPress, dismissOnClickOutside, securePolicy, 1, 1);
    }

    public DialogProperties(boolean z, boolean z2, androidx.compose.ui.window.SecureFlagPolicy secureFlagPolicy3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        androidx.compose.ui.window.SecureFlagPolicy obj4;
        final int i = 1;
        obj2 = i4 & 1 != 0 ? i : obj2;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? SecureFlagPolicy.Inherit : obj4;
        super(obj2, obj3, obj4);
    }

    public DialogProperties(boolean dismissOnBackPress, boolean dismissOnClickOutside, androidx.compose.ui.window.SecureFlagPolicy securePolicy, boolean usePlatformDefaultWidth, boolean decorFitsSystemWindows) {
        super();
        this.dismissOnBackPress = dismissOnBackPress;
        this.dismissOnClickOutside = dismissOnClickOutside;
        this.securePolicy = securePolicy;
        this.usePlatformDefaultWidth = usePlatformDefaultWidth;
        this.decorFitsSystemWindows = decorFitsSystemWindows;
    }

    public DialogProperties(boolean z, boolean z2, androidx.compose.ui.window.SecureFlagPolicy secureFlagPolicy3, boolean z4, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int obj2;
        int obj3;
        androidx.compose.ui.window.SecureFlagPolicy obj4;
        int obj5;
        int obj7;
        final int i = 1;
        obj2 = i6 & 1 != 0 ? i : obj2;
        obj3 = i6 & 2 != 0 ? i : obj3;
        obj4 = i6 & 4 != 0 ? SecureFlagPolicy.Inherit : obj4;
        obj5 = i6 & 8 != 0 ? i : obj5;
        obj7 = i6 &= 16 != 0 ? i : z5;
        super(obj2, obj3, obj4, obj5, obj7);
    }

    public DialogProperties(boolean dismissOnBackPress, boolean dismissOnClickOutside, boolean usePlatformDefaultWidth) {
        super(dismissOnBackPress, dismissOnClickOutside, SecureFlagPolicy.Inherit, usePlatformDefaultWidth, 1);
    }

    public DialogProperties(boolean z, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 1;
        obj2 = i4 & 1 != 0 ? i : obj2;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(obj2, obj3, obj4);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof DialogProperties) {
            return i2;
        }
        if (this.dismissOnBackPress != obj.dismissOnBackPress) {
            return i2;
        }
        if (this.dismissOnClickOutside != obj2.dismissOnClickOutside) {
            return i2;
        }
        if (this.securePolicy != obj3.securePolicy) {
            return i2;
        }
        if (this.usePlatformDefaultWidth != obj4.usePlatformDefaultWidth) {
            return i2;
        }
        if (this.decorFitsSystemWindows != obj5.decorFitsSystemWindows) {
            return i2;
        }
        return i;
    }

    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final androidx.compose.ui.window.SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return result2 += i10;
    }
}
