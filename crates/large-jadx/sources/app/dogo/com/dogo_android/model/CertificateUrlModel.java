package app.dogo.com.dogo_android.model;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/model/CertificateUrlModel;", "", "certificateImageUrl", "", "certificatePdfUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CertificateUrlModel {

    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    public CertificateUrlModel() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public CertificateUrlModel(String string, String string2) {
        super();
        this.certificateImageUrl = string;
        this.certificatePdfUrl = string2;
    }

    public CertificateUrlModel(String string, String string2, int i3, g g4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3);
    }

    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }
}
