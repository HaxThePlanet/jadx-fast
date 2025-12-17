package kotlin.i0.z.e.m0.i.q;

import java.util.Arrays;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class e extends kotlin.i0.z.e.m0.i.q.o<Character> {
    public e(char c) {
        super(Character.valueOf(c));
    }

    private final String c(char c) {
        int i;
        String obj2;
        if (c == 8) {
            obj2 = "\\b";
        } else {
            if (c == 9) {
                obj2 = "\\t";
            } else {
                if (c == 10) {
                    obj2 = "\\n";
                } else {
                    if (c == 12) {
                        obj2 = "\\f";
                    } else {
                        if (c == 13) {
                            obj2 = "\\r";
                        } else {
                            if (e(c)) {
                                obj2 = String.valueOf(c);
                            } else {
                                obj2 = "?";
                            }
                        }
                    }
                }
            }
        }
        return obj2;
    }

    private final boolean e(char c) {
        int i;
        int obj2;
        obj2 = (byte)obj2;
        if (obj2 != 0 && obj2 != 13 && obj2 != 14 && obj2 != 15 && obj2 != 16 && obj2 != 18 && obj2 != 19) {
            if (obj2 != 13) {
                if (obj2 != 14) {
                    if (obj2 != 15) {
                        if (obj2 != 16) {
                            if (obj2 != 18) {
                                obj2 = obj2 != 19 ? 1 : 0;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.o
    public b0 a(c0 c0) {
        return d(c0);
    }

    @Override // kotlin.i0.z.e.m0.i.q.o
    public i0 d(c0 c0) {
        n.f(c0, "module");
        i0 obj2 = c0.m().u();
        n.e(obj2, "module.builtIns.charType");
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.o
    public String toString() {
        int i = 2;
        Object[] arr = new Object[i];
        arr[0] = Integer.valueOf((Character)b().charValue());
        arr[1] = c((Character)b().charValue());
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        return format;
    }
}
