package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class f1 extends kotlinx.coroutines.n {

    private final kotlinx.coroutines.e1 a;
    public f1(kotlinx.coroutines.e1 e1) {
        super();
        this.a = e1;
    }

    @Override // kotlinx.coroutines.n
    public void a(Throwable throwable) {
        this.a.dispose();
    }

    @Override // kotlinx.coroutines.n
    public Object invoke(Object object) {
        a((Throwable)object);
        return w.a;
    }

    @Override // kotlinx.coroutines.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DisposeOnCancel[");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
