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

/* compiled from: ReminderResponse.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/externalmodel/model/responses/ReminderResponse;", "Landroid/os/Parcelable;", "trainingReminder", "Lapp/dogo/externalmodel/model/TrainingReminderModel;", "pottyReminders", "", "Lapp/dogo/externalmodel/model/PottyReminderModel;", "(Lapp/dogo/externalmodel/model/TrainingReminderModel;Ljava/util/List;)V", "getPottyReminders", "()Ljava/util/List;", "getTrainingReminder", "()Lapp/dogo/externalmodel/model/TrainingReminderModel;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ReminderResponse implements Parcelable {

    public static final Parcelable.Creator<ReminderResponse> CREATOR = new ReminderResponse$Creator<>();
    private final List<PottyReminderModel> pottyReminders;
    private final TrainingReminderModel trainingReminder;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ReminderResponse> {
        @Override // android.os.Parcelable$Creator
        public final ReminderResponse createFromParcel(Parcel parcel) {
            TrainingReminderModel trainingReminderModel = null;
            int i = 0;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i2 = 0;
            } else {
                Object fromParcel2 = TrainingReminderModel.CREATOR.createFromParcel(parcel);
            }
            final int _int2 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int2);
            i = 0;
            while (i != _int2) {
                arrayList.add(PottyReminderModel.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new ReminderResponse((TrainingReminderModel)trainingReminderModel, arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final ReminderResponse[] newArray(int i) {
            return new ReminderResponse[i];
        }
    }
    public ReminderResponse(TrainingReminderModel trainingReminderModel, List<PottyReminderModel> list) {
        n.f(list, "pottyReminders");
        super();
        this.trainingReminder = trainingReminderModel;
        this.pottyReminders = list;
    }

    public final List<PottyReminderModel> getPottyReminders() {
        return this.pottyReminders;
    }

    public final TrainingReminderModel getTrainingReminder() {
        return this.trainingReminder;
    }


    public static /* synthetic */ ReminderResponse copy$default(ReminderResponse reminderResponse, TrainingReminderModel trainingReminderModel, List list, int i, Object object) {
        TrainingReminderModel trainingReminder2;
        List pottyReminders2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return reminderResponse.copy(trainingReminder2, pottyReminders2);
    }

    /* operator */ public final TrainingReminderModel component1() {
        return this.trainingReminder;
    }

    /* operator */ public final List<PottyReminderModel> component2() {
        return this.pottyReminders;
    }

    public final ReminderResponse copy(TrainingReminderModel trainingReminder, List<PottyReminderModel> pottyReminders) {
        n.f(pottyReminders, "pottyReminders");
        return new ReminderResponse(trainingReminder, pottyReminders);
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
        if (!(other instanceof ReminderResponse)) {
            return false;
        }
        if (!n.b(this.trainingReminder, other.trainingReminder)) {
            return false;
        }
        return !n.b(this.pottyReminders, other.pottyReminders) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.trainingReminder == null) {
            i = 0;
        } else {
            i = this.trainingReminder.hashCode();
        }
        return (i * 31) + this.pottyReminders.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ReminderResponse(trainingReminder=";
        String str3 = ", pottyReminders=";
        str = str2 + this.trainingReminder + str3 + this.pottyReminders + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        if (this.trainingReminder == null) {
            int i = 0;
            parcel.writeInt(i);
        } else {
            int i2 = 1;
            parcel.writeInt(i2);
            this.trainingReminder.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.pottyReminders.size());
        Iterator it = this.pottyReminders.iterator();
        while (it.hasNext()) {
            (PottyReminderModel)it.next().writeToParcel(parcel, flags);
        }
    }
}
