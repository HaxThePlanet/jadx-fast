package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramTasks.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001 B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "Landroid/os/Parcelable;", "taskId", "", "text", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;)V", "getTaskId", "()Ljava/lang/String;", "getText", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "setType", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramTasks implements Parcelable {

    public static final Parcelable.Creator<ProgramTasks> CREATOR = new ProgramTasks$Creator<>();
    private final String taskId;
    private final String text;
    private ProgramTasks.Type type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramTasks> {
        @Override // android.os.Parcelable$Creator
        public final ProgramTasks createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ProgramTasks(parcel.readString(), parcel.readString(), ProgramTasks_Type.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramTasks[] newArray(int i) {
            return new ProgramTasks[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "COMPLETED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {

        COMPLETED,
        NOT_STARTED;
        private static final /* synthetic */ ProgramTasks.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type[] arr = new ProgramTasks.Type[2];
            return new ProgramTasks.Type[] { ProgramTasks_Type.NOT_STARTED, ProgramTasks_Type.COMPLETED };
        }
    }
    public ProgramTasks(String str, String str2, ProgramTasks.Type type) {
        n.f(str, "taskId");
        n.f(str2, "text");
        n.f(type, "type");
        super();
        this.taskId = str;
        this.text = str2;
        this.type = type;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getText() {
        return this.text;
    }

    public final ProgramTasks.Type getType() {
        return this.type;
    }

    public final void setType(ProgramTasks.Type type) {
        n.f(type, "<set-?>");
        this.type = type;
    }

    public /* synthetic */ ProgramTasks(String str, String str2, ProgramTasks.Type type, int i, g gVar) {
        String str3;
        app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type nOT_STARTED2;
        str3 = "";
        str3 = i & 1 != 0 ? str3 : str3;
        str3 = i & 2 != 0 ? str3 : str3;
        nOT_STARTED2 = i & 4 != 0 ? ProgramTasks_Type.NOT_STARTED : nOT_STARTED2;
        this(str3, str3, nOT_STARTED2);
    }


    public ProgramTasks() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ProgramTasks copy$default(ProgramTasks programTasks, String str, String str2, ProgramTasks.Type type, int i, Object object) {
        String taskId2;
        String text2;
        app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type type2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return programTasks.copy(taskId2, text2, type2);
    }

    /* operator */ public final String component1() {
        return this.taskId;
    }

    /* operator */ public final String component2() {
        return this.text;
    }

    /* operator */ public final ProgramTasks.Type component3() {
        return this.type;
    }

    public final ProgramTasks copy(String taskId, String text, ProgramTasks.Type type) {
        n.f(taskId, "taskId");
        n.f(text, "text");
        n.f(type, "type");
        return new ProgramTasks(taskId, text, type);
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
        if (!(other instanceof ProgramTasks)) {
            return false;
        }
        if (!n.b(this.taskId, other.taskId)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        return this.type != other.type ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.taskId.hashCode() * 31) + this.text.hashCode() * 31 + this.type.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramTasks(taskId=";
        String str3 = ", text=";
        String str4 = ", type=";
        str = str2 + this.taskId + str3 + this.text + str4 + this.type + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.taskId);
        parcel.writeString(this.text);
        parcel.writeString(this.type.name());
    }
}
