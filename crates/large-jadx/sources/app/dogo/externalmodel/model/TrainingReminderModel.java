package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0003*+,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020\u00082\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006-", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel;", "Landroid/os/Parcelable;", "id", "", "time", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "enabled", "", "updateTimeMs", "", "createTimeMs", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;ZJJ)V", "getCreateTimeMs", "()J", "getEnabled", "()Z", "getId", "()Ljava/lang/String;", "getTime", "getUpdateTimeMs", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrainingReminderCreateModel", "TrainingReminderUpdateModel", "Weekdays", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrainingReminderModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.TrainingReminderModel> CREATOR;
    private final long createTimeMs;
    private final boolean enabled;
    private final String id;
    private final String time;
    private final long updateTimeMs;
    private final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.TrainingReminderModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.TrainingReminderModel createFromParcel(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readString(), (TrainingReminderModel.Weekdays)TrainingReminderModel.Weekdays.CREATOR.createFromParcel(parcel), i, parcel.readLong(), obj7, parcel.readLong(), obj9);
            return trainingReminderModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.TrainingReminderModel[] newArray(int i) {
            return new TrainingReminderModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel$TrainingReminderCreateModel;", "Landroid/os/Parcelable;", "time", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;)V", "getTime", "()Ljava/lang/String;", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingReminderCreateModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderCreateModel> CREATOR;
        private final String time;
        private final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;
        static {
            TrainingReminderModel.TrainingReminderCreateModel.Creator creator = new TrainingReminderModel.TrainingReminderCreateModel.Creator();
            TrainingReminderModel.TrainingReminderCreateModel.CREATOR = creator;
        }

        public TrainingReminderCreateModel(String string, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays2) {
            n.f(string, "time");
            n.f(weekdays2, "weekdays");
            super();
            this.time = string;
            this.weekdays = weekdays2;
        }

        public static app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderCreateModel copy$default(app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderCreateModel trainingReminderModel$TrainingReminderCreateModel, String string2, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays3, int i4, Object object5) {
            String obj1;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays obj2;
            if (i4 & 1 != 0) {
                obj1 = trainingReminderCreateModel.time;
            }
            if (i4 &= 2 != 0) {
                obj2 = trainingReminderCreateModel.weekdays;
            }
            return trainingReminderCreateModel.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.time;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays component2() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderCreateModel copy(String string, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays2) {
            n.f(string, "time");
            n.f(weekdays2, "weekdays");
            TrainingReminderModel.TrainingReminderCreateModel trainingReminderCreateModel = new TrainingReminderModel.TrainingReminderCreateModel(string, weekdays2);
            return trainingReminderCreateModel;
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
            if (!object instanceof TrainingReminderModel.TrainingReminderCreateModel) {
                return i2;
            }
            if (!n.b(this.time, object.time)) {
                return i2;
            }
            if (!n.b(this.weekdays, object.weekdays)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getTime() {
            return this.time;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrainingReminderCreateModel(time=");
            stringBuilder.append(this.time);
            stringBuilder.append(", weekdays=");
            stringBuilder.append(this.weekdays);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.time);
            this.weekdays.writeToParcel(parcel, i2);
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0013\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006!", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel$TrainingReminderUpdateModel;", "Landroid/os/Parcelable;", "time", "", "weekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "enabled", "", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTime", "()Ljava/lang/String;", "getWeekdays", "()Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;Ljava/lang/Boolean;)Lapp/dogo/externalmodel/model/TrainingReminderModel$TrainingReminderUpdateModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingReminderUpdateModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderUpdateModel> CREATOR;
        private final Boolean enabled;
        private final String time;
        private final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;
        static {
            TrainingReminderModel.TrainingReminderUpdateModel.Creator creator = new TrainingReminderModel.TrainingReminderUpdateModel.Creator();
            TrainingReminderModel.TrainingReminderUpdateModel.CREATOR = creator;
        }

        public TrainingReminderUpdateModel() {
            super(0, 0, 0, 7, 0);
        }

        public TrainingReminderUpdateModel(String string, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays2, Boolean boolean3) {
            super();
            this.time = string;
            this.weekdays = weekdays2;
            this.enabled = boolean3;
        }

        public TrainingReminderUpdateModel(String string, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays2, Boolean boolean3, int i4, g g5) {
            int obj2;
            int obj3;
            int obj4;
            final int i = 0;
            obj2 = i4 & 1 != 0 ? i : obj2;
            obj3 = i4 & 2 != 0 ? i : obj3;
            obj4 = i4 &= 4 != 0 ? i : obj4;
            super(obj2, obj3, obj4);
        }

        public static app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderUpdateModel copy$default(app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderUpdateModel trainingReminderModel$TrainingReminderUpdateModel, String string2, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays3, Boolean boolean4, int i5, Object object6) {
            String obj1;
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays obj2;
            Boolean obj3;
            if (i5 & 1 != 0) {
                obj1 = trainingReminderUpdateModel.time;
            }
            if (i5 & 2 != 0) {
                obj2 = trainingReminderUpdateModel.weekdays;
            }
            if (i5 &= 4 != 0) {
                obj3 = trainingReminderUpdateModel.enabled;
            }
            return trainingReminderUpdateModel.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.time;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays component2() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public final Boolean component3() {
            return this.enabled;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderUpdateModel copy(String string, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays2, Boolean boolean3) {
            TrainingReminderModel.TrainingReminderUpdateModel trainingReminderUpdateModel = new TrainingReminderModel.TrainingReminderUpdateModel(string, weekdays2, boolean3);
            return trainingReminderUpdateModel;
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
            if (!object instanceof TrainingReminderModel.TrainingReminderUpdateModel) {
                return i2;
            }
            if (!n.b(this.time, object.time)) {
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
        public final String getTime() {
            return this.time;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays getWeekdays() {
            return this.weekdays;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i3;
            int i2;
            String time = this.time;
            i3 = 0;
            if (time == null) {
                i = i3;
            } else {
                i = time.hashCode();
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
            return i6 += i3;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrainingReminderUpdateModel(time=");
            stringBuilder.append(this.time);
            stringBuilder.append(", weekdays=");
            stringBuilder.append(this.weekdays);
            stringBuilder.append(", enabled=");
            stringBuilder.append(this.enabled);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            boolean obj5;
            n.f(parcel, "out");
            parcel.writeString(this.time);
            app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays = this.weekdays;
            final int i = 0;
            final int i3 = 1;
            if (weekdays == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                weekdays.writeToParcel(parcel, i2);
            }
            obj5 = this.enabled;
            if (obj5 == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeInt(obj5.booleanValue());
            }
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0018\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006(", d2 = {"Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "Landroid/os/Parcelable;", "monday", "", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "(ZZZZZZZ)V", "getFriday", "()Z", "getMonday", "getSaturday", "getSunday", "getThursday", "getTuesday", "getWednesday", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Weekdays implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.TrainingReminderModel.Weekdays> CREATOR;
        private final boolean friday;
        private final boolean monday;
        private final boolean saturday;
        private final boolean sunday;
        private final boolean thursday;
        private final boolean tuesday;
        private final boolean wednesday;
        static {
            TrainingReminderModel.Weekdays.Creator creator = new TrainingReminderModel.Weekdays.Creator();
            TrainingReminderModel.Weekdays.CREATOR = creator;
        }

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

        public static app.dogo.externalmodel.model.TrainingReminderModel.Weekdays copy$default(app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i9, Object object10) {
            boolean obj6;
            boolean obj7;
            boolean obj8;
            boolean obj9;
            boolean obj10;
            boolean obj11;
            boolean obj12;
            if (i9 & 1 != 0) {
                obj6 = weekdays.monday;
            }
            if (i9 & 2 != 0) {
                obj7 = weekdays.tuesday;
            }
            if (i9 & 4 != 0) {
                obj8 = weekdays.wednesday;
            }
            if (i9 & 8 != 0) {
                obj9 = weekdays.thursday;
            }
            if (i9 & 16 != 0) {
                obj10 = weekdays.friday;
            }
            if (i9 & 32 != 0) {
                obj11 = weekdays.saturday;
            }
            if (i9 & 64 != 0) {
                obj12 = weekdays.sunday;
            }
            return weekdays.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
        }

        @Override // android.os.Parcelable
        public final boolean component1() {
            return this.monday;
        }

        @Override // android.os.Parcelable
        public final boolean component2() {
            return this.tuesday;
        }

        @Override // android.os.Parcelable
        public final boolean component3() {
            return this.wednesday;
        }

        @Override // android.os.Parcelable
        public final boolean component4() {
            return this.thursday;
        }

        @Override // android.os.Parcelable
        public final boolean component5() {
            return this.friday;
        }

        @Override // android.os.Parcelable
        public final boolean component6() {
            return this.saturday;
        }

        @Override // android.os.Parcelable
        public final boolean component7() {
            return this.sunday;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            super(z, z2, z3, z4, z5, z6, z7);
            return weekdays2;
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
            if (!object instanceof TrainingReminderModel.Weekdays) {
                return i2;
            }
            if (this.monday != object.monday) {
                return i2;
            }
            if (this.tuesday != object.tuesday) {
                return i2;
            }
            if (this.wednesday != object.wednesday) {
                return i2;
            }
            if (this.thursday != object.thursday) {
                return i2;
            }
            if (this.friday != object.friday) {
                return i2;
            }
            if (this.saturday != object.saturday) {
                return i2;
            }
            if (this.sunday != object.sunday) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final boolean getFriday() {
            return this.friday;
        }

        @Override // android.os.Parcelable
        public final boolean getMonday() {
            return this.monday;
        }

        @Override // android.os.Parcelable
        public final boolean getSaturday() {
            return this.saturday;
        }

        @Override // android.os.Parcelable
        public final boolean getSunday() {
            return this.sunday;
        }

        @Override // android.os.Parcelable
        public final boolean getThursday() {
            return this.thursday;
        }

        @Override // android.os.Parcelable
        public final boolean getTuesday() {
            return this.tuesday;
        }

        @Override // android.os.Parcelable
        public final boolean getWednesday() {
            return this.wednesday;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean monday;
            boolean i;
            boolean tuesday;
            boolean wednesday;
            boolean thursday;
            boolean friday;
            boolean saturday;
            i = 1;
            if (this.monday) {
                monday = i;
            }
            if (this.tuesday) {
                tuesday = i;
            }
            if (this.wednesday) {
                wednesday = i;
            }
            if (this.thursday) {
                thursday = i;
            }
            if (this.friday) {
                friday = i;
            }
            if (this.saturday) {
                saturday = i;
            }
            boolean sunday = this.sunday;
            if (sunday) {
            } else {
                i = sunday;
            }
            return i12 += i;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Weekdays(monday=");
            stringBuilder.append(this.monday);
            stringBuilder.append(", tuesday=");
            stringBuilder.append(this.tuesday);
            stringBuilder.append(", wednesday=");
            stringBuilder.append(this.wednesday);
            stringBuilder.append(", thursday=");
            stringBuilder.append(this.thursday);
            stringBuilder.append(", friday=");
            stringBuilder.append(this.friday);
            stringBuilder.append(", saturday=");
            stringBuilder.append(this.saturday);
            stringBuilder.append(", sunday=");
            stringBuilder.append(this.sunday);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
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
    static {
        TrainingReminderModel.Creator creator = new TrainingReminderModel.Creator();
        TrainingReminderModel.CREATOR = creator;
    }

    public TrainingReminderModel(String string, String string2, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays3, boolean z4, long l5, long l6) {
        n.f(string, "id");
        n.f(string2, "time");
        n.f(weekdays3, "weekdays");
        super();
        this.id = string;
        this.time = string2;
        this.weekdays = weekdays3;
        this.enabled = z4;
        this.updateTimeMs = l5;
        this.createTimeMs = obj8;
    }

    public static app.dogo.externalmodel.model.TrainingReminderModel copy$default(app.dogo.externalmodel.model.TrainingReminderModel trainingReminderModel, String string2, String string3, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays4, boolean z5, long l6, long l7, int i8, Object object9) {
        String str;
        String time;
        app.dogo.externalmodel.model.TrainingReminderModel.Weekdays weekdays;
        boolean enabled;
        long updateTimeMs;
        long createTimeMs;
        Object obj = trainingReminderModel;
        str = obj18 & 1 != 0 ? obj.id : string2;
        time = obj18 & 2 != 0 ? obj.time : string3;
        weekdays = obj18 & 4 != 0 ? obj.weekdays : weekdays4;
        enabled = obj18 & 8 != 0 ? obj.enabled : z5;
        updateTimeMs = obj18 & 16 != 0 ? obj.updateTimeMs : l6;
        createTimeMs = obj18 & 32 != 0 ? obj.createTimeMs : i8;
        return trainingReminderModel.copy(str, time, weekdays, enabled, updateTimeMs, l7);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.time;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.TrainingReminderModel.Weekdays component3() {
        return this.weekdays;
    }

    @Override // android.os.Parcelable
    public final boolean component4() {
        return this.enabled;
    }

    @Override // android.os.Parcelable
    public final long component5() {
        return this.updateTimeMs;
    }

    @Override // android.os.Parcelable
    public final long component6() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.TrainingReminderModel copy(String string, String string2, app.dogo.externalmodel.model.TrainingReminderModel.Weekdays trainingReminderModel$Weekdays3, boolean z4, long l5, long l6) {
        n.f(string, "id");
        n.f(string2, "time");
        n.f(weekdays3, "weekdays");
        super(string, string2, weekdays3, z4, l5, obj7, obj17, obj9);
        return trainingReminderModel;
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
        if (!object instanceof TrainingReminderModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.time, object.time)) {
            return i2;
        }
        if (!n.b(this.weekdays, object.weekdays)) {
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
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getTime() {
        return this.time;
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
        return i10 += i15;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainingReminderModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", weekdays=");
        stringBuilder.append(this.weekdays);
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
        parcel.writeString(this.time);
        this.weekdays.writeToParcel(parcel, i2);
        parcel.writeInt(this.enabled);
        parcel.writeLong(this.updateTimeMs);
        parcel.writeLong(this.createTimeMs);
    }
}
