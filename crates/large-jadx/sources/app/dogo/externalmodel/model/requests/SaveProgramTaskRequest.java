package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SaveProgramTaskRequest.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveProgramTaskRequest;", "Landroid/os/Parcelable;", "taskIds", "", "", "moduleId", "lessonId", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getTaskIds", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SaveProgramTaskRequest implements Parcelable {

    public static final Parcelable.Creator<SaveProgramTaskRequest> CREATOR = new SaveProgramTaskRequest$Creator<>();
    private final String lessonId;
    private final String moduleId;
    private final List<String> taskIds;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SaveProgramTaskRequest> {
        @Override // android.os.Parcelable$Creator
        public final SaveProgramTaskRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SaveProgramTaskRequest(parcel.createStringArrayList(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final SaveProgramTaskRequest[] newArray(int i) {
            return new SaveProgramTaskRequest[i];
        }
    }
    public SaveProgramTaskRequest(List<String> list, String str, String str2) {
        n.f(list, "taskIds");
        n.f(str, "moduleId");
        n.f(str2, "lessonId");
        super();
        this.taskIds = list;
        this.moduleId = str;
        this.lessonId = str2;
    }

    public final String getLessonId() {
        return this.lessonId;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final List<String> getTaskIds() {
        return this.taskIds;
    }


    public static /* synthetic */ SaveProgramTaskRequest copy$default(SaveProgramTaskRequest saveProgramTaskRequest, List list, String str, String str2, int i, Object object) {
        List taskIds2;
        String moduleId2;
        String lessonId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return saveProgramTaskRequest.copy(taskIds2, moduleId2, lessonId2);
    }

    /* operator */ public final List<String> component1() {
        return this.taskIds;
    }

    /* operator */ public final String component2() {
        return this.moduleId;
    }

    /* operator */ public final String component3() {
        return this.lessonId;
    }

    public final SaveProgramTaskRequest copy(List<String> taskIds, String moduleId, String lessonId) {
        n.f(taskIds, "taskIds");
        n.f(moduleId, "moduleId");
        n.f(lessonId, "lessonId");
        return new SaveProgramTaskRequest(taskIds, moduleId, lessonId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof SaveProgramTaskRequest)) {
            return false;
        }
        if (!n.b(this.taskIds, other.taskIds)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        return !n.b(this.lessonId, other.lessonId) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.taskIds.hashCode() * 31) + this.moduleId.hashCode() * 31 + this.lessonId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SaveProgramTaskRequest(taskIds=";
        String str3 = ", moduleId=";
        String str4 = ", lessonId=";
        str = str2 + this.taskIds + str3 + this.moduleId + str4 + this.lessonId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeStringList(this.taskIds);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
