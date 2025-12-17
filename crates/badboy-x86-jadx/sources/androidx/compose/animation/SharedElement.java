package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#J\u0008\u0010/\u001a\u00020\u0013H\u0002J\u0006\u00100\u001a\u00020\u0013J(\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206ø\u0001\u0000¢\u0006\u0004\u00087\u00108J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#J\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010;\u001a\u00020\u001eR/\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR/\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u000e\u001a\u0004\u0008\u0010\u0010\n\"\u0004\u0008\u0011\u0010\u000cR+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0019\u0010\u000e\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0017\u0010!\u001a\u0008\u0012\u0004\u0012\u00020#0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\u0008'\u0010\nR\"\u0010(\u001a\u0004\u0018\u00010#2\u0008\u0010\u0006\u001a\u0004\u0018\u00010#@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0,X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006<", d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "<set-?>", "Landroidx/compose/ui/geometry/Rect;", "_targetBounds", "get_targetBounds", "()Landroidx/compose/ui/geometry/Rect;", "set_targetBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "_targetBounds$delegate", "Landroidx/compose/runtime/MutableState;", "currentBounds", "getCurrentBounds", "setCurrentBounds", "currentBounds$delegate", "", "foundMatch", "getFoundMatch", "()Z", "setFoundMatch", "(Z)V", "foundMatch$delegate", "getKey", "()Ljava/lang/Object;", "observingVisibilityChange", "Lkotlin/Function0;", "", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/SharedElementInternalState;", "getStates", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "targetBounds", "getTargetBounds", "targetBoundsProvider", "getTargetBoundsProvider$animation_release", "()Landroidx/compose/animation/SharedElementInternalState;", "updateMatch", "Lkotlin/Function1;", "addState", "sharedElementState", "hasVisibleContent", "isAnimating", "onLookaheadResult", "state", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "onLookaheadResult-v_w8tDc", "(Landroidx/compose/animation/SharedElementInternalState;JJ)V", "onSharedTransitionFinished", "removeState", "updateTargetBoundsProvider", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedElement {

    public static final int $stable = 8;
    private final MutableState _targetBounds$delegate;
    private final MutableState currentBounds$delegate;
    private final MutableState foundMatch$delegate;
    private final Object key;
    private final Function0<Unit> observingVisibilityChange;
    private final androidx.compose.animation.SharedTransitionScopeImpl scope;
    private final SnapshotStateList<androidx.compose.animation.SharedElementInternalState> states;
    private androidx.compose.animation.SharedElementInternalState targetBoundsProvider;
    private final Function1<androidx.compose.animation.SharedElement, Unit> updateMatch;
    static {
        final int i = 8;
    }

    public SharedElement(Object key, androidx.compose.animation.SharedTransitionScopeImpl scope) {
        super();
        this.key = key;
        this.scope = scope;
        int i = 0;
        final int i2 = 2;
        this._targetBounds$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.foundMatch$delegate = SnapshotStateKt.mutableStateOf$default(false, i, i2, i);
        this.currentBounds$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.states = SnapshotStateKt.mutableStateListOf();
        SharedElement.updateMatch.1 anon = new SharedElement.updateMatch.1(this);
        this.updateMatch = (Function1)anon;
        SharedElement.observingVisibilityChange.1 anon2 = new SharedElement.observingVisibilityChange.1(this);
        this.observingVisibilityChange = (Function0)anon2;
    }

    public static final boolean access$hasVisibleContent(androidx.compose.animation.SharedElement $this) {
        return $this.hasVisibleContent();
    }

    private final Rect get_targetBounds() {
        final int i = 0;
        final int i2 = 0;
        return (Rect)(State)this._targetBounds$delegate.getValue();
    }

    private final boolean hasVisibleContent() {
        int index$iv$iv;
        int i2;
        Object obj;
        Object obj2;
        int i;
        boolean it;
        int i3;
        androidx.compose.animation.BoundsAnimation boundsAnimation;
        final int i4 = 0;
        final SnapshotStateList list = states;
        final int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i = 0;
            i3 = 0;
            index$iv$iv++;
        }
        i2 = 0;
        return i2;
    }

    private final void setFoundMatch(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.foundMatch$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void set_targetBounds(Rect <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._targetBounds$delegate.setValue(<set-?>);
    }

    public final void addState(androidx.compose.animation.SharedElementInternalState sharedElementState) {
        this.states.add(sharedElementState);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final Rect getCurrentBounds() {
        final int i = 0;
        final int i2 = 0;
        return (Rect)(State)this.currentBounds$delegate.getValue();
    }

    public final boolean getFoundMatch() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.foundMatch$delegate.getValue().booleanValue();
    }

    public final Object getKey() {
        return this.key;
    }

    public final androidx.compose.animation.SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final SnapshotStateList<androidx.compose.animation.SharedElementInternalState> getStates() {
        return this.states;
    }

    public final Rect getTargetBounds() {
        Rect $this$_get_targetBounds__u24lambda_u241;
        int i;
        long lookaheadOffset-F1C5BW0;
        long nonNullLookaheadSize-NH-jbRc;
        androidx.compose.animation.SharedElementInternalState targetBoundsProvider = this.targetBoundsProvider;
        if (targetBoundsProvider != null) {
            i = 0;
            $this$_get_targetBounds__u24lambda_u241 = RectKt.Rect-tz77jQw(targetBoundsProvider.calculateLookaheadOffset-F1C5BW0(), obj3);
        } else {
            $this$_get_targetBounds__u24lambda_u241 = 0;
        }
        set_targetBounds($this$_get_targetBounds__u24lambda_u241);
        return get_targetBounds();
    }

    public final androidx.compose.animation.SharedElementInternalState getTargetBoundsProvider$animation_release() {
        return this.targetBoundsProvider;
    }

    public final boolean isAnimating() {
        int $this$fastAny$iv;
        int index$iv$iv;
        int i;
        int i4;
        Object obj2;
        Object obj;
        int i2;
        boolean it;
        int i3;
        androidx.compose.animation.BoundsAnimation boundsAnimation;
        final int i5 = 0;
        final SnapshotStateList list = states;
        final int i6 = 0;
        index$iv$iv = 0;
        i4 = 1;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i3 = 0;
            index$iv$iv++;
            i4 = 1;
        }
        $this$fastAny$iv = i;
        if ($this$fastAny$iv != 0 && getFoundMatch()) {
            if (getFoundMatch()) {
                i = i4;
            } else {
            }
        } else {
        }
        return i;
    }

    public final void onLookaheadResult-v_w8tDc(androidx.compose.animation.SharedElementInternalState state, long lookaheadSize, long topLeft) {
        int box-impl2;
        boolean size-NH-jbRc;
        int box-impl;
        long equals-impl0;
        long index$iv;
        long size;
        Object obj;
        Object obj2;
        int i;
        androidx.compose.animation.BoundsAnimation boundsAnimation;
        Rect currentBounds;
        if (state.getBoundsAnimation().getTarget()) {
            this.targetBoundsProvider = state;
            Rect rect = get_targetBounds();
            box-impl = 0;
            if (rect != null) {
                box-impl2 = Offset.box-impl(rect.getTopLeft-F1C5BW0());
            } else {
                box-impl2 = box-impl;
            }
            if (box-impl2 == 0) {
                size-NH-jbRc = equals-impl0;
            } else {
                size-NH-jbRc = Offset.equals-impl0(box-impl2.unbox-impl(), obj4);
            }
            if (size-NH-jbRc) {
                size-NH-jbRc = get_targetBounds();
                if (size-NH-jbRc != null) {
                    box-impl = Size.box-impl(size-NH-jbRc.getSize-NH-jbRc());
                }
                if (box-impl == 0) {
                } else {
                    equals-impl0 = Size.equals-impl0(box-impl.unbox-impl(), box-impl);
                }
                if (equals-impl0 == 0) {
                    size-NH-jbRc = RectKt.Rect-tz77jQw(obj14, obj15);
                    set_targetBounds(size-NH-jbRc);
                    box-impl = this.states;
                    equals-impl0 = 0;
                    index$iv = 0;
                    while (index$iv < (List)box-impl.size()) {
                        i = 0;
                        currentBounds = getCurrentBounds();
                        Intrinsics.checkNotNull(currentBounds);
                        (SharedElementInternalState)box-impl.get(index$iv).getBoundsAnimation().animate(currentBounds, size-NH-jbRc);
                        index$iv++;
                    }
                }
            } else {
            }
        }
    }

    public final void onSharedTransitionFinished() {
        int visibleContent;
        int i;
        if (this.states.size() > 1 && hasVisibleContent()) {
            if (hasVisibleContent()) {
            } else {
                i = 0;
            }
        } else {
        }
        setFoundMatch(i);
        set_targetBounds(0);
    }

    public final void removeState(androidx.compose.animation.SharedElementInternalState sharedElementState) {
        SnapshotStateObserver sharedTransitionObserver;
        Function1 updateMatch;
        Function0 observingVisibilityChange;
        this.states.remove(sharedElementState);
        if (this.states.isEmpty()) {
            updateMatch();
            SharedTransitionScopeKt.getSharedTransitionObserver().clear(this);
        } else {
            SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
        }
    }

    public final void setCurrentBounds(Rect <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentBounds$delegate.setValue(<set-?>);
    }

    public final void updateMatch() {
        boolean transitionActive;
        boolean sharedTransitionObserver;
        int updateMatch;
        Function0 observingVisibilityChange;
        final boolean visibleContent = hasVisibleContent();
        updateMatch = 1;
        if (this.states.size() > updateMatch && visibleContent) {
            if (visibleContent) {
                setFoundMatch(updateMatch);
            } else {
                updateMatch = 0;
                if (this.scope.isTransitionActive()) {
                    if (!visibleContent) {
                        setFoundMatch(updateMatch);
                    }
                } else {
                    setFoundMatch(updateMatch);
                }
            }
        } else {
        }
        if (!(Collection)this.states.isEmpty()) {
            SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
        }
    }

    public final void updateTargetBoundsProvider() {
        int targetProvider;
        int i;
        int i3;
        Object obj;
        Object obj2;
        int i2;
        boolean target;
        targetProvider = 0;
        SnapshotStateList states = this.states;
        final int i5 = 0;
        if (size-- >= 0) {
        }
        if (Intrinsics.areEqual(targetProvider, this.targetBoundsProvider)) {
        }
        this.targetBoundsProvider = targetProvider;
        set_targetBounds(0);
    }
}
