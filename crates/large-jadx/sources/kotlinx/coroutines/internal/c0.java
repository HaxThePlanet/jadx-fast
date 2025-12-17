package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.k0.l;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0000¨\u0006\t", d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/internal/SystemPropsKt")
final class c0 {
    public static final int a(String string, int i2, int i3, int i4) {
        return (int)obj7;
    }

    public static final long b(String string, long l2, long l3, long l4) {
        int i;
        int obj5;
        String str = a0.d(string);
        if (str == null) {
            return l2;
        }
        obj5 = l.o(str);
        final int obj6 = 39;
        final String str2 = "System property '";
        if (obj5 == null) {
        } else {
            final long longValue = obj5.longValue();
            i = 0;
            if (Long.compare(l4, longValue) <= 0 && Long.compare(longValue, obj9) <= 0) {
                if (Long.compare(longValue, obj9) <= 0) {
                    i = 1;
                }
            }
            if (i == 0) {
            } else {
                return longValue;
            }
            obj5 = new StringBuilder();
            obj5.append(str2);
            obj5.append(string);
            obj5.append("' should be in range ");
            obj5.append(l4);
            obj5.append("..");
            obj5.append(obj9);
            obj5.append(", but is '");
            obj5.append(longValue);
            obj5.append(obj6);
            obj5 = new IllegalStateException(obj5.toString().toString());
            throw obj5;
        }
        obj5 = new StringBuilder();
        obj5.append(str2);
        obj5.append(string);
        obj5.append("' has unrecognized value '");
        obj5.append(str);
        obj5.append(obj6);
        obj5 = new IllegalStateException(obj5.toString().toString());
        throw obj5;
    }

    public static final boolean c(String string, boolean z2) {
        boolean obj1;
        final String obj0 = a0.d(string);
        if (obj0 == null) {
        } else {
            obj1 = Boolean.parseBoolean(obj0);
        }
        return obj1;
    }

    public static int d(String string, int i2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 4 != 0) {
            obj2 = 1;
        }
        if (i5 &= 8 != 0) {
            obj3 = Integer.MAX_VALUE;
        }
        return a0.b(string, i2, obj2, obj3);
    }

    public static long e(String string, long l2, long l3, long l4, int i5, Object object6) {
        int obj10;
        long obj12;
        if (obj14 & 4 != 0) {
            obj10 = 1;
        }
        if (obj14 & 8 != 0) {
            obj12 = Long.MAX_VALUE;
        }
        return a0.c(string, l2, obj2, obj10);
    }
}
