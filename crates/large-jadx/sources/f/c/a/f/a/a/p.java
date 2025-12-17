package f.c.a.f.a.a;

import com.google.android.play.core.internal.d2;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class p extends i {

    final String b;
    final o c;
    final f.c.a.f.a.a.s v;
    p(f.c.a.f.a.a.s s, o o2, String string3, o o4) {
        this.v = s;
        this.b = string3;
        this.c = o4;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            r rVar = new r(this.v, this.c, this.b);
            (d2)sVar.a.e().X0(s.f(this.v), s.b(this.v, this.b), rVar);
            h hVar = s.d();
            int runtimeException = 1;
            runtimeException = new Object[runtimeException];
            int str2 = 0;
            runtimeException[str2] = this.b;
            str2 = "requestUpdateInfo(%s)";
            hVar.c(th, str2, runtimeException);
            hVar = this.c;
            runtimeException = new RuntimeException(th);
            hVar.d(runtimeException);
        }
    }
}
