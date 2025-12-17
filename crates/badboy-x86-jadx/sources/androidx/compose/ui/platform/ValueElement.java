package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0013", d2 = {"Landroidx/compose/ui/platform/ValueElement;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ValueElement {

    public static final int $stable = 8;
    private final String name;
    private final Object value;
    static {
        final int i = 8;
    }

    public ValueElement(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }

    public static androidx.compose.ui.platform.ValueElement copy$default(androidx.compose.ui.platform.ValueElement valueElement, String string2, Object object3, int i4, Object object5) {
        String obj1;
        Object obj2;
        if (i4 & 1 != 0) {
            obj1 = valueElement.name;
        }
        if (i4 &= 2 != 0) {
            obj2 = valueElement.value;
        }
        return valueElement.copy(obj1, obj2);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final androidx.compose.ui.platform.ValueElement copy(String string, Object object2) {
        ValueElement valueElement = new ValueElement(string, object2);
        return valueElement;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ValueElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.name, obj.name)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.value, obj.value)) {
            return i2;
        }
        return i;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        if (this.value == null) {
            i = 0;
        } else {
            i = this.value.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ValueElement(name=").append(this.name).append(", value=").append(this.value).append(')').toString();
    }
}
