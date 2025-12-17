package app.dogo.com.dogo_android.x.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l2;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.r2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0014J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000c¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "viewSource", "", "trickRatingList", "", "", "timeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "fragmentReturnTag", "(Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "statusBarColor", "getStatusBarColor", "()Ljava/lang/Integer;", "getTimeMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getTrickRatingList", "()Ljava/util/List;", "getViewSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends g {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.x.b.c> CREATOR;
    private final String v;
    private final List<Integer> w;
    private final TrainingTimeMetrics x;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.x.b.c> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.x.b.c a(Parcel parcel) {
            int i;
            Integer valueOf;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
                i++;
            }
            c cVar = new c(parcel.readString(), arrayList, (TrainingTimeMetrics)TrainingTimeMetrics.CREATOR.createFromParcel(parcel), parcel.readString());
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.x.b.c[] b(int i) {
            return new c[i];
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
        c.a aVar = new c.a();
        c.CREATOR = aVar;
    }

    public c(String string, List<Integer> list2, TrainingTimeMetrics trainingTimeMetrics3, String string4) {
        n.f(string, "viewSource");
        n.f(list2, "trickRatingList");
        n.f(trainingTimeMetrics3, "timeMetrics");
        n.f(string4, "fragmentReturnTag");
        super(string4);
        this.v = string;
        this.w = list2;
        this.x = trainingTimeMetrics3;
        this.y = string4;
    }

    public c(String string, List list2, TrainingTimeMetrics trainingTimeMetrics3, String string4, int i5, g g6) {
        List obj2;
        if (i5 &= 2 != 0) {
            obj2 = p.g();
        }
        super(string, obj2, trainingTimeMetrics3, string4);
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        b bVar = new b();
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        l2 l2Var = new l2();
        return j3.a1.b(r2Var, this.v, l2Var, String.valueOf(this.x.getTodayTrainingTimeSeconds()));
    }

    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final TrainingTimeMetrics e() {
        return this.x;
    }

    public final List<Integer> f() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final String g() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public String getFragmentReturnTag() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public Integer getStatusBarColor() {
        return 2131099683;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public void writeToParcel(Parcel parcel, int i2) {
        int intValue;
        n.f(parcel, "out");
        parcel.writeString(this.v);
        List list = this.w;
        parcel.writeInt(list.size());
        Iterator iterator = list.iterator();
        for (Number next2 : iterator) {
            parcel.writeInt(next2.intValue());
        }
        this.x.writeToParcel(parcel, i2);
        parcel.writeString(this.y);
    }
}
