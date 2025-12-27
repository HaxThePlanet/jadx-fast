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

/* compiled from: MainScreenKey.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B1\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u000c\u0010\u001c\u001a\u0006\u0012\u0002\u0008\u00030\u001dH\u0014J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u0012\"\u0004\u0008\u0015\u0010\u0014¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "deeplink", "Landroid/net/Uri;", "isDogPremium", "", "isCalledFromOnboarding", "dogInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "(Landroid/net/Uri;ZZLapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;)V", "getDeeplink", "()Landroid/net/Uri;", "setDeeplink", "(Landroid/net/Uri;)V", "getDogInvite", "()Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "setDogInvite", "(Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;)V", "()Z", "setCalledFromOnboarding", "(Z)V", "setDogPremium", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class MainScreenKey extends a {

    public static final Parcelable.Creator<i> CREATOR = new i$b<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i.a INSTANCE = new i$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private Uri deeplink;
    private boolean b;
    /* renamed from: c, reason: from kotlin metadata */
    private boolean isCalledFromOnboarding;
    private DogOwnerInvitation v;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenKey$Companion;", "", "()V", "DOG_INVITE_DATA", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<i> {
        public final i a(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            DogOwnerInvitation dogOwnerInvitation = null;
            n.f(parcel, "parcel");
            int i = 0;
            int r2 = parcel.readInt() != 0 ? 1 : i;
            if (parcel.readInt() == 0) {
            }
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                Object fromParcel = DogOwnerInvitation.CREATOR.createFromParcel(parcel);
            }
            MainScreenKey mainScreenKey = new MainScreenKey((Uri)parcel.readParcelable(MainScreenKey.class.getClassLoader()), z, z2, (DogOwnerInvitation)dogOwnerInvitation);
            return mainScreenKey;
        }

        public final i[] b(int i) {
            return new i[i];
        }
    }
    public /* synthetic */ i(Uri uri, boolean z, boolean z2, DogOwnerInvitation dogOwnerInvitation, int i, g gVar) {
        Uri uri2;
        boolean z4;
        i = 0;
        if (i & 1 != 0) {
        }
        final int i2 = 0;
        i2 = i & 2 != 0 ? i2 : i2;
        i2 = i & 4 != 0 ? i2 : i2;
        i = i & 8 != 0 ? i : i;
        this(uri2, z, z4, dogOwnerInvitation);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    /* renamed from: a, reason: from kotlin metadata */
    public final Uri describeContents() {
        return this.deeplink;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final DogOwnerInvitation b() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public Intent buildIntent(Context context) {
        n.f(context, "context");
        final Intent intent = super.buildIntent(context);
        intent.putExtra("android.intent.extra.STREAM", describeContents());
        intent.putExtra("intent_dog_premium_key", d());
        intent.putExtra("called_from_onboarding", c());
        intent.putExtra("dog_invite_data", b());
        return intent;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean c() {
        return this.isCalledFromOnboarding;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean d() {
        return this.b;
    }

    public i(Uri uri, boolean z, boolean z2, DogOwnerInvitation dogOwnerInvitation) {
        super();
        this.deeplink = uri;
        this.b = z;
        this.isCalledFromOnboarding = z2;
        this.v = dogOwnerInvitation;
    }


    public i() {
        this(null, false, false, null, 15, null);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    protected Class<?> getActivityClass() {
        return MainScreenActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.deeplink, flags);
        parcel.writeInt(this.b);
        parcel.writeInt(this.isCalledFromOnboarding);
        if (this.v == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.v.writeToParcel(parcel, flags);
        }
    }
}
