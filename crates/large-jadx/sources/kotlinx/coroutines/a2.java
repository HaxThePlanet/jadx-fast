package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0000\u0008\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u000c\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class a2 extends kotlinx.coroutines.f2 implements kotlinx.coroutines.z {

    private final boolean b;
    public a2(kotlinx.coroutines.y1 y1) {
        super(1);
        f0(y1);
        this.b = G0();
    }

    private final boolean G0() {
        int vVar2;
        kotlinx.coroutines.f2 f2Var;
        int vVar;
        boolean z;
        final int i3 = 0;
        if (vVar2 instanceof w) {
        } else {
            vVar2 = i3;
        }
        int i2 = 0;
        if (vVar2 == 0) {
            return i2;
        }
        f2Var = vVar2.z();
        while (f2Var.Y()) {
            if (vVar instanceof w) {
            } else {
            }
            vVar = i3;
            f2Var = vVar.z();
        }
        return 1;
    }

    @Override // kotlinx.coroutines.f2
    public boolean Y() {
        return this.b;
    }

    @Override // kotlinx.coroutines.f2
    public boolean Z() {
        return 1;
    }
}
