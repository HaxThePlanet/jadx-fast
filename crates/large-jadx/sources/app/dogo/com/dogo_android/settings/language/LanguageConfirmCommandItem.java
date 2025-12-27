package app.dogo.com.dogo_android.t.h0;

import com.google.android.play.core.splitinstall.d;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LanguageSelectionCommandItem.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageConfirmCommandItem;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectionCommandItem;", "splitInstallSessionState", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)V", "getSplitInstallSessionState", "()Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final /* data */ class LanguageConfirmCommandItem extends n {

    private final d a;
    public h(d dVar) {
        n.f(dVar, "splitInstallSessionState");
        super(null);
        this.a = dVar;
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final d component1() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof LanguageConfirmCommandItem)) {
            return false;
        }
        return !n.b(this.a, other.a) ? z3 : z;
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // app.dogo.com.dogo_android.t.h0.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LanguageConfirmCommandItem(splitInstallSessionState=";
        str = str2 + this.a + 41;
        return str;
    }
}
