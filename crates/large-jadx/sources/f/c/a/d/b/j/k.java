package f.c.a.d.b.j;

import android.text.TextUtils;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;

/* loaded from: classes2.dex */
final class k extends f.c.a.d.b.j.j.b {

    private final byte[] q;
    private final String r;
    k(d d, byte[] b2Arr2, String string3) {
        this.q = b2Arr2;
        this.r = string3;
        super(d);
    }

    @Override // f.c.a.d.b.j.j$b
    protected final void l(a.b a$b) {
        String str;
        if (TextUtils.isEmpty(this.r)) {
            str = (m)b.c("com.google.android.safetynet.ATTEST_API_KEY");
        }
        (h)b.getService().Y(this.p, this.q, str);
    }
}
