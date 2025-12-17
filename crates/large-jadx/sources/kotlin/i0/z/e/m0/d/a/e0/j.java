package kotlin.i0.z.e.m0.d.a.e0;

import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.d.a.i0.r;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public interface j {

    public static final kotlin.i0.z.e.m0.d.a.e0.j a;

    public static class b {

        private final b0 a;
        private final b0 b;
        private final List<c1> c;
        private final List<z0> d;
        private final List<String> e;
        private final boolean f;
        public b(b0 b0, b0 b02, List<c1> list3, List<z0> list4, List<String> list5, boolean z6) {
            final int i = 0;
            if (b0 == null) {
            } else {
                if (list3 == null) {
                } else {
                    if (list4 == null) {
                    } else {
                        if (list5 == null) {
                        } else {
                            super();
                            this.a = b0;
                            this.b = b02;
                            this.c = list3;
                            this.d = list4;
                            this.e = list5;
                            this.f = z6;
                        }
                        j.b.a(3);
                        throw i;
                    }
                    j.b.a(2);
                    throw i;
                }
                j.b.a(1);
                throw i;
            }
            j.b.a(0);
            throw i;
        }

        private static void a(int i) {
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
            str = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            int i9 = 0;
            switch (i) {
                case 1:
                    arr[i9] = "valueParameters";
                    break;
                case 2:
                    arr[i9] = "typeParameters";
                    break;
                case 3:
                    arr[i9] = "signatureErrors";
                    break;
                case 4:
                    arr[i9] = str;
                    break;
                default:
                    arr[i9] = "returnType";
            }
            int i10 = 1;
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            arr[i10] = str;
                        } else {
                            arr[i10] = "getErrors";
                        }
                    } else {
                        arr[i10] = "getTypeParameters";
                    }
                } else {
                    arr[i10] = "getValueParameters";
                }
            } else {
                arr[i10] = "getReturnType";
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

        public List<String> b() {
            List list = this.e;
            if (list == null) {
            } else {
                return list;
            }
            j.b.a(7);
            throw 0;
        }

        public b0 c() {
            return this.b;
        }

        public b0 d() {
            b0 b0Var = this.a;
            if (b0Var == null) {
            } else {
                return b0Var;
            }
            j.b.a(4);
            throw 0;
        }

        public List<z0> e() {
            List list = this.d;
            if (list == null) {
            } else {
                return list;
            }
            j.b.a(6);
            throw 0;
        }

        public List<c1> f() {
            List list = this.c;
            if (list == null) {
            } else {
                return list;
            }
            j.b.a(5);
            throw 0;
        }

        public boolean g() {
            return this.f;
        }
    }

    static class a implements kotlin.i0.z.e.m0.d.a.e0.j {
        private static void c(int i) {
            int i2;
            String str;
            String obj3;
            Object[] arr = new Object[3];
            int i6 = 0;
            switch (i) {
                case 1:
                    arr[i6] = "owner";
                    break;
                case 2:
                    arr[i6] = "returnType";
                    break;
                case 3:
                    arr[i6] = "valueParameters";
                    break;
                case 4:
                    arr[i6] = "typeParameters";
                    break;
                case 5:
                    arr[i6] = "descriptor";
                    break;
                case 6:
                    arr[i6] = "signatureErrors";
                    break;
                default:
                    arr[i6] = "method";
            }
            arr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            int i8 = 2;
            if (i != 5 && i != 6) {
                if (i != 6) {
                    arr[i8] = "resolvePropagatedSignature";
                } else {
                    arr[i8] = "reportSignatureErrors";
                }
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        public kotlin.i0.z.e.m0.d.a.e0.j.b a(r r, e e2, b0 b03, b0 b04, List<c1> list5, List<z0> list6) {
            final int i = 0;
            if (r == null) {
            } else {
                if (e2 == null) {
                } else {
                    if (b03 == null) {
                    } else {
                        if (list5 == null) {
                        } else {
                            if (list6 == null) {
                            } else {
                                super(b03, b04, list5, list6, Collections.emptyList(), 0);
                                return obj9;
                            }
                            j.a.c(4);
                            throw i;
                        }
                        j.a.c(3);
                        throw i;
                    }
                    j.a.c(2);
                    throw i;
                }
                j.a.c(1);
                throw i;
            }
            j.a.c(0);
            throw i;
        }

        public void b(b b, List<String> list2) {
            final int i = 0;
            if (b == null) {
            } else {
                if (list2 == null) {
                    j.a.c(6);
                    throw i;
                }
                UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called");
                throw obj2;
            }
            j.a.c(5);
            throw i;
        }
    }
    static {
        j.a aVar = new j.a();
        j.a = aVar;
    }

    public abstract kotlin.i0.z.e.m0.d.a.e0.j.b a(r r, e e2, b0 b03, b0 b04, List<c1> list5, List<z0> list6);

    public abstract void b(b b, List<String> list2);
}
