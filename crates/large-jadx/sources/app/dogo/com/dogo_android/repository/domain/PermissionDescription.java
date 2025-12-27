package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: PermissionDescription.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "", "title", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PermissionDescription {

    private final String description;
    private final String title;
    public PermissionDescription(String str, String str2) {
        n.f(str, "title");
        n.f(str2, "description");
        super();
        this.title = str;
        this.description = str2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public static /* synthetic */ PermissionDescription copy$default(PermissionDescription permissionDescription, String str, String str2, int i, Object object) {
        String title2;
        String description2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return permissionDescription.copy(title2, description2);
    }

    /* operator */ public final String component1() {
        return this.title;
    }

    /* operator */ public final String component2() {
        return this.description;
    }

    public final PermissionDescription copy(String title, String description) {
        n.f(title, "title");
        n.f(description, "description");
        return new PermissionDescription(title, description);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof PermissionDescription)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        return !n.b(this.description, other.description) ? z4 : z;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PermissionDescription(title=";
        String str3 = ", description=";
        str = str2 + this.title + str3 + this.description + 41;
        return str;
    }
}
