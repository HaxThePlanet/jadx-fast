package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.util.customview.DogLogView.a.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogLog.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "Landroid/os/Parcelable;", "logId", "", "dogId", "eventTimeMs", "", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "style", "Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "(Ljava/lang/String;Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/DogLogTypes;Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;)V", "getDogId", "()Ljava/lang/String;", "getEventTimeMs", "()J", "getLogId", "getStyle", "()Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "getType", "()Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "LogStyle", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogLog implements Parcelable {

    public static final Parcelable.Creator<DogLog> CREATOR = new DogLog$Creator<>();
    private final String dogId;
    private final long eventTimeMs;
    private final String logId;
    private final DogLog.LogStyle style;
    private final e type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogLog> {
        @Override // android.os.Parcelable$Creator
        public final DogLog createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogLog dogLog = new DogLog(parcel.readString(), parcel.readString(), parcel.readLong(), eVar, DogLogTypes.valueOf(parcel.readString()), (DogLog_LogStyle)parcel2);
            return dogLog;
        }

        @Override // android.os.Parcelable$Creator
        public final DogLog[] newArray(int i) {
            return new DogLog[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "id", "", "letterColorRes", "", "nameRes", "tagColorRes", "(Ljava/lang/String;III)V", "getId", "()Ljava/lang/String;", "getLetterColorRes", "()I", "getNameRes", "getTagColorRes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LogStyle extends DogLogView.a.b {

        public static final Parcelable.Creator<DogLog.LogStyle> CREATOR = new DogLog$LogStyle$Creator<>();
        private final String id;
        private final int letterColorRes;
        private final int nameRes;
        private final int tagColorRes;
        public LogStyle(String str, int i, int i2, int i3) {
            n.f(str, "id");
            super(str, i, i2, i3);
            this.id = str;
            this.letterColorRes = i;
            this.nameRes = i2;
            this.tagColorRes = i3;
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


        public static /* synthetic */ DogLog.LogStyle copy$default(DogLog.LogStyle logStyle, String str, int i, int i2, int i3, int i4, Object object) {
            int letterColorRes;
            int nameRes;
            int tagColorRes;
            if (i4 & 1 != 0) {
                str = logStyle.getId();
            }
            if (i4 & 2 != 0) {
                letterColorRes = logStyle.getLetterColorRes();
            }
            if (i4 & 4 != 0) {
                nameRes = logStyle.getNameRes();
            }
            if (i4 & 8 != 0) {
                tagColorRes = logStyle.getTagColorRes();
            }
            return logStyle.copy(str, letterColorRes, nameRes, tagColorRes);
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        /* operator */ public final String component1() {
            return getId();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        /* operator */ public final int component2() {
            return getLetterColorRes();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        /* operator */ public final int component3() {
            return getNameRes();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        /* operator */ public final int component4() {
            return getTagColorRes();
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public final DogLog.LogStyle copy(String id, int letterColorRes, int nameRes, int tagColorRes) {
            n.f(id, "id");
            return new DogLog_LogStyle(id, letterColorRes, nameRes, tagColorRes);
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof DogLog_LogStyle)) {
                return false;
            }
            if (!n.b(getId(), other.getId())) {
                return false;
            }
            if (getLetterColorRes() != other.getLetterColorRes()) {
                return false;
            }
            if (getNameRes() != other.getNameRes()) {
                return false;
            }
            return getTagColorRes() != other.getTagColorRes() ? z4 : z;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public int hashCode() {
            return (getId().hashCode() * 31) + Integer.hashCode(getLetterColorRes()) * 31 + Integer.hashCode(getNameRes()) * 31 + Integer.hashCode(getTagColorRes());
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LogStyle(id=";
            String id = getId();
            String str3 = ", letterColorRes=";
            int letterColorRes = getLetterColorRes();
            String str4 = ", nameRes=";
            int nameRes = getNameRes();
            String str5 = ", tagColorRes=";
            int tagColorRes = getTagColorRes();
            str = str2 + id + str3 + letterColorRes + str4 + nameRes + str5 + tagColorRes + 41;
            return str;
        }

        @Override // app.dogo.com.dogo_android.util.customview.DogLogView$a$b
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.letterColorRes);
            parcel.writeInt(this.nameRes);
            parcel.writeInt(this.tagColorRes);
        }
    }
    public DogLog(String str, String str2, long j, e eVar, DogLog.LogStyle logStyle) {
        n.f(str, "logId");
        n.f(str2, "dogId");
        n.f(eVar, "type");
        n.f(logStyle, "style");
        super();
        this.logId = str;
        this.dogId = str2;
        this.eventTimeMs = j;
        this.type = eVar;
        this.style = logStyle;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final DogLog.LogStyle getStyle() {
        return this.style;
    }

    public final e getType() {
        return this.type;
    }


    public static /* synthetic */ DogLog copy$default(DogLog dogLog, String str, String str2, long j, e eVar, DogLog.LogStyle logStyle, int i, Object object) {
        String str22;
        String str32;
        long j42;
        e logStyle62;
        Object i72;
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
        return dogLog.copy(str22, str32, j42, logStyle62, i72);
    }

    /* operator */ public final String component1() {
        return this.logId;
    }

    /* operator */ public final String component2() {
        return this.dogId;
    }

    /* operator */ public final long component3() {
        return this.eventTimeMs;
    }

    /* operator */ public final e component4() {
        return this.type;
    }

    /* operator */ public final DogLog.LogStyle component5() {
        return this.style;
    }

    public final DogLog copy(String logId, String dogId, long eventTimeMs, e type, DogLog.LogStyle style) {
        n.f(logId, "logId");
        n.f(dogId, "dogId");
        n.f(type, "type");
        n.f(style, "style");
        DogLog dogLog = new DogLog(logId, dogId, eventTimeMs, eVar, type, style);
        return dogLog;
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
        if (!(other instanceof DogLog)) {
            return false;
        }
        if (!n.b(this.logId, other.logId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (this.eventTimeMs != other.eventTimeMs) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return !n.b(this.style, other.style) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.logId.hashCode() * 31) + this.dogId.hashCode() * 31 + Long.hashCode(this.eventTimeMs) * 31 + this.type.hashCode() * 31 + this.style.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogLog(logId=";
        String str3 = ", dogId=";
        String str4 = ", eventTimeMs=";
        String str5 = ", type=";
        String str6 = ", style=";
        str = str2 + this.logId + str3 + this.dogId + str4 + this.eventTimeMs + str5 + this.type + str6 + this.style + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.logId);
        parcel.writeString(this.dogId);
        parcel.writeLong(this.eventTimeMs);
        parcel.writeString(this.type.name());
        this.style.writeToParcel(parcel, flags);
    }
}
