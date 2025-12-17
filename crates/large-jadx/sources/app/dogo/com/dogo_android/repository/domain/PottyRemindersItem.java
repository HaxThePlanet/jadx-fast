package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.android.persistencedb.room.entity.PottyReminderEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0014\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 ;2\u00020\u0001:\u0001;BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010(\u001a\u00020\u0007HÆ\u0003J^\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010*J\t\u0010+\u001a\u00020\u0019HÖ\u0001J\u0013\u0010,\u001a\u00020\u00072\u0008\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\r\u0010/\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001eJ\t\u00100\u001a\u00020\u0019HÖ\u0001J\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u000c\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\u0008\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0011\"\u0004\u0008!\u0010\u0014¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "Landroid/os/Parcelable;", "reminderId", "", "dogId", "days", "", "", "startTime", "endTime", "repeatIntervalMs", "", "isActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getDays", "()Ljava/util/List;", "getDogId", "()Ljava/lang/String;", "getEndTime", "setEndTime", "(Ljava/lang/String;)V", "()Z", "setActive", "(Z)V", "notificationId", "", "getNotificationId", "()I", "getReminderId", "getRepeatIntervalMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "describeContents", "equals", "other", "", "getIntervalMinutes", "hashCode", "isEmpty", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "userId", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PottyRemindersItem implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> CREATOR = null;
    public static final app.dogo.com.dogo_android.repository.domain.PottyRemindersItem.Companion Companion = null;
    public static final int MAX_NOTIFICATION_ID_RANGE = 20000;
    public static final int MINIMUM_CHAR_CODE = 43;
    public static final String POTTY_REMINDER_ID = "potty_reminder";
    private final List<Boolean> days;
    private final String dogId;
    private String endTime;
    private boolean isActive;
    private final String reminderId;
    private final Long repeatIntervalMs;
    private String startTime;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem$Companion;", "", "()V", "MAX_NOTIFICATION_ID_RANGE", "", "MINIMUM_CHAR_CODE", "POTTY_REMINDER_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.PottyRemindersItem createFromParcel(Parcel parcel) {
            int i;
            Boolean valueOf;
            int i2;
            int int;
            int valueOf2;
            int i3;
            n.f(parcel, "parcel");
            int int2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int2);
            int i4 = 0;
            i = i4;
            while (i != int2) {
                if (parcel.readInt() != 0) {
                } else {
                }
                i2 = i4;
                arrayList.add(Boolean.valueOf(i2));
                i++;
            }
            if (parcel.readInt() == 0) {
                valueOf2 = 0;
            } else {
                valueOf2 = Long.valueOf(parcel.readLong());
            }
            i3 = parcel.readInt() != 0 ? i2 : i4;
            super(parcel.readString(), parcel.readString(), arrayList, parcel.readString(), parcel.readString(), valueOf2, i3);
            return obj10;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.PottyRemindersItem[] newArray(int i) {
            return new PottyRemindersItem[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        PottyRemindersItem.Companion companion = new PottyRemindersItem.Companion(0);
        PottyRemindersItem.Companion = companion;
        PottyRemindersItem.Creator creator = new PottyRemindersItem.Creator();
        PottyRemindersItem.CREATOR = creator;
    }

    public PottyRemindersItem(String string, String string2, List<Boolean> list3, String string4, String string5, Long long6, boolean z7) {
        int obj2;
        int obj3;
        Object obj4;
        Object obj5;
        n.f(string, "reminderId");
        n.f(string2, "dogId");
        n.f(list3, "days");
        n.f(string4, "startTime");
        super();
        this.reminderId = string;
        this.dogId = string2;
        this.days = list3;
        this.startTime = string4;
        this.endTime = string5;
        this.repeatIntervalMs = long6;
        this.isActive = z7;
        if (list3.size() < 7) {
            obj2 = 0;
            obj3 = obj2 + 1;
            this.days.add(obj2, Boolean.TRUE);
            while (obj3 > 6) {
                obj2 = obj3;
                obj3 = obj2 + 1;
                this.days.add(obj2, Boolean.TRUE);
            }
        }
    }

    public PottyRemindersItem(String string, String string2, List list3, String string4, String string5, Long long6, boolean z7, int i8, g g9) {
        int str;
        int arrayList;
        int i;
        int i4;
        String str2;
        ArrayList list;
        int i3;
        int i2;
        str2 = i8 & 2 != 0 ? str : string2;
        if (i8 & 4 != 0) {
            arrayList = new ArrayList();
            list = arrayList;
        } else {
            list = list3;
        }
        i3 = i8 & 16 != 0 ? i : string5;
        i2 = i8 & 64 != 0 ? i4 : z7;
        super(string, str2, list, string4, i3, long6, i2);
    }

    public static app.dogo.com.dogo_android.repository.domain.PottyRemindersItem copy$default(app.dogo.com.dogo_android.repository.domain.PottyRemindersItem pottyRemindersItem, String string2, String string3, List list4, String string5, String string6, Long long7, boolean z8, int i9, Object object10) {
        String obj6;
        String obj7;
        List obj8;
        String obj9;
        String obj10;
        Long obj11;
        boolean obj12;
        if (i9 & 1 != 0) {
            obj6 = pottyRemindersItem.reminderId;
        }
        if (i9 & 2 != 0) {
            obj7 = pottyRemindersItem.dogId;
        }
        if (i9 & 4 != 0) {
            obj8 = pottyRemindersItem.days;
        }
        if (i9 & 8 != 0) {
            obj9 = pottyRemindersItem.startTime;
        }
        if (i9 & 16 != 0) {
            obj10 = pottyRemindersItem.endTime;
        }
        if (i9 & 32 != 0) {
            obj11 = pottyRemindersItem.repeatIntervalMs;
        }
        if (i9 & 64 != 0) {
            obj12 = pottyRemindersItem.isActive;
        }
        return pottyRemindersItem.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.reminderId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.dogId;
    }

    public final List<Boolean> component3() {
        return this.days;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.endTime;
    }

    @Override // android.os.Parcelable
    public final Long component6() {
        return this.repeatIntervalMs;
    }

    @Override // android.os.Parcelable
    public final boolean component7() {
        return this.isActive;
    }

    public final app.dogo.com.dogo_android.repository.domain.PottyRemindersItem copy(String string, String string2, List<Boolean> list3, String string4, String string5, Long long6, boolean z7) {
        n.f(string, "reminderId");
        n.f(string2, "dogId");
        n.f(list3, "days");
        n.f(string4, "startTime");
        super(string, string2, list3, string4, string5, long6, z7);
        return pottyRemindersItem;
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
        if (!object instanceof PottyRemindersItem) {
            return i2;
        }
        if (!n.b(this.reminderId, object.reminderId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.days, object.days)) {
            return i2;
        }
        if (!n.b(this.startTime, object.startTime)) {
            return i2;
        }
        if (!n.b(this.endTime, object.endTime)) {
            return i2;
        }
        if (!n.b(this.repeatIntervalMs, object.repeatIntervalMs)) {
            return i2;
        }
        if (this.isActive != object.isActive) {
            return i2;
        }
        return i;
    }

    public final List<Boolean> getDays() {
        return this.days;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final String getEndTime() {
        return this.endTime;
    }

    @Override // android.os.Parcelable
    public final Long getIntervalMinutes() {
        Long valueOf;
        TimeUnit mILLISECONDS;
        long longValue;
        Long repeatIntervalMs = this.repeatIntervalMs;
        if (repeatIntervalMs != null) {
            mILLISECONDS = TimeUnit.MILLISECONDS;
            valueOf = Long.valueOf(mILLISECONDS.toMinutes(repeatIntervalMs.longValue()));
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    @Override // android.os.Parcelable
    public final int getNotificationId() {
        int reminderId;
        int i2;
        int i;
        int length;
        i2 = 0;
        reminderId = this.reminderId.length() == 0 ? 1 : i2;
        if (reminderId != 0) {
        } else {
            reminderId = this.reminderId;
            i = i2;
            while (i2 < reminderId.length()) {
                i += length;
                i2++;
            }
            i2 = i % 20000;
        }
        return i2;
    }

    @Override // android.os.Parcelable
    public final String getReminderId() {
        return this.reminderId;
    }

    @Override // android.os.Parcelable
    public final Long getRepeatIntervalMs() {
        return this.repeatIntervalMs;
    }

    @Override // android.os.Parcelable
    public final String getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        boolean isActive;
        int i;
        String endTime = this.endTime;
        if (endTime == null) {
            i2 = i;
        } else {
            i2 = endTime.hashCode();
        }
        Long repeatIntervalMs = this.repeatIntervalMs;
        if (repeatIntervalMs == null) {
        } else {
            i = repeatIntervalMs.hashCode();
        }
        if (this.isActive) {
            isActive = 1;
        }
        return i14 += isActive;
    }

    @Override // android.os.Parcelable
    public final boolean isActive() {
        return this.isActive;
    }

    @Override // android.os.Parcelable
    public final boolean isEmpty() {
        return l.z(this.reminderId);
    }

    @Override // android.os.Parcelable
    public final void setActive(boolean z) {
        this.isActive = z;
    }

    @Override // android.os.Parcelable
    public final void setEndTime(String string) {
        this.endTime = string;
    }

    @Override // android.os.Parcelable
    public final void setStartTime(String string) {
        n.f(string, "<set-?>");
        this.startTime = string;
    }

    @Override // android.os.Parcelable
    public final PottyReminderEntity toEntity(String string) {
        String endTime;
        n.f(string, "userId");
        if (this.endTime == null) {
            endTime = "";
        }
        super(this.reminderId, this.dogId, string, this.days, this.startTime, endTime, this.repeatIntervalMs, this.isActive);
        return pottyReminderEntity;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PottyRemindersItem(reminderId=");
        stringBuilder.append(this.reminderId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", days=");
        stringBuilder.append(this.days);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", repeatIntervalMs=");
        stringBuilder.append(this.repeatIntervalMs);
        stringBuilder.append(", isActive=");
        stringBuilder.append(this.isActive);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int booleanValue;
        long longValue;
        Long obj4;
        n.f(parcel, "out");
        parcel.writeString(this.reminderId);
        parcel.writeString(this.dogId);
        obj4 = this.days;
        parcel.writeInt(obj4.size());
        obj4 = obj4.iterator();
        for (Boolean next : obj4) {
            parcel.writeInt(next.booleanValue());
        }
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        obj4 = this.repeatIntervalMs;
        if (obj4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(obj4.longValue());
        }
        parcel.writeInt(this.isActive);
    }
}
