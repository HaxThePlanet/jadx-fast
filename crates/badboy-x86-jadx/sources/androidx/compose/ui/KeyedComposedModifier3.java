package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c\u0012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0002\u0008\u000f¢\u0006\u0002\u0008\u000c¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014¨\u0006\u001c", d2 = {"Landroidx/compose/ui/KeyedComposedModifier3;", "Landroidx/compose/ui/ComposedModifier;", "fqName", "", "key1", "", "key2", "key3", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFqName", "()Ljava/lang/String;", "getKey1", "()Ljava/lang/Object;", "getKey2", "getKey3", "equals", "", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class KeyedComposedModifier3 extends androidx.compose.ui.ComposedModifier {

    private final String fqName;
    private final Object key1;
    private final Object key2;
    private final Object key3;
    public KeyedComposedModifier3(String fqName, Object key1, Object key2, Object key3, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        super(inspectorInfo, factory);
        this.fqName = fqName;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public boolean equals(Object other) {
        int i;
        boolean equal;
        String fqName;
        if (other instanceof KeyedComposedModifier3 && Intrinsics.areEqual(this.fqName, obj.fqName) && Intrinsics.areEqual(this.key1, obj2.key1) && Intrinsics.areEqual(this.key2, obj3.key2) && Intrinsics.areEqual(this.key3, obj4.key3)) {
            if (Intrinsics.areEqual(this.fqName, obj.fqName)) {
                if (Intrinsics.areEqual(this.key1, obj2.key1)) {
                    if (Intrinsics.areEqual(this.key2, obj3.key2)) {
                        i = Intrinsics.areEqual(this.key3, obj4.key3) ? 1 : 0;
                    } else {
                    }
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
    public final Object getKey3() {
        return this.key3;
    }

    @Override // androidx.compose.ui.ComposedModifier
    public int hashCode() {
        int i3;
        int i2;
        int i;
        Object key1 = this.key1;
        i = 0;
        if (key1 != null) {
            i3 = key1.hashCode();
        } else {
            i3 = i;
        }
        Object key2 = this.key2;
        if (key2 != null) {
            i2 = key2.hashCode();
        } else {
            i2 = i;
        }
        Object key3 = this.key3;
        if (key3 != null) {
            i = key3.hashCode();
        }
        return result2 += i;
    }
}
