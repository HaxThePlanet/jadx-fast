package app.dogo.com.dogo_android.welcome_v2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u000c\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\u0015H\u0014J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "deeplink", "Landroid/net/Uri;", "isDogPremium", "", "(Landroid/net/Uri;Z)V", "getDeeplink", "()Landroid/net/Uri;", "setDeeplink", "(Landroid/net/Uri;)V", "()Z", "setDogPremium", "(Z)V", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o0 extends a {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.o0> CREATOR;
    private Uri a;
    private boolean b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.o0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.o0 a(Parcel parcel) {
            int obj3;
            n.f(parcel, "parcel");
            obj3 = parcel.readInt() != 0 ? 1 : 0;
            o0 o0Var = new o0((Uri)parcel.readParcelable(o0.class.getClassLoader()), obj3);
            return o0Var;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.o0[] b(int i) {
            return new o0[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        o0.a aVar = new o0.a();
        o0.CREATOR = aVar;
    }

    public o0() {
        final int i = 0;
        super(i, 0, 3, i);
    }

    public o0(Uri uri, boolean z2) {
        super();
        this.a = uri;
        this.b = z2;
    }

    public o0(Uri uri, boolean z2, int i3, g g4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final Uri a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public Intent buildIntent(Context context) {
        n.f(context, "context");
        final Intent obj3 = super.buildIntent(context);
        obj3.putExtra("android.intent.extra.STREAM", a());
        obj3.putExtra("intent_dog_premium_key", b());
        return obj3;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    protected Class<?> getActivityClass() {
        return OnboardingActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.a, i2);
        parcel.writeInt(this.b);
    }
}
