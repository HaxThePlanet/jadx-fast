package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: PottyReminderModel.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u000234BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000cHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003Jc\u0010&\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020\u000c2\u0008\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0011R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u00065", d2 = {"Lapp/dogo/externalmodel/model/PottyReminderModel;", "Landroid/os/Parcelable;", "id", "", "startTime", "endTime", "intervalMinutes", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "dogId", "enabled", "", "updateTimeMs", "createTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/String;ZJJ)V", "getCreateTimeMs", "()J", "getDogId", "()Ljava/lang/String;", "getEnabled", "()Z", "getEndTime", "getId", "getIntervalMinutes", "getStartTime", "getUpdateTimeMs", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PottyReminderCreateModel", "PottyReminderUpdateModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PottyReminderModel implements Parcelable {

    public static final Parcelable.Creator<PottyReminderModel> CREATOR = new PottyReminderModel$Creator<>();
    private final long createTimeMs;
    private final String dogId;
    private final boolean enabled;
    private final String endTime;
    private final String id;
    private final long intervalMinutes;
    private final String startTime;
    private final long updateTimeMs;
    private final TrainingReminderModel.Weekdays weekdays;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PottyReminderModel> {
        @Override // android.os.Parcelable$Creator
        public final PottyReminderModel createFromParcel(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            r1 = new PottyReminderModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), weekdays, (TrainingReminderModel_Weekdays)TrainingReminderModel_Weekdays.CREATOR.createFromParcel(parcel), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0), parcel.readLong(), obj, parcel.readLong(), obj2);
            return pottyReminderModel;
        }

        @Override // android.os.Parcelable$Creator
        public final PottyReminderModel[] newArray(int i) {
            return new PottyReminderModel[i];
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006&", d2 = {"Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderCreateModel;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "intervalMinutes", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "dogId", "(Ljava/lang/String;Ljava/lang/String;JLapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getEndTime", "getIntervalMinutes", "()J", "getStartTime", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PottyReminderCreateModel implements Parcelable {

        public static final Parcelable.Creator<PottyReminderModel.PottyReminderCreateModel> CREATOR = new PottyReminderModel$PottyReminderCreateModel$Creator<>();
        private final String dogId;
        private final String endTime;
        private final long intervalMinutes;
        private final String startTime;
        private final TrainingReminderModel.Weekdays weekdays;
        public PottyReminderCreateModel(String str, String str2, long j, TrainingReminderModel.Weekdays weekdays, String str3) {
            n.f(str, "startTime");
            n.f(str2, "endTime");
            n.f(weekdays, "weekdays");
            n.f(str3, "dogId");
            super();
            this.startTime = str;
            this.endTime = str2;
            this.intervalMinutes = j;
            this.weekdays = weekdays;
            this.dogId = str3;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final long getIntervalMinutes() {
            return this.intervalMinutes;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }


        public static /* synthetic */ PottyReminderModel.PottyReminderCreateModel copy$default(PottyReminderModel.PottyReminderCreateModel pottyReminderCreateModel, String str, String str2, long j, TrainingReminderModel.Weekdays weekdays, String str3, int i, Object object) {
            String str22;
            String str32;
            long j42;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays str62;
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
            return pottyReminderCreateModel.copy(str22, str32, j42, str62, i72);
        }

        /* operator */ public final String component1() {
            return this.startTime;
        }

        /* operator */ public final String component2() {
            return this.endTime;
        }

        /* operator */ public final long component3() {
            return this.intervalMinutes;
        }

        /* operator */ public final TrainingReminderModel.Weekdays component4() {
            return this.weekdays;
        }

        /* operator */ public final String component5() {
            return this.dogId;
        }

        public final PottyReminderModel.PottyReminderCreateModel copy(String startTime, String endTime, long intervalMinutes, TrainingReminderModel.Weekdays weekdays, String dogId) {
            n.f(startTime, "startTime");
            n.f(endTime, "endTime");
            n.f(weekdays, "weekdays");
            n.f(dogId, "dogId");
            PottyReminderModel_PottyReminderCreateModel pottyReminderModel_PottyReminderCreateModel = new PottyReminderModel_PottyReminderCreateModel(startTime, endTime, intervalMinutes, weekdays2, weekdays, dogId);
            return pottyReminderModel_PottyReminderCreateModel;
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
            final boolean z6 = false;
            if (!(other instanceof PottyReminderModel_PottyReminderCreateModel)) {
                return false;
            }
            if (!n.b(this.startTime, other.startTime)) {
                return false;
            }
            if (!n.b(this.endTime, other.endTime)) {
                return false;
            }
            if (this.intervalMinutes != other.intervalMinutes) {
                return false;
            }
            if (!n.b(this.weekdays, other.weekdays)) {
                return false;
            }
            return !n.b(this.dogId, other.dogId) ? z6 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.startTime.hashCode() * 31) + this.endTime.hashCode() * 31 + Long.hashCode(this.intervalMinutes) * 31 + this.weekdays.hashCode() * 31 + this.dogId.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "PottyReminderCreateModel(startTime=";
            String str3 = ", endTime=";
            String str4 = ", intervalMinutes=";
            String str5 = ", weekdays=";
            String str6 = ", dogId=";
            str = str2 + this.startTime + str3 + this.endTime + str4 + this.intervalMinutes + str5 + this.weekdays + str6 + this.dogId + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.startTime);
            parcel.writeString(this.endTime);
            parcel.writeLong(this.intervalMinutes);
            this.weekdays.writeToParcel(parcel, flags);
            parcel.writeString(this.dogId);
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BA\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u001c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\n2\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006*", d2 = {"Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderUpdateModel;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "intervalMinutes", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "enabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEndTime", "()Ljava/lang/String;", "getIntervalMinutes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderUpdateModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PottyReminderUpdateModel implements Parcelable {

        public static final Parcelable.Creator<PottyReminderModel.PottyReminderUpdateModel> CREATOR = new PottyReminderModel$PottyReminderUpdateModel$Creator<>();
        private final Boolean enabled;
        private final String endTime;
        private final Long intervalMinutes;
        private final String startTime;
        private final TrainingReminderModel.Weekdays weekdays;
        public PottyReminderUpdateModel(String str, String str2, Long long, TrainingReminderModel.Weekdays weekdays, Boolean boolean) {
            super();
            this.startTime = str;
            this.endTime = str2;
            this.intervalMinutes = long;
            this.weekdays = weekdays;
            this.enabled = boolean;
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final Long getIntervalMinutes() {
            return this.intervalMinutes;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }

        public /* synthetic */ PottyReminderUpdateModel(String str, String str2, Long long, TrainingReminderModel.Weekdays weekdays, Boolean boolean, int i, g gVar) {
            int str22;
            Boolean boolean52;
            str22 = 0;
            gVar = i & 1 != 0 ? str22 : str;
            int r1 = i & 2 != 0 ? str22 : str2;
            int r2 = i & 4 != 0 ? str22 : long;
            int r3 = i & 8 != 0 ? str22 : weekdays;
            i = i & 16 != 0 ? str22 : boolean;
            this(str22, str22, str22, str22, (i & 16 != 0 ? str22 : boolean));
        }


        public PottyReminderUpdateModel() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ PottyReminderModel.PottyReminderUpdateModel copy$default(PottyReminderModel.PottyReminderUpdateModel pottyReminderUpdateModel, String str, String str2, Long long, TrainingReminderModel.Weekdays weekdays, Boolean boolean, int i, Object object) {
            String str22;
            String object82;
            Long long42;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays52;
            Boolean boolean62;
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
            return pottyReminderUpdateModel.copy(str22, object82, long42, weekdays52, boolean62);
        }

        /* operator */ public final String component1() {
            return this.startTime;
        }

        /* operator */ public final String component2() {
            return this.endTime;
        }

        /* operator */ public final Long component3() {
            return this.intervalMinutes;
        }

        /* operator */ public final TrainingReminderModel.Weekdays component4() {
            return this.weekdays;
        }

        /* operator */ public final Boolean component5() {
            return this.enabled;
        }

        public final PottyReminderModel.PottyReminderUpdateModel copy(String startTime, String endTime, Long intervalMinutes, TrainingReminderModel.Weekdays weekdays, Boolean enabled) {
            PottyReminderModel_PottyReminderUpdateModel pottyReminderModel_PottyReminderUpdateModel = new PottyReminderModel_PottyReminderUpdateModel(startTime, endTime, intervalMinutes, weekdays, enabled);
            return pottyReminderModel_PottyReminderUpdateModel;
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
            if (!(other instanceof PottyReminderModel_PottyReminderUpdateModel)) {
                return false;
            }
            if (!n.b(this.startTime, other.startTime)) {
                return false;
            }
            if (!n.b(this.endTime, other.endTime)) {
                return false;
            }
            if (!n.b(this.intervalMinutes, other.intervalMinutes)) {
                return false;
            }
            if (!n.b(this.weekdays, other.weekdays)) {
                return false;
            }
            return !n.b(this.enabled, other.enabled) ? z7 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.startTime == null) {
            } else {
                i = this.startTime.hashCode();
            }
            if (this.endTime == null) {
            } else {
                i = this.endTime.hashCode();
            }
            if (this.intervalMinutes == null) {
            } else {
                i = this.intervalMinutes.hashCode();
            }
            if (this.weekdays == null) {
            } else {
                i = this.weekdays.hashCode();
            }
            if (this.enabled != null) {
                i = this.enabled.hashCode();
            }
            return (i * 31) + i * 31 + i * 31 + i * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "PottyReminderUpdateModel(startTime=";
            String str3 = ", endTime=";
            String str4 = ", intervalMinutes=";
            String str5 = ", weekdays=";
            String str6 = ", enabled=";
            str = str2 + this.startTime + str3 + this.endTime + str4 + this.intervalMinutes + str5 + this.weekdays + str6 + this.enabled + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.startTime);
            parcel.writeString(this.endTime);
            final int i = 0;
            final int i2 = 1;
            if (this.intervalMinutes == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.intervalMinutes.longValue());
            }
            if (this.weekdays == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.weekdays.writeToParcel(parcel, flags);
            }
            if (this.enabled == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeInt(this.enabled.booleanValue());
            }
        }
    }
    public PottyReminderModel(String str, String str2, String str3, long j, TrainingReminderModel.Weekdays weekdays, String str4, boolean z, long j2, long j3) {
        n.f(str, "id");
        n.f(str2, "startTime");
        n.f(str3, "endTime");
        n.f(weekdays, "weekdays");
        n.f(str4, "dogId");
        super();
        this.id = str;
        this.startTime = str2;
        this.endTime = str3;
        this.intervalMinutes = j;
        this.weekdays = weekdays;
        this.dogId = str4;
        this.enabled = z;
        this.updateTimeMs = j2;
        this.createTimeMs = j3;
    }

    public final long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getId() {
        return this.id;
    }

    public final long getIntervalMinutes() {
        return this.intervalMinutes;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public final TrainingReminderModel.Weekdays getWeekdays() {
        return this.weekdays;
    }


    public static /* synthetic */ PottyReminderModel copy$default(PottyReminderModel pottyReminderModel, String str, String str2, String str3, long j, TrainingReminderModel.Weekdays weekdays, String str4, boolean z, long j2, long j3, int i, Object object) {
        String str22;
        String str32;
        String str42;
        long j52;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays str72;
        String z82;
        boolean j92;
        long j102;
        long object122;
        Object pottyReminderModel2 = pottyReminderModel;
        String r2 = i & 1 != 0 ? pottyReminderModel2.id : str;
        String r3 = i & 2 != 0 ? pottyReminderModel2.startTime : str2;
        String r4 = i & 4 != 0 ? pottyReminderModel2.endTime : str3;
        long r5 = i & 8 != 0 ? pottyReminderModel2.intervalMinutes : j;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays r7 = i & 16 != 0 ? pottyReminderModel2.weekdays : weekdays;
        String r8 = i & 32 != 0 ? pottyReminderModel2.dogId : str4;
        boolean r9 = i & 64 != 0 ? pottyReminderModel2.enabled : z;
        long r10 = i & 128 != 0 ? pottyReminderModel2.updateTimeMs : j2;
        long r12 = i & 256 != 0 ? pottyReminderModel2.createTimeMs : j3;
        return pottyReminderModel.copy(str22, str32, str42, j52, r19, str72, z82, j92, j102, r24, (i & 256 != 0 ? pottyReminderModel2.createTimeMs : j3), r26);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.startTime;
    }

    /* operator */ public final String component3() {
        return this.endTime;
    }

    /* operator */ public final long component4() {
        return this.intervalMinutes;
    }

    /* operator */ public final TrainingReminderModel.Weekdays component5() {
        return this.weekdays;
    }

    /* operator */ public final String component6() {
        return this.dogId;
    }

    /* operator */ public final boolean component7() {
        return this.enabled;
    }

    /* operator */ public final long component8() {
        return this.updateTimeMs;
    }

    /* operator */ public final long component9() {
        return this.createTimeMs;
    }

    public final PottyReminderModel copy(String id, String startTime, String endTime, long intervalMinutes, TrainingReminderModel.Weekdays weekdays, String dogId, boolean enabled, long updateTimeMs, long createTimeMs) {
        n.f(id, "id");
        final Object startTime2 = startTime;
        n.f(startTime2, "startTime");
        final Object endTime2 = endTime;
        n.f(endTime2, "endTime");
        final Object dogId2 = weekdays;
        n.f(dogId2, "weekdays");
        final Object enabled2 = dogId;
        n.f(enabled2, "dogId");
        PottyReminderModel pottyReminderModel = new PottyReminderModel(id, startTime2, endTime2, intervalMinutes, weekdays2, dogId2, enabled2, enabled, updateTimeMs, obj, createTimeMs, obj3);
        return pottyReminderModel;
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
        final boolean z8 = false;
        if (!(other instanceof PottyReminderModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.startTime, other.startTime)) {
            return false;
        }
        if (!n.b(this.endTime, other.endTime)) {
            return false;
        }
        if (this.intervalMinutes != other.intervalMinutes) {
            return false;
        }
        if (!n.b(this.weekdays, other.weekdays)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (this.updateTimeMs != other.updateTimeMs) {
            return false;
        }
        return this.createTimeMs != other.createTimeMs ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean enabled2 = true;
        if (this.enabled) {
            int i25 = 1;
        }
        return (this.id.hashCode() * 31) + this.startTime.hashCode() * 31 + this.endTime.hashCode() * 31 + Long.hashCode(this.intervalMinutes) * 31 + this.weekdays.hashCode() * 31 + this.dogId.hashCode() * 31 + enabled2 * 31 + Long.hashCode(this.updateTimeMs) * 31 + Long.hashCode(this.createTimeMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PottyReminderModel(id=";
        String str3 = ", startTime=";
        String str4 = ", endTime=";
        String str5 = ", intervalMinutes=";
        String str6 = ", weekdays=";
        String str7 = ", dogId=";
        String str8 = ", enabled=";
        String str9 = ", updateTimeMs=";
        String str10 = ", createTimeMs=";
        str = str2 + this.id + str3 + this.startTime + str4 + this.endTime + str5 + this.intervalMinutes + str6 + this.weekdays + str7 + this.dogId + str8 + this.enabled + str9 + this.updateTimeMs + str10 + this.createTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeLong(this.intervalMinutes);
        this.weekdays.writeToParcel(parcel, flags);
        parcel.writeString(this.dogId);
        parcel.writeInt(this.enabled);
        parcel.writeLong(this.updateTimeMs);
        parcel.writeLong(this.createTimeMs);
    }
}
