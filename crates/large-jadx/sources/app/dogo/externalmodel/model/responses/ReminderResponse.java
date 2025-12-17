package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.PottyReminderModel;
import app.dogo.externalmodel.model.TrainingReminderModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/externalmodel/model/responses/ReminderResponse;", "Landroid/os/Parcelable;", "trainingReminder", "Lapp/dogo/externalmodel/model/TrainingReminderModel;", "pottyReminders", "", "Lapp/dogo/externalmodel/model/PottyReminderModel;", "(Lapp/dogo/externalmodel/model/TrainingReminderModel;Ljava/util/List;)V", "getPottyReminders", "()Ljava/util/List;", "getTrainingReminder", "()Lapp/dogo/externalmodel/model/TrainingReminderModel;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReminderResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ReminderResponse> CREATOR;
    private final List<PottyReminderModel> pottyReminders;
    private final TrainingReminderModel trainingReminder;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.ReminderResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ReminderResponse createFromParcel(Parcel parcel) {
            int fromParcel;
            int i;
            Object fromParcel2;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = TrainingReminderModel.CREATOR.createFromParcel(parcel);
            }
            final int int2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int2);
            i = 0;
            while (i != int2) {
                arrayList.add(PottyReminderModel.CREATOR.createFromParcel(parcel));
                i++;
            }
            ReminderResponse obj6 = new ReminderResponse((TrainingReminderModel)fromParcel, arrayList);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ReminderResponse[] newArray(int i) {
            return new ReminderResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ReminderResponse.Creator creator = new ReminderResponse.Creator();
        ReminderResponse.CREATOR = creator;
    }

    public ReminderResponse(TrainingReminderModel trainingReminderModel, List<PottyReminderModel> list2) {
        n.f(list2, "pottyReminders");
        super();
        this.trainingReminder = trainingReminderModel;
        this.pottyReminders = list2;
    }

    public static app.dogo.externalmodel.model.responses.ReminderResponse copy$default(app.dogo.externalmodel.model.responses.ReminderResponse reminderResponse, TrainingReminderModel trainingReminderModel2, List list3, int i4, Object object5) {
        TrainingReminderModel obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = reminderResponse.trainingReminder;
        }
        if (i4 &= 2 != 0) {
            obj2 = reminderResponse.pottyReminders;
        }
        return reminderResponse.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final TrainingReminderModel component1() {
        return this.trainingReminder;
    }

    public final List<PottyReminderModel> component2() {
        return this.pottyReminders;
    }

    public final app.dogo.externalmodel.model.responses.ReminderResponse copy(TrainingReminderModel trainingReminderModel, List<PottyReminderModel> list2) {
        n.f(list2, "pottyReminders");
        ReminderResponse reminderResponse = new ReminderResponse(trainingReminderModel, list2);
        return reminderResponse;
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
        if (object instanceof ReminderResponse == null) {
            return i2;
        }
        if (!n.b(this.trainingReminder, object.trainingReminder)) {
            return i2;
        }
        if (!n.b(this.pottyReminders, object.pottyReminders)) {
            return i2;
        }
        return i;
    }

    public final List<PottyReminderModel> getPottyReminders() {
        return this.pottyReminders;
    }

    @Override // android.os.Parcelable
    public final TrainingReminderModel getTrainingReminder() {
        return this.trainingReminder;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        TrainingReminderModel trainingReminder = this.trainingReminder;
        if (trainingReminder == null) {
            i = 0;
        } else {
            i = trainingReminder.hashCode();
        }
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReminderResponse(trainingReminder=");
        stringBuilder.append(this.trainingReminder);
        stringBuilder.append(", pottyReminders=");
        stringBuilder.append(this.pottyReminders);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int trainingReminder;
        int i;
        int size;
        n.f(parcel, "out");
        trainingReminder = this.trainingReminder;
        if (trainingReminder == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            trainingReminder.writeToParcel(parcel, i2);
        }
        List pottyReminders = this.pottyReminders;
        parcel.writeInt(pottyReminders.size());
        Iterator iterator = pottyReminders.iterator();
        for (PottyReminderModel size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
