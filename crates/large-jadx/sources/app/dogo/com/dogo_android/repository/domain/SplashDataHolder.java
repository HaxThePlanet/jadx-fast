package app.dogo.com.dogo_android.repository.domain;

import android.content.Context;
import android.net.Uri;
import app.dogo.com.dogo_android.dogcreation.f;
import app.dogo.com.dogo_android.profile.invitation.f;
import app.dogo.com.dogo_android.util.h0.p1;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.view.main_screen.i;
import app.dogo.com.dogo_android.welcome_v2.o0;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B/\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u000e\"\u0004\u0008\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000e\"\u0004\u0008\u0014\u0010\u0010¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SplashDataHolder;", "", "firstLaunch", "", "noDogs", "isDogPremium", "deeplink", "Landroid/net/Uri;", "(ZZZLandroid/net/Uri;)V", "getDeeplink", "()Landroid/net/Uri;", "setDeeplink", "(Landroid/net/Uri;)V", "getFirstLaunch", "()Z", "setFirstLaunch", "(Z)V", "setDogPremium", "isInvitePending", "getNoDogs", "setNoDogs", "component1", "component2", "component3", "component4", "copy", "equals", "other", "getNextIntent", "Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;", "context", "Landroid/content/Context;", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SplashDataHolder {

    private Uri deeplink;
    private boolean firstLaunch;
    private boolean isDogPremium;
    private boolean noDogs;
    public SplashDataHolder() {
        super(0, 0, 0, 0, 15, 0);
    }

    public SplashDataHolder(boolean z, boolean z2, boolean z3, Uri uri4) {
        super();
        this.firstLaunch = z;
        this.noDogs = z2;
        this.isDogPremium = z3;
        this.deeplink = uri4;
    }

    public SplashDataHolder(boolean z, boolean z2, boolean z3, Uri uri4, int i5, g g6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? 0 : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public static app.dogo.com.dogo_android.repository.domain.SplashDataHolder copy$default(app.dogo.com.dogo_android.repository.domain.SplashDataHolder splashDataHolder, boolean z2, boolean z3, boolean z4, Uri uri5, int i6, Object object7) {
        boolean obj1;
        boolean obj2;
        boolean obj3;
        Uri obj4;
        if (i6 & 1 != 0) {
            obj1 = splashDataHolder.firstLaunch;
        }
        if (i6 & 2 != 0) {
            obj2 = splashDataHolder.noDogs;
        }
        if (i6 & 4 != 0) {
            obj3 = splashDataHolder.isDogPremium;
        }
        if (i6 &= 8 != 0) {
            obj4 = splashDataHolder.deeplink;
        }
        return splashDataHolder.copy(obj1, obj2, obj3, obj4);
    }

    private final boolean isInvitePending() {
        Uri deeplink;
        int i;
        deeplink = this.deeplink;
        i = 0;
        final int i2 = 1;
        if (deeplink == null) {
        } else {
            if (p1.j(deeplink) == i2) {
                i = i2;
            }
        }
        return i;
    }

    public final boolean component1() {
        return this.firstLaunch;
    }

    public final boolean component2() {
        return this.noDogs;
    }

    public final boolean component3() {
        return this.isDogPremium;
    }

    public final Uri component4() {
        return this.deeplink;
    }

    public final app.dogo.com.dogo_android.repository.domain.SplashDataHolder copy(boolean z, boolean z2, boolean z3, Uri uri4) {
        SplashDataHolder splashDataHolder = new SplashDataHolder(z, z2, z3, uri4);
        return splashDataHolder;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SplashDataHolder) {
            return i2;
        }
        if (this.firstLaunch != object.firstLaunch) {
            return i2;
        }
        if (this.noDogs != object.noDogs) {
            return i2;
        }
        if (this.isDogPremium != object.isDogPremium) {
            return i2;
        }
        if (!n.b(this.deeplink, object.deeplink)) {
            return i2;
        }
        return i;
    }

    public final Uri getDeeplink() {
        return this.deeplink;
    }

    public final boolean getFirstLaunch() {
        return this.firstLaunch;
    }

    public final app.dogo.com.dogo_android.repository.domain.DogoIntent getNextIntent(Context context) {
        a o0Var;
        Object deeplink;
        Uri isDogPremium2;
        String isDogPremium;
        int i4;
        int i2;
        int i3;
        int i;
        i iVar;
        android.content.Intent obj9;
        n.f(context, "context");
        if (isInvitePending()) {
            deeplink = this.deeplink;
            isDogPremium = "";
            if (deeplink == null) {
            } else {
                deeplink = p1.d(deeplink);
                if (deeplink == null) {
                } else {
                    isDogPremium = deeplink;
                }
            }
            o0Var = new f(isDogPremium, this.isDogPremium);
            obj9 = o0Var.buildIntent(context);
        } else {
            if (this.firstLaunch) {
                o0Var = new o0(this.deeplink, this.isDogPremium);
                obj9 = o0Var.buildIntent(context);
            } else {
                if (this.noDogs) {
                    super(0, 0, 1, 1, 2, 0);
                    obj9 = o0Var.buildIntent(context);
                } else {
                    o0Var = new f(this.deeplink, this.isDogPremium, 0, 0, 12, 0);
                    obj9 = iVar.buildIntent(context);
                }
            }
        }
        DogoIntent dogoIntent = new DogoIntent(obj9);
        return dogoIntent;
    }

    public final boolean getNoDogs() {
        return this.noDogs;
    }

    public int hashCode() {
        boolean firstLaunch;
        boolean i;
        int i2;
        boolean noDogs;
        i = 1;
        if (this.firstLaunch) {
            firstLaunch = i;
        }
        if (this.noDogs) {
            noDogs = i;
        }
        boolean isDogPremium = this.isDogPremium;
        if (isDogPremium) {
        } else {
            i = isDogPremium;
        }
        Uri deeplink = this.deeplink;
        if (deeplink == null) {
            i2 = 0;
        } else {
            i2 = deeplink.hashCode();
        }
        return i7 += i2;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SplashDataHolder(firstLaunch=");
        stringBuilder.append(this.firstLaunch);
        stringBuilder.append(", noDogs=");
        stringBuilder.append(this.noDogs);
        stringBuilder.append(", isDogPremium=");
        stringBuilder.append(this.isDogPremium);
        stringBuilder.append(", deeplink=");
        stringBuilder.append(this.deeplink);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
