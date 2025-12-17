package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001 B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "Landroid/os/Parcelable;", "taskId", "", "text", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;)V", "getTaskId", "()Ljava/lang/String;", "getText", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "setType", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramTasks implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramTasks> CREATOR;
    private final String taskId;
    private final String text;
    private app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramTasks> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramTasks createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            ProgramTasks programTasks = new ProgramTasks(parcel.readString(), parcel.readString(), ProgramTasks.Type.valueOf(parcel.readString()));
            return programTasks;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramTasks[] newArray(int i) {
            return new ProgramTasks[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "COMPLETED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum Type {

        NOT_STARTED,
        COMPLETED;
        private static final app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type[] arr = new ProgramTasks.Type[2];
            return arr;
        }
    }
    static {
        ProgramTasks.Creator creator = new ProgramTasks.Creator();
        ProgramTasks.CREATOR = creator;
    }

    public ProgramTasks() {
        super(0, 0, 0, 7, 0);
    }

    public ProgramTasks(String string, String string2, app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type programTasks$Type3) {
        n.f(string, "taskId");
        n.f(string2, "text");
        n.f(type3, "type");
        super();
        this.taskId = string;
        this.text = string2;
        this.type = type3;
    }

    public ProgramTasks(String string, String string2, app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type programTasks$Type3, int i4, g g5) {
        String obj2;
        String obj3;
        app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type obj4;
        final String str = "";
        obj2 = i4 & 1 != 0 ? str : obj2;
        obj3 = i4 & 2 != 0 ? str : obj3;
        obj4 = i4 &= 4 != 0 ? ProgramTasks.Type.NOT_STARTED : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramTasks copy$default(app.dogo.com.dogo_android.repository.domain.ProgramTasks programTasks, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type programTasks$Type4, int i5, Object object6) {
        String obj1;
        String obj2;
        app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type obj3;
        if (i5 & 1 != 0) {
            obj1 = programTasks.taskId;
        }
        if (i5 & 2 != 0) {
            obj2 = programTasks.text;
        }
        if (i5 &= 4 != 0) {
            obj3 = programTasks.type;
        }
        return programTasks.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.taskId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type component3() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramTasks copy(String string, String string2, app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type programTasks$Type3) {
        n.f(string, "taskId");
        n.f(string2, "text");
        n.f(type3, "type");
        ProgramTasks programTasks = new ProgramTasks(string, string2, type3);
        return programTasks;
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
        if (!object instanceof ProgramTasks) {
            return i2;
        }
        if (!n.b(this.taskId, object.taskId)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getTaskId() {
        return this.taskId;
    }

    @Override // android.os.Parcelable
    public final String getText() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public final void setType(app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type programTasks$Type) {
        n.f(type, "<set-?>");
        this.type = type;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramTasks(taskId=");
        stringBuilder.append(this.taskId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.taskId);
        parcel.writeString(this.text);
        parcel.writeString(this.type.name());
    }
}
