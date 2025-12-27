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

/* compiled from: PottyRemindersItem.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0014\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 ;2\u00020\u0001:\u0001;BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010(\u001a\u00020\u0007HÆ\u0003J^\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010*J\t\u0010+\u001a\u00020\u0019HÖ\u0001J\u0013\u0010,\u001a\u00020\u00072\u0008\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\r\u0010/\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001eJ\t\u00100\u001a\u00020\u0019HÖ\u0001J\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u000c\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\u0008\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0011\"\u0004\u0008!\u0010\u0014¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "Landroid/os/Parcelable;", "reminderId", "", "dogId", "days", "", "", "startTime", "endTime", "repeatIntervalMs", "", "isActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getDays", "()Ljava/util/List;", "getDogId", "()Ljava/lang/String;", "getEndTime", "setEndTime", "(Ljava/lang/String;)V", "()Z", "setActive", "(Z)V", "notificationId", "", "getNotificationId", "()I", "getReminderId", "getRepeatIntervalMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "describeContents", "equals", "other", "", "getIntervalMinutes", "hashCode", "isEmpty", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "userId", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PottyRemindersItem implements Parcelable {

    public static final Parcelable.Creator<PottyRemindersItem> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final PottyRemindersItem.Companion INSTANCE = null;
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
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PottyRemindersItem> {
        @Override // android.os.Parcelable$Creator
        public final PottyRemindersItem createFromParcel(Parcel parcel) {
            int i;
            boolean z = true;
            Long num = null;
            boolean z2;
            n.f(parcel, "parcel");
            int _int2 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int2);
            i = 0;
            while (i != _int2) {
                arrayList.add(Boolean.valueOf(z));
                i = i + 1;
            }
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                num = Long.valueOf(parcel.readLong());
            }
            long l = parcel.readInt() != 0 ? 1 : i;
            PottyRemindersItem parcel2 = new PottyRemindersItem(parcel.readString(), parcel.readString(), arrayList, parcel.readString(), parcel.readString(), num, (parcel.readInt() != 0 ? 1 : i));
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final PottyRemindersItem[] newArray(int i) {
            return new PottyRemindersItem[i];
        }
    }
    public PottyRemindersItem(String str, String str2, List<Boolean> list, String str3, String str4, Long long, boolean z) {
        int str22 = 0;
        n.f(str, "reminderId");
        n.f(str2, "dogId");
        n.f(list, "days");
        n.f(str3, "startTime");
        super();
        this.reminderId = str;
        this.dogId = str2;
        this.days = list;
        this.startTime = str3;
        this.endTime = str4;
        this.repeatIntervalMs = long;
        this.isActive = z;
        str22 = 7;
        if (list.size() < 7) {
            str22 = 0;
            str22 = str22 + 1;
            this.days.add(str22, Boolean.TRUE);
            int size = 6;
            while (str22 > 6) {
                str22 = str22 + 1;
                this.days.add(str22, Boolean.TRUE);
                size = 6;
            }
        }
    }

    public final List<Boolean> getDays() {
        return this.days;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Long getIntervalMinutes() {
        Long num = null;
        if (this.repeatIntervalMs != null) {
            mILLISECONDS2 = TimeUnit.MILLISECONDS;
            num = Long.valueOf(mILLISECONDS2.toMinutes(this.repeatIntervalMs.longValue()));
        } else {
            int i = 0;
        }
        return num;
    }

    public final int getNotificationId() {
        int i = 1;
        i = 0;
        int r0 = this.reminderId.length() == 0 ? 1 : i;
        if (this.reminderId == 0) {
            while (i < this.reminderId.length()) {
                i2 = this.reminderId.charAt(i) - 43;
                i = i + i2;
                i = i + 1;
            }
            i = i % 20000;
        }
        return i;
    }

    public final String getReminderId() {
        return this.reminderId;
    }

    public final Long getRepeatIntervalMs() {
        return this.repeatIntervalMs;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isEmpty() {
        return l.z(this.reminderId);
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setStartTime(String str) {
        n.f(str, "<set-?>");
        this.startTime = str;
    }

    public final PottyReminderEntity toEntity(String userId) {
        String str;
        n.f(userId, "userId");
        if (this.endTime == null) {
            str = "";
        }
        PottyReminderEntity pottyReminderEntity = new PottyReminderEntity(this.reminderId, this.dogId, userId, this.days, this.startTime, str, this.repeatIntervalMs, this.isActive);
        return pottyReminderEntity;
    }

    public /* synthetic */ PottyRemindersItem(String str, String str2, List list, String str3, String str4, Long long, boolean z, int i, g gVar) {
        String str22;
        ArrayList arrayList;
        String str52;
        boolean z72;
        i = i & 2;
        str22 = i & 2 != 0 ? str22 : str2;
        i2 = i & 4;
        ArrayList r4 = i & 4 != 0 ? new ArrayList() : list;
        i3 = i & 16;
        int i3 = i & 16 != 0 ? i3 : str4;
        i4 = i & 64;
        int i4 = i & 64 != 0 ? i4 : z;
        this(str, str22, arrayList, str3, str52, long, z72);
    }

    static {
        PottyRemindersItem.INSTANCE = new PottyRemindersItem_Companion(null);
        PottyRemindersItem.CREATOR = new PottyRemindersItem.Creator();
    }

    public static /* synthetic */ PottyRemindersItem copy$default(PottyRemindersItem pottyRemindersItem, String str, String str2, List list, String str3, String str4, Long long, boolean z, int i, Object object) {
        String str22;
        String object102;
        List list42;
        String str52;
        String str62;
        Long long72;
        boolean z82;
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
        if (i & 32 != 0) {
        }
        if (i & 64 != 0) {
        }
        return pottyRemindersItem.copy(str22, object102, list42, str52, str62, long72, z82);
    }

    /* operator */ public final String component1() {
        return this.reminderId;
    }

    /* operator */ public final String component2() {
        return this.dogId;
    }

    /* operator */ public final List<Boolean> component3() {
        return this.days;
    }

    /* operator */ public final String component4() {
        return this.startTime;
    }

    /* operator */ public final String component5() {
        return this.endTime;
    }

    /* operator */ public final Long component6() {
        return this.repeatIntervalMs;
    }

    /* operator */ public final boolean component7() {
        return this.isActive;
    }

    public final PottyRemindersItem copy(String reminderId, String dogId, List<Boolean> days, String startTime, String endTime, Long repeatIntervalMs, boolean isActive) {
        n.f(reminderId, "reminderId");
        n.f(dogId, "dogId");
        n.f(days, "days");
        n.f(startTime, "startTime");
        PottyRemindersItem pottyRemindersItem = new PottyRemindersItem(reminderId, dogId, days, startTime, endTime, repeatIntervalMs, isActive);
        return pottyRemindersItem;
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
        final boolean z9 = false;
        if (!(other instanceof PottyRemindersItem)) {
            return false;
        }
        if (!n.b(this.reminderId, other.reminderId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.days, other.days)) {
            return false;
        }
        if (!n.b(this.startTime, other.startTime)) {
            return false;
        }
        if (!n.b(this.endTime, other.endTime)) {
            return false;
        }
        if (!n.b(this.repeatIntervalMs, other.repeatIntervalMs)) {
            return false;
        }
        return this.isActive != other.isActive ? z9 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean isActive2 = true;
        i = 0;
        if (this.endTime == null) {
        } else {
            i = this.endTime.hashCode();
        }
        if (this.repeatIntervalMs != null) {
            i = this.repeatIntervalMs.hashCode();
        }
        if (this.isActive) {
            int i18 = 1;
        }
        return (this.reminderId.hashCode() * 31) + this.dogId.hashCode() * 31 + this.days.hashCode() * 31 + this.startTime.hashCode() * 31 + i * 31 + i * 31 + isActive2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PottyRemindersItem(reminderId=";
        String str3 = ", dogId=";
        String str4 = ", days=";
        String str5 = ", startTime=";
        String str6 = ", endTime=";
        String str7 = ", repeatIntervalMs=";
        String str8 = ", isActive=";
        str = str2 + this.reminderId + str3 + this.dogId + str4 + this.days + str5 + this.startTime + str6 + this.endTime + str7 + this.repeatIntervalMs + str8 + this.isActive + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.reminderId);
        parcel.writeString(this.dogId);
        parcel.writeInt(this.days.size());
        Iterator it = this.days.iterator();
        while (it.hasNext()) {
            parcel.writeInt((Boolean)it.next().booleanValue());
        }
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        if (this.repeatIntervalMs == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(this.repeatIntervalMs.longValue());
        }
        parcel.writeInt(this.isActive);
    }
}
