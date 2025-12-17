package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/UserAuthRecord;", "", "email", "", "displayName", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getEmail", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserAuthRecord {

    private final String displayName;
    private final String email;
    public UserAuthRecord(String string, String string2) {
        super();
        this.email = string;
        this.displayName = string2;
    }

    public static app.dogo.com.dogo_android.repository.domain.UserAuthRecord copy$default(app.dogo.com.dogo_android.repository.domain.UserAuthRecord userAuthRecord, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = userAuthRecord.email;
        }
        if (i4 &= 2 != 0) {
            obj2 = userAuthRecord.displayName;
        }
        return userAuthRecord.copy(obj1, obj2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.displayName;
    }

    public final app.dogo.com.dogo_android.repository.domain.UserAuthRecord copy(String string, String string2) {
        UserAuthRecord userAuthRecord = new UserAuthRecord(string, string2);
        return userAuthRecord;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof UserAuthRecord) {
            return i2;
        }
        if (!n.b(this.email, object.email)) {
            return i2;
        }
        if (!n.b(this.displayName, object.displayName)) {
            return i2;
        }
        return i;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getEmail() {
        return this.email;
    }

    public int hashCode() {
        int i;
        int i2;
        String email = this.email;
        if (email == null) {
            i = i2;
        } else {
            i = email.hashCode();
        }
        final String displayName = this.displayName;
        if (displayName == null) {
        } else {
            i2 = displayName.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserAuthRecord(email=");
        stringBuilder.append(this.email);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
