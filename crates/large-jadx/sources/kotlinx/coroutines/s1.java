package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s1 implements kotlinx.coroutines.t1 {

    private final kotlinx.coroutines.k2 a;
    public s1(kotlinx.coroutines.k2 k2) {
        super();
        this.a = k2;
    }

    @Override // kotlinx.coroutines.t1
    public boolean a() {
        return 0;
    }

    @Override // kotlinx.coroutines.t1
    public kotlinx.coroutines.k2 e() {
        return this.a;
    }

    @Override // kotlinx.coroutines.t1
    public String toString() {
        String string;
        String str;
        if (q0.c()) {
            string = e().y("New");
        } else {
            string = super.toString();
        }
        return string;
    }
}
