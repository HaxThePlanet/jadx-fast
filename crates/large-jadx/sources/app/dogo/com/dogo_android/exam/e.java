package app.dogo.com.dogo_android.exam;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0008HÖ\u0001J\u000c\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\nH\u0014J\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "examUploadData", "Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "(Lapp/dogo/com/dogo_android/exam/ExamUploadData;)V", "getExamUploadData", "()Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends a {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.exam.e> CREATOR;
    private final app.dogo.com.dogo_android.exam.g a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.exam.e> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.exam.e a(Parcel parcel) {
            n.f(parcel, "parcel");
            e eVar = new e((g)g.CREATOR.createFromParcel(parcel));
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.exam.e[] b(int i) {
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

    public e(app.dogo.com.dogo_android.exam.g g) {
        n.f(g, "examUploadData");
        super();
        this.a = g;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final app.dogo.com.dogo_android.exam.g a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    protected Class<?> getActivityClass() {
        return ExamFlowActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
    }
}
