package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.CertificateUrlModel;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.firebase.firestore.FirebaseFirestore;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: GetCertificateInfoInteractor.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetCertificateInfoInteractor;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "certificateInfoMapper", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "programId", "", "it", "Lapp/dogo/com/dogo_android/model/CertificateUrlModel;", "getCertificateInfo", "Lio/reactivex/Single;", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i2, reason: from kotlin metadata */
public final class GetCertificateInfoInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseFirestore firestore;
    public i2(FirebaseFirestore firebaseFirestore) {
        n.f(firebaseFirestore, "firestore");
        super();
        this.firestore = firebaseFirestore;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final CertificateInfo certificateInfoMapper(String programId, CertificateUrlModel it) {
        String it2;
        it2 = it.getCertificateImageUrl();
        it2 = "";
        String r2 = it2;
        it2 = it.getCertificatePdfUrl();
        String r3 = it2;
        CertificateInfo certificateInfo = new CertificateInfo(programId, it2, it2, null, 8, null);
        return certificateInfo;
    }

    private static final CertificateInfo c(i2 i2Var, String str, CertificateUrlModel certificateUrlModel) {
        n.f(i2Var, "this$0");
        n.f(str, "$programId");
        n.f(certificateUrlModel, "it");
        return i2Var.certificateInfoMapper(str, certificateUrlModel);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final a0<CertificateInfo> getCertificateInfo(String programId, String dogId) {
        n.f(programId, "programId");
        n.f(dogId, "dogId");
        final StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "dogs/";
        String str5 = "/programs/";
        str6 = str4 + dogId + str5 + programId;
        com.google.firebase.firestore.DocumentReference document = this.firestore.document(str6);
        n.e(document, "firestore.document(\"dogs/$dogId/programs/$programId\")");
        final a0 map = app.dogo.com.dogo_android.util.extensionfunction.j1.h(document, CertificateUrlModel.class).map(new kotlinx.coroutines.i(this, programId));
        n.e(map, "firestore.document(\"dogs/$dogId/programs/$programId\")\n            .createSingle(CertificateUrlModel::class.java).map {\n                certificateInfoMapper(programId, it)\n            }");
        return map;
    }

    public static /* synthetic */ CertificateInfo d(i2 i2Var, String str, CertificateUrlModel certificateUrlModel) {
        return GetCertificateInfoInteractor.c(i2Var, str, certificateUrlModel);
    }
}
