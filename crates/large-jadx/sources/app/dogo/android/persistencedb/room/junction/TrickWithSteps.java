package e.a.a.a.b.c;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: TrickWithSteps.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/android/persistencedb/room/junction/TrickWithSteps;", "", "locale_stepId", "", "locale_trickId", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocale_stepId", "()Ljava/lang/String;", "getLocale_trickId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final /* data */ class TrickWithSteps {

    /* renamed from: a, reason: from kotlin metadata */
    private final String locale_stepId;
    /* renamed from: b, reason: from kotlin metadata */
    private final String locale_trickId;
    public j(String str, String str2) {
        n.f(str, "locale_stepId");
        n.f(str2, "locale_trickId");
        super();
        this.locale_stepId = str;
        this.locale_trickId = str2;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.locale_stepId;
    }

    public final String b() {
        return this.locale_trickId;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof TrickWithSteps)) {
            return false;
        }
        if (!n.b(this.locale_stepId, other.locale_stepId)) {
            return false;
        }
        return !n.b(this.locale_trickId, other.locale_trickId) ? z4 : z;
    }

    public int hashCode() {
        return (this.locale_stepId.hashCode() * 31) + this.locale_trickId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickWithSteps(locale_stepId=";
        String str3 = ", locale_trickId=";
        str = str2 + this.locale_stepId + str3 + this.locale_trickId + 41;
        return str;
    }
}
