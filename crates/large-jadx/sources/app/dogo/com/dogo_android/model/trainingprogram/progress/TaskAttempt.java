package app.dogo.com.dogo_android.model.trainingprogram.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: TaskAttempt.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/progress/TaskAttempt;", "Landroid/os/Parcelable;", "id", "", "timestamp", "", "programId", "moduleId", "lessonId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLessonId", "getModuleId", "getProgramId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TaskAttempt implements Parcelable {

    public static final Parcelable.Creator<TaskAttempt> CREATOR = new TaskAttempt$Creator<>();
    private final String id;
    private final String lessonId;
    private final String moduleId;
    private final String programId;
    private final long timestamp;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskAttempt> {
        @Override // android.os.Parcelable$Creator
        public final TaskAttempt createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            TaskAttempt taskAttempt = new TaskAttempt(parcel.readString(), parcel.readLong(), str2, parcel.readString(), parcel.readString(), parcel.readString());
            return taskAttempt;
        }

        @Override // android.os.Parcelable$Creator
        public final TaskAttempt[] newArray(int i) {
            return new TaskAttempt[i];
        }
    }
    public TaskAttempt(String str, long j, String str2, String str3, String str4) {
        n.f(str, "id");
        super();
        this.id = str;
        this.timestamp = j;
        this.programId = str2;
        this.moduleId = str3;
        this.lessonId = str4;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLessonId() {
        return this.lessonId;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }


    public static /* synthetic */ TaskAttempt copy$default(TaskAttempt taskAttempt, String str, long j, String str2, String str3, String str4, int i, Object object) {
        String str22;
        long j32;
        String str52;
        String str62;
        String i72;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        return taskAttempt.copy(str22, j32, str52, str62, i72);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final long component2() {
        return this.timestamp;
    }

    /* operator */ public final String component3() {
        return this.programId;
    }

    /* operator */ public final String component4() {
        return this.moduleId;
    }

    /* operator */ public final String component5() {
        return this.lessonId;
    }

    public final TaskAttempt copy(String id, long timestamp, String programId, String moduleId, String lessonId) {
        n.f(id, "id");
        TaskAttempt taskAttempt = new TaskAttempt(id, timestamp, str2, programId, moduleId, lessonId);
        return taskAttempt;
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
        final boolean z6 = false;
        if (!(other instanceof TaskAttempt)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        return !n.b(this.lessonId, other.lessonId) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.programId == null) {
        } else {
            i = this.programId.hashCode();
        }
        if (this.moduleId == null) {
        } else {
            i = this.moduleId.hashCode();
        }
        if (this.lessonId != null) {
            i = this.lessonId.hashCode();
        }
        return (this.id.hashCode() * 31) + Long.hashCode(this.timestamp) * 31 + i * 31 + i * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TaskAttempt(id=";
        String str3 = ", timestamp=";
        String str4 = ", programId=";
        String str5 = ", moduleId=";
        String str6 = ", lessonId=";
        str = str2 + this.id + str3 + this.timestamp + str4 + this.programId + str5 + this.moduleId + str6 + this.lessonId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
