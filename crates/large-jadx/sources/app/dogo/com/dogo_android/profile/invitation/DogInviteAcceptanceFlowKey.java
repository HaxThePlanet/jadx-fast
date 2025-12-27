package app.dogo.com.dogo_android.profile.invitation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogInviteAcceptanceFlowKey.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u000c\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0011H\u0014J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceFlowKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "inviteId", "", "isDogPremium", "", "(Ljava/lang/String;Z)V", "getInviteId", "()Ljava/lang/String;", "setInviteId", "(Ljava/lang/String;)V", "()Z", "setDogPremium", "(Z)V", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DogInviteAcceptanceFlowKey extends a {

    public static final Parcelable.Creator<f> CREATOR = new f$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private String inviteId;
    /* renamed from: b, reason: from kotlin metadata */
    private boolean isDogPremium;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<f> {
        public final f a(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            DogInviteAcceptanceFlowKey dogInviteAcceptanceFlowKey = new DogInviteAcceptanceFlowKey(parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return dogInviteAcceptanceFlowKey;
        }

        public final f[] b(int i) {
            return new f[i];
        }
    }
    public f(String str, boolean z) {
        n.f(str, "inviteId");
        super();
        this.inviteId = str;
        this.isDogPremium = z;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    /* renamed from: a, reason: from kotlin metadata */
    public final String describeContents() {
        return this.inviteId;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean b() {
        return this.isDogPremium;
    }


    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    protected Class<?> getActivityClass() {
        return DogInviteAcceptanceActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.inviteId);
        parcel.writeInt(this.isDogPremium);
    }
}
