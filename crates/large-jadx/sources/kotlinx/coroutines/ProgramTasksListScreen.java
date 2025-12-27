package app.dogo.com.dogo_android.y.c0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.w1;
import app.dogo.com.dogo_android.y.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramTasksListScreen.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0014J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "tasks", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;)V", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTasks", "()Ljava/util/List;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ProgramTasksListScreen extends j {

    public static final Parcelable.Creator<e> CREATOR = new e$a<>();
    private final List<ProgramTasks> a;
    private final ProgramSaveInfo b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<e> {
        public final e a(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(ProgramTasks.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new ProgramTasksListScreen(arrayList, (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel));
        }

        public final e[] b(int i) {
            return new e[i];
        }
    }
    public e(List<ProgramTasks> list, ProgramSaveInfo programSaveInfo) {
        n.f(list, "tasks");
        n.f(programSaveInfo, "saveInfo");
        super();
        this.a = list;
        this.b = programSaveInfo;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final ProgramSaveInfo createFragment() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final List<ProgramTasks> b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramTasksListFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.inAppMessage.b(new EP_LessonId(), this.b.getLessonId());
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.a.size());
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            (ProgramTasks)it.next().writeToParcel(parcel, flags);
        }
        this.b.writeToParcel(parcel, flags);
    }
}
