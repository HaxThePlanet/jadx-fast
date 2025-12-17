package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0017\u0018\u00002\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0017\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\u0008\u0004\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0019H\u0086\u0008J \u0010\u001a\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010\u001b\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ\u001b\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0082\u0010J\u0019\u0010\u001f\u001a\u00060\u0000j\u0002`\u000f2\n\u0010 \u001a\u00060\u0000j\u0002`\u000fH\u0082\u0010J\u0014\u0010!\u001a\u00020\u00152\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J%\u0010\"\u001a\u00020#2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\u0008\u0004\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0019H\u0081\u0008J\u0010\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0014J\u0008\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0001J\u0008\u0010'\u001a\u00020\u0007H\u0002J\u0008\u0010(\u001a\u00020)H\u0016J(\u0010*\u001a\u00020+2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010,\u001a\u00020#H\u0001J%\u0010-\u001a\u00020\u00152\n\u0010.\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000¢\u0006\u0002\u0008/R\u000f\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004R\u000f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004R\u0011\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0011¨\u00061", d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "findPrevNonRemoved", "current", "finishAdd", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "remove", "removeOrNext", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "prev", "validateNode$kotlinx_coroutines_core", "CondAddOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LockFreeLinkedListNode {

    private static final AtomicReferenceFieldUpdater _next$FU;
    private static final AtomicReferenceFieldUpdater _prev$FU;
    private static final AtomicReferenceFieldUpdater _removedRef$FU;
    @Volatile
    private volatile Object _next;
    @Volatile
    private volatile Object _prev;
    @Volatile
    private volatile Object _removedRef;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0008!\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00082\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class CondAddOp extends kotlinx.coroutines.internal.AtomicOp<kotlinx.coroutines.internal.LockFreeLinkedListNode> {

        public final kotlinx.coroutines.internal.LockFreeLinkedListNode newNode;
        public kotlinx.coroutines.internal.LockFreeLinkedListNode oldNext;
        public CondAddOp(kotlinx.coroutines.internal.LockFreeLinkedListNode newNode) {
            super();
            this.newNode = newNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object affected, Object failure) {
            complete((LockFreeLinkedListNode)affected, failure);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(kotlinx.coroutines.internal.LockFreeLinkedListNode affected, Object failure) {
            int i;
            kotlinx.coroutines.internal.LockFreeLinkedListNode oldNext;
            boolean newNode;
            kotlinx.coroutines.internal.LockFreeLinkedListNode oldNext2;
            i = failure == null ? 1 : 0;
            oldNext = i != 0 ? this.newNode : this.oldNext;
            if (oldNext != null && AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.access$get_next$FU$p(), affected, this, oldNext) && i != 0) {
                if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.access$get_next$FU$p(), affected, this, oldNext)) {
                    if (i != 0) {
                        oldNext2 = this.oldNext;
                        Intrinsics.checkNotNull(oldNext2);
                        LockFreeLinkedListNode.access$finishAdd(this.newNode, oldNext2);
                    }
                }
            }
        }
    }
    static {
        final Class<kotlinx.coroutines.internal.LockFreeLinkedListNode> obj4 = LockFreeLinkedListNode.class;
        LockFreeLinkedListNode._next$FU = AtomicReferenceFieldUpdater.newUpdater(obj4, Object.class, "_next");
        LockFreeLinkedListNode._prev$FU = AtomicReferenceFieldUpdater.newUpdater(obj4, Object.class, "_prev");
        LockFreeLinkedListNode._removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(obj4, Object.class, "_removedRef");
    }

    public LockFreeLinkedListNode() {
        super();
        this._next = this;
        this._prev = this;
    }

    public static final void access$finishAdd(kotlinx.coroutines.internal.LockFreeLinkedListNode $this, kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
        $this.finishAdd(next);
    }

    public static final AtomicReferenceFieldUpdater access$get_next$FU$p() {
        return LockFreeLinkedListNode._next$FU;
    }

    private final kotlinx.coroutines.internal.LockFreeLinkedListNode correctPrev(kotlinx.coroutines.internal.OpDescriptor op) {
        Object prev;
        int last;
        Object obj;
        Object str;
        kotlinx.coroutines.internal.LockFreeLinkedListNode ref;
        while (/* condition */) {
            obj = LockFreeLinkedListNode._next$FU.get(prev);
            while (obj == this) {
                if (obj instanceof Removed) {
                    break loop_1;
                } else {
                }
                last = prev;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                prev = obj;
                obj = LockFreeLinkedListNode._next$FU.get(prev);
                if (last != 0) {
                    break loop_1;
                } else {
                }
                prev = str;
                if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, last, prev, obj3.ref)) {
                    break loop_1;
                } else {
                }
                prev = last;
                last = 0;
            }
            if (obj instanceof OpDescriptor) {
            } else {
            }
            if (obj instanceof Removed) {
            } else {
            }
            last = prev;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            prev = obj;
            if (last != 0) {
            } else {
            }
            prev = str;
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, last, prev, obj3.ref)) {
            } else {
            }
            prev = last;
            last = 0;
            Object obj2 = LockFreeLinkedListNode._prev$FU.get(this);
            prev = obj2;
            last = 0;
            (OpDescriptor)obj.perform(prev);
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._prev$FU, this, (LockFreeLinkedListNode)obj2, prev)) {
            }
        }
        return prev;
    }

    private final kotlinx.coroutines.internal.LockFreeLinkedListNode findPrevNonRemoved(kotlinx.coroutines.internal.LockFreeLinkedListNode current) {
        Object obj;
        Object obj2;
        while (!obj2.isRemoved()) {
            obj2 = obj;
        }
        return obj2;
    }

    private final void finishAdd(kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
        Object obj;
        int i;
        boolean z;
        boolean removed;
        final Object obj2 = this;
        final int i2 = 0;
        i = 0;
        while (getNext() != next) {
            i = 0;
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final kotlinx.coroutines.internal.Removed removed() {
        Object removed2;
        kotlinx.coroutines.internal.Removed removed;
        int i;
        AtomicReferenceFieldUpdater _removedRef$FU;
        if ((Removed)LockFreeLinkedListNode._removedRef$FU.get(this) == null) {
            removed2 = new Removed(this);
            i = 0;
            LockFreeLinkedListNode._removedRef$FU.lazySet(this, removed2);
        }
        return removed2;
    }

    public final void addLast(kotlinx.coroutines.internal.LockFreeLinkedListNode node) {
        boolean next;
        while (getPrevNode().addNext(node, this)) {
        }
    }

    public final boolean addLastIf(kotlinx.coroutines.internal.LockFreeLinkedListNode node, Function0<Boolean> condition) {
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode;
        int tryCondAddNext;
        final int i = 0;
        prevNode = this;
        tryCondAddNext = 0;
        LockFreeLinkedListNode.makeCondAddOp.1 anon = new LockFreeLinkedListNode.makeCondAddOp.1(node, condition);
        while (/* condition */) {
        }
        return 1;
    }

    public final boolean addNext(kotlinx.coroutines.internal.LockFreeLinkedListNode node, kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
        LockFreeLinkedListNode._prev$FU.lazySet(node, this);
        LockFreeLinkedListNode._next$FU.lazySet(node, next);
        if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, this, next, node)) {
            return 0;
        }
        node.finishAdd(next);
        return 1;
    }

    public final boolean addOneIfEmpty(kotlinx.coroutines.internal.LockFreeLinkedListNode node) {
        AtomicReferenceFieldUpdater _next$FU;
        boolean z;
        LockFreeLinkedListNode._prev$FU.lazySet(node, this);
        LockFreeLinkedListNode._next$FU.lazySet(node, this);
        while (getNext() != this) {
        }
        return 0;
    }

    public final Object getNext() {
        Object obj;
        int i;
        Object obj2;
        final Object obj3 = this;
        final int i2 = 0;
        obj = LockFreeLinkedListNode._next$FU.get(this);
        i = 0;
        while (!obj instanceof OpDescriptor) {
            (OpDescriptor)obj.perform(this);
            obj = _next$FU.get(this);
            i = 0;
        }
        return obj;
    }

    public final kotlinx.coroutines.internal.LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final kotlinx.coroutines.internal.LockFreeLinkedListNode getPrevNode() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNonRemoved;
        if (correctPrev(0) == null) {
            prevNonRemoved = findPrevNonRemoved((LockFreeLinkedListNode)LockFreeLinkedListNode._prev$FU.get(this));
        }
        return prevNonRemoved;
    }

    public boolean isRemoved() {
        return next instanceof Removed;
    }

    public final kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp makeCondAddOp(kotlinx.coroutines.internal.LockFreeLinkedListNode node, Function0<Boolean> condition) {
        final int i = 0;
        LockFreeLinkedListNode.makeCondAddOp.1 anon = new LockFreeLinkedListNode.makeCondAddOp.1(node, condition);
        return (LockFreeLinkedListNode.CondAddOp)anon;
    }

    protected kotlinx.coroutines.internal.LockFreeLinkedListNode nextIfRemoved() {
        Object next;
        int ref;
        if (next instanceof Removed) {
        } else {
            next = ref;
        }
        if (next != null) {
            ref = next.ref;
        }
        return ref;
    }

    public boolean remove() {
        int i;
        i = removeOrNext() == null ? 1 : 0;
        return i;
    }

    public final kotlinx.coroutines.internal.LockFreeLinkedListNode removeOrNext() {
        Object next;
        kotlinx.coroutines.internal.Removed removed;
        boolean z;
        next = getNext();
        while (next instanceof Removed) {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            next = getNext();
        }
        return obj3.ref;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LockFreeLinkedListNode.toString.1 anon = new LockFreeLinkedListNode.toString.1(this);
        return stringBuilder.append(anon).append('@').append(DebugStringsKt.getHexAddress(this)).toString();
    }

    public final int tryCondAddNext(kotlinx.coroutines.internal.LockFreeLinkedListNode node, kotlinx.coroutines.internal.LockFreeLinkedListNode next, kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp condAdd) {
        int i;
        LockFreeLinkedListNode._prev$FU.lazySet(node, this);
        LockFreeLinkedListNode._next$FU.lazySet(node, next);
        condAdd.oldNext = next;
        if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, this, next, condAdd)) {
            return 0;
        }
        i = condAdd.perform(this) == null ? 1 : 2;
        return i;
    }

    public final void validateNode$kotlinx_coroutines_core(kotlinx.coroutines.internal.LockFreeLinkedListNode prev, kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
        int $i$a$AssertLockFreeLinkedListNode$validateNode$1;
        boolean aSSERTIONS_ENABLED;
        int i;
        Object obj;
        final int i3 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i2 = 0;
            $i$a$AssertLockFreeLinkedListNode$validateNode$1 = prev == LockFreeLinkedListNode._prev$FU.get(this) ? i : i3;
            if ($i$a$AssertLockFreeLinkedListNode$validateNode$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (next == LockFreeLinkedListNode._next$FU.get(this)) {
            } else {
                i = i3;
            }
            if (i == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
    }
}
