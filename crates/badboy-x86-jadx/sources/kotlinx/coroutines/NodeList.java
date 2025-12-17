package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bJ\u0008\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NodeList extends LockFreeLinkedListHead implements kotlinx.coroutines.Incomplete {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListHead
    public kotlinx.coroutines.NodeList getList() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListHead
    public final String getString(String state) {
        int first;
        Object cur$iv;
        String str;
        int i;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i2 = 0;
        sb.append("List{");
        sb.append(state);
        sb.append("}[");
        int i3 = 0;
        first = 1;
        Object obj = this;
        final int i4 = 0;
        Intrinsics.checkNotNull((LockFreeLinkedListHead)obj.getNext(), "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        while (!Intrinsics.areEqual(cur$iv, obj)) {
            if (cur$iv instanceof JobNode) {
            }
            cur$iv = cur$iv.getNextNode();
            i = 0;
            if (first != 0) {
            } else {
            }
            sb.append(", ");
            sb.append((JobNode)cur$iv);
            first = 0;
        }
        sb.append("]");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListHead
    public boolean isActive() {
        return 1;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListHead
    public String toString() {
        String string;
        if (DebugKt.getDEBUG()) {
            string = getString("Active");
        } else {
            string = super.toString();
        }
        return string;
    }
}
