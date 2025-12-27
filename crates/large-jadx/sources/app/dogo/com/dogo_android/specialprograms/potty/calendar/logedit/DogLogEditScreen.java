package app.dogo.com.dogo_android.u.n.p.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogLogEditScreen.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0008\u0010\u0018\u001a\u00020\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000cR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "preselectedTimeMs", "", "preselectedTagType", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "logId", "fragmentReturnTag", "(Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogLogTypes;Ljava/lang/String;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getLogId", "getPreselectedTagType", "()Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "getPreselectedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class DogLogEditScreen extends j {

    public static final Parcelable.Creator<h> CREATOR = new h$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private final Long b;
    private final e c;
    private final String v;
    /* renamed from: w, reason: from kotlin metadata */
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<h> {
        public final h a(Parcel parcel) {
            int i;
            e str;
            n.f(parcel, "parcel");
            i = 0;
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(parcel.readString(), i, str, string, parcel2);
            return dogLogEditScreen;
        }

        public final h[] b(int i) {
            return new h[i];
        }
    }
    public /* synthetic */ h(String str, Long long, e eVar, String str2, String str3, int i, g gVar) {
        Long long22;
        e eVar32;
        String str42;
        String str52;
        i = 0;
        int r3 = i & 2 != 0 ? i : long;
        int r4 = i & 4 != 0 ? i : eVar;
        int r5 = i & 8 != 0 ? i : str2;
        str52 = i & 16 != 0 ? "" : str52;
        this(str, long22, eVar32, str42, str52);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final e b() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final Long c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new DogLogEditFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.f1.b(new EP_ViewSource(), this.fragmentReturnTag);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100379;
    }

    public h(String str, Long long, e eVar, String str2, String str3) {
        n.f(str, "source");
        n.f(str3, "fragmentReturnTag");
        super();
        this.fragmentReturnTag = str;
        this.b = long;
        this.c = eVar;
        this.v = str2;
        this.source = str3;
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.fragmentReturnTag);
        final int i = 0;
        final int i2 = 1;
        if (this.b == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.b.longValue());
        }
        if (this.c == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeString(this.c.name());
        }
        parcel.writeString(this.v);
        parcel.writeString(this.source);
    }
}
