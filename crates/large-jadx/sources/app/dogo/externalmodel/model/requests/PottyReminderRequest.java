package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.PottyReminderModel.PottyReminderCreateModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/requests/PottyReminderRequest;", "Landroid/os/Parcelable;", "reminder", "Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderCreateModel;", "(Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderCreateModel;)V", "getReminder", "()Lapp/dogo/externalmodel/model/PottyReminderModel$PottyReminderCreateModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PottyReminderRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.PottyReminderRequest> CREATOR;
    private final PottyReminderModel.PottyReminderCreateModel reminder;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.PottyReminderRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.PottyReminderRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            PottyReminderRequest pottyReminderRequest = new PottyReminderRequest((PottyReminderModel.PottyReminderCreateModel)PottyReminderModel.PottyReminderCreateModel.CREATOR.createFromParcel(parcel));
            return pottyReminderRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.PottyReminderRequest[] newArray(int i) {
            return new PottyReminderRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        PottyReminderRequest.Creator creator = new PottyReminderRequest.Creator();
        PottyReminderRequest.CREATOR = creator;
    }

    public PottyReminderRequest(PottyReminderModel.PottyReminderCreateModel pottyReminderModel$PottyReminderCreateModel) {
        n.f(pottyReminderCreateModel, "reminder");
        super();
        this.reminder = pottyReminderCreateModel;
    }

    public static app.dogo.externalmodel.model.requests.PottyReminderRequest copy$default(app.dogo.externalmodel.model.requests.PottyReminderRequest pottyReminderRequest, PottyReminderModel.PottyReminderCreateModel pottyReminderModel$PottyReminderCreateModel2, int i3, Object object4) {
        PottyReminderModel.PottyReminderCreateModel obj1;
        if (i3 &= 1 != 0) {
            obj1 = pottyReminderRequest.reminder;
        }
        return pottyReminderRequest.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final PottyReminderModel.PottyReminderCreateModel component1() {
        return this.reminder;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.PottyReminderRequest copy(PottyReminderModel.PottyReminderCreateModel pottyReminderModel$PottyReminderCreateModel) {
        n.f(pottyReminderCreateModel, "reminder");
        PottyReminderRequest pottyReminderRequest = new PottyReminderRequest(pottyReminderCreateModel);
        return pottyReminderRequest;
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
        if (object instanceof PottyReminderRequest == null) {
            return i2;
        }
        if (!n.b(this.reminder, object.reminder)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final PottyReminderModel.PottyReminderCreateModel getReminder() {
        return this.reminder;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.reminder.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PottyReminderRequest(reminder=");
        stringBuilder.append(this.reminder);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.reminder.writeToParcel(parcel, i2);
    }
}
