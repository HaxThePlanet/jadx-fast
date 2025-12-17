package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.util.customview.DogLogView.a.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "Landroid/os/Parcelable;", "logId", "", "dogId", "eventTimeMs", "", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "style", "Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "(Ljava/lang/String;Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/DogLogTypes;Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;)V", "getDogId", "()Ljava/lang/String;", "getEventTimeMs", "()J", "getLogId", "getStyle", "()Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "getType", "()Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "LogStyle", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogLog implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogLog> CREATOR;
    private final String dogId;
    private final long eventTimeMs;
    private final String logId;
    private final app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle style;
    private final e type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogLog> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogLog createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readLong(), obj5, e.valueOf(parcel.readString()), (DogLog.LogStyle)DogLog.LogStyle.CREATOR.createFromParcel(parcel));
            return dogLog;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogLog[] newArray(int i) {
            return new DogLog[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "id", "", "letterColorRes", "", "nameRes", "tagColorRes", "(Ljava/lang/String;III)V", "getId", "()Ljava/lang/String;", "getLetterColorRes", "()I", "getNameRes", "getTagColorRes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LogStyle extends DogLogView.a.b {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle> CREATOR;
        private final String id;
        private final int letterColorRes;
        private final int nameRes;
        private final int tagColorRes;
        static {
            DogLog.LogStyle.Creator creator = new DogLog.LogStyle.Creator();
            DogLog.LogStyle.CREATOR = creator;
        }

        public LogStyle(String string, int i2, int i3, int i4) {
            n.f(string, "id");
            super(string, i2, i3, i4);
            this.id = string;
            this.letterColorRes = i2;
            this.nameRes = i3;
            this.tagColorRes = i4;
        }

        public static app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle copy$default(app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle dogLog$LogStyle, String string2, int i3, int i4, int i5, int i6, Object object7) {
            String obj1;
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 1 != 0) {
                obj1 = logStyle.getId();
            }
            if (i6 & 2 != 0) {
                obj2 = logStyle.getLetterColorRes();
            }
            if (i6 & 4 != 0) {
                obj3 = logStyle.getNameRes();
            }
            if (i6 &= 8 != 0) {
                obj4 = logStyle.getTagColorRes();
            }
            return logStyle.copy(obj1, obj2, obj3, obj4);
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public final String component1() {
            return getId();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public final int component2() {
            return getLetterColorRes();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public final int component3() {
            return getNameRes();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public final int component4() {
            return getTagColorRes();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public final app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle copy(String string, int i2, int i3, int i4) {
            n.f(string, "id");
            DogLog.LogStyle logStyle = new DogLog.LogStyle(string, i2, i3, i4);
            return logStyle;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof DogLog.LogStyle) {
                return i2;
            }
            if (!n.b(getId(), (DogLog.LogStyle)object.getId())) {
                return i2;
            }
            if (getLetterColorRes() != object.getLetterColorRes()) {
                return i2;
            }
            if (getNameRes() != object.getNameRes()) {
                return i2;
            }
            if (getTagColorRes() != object.getTagColorRes()) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public String getId() {
            return this.id;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public int getLetterColorRes() {
            return this.letterColorRes;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public int getNameRes() {
            return this.nameRes;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public int getTagColorRes() {
            return this.tagColorRes;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public int hashCode() {
            return i6 += i10;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LogStyle(id=");
            stringBuilder.append(getId());
            stringBuilder.append(", letterColorRes=");
            stringBuilder.append(getLetterColorRes());
            stringBuilder.append(", nameRes=");
            stringBuilder.append(getNameRes());
            stringBuilder.append(", tagColorRes=");
            stringBuilder.append(getTagColorRes());
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.letterColorRes);
            parcel.writeInt(this.nameRes);
            parcel.writeInt(this.tagColorRes);
        }
    }
    static {
        DogLog.Creator creator = new DogLog.Creator();
        DogLog.CREATOR = creator;
    }

    public DogLog(String string, String string2, long l3, e e4, app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle dogLog$LogStyle5) {
        n.f(string, "logId");
        n.f(string2, "dogId");
        n.f(logStyle5, "type");
        n.f(obj7, "style");
        super();
        this.logId = string;
        this.dogId = string2;
        this.eventTimeMs = l3;
        this.type = logStyle5;
        this.style = obj7;
    }

    public static app.dogo.com.dogo_android.repository.domain.DogLog copy$default(app.dogo.com.dogo_android.repository.domain.DogLog dogLog, String string2, String string3, long l4, e e5, app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle dogLog$LogStyle6, int i7, Object object8) {
        String obj5;
        String obj6;
        long obj7;
        e obj9;
        app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle obj10;
        if (object8 & 1 != 0) {
            obj5 = dogLog.logId;
        }
        if (object8 & 2 != 0) {
            obj6 = dogLog.dogId;
        }
        if (object8 & 4 != 0) {
            obj7 = dogLog.eventTimeMs;
        }
        if (object8 & 8 != 0) {
            obj9 = dogLog.type;
        }
        if (object8 & 16 != 0) {
            obj10 = dogLog.style;
        }
        return dogLog.copy(obj5, obj6, obj7, obj10, obj9);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.logId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return this.eventTimeMs;
    }

    @Override // android.os.Parcelable
    public final e component4() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle component5() {
        return this.style;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogLog copy(String string, String string2, long l3, e e4, app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle dogLog$LogStyle5) {
        n.f(string, "logId");
        n.f(string2, "dogId");
        n.f(logStyle5, "type");
        n.f(obj14, "style");
        super(string, string2, l3, obj5, logStyle5, obj14);
        return dogLog;
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
        if (!object instanceof DogLog) {
            return i2;
        }
        if (!n.b(this.logId, object.logId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (Long.compare(eventTimeMs, eventTimeMs2) != 0) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        if (!n.b(this.style, object.style)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getLogId() {
        return this.logId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle getStyle() {
        return this.style;
    }

    @Override // android.os.Parcelable
    public final e getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i8 += i13;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogLog(logId=");
        stringBuilder.append(this.logId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", eventTimeMs=");
        stringBuilder.append(this.eventTimeMs);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", style=");
        stringBuilder.append(this.style);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.logId);
        parcel.writeString(this.dogId);
        parcel.writeLong(this.eventTimeMs);
        parcel.writeString(this.type.name());
        this.style.writeToParcel(parcel, i2);
    }
}
