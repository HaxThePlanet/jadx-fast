package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a$\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0008H\u0007\u001a\u001c\u0010\u0014\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a$\u0010\u0014\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0008H\u0007\u001a\u001a\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0004\u0008\u0000\u0010\u0018*\u00020\u000f2\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00180\u0001H\u0000¢\u0006\u0002\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002\u001a(\u0010\u001b\u001a\u00020\u001c\"\u0004\u0008\u0000\u0010\u0018*\u0008\u0012\u0004\u0012\u0002H\u00180!2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0007\u001a\u00020\u0008*\u00020\t8GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"CompositionImplServiceKey", "Landroidx/compose/runtime/CompositionServiceKey;", "Landroidx/compose/runtime/CompositionImpl;", "getCompositionImplServiceKey", "()Landroidx/compose/runtime/CompositionServiceKey;", "PendingApplyNoModifications", "", "recomposeCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/ControlledComposition;", "getRecomposeCoroutineContext$annotations", "(Landroidx/compose/runtime/ControlledComposition;)V", "getRecomposeCoroutineContext", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/coroutines/CoroutineContext;", "Composition", "Landroidx/compose/runtime/Composition;", "applier", "Landroidx/compose/runtime/Applier;", "parent", "Landroidx/compose/runtime/CompositionContext;", "ControlledComposition", "ReusableComposition", "Landroidx/compose/runtime/ReusableComposition;", "getCompositionService", "T", "key", "(Landroidx/compose/runtime/Composition;Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "swap", "", "Landroidx/collection/MutableIntList;", "a", "", "b", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompositionKt {

    private static final androidx.compose.runtime.CompositionServiceKey<androidx.compose.runtime.CompositionImpl> CompositionImplServiceKey;
    private static final Object PendingApplyNoModifications;
    static {
        Object object = new Object();
        CompositionKt.PendingApplyNoModifications = object;
        CompositionKt.CompositionImplServiceKey.1 anon = new CompositionKt.CompositionImplServiceKey.1();
        CompositionKt.CompositionImplServiceKey = (CompositionServiceKey)anon;
    }

    public static final androidx.compose.runtime.Composition Composition(androidx.compose.runtime.Applier<?> applier, androidx.compose.runtime.CompositionContext parent) {
        CompositionImpl compositionImpl = new CompositionImpl(parent, applier, 0, 4, 0);
        return (Composition)compositionImpl;
    }

    public static final androidx.compose.runtime.Composition Composition(androidx.compose.runtime.Applier<?> applier, androidx.compose.runtime.CompositionContext parent, CoroutineContext recomposeCoroutineContext) {
        CompositionImpl compositionImpl = new CompositionImpl(parent, applier, recomposeCoroutineContext);
        return (Composition)compositionImpl;
    }

    public static final androidx.compose.runtime.ControlledComposition ControlledComposition(androidx.compose.runtime.Applier<?> applier, androidx.compose.runtime.CompositionContext parent) {
        CompositionImpl compositionImpl = new CompositionImpl(parent, applier, 0, 4, 0);
        return (ControlledComposition)compositionImpl;
    }

    public static final androidx.compose.runtime.ControlledComposition ControlledComposition(androidx.compose.runtime.Applier<?> applier, androidx.compose.runtime.CompositionContext parent, CoroutineContext recomposeCoroutineContext) {
        CompositionImpl compositionImpl = new CompositionImpl(parent, applier, recomposeCoroutineContext);
        return (ControlledComposition)compositionImpl;
    }

    public static final androidx.compose.runtime.ReusableComposition ReusableComposition(androidx.compose.runtime.Applier<?> applier, androidx.compose.runtime.CompositionContext parent) {
        CompositionImpl compositionImpl = new CompositionImpl(parent, applier, 0, 4, 0);
        return (ReusableComposition)compositionImpl;
    }

    public static final Object access$getPendingApplyNoModifications$p() {
        return CompositionKt.PendingApplyNoModifications;
    }

    public static final void access$swap(MutableIntList $receiver, int a, int b) {
        CompositionKt.swap($receiver, a, b);
    }

    public static final void access$swap(List $receiver, int a, int b) {
        CompositionKt.swap($receiver, a, b);
    }

    public static final androidx.compose.runtime.CompositionServiceKey<androidx.compose.runtime.CompositionImpl> getCompositionImplServiceKey() {
        return CompositionKt.CompositionImplServiceKey;
    }

    public static final <T> T getCompositionService(androidx.compose.runtime.Composition $this$getCompositionService, androidx.compose.runtime.CompositionServiceKey<T> key) {
        Object obj;
        int compositionService;
        if ($this$getCompositionService instanceof CompositionServices) {
            obj = $this$getCompositionService;
        } else {
            obj = compositionService;
        }
        if (obj != null) {
            compositionService = obj.getCompositionService(key);
        }
        return compositionService;
    }

    public static final CoroutineContext getRecomposeCoroutineContext(androidx.compose.runtime.ControlledComposition $this$recomposeCoroutineContext) {
        Object recomposeContext;
        if ($this$recomposeCoroutineContext instanceof CompositionImpl) {
            recomposeContext = $this$recomposeCoroutineContext;
        } else {
            recomposeContext = 0;
        }
        if (recomposeContext != null) {
            if (recomposeContext.getRecomposeContext() == null) {
                recomposeContext = EmptyCoroutineContext.INSTANCE;
            }
        } else {
        }
        return recomposeContext;
    }

    public static void getRecomposeCoroutineContext$annotations(androidx.compose.runtime.ControlledComposition controlledComposition) {
    }

    private static final void swap(MutableIntList $this$swap, int a, int b) {
        $this$swap.set(a, $this$swap.get(b));
        $this$swap.set(b, $this$swap.get(a));
    }

    private static final <T> void swap(List<T> $this$swap, int a, int b) {
        $this$swap.set(a, $this$swap.get(b));
        $this$swap.set(b, $this$swap.get(a));
    }
}
