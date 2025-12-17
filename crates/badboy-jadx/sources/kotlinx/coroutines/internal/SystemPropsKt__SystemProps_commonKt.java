package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\t", d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/internal/SystemPropsKt")
final class SystemPropsKt__SystemProps_commonKt {
    public static final int systemProp(String propertyName, int defaultValue, int minValue, int maxValue) {
        return (int)systemProp;
    }

    public static final long systemProp(String propertyName, long defaultValue, long minValue, long maxValue) {
        int cmp;
        int i;
        final String systemProp = SystemPropsKt.systemProp(propertyName);
        if (systemProp == null) {
            return defaultValue;
        }
        Long longOrNull = StringsKt.toLongOrNull(systemProp);
        int i2 = 39;
        String str = "System property '";
        if (longOrNull == null) {
        } else {
            long longValue = longOrNull.longValue();
            i = 0;
            if (Long.compare(maxValue, longValue) <= 0 && Long.compare(longValue, obj12) <= 0) {
                if (Long.compare(longValue, obj12) <= 0) {
                    i = 1;
                }
            }
            if (i == 0) {
            } else {
                return longValue;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.append(str).append(propertyName).append("' should be in range ").append(maxValue).append("..").append(obj12).append(", but is '").append(longValue).append(i2).toString().toString());
            throw illegalStateException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder.append(str).append(propertyName).append("' has unrecognized value '").append(systemProp).append(i2).toString().toString());
        throw illegalStateException2;
    }

    public static final String systemProp(String propertyName, String defaultValue) {
        String systemProp;
        if (SystemPropsKt.systemProp(propertyName) == null) {
            systemProp = defaultValue;
        }
        return systemProp;
    }

    public static final boolean systemProp(String propertyName, boolean defaultValue) {
        boolean boolean;
        String systemProp = SystemPropsKt.systemProp(propertyName);
        if (systemProp != null) {
            boolean = Boolean.parseBoolean(systemProp);
        } else {
            boolean = defaultValue;
        }
        return boolean;
    }

    public static int systemProp$default(String string, int i2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 4 != 0) {
            obj2 = 1;
        }
        if (i5 &= 8 != 0) {
            obj3 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(string, i2, obj2, obj3);
    }

    public static long systemProp$default(String string, long l2, long l3, long l4, int i5, Object object6) {
        int i;
        long l;
        int obj10;
        long obj12;
        i = obj14 & 4 != 0 ? obj10 : l4;
        l = obj14 & 8 != 0 ? obj12 : object6;
        return SystemPropsKt.systemProp(string, l2, obj2, i);
    }
}
