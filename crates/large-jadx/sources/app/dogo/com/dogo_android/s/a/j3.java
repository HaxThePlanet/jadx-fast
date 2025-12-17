package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.service.i2;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/RequestCertificateInfoInteractor;", "", "cloudFunction", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "(Lapp/dogo/com/dogo_android/service/CloudFunctionsService;)V", "getCertificateInfo", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "programId", "", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j3 {

    private final i2 a;
    public j3(i2 i2) {
        n.f(i2, "cloudFunction");
        super();
        this.a = i2;
    }

    public final a0<CertificateInfo> a(String string, String string2) {
        n.f(string, "programId");
        n.f(string2, "dogId");
        return this.a.i(string, string2);
    }
}
