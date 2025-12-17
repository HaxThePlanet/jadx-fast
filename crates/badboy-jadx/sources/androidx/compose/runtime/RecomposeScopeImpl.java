package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.RecomposeScopeObserver;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0000\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010;\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000eJ\u001c\u0010>\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0010\u0018\u00010?2\u0006\u0010A\u001a\u00020\u000fJ\u0008\u0010B\u001a\u00020\u0010H\u0016J\u0010\u0010C\u001a\u00020D2\u0008\u0010\u0016\u001a\u0004\u0018\u000103J\u0010\u0010E\u001a\u00020\u00122\u0008\u0010F\u001a\u0004\u0018\u000103J\u0015\u0010G\u001a\u00020H2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\u0008IJ\u001c\u0010J\u001a\u00020\u00102\n\u0010K\u001a\u0006\u0012\u0002\u0008\u0003022\u0008\u0010\u0016\u001a\u0004\u0018\u000103J\u000e\u0010L\u001a\u00020\u00122\u0006\u0010K\u001a\u000203J\u0006\u0010M\u001a\u00020\u0010J\u0006\u0010N\u001a\u00020\u0010J\u0006\u0010O\u001a\u00020\u0010J\u000e\u0010P\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u000fJ\"\u0010Q\u001a\u00020\u00102\u0018\u0010\u000c\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016J*\u0010R\u001a\u00020\u0012*\u0006\u0012\u0002\u0008\u0003022\u0018\u0010S\u001a\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u000302\u0012\u0006\u0012\u0004\u0018\u00010301H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\"\u0010\u000c\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0018\u0010\u0014\"\u0004\u0008\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001c\u0010\u0014\"\u0004\u0008\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008 \u0010\u0014\"\u0004\u0008!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0014R\u001a\u0010#\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008%\u0010&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008(\u0010\u0014\"\u0004\u0008)\u0010\u001aR$\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\u000c\u001a\u0004\u0008+\u0010\u0014\"\u0004\u0008,\u0010\u001aR$\u0010-\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128@@BX\u0080\u000e¢\u0006\u000c\u001a\u0004\u0008.\u0010\u0014\"\u0004\u0008/\u0010\u001aR\"\u00100\u001a\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u000302\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00087\u0010\u0014\"\u0004\u00088\u0010\u001aR\u0011\u00109\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008:\u0010\u0014¨\u0006U", d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "forcedRecompose", "getForcedRecompose", "setForcedRecompose", "isConditional", "observer", "Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "getObserver$annotations", "()V", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observe$runtime_release", "recordDerivedStateValue", "instance", "recordRead", "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "checkDerivedStateChanged", "dependencies", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecomposeScopeImpl implements androidx.compose.runtime.ScopeUpdateScope, androidx.compose.runtime.RecomposeScope {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.RecomposeScopeImpl.Companion Companion;
    private androidx.compose.runtime.Anchor anchor;
    private Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeObserver observer;
    private androidx.compose.runtime.RecomposeScopeOwner owner;
    private MutableScatterMap<androidx.compose.runtime.DerivedState<?>, Object> trackedDependencies;
    private MutableObjectIntMap<Object> trackedInstances;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0008\u000cJ#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0000¢\u0006\u0002\u0008\u0010¨\u0006\u0011", d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime_release", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final void adoptAnchoredScopes$runtime_release(androidx.compose.runtime.SlotWriter slots, List<androidx.compose.runtime.Anchor> anchors, androidx.compose.runtime.RecomposeScopeOwner newOwner) {
            boolean empty;
            int i;
            int index$iv;
            int size;
            Object obj;
            Object obj2;
            int i2;
            int slot;
            boolean z;
            if (!(Collection)anchors.isEmpty()) {
                empty = anchors;
                i = 0;
                index$iv = 0;
                while (index$iv < empty.size()) {
                    i2 = 0;
                    if (slot instanceof RecomposeScopeImpl) {
                    } else {
                    }
                    slot = 0;
                    if (slot != 0) {
                    }
                    index$iv++;
                    slot.adoptedBy(newOwner);
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime_release(androidx.compose.runtime.SlotTable slots, List<androidx.compose.runtime.Anchor> anchors) {
            int $this$fastAny$iv;
            int i4;
            int i5;
            Object obj5;
            int i6;
            int index$iv$iv;
            int size;
            int i;
            Object obj2;
            Object obj;
            int i2;
            int it;
            int i3;
            boolean ownsAnchor;
            final Object obj3 = slots;
            i4 = 0;
            if (!(Collection)anchors.isEmpty()) {
                i5 = 0;
                obj5 = obj4;
                i6 = 0;
                index$iv$iv = 0;
                i = 1;
                while (index$iv$iv < obj5.size()) {
                    i2 = 0;
                    Object obj6 = obj;
                    i3 = 0;
                    if (obj3.ownsAnchor((Anchor)obj6) && slot$runtime_release instanceof RecomposeScopeImpl) {
                    } else {
                    }
                    it = i4;
                    index$iv$iv++;
                    i = 1;
                    if (slot$runtime_release instanceof RecomposeScopeImpl) {
                    } else {
                    }
                    it = i;
                }
                $this$fastAny$iv = i4;
                if ($this$fastAny$iv != 0) {
                    i4 = i;
                } else {
                }
            } else {
            }
            return i4;
        }
    }
    static {
        RecomposeScopeImpl.Companion companion = new RecomposeScopeImpl.Companion(0);
        RecomposeScopeImpl.Companion = companion;
        int i = 8;
    }

    public RecomposeScopeImpl(androidx.compose.runtime.RecomposeScopeOwner owner) {
        super();
        this.owner = owner;
    }

    public static final int access$getCurrentToken$p(androidx.compose.runtime.RecomposeScopeImpl $this) {
        return $this.currentToken;
    }

    public static final RecomposeScopeObserver access$getObserver$p(androidx.compose.runtime.RecomposeScopeImpl $this) {
        return $this.observer;
    }

    public static final MutableScatterMap access$getTrackedDependencies$p(androidx.compose.runtime.RecomposeScopeImpl $this) {
        return $this.trackedDependencies;
    }

    public static final MutableObjectIntMap access$getTrackedInstances$p(androidx.compose.runtime.RecomposeScopeImpl $this) {
        return $this.trackedInstances;
    }

    public static final void access$setObserver$p(androidx.compose.runtime.RecomposeScopeImpl $this, RecomposeScopeObserver <set-?>) {
        $this.observer = <set-?>;
    }

    private final boolean checkDerivedStateChanged(androidx.compose.runtime.DerivedState<?> $this$checkDerivedStateChanged, MutableScatterMap<androidx.compose.runtime.DerivedState<?>, Object> dependencies) {
        androidx.compose.runtime.SnapshotMutationPolicy structuralEqualityPolicy;
        Intrinsics.checkNotNull($this$checkDerivedStateChanged, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        if ($this$checkDerivedStateChanged.getPolicy() == null) {
            structuralEqualityPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return equivalent ^= 1;
    }

    private static void getObserver$annotations() {
    }

    private final boolean getRereading() {
        int i;
        i = flags &= 32 != 0 ? 1 : 0;
        return i;
    }

    private final void setRereading(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 32;
        } else {
            this.flags = flags2 &= -33;
        }
    }

    private final void setSkipped(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 16;
        } else {
            this.flags = flags2 &= -17;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void adoptedBy(androidx.compose.runtime.RecomposeScopeOwner owner) {
        this.owner = owner;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void compose(androidx.compose.runtime.Composer composer) {
        int iNSTANCE;
        final Function2 block = this.block;
        final RecomposeScopeObserver observer = this.observer;
        Integer valueOf = 1;
        if (observer != null && block != null) {
            if (block != null) {
                observer.onBeginScopeComposition((RecomposeScope)this);
                block.invoke(composer, valueOf);
                observer.onEndScopeComposition((RecomposeScope)this);
            }
        }
        iNSTANCE = block != null ? Unit.INSTANCE : 0;
        if (iNSTANCE == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Invalid restart scope".toString());
        throw illegalStateException;
    }

    public final Function1<androidx.compose.runtime.Composition, Unit> end(int token) {
        androidx.compose.runtime.RecomposeScopeImpl.end.1.2 anon;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int instanceToken;
        int j$iv$iv$iv;
        int $i$f$isFull;
        MutableObjectIntMap map;
        int i11;
        Object[] keys;
        int[] values;
        MutableObjectIntMap map2;
        int i5;
        long[] metadata;
        int i;
        int i$iv$iv$iv;
        int i12;
        long slot$iv$iv$iv;
        MutableObjectIntMap $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i9;
        int cmp;
        int $i$a$LetRecomposeScopeImpl$end$1;
        int i2;
        Object obj;
        int i4;
        int i3;
        int i6;
        int i7;
        int i10;
        int i8;
        final Object obj2 = this;
        final int i13 = token;
        final MutableObjectIntMap trackedInstances = obj2.trackedInstances;
        if (trackedInstances != null) {
            instanceToken = 0;
            if (!obj2.getSkipped$runtime_release()) {
                j$iv$iv$iv = trackedInstances;
                map = j$iv$iv$iv;
                i11 = 0;
                i5 = 0;
                metadata = map2.metadata;
                length += -2;
                i12 = 0;
                if (0 <= i) {
                } else {
                    $i$a$LetRecomposeScopeImpl$end$1 = instanceToken;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
                    i9 = $i$f$isFull;
                }
                if (i12 != 0) {
                    anon = new RecomposeScopeImpl.end.1.2(obj2, i13, trackedInstances);
                } else {
                    anon = 0;
                }
            } else {
                $i$a$LetRecomposeScopeImpl$end$1 = instanceToken;
            }
        } else {
            anon = 0;
        }
        return anon;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final androidx.compose.runtime.Anchor getAnchor() {
        return this.anchor;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getCanRecompose() {
        int i;
        i = this.block != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getDefaultsInScope() {
        int i;
        i = flags &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getDefaultsInvalid() {
        int i;
        i = flags &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getForcedRecompose() {
        int i;
        i = flags &= 64 != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getRequiresRecompose() {
        int i;
        i = flags &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getSkipped$runtime_release() {
        int i;
        i = flags &= 16 != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getUsed() {
        int i;
        if (flags &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean getValid() {
        int owner;
        int i;
        if (this.owner != null) {
            androidx.compose.runtime.Anchor anchor = this.anchor;
            if (anchor != null) {
                owner = anchor.getValid();
            } else {
                owner = i;
            }
            if (owner != 0) {
                i = 1;
            }
        }
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void invalidate() {
        int i;
        final androidx.compose.runtime.RecomposeScopeOwner owner = this.owner;
        if (owner != null) {
            owner.invalidate(this, 0);
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final androidx.compose.runtime.InvalidationResult invalidateForResult(Object value) {
        androidx.compose.runtime.InvalidationResult iGNORED;
        iGNORED = this.owner;
        if (iGNORED != null) {
            if (iGNORED.invalidate(this, value) == null) {
                iGNORED = InvalidationResult.IGNORED;
            }
        } else {
        }
        return iGNORED;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean isConditional() {
        int i;
        i = this.trackedDependencies != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean isInvalidFor(Object instances) {
        Object obj4;
        boolean checkDerivedStateChanged;
        int cmp;
        int checkDerivedStateChanged2;
        MutableScatterMap trackedDependencies2;
        int trackedDependencies;
        boolean notEmpty;
        long j$iv$iv$iv;
        int $i$f$isFull;
        Object obj;
        int i6;
        Object[] elements;
        Object obj2;
        int i4;
        long[] metadata;
        int i5;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        MutableScatterMap $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int cmp2;
        int $i$f$any;
        long l;
        Object obj3;
        int i;
        Object it;
        int i3;
        int i2;
        final Object obj5 = this;
        obj4 = instances;
        cmp = 1;
        if (obj4 == null) {
            return cmp;
        }
        trackedDependencies2 = obj5.trackedDependencies;
        if (trackedDependencies2 == null) {
            return cmp;
        }
        if (obj4 instanceof DerivedState) {
            checkDerivedStateChanged2 = obj5.checkDerivedStateChanged((DerivedState)obj4, trackedDependencies2);
        } else {
            if (obj4 instanceof ScatterSet != null) {
                if ((ScatterSet)obj4.isNotEmpty()) {
                    obj = notEmpty;
                    i6 = 0;
                    i4 = 0;
                    metadata = obj2.metadata;
                    length += -2;
                    if (0 <= i5) {
                    } else {
                        $i$f$any = $i$f$isFull;
                        obj4 = 0;
                    }
                    checkDerivedStateChanged2 = obj4 != null ? 1 : 0;
                } else {
                }
            } else {
                checkDerivedStateChanged2 = 1;
            }
        }
        return checkDerivedStateChanged2;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final CompositionObserverHandle observe$runtime_release(RecomposeScopeObserver observer) {
        Object obj = RecomposeScopeImplKt.access$getCallbackLock$p();
        final int i = 0;
        int i2 = 0;
        this.observer = observer;
        Unit $i$a$SynchronizedRecomposeScopeImpl$observe$1 = Unit.INSTANCE;
        RecomposeScopeImpl.observe.2 lock$iv = new RecomposeScopeImpl.observe.2(this, observer);
        return (CompositionObserverHandle)lock$iv;
        synchronized (obj) {
            obj = RecomposeScopeImplKt.access$getCallbackLock$p();
            i = 0;
            i2 = 0;
            this.observer = observer;
            $i$a$SynchronizedRecomposeScopeImpl$observe$1 = Unit.INSTANCE;
            lock$iv = new RecomposeScopeImpl.observe.2(this, observer);
            return (CompositionObserverHandle)lock$iv;
        }
    }

    public final void recordDerivedStateValue(androidx.compose.runtime.DerivedState<?> instance, Object value) {
        MutableScatterMap trackedDependencies;
        MutableScatterMap map;
        int i2;
        int i;
        if (this.trackedDependencies == null) {
            trackedDependencies = new MutableScatterMap(0, 1, 0);
            i2 = 0;
            this.trackedDependencies = trackedDependencies;
        }
        trackedDependencies.set(instance, value);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final boolean recordRead(Object instance) {
        MutableObjectIntMap mutableObjectIntMap;
        MutableObjectIntMap map;
        int i;
        final int i2 = 0;
        if (getRereading()) {
            return i2;
        }
        final int i3 = 1;
        if (this.trackedInstances == null) {
            mutableObjectIntMap = new MutableObjectIntMap(i2, i3, 0);
            i = 0;
            this.trackedInstances = mutableObjectIntMap;
        }
        if (mutableObjectIntMap.put(instance, this.currentToken, -1) == this.currentToken) {
            return i3;
        }
        return i2;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void release() {
        Object obj;
        androidx.compose.runtime.RecomposeScopeOwner owner = this.owner;
        if (owner != null) {
            owner.recomposeScopeReleased(this);
        }
        int i = 0;
        this.owner = i;
        this.trackedInstances = i;
        this.trackedDependencies = i;
        RecomposeScopeObserver observer = this.observer;
        if (observer != null) {
            observer.onScopeDisposed((RecomposeScope)this);
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void rereadTrackedInstances() {
        androidx.compose.runtime.RecomposeScopeOwner $this$maskEmptyOrDeleted$iv$iv$iv;
        Object obj2;
        Object obj;
        androidx.compose.runtime.RecomposeScopeOwner recomposeScopeOwner;
        int i8;
        MutableObjectIntMap map3;
        int i2;
        int j$iv$iv;
        MutableObjectIntMap $i$f$isFull;
        int i5;
        Object[] keys;
        int[] values;
        MutableObjectIntMap map;
        int i3;
        long[] metadata;
        int i7;
        int i$iv$iv;
        long slot$iv$iv;
        long l2;
        MutableObjectIntMap map2;
        int cmp;
        long l;
        int i4;
        int i6;
        int i;
        obj = this;
        $this$maskEmptyOrDeleted$iv$iv$iv = obj.owner;
        i8 = 0;
        $this$maskEmptyOrDeleted$iv$iv$iv = obj.trackedInstances;
        if ($this$maskEmptyOrDeleted$iv$iv$iv != null && $this$maskEmptyOrDeleted$iv$iv$iv != null) {
            i8 = 0;
            $this$maskEmptyOrDeleted$iv$iv$iv = obj.trackedInstances;
            if ($this$maskEmptyOrDeleted$iv$iv$iv != null) {
                i2 = 0;
                obj.setRereading(true);
                $i$f$isFull = map3;
                i5 = 0;
                i3 = 0;
                metadata = map.metadata;
                length += -2;
                if (0 <= i7) {
                } else {
                    map2 = $i$f$isFull;
                }
                try {
                    this.setRereading(false);
                    obj2.setRereading(false);
                    throw th;
                } catch (Throwable th) {
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void scopeSkipped() {
        setSkipped(true);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void setAnchor(androidx.compose.runtime.Anchor <set-?>) {
        this.anchor = <set-?>;
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void setDefaultsInScope(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 2;
        } else {
            this.flags = flags2 &= -3;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void setDefaultsInvalid(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 4;
        } else {
            this.flags = flags2 &= -5;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void setForcedRecompose(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 64;
        } else {
            this.flags = flags2 &= -65;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void setRequiresRecompose(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 8;
        } else {
            this.flags = flags2 &= -9;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void setUsed(boolean value) {
        int i;
        if (value != null) {
            this.flags = flags |= 1;
        } else {
            this.flags = flags2 &= -2;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    public void updateScope(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> block) {
        this.block = block;
    }
}
