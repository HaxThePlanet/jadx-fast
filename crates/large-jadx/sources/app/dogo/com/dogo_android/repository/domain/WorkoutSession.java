package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: WorkoutSession.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u001e\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 72\u00020\u0001:\u00017BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0008HÆ\u0003J\t\u0010%\u001a\u00020\u0008HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003JU\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010*\u001a\u00020\u0008HÖ\u0001J\u0013\u0010+\u001a\u00020\u000b2\u0008\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0008HÖ\u0001J\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00100\u001a\u00020\u000bJ\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0008HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0015\"\u0004\u0008\u001f\u0010\u0017R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "Landroid/os/Parcelable;", "dogId", "", "trainingTricksList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "currentStreak", "", "longestStreak", "canIncreaseStreak", "", "isStreaksEnabled", "lastAchievedStreakTimestampMs", "", "(Ljava/lang/String;Ljava/util/List;IIZZJ)V", "getCanIncreaseStreak", "()Z", "setCanIncreaseStreak", "(Z)V", "getCurrentStreak", "()I", "setCurrentStreak", "(I)V", "getDogId", "()Ljava/lang/String;", "getLastAchievedStreakTimestampMs", "()J", "setLastAchievedStreakTimestampMs", "(J)V", "getLongestStreak", "setLongestStreak", "getTrainingTricksList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "isWorkoutSessionLocked", "isWorkoutSessionUnlocked", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WorkoutSession implements Parcelable {

    public static final Parcelable.Creator<WorkoutSession> CREATOR = new WorkoutSession$Creator<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final WorkoutSession.Companion INSTANCE = new WorkoutSession$Companion(0);
    private boolean canIncreaseStreak;
    private int currentStreak;
    private final String dogId;
    private final boolean isStreaksEnabled;
    private long lastAchievedStreakTimestampMs;
    private int longestStreak;
    private final List<TrickItem> trainingTricksList;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession$Companion;", "", "()V", "createEmpty", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final WorkoutSession createEmpty(String dogId) {
            n.f(dogId, "dogId");
            WorkoutSession workoutSession = new WorkoutSession(dogId, null, 0, 0, false, false, 0L, i7, 126, 0);
            return workoutSession;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkoutSession> {
        @Override // android.os.Parcelable$Creator
        public final WorkoutSession createFromParcel(Parcel parcel) {
            int i;
            boolean z2;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            i = 1;
            int r0 = i;
            int r7 = i;
            WorkoutSession parcel2 = new WorkoutSession(parcel.readString(), arrayList, parcel.readInt(), parcel.readInt(), i, i, parcel.readLong(), obj);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final WorkoutSession[] newArray(int i) {
            return new WorkoutSession[i];
        }
    }
    public WorkoutSession(String str, List<TrickItem> list, int i, int i2, boolean z, boolean z2, long j) {
        n.f(str, "dogId");
        n.f(list, "trainingTricksList");
        super();
        this.dogId = str;
        this.trainingTricksList = list;
        this.currentStreak = i;
        this.longestStreak = i2;
        this.canIncreaseStreak = z;
        this.isStreaksEnabled = z2;
        this.lastAchievedStreakTimestampMs = j;
    }

    public final boolean getCanIncreaseStreak() {
        return this.canIncreaseStreak;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final long getLastAchievedStreakTimestampMs() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final int getLongestStreak() {
        return this.longestStreak;
    }

    public final List<TrickItem> getTrainingTricksList() {
        return this.trainingTricksList;
    }

    public final boolean isStreaksEnabled() {
        return this.isStreaksEnabled;
    }

    public final boolean isWorkoutSessionLocked() {
        return this.trainingTricksList.isEmpty();
    }

    public final boolean isWorkoutSessionUnlocked() {
        return !this.trainingTricksList.isEmpty();
    }

    public final void setCanIncreaseStreak(boolean z) {
        this.canIncreaseStreak = z;
    }

    public final void setCurrentStreak(int i) {
        this.currentStreak = i;
    }

    public final void setLastAchievedStreakTimestampMs(long j) {
        this.lastAchievedStreakTimestampMs = j;
    }

    public final void setLongestStreak(int i) {
        this.longestStreak = i;
    }

    public /* synthetic */ WorkoutSession(String str, List list, int i, int i2, boolean z, boolean z2, long j, int i3, g gVar) {
        List list22;
        int i32;
        int j72 = 0;
        if (i3 & 2 != 0) {
            list22 = p.g();
        } else {
            list22 = list;
        }
        i32 = 0;
        int r1 = i3 & 4 != 0 ? i32 : i;
        int r3 = i3 & 8 != 0 ? i32 : i2;
        int r4 = i3 & 16 != 0 ? i32 : z;
        if (i3 & 32 == 0) {
            i32 = z2;
        }
        int r5 = i3 & 64 != 0 ? 0 : j;
        this(str, list22, i32, i32, i32, i32, (i3 & 64 != 0 ? 0 : j), gVar);
    }


    public static /* synthetic */ WorkoutSession copy$default(WorkoutSession workoutSession, String str, List list, int i, int i2, boolean z, boolean z2, long j, int i3, Object object) {
        String str22;
        List list32;
        int i42;
        int i52;
        boolean z62;
        boolean z72;
        long j82;
        Object workoutSession2 = workoutSession;
        String r1 = i3 & 1 != 0 ? workoutSession2.dogId : str;
        List r2 = i3 & 2 != 0 ? workoutSession2.trainingTricksList : list;
        int r3 = i3 & 4 != 0 ? workoutSession2.currentStreak : i;
        int r4 = i3 & 8 != 0 ? workoutSession2.longestStreak : i2;
        boolean r5 = i3 & 16 != 0 ? workoutSession2.canIncreaseStreak : z;
        boolean r6 = i3 & 32 != 0 ? workoutSession2.isStreaksEnabled : z2;
        long r7 = i3 & 64 != 0 ? workoutSession2.lastAchievedStreakTimestampMs : j;
        return workoutSession.copy(str22, list32, i42, i52, z62, z72, (i3 & 64 != 0 ? workoutSession2.lastAchievedStreakTimestampMs : j), r17);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final List<TrickItem> component2() {
        return this.trainingTricksList;
    }

    /* operator */ public final int component3() {
        return this.currentStreak;
    }

    /* operator */ public final int component4() {
        return this.longestStreak;
    }

    /* operator */ public final boolean component5() {
        return this.canIncreaseStreak;
    }

    /* operator */ public final boolean component6() {
        return this.isStreaksEnabled;
    }

    /* operator */ public final long component7() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final WorkoutSession copy(String dogId, List<TrickItem> trainingTricksList, int currentStreak, int longestStreak, boolean canIncreaseStreak, boolean isStreaksEnabled, long lastAchievedStreakTimestampMs) {
        n.f(dogId, "dogId");
        n.f(trainingTricksList, "trainingTricksList");
        WorkoutSession workoutSession = new WorkoutSession(dogId, trainingTricksList, currentStreak, longestStreak, canIncreaseStreak, isStreaksEnabled, lastAchievedStreakTimestampMs, obj);
        return workoutSession;
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
        if (!(other instanceof WorkoutSession)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.trainingTricksList, other.trainingTricksList)) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        if (this.longestStreak != other.longestStreak) {
            return false;
        }
        if (this.canIncreaseStreak != other.canIncreaseStreak) {
            return false;
        }
        if (this.isStreaksEnabled != other.isStreaksEnabled) {
            return false;
        }
        return this.lastAchievedStreakTimestampMs != other.lastAchievedStreakTimestampMs ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean canIncreaseStreak2;
        int i = 1;
        i = 1;
        if (this.canIncreaseStreak) {
        }
        if (!(this.isStreaksEnabled)) {
        }
        return (this.dogId.hashCode() * 31) + this.trainingTricksList.hashCode() * 31 + Integer.hashCode(this.currentStreak) * 31 + Integer.hashCode(this.longestStreak) * 31 + canIncreaseStreak2 * 31 + i * 31 + Long.hashCode(this.lastAchievedStreakTimestampMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "WorkoutSession(dogId=";
        String str3 = ", trainingTricksList=";
        String str4 = ", currentStreak=";
        String str5 = ", longestStreak=";
        String str6 = ", canIncreaseStreak=";
        String str7 = ", isStreaksEnabled=";
        String str8 = ", lastAchievedStreakTimestampMs=";
        str = str2 + this.dogId + str3 + this.trainingTricksList + str4 + this.currentStreak + str5 + this.longestStreak + str6 + this.canIncreaseStreak + str7 + this.isStreaksEnabled + str8 + this.lastAchievedStreakTimestampMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeInt(this.trainingTricksList.size());
        Iterator it = this.trainingTricksList.iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            (TrickItem)it.next().writeToParcel(parcel, flags);
            hasNext = it.hasNext();
        }
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.longestStreak);
        parcel.writeInt(this.canIncreaseStreak);
        parcel.writeInt(this.isStreaksEnabled);
        parcel.writeLong(this.lastAchievedStreakTimestampMs);
    }
}
