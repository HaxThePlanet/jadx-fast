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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfo", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "(Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;)V", "getExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "getExtras", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.inappmessaging.m> CREATOR;
    private final InAppMessageDataHolder a;
    private final InAppFeedbackExtras b;
    private final ExamHistorySaveInfo c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.inappmessaging.m> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.inappmessaging.m a(Parcel parcel) {
            int fromParcel2;
            Object fromParcel;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel2 = fromParcel;
            } else {
                fromParcel2 = InAppFeedbackExtras.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() == 0) {
            } else {
                fromParcel = ExamHistorySaveInfo.CREATOR.createFromParcel(parcel);
            }
            m mVar = new m((InAppMessageDataHolder)InAppMessageDataHolder.CREATOR.createFromParcel(parcel), (InAppFeedbackExtras)fromParcel2, (ExamHistorySaveInfo)fromParcel);
            return mVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.inappmessaging.m[] b(int i) {
            return new m[i];
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
        m.a aVar = new m.a();
        m.CREATOR = aVar;
    }

    public m(InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras2, ExamHistorySaveInfo examHistorySaveInfo3) {
        n.f(inAppMessageDataHolder, "messageData");
        super();
        this.a = inAppMessageDataHolder;
        this.b = inAppFeedbackExtras2;
        this.c = examHistorySaveInfo3;
    }

    public m(InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras2, ExamHistorySaveInfo examHistorySaveInfo3, int i4, g g5) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(inAppMessageDataHolder, obj3, obj4);
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final ExamHistorySaveInfo a() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final InAppFeedbackExtras b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final InAppMessageDataHolder c() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        l lVar = new l();
        return lVar;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        z0 z0Var = new z0();
        return j3.W0.b(z0Var, this.a.getCampaignId());
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        InAppFeedbackExtras inAppFeedbackExtras = this.b;
        final int i = 0;
        final int i3 = 1;
        if (inAppFeedbackExtras == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            inAppFeedbackExtras.writeToParcel(parcel, i2);
        }
        ExamHistorySaveInfo examHistorySaveInfo = this.c;
        if (examHistorySaveInfo == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            examHistorySaveInfo.writeToParcel(parcel, i2);
        }
    }
}
