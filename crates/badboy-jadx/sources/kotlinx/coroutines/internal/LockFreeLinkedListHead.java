package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u0008\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0007\u001a\u00020\u0008\"\u000e\u0008\u0000\u0010\t\u0018\u0001*\u00060\u0001j\u0002`\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00080\u000cH\u0086\u0008J\u0010\u0010\r\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\nH\u0014J\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0010\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0005¨\u0006\u0012", d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "isRemoved", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "nextIfRemoved", "remove", "", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LockFreeLinkedListHead extends kotlinx.coroutines.internal.LockFreeLinkedListNode {
    public final <T extends kotlinx.coroutines.internal.LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> block) {
        Object cur;
        String str;
        String str2;
        final int i = 0;
        Intrinsics.checkNotNull(getNext(), "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        while (!Intrinsics.areEqual(cur, this)) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (cur instanceof LockFreeLinkedListNode != null) {
            }
            cur = cur.getNextNode();
            block.invoke(cur);
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean isEmpty() {
        int i;
        i = getNext() == this ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean isRemoved() {
        return 0;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    protected kotlinx.coroutines.internal.LockFreeLinkedListNode nextIfRemoved() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final Void remove() {
        IllegalStateException illegalStateException = new IllegalStateException("head cannot be removed".toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean remove() {
        return (Boolean)remove().booleanValue();
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final void validate$kotlinx_coroutines_core() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode prev;
        Object cur;
        kotlinx.coroutines.internal.LockFreeLinkedListNode nextNode;
        prev = this;
        final String str = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }";
        Intrinsics.checkNotNull(getNext(), str);
        while (!Intrinsics.areEqual(cur, this)) {
            nextNode = cur.getNextNode();
            cur.validateNode$kotlinx_coroutines_core(prev, nextNode);
            prev = cur;
            cur = nextNode;
        }
        Object next = getNext();
        Intrinsics.checkNotNull(next, str);
        validateNode$kotlinx_coroutines_core(prev, (LockFreeLinkedListNode)next);
    }
}
