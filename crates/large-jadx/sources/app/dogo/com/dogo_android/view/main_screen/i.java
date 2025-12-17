package app.dogo.com.dogo_android.view.main_screen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B1\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u000c\u0010\u001c\u001a\u0006\u0012\u0002\u0008\u00030\u001dH\u0014J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u0012\"\u0004\u0008\u0015\u0010\u0014¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "deeplink", "Landroid/net/Uri;", "isDogPremium", "", "isCalledFromOnboarding", "dogInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "(Landroid/net/Uri;ZZLapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;)V", "getDeeplink", "()Landroid/net/Uri;", "setDeeplink", "(Landroid/net/Uri;)V", "getDogInvite", "()Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "setDogInvite", "(Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;)V", "()Z", "setCalledFromOnboarding", "(Z)V", "setDogPremium", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends a {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.view.main_screen.i> CREATOR;
    public static final app.dogo.com.dogo_android.view.main_screen.i.a Companion;
    private Uri a;
    private boolean b;
    private boolean c;
    private DogOwnerInvitation v;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenKey$Companion;", "", "()V", "DOG_INVITE_DATA", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<app.dogo.com.dogo_android.view.main_screen.i> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.view.main_screen.i a(Parcel parcel) {
            int i;
            int i2;
            int cREATOR;
            int obj7;
            n.f(parcel, "parcel");
            int i3 = 0;
            i = parcel.readInt() != 0 ? i2 : i3;
            if (parcel.readInt() != 0) {
            } else {
                i2 = i3;
            }
            if (parcel.readInt() == 0) {
                obj7 = 0;
            } else {
                obj7 = DogOwnerInvitation.CREATOR.createFromParcel(parcel);
            }
            i iVar = new i((Uri)parcel.readParcelable(i.class.getClassLoader()), i, i2, (DogOwnerInvitation)obj7);
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.view.main_screen.i[] b(int i) {
            return new i[i];
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
        i.a aVar = new i.a(0);
        i.Companion = aVar;
        i.b bVar = new i.b();
        i.CREATOR = bVar;
    }

    public i() {
        super(0, 0, 0, 0, 15, 0);
    }

    public i(Uri uri, boolean z2, boolean z3, DogOwnerInvitation dogOwnerInvitation4) {
        super();
        this.a = uri;
        this.b = z2;
        this.c = z3;
        this.v = dogOwnerInvitation4;
    }

    public i(Uri uri, boolean z2, boolean z3, DogOwnerInvitation dogOwnerInvitation4, int i5, g g6) {
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        final int i = 0;
        obj3 = i5 & 1 != 0 ? i : obj3;
        final int i2 = 0;
        obj4 = i5 & 2 != 0 ? i2 : obj4;
        obj5 = i5 & 4 != 0 ? i2 : obj5;
        obj6 = i5 &= 8 != 0 ? i : obj6;
        super(obj3, obj4, obj5, obj6);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final Uri a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final DogOwnerInvitation b() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public Intent buildIntent(Context context) {
        n.f(context, "context");
        final Intent obj3 = super.buildIntent(context);
        obj3.putExtra("android.intent.extra.STREAM", a());
        obj3.putExtra("intent_dog_premium_key", d());
        obj3.putExtra("called_from_onboarding", c());
        obj3.putExtra("dog_invite_data", b());
        return obj3;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean c() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean d() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    protected Class<?> getActivityClass() {
        return MainScreenActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeParcelable(this.a, i2);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        DogOwnerInvitation dogOwnerInvitation = this.v;
        if (dogOwnerInvitation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dogOwnerInvitation.writeToParcel(parcel, i2);
        }
    }
}
