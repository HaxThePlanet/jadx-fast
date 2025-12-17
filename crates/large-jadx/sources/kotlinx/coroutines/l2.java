package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "parent", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l2 implements kotlinx.coroutines.e1, kotlinx.coroutines.v {

    public static final kotlinx.coroutines.l2 a;
    static {
        l2 l2Var = new l2();
        l2.a = l2Var;
    }

    @Override // kotlinx.coroutines.e1
    public boolean c(Throwable throwable) {
        return 0;
    }

    @Override // kotlinx.coroutines.e1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.e1
    public kotlinx.coroutines.y1 getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.e1
    public String toString() {
        return "NonDisposableHandle";
    }
}
