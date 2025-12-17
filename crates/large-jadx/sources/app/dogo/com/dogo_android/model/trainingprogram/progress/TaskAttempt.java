package app.dogo.com.dogo_android.model.trainingprogram.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/progress/TaskAttempt;", "Landroid/os/Parcelable;", "id", "", "timestamp", "", "programId", "moduleId", "lessonId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLessonId", "getModuleId", "getProgramId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TaskAttempt implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt> CREATOR;
    private final String id;
    private final String lessonId;
    private final String moduleId;
    private final String programId;
    private final long timestamp;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readLong(), obj4, parcel.readString(), parcel.readString(), parcel.readString());
            return taskAttempt;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt[] newArray(int i) {
            return new TaskAttempt[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        TaskAttempt.Creator creator = new TaskAttempt.Creator();
        TaskAttempt.CREATOR = creator;
    }

    public TaskAttempt(String string, long l2, String string3, String string4, String string5) {
        n.f(string, "id");
        super();
        this.id = string;
        this.timestamp = l2;
        this.programId = string4;
        this.moduleId = string5;
        this.lessonId = obj7;
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt copy$default(app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt taskAttempt, String string2, long l3, String string4, String string5, String string6, int i7, Object object8) {
        String obj5;
        long obj6;
        String obj8;
        String obj9;
        String obj10;
        if (object8 & 1 != 0) {
            obj5 = taskAttempt.id;
        }
        if (object8 & 2 != 0) {
            obj6 = taskAttempt.timestamp;
        }
        if (object8 & 4 != 0) {
            obj8 = taskAttempt.programId;
        }
        if (object8 & 8 != 0) {
            obj9 = taskAttempt.moduleId;
        }
        if (object8 & 16 != 0) {
            obj10 = taskAttempt.lessonId;
        }
        return taskAttempt.copy(obj5, obj6, obj9, obj8, obj9);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return this.timestamp;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.model.trainingprogram.progress.TaskAttempt copy(String string, long l2, String string3, String string4, String string5) {
        n.f(string, "id");
        super(string, l2, obj4, string4, string5, obj14);
        return taskAttempt;
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
        if (!object instanceof TaskAttempt) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (Long.compare(timestamp, timestamp2) != 0) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
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
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getLessonId() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final String getModuleId() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        int i3;
        String programId = this.programId;
        i3 = 0;
        if (programId == null) {
            i = i3;
        } else {
            i = programId.hashCode();
        }
        String moduleId = this.moduleId;
        if (moduleId == null) {
            i2 = i3;
        } else {
            i2 = moduleId.hashCode();
        }
        String lessonId = this.lessonId;
        if (lessonId == null) {
        } else {
            i3 = lessonId.hashCode();
        }
        return i11 += i3;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TaskAttempt(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
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
        parcel.writeString(this.id);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
