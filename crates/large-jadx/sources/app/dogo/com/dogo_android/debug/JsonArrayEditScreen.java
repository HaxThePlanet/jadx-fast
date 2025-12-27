package app.dogo.com.dogo_android.i;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: JsonArrayEditScreen.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000b\u001a\u00020\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "remoteKey", "", "selectionList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getRemoteKey", "()Ljava/lang/String;", "getSelectionList", "()Ljava/util/List;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r0, reason: from kotlin metadata */
public final class JsonArrayEditScreen extends e {

    public static final Parcelable.Creator<r0> CREATOR = new r0$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String remoteKey;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<String> selectionList;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<r0> {
        public final r0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new JsonArrayEditScreen(parcel.readString(), parcel.createStringArrayList());
        }

        public final r0[] b(int i) {
            return new r0[i];
        }
    }
    public r0(String str, List<String> list) {
        n.f(str, "remoteKey");
        n.f(list, "selectionList");
        super();
        this.remoteKey = str;
        this.selectionList = list;
    }

    @Override // app.dogo.com.dogo_android.util.e
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.remoteKey;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final List<String> b() {
        return this.selectionList;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        return new JsonArrayEditDialog();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.challengeEntryCreation.withoutParameters();
    }


    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.remoteKey);
        parcel.writeStringList(this.selectionList);
    }
}
