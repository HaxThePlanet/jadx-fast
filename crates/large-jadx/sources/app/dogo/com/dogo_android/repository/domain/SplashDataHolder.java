package app.dogo.com.dogo_android.repository.domain;

import android.content.Context;
import android.net.Uri;
import app.dogo.com.dogo_android.util.h0.p1;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.view.main_screen.i;
import app.dogo.com.dogo_android.welcome_v2.o0;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: SplashDataHolder.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B/\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u000e\"\u0004\u0008\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000e\"\u0004\u0008\u0014\u0010\u0010¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SplashDataHolder;", "", "firstLaunch", "", "noDogs", "isDogPremium", "deeplink", "Landroid/net/Uri;", "(ZZZLandroid/net/Uri;)V", "getDeeplink", "()Landroid/net/Uri;", "setDeeplink", "(Landroid/net/Uri;)V", "getFirstLaunch", "()Z", "setFirstLaunch", "(Z)V", "setDogPremium", "isInvitePending", "getNoDogs", "setNoDogs", "component1", "component2", "component3", "component4", "copy", "equals", "other", "getNextIntent", "Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;", "context", "Landroid/content/Context;", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SplashDataHolder {

    private Uri deeplink;
    private boolean firstLaunch;
    private boolean isDogPremium;
    private boolean noDogs;
    public SplashDataHolder(boolean z, boolean z2, boolean z3, Uri uri) {
        super();
        this.firstLaunch = z;
        this.noDogs = z2;
        this.isDogPremium = z3;
        this.deeplink = uri;
    }

    private final boolean isInvitePending() {
        boolean z2 = false;
        int i2 = 0;
        final int i = 1;
        if (this.deeplink != null) {
            if (app.dogo.com.dogo_android.util.extensionfunction.p1.j(this.deeplink)) {
            }
        }
        return z2;
    }

    public final Uri getDeeplink() {
        return this.deeplink;
    }

    public final boolean getFirstLaunch() {
        return this.firstLaunch;
    }

    public final DogoIntent getNextIntent(Context context) {
        String str;
        android.content.Intent intent;
        n.f(context, "context");
        if (isInvitePending()) {
            str = "";
            if (this.deeplink != null) {
                str = app.dogo.com.dogo_android.util.extensionfunction.p1.d(this.deeplink);
                if (str != null) {
                }
            }
            DogInviteAcceptanceFlowKey dogInviteAcceptanceFlowKey = new DogInviteAcceptanceFlowKey(str, this.isDogPremium);
            intent = dogInviteAcceptanceFlowKey.buildIntent(context);
        } else {
            if (this.firstLaunch) {
                intent = new OnboardingScreenKey(this.deeplink, this.isDogPremium).buildIntent(context);
            } else {
                if (this.noDogs) {
                    DogCreationScreenKey dogCreationScreenKey = new DogCreationScreenKey(null, null, true, true, 2, null);
                    intent = dogCreationScreenKey.buildIntent(context);
                } else {
                    boolean z = false;
                    app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation = null;
                    int i = 12;
                    g gVar = null;
                    DogCreationScreenKey mainScreenKey = new DogCreationScreenKey(this.deeplink, this.isDogPremium, z, dogOwnerInvitation, i, gVar);
                    intent = mainScreenKey.buildIntent(context);
                }
            }
        }
        return new DogoIntent(intent);
    }

    public final boolean getNoDogs() {
        return this.noDogs;
    }

    public final boolean isDogPremium() {
        return this.isDogPremium;
    }

    public final void setDeeplink(Uri uri) {
        this.deeplink = uri;
    }

    public final void setDogPremium(boolean z) {
        this.isDogPremium = z;
    }

    public final void setFirstLaunch(boolean z) {
        this.firstLaunch = z;
    }

    public final void setNoDogs(boolean z) {
        this.noDogs = z;
    }

    public /* synthetic */ SplashDataHolder(boolean z, boolean z2, boolean z3, Uri uri, int i, g gVar) {
        boolean z4;
        boolean z5;
        boolean z6;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        int i2 = i & 8 != 0 ? 0 : i2;
        this(z4, z5, z6, uri);
    }

    public SplashDataHolder() {
        this(false, false, false, null, 15, null);
    }

    public static /* synthetic */ SplashDataHolder copy$default(SplashDataHolder splashDataHolder, boolean z, boolean z2, boolean z3, Uri uri, int i, Object object) {
        boolean firstLaunch2;
        boolean noDogs2;
        boolean isDogPremium2;
        Uri deeplink2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return splashDataHolder.copy(firstLaunch2, noDogs2, isDogPremium2, deeplink2);
    }

    /* operator */ public final boolean component1() {
        return this.firstLaunch;
    }

    /* operator */ public final boolean component2() {
        return this.noDogs;
    }

    /* operator */ public final boolean component3() {
        return this.isDogPremium;
    }

    /* operator */ public final Uri component4() {
        return this.deeplink;
    }

    public final SplashDataHolder copy(boolean firstLaunch, boolean noDogs, boolean isDogPremium, Uri deeplink) {
        return new SplashDataHolder(firstLaunch, noDogs, isDogPremium, deeplink);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof SplashDataHolder)) {
            return false;
        }
        if (this.firstLaunch != other.firstLaunch) {
            return false;
        }
        if (this.noDogs != other.noDogs) {
            return false;
        }
        if (this.isDogPremium != other.isDogPremium) {
            return false;
        }
        return !n.b(this.deeplink, other.deeplink) ? z3 : z;
    }

    public int hashCode() {
        boolean firstLaunch2;
        boolean isDogPremium2 = true;
        int i2 = 0;
        boolean noDogs2;
        int i = 1;
        if (this.firstLaunch) {
        }
        if (this.noDogs) {
        }
        if (!(this.isDogPremium)) {
        }
        if (this.deeplink == null) {
            i2 = 0;
        } else {
            i2 = this.deeplink.hashCode();
        }
        return (firstLaunch2 * 31) + noDogs2 * 31 + isDogPremium2 * 31 + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SplashDataHolder(firstLaunch=";
        String str3 = ", noDogs=";
        String str4 = ", isDogPremium=";
        String str5 = ", deeplink=";
        str = str2 + this.firstLaunch + str3 + this.noDogs + str4 + this.isDogPremium + str5 + this.deeplink + 41;
        return str;
    }
}
