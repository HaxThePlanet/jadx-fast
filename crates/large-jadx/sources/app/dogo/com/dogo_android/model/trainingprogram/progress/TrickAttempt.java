package app.dogo.com.dogo_android.model.trainingprogram.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickAttempt.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BG\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/progress/TrickAttempt;", "Landroid/os/Parcelable;", "id", "", "knowledge", "", "timestamp", "", "programId", "moduleId", "lessonId", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getKnowledge", "()I", "getLessonId", "getModuleId", "getProgramId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickAttempt implements Parcelable {

    public static final Parcelable.Creator<TrickAttempt> CREATOR = new TrickAttempt$Creator<>();
    private final String id;
    private final int knowledge;
    private final String lessonId;
    private final String moduleId;
    private final String programId;
    private final long timestamp;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrickAttempt> {
        @Override // android.os.Parcelable$Creator
        public final TrickAttempt createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            TrickAttempt trickAttempt = new TrickAttempt(parcel.readString(), parcel.readInt(), parcel.readLong(), str2, parcel.readString(), parcel.readString(), parcel.readString());
            return trickAttempt;
        }

        @Override // android.os.Parcelable$Creator
        public final TrickAttempt[] newArray(int i) {
            return new TrickAttempt[i];
        }
    }
    public TrickAttempt(String str, int i, long j, String str2, String str3, String str4) {
        n.f(str, "id");
        super();
        this.id = str;
        this.knowledge = i;
        this.timestamp = j;
        this.programId = str2;
        this.moduleId = str3;
        this.lessonId = str4;
    }

    public final String getId() {
        return this.id;
    }

    public final int getKnowledge() {
        return this.knowledge;
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

    public /* synthetic */ TrickAttempt(String str, int i, long j, String str2, String str3, String str4, int i2, g gVar) {
        int j33;
        String str62;
        int i22 = 0;
        int j32 = 0;
        str2 = i2 & 1 != 0 ? "" : str2;
        i22 = i2 & 2 != 0 ? 0 : i22;
        if (i2 & 4 != 0) {
            j32 = 0;
        }
        j33 = 0;
        int r2 = i2 & 8 != 0 ? j33 : str2;
        int r3 = i2 & 16 != 0 ? j33 : str3;
        int r4 = i2 & 32 != 0 ? j33 : str4;
        this(str2, i22, j32, str3, j33, str62, (i2 & 32 != 0 ? j33 : str4));
    }


    public TrickAttempt() {
        this(null, 0, 0L, str, null, null, 0, 63, 0);
    }

    public static /* synthetic */ TrickAttempt copy$default(TrickAttempt trickAttempt, String str, int i, long j, String str2, String str3, String str4, int i2, Object object) {
        String str22;
        int i32;
        long j42;
        String str62;
        String str72;
        String i82;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        if (i2 & 8 != 0) {
        }
        if (i2 & 16 != 0) {
        }
        if (i2 & 32 != 0) {
        }
        return trickAttempt.copy(str22, i32, j42, str62, str72, i82);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final int component2() {
        return this.knowledge;
    }

    /* operator */ public final long component3() {
        return this.timestamp;
    }

    /* operator */ public final String component4() {
        return this.programId;
    }

    /* operator */ public final String component5() {
        return this.moduleId;
    }

    /* operator */ public final String component6() {
        return this.lessonId;
    }

    public final TrickAttempt copy(String id, int knowledge, long timestamp, String programId, String moduleId, String lessonId) {
        n.f(id, "id");
        TrickAttempt trickAttempt = new TrickAttempt(id, knowledge, timestamp, str2, programId, moduleId, lessonId);
        return trickAttempt;
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
        if (!(other instanceof TrickAttempt)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (this.knowledge != other.knowledge) {
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
        return (this.id.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + Long.hashCode(this.timestamp) * 31 + i * 31 + i * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickAttempt(id=";
        String str3 = ", knowledge=";
        String str4 = ", timestamp=";
        String str5 = ", programId=";
        String str6 = ", moduleId=";
        String str7 = ", lessonId=";
        str = str2 + this.id + str3 + this.knowledge + str4 + this.timestamp + str5 + this.programId + str6 + this.moduleId + str7 + this.lessonId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeInt(this.knowledge);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.programId);
        parcel.writeString(this.moduleId);
        parcel.writeString(this.lessonId);
    }
}
