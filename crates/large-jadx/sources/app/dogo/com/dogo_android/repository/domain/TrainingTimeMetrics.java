package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: TrainingTimeMetrics.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001d\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u00010BG\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JK\u0010#\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0013\u0010%\u001a\u00020\t2\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000f\"\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u000eR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "Landroid/os/Parcelable;", "weekTrainingSummary", "", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "currentStreak", "", "previousGoalNotReachedDuration", "isMetricsEnabled", "", "isDashboardCardUnlocked", "isTooltipVisible", "(Ljava/util/List;IIZZZ)V", "getCurrentStreak", "()I", "()Z", "isTodayGoalAchieved", "setTooltipVisible", "(Z)V", "getPreviousGoalNotReachedDuration", "shouldShowMetricsInDashboard", "getShouldShowMetricsInDashboard", "todaySummary", "getTodaySummary", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "todayTrainingTimeSeconds", "getTodayTrainingTimeSeconds", "getWeekTrainingSummary", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrainingTimeDay", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrainingTimeMetrics implements Parcelable {

    public static final Parcelable.Creator<TrainingTimeMetrics> CREATOR = new TrainingTimeMetrics$Creator<>();
    private final int currentStreak;
    private final boolean isDashboardCardUnlocked;
    private final boolean isMetricsEnabled;
    private boolean isTooltipVisible;
    private final int previousGoalNotReachedDuration;
    private final List<TrainingTimeMetrics.TrainingTimeDay> weekTrainingSummary;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrainingTimeMetrics> {
        @Override // android.os.Parcelable$Creator
        public final TrainingTimeMetrics createFromParcel(Parcel parcel) {
            int i;
            boolean z2;
            boolean z3;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrainingTimeMetrics_TrainingTimeDay.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            i = 1;
            int r0 = i;
            int r6 = i;
            int r7 = i;
            TrainingTimeMetrics parcel2 = new TrainingTimeMetrics(arrayList, parcel.readInt(), parcel.readInt(), i, z2, i);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final TrainingTimeMetrics[] newArray(int i) {
            return new TrainingTimeMetrics[i];
        }
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0008HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0010¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "Landroid/os/Parcelable;", "isToday", "", "durationSec", "", "dailyTrainingGoalSec", "date", "", "weekdayText", "streakStatus", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay$StreakStatus;", "(ZIILjava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay$StreakStatus;)V", "getDailyTrainingGoalSec", "()I", "getDate", "()Ljava/lang/String;", "getDurationSec", "()Z", "getStreakStatus", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay$StreakStatus;", "getWeekdayText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "StreakStatus", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingTimeDay implements Parcelable {

        public static final Parcelable.Creator<TrainingTimeMetrics.TrainingTimeDay> CREATOR = new TrainingTimeMetrics$TrainingTimeDay$Creator<>();
        private final int dailyTrainingGoalSec;
        private final String date;
        private final int durationSec;
        private final boolean isToday;
        private final TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus;
        private final String weekdayText;
        public TrainingTimeDay(boolean z, int i, int i2, String str, String str2, TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus) {
            n.f(str, "date");
            n.f(str2, "weekdayText");
            n.f(streakStatus, "streakStatus");
            super();
            this.isToday = z;
            this.durationSec = i;
            this.dailyTrainingGoalSec = i2;
            this.date = str;
            this.weekdayText = str2;
            this.streakStatus = streakStatus;
        }

        public final int getDailyTrainingGoalSec() {
            return this.dailyTrainingGoalSec;
        }

        public final String getDate() {
            return this.date;
        }

        public final int getDurationSec() {
            return this.durationSec;
        }

        public final TrainingTimeMetrics.TrainingTimeDay.StreakStatus getStreakStatus() {
            return this.streakStatus;
        }

        public final String getWeekdayText() {
            return this.weekdayText;
        }

        public final boolean isToday() {
            return this.isToday;
        }


        public static /* synthetic */ TrainingTimeMetrics.TrainingTimeDay copy$default(TrainingTimeMetrics.TrainingTimeDay trainingTimeDay, boolean z, int i, int i2, String str, String str2, TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus, int i3, Object object) {
            boolean z22;
            int object92;
            int i42;
            String str52;
            String str62;
            app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus72;
            if (i3 & 1 != 0) {
            }
            if (i3 & 2 != 0) {
            }
            if (i3 & 4 != 0) {
            }
            if (i3 & 8 != 0) {
            }
            if (i3 & 16 != 0) {
            }
            if (i3 & 32 != 0) {
            }
            return trainingTimeDay.copy(z22, object92, i42, str52, str62, streakStatus72);
        }

        /* operator */ public final boolean component1() {
            return this.isToday;
        }

        /* operator */ public final int component2() {
            return this.durationSec;
        }

        /* operator */ public final int component3() {
            return this.dailyTrainingGoalSec;
        }

        /* operator */ public final String component4() {
            return this.date;
        }

        /* operator */ public final String component5() {
            return this.weekdayText;
        }

        /* operator */ public final TrainingTimeMetrics.TrainingTimeDay.StreakStatus component6() {
            return this.streakStatus;
        }

        public final TrainingTimeMetrics.TrainingTimeDay copy(boolean isToday, int durationSec, int dailyTrainingGoalSec, String date, String weekdayText, TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus) {
            n.f(date, "date");
            n.f(weekdayText, "weekdayText");
            n.f(streakStatus, "streakStatus");
            TrainingTimeMetrics_TrainingTimeDay trainingTimeMetrics_TrainingTimeDay = new TrainingTimeMetrics_TrainingTimeDay(isToday, durationSec, dailyTrainingGoalSec, date, weekdayText, streakStatus);
            return trainingTimeMetrics_TrainingTimeDay;
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
            if (!(other instanceof TrainingTimeMetrics_TrainingTimeDay)) {
                return false;
            }
            if (this.isToday != other.isToday) {
                return false;
            }
            if (this.durationSec != other.durationSec) {
                return false;
            }
            if (this.dailyTrainingGoalSec != other.dailyTrainingGoalSec) {
                return false;
            }
            if (!n.b(this.date, other.date)) {
                return false;
            }
            if (!n.b(this.weekdayText, other.weekdayText)) {
                return false;
            }
            return this.streakStatus != other.streakStatus ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean isToday2 = true;
            if (this.isToday) {
                int i11 = 1;
            }
            return (isToday2 * 31) + Integer.hashCode(this.durationSec) * 31 + Integer.hashCode(this.dailyTrainingGoalSec) * 31 + this.date.hashCode() * 31 + this.weekdayText.hashCode() * 31 + this.streakStatus.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrainingTimeDay(isToday=";
            String str3 = ", durationSec=";
            String str4 = ", dailyTrainingGoalSec=";
            String str5 = ", date=";
            String str6 = ", weekdayText=";
            String str7 = ", streakStatus=";
            str = str2 + this.isToday + str3 + this.durationSec + str4 + this.dailyTrainingGoalSec + str5 + this.date + str6 + this.weekdayText + str7 + this.streakStatus + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.isToday);
            parcel.writeInt(this.durationSec);
            parcel.writeInt(this.dailyTrainingGoalSec);
            parcel.writeString(this.date);
            parcel.writeString(this.weekdayText);
            parcel.writeString(this.streakStatus.name());
        }
    }
    public TrainingTimeMetrics(List<TrainingTimeMetrics.TrainingTimeDay> list, int i, int i2, boolean z, boolean z2, boolean z3) {
        n.f(list, "weekTrainingSummary");
        super();
        this.weekTrainingSummary = list;
        this.currentStreak = i;
        this.previousGoalNotReachedDuration = i2;
        this.isMetricsEnabled = z;
        this.isDashboardCardUnlocked = z2;
        this.isTooltipVisible = z3;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final int getPreviousGoalNotReachedDuration() {
        return this.previousGoalNotReachedDuration;
    }

    public final boolean getShouldShowMetricsInDashboard() {
        boolean z = false;
        int r0 = this.isDashboardCardUnlocked && this.isMetricsEnabled ? 1 : 0;
        return (this.isDashboardCardUnlocked && this.isMetricsEnabled ? 1 : 0);
    }

    public final TrainingTimeMetrics.TrainingTimeDay getTodaySummary() {
        int i = 0;
        boolean today;
        Iterator it = this.weekTrainingSummary.iterator();
        while (it.hasNext()) {
            if ((TrainingTimeMetrics_TrainingTimeDay)item.isToday()) {
                break;
            }
        }
        i = 0;
        return (TrainingTimeMetrics_TrainingTimeDay)i;
    }

    public final int getTodayTrainingTimeSeconds() {
        int durationSec = 0;
        Object item = null;
        boolean today;
        Iterator it = this.weekTrainingSummary.iterator();
        while (it.hasNext()) {
            if ((TrainingTimeMetrics_TrainingTimeDay)item.isToday()) {
                break;
            }
        }
        int i = 0;
        if (item == null) {
            durationSec = 0;
        } else {
            durationSec = item.getDurationSec();
        }
        return durationSec;
    }

    public final List<TrainingTimeMetrics.TrainingTimeDay> getWeekTrainingSummary() {
        return this.weekTrainingSummary;
    }

    public final boolean isDashboardCardUnlocked() {
        return this.isDashboardCardUnlocked;
    }

    public final boolean isMetricsEnabled() {
        return this.isMetricsEnabled;
    }

    public final boolean isTodayGoalAchieved() {
        boolean z = false;
        Object item;
        app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus = null;
        boolean today;
        Iterator it = this.weekTrainingSummary.iterator();
        while (it.hasNext()) {
            if ((TrainingTimeMetrics_TrainingTimeDay)item.isToday()) {
                break;
            }
        }
        if (item != null) {
            streakStatus = item.getStreakStatus();
        }
        int r0 = streakStatus == TrainingTimeMetrics_TrainingTimeDay_StreakStatus.ACTIVE ? 1 : 0;
        return (streakStatus == TrainingTimeMetrics_TrainingTimeDay_StreakStatus.ACTIVE ? 1 : 0);
    }

    public final boolean isTooltipVisible() {
        return this.isTooltipVisible;
    }

    public final void setTooltipVisible(boolean z) {
        this.isTooltipVisible = z;
    }

    public /* synthetic */ TrainingTimeMetrics(List list, int i, int i2, boolean z, boolean z2, boolean z3, int i3, g gVar) {
        int z62 = 0;
        List list2;
        if (i3 & 1 != 0) {
            list2 = p.g();
        }
        z62 = 0;
        gVar = i3 & 2 != 0 ? z62 : i;
        int r1 = i3 & 4 != 0 ? z62 : i2;
        int r2 = i3 & 8 != 0 ? z62 : z;
        int r3 = i3 & 16 != 0 ? z62 : z2;
        if (i3 & 32 == 0) {
            z62 = z3;
        }
        this(list2, z62, z62, z62, z62, z62);
    }


    public TrainingTimeMetrics() {
        this(null, 0, 0, false, false, false, 63, null);
    }

    public static /* synthetic */ TrainingTimeMetrics copy$default(TrainingTimeMetrics trainingTimeMetrics, List list, int i, int i2, boolean z, boolean z2, boolean z3, int i3, Object object) {
        List list22;
        int object92;
        int i42;
        boolean z52;
        boolean z62;
        boolean z72;
        if (i3 & 1 != 0) {
        }
        if (i3 & 2 != 0) {
        }
        if (i3 & 4 != 0) {
        }
        if (i3 & 8 != 0) {
        }
        if (i3 & 16 != 0) {
        }
        if (i3 & 32 != 0) {
        }
        return trainingTimeMetrics.copy(list22, object92, i42, z52, z62, z72);
    }

    /* operator */ public final List<TrainingTimeMetrics.TrainingTimeDay> component1() {
        return this.weekTrainingSummary;
    }

    /* operator */ public final int component2() {
        return this.currentStreak;
    }

    /* operator */ public final int component3() {
        return this.previousGoalNotReachedDuration;
    }

    /* operator */ public final boolean component4() {
        return this.isMetricsEnabled;
    }

    /* operator */ public final boolean component5() {
        return this.isDashboardCardUnlocked;
    }

    /* operator */ public final boolean component6() {
        return this.isTooltipVisible;
    }

    public final TrainingTimeMetrics copy(List<TrainingTimeMetrics.TrainingTimeDay> weekTrainingSummary, int currentStreak, int previousGoalNotReachedDuration, boolean isMetricsEnabled, boolean isDashboardCardUnlocked, boolean isTooltipVisible) {
        n.f(weekTrainingSummary, "weekTrainingSummary");
        TrainingTimeMetrics trainingTimeMetrics = new TrainingTimeMetrics(weekTrainingSummary, currentStreak, previousGoalNotReachedDuration, isMetricsEnabled, isDashboardCardUnlocked, isTooltipVisible);
        return trainingTimeMetrics;
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
        final boolean z4 = false;
        if (!(other instanceof TrainingTimeMetrics)) {
            return false;
        }
        if (!n.b(this.weekTrainingSummary, other.weekTrainingSummary)) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        if (this.previousGoalNotReachedDuration != other.previousGoalNotReachedDuration) {
            return false;
        }
        if (this.isMetricsEnabled != other.isMetricsEnabled) {
            return false;
        }
        if (this.isDashboardCardUnlocked != other.isDashboardCardUnlocked) {
            return false;
        }
        return this.isTooltipVisible != other.isTooltipVisible ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isMetricsEnabled2;
        boolean isDashboardCardUnlocked2;
        boolean isTooltipVisible2 = true;
        int i = 1;
        if (this.isMetricsEnabled) {
        }
        if (this.isDashboardCardUnlocked) {
        }
        if (!(this.isTooltipVisible)) {
        }
        return (this.weekTrainingSummary.hashCode() * 31) + Integer.hashCode(this.currentStreak) * 31 + Integer.hashCode(this.previousGoalNotReachedDuration) * 31 + isMetricsEnabled2 * 31 + isDashboardCardUnlocked2 * 31 + isTooltipVisible2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrainingTimeMetrics(weekTrainingSummary=";
        String str3 = ", currentStreak=";
        String str4 = ", previousGoalNotReachedDuration=";
        String str5 = ", isMetricsEnabled=";
        String str6 = ", isDashboardCardUnlocked=";
        String str7 = ", isTooltipVisible=";
        str = str2 + this.weekTrainingSummary + str3 + this.currentStreak + str4 + this.previousGoalNotReachedDuration + str5 + this.isMetricsEnabled + str6 + this.isDashboardCardUnlocked + str7 + this.isTooltipVisible + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.weekTrainingSummary.size());
        Iterator it = this.weekTrainingSummary.iterator();
        while (it.hasNext()) {
            (TrainingTimeMetrics_TrainingTimeDay)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.previousGoalNotReachedDuration);
        parcel.writeInt(this.isMetricsEnabled);
        parcel.writeInt(this.isDashboardCardUnlocked);
        parcel.writeInt(this.isTooltipVisible);
    }
}
