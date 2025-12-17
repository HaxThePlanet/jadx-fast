package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(String propertyName, int defaultValue, int minValue, int maxValue) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(propertyName, defaultValue, minValue, maxValue);
    }

    public static final long systemProp(String propertyName, long defaultValue, long minValue, long maxValue) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(propertyName, defaultValue, minValue, maxValue);
    }

    public static final String systemProp(String propertyName) {
        return SystemPropsKt__SystemPropsKt.systemProp(propertyName);
    }

    public static final String systemProp(String propertyName, String defaultValue) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(propertyName, defaultValue);
    }

    public static final boolean systemProp(String propertyName, boolean defaultValue) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(propertyName, defaultValue);
    }

    public static int systemProp$default(String string, int i2, int i3, int i4, int i5, Object object6) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(string, i2, i3, i4, i5, object6);
    }

    public static long systemProp$default(String string, long l2, long l3, long l4, int i5, Object object6) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(string, l2, l3, l4, i5, object6);
    }
}
