package app.dogo.com.dogo_android.u.n.q;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0008\u001a\u00020\tH\u0014J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "list", "", "", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.u.n.q.o> CREATOR;
    private final List<Long> a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.u.n.q.o> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.n.q.o a(Parcel parcel) {
            int i;
            Long valueOf;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(Long.valueOf(parcel.readLong()));
                i++;
            }
            o obj6 = new o(arrayList);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.n.q.o[] b(int i) {
            return new o[i];
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
        o.a aVar = new o.a();
        o.CREATOR = aVar;
    }

    public o(List<Long> list) {
        n.f(list, "list");
        super();
        this.a = list;
    }

    public final List<Long> a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        n nVar = new n();
        return nVar;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return j3.I0.f();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        int longValue;
        n.f(parcel, "out");
        List obj4 = this.a;
        parcel.writeInt(obj4.size());
        obj4 = obj4.iterator();
        for (Number next2 : obj4) {
            parcel.writeLong(next2.longValue());
        }
    }
}
