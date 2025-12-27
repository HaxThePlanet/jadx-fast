package f.c.a.d.b.j;

import android.text.TextUtils;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;

/* loaded from: classes2.dex */
final class k extends j.b {

    private final /* synthetic */ byte[] q;
    private final /* synthetic */ String r;
    k(d dVar, byte[] bArr, String str) {
        this.q = bArr;
        this.r = str;
        super(dVar);
    }

    @Override // f.c.a.d.b.j.j$b
    protected final /* synthetic */ void l(a.b bVar) {
        String str;
        if (TextUtils.isEmpty(this.r)) {
            str = bVar.c("com.google.android.safetynet.ATTEST_API_KEY");
        }
        (h)bVar.getService().Y(this.p, this.q, str);
    }
}
