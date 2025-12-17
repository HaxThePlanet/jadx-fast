package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DashboardExam;", "", "placeholder", "", "(Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DashboardExam {

    private final String placeholder;
    public DashboardExam() {
        final int i = 0;
        super(i, 1, i);
    }

    public DashboardExam(String string) {
        n.f(string, "placeholder");
        super();
        this.placeholder = string;
    }

    public DashboardExam(String string, int i2, g g3) {
        String obj1;
        obj1 = i2 &= 1 != 0 ? "" : obj1;
        super(obj1);
    }

    public static app.dogo.com.dogo_android.repository.domain.DashboardExam copy$default(app.dogo.com.dogo_android.repository.domain.DashboardExam dashboardExam, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = dashboardExam.placeholder;
        }
        return dashboardExam.copy(obj1);
    }

    public final String component1() {
        return this.placeholder;
    }

    public final app.dogo.com.dogo_android.repository.domain.DashboardExam copy(String string) {
        n.f(string, "placeholder");
        DashboardExam dashboardExam = new DashboardExam(string);
        return dashboardExam;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DashboardExam) {
            return i2;
        }
        if (!n.b(this.placeholder, object.placeholder)) {
            return i2;
        }
        return i;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public int hashCode() {
        return this.placeholder.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DashboardExam(placeholder=");
        stringBuilder.append(this.placeholder);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
