package app.dogo.com.dogo_android.model.trainingprogram.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BG\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/progress/TrickAttempt;", "Landroid/os/Parcelable;", "id", "", "knowledge", "", "timestamp", "", "programId", "moduleId", "lessonId", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getKnowledge", "()I", "getLessonId", "getModuleId", "getProgramId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickAttempt implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt> CREATOR;
    private final String id;
    private final int knowledge;
    private final String lessonId;
    private final String moduleId;
    private final String programId;
    private final long timestamp;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readInt(), parcel.readLong(), obj5, parcel.readString(), parcel.readString(), parcel.readString());
            return trickAttempt;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt[] newArray(int i) {
            return new TrickAttempt[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        TrickAttempt.Creator creator = new TrickAttempt.Creator();
        TrickAttempt.CREATOR = creator;
    }

    public TrickAttempt() {
        super(0, 0, 0, obj4, 0, 0, 0, 63, 0);
    }

    public TrickAttempt(String string, int i2, long l3, String string4, String string5, String string6) {
        n.f(string, "id");
        super();
        this.id = string;
        this.knowledge = i2;
        this.timestamp = l3;
        this.programId = string5;
        this.moduleId = string6;
        this.lessonId = obj8;
    }

    public TrickAttempt(String string, int i2, long l3, String string4, String string5, String string6, int i7, g g8) {
        int i;
        int str;
        int i3;
        String obj6;
        int obj7;
        int obj8;
        obj6 = g8 & 1 != 0 ? "" : obj6;
        obj7 = g8 & 2 != 0 ? 0 : obj7;
        obj8 = g8 & 4 != 0 ? 0 : obj8;
        obj8 = 0;
        i = g8 & 8 != 0 ? obj8 : string5;
        str = g8 & 16 != 0 ? obj8 : string6;
        i3 = g8 & 32 != 0 ? obj8 : i7;
        super(obj6, obj7, obj8, string6, i, str, i3);
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt copy$default(app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt trickAttempt, String string2, int i3, long l4, String string5, String string6, String string7, int i8, Object object9) {
        String obj6;
        int obj7;
        long obj8;
        String obj10;
        String obj11;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = trickAttempt.id;
        }
        if (object9 & 2 != 0) {
            obj7 = trickAttempt.knowledge;
        }
        if (object9 & 4 != 0) {
            obj8 = trickAttempt.timestamp;
        }
        if (object9 & 8 != 0) {
            obj10 = trickAttempt.programId;
        }
        if (object9 & 16 != 0) {
            obj11 = trickAttempt.moduleId;
        }
        if (object9 & 32 != 0) {
            obj12 = trickAttempt.lessonId;
        }
        return trickAttempt.copy(obj6, obj7, obj8, obj11, obj10, obj11);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return this.timestamp;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.moduleId;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.lessonId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.model.trainingprogram.progress.TrickAttempt copy(String string, int i2, long l3, String string4, String string5, String string6) {
        n.f(string, "id");
        super(string, i2, l3, obj5, string5, string6, obj16);
        return trickAttempt;
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
        if (!object instanceof TrickAttempt) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
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
    public final int getKnowledge() {
        return this.knowledge;
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
        int i3;
        int i;
        int i2;
        String programId = this.programId;
        i2 = 0;
        if (programId == null) {
            i3 = i2;
        } else {
            i3 = programId.hashCode();
        }
        String moduleId = this.moduleId;
        if (moduleId == null) {
            i = i2;
        } else {
            i = moduleId.hashCode();
        }
        String lessonId = this.lessonId;
        if (lessonId == null) {
        } else {
            i2 = lessonId.hashCode();
        }
        return i13 += i2;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickAttempt(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
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
        parcel.writeInt(this.knowledge);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
