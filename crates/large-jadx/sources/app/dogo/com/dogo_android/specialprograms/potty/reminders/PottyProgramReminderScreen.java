package app.dogo.com.dogo_android.u.n.q;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: PottyProgramReminderScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "presetReminder", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "(Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;)V", "getPresetReminder", "()Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class PottyProgramReminderScreen extends j {

    public static final Parcelable.Creator<k> CREATOR = new k$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final PottyRemindersItem presetReminder;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<k> {
        public final k a(Parcel parcel) {
            PottyRemindersItem pottyRemindersItem = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = PottyRemindersItem.CREATOR.createFromParcel(parcel);
            }
            PottyProgramReminderScreen pottyProgramReminderScreen = new PottyProgramReminderScreen((PottyRemindersItem)pottyRemindersItem);
            return pottyProgramReminderScreen;
        }

        public final k[] b(int i) {
            return new k[i];
        }
    }
    public k(PottyRemindersItem pottyRemindersItem) {
        super();
        this.presetReminder = pottyRemindersItem;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final PottyRemindersItem createFragment() {
        return this.presetReminder;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new PottyProgramReminderFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.b1.f();
    }

    public /* synthetic */ k(PottyRemindersItem pottyRemindersItem, int i, g gVar) {
        PottyRemindersItem pottyRemindersItem2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(pottyRemindersItem2);
    }


    public k() {
        final PottyRemindersItem pottyRemindersItem = null;
        this(pottyRemindersItem, 1, pottyRemindersItem);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        if (this.presetReminder == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.presetReminder.writeToParcel(parcel, flags);
        }
    }
}
