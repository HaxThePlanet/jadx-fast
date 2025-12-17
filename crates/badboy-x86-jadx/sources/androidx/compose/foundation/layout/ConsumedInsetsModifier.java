package androidx.compose.foundation.layout;

import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/layout/ConsumedInsetsModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/WindowInsets;", "", "(Lkotlin/jvm/functions/Function1;)V", "oldWindowInsets", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ConsumedInsetsModifier implements ModifierLocalConsumer {

    private final Function1<androidx.compose.foundation.layout.WindowInsets, Unit> block;
    private androidx.compose.foundation.layout.WindowInsets oldWindowInsets;
    public ConsumedInsetsModifier(Function1<? super androidx.compose.foundation.layout.WindowInsets, Unit> block) {
        super();
        this.block = block;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public boolean equals(Object other) {
        int i;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof ConsumedInsetsModifier) {
            return i2;
        }
        if (obj.block == this.block) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public int hashCode() {
        return this.block.hashCode();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        boolean equal;
        final int i = 0;
        Object current = scope.getCurrent((ModifierLocal)WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        if (!Intrinsics.areEqual((WindowInsets)current, this.oldWindowInsets)) {
            this.oldWindowInsets = current;
            this.block.invoke(current);
        }
    }
}
