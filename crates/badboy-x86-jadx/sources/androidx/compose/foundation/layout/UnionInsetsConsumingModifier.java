package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/foundation/layout/UnionInsetsConsumingModifier;", "Landroidx/compose/foundation/layout/InsetsConsumingModifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "calculateInsets", "modifierLocalInsets", "equals", "", "other", "", "hashCode", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class UnionInsetsConsumingModifier extends androidx.compose.foundation.layout.InsetsConsumingModifier {

    private final androidx.compose.foundation.layout.WindowInsets insets;
    public UnionInsetsConsumingModifier(androidx.compose.foundation.layout.WindowInsets insets) {
        super(0);
        this.insets = insets;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifier
    public androidx.compose.foundation.layout.WindowInsets calculateInsets(androidx.compose.foundation.layout.WindowInsets modifierLocalInsets) {
        return WindowInsetsKt.union(this.insets, modifierLocalInsets);
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifier
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof UnionInsetsConsumingModifier) {
            return 0;
        }
        return Intrinsics.areEqual(obj.insets, this.insets);
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifier
    public int hashCode() {
        return this.insets.hashCode();
    }
}
