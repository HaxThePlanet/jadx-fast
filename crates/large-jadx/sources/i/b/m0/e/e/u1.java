package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.p0.a;
import i.b.v;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class u1<R, T>  extends i.b.m0.e.e.a<T, R> {

    final v<? extends R, ? super T> b;
    public u1(w<T> w, v<? extends R, ? super T> v2) {
        super(w);
        this.b = v2;
    }

    public void subscribeActual(y<? super R> y) {
        try {
            final y obj3 = this.b.a(y);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Operator ");
            stringBuilder.append(this.b);
            stringBuilder.append(" returned a null Observer");
            b.e(obj3, stringBuilder.toString());
            this.a.subscribe((y)obj3);
            a.b(y);
            a.t(y);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(y);
            throw nullPointerException;
            throw y;
        }
    }
}
