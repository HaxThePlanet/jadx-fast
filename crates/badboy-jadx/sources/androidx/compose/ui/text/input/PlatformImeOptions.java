package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\r", d2 = {"Landroidx/compose/ui/text/input/PlatformImeOptions;", "", "privateImeOptions", "", "(Ljava/lang/String;)V", "getPrivateImeOptions", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformImeOptions {

    public static final int $stable;
    private final String privateImeOptions;
    static {
    }

    public PlatformImeOptions() {
        final int i = 0;
        super(i, 1, i);
    }

    public PlatformImeOptions(String privateImeOptions) {
        super();
        this.privateImeOptions = privateImeOptions;
    }

    public PlatformImeOptions(String string, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof PlatformImeOptions) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.privateImeOptions, obj.privateImeOptions)) {
            return i2;
        }
        return i;
    }

    public final String getPrivateImeOptions() {
        return this.privateImeOptions;
    }

    public int hashCode() {
        int i;
        String privateImeOptions = this.privateImeOptions;
        if (privateImeOptions != null) {
            i = privateImeOptions.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PlatformImeOptions(privateImeOptions=").append(this.privateImeOptions).append(')').toString();
    }
}
