package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008 \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u0016", d2 = {"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "job", "Lkotlinx/coroutines/JobSupport;", "getJob", "()Lkotlinx/coroutines/JobSupport;", "setJob", "(Lkotlinx/coroutines/JobSupport;)V", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class e2 extends kotlinx.coroutines.d0 implements kotlinx.coroutines.e1, kotlinx.coroutines.t1 {

    public kotlinx.coroutines.f2 v;
    @Override // kotlinx.coroutines.d0
    public final void A(kotlinx.coroutines.f2 f2) {
        this.v = f2;
    }

    @Override // kotlinx.coroutines.d0
    public boolean a() {
        return 1;
    }

    @Override // kotlinx.coroutines.d0
    public void dispose() {
        z().u0(this);
    }

    @Override // kotlinx.coroutines.d0
    public kotlinx.coroutines.k2 e() {
        return null;
    }

    @Override // kotlinx.coroutines.d0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r0.a(this));
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        stringBuilder.append("[job@");
        stringBuilder.append(r0.b(z()));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.d0
    public final kotlinx.coroutines.f2 z() {
        kotlinx.coroutines.f2 f2Var = this.v;
        if (f2Var == null) {
        } else {
            return f2Var;
        }
        n.w("job");
        throw 0;
    }
}
