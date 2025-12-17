package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.DateUtils;
import app.dogo.com.dogo_android.s.b.f1.b;
import app.dogo.com.dogo_android.u.k;
import app.dogo.com.dogo_android.u.k.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008!\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u007f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c\u0012\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000c\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000f\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cHÆ\u0003J\u000f\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000cHÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0083\u0001\u0010.\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0004HÆ\u0001J\t\u0010/\u001a\u00020\tHÖ\u0001J\u0013\u00100\u001a\u00020\u00102\u0008\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000cJ\u0006\u00104\u001a\u00020\u0010J\u0006\u00105\u001a\u00020\u0010J\u0006\u00106\u001a\u00020\u0010J\t\u00107\u001a\u00020\tHÖ\u0001J\u0006\u00108\u001a\u00020\u0010J\u0008\u00109\u001a\u00020\tH\u0002J\t\u0010:\u001a\u00020\u0004HÖ\u0001J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\tHÖ\u0001R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0018R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u001cR\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0018R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010!¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramProgress;", "programId", "", "startedTimeMs", "", "stoppedTimeMs", "cleanDaysStreak", "", "logStreak", "readArticles", "", "calendarLogs", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$DogLogEntity;", "isRecommended", "", "isCompleted", "certificatePdfUrl", "certificateImageUrl", "(Ljava/lang/String;JJIILjava/util/List;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/String;)V", "getCalendarLogs", "()Ljava/util/List;", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "getCleanDaysStreak", "()I", "()Z", "getLogStreak", "getProgramId", "getReadArticles", "getStartedTimeMs", "()J", "getStoppedTimeMs", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "fillPottyCheckmarksList", "hasLogs", "hasProgress", "hasReachedPottyGoal", "hashCode", "isEnrolled", "pottyLogsTodayCount", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PottyProgramProgress implements Parcelable, k {

    public static final int CLEAN_DAYS_FOR_REACHING_POTTY_GOAL = 14;
    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.PottyProgramProgress> CREATOR;
    public static final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress.Companion Companion;
    private final List<f1.b> calendarLogs;
    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    private final int cleanDaysStreak;
    private final boolean isCompleted;
    private final boolean isRecommended;
    private final int logStreak;
    private final String programId;
    private final List<String> readArticles;
    private final long startedTimeMs;
    private final long stoppedTimeMs;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress$Companion;", "", "()V", "CLEAN_DAYS_FOR_REACHING_POTTY_GOAL", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.PottyProgramProgress> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress createFromParcel(Parcel parcel) {
            int i;
            int i2;
            Object fromParcel;
            int i3;
            Object obj = parcel;
            n.f(obj, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            int i4 = 0;
            i2 = i4;
            while (i2 != int) {
                arrayList.add(f1.b.CREATOR.createFromParcel(obj));
                i2++;
            }
            int i5 = 1;
            i = parcel.readInt() != 0 ? i5 : i4;
            i3 = parcel.readInt() != 0 ? i5 : i4;
            super(parcel.readString(), parcel.readLong(), obj5, parcel.readLong(), obj7, parcel.readInt(), parcel.readInt(), parcel.createStringArrayList(), arrayList, i, i3, parcel.readString(), parcel.readString());
            return pottyProgramProgress;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress[] newArray(int i) {
            return new PottyProgramProgress[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        PottyProgramProgress.Companion companion = new PottyProgramProgress.Companion(0);
        PottyProgramProgress.Companion = companion;
        PottyProgramProgress.Creator creator = new PottyProgramProgress.Creator();
        PottyProgramProgress.CREATOR = creator;
    }

    public PottyProgramProgress() {
        super(0, 0, obj3, 0, obj5, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
    }

    public PottyProgramProgress(String string, long l2, long l3, int i4, int i5, List<String> list6, List<f1.b> list7, boolean z8, boolean z9, String string10, String string11) {
        n.f(string, "programId");
        n.f(z8, "readArticles");
        n.f(z9, "calendarLogs");
        n.f(obj13, "certificatePdfUrl");
        n.f(obj14, "certificateImageUrl");
        super();
        this.programId = string;
        this.startedTimeMs = l2;
        this.stoppedTimeMs = i4;
        this.cleanDaysStreak = list6;
        this.logStreak = list7;
        this.readArticles = z8;
        this.calendarLogs = z9;
        this.isRecommended = string10;
        this.isCompleted = string11;
        this.certificatePdfUrl = obj13;
        this.certificateImageUrl = obj14;
    }

    public PottyProgramProgress(String string, long l2, long l3, int i4, int i5, List list6, List list7, boolean z8, boolean z9, String string10, String string11, int i12, g g13) {
        String str2;
        int i3;
        int i6;
        int i;
        int i2;
        int i7;
        List list2;
        List list;
        int i8;
        String str;
        String str3;
        int i9 = obj28;
        str2 = i9 & 1 != 0 ? "id_potty_program" : string;
        i = i9 & 2 != 0 ? i6 : l2;
        if (i9 & 4 != 0) {
        } else {
            i6 = i4;
        }
        i2 = 0;
        i3 = i9 & 8 != 0 ? i2 : list6;
        i7 = i9 & 16 != 0 ? i2 : list7;
        if (i9 & 32 != 0) {
            list2 = p.g();
        } else {
            list2 = z8;
        }
        if (i9 & 64 != 0) {
            list = p.g();
        } else {
            list = z9;
        }
        i8 = i9 & 128 != 0 ? i2 : string10;
        if (i9 & 256 != 0) {
        } else {
            i2 = string11;
        }
        str = i9 & 512 != 0 ? str3 : i12;
        if (i9 &= 1024 != 0) {
        } else {
            str3 = g13;
        }
        super(str2, i, i4, i6, list6, i3, i7, list2, list, i8, i2, str, str3);
    }

    public static app.dogo.com.dogo_android.repository.domain.PottyProgramProgress copy$default(app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress, String string2, long l3, long l4, int i5, int i6, List list7, List list8, boolean z9, boolean z10, String string11, String string12, int i13, Object object14) {
        String certificateImageUrl;
        String programId;
        long startedTimeMs;
        long stoppedTimeMs;
        int cleanDaysStreak;
        int logStreak;
        List readArticles;
        List calendarLogs;
        boolean isRecommended;
        boolean isCompleted;
        String certificatePdfUrl;
        Object obj = pottyProgramProgress;
        int i = obj28;
        programId = i & 1 != 0 ? obj.programId : string2;
        if (i & 2 != 0) {
            startedTimeMs = pottyProgramProgress.getStartedTimeMs();
        } else {
            startedTimeMs = l3;
        }
        if (i & 4 != 0) {
            stoppedTimeMs = pottyProgramProgress.getStoppedTimeMs();
        } else {
            stoppedTimeMs = i5;
        }
        cleanDaysStreak = i & 8 != 0 ? obj.cleanDaysStreak : list7;
        logStreak = i & 16 != 0 ? obj.logStreak : list8;
        readArticles = i & 32 != 0 ? obj.readArticles : z9;
        calendarLogs = i & 64 != 0 ? obj.calendarLogs : z10;
        isRecommended = i & 128 != 0 ? obj.isRecommended : string11;
        isCompleted = i & 256 != 0 ? obj.isCompleted : string12;
        certificatePdfUrl = i & 512 != 0 ? obj.certificatePdfUrl : i13;
        certificateImageUrl = i &= 1024 != 0 ? obj.certificateImageUrl : object14;
        return pottyProgramProgress.copy(programId, startedTimeMs, l4, stoppedTimeMs, i6, cleanDaysStreak, logStreak, readArticles, calendarLogs, isRecommended, isCompleted);
    }

    private final int pottyLogsTodayCount() {
        Object calendarLogs;
        boolean today;
        int i;
        long l;
        calendarLogs = this.calendarLogs;
        i = 0;
        if (calendarLogs instanceof Collection != null && calendarLogs.isEmpty()) {
            if (calendarLogs.isEmpty()) {
            } else {
                calendarLogs = calendarLogs.iterator();
                for (f1.b next : calendarLogs) {
                }
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component10() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final String component11() {
        return this.certificateImageUrl;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return getStartedTimeMs();
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return getStoppedTimeMs();
    }

    @Override // android.os.Parcelable
    public final int component4() {
        return this.cleanDaysStreak;
    }

    @Override // android.os.Parcelable
    public final int component5() {
        return this.logStreak;
    }

    public final List<String> component6() {
        return this.readArticles;
    }

    public final List<f1.b> component7() {
        return this.calendarLogs;
    }

    @Override // android.os.Parcelable
    public final boolean component8() {
        return this.isRecommended;
    }

    @Override // android.os.Parcelable
    public final boolean component9() {
        return this.isCompleted;
    }

    public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress copy(String string, long l2, long l3, int i4, int i5, List<String> list6, List<f1.b> list7, boolean z8, boolean z9, String string10, String string11) {
        final Object obj = string;
        n.f(obj, "programId");
        final Object obj2 = z8;
        n.f(obj2, "readArticles");
        final Object obj3 = z9;
        n.f(obj3, "calendarLogs");
        final Object obj4 = obj27;
        n.f(obj4, "certificatePdfUrl");
        final Object obj5 = obj28;
        n.f(obj5, "certificateImageUrl");
        super(obj, l2, obj4, i4, obj6, list6, list7, obj2, obj3, string10, string11, obj4, obj5);
        return pottyProgramProgress;
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
        if (!object instanceof PottyProgramProgress) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (Long.compare(startedTimeMs, startedTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(stoppedTimeMs, stoppedTimeMs2) != 0) {
            return i2;
        }
        if (this.cleanDaysStreak != object.cleanDaysStreak) {
            return i2;
        }
        if (this.logStreak != object.logStreak) {
            return i2;
        }
        if (!n.b(this.readArticles, object.readArticles)) {
            return i2;
        }
        if (!n.b(this.calendarLogs, object.calendarLogs)) {
            return i2;
        }
        if (this.isRecommended != object.isRecommended) {
            return i2;
        }
        if (this.isCompleted != object.isCompleted) {
            return i2;
        }
        if (!n.b(this.certificatePdfUrl, object.certificatePdfUrl)) {
            return i2;
        }
        if (!n.b(this.certificateImageUrl, object.certificateImageUrl)) {
            return i2;
        }
        return i;
    }

    public final List<Boolean> fillPottyCheckmarksList() {
        int i3;
        int i;
        Boolean valueOf;
        int i2;
        ArrayList arrayList = new ArrayList();
        final int i4 = 0;
        i3 = i4;
        i = i3 + 1;
        while (i3 < pottyLogsTodayCount()) {
            i2 = 1;
            arrayList.add(i3, Boolean.valueOf(i2));
            if (i <= 4) {
            }
            i3 = i;
            i = i3 + 1;
            i2 = i4;
        }
        return arrayList;
    }

    public final List<f1.b> getCalendarLogs() {
        return this.calendarLogs;
    }

    @Override // android.os.Parcelable
    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final int getCleanDaysStreak() {
        return this.cleanDaysStreak;
    }

    @Override // android.os.Parcelable
    public final int getLogStreak() {
        return this.logStreak;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    public final List<String> getReadArticles() {
        return this.readArticles;
    }

    @Override // android.os.Parcelable
    public long getStartedTimeMs() {
        return this.startedTimeMs;
    }

    @Override // android.os.Parcelable
    public long getStoppedTimeMs() {
        return this.stoppedTimeMs;
    }

    @Override // android.os.Parcelable
    public final boolean hasLogs() {
        return empty ^= 1;
    }

    @Override // android.os.Parcelable
    public final boolean hasProgress() {
        int i;
        int i2;
        i2 = 1;
        if (empty ^= i2 == 0) {
            if (empty2 ^= i2 != 0) {
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    @Override // android.os.Parcelable
    public final boolean hasReachedPottyGoal() {
        return this.isCompleted;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isRecommended;
        int i;
        if (this.isRecommended) {
            isRecommended = i;
        }
        boolean isCompleted = this.isCompleted;
        if (isCompleted) {
        } else {
            i = isCompleted;
        }
        return i21 += i30;
    }

    @Override // android.os.Parcelable
    public boolean isActive() {
        return k.a.a(this);
    }

    @Override // android.os.Parcelable
    public final boolean isCompleted() {
        return this.isCompleted;
    }

    @Override // android.os.Parcelable
    public final boolean isEnrolled() {
        boolean isRecommended;
        int i;
        if (this.isRecommended) {
            if (isStopped()) {
                i = isActive() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isRecommended() {
        return this.isRecommended;
    }

    @Override // android.os.Parcelable
    public boolean isStopped() {
        return k.a.b(this);
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PottyProgramProgress(programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", startedTimeMs=");
        stringBuilder.append(getStartedTimeMs());
        stringBuilder.append(", stoppedTimeMs=");
        stringBuilder.append(getStoppedTimeMs());
        stringBuilder.append(", cleanDaysStreak=");
        stringBuilder.append(this.cleanDaysStreak);
        stringBuilder.append(", logStreak=");
        stringBuilder.append(this.logStreak);
        stringBuilder.append(", readArticles=");
        stringBuilder.append(this.readArticles);
        stringBuilder.append(", calendarLogs=");
        stringBuilder.append(this.calendarLogs);
        stringBuilder.append(", isRecommended=");
        stringBuilder.append(this.isRecommended);
        stringBuilder.append(", isCompleted=");
        stringBuilder.append(this.isCompleted);
        stringBuilder.append(", certificatePdfUrl=");
        stringBuilder.append(this.certificatePdfUrl);
        stringBuilder.append(", certificateImageUrl=");
        stringBuilder.append(this.certificateImageUrl);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeLong(this.startedTimeMs);
        parcel.writeLong(this.stoppedTimeMs);
        parcel.writeInt(this.cleanDaysStreak);
        parcel.writeInt(this.logStreak);
        parcel.writeStringList(this.readArticles);
        List calendarLogs = this.calendarLogs;
        parcel.writeInt(calendarLogs.size());
        Iterator iterator = calendarLogs.iterator();
        for (f1.b size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.isRecommended);
        parcel.writeInt(this.isCompleted);
        parcel.writeString(this.certificatePdfUrl);
        parcel.writeString(this.certificateImageUrl);
    }
}
