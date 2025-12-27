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

/* compiled from: PottyProgramProgress.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008!\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u007f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c\u0012\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000c\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000f\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cHÆ\u0003J\u000f\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000cHÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0083\u0001\u0010.\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0004HÆ\u0001J\t\u0010/\u001a\u00020\tHÖ\u0001J\u0013\u00100\u001a\u00020\u00102\u0008\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000cJ\u0006\u00104\u001a\u00020\u0010J\u0006\u00105\u001a\u00020\u0010J\u0006\u00106\u001a\u00020\u0010J\t\u00107\u001a\u00020\tHÖ\u0001J\u0006\u00108\u001a\u00020\u0010J\u0008\u00109\u001a\u00020\tH\u0002J\t\u0010:\u001a\u00020\u0004HÖ\u0001J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\tHÖ\u0001R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0018R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u001cR\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0018R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010!¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramProgress;", "programId", "", "startedTimeMs", "", "stoppedTimeMs", "cleanDaysStreak", "", "logStreak", "readArticles", "", "calendarLogs", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$DogLogEntity;", "isRecommended", "", "isCompleted", "certificatePdfUrl", "certificateImageUrl", "(Ljava/lang/String;JJIILjava/util/List;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/String;)V", "getCalendarLogs", "()Ljava/util/List;", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "getCleanDaysStreak", "()I", "()Z", "getLogStreak", "getProgramId", "getReadArticles", "getStartedTimeMs", "()J", "getStoppedTimeMs", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "fillPottyCheckmarksList", "hasLogs", "hasProgress", "hasReachedPottyGoal", "hashCode", "isEnrolled", "pottyLogsTodayCount", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PottyProgramProgress implements Parcelable, k {

    public static final int CLEAN_DAYS_FOR_REACHING_POTTY_GOAL = 14;
    public static final Parcelable.Creator<PottyProgramProgress> CREATOR = new PottyProgramProgress$Creator<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final PottyProgramProgress.Companion INSTANCE = new PottyProgramProgress$Companion(0);
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
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PottyProgramProgress> {
        @Override // android.os.Parcelable$Creator
        public final PottyProgramProgress createFromParcel(Parcel parcel) {
            int i;
            String str3;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(DogLogRepository_DogLogEntity.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            i = 1;
            int r1 = i;
            int r13 = i;
            PottyProgramProgress pottyProgramProgress = new PottyProgramProgress(parcel.readString(), parcel.readLong(), l, parcel.readLong(), i2, parcel.readInt(), parcel.readInt(), parcel.createStringArrayList(), arrayList, i, i, parcel.readString(), parcel.readString());
            return pottyProgramProgress;
        }

        @Override // android.os.Parcelable$Creator
        public final PottyProgramProgress[] newArray(int i) {
            return new PottyProgramProgress[i];
        }
    }
    public PottyProgramProgress(String str, long j, long j2, int i, int i2, List<String> list, List<f1.b> list2, boolean z, boolean z2, String str2, String str3) {
        n.f(str, "programId");
        n.f(list, "readArticles");
        n.f(list2, "calendarLogs");
        n.f(str2, "certificatePdfUrl");
        n.f(str3, "certificateImageUrl");
        super();
        this.programId = str;
        this.startedTimeMs = j;
        this.stoppedTimeMs = j2;
        this.cleanDaysStreak = i;
        this.logStreak = i2;
        this.readArticles = list;
        this.calendarLogs = list2;
        this.isRecommended = z;
        this.isCompleted = z2;
        this.certificatePdfUrl = str2;
        this.certificateImageUrl = str3;
    }

    private final int pottyLogsTodayCount() {
        boolean hasNext;
        int i = 0;
        long l;
        hasNext = calendarLogs2 instanceof Collection;
        i = 0;
        if (!(calendarLogs2 instanceof Collection) || !this.calendarLogs.isEmpty()) {
            Iterator it = this.calendarLogs.iterator();
            while (it.hasNext()) {
                if (DateUtils.isToday((DogLogRepository_DogLogEntity)it.next().c())) {
                    i = i + 1;
                }
            }
        }
        return i;
    }

    public final List<Boolean> fillPottyCheckmarksList() {
        int i;
        boolean z = true;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        i = i + 1;
        while (i < pottyLogsTodayCount()) {
            int i3 = 1;
            arrayList.add(i, Boolean.valueOf(z));
            if (i > 4) {
                return arrayList;
            }
        }
        return arrayList;
    }

    public final List<f1.b> getCalendarLogs() {
        return this.calendarLogs;
    }

    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    public final int getCleanDaysStreak() {
        return this.cleanDaysStreak;
    }

    public final int getLogStreak() {
        return this.logStreak;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final List<String> getReadArticles() {
        return this.readArticles;
    }

    public long getStartedTimeMs() {
        return this.startedTimeMs;
    }

    public long getStoppedTimeMs() {
        return this.stoppedTimeMs;
    }

    public final boolean hasLogs() {
        return !this.calendarLogs.isEmpty();
    }

    public final boolean hasProgress() {
        boolean z = true;
        int i2 = 1;
        i = this.readArticles.isEmpty() ^ i2;
        if (!this.readArticles.isEmpty() ^ i2) {
            i = this.calendarLogs.isEmpty() ^ i2;
            if (!(this.calendarLogs.isEmpty() ^ i2)) {
                int i3 = 0;
            }
        }
        return z;
    }

    public final boolean hasReachedPottyGoal() {
        return this.isCompleted;
    }

    public boolean isActive() {
        return app.dogo.com.dogo_android.specialprograms.k.a.a(this);
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final boolean isEnrolled() {
        boolean z = true;
        if (!this.isRecommended || this.isStopped()) {
            int r0 = isActive() ? 1 : 0;
        }
        return (isActive() ? 1 : 0);
    }

    public final boolean isRecommended() {
        return this.isRecommended;
    }

    public boolean isStopped() {
        return app.dogo.com.dogo_android.specialprograms.k.a.b(this);
    }

    public /* synthetic */ PottyProgramProgress(String str, long j, long j2, int i, int i2, List list, List list2, boolean z, boolean z2, String str2, String str3, int i3, g gVar) {
        int list62;
        long i42 = 0;
        int j22;
        List z82;
        List z92;
        String i122;
        i = i3;
        String r1 = i & 1 != 0 ? "id_potty_program" : str;
        int r5 = i & 2 != 0 ? 0 : j;
        if (i & 4 == 0) {
            i42 = j2;
        }
        list62 = 0;
        int r2 = i & 8 != 0 ? list62 : i;
        int r8 = i & 16 != 0 ? list62 : i2;
        if (i & 32 != 0) {
            z82 = p.g();
        } else {
            z82 = list;
        }
        if (i & 64 != 0) {
            z92 = p.g();
        } else {
            z92 = list2;
        }
        int r11 = i & 128 != 0 ? list62 : z;
        if (i & 256 == 0) {
            list62 = z2;
        }
        i122 = "";
        String r12 = i & 512 != 0 ? "" : str2;
        if (i & 1024 == 0) {
            i122 = str3;
        }
        this(str2, j22, j2, i42, i, list62, list62, z82, z92, list62, list62, i122, i122);
    }


    public PottyProgramProgress() {
        this(null, 0L, l, 0, i4, null, null, false, false, null, null, 0, null, 2047, 0);
    }

    public static /* synthetic */ PottyProgramProgress copy$default(PottyProgramProgress pottyProgramProgress, String str, long j, long j2, int i, int i2, List list, List list2, boolean z, boolean z2, String str2, String str3, int i3, Object object) {
        String object142;
        String str22;
        long j32;
        long i52;
        int list72;
        int list82;
        List z92;
        List z102;
        boolean str112;
        boolean str122;
        String i132;
        Object pottyProgramProgress2 = pottyProgramProgress;
        i = i3;
        String r2 = i & 1 != 0 ? pottyProgramProgress2.programId : str;
        if (i & 2 != 0) {
            j32 = pottyProgramProgress.getStartedTimeMs();
        } else {
            j32 = j;
        }
        if (i & 4 != 0) {
            i52 = pottyProgramProgress.getStoppedTimeMs();
        } else {
            i52 = j2;
        }
        int r7 = i & 8 != 0 ? pottyProgramProgress2.cleanDaysStreak : i;
        int r8 = i & 16 != 0 ? pottyProgramProgress2.logStreak : i2;
        List r9 = i & 32 != 0 ? pottyProgramProgress2.readArticles : list;
        List r10 = i & 64 != 0 ? pottyProgramProgress2.calendarLogs : list2;
        boolean r11 = i & 128 != 0 ? pottyProgramProgress2.isRecommended : z;
        boolean r12 = i & 256 != 0 ? pottyProgramProgress2.isCompleted : z2;
        String r13 = i & 512 != 0 ? pottyProgramProgress2.certificatePdfUrl : str2;
        String r1 = i & 1024 != 0 ? pottyProgramProgress2.certificateImageUrl : str3;
        return pottyProgramProgress.copy(str22, j32, r17, i52, r19, list72, list82, z92, z102, str112, str122, i132, (i & 1024 != 0 ? pottyProgramProgress2.certificateImageUrl : str3));
    }

    /* operator */ public final String component1() {
        return this.programId;
    }

    /* operator */ public final String component10() {
        return this.certificatePdfUrl;
    }

    /* operator */ public final String component11() {
        return this.certificateImageUrl;
    }

    /* operator */ public final long component2() {
        return getStartedTimeMs();
    }

    /* operator */ public final long component3() {
        return getStoppedTimeMs();
    }

    /* operator */ public final int component4() {
        return this.cleanDaysStreak;
    }

    /* operator */ public final int component5() {
        return this.logStreak;
    }

    /* operator */ public final List<String> component6() {
        return this.readArticles;
    }

    /* operator */ public final List<f1.b> component7() {
        return this.calendarLogs;
    }

    /* operator */ public final boolean component8() {
        return this.isRecommended;
    }

    /* operator */ public final boolean component9() {
        return this.isCompleted;
    }

    public final PottyProgramProgress copy(String programId, long startedTimeMs, long stoppedTimeMs, int cleanDaysStreak, int logStreak, List<String> readArticles, List<f1.b> calendarLogs, boolean isRecommended, boolean isCompleted, String certificatePdfUrl, String certificateImageUrl) {
        final Object programId2 = programId;
        n.f(programId2, "programId");
        final Object isRecommended2 = readArticles;
        n.f(isRecommended2, "readArticles");
        final Object isCompleted2 = calendarLogs;
        n.f(isCompleted2, "calendarLogs");
        final Object obj = certificatePdfUrl;
        n.f(obj, "certificatePdfUrl");
        final Object obj2 = certificateImageUrl;
        n.f(obj2, "certificateImageUrl");
        PottyProgramProgress pottyProgramProgress = new PottyProgramProgress(programId2, startedTimeMs, l, stoppedTimeMs, i, cleanDaysStreak, logStreak, isRecommended2, isCompleted2, isRecommended, isCompleted, obj, obj2);
        return pottyProgramProgress;
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
        final boolean z7 = false;
        if (!(other instanceof PottyProgramProgress)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        long startedTimeMs = getStartedTimeMs();
        long startedTimeMs2 = other.getStartedTimeMs();
        if (startedTimeMs != startedTimeMs2) {
            return false;
        }
        long stoppedTimeMs = getStoppedTimeMs();
        long stoppedTimeMs2 = other.getStoppedTimeMs();
        if (stoppedTimeMs != stoppedTimeMs2) {
            return false;
        }
        if (this.cleanDaysStreak != other.cleanDaysStreak) {
            return false;
        }
        if (this.logStreak != other.logStreak) {
            return false;
        }
        if (!n.b(this.readArticles, other.readArticles)) {
            return false;
        }
        if (!n.b(this.calendarLogs, other.calendarLogs)) {
            return false;
        }
        if (this.isRecommended != other.isRecommended) {
            return false;
        }
        if (this.isCompleted != other.isCompleted) {
            return false;
        }
        if (!n.b(this.certificatePdfUrl, other.certificatePdfUrl)) {
            return false;
        }
        return !n.b(this.certificateImageUrl, other.certificateImageUrl) ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isRecommended2;
        int i = 1;
        i = 1;
        if (this.isRecommended) {
        }
        if (!(this.isCompleted)) {
        }
        return (this.programId.hashCode() * 31) + Long.hashCode(getStartedTimeMs()) * 31 + Long.hashCode(getStoppedTimeMs()) * 31 + Integer.hashCode(this.cleanDaysStreak) * 31 + Integer.hashCode(this.logStreak) * 31 + this.readArticles.hashCode() * 31 + this.calendarLogs.hashCode() * 31 + isRecommended2 * 31 + i * 31 + this.certificatePdfUrl.hashCode() * 31 + this.certificateImageUrl.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PottyProgramProgress(programId=";
        String str3 = ", startedTimeMs=";
        long startedTimeMs = getStartedTimeMs();
        String str4 = ", stoppedTimeMs=";
        long stoppedTimeMs = getStoppedTimeMs();
        String str5 = ", cleanDaysStreak=";
        String str6 = ", logStreak=";
        String str7 = ", readArticles=";
        String str8 = ", calendarLogs=";
        String str9 = ", isRecommended=";
        String str10 = ", isCompleted=";
        String str11 = ", certificatePdfUrl=";
        String str12 = ", certificateImageUrl=";
        str = str2 + this.programId + str3 + startedTimeMs + str4 + stoppedTimeMs + str5 + this.cleanDaysStreak + str6 + this.logStreak + str7 + this.readArticles + str8 + this.calendarLogs + str9 + this.isRecommended + str10 + this.isCompleted + str11 + this.certificatePdfUrl + str12 + this.certificateImageUrl + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeLong(this.startedTimeMs);
        parcel.writeLong(this.stoppedTimeMs);
        parcel.writeInt(this.cleanDaysStreak);
        parcel.writeInt(this.logStreak);
        parcel.writeStringList(this.readArticles);
        parcel.writeInt(this.calendarLogs.size());
        Iterator it = this.calendarLogs.iterator();
        while (it.hasNext()) {
            (DogLogRepository_DogLogEntity)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isRecommended);
        parcel.writeInt(this.isCompleted);
        parcel.writeString(this.certificatePdfUrl);
        parcel.writeString(this.certificateImageUrl);
    }
}
