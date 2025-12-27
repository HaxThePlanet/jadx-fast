package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DashboardExam.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DashboardExam;", "", "placeholder", "", "(Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DashboardExam {

    private final String placeholder;
    public DashboardExam(String str) {
        n.f(str, "placeholder");
        super();
        this.placeholder = str;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public /* synthetic */ DashboardExam(String str, int i, g gVar) {
        String str2;
        str2 = i & 1 != 0 ? "" : str2;
        this(str2);
    }

    public DashboardExam() {
        final String str = null;
        this(str, 1, str);
    }

    public static /* synthetic */ DashboardExam copy$default(DashboardExam dashboardExam, String str, int i, Object object) {
        String placeholder2;
        if (i & 1 != 0) {
        }
        return dashboardExam.copy(placeholder2);
    }

    /* operator */ public final String component1() {
        return this.placeholder;
    }

    public final DashboardExam copy(String placeholder) {
        n.f(placeholder, "placeholder");
        return new DashboardExam(placeholder);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof DashboardExam)) {
            return false;
        }
        return !n.b(this.placeholder, other.placeholder) ? z3 : z;
    }

    public int hashCode() {
        return this.placeholder.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DashboardExam(placeholder=";
        str = str2 + this.placeholder + 41;
        return str;
    }
}
