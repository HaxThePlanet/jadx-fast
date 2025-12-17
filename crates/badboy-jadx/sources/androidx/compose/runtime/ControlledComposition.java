package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u00002\u00020\u0001J\u0008\u0010\u0007\u001a\u00020\u0008H&J\u0008\u0010\t\u001a\u00020\u0008H&J\u0008\u0010\n\u001a\u00020\u0008H&J\u0008\u0010\u000b\u001a\u00020\u0008H&J \u0010\u000c\u001a\u00020\u00082\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00080\u000e¢\u0006\u0002\u0008\u000fH&¢\u0006\u0002\u0010\u0010J3\u0010\u0011\u001a\u0002H\u0012\"\u0004\u0008\u0000\u0010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u000eH&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u001aH'J$\u0010\u001b\u001a\u00020\u00082\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e0\u001dH'J\u0008\u0010 \u001a\u00020\u0008H&J\u0016\u0010!\u001a\u00020\u00032\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#H&J\u0016\u0010%\u001a\u00020\u00082\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000eH&J\u0008\u0010&\u001a\u00020\u0003H&J\u0016\u0010'\u001a\u00020\u00082\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#H&J\u0010\u0010(\u001a\u00020\u00082\u0006\u0010)\u001a\u00020$H&J\u0010\u0010*\u001a\u00020\u00082\u0006\u0010)\u001a\u00020$H&J\u0008\u0010+\u001a\u00020\u0008H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0005\u0082\u0001\u0001,ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006-À\u0006\u0001", d2 = {"Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/Composition;", "hasPendingChanges", "", "getHasPendingChanges", "()Z", "isComposing", "abandonChanges", "", "applyChanges", "applyLateChanges", "changesApplied", "composeContent", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;)V", "delegateInvalidations", "R", "to", "groupIndex", "", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "insertMovableContent", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidateAll", "observesAnyOf", "values", "", "", "prepareCompose", "recompose", "recordModificationsOf", "recordReadOf", "value", "recordWriteOf", "verifyConsistent", "Landroidx/compose/runtime/CompositionImpl;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ControlledComposition extends androidx.compose.runtime.Composition {
    @Override // androidx.compose.runtime.Composition
    public abstract void abandonChanges();

    @Override // androidx.compose.runtime.Composition
    public abstract void applyChanges();

    @Override // androidx.compose.runtime.Composition
    public abstract void applyLateChanges();

    @Override // androidx.compose.runtime.Composition
    public abstract void changesApplied();

    public abstract void composeContent(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> function2);

    public abstract <R> R delegateInvalidations(androidx.compose.runtime.ControlledComposition controlledComposition, int i2, Function0<? extends R> function03);

    @Override // androidx.compose.runtime.Composition
    public abstract void disposeUnusedMovableContent(androidx.compose.runtime.MovableContentState movableContentState);

    @Override // androidx.compose.runtime.Composition
    public abstract boolean getHasPendingChanges();

    public abstract void insertMovableContent(List<Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> list);

    @Override // androidx.compose.runtime.Composition
    public abstract void invalidateAll();

    @Override // androidx.compose.runtime.Composition
    public abstract boolean isComposing();

    public abstract boolean observesAnyOf(Set<? extends Object> set);

    public abstract void prepareCompose(Function0<Unit> function0);

    @Override // androidx.compose.runtime.Composition
    public abstract boolean recompose();

    public abstract void recordModificationsOf(Set<? extends Object> set);

    @Override // androidx.compose.runtime.Composition
    public abstract void recordReadOf(Object object);

    @Override // androidx.compose.runtime.Composition
    public abstract void recordWriteOf(Object object);

    @Override // androidx.compose.runtime.Composition
    public abstract void verifyConsistent();
}
