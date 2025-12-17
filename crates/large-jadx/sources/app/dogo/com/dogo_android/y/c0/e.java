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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0014J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "tasks", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;)V", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTasks", "()Ljava/util/List;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.c0.e> CREATOR;
    private final List<ProgramTasks> a;
    private final ProgramSaveInfo b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.c0.e> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.c0.e a(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(ProgramTasks.CREATOR.createFromParcel(parcel));
                i++;
            }
            e eVar = new e(arrayList, (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel));
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.c0.e[] b(int i) {
            return new e[i];
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
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    public e(List<ProgramTasks> list, ProgramSaveInfo programSaveInfo2) {
        n.f(list, "tasks");
        n.f(programSaveInfo2, "saveInfo");
        super();
        this.a = list;
        this.b = programSaveInfo2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramSaveInfo a() {
        return this.b;
    }

    public final List<ProgramTasks> b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        d dVar = new d();
        return dVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        w1 w1Var = new w1();
        return j3.c0.b(w1Var, this.b.getLessonId());
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List list = this.a;
        parcel.writeInt(list.size());
        Iterator iterator = list.iterator();
        for (ProgramTasks size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        this.b.writeToParcel(parcel, i2);
    }
}
