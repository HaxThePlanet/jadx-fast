package app.dogo.com.dogo_android.inbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import com.iterable.iterableapi.ui.inbox.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: MobileInboxScreen.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\r\u001a\u00020\u000eH\u0014J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0008HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0008HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/inbox/MobileInboxScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "noMessagesTitle", "", "noMessagesBody", "inboxMode", "Lcom/iterable/iterableapi/ui/inbox/InboxMode;", "itemLayoutId", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/iterable/iterableapi/ui/inbox/InboxMode;I)V", "statusBarColor", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class MobileInboxScreen extends j {

    public static final Parcelable.Creator<b> CREATOR = new b$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String inboxMode;
    /* renamed from: b, reason: from kotlin metadata */
    private final String itemLayoutId;
    /* renamed from: c, reason: from kotlin metadata */
    private final a noMessagesBody;
    /* renamed from: v, reason: from kotlin metadata */
    private final int noMessagesTitle;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<b> {
        public final b a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new MobileInboxScreen(parcel.readString(), parcel.readString(), a.valueOf(parcel.readString()), parcel.readInt());
        }

        public final b[] b(int i) {
            return new b[i];
        }
    }
    public /* synthetic */ b(String str, String str2, a aVar, int i, int i2, kotlin.d0.d.g gVar) {
        a pOPUP2;
        pOPUP2 = i2 & 4 != 0 ? a.POPUP : pOPUP2;
        i = i2 & 8 != 0 ? R.layout.cell_iterable_mailbox : i;
        this(str, str2, pOPUP2, i);
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        com.iterable.iterableapi.ui.inbox.g gVar = g.F1(this.noMessagesBody, this.noMessagesTitle, this.inboxMode, this.itemLayoutId);
        n.e(gVar, "newInstance(\n        inboxMode,\n        itemLayoutId,\n        noMessagesTitle,\n        noMessagesBody\n    )");
        return gVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.challengeProfile.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100379;
    }

    public b(String str, String str2, a aVar, int i) {
        n.f(str, "noMessagesTitle");
        n.f(str2, "noMessagesBody");
        n.f(aVar, "inboxMode");
        super();
        this.inboxMode = str;
        this.itemLayoutId = str2;
        this.noMessagesBody = aVar;
        this.noMessagesTitle = i;
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.inboxMode);
        parcel.writeString(this.itemLayoutId);
        parcel.writeString(this.noMessagesBody.name());
        parcel.writeInt(this.noMessagesTitle);
    }
}
