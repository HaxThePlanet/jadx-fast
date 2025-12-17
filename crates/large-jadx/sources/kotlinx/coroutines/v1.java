package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0016R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class v1 extends kotlinx.coroutines.n {

    private final l<Throwable, w> a;
    public v1(l<? super Throwable, w> l) {
        super();
        this.a = l;
    }

    @Override // kotlinx.coroutines.n
    public void a(Throwable throwable) {
        this.a.invoke(throwable);
    }

    @Override // kotlinx.coroutines.n
    public Object invoke(Object object) {
        a((Throwable)object);
        return w.a;
    }

    @Override // kotlinx.coroutines.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InvokeOnCancel[");
        stringBuilder.append(r0.a(this.a));
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
