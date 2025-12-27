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

/* compiled from: InAppOneTenScreen.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfo", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "(Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;)V", "getExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "getExtras", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class InAppOneTenScreen extends e {

    public static final Parcelable.Creator<m> CREATOR = new m$a<>();
    private final InAppMessageDataHolder a;
    /* renamed from: b, reason: from kotlin metadata */
    private final InAppFeedbackExtras extras;
    private final ExamHistorySaveInfo c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<m> {
        public final m a(Parcel parcel) {
            InAppFeedbackExtras inAppFeedbackExtras;
            ExamHistorySaveInfo examHistorySaveInfo = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
            } else {
                Object fromParcel2 = InAppFeedbackExtras.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0) {
                Object fromParcel3 = ExamHistorySaveInfo.CREATOR.createFromParcel(parcel);
            }
            InAppOneTenScreen inAppOneTenScreen = new InAppOneTenScreen((InAppMessageDataHolder)InAppMessageDataHolder.CREATOR.createFromParcel(parcel), (InAppFeedbackExtras)inAppFeedbackExtras, (ExamHistorySaveInfo)examHistorySaveInfo);
            return inAppOneTenScreen;
        }

        public final m[] b(int i) {
            return new m[i];
        }
    }
    public m(InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras, ExamHistorySaveInfo examHistorySaveInfo) {
        n.f(inAppMessageDataHolder, "messageData");
        super();
        this.a = inAppMessageDataHolder;
        this.extras = inAppFeedbackExtras;
        this.c = examHistorySaveInfo;
    }

    @Override // app.dogo.com.dogo_android.util.e
    /* renamed from: a, reason: from kotlin metadata */
    public final ExamHistorySaveInfo createFragment() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final InAppFeedbackExtras b() {
        return this.extras;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final InAppMessageDataHolder c() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        return new InAppOneTenFragmentDialog();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.emailAuthentication.b(new EP_CampaignId(), this.a.getCampaignId());
    }

    public /* synthetic */ m(InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras, ExamHistorySaveInfo examHistorySaveInfo, int i, g gVar) {
        i = 0;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        this(inAppMessageDataHolder, inAppFeedbackExtras, examHistorySaveInfo);
    }


    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
        final int i = 0;
        final int i2 = 1;
        if (this.extras == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            this.extras.writeToParcel(parcel, flags);
        }
        if (this.c == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            this.c.writeToParcel(parcel, flags);
        }
    }
}
