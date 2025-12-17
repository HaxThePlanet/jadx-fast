package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveProgramTaskRequest;", "Landroid/os/Parcelable;", "taskIds", "", "", "moduleId", "lessonId", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getTaskIds", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SaveProgramTaskRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveProgramTaskRequest> CREATOR;
    private final String lessonId;
    private final String moduleId;
    private final List<String> taskIds;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveProgramTaskRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveProgramTaskRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            SaveProgramTaskRequest saveProgramTaskRequest = new SaveProgramTaskRequest(parcel.createStringArrayList(), parcel.readString(), parcel.readString());
            return saveProgramTaskRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveProgramTaskRequest[] newArray(int i) {
            return new SaveProgramTaskRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SaveProgramTaskRequest.Creator creator = new SaveProgramTaskRequest.Creator();
        SaveProgramTaskRequest.CREATOR = creator;
    }

    public SaveProgramTaskRequest(List<String> list, String string2, String string3) {
        n.f(list, "taskIds");
        n.f(string2, "moduleId");
        n.f(string3, "lessonId");
        super();
        this.taskIds = list;
        this.moduleId = string2;
        this.lessonId = string3;
    }

    public static app.dogo.externalmodel.model.requests.SaveProgramTaskRequest copy$default(app.dogo.externalmodel.model.requests.SaveProgramTaskRequest saveProgramTaskRequest, List list2, String string3, String string4, int i5, Object object6) {
        List obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = saveProgramTaskRequest.taskIds;
        }
        if (i5 & 2 != 0) {
            obj2 = saveProgramTaskRequest.moduleId;
        }
        if (i5 &= 4 != 0) {
            obj3 = saveProgramTaskRequest.lessonId;
        }
        return saveProgramTaskRequest.copy(obj1, obj2, obj3);
    }

    public final List<String> component1() {
        return this.taskIds;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.lessonId;
    }

    public final app.dogo.externalmodel.model.requests.SaveProgramTaskRequest copy(List<String> list, String string2, String string3) {
        n.f(list, "taskIds");
        n.f(string2, "moduleId");
        n.f(string3, "lessonId");
        SaveProgramTaskRequest saveProgramTaskRequest = new SaveProgramTaskRequest(list, string2, string3);
        return saveProgramTaskRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof SaveProgramTaskRequest == null) {
            return i2;
        }
        if (!n.b(this.taskIds, object.taskIds)) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (!n.b(this.lessonId, object.lessonId)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getLessonId() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final String getModuleId() {
        return this.moduleId;
    }

    public final List<String> getTaskIds() {
        return this.taskIds;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveProgramTaskRequest(taskIds=");
        stringBuilder.append(this.taskIds);
        stringBuilder.append(", moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", lessonId=");
        stringBuilder.append(this.lessonId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeStringList(this.taskIds);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
