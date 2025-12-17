package okhttp3.logging;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;
import l.f;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Ll/f;", "", "isProbablyUtf8", "(Ll/f;)Z", "okhttp-logging-interceptor"}, k = 2, mv = {1, 4, 0})
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(f f) {
        int i;
        f whitespace;
        int iSOControl;
        n.f(f, "$this$isProbablyUtf8");
        int i2 = 0;
        f fVar = new f();
        f.j(fVar, 0, obj4);
        i = i2;
        while (i < 16) {
            whitespace = fVar.M();
            i++;
        }
        return 1;
    }
}
