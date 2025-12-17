package app.dogo.com.dogo_android.inbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import com.iterable.iterableapi.ui.inbox.a;
import com.iterable.iterableapi.ui.inbox.g;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\r\u001a\u00020\u000eH\u0014J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0008HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0008HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/inbox/MobileInboxScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "noMessagesTitle", "", "noMessagesBody", "inboxMode", "Lcom/iterable/iterableapi/ui/inbox/InboxMode;", "itemLayoutId", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/iterable/iterableapi/ui/inbox/InboxMode;I)V", "statusBarColor", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.inbox.b> CREATOR;
    private final String a;
    private final String b;
    private final a c;
    private final int v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.inbox.b> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.inbox.b a(Parcel parcel) {
            n.f(parcel, "parcel");
            b bVar = new b(parcel.readString(), parcel.readString(), a.valueOf(parcel.readString()), parcel.readInt());
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.inbox.b[] b(int i) {
            return new b[i];
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
        b.a aVar = new b.a();
        b.CREATOR = aVar;
    }

    public b(String string, String string2, a a3, int i4) {
        n.f(string, "noMessagesTitle");
        n.f(string2, "noMessagesBody");
        n.f(a3, "inboxMode");
        super();
        this.a = string;
        this.b = string2;
        this.c = a3;
        this.v = i4;
    }

    public b(String string, String string2, a a3, int i4, int i5, g g6) {
        a obj3;
        int obj4;
        obj3 = i5 & 4 != 0 ? a.POPUP : obj3;
        obj4 = i5 &= 8 != 0 ? R.layout.cell_iterable_mailbox : obj4;
        super(string, string2, obj3, obj4);
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        g gVar = g.F1(this.c, this.v, this.a, this.b);
        n.e(gVar, "newInstance(\n        inboxMode,\n        itemLayoutId,\n        noMessagesTitle,\n        noMessagesBody\n    )");
        return gVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.H.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100379;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c.name());
        parcel.writeInt(this.v);
    }
}
