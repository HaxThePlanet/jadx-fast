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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001d\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u00010BG\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JK\u0010#\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0013\u0010%\u001a\u00020\t2\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000f\"\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u000eR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "Landroid/os/Parcelable;", "weekTrainingSummary", "", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "currentStreak", "", "previousGoalNotReachedDuration", "isMetricsEnabled", "", "isDashboardCardUnlocked", "isTooltipVisible", "(Ljava/util/List;IIZZZ)V", "getCurrentStreak", "()I", "()Z", "isTodayGoalAchieved", "setTooltipVisible", "(Z)V", "getPreviousGoalNotReachedDuration", "shouldShowMetricsInDashboard", "getShouldShowMetricsInDashboard", "todaySummary", "getTodaySummary", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "todayTrainingTimeSeconds", "getTodayTrainingTimeSeconds", "getWeekTrainingSummary", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrainingTimeDay", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrainingTimeMetrics implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics> CREATOR;
    private final int currentStreak;
    private final boolean isDashboardCardUnlocked;
    private final boolean isMetricsEnabled;
    private boolean isTooltipVisible;
    private final int previousGoalNotReachedDuration;
    private final List<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay> weekTrainingSummary;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics createFromParcel(Parcel parcel) {
            int i;
            int i3;
            Object fromParcel;
            int i4;
            int i2;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            int i5 = 0;
            i3 = i5;
            while (i3 != int) {
                arrayList.add(TrainingTimeMetrics.TrainingTimeDay.CREATOR.createFromParcel(parcel));
                i3++;
            }
            int i6 = 1;
            i = parcel.readInt() != 0 ? i6 : i5;
            i4 = parcel.readInt() != 0 ? i6 : i5;
            i2 = parcel.readInt() != 0 ? i6 : i5;
            super(arrayList, parcel.readInt(), parcel.readInt(), i, i4, i2);
            return obj9;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics[] newArray(int i) {
            return new TrainingTimeMetrics[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0008HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0010¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay;", "Landroid/os/Parcelable;", "isToday", "", "durationSec", "", "dailyTrainingGoalSec", "date", "", "weekdayText", "streakStatus", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay$StreakStatus;", "(ZIILjava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay$StreakStatus;)V", "getDailyTrainingGoalSec", "()I", "getDate", "()Ljava/lang/String;", "getDurationSec", "()Z", "getStreakStatus", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics$TrainingTimeDay$StreakStatus;", "getWeekdayText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "StreakStatus", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingTimeDay implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay> CREATOR;
        private final int dailyTrainingGoalSec;
        private final String date;
        private final int durationSec;
        private final boolean isToday;
        private final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus;
        private final String weekdayText;
        static {
            TrainingTimeMetrics.TrainingTimeDay.Creator creator = new TrainingTimeMetrics.TrainingTimeDay.Creator();
            TrainingTimeMetrics.TrainingTimeDay.CREATOR = creator;
        }

        public TrainingTimeDay(boolean z, int i2, int i3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus trainingTimeMetrics$TrainingTimeDay$StreakStatus6) {
            n.f(string4, "date");
            n.f(string5, "weekdayText");
            n.f(streakStatus6, "streakStatus");
            super();
            this.isToday = z;
            this.durationSec = i2;
            this.dailyTrainingGoalSec = i3;
            this.date = string4;
            this.weekdayText = string5;
            this.streakStatus = streakStatus6;
        }

        public static app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay copy$default(app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay trainingTimeMetrics$TrainingTimeDay, boolean z2, int i3, int i4, String string5, String string6, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus trainingTimeMetrics$TrainingTimeDay$StreakStatus7, int i8, Object object9) {
            boolean obj5;
            int obj6;
            int obj7;
            String obj8;
            String obj9;
            app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus obj10;
            if (i8 & 1 != 0) {
                obj5 = trainingTimeDay.isToday;
            }
            if (i8 & 2 != 0) {
                obj6 = trainingTimeDay.durationSec;
            }
            if (i8 & 4 != 0) {
                obj7 = trainingTimeDay.dailyTrainingGoalSec;
            }
            if (i8 & 8 != 0) {
                obj8 = trainingTimeDay.date;
            }
            if (i8 & 16 != 0) {
                obj9 = trainingTimeDay.weekdayText;
            }
            if (i8 & 32 != 0) {
                obj10 = trainingTimeDay.streakStatus;
            }
            return trainingTimeDay.copy(obj5, obj6, obj7, obj8, obj9, obj10);
        }

        @Override // android.os.Parcelable
        public final boolean component1() {
            return this.isToday;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.durationSec;
        }

        @Override // android.os.Parcelable
        public final int component3() {
            return this.dailyTrainingGoalSec;
        }

        @Override // android.os.Parcelable
        public final String component4() {
            return this.date;
        }

        @Override // android.os.Parcelable
        public final String component5() {
            return this.weekdayText;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus component6() {
            return this.streakStatus;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay copy(boolean z, int i2, int i3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus trainingTimeMetrics$TrainingTimeDay$StreakStatus6) {
            n.f(string4, "date");
            n.f(string5, "weekdayText");
            n.f(streakStatus6, "streakStatus");
            super(z, i2, i3, string4, string5, streakStatus6);
            return trainingTimeDay;
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
            if (!object instanceof TrainingTimeMetrics.TrainingTimeDay) {
                return i2;
            }
            if (this.isToday != object.isToday) {
                return i2;
            }
            if (this.durationSec != object.durationSec) {
                return i2;
            }
            if (this.dailyTrainingGoalSec != object.dailyTrainingGoalSec) {
                return i2;
            }
            if (!n.b(this.date, object.date)) {
                return i2;
            }
            if (!n.b(this.weekdayText, object.weekdayText)) {
                return i2;
            }
            if (this.streakStatus != object.streakStatus) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getDailyTrainingGoalSec() {
            return this.dailyTrainingGoalSec;
        }

        @Override // android.os.Parcelable
        public final String getDate() {
            return this.date;
        }

        @Override // android.os.Parcelable
        public final int getDurationSec() {
            return this.durationSec;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus getStreakStatus() {
            return this.streakStatus;
        }

        @Override // android.os.Parcelable
        public final String getWeekdayText() {
            return this.weekdayText;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean isToday;
            if (this.isToday) {
                isToday = 1;
            }
            return i9 += i15;
        }

        @Override // android.os.Parcelable
        public final boolean isToday() {
            return this.isToday;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrainingTimeDay(isToday=");
            stringBuilder.append(this.isToday);
            stringBuilder.append(", durationSec=");
            stringBuilder.append(this.durationSec);
            stringBuilder.append(", dailyTrainingGoalSec=");
            stringBuilder.append(this.dailyTrainingGoalSec);
            stringBuilder.append(", date=");
            stringBuilder.append(this.date);
            stringBuilder.append(", weekdayText=");
            stringBuilder.append(this.weekdayText);
            stringBuilder.append(", streakStatus=");
            stringBuilder.append(this.streakStatus);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeInt(this.isToday);
            parcel.writeInt(this.durationSec);
            parcel.writeInt(this.dailyTrainingGoalSec);
            parcel.writeString(this.date);
            parcel.writeString(this.weekdayText);
            parcel.writeString(this.streakStatus.name());
        }
    }
    static {
        TrainingTimeMetrics.Creator creator = new TrainingTimeMetrics.Creator();
        TrainingTimeMetrics.CREATOR = creator;
    }

    public TrainingTimeMetrics() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public TrainingTimeMetrics(List<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay> list, int i2, int i3, boolean z4, boolean z5, boolean z6) {
        n.f(list, "weekTrainingSummary");
        super();
        this.weekTrainingSummary = list;
        this.currentStreak = i2;
        this.previousGoalNotReachedDuration = i3;
        this.isMetricsEnabled = z4;
        this.isDashboardCardUnlocked = z5;
        this.isTooltipVisible = z6;
    }

    public TrainingTimeMetrics(List list, int i2, int i3, boolean z4, boolean z5, boolean z6, int i7, g g8) {
        int i;
        int i5;
        int i4;
        int i6;
        List obj5;
        int obj12;
        if (i7 & 1 != 0) {
            obj5 = p.g();
        }
        i = 0;
        obj12 = i7 & 2 != 0 ? i : i2;
        i5 = i7 & 4 != 0 ? i : i3;
        i4 = i7 & 8 != 0 ? i : z4;
        i6 = i7 & 16 != 0 ? i : z5;
        if (i7 & 32 != 0) {
        } else {
            i = z6;
        }
        super(obj5, obj12, i5, i4, i6, i);
    }

    public static app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics copy$default(app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics, List list2, int i3, int i4, boolean z5, boolean z6, boolean z7, int i8, Object object9) {
        List obj5;
        int obj6;
        int obj7;
        boolean obj8;
        boolean obj9;
        boolean obj10;
        if (i8 & 1 != 0) {
            obj5 = trainingTimeMetrics.weekTrainingSummary;
        }
        if (i8 & 2 != 0) {
            obj6 = trainingTimeMetrics.currentStreak;
        }
        if (i8 & 4 != 0) {
            obj7 = trainingTimeMetrics.previousGoalNotReachedDuration;
        }
        if (i8 & 8 != 0) {
            obj8 = trainingTimeMetrics.isMetricsEnabled;
        }
        if (i8 & 16 != 0) {
            obj9 = trainingTimeMetrics.isDashboardCardUnlocked;
        }
        if (i8 & 32 != 0) {
            obj10 = trainingTimeMetrics.isTooltipVisible;
        }
        return trainingTimeMetrics.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay> component1() {
        return this.weekTrainingSummary;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final int component3() {
        return this.previousGoalNotReachedDuration;
    }

    @Override // android.os.Parcelable
    public final boolean component4() {
        return this.isMetricsEnabled;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isDashboardCardUnlocked;
    }

    @Override // android.os.Parcelable
    public final boolean component6() {
        return this.isTooltipVisible;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics copy(List<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay> list, int i2, int i3, boolean z4, boolean z5, boolean z6) {
        n.f(list, "weekTrainingSummary");
        super(list, i2, i3, z4, z5, z6);
        return trainingTimeMetrics;
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
        if (!object instanceof TrainingTimeMetrics) {
            return i2;
        }
        if (!n.b(this.weekTrainingSummary, object.weekTrainingSummary)) {
            return i2;
        }
        if (this.currentStreak != object.currentStreak) {
            return i2;
        }
        if (this.previousGoalNotReachedDuration != object.previousGoalNotReachedDuration) {
            return i2;
        }
        if (this.isMetricsEnabled != object.isMetricsEnabled) {
            return i2;
        }
        if (this.isDashboardCardUnlocked != object.isDashboardCardUnlocked) {
            return i2;
        }
        if (this.isTooltipVisible != object.isTooltipVisible) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final int getPreviousGoalNotReachedDuration() {
        return this.previousGoalNotReachedDuration;
    }

    @Override // android.os.Parcelable
    public final boolean getShouldShowMetricsInDashboard() {
        boolean isDashboardCardUnlocked;
        int i;
        if (this.isDashboardCardUnlocked && this.isMetricsEnabled) {
            i = this.isMetricsEnabled ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay getTodaySummary() {
        Object next;
        boolean today;
        Iterator iterator = this.weekTrainingSummary.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        return (TrainingTimeMetrics.TrainingTimeDay)next;
    }

    @Override // android.os.Parcelable
    public final int getTodayTrainingTimeSeconds() {
        int durationSec;
        Object next;
        boolean today;
        Iterator iterator = this.weekTrainingSummary.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        if ((TrainingTimeMetrics.TrainingTimeDay)next == null) {
            durationSec = 0;
        } else {
            durationSec = (TrainingTimeMetrics.TrainingTimeDay)next.getDurationSec();
        }
        return durationSec;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay> getWeekTrainingSummary() {
        return this.weekTrainingSummary;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isMetricsEnabled;
        boolean isDashboardCardUnlocked;
        boolean i;
        i = 1;
        if (this.isMetricsEnabled) {
            isMetricsEnabled = i;
        }
        if (this.isDashboardCardUnlocked) {
            isDashboardCardUnlocked = i;
        }
        boolean isTooltipVisible = this.isTooltipVisible;
        if (isTooltipVisible) {
        } else {
            i = isTooltipVisible;
        }
        return i11 += i;
    }

    @Override // android.os.Parcelable
    public final boolean isDashboardCardUnlocked() {
        return this.isDashboardCardUnlocked;
    }

    @Override // android.os.Parcelable
    public final boolean isMetricsEnabled() {
        return this.isMetricsEnabled;
    }

    @Override // android.os.Parcelable
    public final boolean isTodayGoalAchieved() {
        int i;
        Object next;
        int streakStatus;
        boolean today;
        Iterator iterator = this.weekTrainingSummary.iterator();
        for (Object next : iterator) {
        }
        next = streakStatus;
        if ((TrainingTimeMetrics.TrainingTimeDay)next == null) {
        } else {
            streakStatus = (TrainingTimeMetrics.TrainingTimeDay)next.getStreakStatus();
        }
        i = streakStatus == TrainingTimeMetrics.TrainingTimeDay.StreakStatus.ACTIVE ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isTooltipVisible() {
        return this.isTooltipVisible;
    }

    @Override // android.os.Parcelable
    public final void setTooltipVisible(boolean z) {
        this.isTooltipVisible = z;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainingTimeMetrics(weekTrainingSummary=");
        stringBuilder.append(this.weekTrainingSummary);
        stringBuilder.append(", currentStreak=");
        stringBuilder.append(this.currentStreak);
        stringBuilder.append(", previousGoalNotReachedDuration=");
        stringBuilder.append(this.previousGoalNotReachedDuration);
        stringBuilder.append(", isMetricsEnabled=");
        stringBuilder.append(this.isMetricsEnabled);
        stringBuilder.append(", isDashboardCardUnlocked=");
        stringBuilder.append(this.isDashboardCardUnlocked);
        stringBuilder.append(", isTooltipVisible=");
        stringBuilder.append(this.isTooltipVisible);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List weekTrainingSummary = this.weekTrainingSummary;
        parcel.writeInt(weekTrainingSummary.size());
        Iterator iterator = weekTrainingSummary.iterator();
        for (TrainingTimeMetrics.TrainingTimeDay size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.previousGoalNotReachedDuration);
        parcel.writeInt(this.isMetricsEnabled);
        parcel.writeInt(this.isDashboardCardUnlocked);
        parcel.writeInt(this.isTooltipVisible);
    }
}
