package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.o;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bJ\u0008\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k2 extends m implements kotlinx.coroutines.t1 {
    @Override // kotlinx.coroutines.internal.m
    public boolean a() {
        return 1;
    }

    @Override // kotlinx.coroutines.internal.m
    public kotlinx.coroutines.k2 e() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.m
    public String toString() {
        String string;
        if (q0.c()) {
            string = y("Active");
        } else {
            string = super.toString();
        }
        return string;
    }

    @Override // kotlinx.coroutines.internal.m
    public final String y(String string) {
        int i;
        boolean z;
        String str;
        Object obj5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List{");
        stringBuilder.append(string);
        stringBuilder.append("}[");
        obj5 = o();
        i = 1;
        while (!n.b(obj5, this)) {
            if (obj5 instanceof e2) {
            }
            obj5 = obj5.p();
            if (i != 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append((e2)obj5);
            i = 0;
        }
        stringBuilder.append("]");
        obj5 = stringBuilder.toString();
        n.e(obj5, "StringBuilder().apply(builderAction).toString()");
        return obj5;
    }
}
