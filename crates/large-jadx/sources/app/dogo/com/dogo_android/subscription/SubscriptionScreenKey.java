package app.dogo.com.dogo_android.subscription;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u000c\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0014J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\t\"\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "viewSource", "", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "lessonId", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getPreloadedOffer", "()Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "getViewSource", "setViewSource", "(Ljava/lang/String;)V", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionScreenKey extends a {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.subscription.SubscriptionScreenKey> CREATOR;
    private final String lessonId;
    private final SubscriptionOffer preloadedOffer;
    private String viewSource;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.subscription.SubscriptionScreenKey> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.SubscriptionScreenKey createFromParcel(Parcel parcel) {
            int fromParcel;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = SubscriptionOffer.CREATOR.createFromParcel(parcel);
            }
            SubscriptionScreenKey subscriptionScreenKey = new SubscriptionScreenKey(parcel.readString(), (SubscriptionOffer)fromParcel, parcel.readString());
            return subscriptionScreenKey;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.SubscriptionScreenKey[] newArray(int i) {
            return new SubscriptionScreenKey[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SubscriptionScreenKey.Creator creator = new SubscriptionScreenKey.Creator();
        SubscriptionScreenKey.CREATOR = creator;
    }

    public SubscriptionScreenKey(String string, SubscriptionOffer subscriptionOffer2, String string3) {
        n.f(string, "viewSource");
        super();
        this.viewSource = string;
        this.preloadedOffer = subscriptionOffer2;
        this.lessonId = string3;
    }

    public SubscriptionScreenKey(String string, SubscriptionOffer subscriptionOffer2, String string3, int i4, g g5) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(string, obj3, obj4);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    protected Class<?> getActivityClass() {
        return SubscriptionActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String getLessonId() {
        return this.lessonId;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final SubscriptionOffer getPreloadedOffer() {
        return this.preloadedOffer;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String getViewSource() {
        return this.viewSource;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final void setViewSource(String string) {
        n.f(string, "<set-?>");
        this.viewSource = string;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.viewSource);
        SubscriptionOffer preloadedOffer = this.preloadedOffer;
        if (preloadedOffer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            preloadedOffer.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.lessonId);
    }
}
