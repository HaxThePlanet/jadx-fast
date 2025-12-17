package app.dogo.com.dogo_android.inappmessaging;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo;
import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.z0;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B/\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0013\u001a\u00020\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "rating", "", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfo", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "(ILapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;)V", "getExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "getExtras", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "getRating", "()I", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.inappmessaging.j> CREATOR;
    private final int a;
    private final InAppMessageDataHolder b;
    private final InAppFeedbackExtras c;
    private final ExamHistorySaveInfo v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.inappmessaging.j> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.inappmessaging.j a(Parcel parcel) {
            int fromParcel;
            Object fromParcel2;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel = fromParcel2;
            } else {
                fromParcel = InAppFeedbackExtras.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() == 0) {
            } else {
                fromParcel2 = ExamHistorySaveInfo.CREATOR.createFromParcel(parcel);
            }
            j jVar = new j(parcel.readInt(), (InAppMessageDataHolder)InAppMessageDataHolder.CREATOR.createFromParcel(parcel), (InAppFeedbackExtras)fromParcel, (ExamHistorySaveInfo)fromParcel2);
            return jVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.inappmessaging.j[] b(int i) {
            return new j[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        j.a aVar = new j.a();
        j.CREATOR = aVar;
    }

    public j(int i, InAppMessageDataHolder inAppMessageDataHolder2, InAppFeedbackExtras inAppFeedbackExtras3, ExamHistorySaveInfo examHistorySaveInfo4) {
        n.f(inAppMessageDataHolder2, "messageData");
        super();
        this.a = i;
        this.b = inAppMessageDataHolder2;
        this.c = inAppFeedbackExtras3;
        this.v = examHistorySaveInfo4;
    }

    public j(int i, InAppMessageDataHolder inAppMessageDataHolder2, InAppFeedbackExtras inAppFeedbackExtras3, ExamHistorySaveInfo examHistorySaveInfo4, int i5, g g6) {
        int obj2;
        int obj4;
        int obj5;
        obj2 = i5 & 1 != 0 ? 0 : obj2;
        final int i2 = 0;
        obj4 = i5 & 4 != 0 ? i2 : obj4;
        obj5 = i5 &= 8 != 0 ? i2 : obj5;
        super(obj2, inAppMessageDataHolder2, obj4, obj5);
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final ExamHistorySaveInfo a() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final InAppFeedbackExtras b() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final InAppMessageDataHolder c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        i iVar = new i();
        return iVar;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        z0 z0Var = new z0();
        return j3.V0.b(z0Var, this.b.getCampaignId());
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final int d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(this.a);
        this.b.writeToParcel(parcel, i2);
        InAppFeedbackExtras inAppFeedbackExtras = this.c;
        final int i3 = 0;
        final int i4 = 1;
        if (inAppFeedbackExtras == null) {
            parcel.writeInt(i3);
        } else {
            parcel.writeInt(i4);
            inAppFeedbackExtras.writeToParcel(parcel, i2);
        }
        ExamHistorySaveInfo examHistorySaveInfo = this.v;
        if (examHistorySaveInfo == null) {
            parcel.writeInt(i3);
        } else {
            parcel.writeInt(i4);
            examHistorySaveInfo.writeToParcel(parcel, i2);
        }
    }
}
