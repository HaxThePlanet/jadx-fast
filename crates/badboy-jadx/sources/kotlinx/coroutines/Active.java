package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/Active;", "Lkotlinx/coroutines/NotCompleted;", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Active implements kotlinx.coroutines.NotCompleted {

    public static final kotlinx.coroutines.Active INSTANCE;
    static {
        Active active = new Active();
        Active.INSTANCE = active;
    }

    @Override // kotlinx.coroutines.NotCompleted
    public String toString() {
        return "Active";
    }
}
