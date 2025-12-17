package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\"\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\nH\u0007\u001a0\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u000c2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\nH\u0007\u001a0\u0010\r\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0082\u0008¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u00020\u0015\"\u0004\u0008\u0000\u0010\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0080\u0008\u001a*\u0010\u0017\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u00082\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00080\u0018H\u0082\u0008¢\u0006\u0004\u0008\u0019\u0010\u001a\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"calculationBlockNestedLevel", "Landroidx/compose/runtime/SnapshotThreadLocal;", "Landroidx/compose/runtime/internal/IntRef;", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "notifyObservers", "R", "derivedState", "Landroidx/compose/runtime/DerivedState;", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "", "observer", "withCalculationNestedLevel", "Lkotlin/Function1;", "withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final class SnapshotStateKt__DerivedStateKt {

    private static final androidx.compose.runtime.SnapshotThreadLocal<IntRef> calculationBlockNestedLevel;
    private static final androidx.compose.runtime.SnapshotThreadLocal<MutableVector<androidx.compose.runtime.DerivedStateObserver>> derivedStateObservers;
    static {
        SnapshotThreadLocal snapshotThreadLocal = new SnapshotThreadLocal();
        SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel = snapshotThreadLocal;
        SnapshotThreadLocal snapshotThreadLocal2 = new SnapshotThreadLocal();
        SnapshotStateKt__DerivedStateKt.derivedStateObservers = snapshotThreadLocal2;
    }

    public static final androidx.compose.runtime.SnapshotThreadLocal access$getCalculationBlockNestedLevel$p() {
        return SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
    }

    public static final MutableVector<androidx.compose.runtime.DerivedStateObserver> derivedStateObservers() {
        Object capacity$iv;
        int i;
        MutableVector mutableVector;
        androidx.compose.runtime.SnapshotThreadLocal derivedStateObservers;
        int i2;
        if ((MutableVector)SnapshotStateKt__DerivedStateKt.derivedStateObservers.get() == null) {
            int i4 = 0;
            mutableVector = new MutableVector(new DerivedStateObserver[0], 0);
            i = 0;
            SnapshotStateKt__DerivedStateKt.derivedStateObservers.set(mutableVector);
        }
        return capacity$iv;
    }

    public static final <T> androidx.compose.runtime.State<T> derivedStateOf(androidx.compose.runtime.SnapshotMutationPolicy<T> policy, Function0<? extends T> calculation) {
        DerivedSnapshotState derivedSnapshotState = new DerivedSnapshotState(calculation, policy);
        return (State)derivedSnapshotState;
    }

    public static final <T> androidx.compose.runtime.State<T> derivedStateOf(Function0<? extends T> calculation) {
        DerivedSnapshotState derivedSnapshotState = new DerivedSnapshotState(calculation, 0);
        return (State)derivedSnapshotState;
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(androidx.compose.runtime.DerivedState<?> derivedState, Function0<? extends R> block) {
        Throwable th;
        Object obj2;
        int i;
        int i$iv;
        int i$iv2;
        Object[] content;
        Object obj;
        int i2;
        final int i3 = 0;
        final MutableVector derivedStateObservers = SnapshotStateKt.derivedStateObservers();
        MutableVector mutableVector = derivedStateObservers;
        int i4 = 0;
        int size = mutableVector.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = 0;
            (DerivedStateObserver)mutableVector.getContent()[i$iv].start(derivedState);
            while (i$iv++ >= size) {
                obj = 0;
                (DerivedStateObserver)i$iv2[i$iv].start(derivedState);
            }
        }
        MutableVector mutableVector2 = derivedStateObservers;
        int i5 = 0;
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            i$iv2 = 0;
            i2 = 0;
            (DerivedStateObserver)mutableVector2.getContent()[i$iv2].done(derivedState);
            while (i$iv2++ >= size2) {
                i2 = 0;
                (DerivedStateObserver)content[i$iv2].done(derivedState);
            }
        }
        return block.invoke();
    }

    public static final <R> void observeDerivedStateRecalculations(androidx.compose.runtime.DerivedStateObserver observer, Function0<? extends R> block) {
        final int i = 0;
        final MutableVector derivedStateObservers = SnapshotStateKt.derivedStateObservers();
        derivedStateObservers.add(observer);
        block.invoke();
        final int i2 = 0;
        derivedStateObservers.removeAt(size--);
    }

    private static final <T> T withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt(Function1<? super IntRef, ? extends T> block) {
        Object intRef2;
        IntRef intRef;
        int i;
        androidx.compose.runtime.SnapshotThreadLocal snapshotThreadLocal;
        final int i2 = 0;
        if ((IntRef)SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get() == null) {
            intRef2 = new IntRef(0);
            i = 0;
            SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(intRef2);
        }
        return block.invoke(intRef2);
    }
}
