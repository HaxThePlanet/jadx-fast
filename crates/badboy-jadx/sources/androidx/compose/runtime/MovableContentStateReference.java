package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008\u0007\u0018\u00002\u00020\u0001B]\u0008\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\u000c\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001c\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R.\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!¨\u0006\"", d2 = {"Landroidx/compose/runtime/MovableContentStateReference;", "", "content", "Landroidx/compose/runtime/MovableContent;", "parameter", "composition", "Landroidx/compose/runtime/ControlledComposition;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidations", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "locals", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/MovableContent;Ljava/lang/Object;Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/Anchor;Ljava/util/List;Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "getAnchor$runtime_release", "()Landroidx/compose/runtime/Anchor;", "getComposition$runtime_release", "()Landroidx/compose/runtime/ControlledComposition;", "getContent$runtime_release", "()Landroidx/compose/runtime/MovableContent;", "getInvalidations$runtime_release", "()Ljava/util/List;", "setInvalidations$runtime_release", "(Ljava/util/List;)V", "getLocals$runtime_release", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getParameter$runtime_release", "()Ljava/lang/Object;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MovableContentStateReference {

    public static final int $stable = 8;
    private final androidx.compose.runtime.Anchor anchor;
    private final androidx.compose.runtime.ControlledComposition composition;
    private final androidx.compose.runtime.MovableContent<Object> content;
    private List<? extends Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends Object>> invalidations;
    private final androidx.compose.runtime.PersistentCompositionLocalMap locals;
    private final Object parameter;
    private final androidx.compose.runtime.SlotTable slotTable;
    static {
        final int i = 8;
    }

    public MovableContentStateReference(androidx.compose.runtime.MovableContent<Object> content, Object parameter, androidx.compose.runtime.ControlledComposition composition, androidx.compose.runtime.SlotTable slotTable, androidx.compose.runtime.Anchor anchor, List<? extends Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends Object>> invalidations, androidx.compose.runtime.PersistentCompositionLocalMap locals) {
        super();
        this.content = content;
        this.parameter = parameter;
        this.composition = composition;
        this.slotTable = slotTable;
        this.anchor = anchor;
        this.invalidations = invalidations;
        this.locals = locals;
    }

    public final androidx.compose.runtime.Anchor getAnchor$runtime_release() {
        return this.anchor;
    }

    public final androidx.compose.runtime.ControlledComposition getComposition$runtime_release() {
        return this.composition;
    }

    public final androidx.compose.runtime.MovableContent<Object> getContent$runtime_release() {
        return this.content;
    }

    public final List<Pair<androidx.compose.runtime.RecomposeScopeImpl, Object>> getInvalidations$runtime_release() {
        return this.invalidations;
    }

    public final androidx.compose.runtime.PersistentCompositionLocalMap getLocals$runtime_release() {
        return this.locals;
    }

    public final Object getParameter$runtime_release() {
        return this.parameter;
    }

    public final androidx.compose.runtime.SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final void setInvalidations$runtime_release(List<? extends Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends Object>> <set-?>) {
        this.invalidations = <set-?>;
    }
}
