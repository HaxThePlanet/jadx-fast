package app.dogo.com.dogo_android.exam;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ExamFlowScreenKey.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0008HÖ\u0001J\u000c\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\nH\u0014J\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "examUploadData", "Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "(Lapp/dogo/com/dogo_android/exam/ExamUploadData;)V", "getExamUploadData", "()Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ExamFlowScreenKey extends a {

    public static final Parcelable.Creator<e> CREATOR = new e$a<>();
    private final g a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<e> {
        public final e a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ExamFlowScreenKey((ExamUploadData)ExamUploadData.CREATOR.createFromParcel(parcel));
        }

        public final e[] b(int i) {
            return new e[i];
        }
    }
    public e(g gVar) {
        n.f(gVar, "examUploadData");
        super();
        this.a = gVar;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    /* renamed from: a, reason: from kotlin metadata */
    public final g describeContents() {
        return this.a;
    }


    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    protected Class<?> getActivityClass() {
        return ExamFlowActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
    }
}
