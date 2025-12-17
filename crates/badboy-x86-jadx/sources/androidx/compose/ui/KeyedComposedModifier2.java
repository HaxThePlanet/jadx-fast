package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001BX\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008¢\u0006\u0002\u0008\u000b\u0012\u001c\u0010\u000c\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0008¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013¨\u0006\u001a", d2 = {"Landroidx/compose/ui/KeyedComposedModifier2;", "Landroidx/compose/ui/ComposedModifier;", "fqName", "", "key1", "", "key2", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFqName", "()Ljava/lang/String;", "getKey1", "()Ljava/lang/Object;", "getKey2", "equals", "", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class KeyedComposedModifier2 extends androidx.compose.ui.ComposedModifier {

    private final String fqName;
    private final Object key1;
    private final Object key2;
    public KeyedComposedModifier2(String fqName, Object key1, Object key2, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        super(inspectorInfo, factory);
        this.fqName = fqName;
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public boolean equals(Object other) {
        boolean equal;
        int i;
        Object fqName;
        if (other instanceof KeyedComposedModifier2 && Intrinsics.areEqual(this.fqName, obj.fqName) && Intrinsics.areEqual(this.key1, obj2.key1) && Intrinsics.areEqual(this.key2, obj3.key2)) {
            if (Intrinsics.areEqual(this.fqName, obj.fqName)) {
                if (Intrinsics.areEqual(this.key1, obj2.key1)) {
                    i = Intrinsics.areEqual(this.key2, obj3.key2) ? 1 : 0;
                } else {
                }
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
    public final Object getKey2() {
        return this.key2;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public int hashCode() {
        int i2;
        int i;
        Object key1 = this.key1;
        if (key1 != null) {
            i2 = key1.hashCode();
        } else {
            i2 = i;
        }
        Object key2 = this.key2;
        if (key2 != null) {
            i = key2.hashCode();
        }
        return result += i;
    }
}
