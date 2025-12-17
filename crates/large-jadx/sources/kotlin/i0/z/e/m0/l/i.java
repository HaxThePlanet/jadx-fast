package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class i extends kotlin.i0.z.e.m0.l.b implements kotlin.i0.z.e.m0.l.t0 {

    private final e d;
    private final List<z0> e;
    private final Collection<kotlin.i0.z.e.m0.l.b0> f;
    public i(e e, List<? extends z0> list2, Collection<kotlin.i0.z.e.m0.l.b0> collection3, n n4) {
        final int i = 0;
        if (e == null) {
        } else {
            if (list2 == null) {
            } else {
                if (collection3 == null) {
                } else {
                    if (n4 == null) {
                    } else {
                        super(n4);
                        this.d = e;
                        ArrayList obj2 = new ArrayList(list2);
                        this.e = Collections.unmodifiableList(obj2);
                        this.f = Collections.unmodifiableCollection(collection3);
                    }
                    i.r(3);
                    throw i;
                }
                i.r(2);
                throw i;
            }
            i.r(1);
            throw i;
        }
        i.r(0);
        throw i;
    }

    private static void r(int i) {
        String str2;
        int i2;
        String str;
        String str3;
        Object obj10;
        final int i4 = 7;
        final int i5 = 6;
        final int i6 = 5;
        final int i7 = 4;
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    str2 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                } else {
                }
            } else {
            }
        } else {
        }
        final int i8 = 2;
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    i2 = i != i4 ? 3 : i8;
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        int i9 = 0;
        switch (i) {
            case 1:
                arr[i9] = "parameters";
                break;
            case 2:
                arr[i9] = "supertypes";
                break;
            case 3:
                arr[i9] = "storageManager";
                break;
            case 4:
                arr[i9] = str;
                break;
            default:
                arr[i9] = "classDescriptor";
        }
        int i10 = 1;
        if (i != i7) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        arr[i10] = str;
                    } else {
                        arr[i10] = "getSupertypeLoopChecker";
                    }
                } else {
                    arr[i10] = "computeSupertypes";
                }
            } else {
                arr[i10] = "getDeclarationDescriptor";
            }
        } else {
            arr[i10] = "getParameters";
        }
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        arr[i8] = "<init>";
                    }
                }
            }
        }
        String format = String.format(str2, arr);
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        obj10 = new IllegalArgumentException(format);
                    } else {
                        obj10 = new IllegalStateException(format);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj10;
    }

    @Override // kotlin.i0.z.e.m0.l.b
    public boolean d() {
        return 1;
    }

    public List<z0> getParameters() {
        List list = this.e;
        if (list == null) {
        } else {
            return list;
        }
        i.r(4);
        throw 0;
    }

    protected Collection<kotlin.i0.z.e.m0.l.b0> h() {
        Collection collection = this.f;
        if (collection == null) {
        } else {
            return collection;
        }
        i.r(6);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.b
    protected x0 l() {
        x0.a aVar = x0.a.a;
        if (aVar == null) {
        } else {
            return aVar;
        }
        i.r(7);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.b
    public e t() {
        e eVar = this.d;
        if (eVar == null) {
        } else {
            return eVar;
        }
        i.r(5);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.b
    public String toString() {
        return d.m(this.d).b();
    }
}
