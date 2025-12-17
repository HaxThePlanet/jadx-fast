package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InactiveNodeList implements kotlinx.coroutines.Incomplete {

    private final kotlinx.coroutines.NodeList list;
    public InactiveNodeList(kotlinx.coroutines.NodeList list) {
        super();
        this.list = list;
    }

    @Override // kotlinx.coroutines.Incomplete
    public kotlinx.coroutines.NodeList getList() {
        return this.list;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return 0;
    }

    @Override // kotlinx.coroutines.Incomplete
    public String toString() {
        String string;
        String str;
        if (DebugKt.getDEBUG()) {
            string = getList().getString("New");
        } else {
            string = super.toString();
        }
        return string;
    }
}
