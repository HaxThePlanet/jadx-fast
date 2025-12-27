package app.dogo.com.dogo_android.subscription;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: SubscriptionScreenKey.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u000c\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0014J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\t\"\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "viewSource", "", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "lessonId", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getPreloadedOffer", "()Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "getViewSource", "setViewSource", "(Ljava/lang/String;)V", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionScreenKey extends a {

    public static final Parcelable.Creator<SubscriptionScreenKey> CREATOR = new SubscriptionScreenKey$Creator<>();
    private final String lessonId;
    private final SubscriptionOffer preloadedOffer;
    private String viewSource;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionScreenKey> {
        @Override // android.os.Parcelable$Creator
        public final SubscriptionScreenKey createFromParcel(Parcel parcel) {
            SubscriptionOffer subscriptionOffer = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = SubscriptionOffer.CREATOR.createFromParcel(parcel);
            }
            SubscriptionScreenKey subscriptionScreenKey = new SubscriptionScreenKey(parcel.readString(), (SubscriptionOffer)subscriptionOffer, parcel.readString());
            return subscriptionScreenKey;
        }

        @Override // android.os.Parcelable$Creator
        public final SubscriptionScreenKey[] newArray(int i) {
            return new SubscriptionScreenKey[i];
        }
    }
    public /* synthetic */ SubscriptionScreenKey(String str, SubscriptionOffer subscriptionOffer, String str2, int i, g gVar) {
        i = 0;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        this(str, subscriptionOffer, str2);
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
    public final void setViewSource(String str) {
        n.f(str, "<set-?>");
        this.viewSource = str;
    }

    public SubscriptionScreenKey(String str, SubscriptionOffer subscriptionOffer, String str2) {
        n.f(str, "viewSource");
        super();
        this.viewSource = str;
        this.preloadedOffer = subscriptionOffer;
        this.lessonId = str2;
    }


    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    protected Class<?> getActivityClass() {
        return SubscriptionActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.viewSource);
        if (this.preloadedOffer == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.preloadedOffer.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.lessonId);
    }
}
