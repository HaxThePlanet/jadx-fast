package f.c.a.f.a.a;

import android.os.RemoteException;
import com.google.android.play.core.internal.d2;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class p extends i {

    final /* synthetic */ String b;
    final /* synthetic */ o c;
    final /* synthetic */ s v;
    p(s sVar, o oVar, String str, o oVar2) {
        this.v = sVar;
        this.b = str;
        this.c = oVar2;
        super(oVar);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            (d2)this.v.a.e().X0(this.v.b, s.b(this.v, this.b), new r(this.v, this.c, this.b));
        } catch (android.os.RemoteException remote) {
            h hVar = s.e;
            int runtimeException = 1;
            runtimeException = new Object[runtimeException];
            int str2 = 0;
            runtimeException[str2] = this.b;
            str2 = "requestUpdateInfo(%s)";
            hVar.c(remote, str2, runtimeException);
            runtimeException = new RuntimeException(remote);
            this.c.d(runtimeException);
            return;
        }
    }
}
