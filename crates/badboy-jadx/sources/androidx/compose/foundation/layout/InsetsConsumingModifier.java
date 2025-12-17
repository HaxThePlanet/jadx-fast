package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00083\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0008\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/layout/InsetsConsumingModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/layout/WindowInsets;", "()V", "<set-?>", "consumedInsets", "getConsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setConsumedInsets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "consumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "calculateInsets", "modifierLocalInsets", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/foundation/layout/PaddingValuesConsumingModifier;", "Landroidx/compose/foundation/layout/UnionInsetsConsumingModifier;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class InsetsConsumingModifier implements ModifierLocalConsumer, ModifierLocalProvider<androidx.compose.foundation.layout.WindowInsets> {

    private final MutableState consumedInsets$delegate;
    private InsetsConsumingModifier() {
        super();
        int i = 0;
        final int i2 = 0;
        this.consumedInsets$delegate = SnapshotStateKt.mutableStateOf$default(WindowInsetsKt.WindowInsets(i, i, i, i), i2, 2, i2);
    }

    public InsetsConsumingModifier(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    private final androidx.compose.foundation.layout.WindowInsets getConsumedInsets() {
        final int i = 0;
        final int i2 = 0;
        return (WindowInsets)(State)this.consumedInsets$delegate.getValue();
    }

    private final void setConsumedInsets(androidx.compose.foundation.layout.WindowInsets <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.consumedInsets$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public abstract androidx.compose.foundation.layout.WindowInsets calculateInsets(androidx.compose.foundation.layout.WindowInsets windowInsets);

    public ProvidableModifierLocal<androidx.compose.foundation.layout.WindowInsets> getKey() {
        return WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public androidx.compose.foundation.layout.WindowInsets getValue() {
        return getConsumedInsets();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        final int i = 0;
        setConsumedInsets(calculateInsets((WindowInsets)scope.getCurrent((ModifierLocal)WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets())));
    }
}
