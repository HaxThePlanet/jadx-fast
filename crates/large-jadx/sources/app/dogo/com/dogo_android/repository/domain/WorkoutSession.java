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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u001e\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 72\u00020\u0001:\u00017BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0008HÆ\u0003J\t\u0010%\u001a\u00020\u0008HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003JU\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010*\u001a\u00020\u0008HÖ\u0001J\u0013\u0010+\u001a\u00020\u000b2\u0008\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0008HÖ\u0001J\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00100\u001a\u00020\u000bJ\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0008HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0015\"\u0004\u0008\u001f\u0010\u0017R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "Landroid/os/Parcelable;", "dogId", "", "trainingTricksList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "currentStreak", "", "longestStreak", "canIncreaseStreak", "", "isStreaksEnabled", "lastAchievedStreakTimestampMs", "", "(Ljava/lang/String;Ljava/util/List;IIZZJ)V", "getCanIncreaseStreak", "()Z", "setCanIncreaseStreak", "(Z)V", "getCurrentStreak", "()I", "setCurrentStreak", "(I)V", "getDogId", "()Ljava/lang/String;", "getLastAchievedStreakTimestampMs", "()J", "setLastAchievedStreakTimestampMs", "(J)V", "getLongestStreak", "setLongestStreak", "getTrainingTricksList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "isWorkoutSessionLocked", "isWorkoutSessionUnlocked", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WorkoutSession implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.WorkoutSession> CREATOR;
    public static final app.dogo.com.dogo_android.repository.domain.WorkoutSession.Companion Companion;
    private boolean canIncreaseStreak;
    private int currentStreak;
    private final String dogId;
    private final boolean isStreaksEnabled;
    private long lastAchievedStreakTimestampMs;
    private int longestStreak;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> trainingTricksList;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession$Companion;", "", "()V", "createEmpty", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.repository.domain.WorkoutSession createEmpty(String string) {
            n.f(string, "dogId");
            super(string, 0, 0, 0, 0, 0, 0, obj9, 126, 0);
            return workoutSession;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.WorkoutSession> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.WorkoutSession createFromParcel(Parcel parcel) {
            int i3;
            int i2;
            Object fromParcel;
            int i;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            int i4 = 0;
            i2 = i4;
            while (i2 != int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i2++;
            }
            int i5 = 1;
            i3 = parcel.readInt() != 0 ? i5 : i4;
            i = parcel.readInt() != 0 ? i5 : i4;
            super(parcel.readString(), arrayList, parcel.readInt(), parcel.readInt(), i3, i, parcel.readLong(), obj9);
            return obj11;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.WorkoutSession[] newArray(int i) {
            return new WorkoutSession[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        WorkoutSession.Companion companion = new WorkoutSession.Companion(0);
        WorkoutSession.Companion = companion;
        WorkoutSession.Creator creator = new WorkoutSession.Creator();
        WorkoutSession.CREATOR = creator;
    }

    public WorkoutSession(String string, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2, int i3, int i4, boolean z5, boolean z6, long l7) {
        n.f(string, "dogId");
        n.f(list2, "trainingTricksList");
        super();
        this.dogId = string;
        this.trainingTricksList = list2;
        this.currentStreak = i3;
        this.longestStreak = i4;
        this.canIncreaseStreak = z5;
        this.isStreaksEnabled = z6;
        this.lastAchievedStreakTimestampMs = l7;
    }

    public WorkoutSession(String string, List list2, int i3, int i4, boolean z5, boolean z6, long l7, int i8, g g9) {
        List list;
        int i2;
        int i7;
        int i6;
        int i5;
        int i;
        if (g9 & 2 != 0) {
            list = p.g();
        } else {
            list = list2;
        }
        i7 = 0;
        i2 = g9 & 4 != 0 ? i7 : i3;
        i6 = g9 & 8 != 0 ? i7 : i4;
        i5 = g9 & 16 != 0 ? i7 : z5;
        if (g9 & 32 != 0) {
        } else {
            i7 = z6;
        }
        i = g9 & 64 != 0 ? 0 : l7;
        super(string, list, i2, i6, i5, i7, i, obj17);
    }

    public static app.dogo.com.dogo_android.repository.domain.WorkoutSession copy$default(app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession, String string2, List list3, int i4, int i5, boolean z6, boolean z7, long l8, int i9, Object object10) {
        String dogId;
        List trainingTricksList;
        int currentStreak;
        int longestStreak;
        boolean canIncreaseStreak;
        boolean isStreaksEnabled;
        long lastAchievedStreakTimestampMs;
        Object obj = workoutSession;
        dogId = object10 & 1 != 0 ? obj.dogId : string2;
        trainingTricksList = object10 & 2 != 0 ? obj.trainingTricksList : list3;
        currentStreak = object10 & 4 != 0 ? obj.currentStreak : i4;
        longestStreak = object10 & 8 != 0 ? obj.longestStreak : i5;
        canIncreaseStreak = object10 & 16 != 0 ? obj.canIncreaseStreak : z6;
        isStreaksEnabled = object10 & 32 != 0 ? obj.isStreaksEnabled : z7;
        lastAchievedStreakTimestampMs = object10 & 64 != 0 ? obj.lastAchievedStreakTimestampMs : l8;
        return workoutSession.copy(dogId, trainingTricksList, currentStreak, longestStreak, canIncreaseStreak, isStreaksEnabled, lastAchievedStreakTimestampMs);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.dogId;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component2() {
        return this.trainingTricksList;
    }

    @Override // android.os.Parcelable
    public final int component3() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final int component4() {
        return this.longestStreak;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.canIncreaseStreak;
    }

    @Override // android.os.Parcelable
    public final boolean component6() {
        return this.isStreaksEnabled;
    }

    @Override // android.os.Parcelable
    public final long component7() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final app.dogo.com.dogo_android.repository.domain.WorkoutSession copy(String string, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2, int i3, int i4, boolean z5, boolean z6, long l7) {
        n.f(string, "dogId");
        n.f(list2, "trainingTricksList");
        super(string, list2, i3, i4, z5, z6, l7, obj9);
        return workoutSession;
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
        if (!object instanceof WorkoutSession) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.trainingTricksList, object.trainingTricksList)) {
            return i2;
        }
        if (this.currentStreak != object.currentStreak) {
            return i2;
        }
        if (this.longestStreak != object.longestStreak) {
            return i2;
        }
        if (this.canIncreaseStreak != object.canIncreaseStreak) {
            return i2;
        }
        if (this.isStreaksEnabled != object.isStreaksEnabled) {
            return i2;
        }
        if (Long.compare(lastAchievedStreakTimestampMs, lastAchievedStreakTimestampMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean getCanIncreaseStreak() {
        return this.canIncreaseStreak;
    }

    @Override // android.os.Parcelable
    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final long getLastAchievedStreakTimestampMs() {
        return this.lastAchievedStreakTimestampMs;
    }

    @Override // android.os.Parcelable
    public final int getLongestStreak() {
        return this.longestStreak;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getTrainingTricksList() {
        return this.trainingTricksList;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean canIncreaseStreak;
        int i;
        if (this.canIncreaseStreak) {
            canIncreaseStreak = i;
        }
        boolean isStreaksEnabled = this.isStreaksEnabled;
        if (isStreaksEnabled) {
        } else {
            i = isStreaksEnabled;
        }
        return i13 += i18;
    }

    @Override // android.os.Parcelable
    public final boolean isStreaksEnabled() {
        return this.isStreaksEnabled;
    }

    @Override // android.os.Parcelable
    public final boolean isWorkoutSessionLocked() {
        return this.trainingTricksList.isEmpty();
    }

    @Override // android.os.Parcelable
    public final boolean isWorkoutSessionUnlocked() {
        return empty ^= 1;
    }

    @Override // android.os.Parcelable
    public final void setCanIncreaseStreak(boolean z) {
        this.canIncreaseStreak = z;
    }

    @Override // android.os.Parcelable
    public final void setCurrentStreak(int i) {
        this.currentStreak = i;
    }

    @Override // android.os.Parcelable
    public final void setLastAchievedStreakTimestampMs(long l) {
        this.lastAchievedStreakTimestampMs = l;
    }

    @Override // android.os.Parcelable
    public final void setLongestStreak(int i) {
        this.longestStreak = i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkoutSession(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", trainingTricksList=");
        stringBuilder.append(this.trainingTricksList);
        stringBuilder.append(", currentStreak=");
        stringBuilder.append(this.currentStreak);
        stringBuilder.append(", longestStreak=");
        stringBuilder.append(this.longestStreak);
        stringBuilder.append(", canIncreaseStreak=");
        stringBuilder.append(this.canIncreaseStreak);
        stringBuilder.append(", isStreaksEnabled=");
        stringBuilder.append(this.isStreaksEnabled);
        stringBuilder.append(", lastAchievedStreakTimestampMs=");
        stringBuilder.append(this.lastAchievedStreakTimestampMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        List trainingTricksList = this.trainingTricksList;
        parcel.writeInt(trainingTricksList.size());
        Iterator iterator = trainingTricksList.iterator();
        boolean next = iterator.hasNext();
        for (TrickItem size : iterator) {
            size.writeToParcel(parcel, i2);
            next = iterator.hasNext();
        }
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.longestStreak);
        parcel.writeInt(this.canIncreaseStreak);
        parcel.writeInt(this.isStreaksEnabled);
        parcel.writeLong(this.lastAchievedStreakTimestampMs);
    }
}
