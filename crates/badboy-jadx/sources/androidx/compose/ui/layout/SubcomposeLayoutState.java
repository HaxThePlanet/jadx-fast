package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction;
import androidx.compose.ui.unit.Constraints;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001:\u0001&B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0008\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\r\u0010\u001d\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0008\u001eJ(\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\u00012\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u000f0#¢\u0006\u0002\u0008$¢\u0006\u0002\u0010%R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0002\u0008\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012RB\u0010\u0013\u001a0\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u000c¢\u0006\u0002\u0008\u0010\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0002\u0008\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R+\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0002\u0008\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006'", d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState;", "", "()V", "maxSlotsToRetainForReuse", "", "(I)V", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "_state", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setCompositionContext", "Lkotlin/Function2;", "Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/CompositionContext;", "", "Lkotlin/ExtensionFunctionType;", "getSetCompositionContext$ui_release", "()Lkotlin/jvm/functions/Function2;", "setMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "getSetMeasurePolicy$ui_release", "setRoot", "getSetRoot$ui_release", "state", "getState", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "forceRecomposeChildren", "forceRecomposeChildren$ui_release", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "PrecomposedSlotHandle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubcomposeLayoutState {

    public static final int $stable = 8;
    private androidx.compose.ui.layout.LayoutNodeSubcompositionsState _state;
    private final Function2<LayoutNode, CompositionContext, Unit> setCompositionContext;
    private final Function2<LayoutNode, Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult>, Unit> setMeasurePolicy;
    private final Function2<LayoutNode, androidx.compose.ui.layout.SubcomposeLayoutState, Unit> setRoot;
    private final androidx.compose.ui.layout.SubcomposeSlotReusePolicy slotReusePolicy;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ&\u0010\u000e\u001a\u00020\u00072\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0014À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "", "placeablesCount", "", "getPlaceablesCount", "()I", "dispose", "", "premeasure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "premeasure-0kLqBqw", "(IJ)V", "traverseDescendants", "key", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PrecomposedSlotHandle {
        public abstract void dispose();

        public int getPlaceablesCount() {
            return 0;
        }

        public void premeasure-0kLqBqw(int index, long constraints) {
        }

        public void traverseDescendants(Object key, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> block) {
        }
    }
    static {
        final int i = 8;
    }

    public SubcomposeLayoutState() {
        super((SubcomposeSlotReusePolicy)NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    @Deprecated(message = "This constructor is deprecated", replaceWith = @ReplaceWith(...))
    public SubcomposeLayoutState(int maxSlotsToRetainForReuse) {
        super(SubcomposeLayoutKt.SubcomposeSlotReusePolicy(maxSlotsToRetainForReuse));
    }

    public SubcomposeLayoutState(androidx.compose.ui.layout.SubcomposeSlotReusePolicy slotReusePolicy) {
        super();
        this.slotReusePolicy = slotReusePolicy;
        SubcomposeLayoutState.setRoot.1 anon = new SubcomposeLayoutState.setRoot.1(this);
        this.setRoot = (Function2)anon;
        SubcomposeLayoutState.setCompositionContext.1 anon2 = new SubcomposeLayoutState.setCompositionContext.1(this);
        this.setCompositionContext = (Function2)anon2;
        SubcomposeLayoutState.setMeasurePolicy.1 anon3 = new SubcomposeLayoutState.setMeasurePolicy.1(this);
        this.setMeasurePolicy = (Function2)anon3;
    }

    public static final androidx.compose.ui.layout.SubcomposeSlotReusePolicy access$getSlotReusePolicy$p(androidx.compose.ui.layout.SubcomposeLayoutState $this) {
        return $this.slotReusePolicy;
    }

    public static final androidx.compose.ui.layout.LayoutNodeSubcompositionsState access$getState(androidx.compose.ui.layout.SubcomposeLayoutState $this) {
        return $this.getState();
    }

    public static final void access$set_state$p(androidx.compose.ui.layout.SubcomposeLayoutState $this, androidx.compose.ui.layout.LayoutNodeSubcompositionsState <set-?>) {
        $this._state = <set-?>;
    }

    private final androidx.compose.ui.layout.LayoutNodeSubcompositionsState getState() {
        androidx.compose.ui.layout.LayoutNodeSubcompositionsState _state = this._state;
        if (_state == null) {
        } else {
            return _state;
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireNotNullSubcomposeLayoutState$state$1 = new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
        throw $i$a$RequireNotNullSubcomposeLayoutState$state$1;
    }

    public final void forceRecomposeChildren$ui_release() {
        getState().forceRecomposeChildren();
    }

    public final Function2<LayoutNode, CompositionContext, Unit> getSetCompositionContext$ui_release() {
        return this.setCompositionContext;
    }

    public final Function2<LayoutNode, Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult>, Unit> getSetMeasurePolicy$ui_release() {
        return this.setMeasurePolicy;
    }

    public final Function2<LayoutNode, androidx.compose.ui.layout.SubcomposeLayoutState, Unit> getSetRoot$ui_release() {
        return this.setRoot;
    }

    public final androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        return getState().precompose(slotId, content);
    }
}
