package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.v;
import i.b.w;
import i.b.y;

/* compiled from: ObservableLift.java */
/* loaded from: classes3.dex */
public final class u1<R, T> extends a<T, R> {

    final v<? extends R, ? super T> b;
    public u1(w<T> wVar, v<? extends R, ? super T> vVar) {
        super(wVar);
        this.b = vVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super R> yVar) {
        try {
            final y yVar2 = this.b.a(yVar);
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Operator ";
            String str4 = " returned a null Observer";
            str = str3 + this.b + str4;
            b.e(yVar2, str);
        } catch (java.lang.NullPointerException npe) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) npe;
        } finally {
            a.b(npe);
            a.t(npe);
            java.lang.NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(npe);
            throw nullPointerException;
        }
        this.a.subscribe(yVar2);
    }
}
