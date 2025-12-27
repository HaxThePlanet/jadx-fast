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

/* compiled from: InAppFeedbackScreen.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B/\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0013\u001a\u00020\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "rating", "", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfo", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "(ILapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;)V", "getExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "getExtras", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "getRating", "()I", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class InAppFeedbackScreen extends e {

    public static final Parcelable.Creator<j> CREATOR = new j$a<>();
    private final int a;
    private final InAppMessageDataHolder b;
    private final InAppFeedbackExtras c;
    private final ExamHistorySaveInfo v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<j> {
        public final j a(Parcel parcel) {
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
            InAppFeedbackScreen inAppFeedbackScreen = new InAppFeedbackScreen(parcel.readInt(), (InAppMessageDataHolder)InAppMessageDataHolder.CREATOR.createFromParcel(parcel), (InAppFeedbackExtras)inAppFeedbackExtras, (ExamHistorySaveInfo)examHistorySaveInfo);
            return inAppFeedbackScreen;
        }

        public final j[] b(int i) {
            return new j[i];
        }
    }
    public j(int i, InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras, ExamHistorySaveInfo examHistorySaveInfo) {
        n.f(inAppMessageDataHolder, "messageData");
        super();
        this.a = i;
        this.b = inAppMessageDataHolder;
        this.c = inAppFeedbackExtras;
        this.v = examHistorySaveInfo;
    }

    @Override // app.dogo.com.dogo_android.util.e
    /* renamed from: a, reason: from kotlin metadata */
    public final ExamHistorySaveInfo createFragment() {
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
        return new InAppFeedbackFragmentDialog();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.dogOwners.b(new EP_CampaignId(), this.b.getCampaignId());
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final int d() {
        return this.a;
    }

    public /* synthetic */ j(int i, InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras, ExamHistorySaveInfo examHistorySaveInfo, int i2, g gVar) {
        int i3 = 0;
        if (i2 & 1 != 0) {
            i3 = 0;
        }
        i2 = 0;
        i2 = i2 & 4 != 0 ? i2 : i2;
        i2 = i2 & 8 != 0 ? i2 : i2;
        this(i3, inAppMessageDataHolder, inAppFeedbackExtras, examHistorySaveInfo);
    }


    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.a);
        this.b.writeToParcel(parcel, flags);
        final int i2 = 0;
        final int i3 = 1;
        if (this.c == null) {
            parcel.writeInt(i2);
        } else {
            parcel.writeInt(i3);
            this.c.writeToParcel(parcel, flags);
        }
        if (this.v == null) {
            parcel.writeInt(i2);
        } else {
            parcel.writeInt(i3);
            this.v.writeToParcel(parcel, flags);
        }
    }
}
