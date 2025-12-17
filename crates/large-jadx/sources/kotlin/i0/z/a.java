package kotlin.i0.z;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.d0.d.n;
import kotlin.i0.c;
import kotlin.i0.l.a;
import kotlin.i0.z.e.f;
import kotlin.i0.z.e.j0;
import kotlin.i0.z.e.l0.d;

/* loaded from: classes3.dex */
public final class a {
    public static final void a(c<?> c, boolean z2) {
        Object obj;
        Field field;
        boolean z;
        Object obj3;
        n.f(c, "$this$isAccessible");
        if (c instanceof h) {
            Object obj2 = c;
            field = c.b((l)obj2);
            if (field != null) {
                field.setAccessible(z2);
            }
            obj = c.c(obj2);
            if (obj != null) {
                obj.setAccessible(z2);
            }
            obj3 = c.e((h)c);
            if (obj3 != null) {
                obj3.setAccessible(z2);
            }
        } else {
            if (c instanceof l) {
                obj = c.b((l)c);
                if (obj != null) {
                    obj.setAccessible(z2);
                }
                obj3 = c.c(c);
                if (obj3 != null) {
                    obj3.setAccessible(z2);
                }
            } else {
                if (c instanceof l.b) {
                    obj = c.b((l.b)c.j());
                    if (obj != null) {
                        obj.setAccessible(z2);
                    }
                    obj3 = c.d((g)c);
                    if (obj3 != null) {
                        obj3.setAccessible(z2);
                    }
                } else {
                    if (c instanceof h.a) {
                        obj = c.b((h.a)c.j());
                        if (obj != null) {
                            obj.setAccessible(z2);
                        }
                        obj3 = c.d((g)c);
                        if (obj3 != null) {
                            obj3.setAccessible(z2);
                        }
                    } else {
                        if (!c instanceof g) {
                        } else {
                            obj = c;
                            Method method = c.d((g)obj);
                            if (method != null) {
                                method.setAccessible(z2);
                            }
                            obj3 = j0.a(c);
                            obj3 = obj3.x();
                            if (obj3 != null && obj3 != null) {
                                obj3 = obj3.x();
                                if (obj3 != null) {
                                    obj3 = obj3.b();
                                } else {
                                    obj3 = field;
                                }
                            } else {
                            }
                            if (obj3 instanceof AccessibleObject == null) {
                            } else {
                                field = obj3;
                            }
                            if ((AccessibleObject)field != 0) {
                                (AccessibleObject)field.setAccessible(true);
                            }
                            obj3 = c.a(obj);
                            if (obj3 != null) {
                                obj3.setAccessible(z2);
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown callable: ");
        stringBuilder.append(c);
        stringBuilder.append(" (");
        stringBuilder.append(c.getClass());
        stringBuilder.append(')');
        UnsupportedOperationException obj4 = new UnsupportedOperationException(stringBuilder.toString());
        throw obj4;
    }
}
