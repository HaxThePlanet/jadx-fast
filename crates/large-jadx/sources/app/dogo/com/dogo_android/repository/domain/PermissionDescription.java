package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "", "title", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PermissionDescription {

    private final String description;
    private final String title;
    public PermissionDescription(String string, String string2) {
        n.f(string, "title");
        n.f(string2, "description");
        super();
        this.title = string;
        this.description = string2;
    }

    public static app.dogo.com.dogo_android.repository.domain.PermissionDescription copy$default(app.dogo.com.dogo_android.repository.domain.PermissionDescription permissionDescription, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = permissionDescription.title;
        }
        if (i4 &= 2 != 0) {
            obj2 = permissionDescription.description;
        }
        return permissionDescription.copy(obj1, obj2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final app.dogo.com.dogo_android.repository.domain.PermissionDescription copy(String string, String string2) {
        n.f(string, "title");
        n.f(string2, "description");
        PermissionDescription permissionDescription = new PermissionDescription(string, string2);
        return permissionDescription;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PermissionDescription) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        return i;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PermissionDescription(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
