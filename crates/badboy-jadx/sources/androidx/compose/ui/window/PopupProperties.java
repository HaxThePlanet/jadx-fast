package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0012\u0008\u0007\u0018\u00002\u00020\u0001B/\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007BC\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bBM\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003¢\u0006\u0002\u0010\rB?\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u001e\u001a\u00020\u00032\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010 \u001a\u00020\u000fH\u0016R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0013R\u0014\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0013¨\u0006!", d2 = {"Landroidx/compose/ui/window/PopupProperties;", "", "focusable", "", "dismissOnBackPress", "dismissOnClickOutside", "clippingEnabled", "(ZZZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "excludeFromSystemGesture", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "usePlatformDefaultWidth", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "flags", "", "inheritSecurePolicy", "(IZZZZZ)V", "getClippingEnabled", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getFlags$ui_release", "()I", "getFocusable", "getInheritSecurePolicy$ui_release", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "equals", "other", "hashCode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PopupProperties {

    public static final int $stable;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final int flags;
    private final boolean inheritSecurePolicy;
    private final boolean usePlatformDefaultWidth;
    static {
    }

    public PopupProperties(int flags, boolean inheritSecurePolicy, boolean dismissOnBackPress, boolean dismissOnClickOutside, boolean excludeFromSystemGesture, boolean usePlatformDefaultWidth) {
        super();
        this.flags = flags;
        this.inheritSecurePolicy = inheritSecurePolicy;
        this.dismissOnBackPress = dismissOnBackPress;
        this.dismissOnClickOutside = dismissOnClickOutside;
        this.excludeFromSystemGesture = excludeFromSystemGesture;
        this.usePlatformDefaultWidth = usePlatformDefaultWidth;
    }

    public PopupProperties(int i, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj7;
        int obj8;
        final int i2 = 1;
        obj3 = i7 & 2 != 0 ? i2 : obj3;
        obj4 = i7 & 4 != 0 ? i2 : obj4;
        obj5 = i7 & 8 != 0 ? i2 : obj5;
        obj6 = i7 & 16 != 0 ? i2 : obj6;
        obj8 = i7 &= 32 != 0 ? obj7 : z6;
        super(i, obj3, obj4, obj5, obj6, obj8);
    }

    public PopupProperties(boolean focusable, boolean dismissOnBackPress, boolean dismissOnClickOutside, androidx.compose.ui.window.SecureFlagPolicy securePolicy, boolean excludeFromSystemGesture, boolean clippingEnabled) {
        super(focusable, dismissOnBackPress, dismissOnClickOutside, securePolicy, excludeFromSystemGesture, clippingEnabled, 0);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, androidx.compose.ui.window.SecureFlagPolicy secureFlagPolicy4, boolean z5, boolean z6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int obj2;
        int obj3;
        int obj4;
        androidx.compose.ui.window.SecureFlagPolicy obj5;
        int obj6;
        int obj9;
        obj2 = i7 & 1 != 0 ? 0 : obj2;
        final int i = 1;
        obj3 = i7 & 2 != 0 ? i : obj3;
        obj4 = i7 & 4 != 0 ? i : obj4;
        obj5 = i7 & 8 != 0 ? SecureFlagPolicy.Inherit : obj5;
        obj6 = i7 & 16 != 0 ? i : obj6;
        obj9 = i7 &= 32 != 0 ? i : z6;
        super(obj2, obj3, obj4, obj5, obj6, obj9);
    }

    public PopupProperties(boolean focusable, boolean dismissOnBackPress, boolean dismissOnClickOutside, androidx.compose.ui.window.SecureFlagPolicy securePolicy, boolean excludeFromSystemGesture, boolean clippingEnabled, boolean usePlatformDefaultWidth) {
        int i;
        i = securePolicy == SecureFlagPolicy.Inherit ? 1 : 0;
        super(AndroidPopup_androidKt.access$createFlags(focusable, securePolicy, clippingEnabled), i, dismissOnBackPress, dismissOnClickOutside, excludeFromSystemGesture, usePlatformDefaultWidth);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, androidx.compose.ui.window.SecureFlagPolicy secureFlagPolicy4, boolean z5, boolean z6, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int obj3;
        int obj4;
        int obj5;
        androidx.compose.ui.window.SecureFlagPolicy obj6;
        int obj7;
        int obj8;
        int obj10;
        final int i = 0;
        obj3 = i8 & 1 != 0 ? i : obj3;
        final int i2 = 1;
        obj4 = i8 & 2 != 0 ? i2 : obj4;
        obj5 = i8 & 4 != 0 ? i2 : obj5;
        obj6 = i8 & 8 != 0 ? SecureFlagPolicy.Inherit : obj6;
        obj7 = i8 & 16 != 0 ? i2 : obj7;
        obj8 = i8 & 32 != 0 ? i2 : obj8;
        obj10 = i8 &= 64 != 0 ? i : z7;
        super(obj3, obj4, obj5, obj6, obj7, obj8, obj10);
    }

    public PopupProperties(boolean focusable, boolean dismissOnBackPress, boolean dismissOnClickOutside, boolean clippingEnabled) {
        super(focusable, dismissOnBackPress, dismissOnClickOutside, SecureFlagPolicy.Inherit, 1, clippingEnabled);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, boolean z4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        obj2 = i5 & 1 != 0 ? 0 : obj2;
        final int i = 1;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof PopupProperties) {
            return i2;
        }
        if (this.flags != obj.flags) {
            return i2;
        }
        if (this.inheritSecurePolicy != obj2.inheritSecurePolicy) {
            return i2;
        }
        if (this.dismissOnBackPress != obj3.dismissOnBackPress) {
            return i2;
        }
        if (this.dismissOnClickOutside != obj4.dismissOnClickOutside) {
            return i2;
        }
        if (this.excludeFromSystemGesture != obj5.excludeFromSystemGesture) {
            return i2;
        }
        if (this.usePlatformDefaultWidth != obj6.usePlatformDefaultWidth) {
            return i2;
        }
        return i;
    }

    public final boolean getClippingEnabled() {
        int i;
        i = flags &= 512 == 0 ? 1 : 0;
        return i;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final int getFlags$ui_release() {
        return this.flags;
    }

    public final boolean getFocusable() {
        int i;
        i = flags &= 8 == 0 ? 1 : 0;
        return i;
    }

    public final boolean getInheritSecurePolicy$ui_release() {
        return this.inheritSecurePolicy;
    }

    public final androidx.compose.ui.window.SecureFlagPolicy getSecurePolicy() {
        androidx.compose.ui.window.SecureFlagPolicy secureOff;
        secureOff = this.inheritSecurePolicy ? SecureFlagPolicy.Inherit : i == 0 ? SecureFlagPolicy.SecureOff : SecureFlagPolicy.SecureOn;
        return secureOff;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return result4 += i11;
    }
}
