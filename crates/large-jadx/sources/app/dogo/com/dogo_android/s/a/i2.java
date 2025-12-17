package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.CertificateUrlModel;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.firebase.firestore.FirebaseFirestore;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetCertificateInfoInteractor;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "certificateInfoMapper", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "programId", "", "it", "Lapp/dogo/com/dogo_android/model/CertificateUrlModel;", "getCertificateInfo", "Lio/reactivex/Single;", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i2 {

    private final FirebaseFirestore a;
    public i2(FirebaseFirestore firebaseFirestore) {
        n.f(firebaseFirestore, "firestore");
        super();
        this.a = firebaseFirestore;
    }

    private final CertificateInfo a(String string, CertificateUrlModel certificateUrlModel2) {
        String str;
        String str2;
        String certificateImageUrl = certificateUrlModel2.getCertificateImageUrl();
        String str3 = "";
        str = certificateImageUrl == null ? str3 : certificateImageUrl;
        final String obj10 = certificateUrlModel2.getCertificatePdfUrl();
        str2 = obj10 == null ? str3 : obj10;
        super(string, str, str2, 0, 8, 0);
        return certificateInfo2;
    }

    private static final CertificateInfo c(app.dogo.com.dogo_android.s.a.i2 i2, String string2, CertificateUrlModel certificateUrlModel3) {
        n.f(i2, "this$0");
        n.f(string2, "$programId");
        n.f(certificateUrlModel3, "it");
        return i2.a(string2, certificateUrlModel3);
    }

    public static CertificateInfo d(app.dogo.com.dogo_android.s.a.i2 i2, String string2, CertificateUrlModel certificateUrlModel3) {
        return i2.c(i2, string2, certificateUrlModel3);
    }

    public final a0<CertificateInfo> b(String string, String string2) {
        n.f(string, "programId");
        n.f(string2, "dogId");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dogs/");
        stringBuilder.append(string2);
        stringBuilder.append("/programs/");
        stringBuilder.append(string);
        com.google.firebase.firestore.DocumentReference obj5 = this.a.document(stringBuilder.toString());
        n.e(obj5, "firestore.document(\"dogs/$dogId/programs/$programId\")");
        i iVar = new i(this, string);
        final a0 obj4 = j1.h(obj5, CertificateUrlModel.class).map(iVar);
        n.e(obj4, "firestore.document(\"dogs/$dogId/programs/$programId\")\n            .createSingle(CertificateUrlModel::class.java).map {\n                certificateInfoMapper(programId, it)\n            }");
        return obj4;
    }
}
