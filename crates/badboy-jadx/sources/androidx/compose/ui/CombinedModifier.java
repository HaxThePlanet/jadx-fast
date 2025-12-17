package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0008\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u001c\u0010\r\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0013\u0010\u000e\u001a\u00020\t2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J5\u0010\u0011\u001a\u0002H\u0012\"\u0004\u0008\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J5\u0010\u0017\u001a\u0002H\u0012\"\u0004\u0008\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0006¨\u0006\u001c", d2 = {"Landroidx/compose/ui/CombinedModifier;", "Landroidx/compose/ui/Modifier;", "outer", "inner", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;)V", "getInner$ui_release", "()Landroidx/compose/ui/Modifier;", "getOuter$ui_release", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "equals", "other", "", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CombinedModifier implements androidx.compose.ui.Modifier {

    public static final int $stable;
    private final androidx.compose.ui.Modifier inner;
    private final androidx.compose.ui.Modifier outer;
    static {
    }

    public CombinedModifier(androidx.compose.ui.Modifier outer, androidx.compose.ui.Modifier inner) {
        super();
        this.outer = outer;
        this.inner = inner;
    }

    public boolean all(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> predicate) {
        boolean z;
        int i;
        if (this.outer.all(predicate) && this.inner.all(predicate)) {
            i = this.inner.all(predicate) ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean any(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> predicate) {
        int i;
        boolean z;
        if (!this.outer.any(predicate)) {
            if (this.inner.any(predicate)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.Modifier
    public boolean equals(Object other) {
        int i;
        boolean equal;
        androidx.compose.ui.Modifier outer;
        if (other instanceof CombinedModifier && Intrinsics.areEqual(this.outer, obj.outer) && Intrinsics.areEqual(this.inner, obj2.inner)) {
            if (Intrinsics.areEqual(this.outer, obj.outer)) {
                i = Intrinsics.areEqual(this.inner, obj2.inner) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public <R> R foldIn(R initial, Function2<? super R, ? super androidx.compose.ui.Modifier.Element, ? extends R> operation) {
        return this.inner.foldIn(this.outer.foldIn(initial, operation), operation);
    }

    public <R> R foldOut(R initial, Function2<? super androidx.compose.ui.Modifier.Element, ? super R, ? extends R> operation) {
        return this.outer.foldOut(this.inner.foldOut(initial, operation), operation);
    }

    @Override // androidx.compose.ui.Modifier
    public final androidx.compose.ui.Modifier getInner$ui_release() {
        return this.inner;
    }

    @Override // androidx.compose.ui.Modifier
    public final androidx.compose.ui.Modifier getOuter$ui_release() {
        return this.outer;
    }

    @Override // androidx.compose.ui.Modifier
    public int hashCode() {
        return i += i4;
    }

    @Override // androidx.compose.ui.Modifier
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('[').append((String)foldIn("", (Function2)CombinedModifier.toString.1.INSTANCE)).append(']').toString();
    }
}
