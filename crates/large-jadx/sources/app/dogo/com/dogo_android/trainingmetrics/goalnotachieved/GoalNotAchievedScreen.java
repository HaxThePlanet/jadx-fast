package app.dogo.com.dogo_android.x.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l2;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.r2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: GoalNotAchievedScreen.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0014J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000c¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "viewSource", "", "trickRatingList", "", "", "timeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "fragmentReturnTag", "(Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "statusBarColor", "getStatusBarColor", "()Ljava/lang/Integer;", "getTimeMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getTrickRatingList", "()Ljava/util/List;", "getViewSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class GoalNotAchievedScreen extends app.dogo.com.dogo_android.util.g {

    public static final Parcelable.Creator<c> CREATOR = new c$a<>();
    /* renamed from: v, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private final List<Integer> w;
    /* renamed from: x, reason: from kotlin metadata */
    private final TrainingTimeMetrics timeMetrics;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<c> {
        public final c a(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
                i = i + 1;
            }
            return new GoalNotAchievedScreen(parcel.readString(), arrayList, (TrainingTimeMetrics)TrainingTimeMetrics.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        public final c[] b(int i) {
            return new c[i];
        }
    }
    public /* synthetic */ c(String str, List list, TrainingTimeMetrics trainingTimeMetrics, String str2, int i, kotlin.d0.d.g gVar) {
        if (i & 2 != 0) {
            list = p.g();
        }
        this(str, list, trainingTimeMetrics, str2);
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        return new GoalNotAchievedFragment();
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        return S.faqList.b(new EP_ViewSource(), this.fragmentReturnTag, new EP_Time(), String.valueOf(this.timeMetrics.getTodayTrainingTimeSeconds()));
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final TrainingTimeMetrics e() {
        return this.timeMetrics;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final List<Integer> f() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final String g() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public String getFragmentReturnTag() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public Integer getStatusBarColor() {
        return 2131099683;
    }

    public c(String str, List<Integer> list, TrainingTimeMetrics trainingTimeMetrics, String str2) {
        n.f(str, "viewSource");
        n.f(list, "trickRatingList");
        n.f(trainingTimeMetrics, "timeMetrics");
        n.f(str2, "fragmentReturnTag");
        super(str2);
        this.fragmentReturnTag = str;
        this.w = list;
        this.timeMetrics = trainingTimeMetrics;
        this.y = str2;
    }


    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeInt(this.w.size());
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            parcel.writeInt((Number)it.next().intValue());
        }
        this.timeMetrics.writeToParcel(parcel, flags);
        parcel.writeString(this.y);
    }
}
