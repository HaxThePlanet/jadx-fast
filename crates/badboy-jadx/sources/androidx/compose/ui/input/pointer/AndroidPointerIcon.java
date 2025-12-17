package androidx.compose.ui.input.pointer;

import android.view.PointerIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000f", d2 = {"Landroidx/compose/ui/input/pointer/AndroidPointerIcon;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "pointerIcon", "Landroid/view/PointerIcon;", "(Landroid/view/PointerIcon;)V", "getPointerIcon", "()Landroid/view/PointerIcon;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPointerIcon implements androidx.compose.ui.input.pointer.PointerIcon {

    public static final int $stable;
    private final PointerIcon pointerIcon;
    static {
    }

    public AndroidPointerIcon(PointerIcon pointerIcon) {
        super();
        this.pointerIcon = pointerIcon;
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public boolean equals(Object other) {
        Class class;
        if (this == other) {
            return 1;
        }
        if (other != null) {
            class = other.getClass();
        } else {
            class = 0;
        }
        if (!Intrinsics.areEqual(getClass(), class)) {
            return 0;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIcon");
        Object obj = other;
        return Intrinsics.areEqual(this.pointerIcon, obj2.pointerIcon);
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public final PointerIcon getPointerIcon() {
        return this.pointerIcon;
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public int hashCode() {
        return this.pointerIcon.hashCode();
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AndroidPointerIcon(pointerIcon=").append(this.pointerIcon).append(')').toString();
    }
}
