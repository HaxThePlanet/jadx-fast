package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0018\u001a\u00020\u00102\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0008\u0010#\u001a\u00020\u0003H\u0016J\u0008\u0010$\u001a\u00020\u0005H\u0016J\u001d\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008*R+\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0015\u0010\u000f\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006+", d2 = {"Landroidx/compose/foundation/layout/AndroidWindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "type", "", "name", "", "(ILjava/lang/String;)V", "<set-?>", "Landroidx/core/graphics/Insets;", "insets", "getInsets$foundation_layout_release", "()Landroidx/core/graphics/Insets;", "setInsets$foundation_layout_release", "(Landroidx/core/graphics/Insets;)V", "insets$delegate", "Landroidx/compose/runtime/MutableState;", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "getType$foundation_layout_release", "()I", "equals", "other", "", "getBottom", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "update", "", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "typeMask", "update$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidWindowInsets implements androidx.compose.foundation.layout.WindowInsets {

    public static final int $stable;
    private final MutableState insets$delegate;
    private final MutableState isVisible$delegate;
    private final String name;
    private final int type;
    static {
    }

    public AndroidWindowInsets(int type, String name) {
        super();
        this.type = type;
        this.name = name;
        final int i2 = 0;
        final int i3 = 2;
        this.insets$delegate = SnapshotStateKt.mutableStateOf$default(Insets.NONE, i2, i3, i2);
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(true, i2, i3, i2);
    }

    private final void setVisible(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isVisible$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public boolean equals(Object other) {
        int i;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof AndroidWindowInsets) {
            return i2;
        }
        if (this.type == obj.type) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        return insets$foundation_layout_release.bottom;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final Insets getInsets$foundation_layout_release() {
        final int i = 0;
        final int i2 = 0;
        return (Insets)(State)this.insets$delegate.getValue();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return insets$foundation_layout_release.left;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        return insets$foundation_layout_release.right;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        return insets$foundation_layout_release.top;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getType$foundation_layout_release() {
        return this.type;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int hashCode() {
        return this.type;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final boolean isVisible() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isVisible$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final void setInsets$foundation_layout_release(Insets <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.insets$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = ", ";
        return stringBuilder.append(this.name).append('(').append(insets$foundation_layout_release.left).append(str).append(insets$foundation_layout_release3.top).append(str).append(insets$foundation_layout_release4.right).append(str).append(insets$foundation_layout_release2.bottom).append(')').toString();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final void update$foundation_layout_release(WindowInsetsCompat windowInsetsCompat, int typeMask) {
        int visible;
        if (typeMask != 0) {
            if (type &= typeMask != 0) {
                setInsets$foundation_layout_release(windowInsetsCompat.getInsets(this.type));
                setVisible(windowInsetsCompat.isVisible(this.type));
            }
        } else {
        }
    }
}
