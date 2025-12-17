package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n\u0012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000c0\u0007¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u0018", d2 = {"Landroidx/compose/ui/KeyedComposedModifier1;", "Landroidx/compose/ui/ComposedModifier;", "fqName", "", "key1", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFqName", "()Ljava/lang/String;", "getKey1", "()Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class KeyedComposedModifier1 extends androidx.compose.ui.ComposedModifier {

    private final String fqName;
    private final Object key1;
    public KeyedComposedModifier1(String fqName, Object key1, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        super(inspectorInfo, factory);
        this.fqName = fqName;
        this.key1 = key1;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public boolean equals(Object other) {
        int i;
        boolean equal;
        Object fqName;
        if (other instanceof KeyedComposedModifier1 && Intrinsics.areEqual(this.fqName, obj.fqName) && Intrinsics.areEqual(this.key1, obj2.key1)) {
            if (Intrinsics.areEqual(this.fqName, obj.fqName)) {
                i = Intrinsics.areEqual(this.key1, obj2.key1) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public final String getFqName() {
        return this.fqName;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public final Object getKey1() {
        return this.key1;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public int hashCode() {
        int i;
        Object key1 = this.key1;
        if (key1 != null) {
            i = key1.hashCode();
        } else {
            i = 0;
        }
        return i3 += i;
    }
}
