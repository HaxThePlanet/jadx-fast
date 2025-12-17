package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ApiError;", "", "name", "", "type", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getName", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApiError {

    private final String message;
    private final String name;
    private final String type;
    public ApiError(String string, String string2, String string3) {
        super();
        this.name = string;
        this.type = string2;
        this.message = string3;
    }

    public static app.dogo.com.dogo_android.repository.domain.ApiError copy$default(app.dogo.com.dogo_android.repository.domain.ApiError apiError, String string2, String string3, String string4, int i5, Object object6) {
        String obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = apiError.name;
        }
        if (i5 & 2 != 0) {
            obj2 = apiError.type;
        }
        if (i5 &= 4 != 0) {
            obj3 = apiError.message;
        }
        return apiError.copy(obj1, obj2, obj3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.message;
    }

    public final app.dogo.com.dogo_android.repository.domain.ApiError copy(String string, String string2, String string3) {
        ApiError apiError = new ApiError(string, string2, string3);
        return apiError;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof ApiError == null) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (!n.b(this.message, object.message)) {
            return i2;
        }
        return i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        int i;
        int i2;
        String name = this.name;
        i = 0;
        if (name == null) {
            i3 = i;
        } else {
            i3 = name.hashCode();
        }
        String type = this.type;
        if (type == null) {
            i2 = i;
        } else {
            i2 = type.hashCode();
        }
        String message = this.message;
        if (message == null) {
        } else {
            i = message.hashCode();
        }
        return i6 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApiError(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
