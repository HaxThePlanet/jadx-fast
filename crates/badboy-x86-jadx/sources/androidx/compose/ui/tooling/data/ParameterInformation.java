package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001a\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00062\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006#", d2 = {"Landroidx/compose/ui/tooling/data/ParameterInformation;", "", "name", "", "value", "fromDefault", "", "static", "compared", "inlineClass", "stable", "(Ljava/lang/String;Ljava/lang/Object;ZZZLjava/lang/String;Z)V", "getCompared", "()Z", "getFromDefault", "getInlineClass", "()Ljava/lang/String;", "getName", "getStable", "getStatic", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParameterInformation {

    public static final int $stable = 8;
    private final boolean compared;
    private final boolean fromDefault;
    private final String inlineClass;
    private final String name;
    private final boolean stable;
    private final boolean static;
    private final Object value;
    static {
        final int i = 8;
    }

    public ParameterInformation(String name, Object value, boolean fromDefault, boolean static, boolean compared, String inlineClass, boolean stable) {
        super();
        this.name = name;
        this.value = value;
        this.fromDefault = fromDefault;
        this.static = static;
        this.compared = compared;
        this.inlineClass = inlineClass;
        this.stable = stable;
    }

    public static androidx.compose.ui.tooling.data.ParameterInformation copy$default(androidx.compose.ui.tooling.data.ParameterInformation parameterInformation, String string2, Object object3, boolean z4, boolean z5, boolean z6, String string7, boolean z8, int i9, Object object10) {
        String obj1;
        Object obj2;
        boolean obj3;
        boolean obj4;
        boolean obj5;
        String obj6;
        boolean obj7;
        if (i9 & 1 != 0) {
            obj1 = parameterInformation.name;
        }
        if (i9 & 2 != 0) {
            obj2 = parameterInformation.value;
        }
        if (i9 & 4 != 0) {
            obj3 = parameterInformation.fromDefault;
        }
        if (i9 & 8 != 0) {
            obj4 = parameterInformation.static;
        }
        if (i9 & 16 != 0) {
            obj5 = parameterInformation.compared;
        }
        if (i9 & 32 != 0) {
            obj6 = parameterInformation.inlineClass;
        }
        if (i9 &= 64 != 0) {
            obj7 = parameterInformation.stable;
        }
        return parameterInformation.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final boolean component3() {
        return this.fromDefault;
    }

    public final boolean component4() {
        return this.static;
    }

    public final boolean component5() {
        return this.compared;
    }

    public final String component6() {
        return this.inlineClass;
    }

    public final boolean component7() {
        return this.stable;
    }

    public final androidx.compose.ui.tooling.data.ParameterInformation copy(String string, Object object2, boolean z3, boolean z4, boolean z5, String string6, boolean z7) {
        ParameterInformation parameterInformation = new ParameterInformation(string, object2, z3, z4, z5, string6, z7);
        return parameterInformation;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ParameterInformation) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.name, obj.name)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.value, obj.value)) {
            return i2;
        }
        if (this.fromDefault != obj.fromDefault) {
            return i2;
        }
        if (this.static != obj.static) {
            return i2;
        }
        if (this.compared != obj.compared) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.inlineClass, obj.inlineClass)) {
            return i2;
        }
        if (this.stable != obj.stable) {
            return i2;
        }
        return i;
    }

    public final boolean getCompared() {
        return this.compared;
    }

    public final boolean getFromDefault() {
        return this.fromDefault;
    }

    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getStable() {
        return this.stable;
    }

    public final boolean getStatic() {
        return this.static;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        String inlineClass;
        int i2;
        if (this.value == null) {
            i = i2;
        } else {
            i = this.value.hashCode();
        }
        if (this.inlineClass == null) {
        } else {
            i2 = this.inlineClass.hashCode();
        }
        return i8 += i19;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ParameterInformation(name=").append(this.name).append(", value=").append(this.value).append(", fromDefault=").append(this.fromDefault).append(", static=").append(this.static).append(", compared=").append(this.compared).append(", inlineClass=").append(this.inlineClass).append(", stable=").append(this.stable).append(')').toString();
    }
}
