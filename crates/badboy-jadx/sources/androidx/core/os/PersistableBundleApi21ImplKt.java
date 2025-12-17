package androidx.core.os;

import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r", d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", "capacity", "", "putValue", "", "persistableBundle", "key", "", "value", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PersistableBundleApi21ImplKt {

    public static final androidx.core.os.PersistableBundleApi21ImplKt INSTANCE;
    static {
        PersistableBundleApi21ImplKt persistableBundleApi21ImplKt = new PersistableBundleApi21ImplKt();
        PersistableBundleApi21ImplKt.INSTANCE = persistableBundleApi21ImplKt;
    }

    @JvmStatic
    public static final PersistableBundle createPersistableBundle(int capacity) {
        PersistableBundle persistableBundle = new PersistableBundle(capacity);
        return persistableBundle;
    }

    @JvmStatic
    public static final void putValue(PersistableBundle persistableBundle, String key, Object value) {
        int componentType;
        Object obj;
        String str;
        boolean assignableFrom;
        final PersistableBundle bundle = persistableBundle;
        final int i = 0;
        if (value == null) {
            bundle.putString(key, 0);
        } else {
            if (value instanceof Boolean) {
                PersistableBundleApi22ImplKt.putBoolean(bundle, key, (Boolean)value.booleanValue());
            } else {
                if (value instanceof Double) {
                    bundle.putDouble(key, (Number)value.doubleValue());
                } else {
                    if (value instanceof Integer) {
                        bundle.putInt(key, (Number)value.intValue());
                    } else {
                        if (value instanceof Long) {
                            bundle.putLong(key, (Number)value.longValue());
                        } else {
                            if (value instanceof String != null) {
                                bundle.putString(key, (String)value);
                            } else {
                                if (value instanceof PersistableBundle != null) {
                                    bundle.putPersistableBundle(key, (PersistableBundle)value);
                                } else {
                                    if (value instanceof boolean[]) {
                                        PersistableBundleApi22ImplKt.putBooleanArray(bundle, key, (boolean[])value);
                                    } else {
                                        if (value instanceof double[]) {
                                            bundle.putDoubleArray(key, (double[])value);
                                        } else {
                                            if (value instanceof int[]) {
                                                bundle.putIntArray(key, (int[])value);
                                            } else {
                                                if (value instanceof long[]) {
                                                    bundle.putLongArray(key, (long[])value);
                                                } else {
                                                    int i2 = 34;
                                                    str = " for key \"";
                                                    if (!value instanceof Object[]) {
                                                    } else {
                                                        componentType = value.getClass().getComponentType();
                                                        Intrinsics.checkNotNull(componentType);
                                                        if (!String.class.isAssignableFrom(componentType)) {
                                                        } else {
                                                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                                                            bundle.putStringArray(key, (String[])value);
                                                        }
                                                        StringBuilder stringBuilder2 = new StringBuilder();
                                                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Unsupported value array type ").append(componentType.getCanonicalName()).append(str).append(key).append(i2).toString());
                                                        throw illegalArgumentException2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unsupported value type ").append(value.getClass().getCanonicalName()).append(str).append(key).append(i2).toString());
        throw illegalArgumentException;
    }
}
