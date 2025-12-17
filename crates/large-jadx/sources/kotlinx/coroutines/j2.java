package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\u0008\u001a\u0004\u0018\u00010\u0007H\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\t", d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class j2 extends kotlinx.coroutines.h0 {
    @Override // kotlinx.coroutines.h0
    public abstract kotlinx.coroutines.j2 M();

    @Override // kotlinx.coroutines.h0
    protected final String T() {
        kotlinx.coroutines.j2 j2Var;
        kotlinx.coroutines.j2 j2Var2 = c1.c();
        if (this == j2Var2) {
            return "Dispatchers.Main";
        }
        j2Var = j2Var2.M();
        if (this == j2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.h0
    public String toString() {
        String string;
        String str;
        if (T() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(r0.a(this));
            stringBuilder.append('@');
            stringBuilder.append(r0.b(this));
            string = stringBuilder.toString();
        }
        return string;
    }
}
