package app.dogo.com.dogo_android.u.m.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;

/* compiled from: SpecialProgramCertificateScreen.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/certificate/SpecialProgramCertificateScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "certificateData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "programId", "", "source", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCertificateData", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "getFragmentReturnTag", "()Ljava/lang/String;", "getProgramId", "getSource", "component1", "component2", "component3", "component4", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final /* data */ class SpecialProgramCertificateScreen extends j {

    public static final Parcelable.Creator<f> CREATOR = new f$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final SpecialProgramOverviewItem.CertificateData certificateData;
    /* renamed from: b, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    /* renamed from: c, reason: from kotlin metadata */
    private final String programId;
    /* renamed from: v, reason: from kotlin metadata */
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<f> {
        public final f a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SpecialProgramCertificateScreen((SpecialProgramOverviewItem_CertificateData)SpecialProgramOverviewItem_CertificateData.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final f[] b(int i) {
            return new f[i];
        }
    }
    public f(SpecialProgramOverviewItem.CertificateData certificateData, String str, String str2, String str3) {
        n.f(certificateData, "certificateData");
        n.f(str, "programId");
        n.f(str2, "source");
        n.f(str3, "fragmentReturnTag");
        super();
        this.certificateData = certificateData;
        this.fragmentReturnTag = str;
        this.programId = str2;
        this.source = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final SpecialProgramOverviewItem.CertificateData component1() {
        return this.certificateData;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new SpecialProgramCertificateFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.programDescriptionScreen.c(u.a(new EP_ViewSource(), this.programId));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.source;
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof SpecialProgramCertificateScreen)) {
            return false;
        }
        if (!n.b(this.certificateData, other.certificateData)) {
            return false;
        }
        if (!n.b(this.fragmentReturnTag, other.fragmentReturnTag)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        return !n.b(getFragmentReturnTag(), other.getFragmentReturnTag()) ? z6 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        return (this.certificateData.hashCode() * 31) + this.fragmentReturnTag.hashCode() * 31 + this.programId.hashCode() * 31 + getFragmentReturnTag().hashCode();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SpecialProgramCertificateScreen(certificateData=";
        String str3 = ", programId=";
        String str4 = ", source=";
        String str5 = ", fragmentReturnTag=";
        String fragmentReturnTag = getFragmentReturnTag();
        str = str2 + this.certificateData + str3 + this.fragmentReturnTag + str4 + this.programId + str5 + fragmentReturnTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.certificateData.writeToParcel(parcel, flags);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.programId);
        parcel.writeString(this.source);
    }
}
