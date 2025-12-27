package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrainingReminderModel.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0003*+,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\u00082\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006-", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel;", "Landroid/os/Parcelable;", "id", "", "time", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "enabled", "", "updateTimeMs", "", "createTimeMs", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;ZJJ)V", "getCreateTimeMs", "()J", "getEnabled", "()Z", "getId", "()Ljava/lang/String;", "getTime", "getUpdateTimeMs", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrainingReminderCreateModel", "TrainingReminderUpdateModel", "Weekdays", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrainingReminderModel implements Parcelable {

    public static final Parcelable.Creator<TrainingReminderModel> CREATOR = new TrainingReminderModel$Creator<>();
    private final long createTimeMs;
    private final boolean enabled;
    private final String id;
    private final String time;
    private final long updateTimeMs;
    private final TrainingReminderModel.Weekdays weekdays;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrainingReminderModel> {
        @Override // android.os.Parcelable$Creator
        public final TrainingReminderModel createFromParcel(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            r1 = new TrainingReminderModel(parcel.readString(), parcel.readString(), (TrainingReminderModel_Weekdays)TrainingReminderModel_Weekdays.CREATOR.createFromParcel(parcel), (parcel.readInt() != 0 ? 1 : 0), parcel.readLong(), l, parcel.readLong(), obj);
            return trainingReminderModel;
        }

        @Override // android.os.Parcelable$Creator
        public final TrainingReminderModel[] newArray(int i) {
            return new TrainingReminderModel[i];
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel$TrainingReminderCreateModel;", "Landroid/os/Parcelable;", "time", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;)V", "getTime", "()Ljava/lang/String;", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingReminderCreateModel implements Parcelable {

        public static final Parcelable.Creator<TrainingReminderModel.TrainingReminderCreateModel> CREATOR = new TrainingReminderModel$TrainingReminderCreateModel$Creator<>();
        private final String time;
        private final TrainingReminderModel.Weekdays weekdays;
        public TrainingReminderCreateModel(String str, TrainingReminderModel.Weekdays weekdays) {
            n.f(str, "time");
            n.f(weekdays, "weekdays");
            super();
            this.time = str;
            this.weekdays = weekdays;
        }

        public final String getTime() {
            return this.time;
        }

        public final TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }


        public static /* synthetic */ TrainingReminderModel.TrainingReminderCreateModel copy$default(TrainingReminderModel.TrainingReminderCreateModel trainingReminderCreateModel, String str, TrainingReminderModel.Weekdays weekdays, int i, Object object) {
            String time2;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return trainingReminderCreateModel.copy(time2, weekdays2);
        }

        /* operator */ public final String component1() {
            return this.time;
        }

        /* operator */ public final TrainingReminderModel.Weekdays component2() {
            return this.weekdays;
        }

        public final TrainingReminderModel.TrainingReminderCreateModel copy(String time, TrainingReminderModel.Weekdays weekdays) {
            n.f(time, "time");
            n.f(weekdays, "weekdays");
            return new TrainingReminderModel_TrainingReminderCreateModel(time, weekdays);
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
            if (!(other instanceof TrainingReminderModel_TrainingReminderCreateModel)) {
                return false;
            }
            if (!n.b(this.time, other.time)) {
                return false;
            }
            return !n.b(this.weekdays, other.weekdays) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.time.hashCode() * 31) + this.weekdays.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrainingReminderCreateModel(time=";
            String str3 = ", weekdays=";
            str = str2 + this.time + str3 + this.weekdays + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.time);
            this.weekdays.writeToParcel(parcel, flags);
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0013\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006!", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel$TrainingReminderUpdateModel;", "Landroid/os/Parcelable;", "time", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "enabled", "", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTime", "()Ljava/lang/String;", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)Lapp/dogo/externalmodel/model/TrainingReminderModel$TrainingReminderUpdateModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingReminderUpdateModel implements Parcelable {

        public static final Parcelable.Creator<TrainingReminderModel.TrainingReminderUpdateModel> CREATOR = new TrainingReminderModel$TrainingReminderUpdateModel$Creator<>();
        private final Boolean enabled;
        private final String time;
        private final TrainingReminderModel.Weekdays weekdays;
        public TrainingReminderUpdateModel(String str, TrainingReminderModel.Weekdays weekdays, Boolean boolean) {
            super();
            this.time = str;
            this.weekdays = weekdays;
            this.enabled = boolean;
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public final String getTime() {
            return this.time;
        }

        public final TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }

        public /* synthetic */ TrainingReminderUpdateModel(String str, TrainingReminderModel.Weekdays weekdays, Boolean boolean, int i, g gVar) {
            String str2;
            Boolean bool;
            i = 0;
            i = i & 1 != 0 ? i : i;
            i = i & 2 != 0 ? i : i;
            i = i & 4 != 0 ? i : i;
            this(str2, weekdays, bool);
        }


        public TrainingReminderUpdateModel() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ TrainingReminderModel.TrainingReminderUpdateModel copy$default(TrainingReminderModel.TrainingReminderUpdateModel trainingReminderUpdateModel, String str, TrainingReminderModel.Weekdays weekdays, Boolean boolean, int i, Object object) {
            String time2;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays2;
            Boolean enabled2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return trainingReminderUpdateModel.copy(time2, weekdays2, enabled2);
        }

        /* operator */ public final String component1() {
            return this.time;
        }

        /* operator */ public final TrainingReminderModel.Weekdays component2() {
            return this.weekdays;
        }

        /* operator */ public final Boolean component3() {
            return this.enabled;
        }

        public final TrainingReminderModel.TrainingReminderUpdateModel copy(String time, TrainingReminderModel.Weekdays weekdays, Boolean enabled) {
            return new TrainingReminderModel_TrainingReminderUpdateModel(time, weekdays, enabled);
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
            if (!(other instanceof TrainingReminderModel_TrainingReminderUpdateModel)) {
                return false;
            }
            if (!n.b(this.time, other.time)) {
                return false;
            }
            if (!n.b(this.weekdays, other.weekdays)) {
                return false;
            }
            return !n.b(this.enabled, other.enabled) ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.time == null) {
            } else {
                i = this.time.hashCode();
            }
            if (this.weekdays == null) {
            } else {
                i = this.weekdays.hashCode();
            }
            if (this.enabled != null) {
                i = this.enabled.hashCode();
            }
            return (i * 31) + i * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrainingReminderUpdateModel(time=";
            String str3 = ", weekdays=";
            String str4 = ", enabled=";
            str = str2 + this.time + str3 + this.weekdays + str4 + this.enabled + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.time);
            final int i = 0;
            final int i2 = 1;
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

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0018\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006(", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "Landroid/os/Parcelable;", "monday", "", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "(ZZZZZZZ)V", "getFriday", "()Z", "getMonday", "getSaturday", "getSunday", "getThursday", "getTuesday", "getWednesday", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Weekdays implements Parcelable {

        public static final Parcelable.Creator<TrainingReminderModel.Weekdays> CREATOR = new TrainingReminderModel$Weekdays$Creator<>();
        private final boolean friday;
        private final boolean monday;
        private final boolean saturday;
        private final boolean sunday;
        private final boolean thursday;
        private final boolean tuesday;
        private final boolean wednesday;
        public Weekdays(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            super();
            this.monday = z;
            this.tuesday = z2;
            this.wednesday = z3;
            this.thursday = z4;
            this.friday = z5;
            this.saturday = z6;
            this.sunday = z7;
        }

        public final boolean getFriday() {
            return this.friday;
        }

        public final boolean getMonday() {
            return this.monday;
        }

        public final boolean getSaturday() {
            return this.saturday;
        }

        public final boolean getSunday() {
            return this.sunday;
        }

        public final boolean getThursday() {
            return this.thursday;
        }

        public final boolean getTuesday() {
            return this.tuesday;
        }

        public final boolean getWednesday() {
            return this.wednesday;
        }


        public static /* synthetic */ TrainingReminderModel.Weekdays copy$default(TrainingReminderModel.Weekdays weekdays, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object object) {
            boolean z22;
            boolean object102;
            boolean z42;
            boolean z52;
            boolean z62;
            boolean z72;
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
            return weekdays.copy(z22, object102, z42, z52, z62, z72, z82);
        }

        /* operator */ public final boolean component1() {
            return this.monday;
        }

        /* operator */ public final boolean component2() {
            return this.tuesday;
        }

        /* operator */ public final boolean component3() {
            return this.wednesday;
        }

        /* operator */ public final boolean component4() {
            return this.thursday;
        }

        /* operator */ public final boolean component5() {
            return this.friday;
        }

        /* operator */ public final boolean component6() {
            return this.saturday;
        }

        /* operator */ public final boolean component7() {
            return this.sunday;
        }

        public final TrainingReminderModel.Weekdays copy(boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
            TrainingReminderModel_Weekdays trainingReminderModel_Weekdays = new TrainingReminderModel_Weekdays(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
            return trainingReminderModel_Weekdays;
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
            final boolean z3 = false;
            if (!(other instanceof TrainingReminderModel_Weekdays)) {
                return false;
            }
            if (this.monday != other.monday) {
                return false;
            }
            if (this.tuesday != other.tuesday) {
                return false;
            }
            if (this.wednesday != other.wednesday) {
                return false;
            }
            if (this.thursday != other.thursday) {
                return false;
            }
            if (this.friday != other.friday) {
                return false;
            }
            if (this.saturday != other.saturday) {
                return false;
            }
            return this.sunday != other.sunday ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean monday2;
            boolean sunday2 = true;
            boolean tuesday2;
            boolean wednesday2;
            boolean thursday2;
            boolean friday2;
            boolean saturday2;
            int i = 1;
            if (this.monday) {
            }
            if (this.tuesday) {
            }
            if (this.wednesday) {
            }
            if (this.thursday) {
            }
            if (this.friday) {
            }
            if (this.saturday) {
            }
            if (!(this.sunday)) {
            }
            return (monday2 * 31) + tuesday2 * 31 + wednesday2 * 31 + thursday2 * 31 + friday2 * 31 + saturday2 * 31 + sunday2;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Weekdays(monday=";
            String str3 = ", tuesday=";
            String str4 = ", wednesday=";
            String str5 = ", thursday=";
            String str6 = ", friday=";
            String str7 = ", saturday=";
            String str8 = ", sunday=";
            str = str2 + this.monday + str3 + this.tuesday + str4 + this.wednesday + str5 + this.thursday + str6 + this.friday + str7 + this.saturday + str8 + this.sunday + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.monday);
            parcel.writeInt(this.tuesday);
            parcel.writeInt(this.wednesday);
            parcel.writeInt(this.thursday);
            parcel.writeInt(this.friday);
            parcel.writeInt(this.saturday);
            parcel.writeInt(this.sunday);
        }
    }
    public TrainingReminderModel(String str, String str2, TrainingReminderModel.Weekdays weekdays, boolean z, long j, long j2) {
        n.f(str, "id");
        n.f(str2, "time");
        n.f(weekdays, "weekdays");
        super();
        this.id = str;
        this.time = str2;
        this.weekdays = weekdays;
        this.enabled = z;
        this.updateTimeMs = j;
        this.createTimeMs = j2;
    }

    public final long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTime() {
        return this.time;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public final TrainingReminderModel.Weekdays getWeekdays() {
        return this.weekdays;
    }


    public static /* synthetic */ TrainingReminderModel copy$default(TrainingReminderModel trainingReminderModel, String str, String str2, TrainingReminderModel.Weekdays weekdays, boolean z, long j, long j2, int i, Object object) {
        String str22;
        String str32;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays42;
        boolean z52;
        long j62;
        long i82;
        Object trainingReminderModel2 = trainingReminderModel;
        String r1 = i & 1 != 0 ? trainingReminderModel2.id : str;
        String r2 = i & 2 != 0 ? trainingReminderModel2.time : str2;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays r3 = i & 4 != 0 ? trainingReminderModel2.weekdays : weekdays;
        boolean r4 = i & 8 != 0 ? trainingReminderModel2.enabled : z;
        long r5 = i & 16 != 0 ? trainingReminderModel2.updateTimeMs : j;
        long r7 = i & 32 != 0 ? trainingReminderModel2.createTimeMs : j2;
        return trainingReminderModel.copy(str22, str32, weekdays42, z52, j62, r15, (i & 32 != 0 ? trainingReminderModel2.createTimeMs : j2), r17);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.time;
    }

    /* operator */ public final TrainingReminderModel.Weekdays component3() {
        return this.weekdays;
    }

    /* operator */ public final boolean component4() {
        return this.enabled;
    }

    /* operator */ public final long component5() {
        return this.updateTimeMs;
    }

    /* operator */ public final long component6() {
        return this.createTimeMs;
    }

    public final TrainingReminderModel copy(String id, String time, TrainingReminderModel.Weekdays weekdays, boolean enabled, long updateTimeMs, long createTimeMs) {
        n.f(id, "id");
        n.f(time, "time");
        n.f(weekdays, "weekdays");
        TrainingReminderModel trainingReminderModel = new TrainingReminderModel(id, time, weekdays, enabled, updateTimeMs, l, createTimeMs, obj2);
        return trainingReminderModel;
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
        if (!(other instanceof TrainingReminderModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.time, other.time)) {
            return false;
        }
        if (!n.b(this.weekdays, other.weekdays)) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (this.updateTimeMs != other.updateTimeMs) {
            return false;
        }
        return this.createTimeMs != other.createTimeMs ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean enabled2 = true;
        if (this.enabled) {
            int i16 = 1;
        }
        return (this.id.hashCode() * 31) + this.time.hashCode() * 31 + this.weekdays.hashCode() * 31 + enabled2 * 31 + Long.hashCode(this.updateTimeMs) * 31 + Long.hashCode(this.createTimeMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrainingReminderModel(id=";
        String str3 = ", time=";
        String str4 = ", weekdays=";
        String str5 = ", enabled=";
        String str6 = ", updateTimeMs=";
        String str7 = ", createTimeMs=";
        str = str2 + this.id + str3 + this.time + str4 + this.weekdays + str5 + this.enabled + str6 + this.updateTimeMs + str7 + this.createTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.time);
        this.weekdays.writeToParcel(parcel, flags);
        parcel.writeInt(this.enabled);
        parcel.writeLong(this.updateTimeMs);
        parcel.writeLong(this.createTimeMs);
    }
}
