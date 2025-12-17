package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u0003H\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Landroidx/compose/ui/input/pointer/AndroidPointerIconType;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "type", "", "(I)V", "getType", "()I", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPointerIconType implements androidx.compose.ui.input.pointer.PointerIcon {

    public static final int $stable;
    private final int type;
    static {
    }

    public AndroidPointerIconType(int type) {
        super();
        this.type = type;
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public boolean equals(Object other) {
        Class class;
        final int i = 1;
        if (this == other) {
            return i;
        }
        if (other != null) {
            class = other.getClass();
        } else {
            class = 0;
        }
        int i2 = 0;
        if (!Intrinsics.areEqual(getClass(), class)) {
            return i2;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
        Object obj = other;
        if (this.type != obj2.type) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public final int getType() {
        return this.type;
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public int hashCode() {
        return this.type;
    }

    @Override // androidx.compose.ui.input.pointer.PointerIcon
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AndroidPointerIcon(type=").append(this.type).append(')').toString();
    }
}
