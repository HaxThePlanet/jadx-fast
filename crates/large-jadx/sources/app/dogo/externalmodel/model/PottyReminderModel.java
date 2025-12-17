package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u000234BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000cHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003Jc\u0010&\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020\u000c2\u0008\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0011R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u00065", d2 = {"Lapp/dogo/externalmodel/model/PottyReminderModel;", "Landroid/os/Parcelable;", "id", "", "startTime", "endTime", "intervalMinutes", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "dogId", "enabled", "", "updateTimeMs", "createTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/String;ZJJ)V", "getCreateTimeMs", "()J", "getDogId", "()Ljava/lang/String;", "getEnabled", "()Z", "getEndTime", "getId", "getIntervalMinutes", "getStartTime", "getUpdateTimeMs", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PottyReminderCreateModel", "PottyReminderUpdateModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PottyReminderModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyReminderModel> CREATOR;
    private final long createTimeMs;
    private final String dogId;
    private final boolean enabled;
    private final String endTime;
    private final String id;
    private final long intervalMinutes;
    private final String startTime;
    private final long updateTimeMs;
    private final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.PottyReminderModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.PottyReminderModel createFromParcel(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), obj6, (TrainingReminderModel.Weekdays)TrainingReminderModel.Weekdays.CREATOR.createFromParcel(parcel), parcel.readString(), i, parcel.readLong(), obj11, parcel.readLong(), obj13);
            return pottyReminderModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.PottyReminderModel[] newArray(int i) {
            return new PottyReminderModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006&", d2 = {"Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderCreateModel;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "intervalMinutes", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "dogId", "(Ljava/lang/String;Ljava/lang/String;JLapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getEndTime", "getIntervalMinutes", "()J", "getStartTime", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PottyReminderCreateModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyReminderModel.PottyReminderCreateModel> CREATOR;
        private final String dogId;
        private final String endTime;
        private final long intervalMinutes;
        private final String startTime;
        private final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;
        static {
            PottyReminderModel.PottyReminderCreateModel.Creator creator = new PottyReminderModel.PottyReminderCreateModel.Creator();
            PottyReminderModel.PottyReminderCreateModel.CREATOR = creator;
        }

        public PottyReminderCreateModel(String string, String string2, long l3, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays4, String string5) {
            n.f(string, "startTime");
            n.f(string2, "endTime");
            n.f(string5, "weekdays");
            n.f(obj7, "dogId");
            super();
            this.startTime = string;
            this.endTime = string2;
            this.intervalMinutes = l3;
            this.weekdays = string5;
            this.dogId = obj7;
        }

        public static app.dogo.externalmodel.model.PottyReminderModel.PottyReminderCreateModel copy$default(app.dogo.externalmodel.model.PottyReminderModel.PottyReminderCreateModel pottyReminderModel$PottyReminderCreateModel, String string2, String string3, long l4, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays5, String string6, int i7, Object object8) {
            String obj5;
            String obj6;
            long obj7;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays obj9;
            String obj10;
            if (object8 & 1 != 0) {
                obj5 = pottyReminderCreateModel.startTime;
            }
            if (object8 & 2 != 0) {
                obj6 = pottyReminderCreateModel.endTime;
            }
            if (object8 & 4 != 0) {
                obj7 = pottyReminderCreateModel.intervalMinutes;
            }
            if (object8 & 8 != 0) {
                obj9 = pottyReminderCreateModel.weekdays;
            }
            if (object8 & 16 != 0) {
                obj10 = pottyReminderCreateModel.dogId;
            }
            return pottyReminderCreateModel.copy(obj5, obj6, obj7, obj10, obj9);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.startTime;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.endTime;
        }

        @Override // android.os.Parcelable
        public final long component3() {
            return this.intervalMinutes;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays component4() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public final String component5() {
            return this.dogId;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyReminderModel.PottyReminderCreateModel copy(String string, String string2, long l3, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays4, String string5) {
            n.f(string, "startTime");
            n.f(string2, "endTime");
            n.f(string5, "weekdays");
            n.f(obj14, "dogId");
            super(string, string2, l3, obj5, string5, obj14);
            return pottyReminderCreateModel;
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
            if (!object instanceof PottyReminderModel.PottyReminderCreateModel) {
                return i2;
            }
            if (!n.b(this.startTime, object.startTime)) {
                return i2;
            }
            if (!n.b(this.endTime, object.endTime)) {
                return i2;
            }
            if (Long.compare(intervalMinutes, intervalMinutes2) != 0) {
                return i2;
            }
            if (!n.b(this.weekdays, object.weekdays)) {
                return i2;
            }
            if (!n.b(this.dogId, object.dogId)) {
                return i2;
            }
            return i;
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
        public final long getIntervalMinutes() {
            return this.intervalMinutes;
        }

        @Override // android.os.Parcelable
        public final String getStartTime() {
            return this.startTime;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i8 += i13;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PottyReminderCreateModel(startTime=");
            stringBuilder.append(this.startTime);
            stringBuilder.append(", endTime=");
            stringBuilder.append(this.endTime);
            stringBuilder.append(", intervalMinutes=");
            stringBuilder.append(this.intervalMinutes);
            stringBuilder.append(", weekdays=");
            stringBuilder.append(this.weekdays);
            stringBuilder.append(", dogId=");
            stringBuilder.append(this.dogId);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.startTime);
            parcel.writeString(this.endTime);
            parcel.writeLong(this.intervalMinutes);
            this.weekdays.writeToParcel(parcel, i2);
            parcel.writeString(this.dogId);
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BA\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u001c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\n2\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006*", d2 = {"Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderUpdateModel;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "intervalMinutes", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "enabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEndTime", "()Ljava/lang/String;", "getIntervalMinutes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderUpdateModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PottyReminderUpdateModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyReminderModel.PottyReminderUpdateModel> CREATOR;
        private final Boolean enabled;
        private final String endTime;
        private final Long intervalMinutes;
        private final String startTime;
        private final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;
        static {
            PottyReminderModel.PottyReminderUpdateModel.Creator creator = new PottyReminderModel.PottyReminderUpdateModel.Creator();
            PottyReminderModel.PottyReminderUpdateModel.CREATOR = creator;
        }

        public PottyReminderUpdateModel() {
            super(0, 0, 0, 0, 0, 31, 0);
        }

        public PottyReminderUpdateModel(String string, String string2, Long long3, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays4, Boolean boolean5) {
            super();
            this.startTime = string;
            this.endTime = string2;
            this.intervalMinutes = long3;
            this.weekdays = weekdays4;
            this.enabled = boolean5;
        }

        public PottyReminderUpdateModel(String string, String string2, Long long3, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays4, Boolean boolean5, int i6, g g7) {
            int i3;
            int i;
            int i2;
            int obj10;
            int obj11;
            final int i4 = 0;
            obj11 = i6 & 1 != 0 ? i4 : string;
            i3 = i6 & 2 != 0 ? i4 : string2;
            i = i6 & 4 != 0 ? i4 : long3;
            i2 = i6 & 8 != 0 ? i4 : weekdays4;
            obj10 = i6 & 16 != 0 ? i4 : boolean5;
            super(obj11, i3, i, i2, obj10);
        }

        public static app.dogo.externalmodel.model.PottyReminderModel.PottyReminderUpdateModel copy$default(app.dogo.externalmodel.model.PottyReminderModel.PottyReminderUpdateModel pottyReminderModel$PottyReminderUpdateModel, String string2, String string3, Long long4, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays5, Boolean boolean6, int i7, Object object8) {
            String obj4;
            String obj5;
            Long obj6;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays obj7;
            Boolean obj8;
            if (i7 & 1 != 0) {
                obj4 = pottyReminderUpdateModel.startTime;
            }
            if (i7 & 2 != 0) {
                obj5 = pottyReminderUpdateModel.endTime;
            }
            if (i7 & 4 != 0) {
                obj6 = pottyReminderUpdateModel.intervalMinutes;
            }
            if (i7 & 8 != 0) {
                obj7 = pottyReminderUpdateModel.weekdays;
            }
            if (i7 & 16 != 0) {
                obj8 = pottyReminderUpdateModel.enabled;
            }
            return pottyReminderUpdateModel.copy(obj4, obj5, obj6, obj7, obj8);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.startTime;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.endTime;
        }

        @Override // android.os.Parcelable
        public final Long component3() {
            return this.intervalMinutes;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays component4() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public final Boolean component5() {
            return this.enabled;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyReminderModel.PottyReminderUpdateModel copy(String string, String string2, Long long3, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays4, Boolean boolean5) {
            super(string, string2, long3, weekdays4, boolean5);
            return pottyReminderUpdateModel2;
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
            if (!object instanceof PottyReminderModel.PottyReminderUpdateModel) {
                return i2;
            }
            if (!n.b(this.startTime, object.startTime)) {
                return i2;
            }
            if (!n.b(this.endTime, object.endTime)) {
                return i2;
            }
            if (!n.b(this.intervalMinutes, object.intervalMinutes)) {
                return i2;
            }
            if (!n.b(this.weekdays, object.weekdays)) {
                return i2;
            }
            if (!n.b(this.enabled, object.enabled)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final Boolean getEnabled() {
            return this.enabled;
        }

        @Override // android.os.Parcelable
        public final String getEndTime() {
            return this.endTime;
        }

        @Override // android.os.Parcelable
        public final Long getIntervalMinutes() {
            return this.intervalMinutes;
        }

        @Override // android.os.Parcelable
        public final String getStartTime() {
            return this.startTime;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i5;
            int i3;
            int i4;
            int i;
            int i2;
            String startTime = this.startTime;
            i3 = 0;
            if (startTime == null) {
                i5 = i3;
            } else {
                i5 = startTime.hashCode();
            }
            String endTime = this.endTime;
            if (endTime == null) {
                i4 = i3;
            } else {
                i4 = endTime.hashCode();
            }
            Long intervalMinutes = this.intervalMinutes;
            if (intervalMinutes == null) {
                i = i3;
            } else {
                i = intervalMinutes.hashCode();
            }
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays = this.weekdays;
            if (weekdays == null) {
                i2 = i3;
            } else {
                i2 = weekdays.hashCode();
            }
            Boolean enabled = this.enabled;
            if (enabled == null) {
            } else {
                i3 = enabled.hashCode();
            }
            return i12 += i3;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PottyReminderUpdateModel(startTime=");
            stringBuilder.append(this.startTime);
            stringBuilder.append(", endTime=");
            stringBuilder.append(this.endTime);
            stringBuilder.append(", intervalMinutes=");
            stringBuilder.append(this.intervalMinutes);
            stringBuilder.append(", weekdays=");
            stringBuilder.append(this.weekdays);
            stringBuilder.append(", enabled=");
            stringBuilder.append(this.enabled);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            Boolean obj7;
            n.f(parcel, "out");
            parcel.writeString(this.startTime);
            parcel.writeString(this.endTime);
            Long intervalMinutes = this.intervalMinutes;
            final int i = 0;
            final int i3 = 1;
            if (intervalMinutes == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(intervalMinutes.longValue());
            }
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays = this.weekdays;
            if (weekdays == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                weekdays.writeToParcel(parcel, i2);
            }
            obj7 = this.enabled;
            if (obj7 == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeInt(obj7.booleanValue());
            }
        }
    }
    static {
        PottyReminderModel.Creator creator = new PottyReminderModel.Creator();
        PottyReminderModel.CREATOR = creator;
    }

    public PottyReminderModel(String string, String string2, String string3, long l4, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays5, String string6, boolean z7, long l8, long l9) {
        n.f(string, "id");
        n.f(string2, "startTime");
        n.f(string3, "endTime");
        n.f(string6, "weekdays");
        n.f(z7, "dogId");
        super();
        this.id = string;
        this.startTime = string2;
        this.endTime = string3;
        this.intervalMinutes = l4;
        this.weekdays = string6;
        this.dogId = z7;
        this.enabled = l8;
        this.updateTimeMs = l9;
        this.createTimeMs = obj12;
    }

    public static app.dogo.externalmodel.model.PottyReminderModel copy$default(app.dogo.externalmodel.model.PottyReminderModel pottyReminderModel, String string2, String string3, String string4, long l5, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays6, String string7, boolean z8, long l9, long l10, int i11, Object object12) {
        String str;
        String startTime;
        String endTime;
        long intervalMinutes;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;
        String dogId;
        boolean enabled;
        long updateTimeMs;
        long createTimeMs;
        Object obj = pottyReminderModel;
        int i = obj27;
        str = i & 1 != 0 ? obj.id : string2;
        startTime = i & 2 != 0 ? obj.startTime : string3;
        endTime = i & 4 != 0 ? obj.endTime : string4;
        intervalMinutes = i & 8 != 0 ? obj.intervalMinutes : l5;
        weekdays = i & 16 != 0 ? obj.weekdays : string7;
        dogId = i & 32 != 0 ? obj.dogId : z8;
        enabled = i & 64 != 0 ? obj.enabled : l9;
        updateTimeMs = i & 128 != 0 ? obj.updateTimeMs : l10;
        createTimeMs = i &= 256 != 0 ? obj.createTimeMs : object12;
        return pottyReminderModel.copy(str, startTime, endTime, intervalMinutes, weekdays6, weekdays, dogId, enabled, updateTimeMs);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.endTime;
    }

    @Override // android.os.Parcelable
    public final long component4() {
        return this.intervalMinutes;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays component5() {
        return this.weekdays;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final boolean component7() {
        return this.enabled;
    }

    @Override // android.os.Parcelable
    public final long component8() {
        return this.updateTimeMs;
    }

    @Override // android.os.Parcelable
    public final long component9() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.PottyReminderModel copy(String string, String string2, String string3, long l4, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays5, String string6, boolean z7, long l8, long l9) {
        n.f(string, "id");
        final Object obj = string2;
        n.f(obj, "startTime");
        final Object obj2 = string3;
        n.f(obj2, "endTime");
        final Object obj3 = string6;
        n.f(obj3, "weekdays");
        final Object obj4 = z7;
        n.f(obj4, "dogId");
        super(string, obj, obj2, l4, obj6, obj3, obj4, l8, l9, obj11, obj25, obj13);
        return pottyReminderModel;
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
        if (!object instanceof PottyReminderModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.startTime, object.startTime)) {
            return i2;
        }
        if (!n.b(this.endTime, object.endTime)) {
            return i2;
        }
        if (Long.compare(intervalMinutes, intervalMinutes2) != 0) {
            return i2;
        }
        if (!n.b(this.weekdays, object.weekdays)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (this.enabled != object.enabled) {
            return i2;
        }
        if (Long.compare(updateTimeMs, updateTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(createTimeMs, createTimeMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getCreateTimeMs() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // android.os.Parcelable
    public final String getEndTime() {
        return this.endTime;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final long getIntervalMinutes() {
        return this.intervalMinutes;
    }

    @Override // android.os.Parcelable
    public final String getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays getWeekdays() {
        return this.weekdays;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean enabled;
        if (this.enabled) {
            enabled = 1;
        }
        return i16 += i24;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PottyReminderModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", intervalMinutes=");
        stringBuilder.append(this.intervalMinutes);
        stringBuilder.append(", weekdays=");
        stringBuilder.append(this.weekdays);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", enabled=");
        stringBuilder.append(this.enabled);
        stringBuilder.append(", updateTimeMs=");
        stringBuilder.append(this.updateTimeMs);
        stringBuilder.append(", createTimeMs=");
        stringBuilder.append(this.createTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeLong(this.intervalMinutes);
        this.weekdays.writeToParcel(parcel, i2);
        parcel.writeString(this.dogId);
        parcel.writeInt(this.enabled);
        parcel.writeLong(this.updateTimeMs);
        parcel.writeLong(this.createTimeMs);
    }
}
