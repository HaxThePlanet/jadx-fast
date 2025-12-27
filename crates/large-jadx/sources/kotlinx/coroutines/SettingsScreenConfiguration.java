package app.dogo.com.dogo_android.t;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: SettingsScreenConfiguration.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsScreenConfiguration;", "", "canResubscribe", "", "signedIn", "signedInAs", "", "(ZZLjava/lang/String;)V", "getCanResubscribe", "()Z", "getSignedIn", "getSignedInAs", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e0, reason: from kotlin metadata */
public final /* data */ class SettingsScreenConfiguration {

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean canResubscribe;
    /* renamed from: b, reason: from kotlin metadata */
    private final boolean signedIn;
    /* renamed from: c, reason: from kotlin metadata */
    private final String signedInAs;
    public e0(boolean z, boolean z2, String str) {
        n.f(str, "signedInAs");
        super();
        this.canResubscribe = z;
        this.signedIn = z2;
        this.signedInAs = str;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
        return this.canResubscribe;
    }

    public final boolean b() {
        return this.signedIn;
    }

    public final String c() {
        return this.signedInAs;
    }

    public /* synthetic */ e0(boolean z, boolean z2, String str, int i, g gVar) {
        boolean z3;
        boolean z4;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        str = i & 4 != 0 ? "" : str;
        this(z3, z4, str);
    }

    public e0() {
        this(false, false, null, 7, null);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof SettingsScreenConfiguration)) {
            return false;
        }
        if (this.canResubscribe != other.canResubscribe) {
            return false;
        }
        if (this.signedIn != other.signedIn) {
            return false;
        }
        return !n.b(this.signedInAs, other.signedInAs) ? z3 : z;
    }

    public int hashCode() {
        boolean canResubscribe2;
        int i = 1;
        i = 1;
        if (this.canResubscribe) {
        }
        if (!(this.signedIn)) {
        }
        return (canResubscribe2 * 31) + i * 31 + this.signedInAs.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SettingsScreenConfiguration(canResubscribe=";
        String str3 = ", signedIn=";
        String str4 = ", signedInAs=";
        str = str2 + this.canResubscribe + str3 + this.signedIn + str4 + this.signedInAs + 41;
        return str;
    }
}
