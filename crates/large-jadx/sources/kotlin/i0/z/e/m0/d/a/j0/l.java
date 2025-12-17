package kotlin.i0.z.e.m0.d.a.j0;

import i.b.m0.e.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.q.d;
import kotlin.i0.z.e.m0.d.a.a;
import kotlin.i0.z.e.m0.d.a.c;
import kotlin.i0.z.e.m0.d.a.c.a;
import kotlin.i0.z.e.m0.d.a.d0;
import kotlin.i0.z.e.m0.d.a.f0.b;
import kotlin.i0.z.e.m0.d.a.f0.f;
import kotlin.i0.z.e.m0.d.a.f0.h;
import kotlin.i0.z.e.m0.d.a.f0.i;
import kotlin.i0.z.e.m0.d.a.f0.j;
import kotlin.i0.z.e.m0.d.a.f0.k;
import kotlin.i0.z.e.m0.d.a.f0.l;
import kotlin.i0.z.e.m0.d.a.g0.a;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.c;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.g0.l.c;
import kotlin.i0.z.e.m0.d.a.g0.l.e;
import kotlin.i0.z.e.m0.d.a.k;
import kotlin.i0.z.e.m0.d.a.s;
import kotlin.i0.z.e.m0.d.a.w;
import kotlin.i0.z.e.m0.d.a.z;
import kotlin.i0.z.e.m0.d.b.s;
import kotlin.i0.z.e.m0.d.b.t;
import kotlin.i0.z.e.m0.d.b.v;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.i.r.a;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.e1;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.i;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.e;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.jvm.internal.impl.utils.h;
import kotlin.u;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class l {

    private final c a;
    private final e b;
    private final kotlin.i0.z.e.m0.d.a.j0.d c;

    private static class a {

        private final b0 a;
        private final boolean b;
        private final boolean c;
        public a(b0 b0, boolean z2, boolean z3) {
            n.f(b0, "type");
            super();
            this.a = b0;
            this.b = z2;
            this.c = z3;
        }

        public final boolean a() {
            return this.c;
        }

        public final b0 b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }
    }

    private final class b {

        private final a a;
        private final b0 b;
        private final Collection<b0> c;
        private final boolean d;
        private final g e;
        private final a f;
        private final boolean g;
        final kotlin.i0.z.e.m0.d.a.j0.l h;
        public b(kotlin.i0.z.e.m0.d.a.j0.l l, a a2, b0 b03, Collection collection4, boolean z5, g g6, a a7, boolean z8) {
            n.f(l, "this$0");
            n.f(b03, "fromOverride");
            n.f(collection4, "fromOverridden");
            n.f(g6, "containerContext");
            n.f(a7, "containerApplicabilityType");
            this.h = l;
            super();
            this.a = a2;
            this.b = b03;
            this.c = collection4;
            this.d = z5;
            this.e = g6;
            this.f = a7;
            this.g = z8;
        }

        public b(kotlin.i0.z.e.m0.d.a.j0.l l, a a2, b0 b03, Collection collection4, boolean z5, g g6, a a7, boolean z8, int i9, g g10) {
            int i;
            int i2;
            obj2.h = l;
            i2 = i9 & 64 != 0 ? i : z8;
            super(l, a2, b03, collection4, z5, g6, a7, i2);
        }

        private final kotlin.i0.z.e.m0.d.a.j0.h a(z0 z0) {
            int empty2;
            List upperBounds2;
            List upperBounds;
            kotlin.i0.z.e.m0.d.a.j0.h nOT_NULL;
            boolean empty;
            int i;
            List obj7;
            if (!z0 instanceof m) {
                return null;
            }
            upperBounds = (m)z0.getUpperBounds();
            final String str = "upperBounds";
            n.e(upperBounds, str);
            i = 0;
            final int i2 = 1;
            if (upperBounds instanceof Collection != null && upperBounds.isEmpty()) {
                if (upperBounds.isEmpty()) {
                    empty2 = i2;
                } else {
                    upperBounds = upperBounds.iterator();
                    for (b0 next3 : upperBounds) {
                    }
                }
            } else {
            }
            if (empty2 != 0) {
            } else {
                upperBounds2 = z0.getUpperBounds();
                n.e(upperBounds2, str);
                if (upperBounds2 instanceof Collection != null && upperBounds2.isEmpty()) {
                    if (upperBounds2.isEmpty()) {
                        empty2 = i2;
                    } else {
                        upperBounds2 = upperBounds2.iterator();
                        for (b0 next2 : upperBounds2) {
                        }
                    }
                } else {
                }
                if (empty2 != 0) {
                } else {
                    obj7 = z0.getUpperBounds();
                    n.e(obj7, str);
                    if (obj7 instanceof Collection != null && obj7.isEmpty()) {
                        if (obj7.isEmpty()) {
                        } else {
                            obj7 = obj7.iterator();
                            while (obj7.hasNext()) {
                                Object next = obj7.next();
                                n.e((b0)next, "it");
                                if (z2 ^= i2) {
                                    break;
                                } else {
                                }
                            }
                        }
                    } else {
                    }
                    nOT_NULL = i != 0 ? h.NOT_NULL : h.NULLABLE;
                }
            }
            return nOT_NULL;
        }

        private final l<Integer, kotlin.i0.z.e.m0.d.a.j0.e> b() {
            int size;
            Collection iterator;
            int i3;
            boolean empty;
            f arrayList;
            b0 b0Var;
            int i4;
            z0 z0Var;
            boolean z;
            int i5;
            int i6;
            int i;
            int i2;
            boolean next;
            final Object obj3 = this;
            Collection collection = obj3.c;
            ArrayList arrayList2 = new ArrayList(p.r(collection, 10));
            Iterator iterator2 = collection.iterator();
            for (b0 next3 : iterator2) {
                arrayList2.add(obj3.o(next3));
            }
            final List list = obj3.o(obj3.b);
            final int i8 = 1;
            if (obj3.d) {
                iterator = obj3.c;
                if (iterator instanceof Collection != null && iterator.isEmpty()) {
                    if (iterator.isEmpty()) {
                        size = 0;
                    } else {
                        iterator = iterator.iterator();
                        for (b0 next2 : iterator) {
                        }
                    }
                } else {
                }
                i6 = size != 0 ? i8 : 0;
            } else {
            }
            if (i6 != 0) {
                i = i8;
            } else {
                i = size;
            }
            final kotlin.i0.z.e.m0.d.a.j0.e[] arr = new e[i];
            i2 = 0;
            while (i2 < i) {
                if (i2 == 0) {
                } else {
                }
                i4 = 0;
                Object obj = list.get(i2);
                arrayList = new ArrayList();
                Iterator iterator3 = arrayList2.iterator();
                while (iterator3.hasNext()) {
                    Object obj5 = p.a0((List)iterator3.next(), i2);
                    if ((o)obj5 == null) {
                    } else {
                    }
                    i5 = (o)obj5.e();
                    if (i5 != 0) {
                    }
                    arrayList.add(i5);
                    i5 = 0;
                }
                arr[i2] = this.d((o)obj.a(), arrayList, obj.b(), i4, obj.c(), obj.d());
                i2++;
                obj5 = p.a0((List)iterator3.next(), i2);
                if ((o)obj5 == null) {
                } else {
                }
                i5 = (o)obj5.e();
                if (i5 != 0) {
                }
                arrayList.add(i5);
                i5 = 0;
                i4 = i8;
            }
            l.b.a aVar = new l.b.a(arr);
            return aVar;
        }

        private final kotlin.i0.z.e.m0.d.a.j0.i c(kotlin.i0.z.e.m0.d.a.j0.i i, s s2, z0 z03) {
            kotlin.i0.z.e.m0.d.a.j0.h hVar;
            kotlin.i0.z.e.m0.d.a.j0.i obj4;
            kotlin.i0.z.e.m0.d.a.j0.i obj5;
            final int i2 = 0;
            if (i == null) {
                if (s2 == null) {
                    obj4 = i2;
                } else {
                }
            }
            if (z03 == null) {
                obj5 = i2;
            } else {
                obj5 = a(z03);
            }
            if (obj5 == null) {
                return obj4;
            }
            final int obj6 = 2;
            int i3 = 0;
            if (obj4 == null) {
                obj4 = new i(obj5, i3, obj6, i2);
                return obj4;
            }
            i iVar = new i(m(obj5, obj4.c()), i3, obj6, i2);
            return iVar;
        }

        private final kotlin.i0.z.e.m0.d.a.j0.e d(b0 b0, Collection<? extends b0> collection2, s s3, boolean z4, z0 z05, boolean z6) {
            ArrayList arrayList;
            kotlin.i0.z.e.m0.d.a.j0.e eVar;
            kotlin.i0.z.e.m0.d.a.j0.f fVar;
            kotlin.i0.z.e.m0.d.a.j0.h hVar;
            boolean next;
            int i;
            boolean z0Var;
            int obj10;
            int obj12;
            int obj13;
            int obj14;
            int obj15;
            arrayList = new ArrayList(p.r(collection2, 10));
            Iterator iterator = collection2.iterator();
            for (b0 next4 : iterator) {
                arrayList.add(h(next4));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                fVar = (e)iterator2.next().b();
                if (fVar != null) {
                }
                arrayList2.add(fVar);
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator iterator3 = arrayList.iterator();
            while (iterator3.hasNext()) {
                hVar = (e)iterator3.next().c();
                if (hVar != null) {
                }
                arrayList3.add(hVar);
            }
            java.util.Set set2 = p.P0(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            Iterator obj11 = collection2.iterator();
            while (obj11.hasNext()) {
                next = h(e1.c((b0)obj11.next())).c();
                if (next) {
                }
                arrayList4.add(next);
            }
            obj11 = p.P0(arrayList4);
            obj10 = this.i(b0, z4, s3, z05, z6);
            obj14 = 1;
            obj15 = 0;
            obj12 = obj12 ^= obj14 != 0 ? obj10 : obj15;
            if (obj12 == null) {
                obj12 = obj15;
            } else {
                obj12 = obj12.c();
            }
            kotlin.i0.z.e.m0.d.a.j0.h hVar2 = obj10.c();
            int i4 = 0;
            if (this.d && z4 != 0) {
                i = z4 != 0 ? obj14 : i4;
            } else {
            }
            kotlin.i0.z.e.m0.d.a.j0.h hVar3 = r.d(set2, obj12, i);
            if (hVar3 == null) {
            } else {
                if (l() && z4 != 0 && hVar3 == h.NULLABLE) {
                    if (z4 != 0) {
                        obj13 = hVar3 == h.NULLABLE ? obj14 : i4;
                    } else {
                    }
                } else {
                }
                if (obj13 == null) {
                    obj15 = hVar3;
                }
            }
            obj13 = r.c(p.P0(arrayList2), f.MUTABLE, f.READ_ONLY, obj10.b(), i);
            if (hVar2 == obj12) {
                if (!n.b(obj11, set2)) {
                    obj12 = obj14;
                } else {
                    obj12 = i4;
                }
            } else {
            }
            if (!obj10.d()) {
                if (arrayList.isEmpty()) {
                    obj10 = i4;
                } else {
                    obj10 = arrayList.iterator();
                    for (e next2 : obj10) {
                    }
                }
                if (obj10 != null) {
                    obj10 = obj14;
                } else {
                    obj10 = i4;
                }
            } else {
            }
            if (obj15 == null && obj12 != null) {
                if (obj12 != null) {
                    return r.a(r.d(obj11, hVar2, i), (f)obj13, obj14, obj10);
                }
            }
            if (obj15 == null) {
            } else {
                obj14 = i4;
            }
            return r.a(obj15, obj13, obj14, obj10);
        }

        public static kotlin.i0.z.e.m0.d.a.j0.l.a f(kotlin.i0.z.e.m0.d.a.j0.l.b l$b, kotlin.i0.z.e.m0.d.a.j0.s s2, int i3, Object object4) {
            int obj1;
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            return b.e(obj1);
        }

        private final kotlin.i0.z.e.m0.d.a.j0.i g(g g, boolean z2, boolean z3) {
            kotlin.i0.z.e.m0.d.a.j0.i iVar;
            final Iterator obj3 = g.iterator();
            for (c next2 : obj3) {
            }
            iVar = 0;
            return iVar;
        }

        private final kotlin.i0.z.e.m0.d.a.j0.e h(b0 b0) {
            kotlin.i0.z.e.m0.l.i0 z;
            kotlin.i0.z.e.m0.d.a.j0.f rEAD_ONLY;
            o oVar;
            kotlin.i0.z.e.m0.l.i0 i0Var;
            boolean nOT_NULL;
            int i;
            if (y.b(b0)) {
                v vVar = y.a(b0);
                oVar = new o(vVar.T0(), vVar.U0());
            } else {
                oVar = new o(b0, b0);
            }
            Object obj = oVar.a();
            Object obj2 = oVar.b();
            d dVar = d.a;
            int i2 = 0;
            if ((b0)obj.M0()) {
                nOT_NULL = h.NULLABLE;
                i = nOT_NULL;
            } else {
            }
            rEAD_ONLY = dVar.f(obj) ? f.READ_ONLY : z3 ? f.MUTABLE : i2;
            super(i, rEAD_ONLY, obj12 instanceof g, 0, 8, 0);
            return eVar2;
        }

        private final kotlin.i0.z.e.m0.d.a.j0.e i(b0 b0, boolean z2, s s3, z0 z04, boolean z5) {
            kotlin.i0.z.e.m0.d.a.j0.i iVar;
            int i2;
            g annotations;
            a aVar;
            g annotations2;
            int valueOf;
            ArrayList arrayList;
            boolean next;
            int i;
            c.a contains;
            c tYPE_USE;
            boolean obj10;
            w obj11;
            s obj12;
            kotlin.i0.z.e.m0.d.a.j0.i obj13;
            kotlin.i0.z.e.m0.d.a.j0.h obj14;
            boolean z = this.e.a().p().b();
            i2 = 1;
            final int i3 = 0;
            aVar = this.a;
            if (z2 != null && aVar != null && !aVar instanceof z0 && z) {
                aVar = this.a;
                if (aVar != null) {
                    if (!aVar instanceof z0) {
                        if (z) {
                            arrayList = new ArrayList();
                            Iterator iterator = aVar.getAnnotations().iterator();
                            while (iterator.hasNext()) {
                                next = iterator.next();
                                contains = l.a(this.h).h((c)next);
                                if (contains == null) {
                                } else {
                                }
                                if (contains.b().contains(a.TYPE_USE) == null) {
                                } else {
                                }
                                i = i3;
                                if (i != 0) {
                                }
                                arrayList.add(next);
                                i = i2;
                            }
                            annotations = i.a(g.q.a(arrayList), b0.getAnnotations());
                        } else {
                            aVar = this.a;
                            if (z2 != null && aVar != null) {
                                aVar = this.a;
                                if (aVar != null) {
                                    annotations = i.a(aVar.getAnnotations(), b0.getAnnotations());
                                } else {
                                    annotations = b0.getAnnotations();
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            valueOf = 0;
            if (z2 != null) {
                obj11 = this.e.b();
                if (obj11 == null) {
                    obj12 = valueOf;
                } else {
                    obj12 = obj11.a(this.f);
                }
            }
            if (obj12 == null) {
                obj12 = valueOf;
            } else {
            }
            obj11 = n(b0);
            if (g(annotations, z, this.g) == null) {
                iVar = valueOf;
            } else {
            }
            if (iVar == null) {
                obj13 = c((i)obj11.a(), obj12, z04);
            } else {
                obj13 = iVar;
            }
            if (iVar != null && iVar.c() == h.NOT_NULL) {
                if (iVar.c() == h.NOT_NULL) {
                    obj11 = i2;
                } else {
                    obj11 = i3;
                }
            } else {
            }
            if (obj13 == null) {
                obj14 = valueOf;
            } else {
                obj14 = obj13.c();
            }
            if (obj11 != null && a.i(b0)) {
                if (a.i(b0)) {
                } else {
                    i2 = i3;
                }
            } else {
            }
            if (obj13 == null) {
            } else {
                valueOf = Boolean.valueOf(obj13.d());
            }
            obj12 = new e(obj14, (f)l.b.k(l.b.j(z.m(), annotations, f.READ_ONLY), l.b.j(z.j(), annotations, f.MUTABLE)), i2, n.b(valueOf, Boolean.TRUE));
            return obj12;
        }

        private static final <T> T j(List<b> list, g g2, T t3) {
            boolean empty;
            int i;
            Object obj3;
            int obj5;
            final int i2 = 0;
            if (list instanceof Collection != null && list.isEmpty()) {
                if (list.isEmpty()) {
                    i = i2;
                } else {
                    obj3 = list.iterator();
                    while (obj3.hasNext()) {
                        if (g2.o((b)obj3.next()) != null) {
                        } else {
                        }
                        empty = i2;
                        if (!empty) {
                            break;
                        }
                        empty = i;
                    }
                }
            } else {
            }
            if (i != 0) {
            } else {
                obj5 = 0;
            }
            return obj5;
        }

        private static final <T> T k(T t, T t2) {
            boolean z;
            Object obj1;
            if (t != null && t2 != null) {
                if (t2 != null) {
                    if (n.b(t, t2)) {
                        if (t == null) {
                            obj1 = t2;
                        }
                    } else {
                        obj1 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj1;
        }

        private final boolean l() {
            a aVar;
            int i;
            int i2;
            if (!aVar instanceof c1) {
                aVar = i2;
            }
            if ((c1)aVar == null) {
            } else {
                i2 = (c1)aVar.l0();
            }
            i = i2 != 0 ? 1 : 0;
            return i;
        }

        private final kotlin.i0.z.e.m0.d.a.j0.h m(kotlin.i0.z.e.m0.d.a.j0.h h, kotlin.i0.z.e.m0.d.a.j0.h h2) {
            kotlin.i0.z.e.m0.d.a.j0.h obj3;
            kotlin.i0.z.e.m0.d.a.j0.h fORCE_FLEXIBILITY = h.FORCE_FLEXIBILITY;
            if (h == fORCE_FLEXIBILITY) {
                return h2;
            }
            if (h2 == fORCE_FLEXIBILITY) {
                return h;
            }
            kotlin.i0.z.e.m0.d.a.j0.h nULLABLE = h.NULLABLE;
            if (h == nULLABLE) {
                return h2;
            }
            if (h2 == nULLABLE) {
                return h;
            }
            if (h == h2) {
                obj3 = h.NOT_NULL;
            }
            return h.NOT_NULL;
        }

        private final o<kotlin.i0.z.e.m0.d.a.j0.i, Boolean> n(b0 b0) {
            int i;
            int obj7;
            final int i2 = 0;
            if (obj7 instanceof z0) {
            } else {
                obj7 = i2;
            }
            if (obj7 == null) {
                obj7 = i2;
            } else {
                obj7 = a(obj7);
            }
            if (obj7 == null) {
                obj7 = new o(i2, Boolean.FALSE);
                return obj7;
            }
            final kotlin.i0.z.e.m0.d.a.j0.h nOT_NULL = h.NOT_NULL;
            i iVar = new i(nOT_NULL, 0, 2, i2);
            if (obj7 == nOT_NULL) {
                i = 1;
            }
            o oVar = new o(iVar, Boolean.valueOf(i));
            return oVar;
        }

        private final List<kotlin.i0.z.e.m0.d.a.j0.o> o(b0 b0) {
            ArrayList arrayList = new ArrayList(1);
            l.b.p(this, arrayList, b0, this.e, 0);
            return arrayList;
        }

        private static final void p(kotlin.i0.z.e.m0.d.a.j0.l.b l$b, ArrayList<kotlin.i0.z.e.m0.d.a.j0.o> arrayList2, b0 b03, g g4, z0 z05) {
            s sVar;
            a tYPE_PARAMETER_BOUNDS;
            String type;
            int oVar;
            String str;
            List obj8;
            final g obj7 = a.h(g4, b03.getAnnotations());
            w wVar = obj7.b();
            if (wVar == null) {
                sVar = 0;
            } else {
                tYPE_PARAMETER_BOUNDS = b.g ? a.TYPE_PARAMETER_BOUNDS : a.TYPE_USE;
                sVar = wVar.a(tYPE_PARAMETER_BOUNDS);
            }
            o oVar2 = new o(b03, sVar, z05, 0);
            arrayList2.add(oVar2);
            List obj6 = b03.L0().getParameters();
            n.e(obj6, "type.constructor.parameters");
            obj6 = p.S0(b03.K0(), obj6).iterator();
            while (obj6.hasNext()) {
                obj8 = obj6.next();
                Object obj = (o)obj8.a();
                obj8 = obj8.b();
                str = "arg.type";
                if ((v0)obj.c() != 0) {
                } else {
                }
                type = obj.getType();
                n.e(type, str);
                l.b.p(b, arrayList2, type, obj7, (z0)obj8);
                type = obj.getType();
                n.e(type, str);
                oVar = new o(type, sVar, obj8, 1);
                arrayList2.add(oVar);
            }
        }

        public final kotlin.i0.z.e.m0.d.a.j0.l.a e(kotlin.i0.z.e.m0.d.a.j0.s s) {
            l lVar;
            b0 b0Var;
            int aVar;
            kotlin.i0.z.e.m0.d.a.j0.l.b.c cVar;
            if (s == null) {
                cVar = aVar;
            } else {
                cVar = new l.b.c(s, b());
            }
            boolean obj6 = c1.c(this.b, l.b.b.a);
            if (cVar == null) {
            } else {
                lVar = cVar;
            }
            b0Var = l.b(this.h).b(this.b, lVar);
            if (b0Var == null) {
            } else {
                aVar = new l.a(b0Var, 1, obj6);
            }
            if (aVar == 0) {
                aVar = new l.a(this.b, 0, obj6);
            }
            return aVar;
        }
    }

    private static final class c extends kotlin.i0.z.e.m0.d.a.j0.l.a {

        private final boolean d;
        public c(b0 b0, boolean z2, boolean z3, boolean z4) {
            n.f(b0, "type");
            super(b0, z3, z4);
            this.d = z2;
        }

        @Override // kotlin.i0.z.e.m0.d.a.j0.l$a
        public final boolean d() {
            return this.d;
        }
    }

    static final class d extends p implements l<b, b0> {

        public static final kotlin.i0.z.e.m0.d.a.j0.l.d a;
        static {
            l.d dVar = new l.d();
            l.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(b b) {
            n.f(b, "it");
            kotlin.reflect.jvm.internal.impl.descriptors.r0 obj2 = b.m0();
            n.d(obj2);
            obj2 = obj2.getType();
            n.e(obj2, "it.extensionReceiverParameter!!.type");
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    static final class e extends p implements l<b, b0> {

        public static final kotlin.i0.z.e.m0.d.a.j0.l.e a;
        static {
            l.e eVar = new l.e();
            l.e.a = eVar;
        }

        e() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(b b) {
            n.f(b, "it");
            final b0 obj2 = b.getReturnType();
            n.d(obj2);
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    static final class f extends p implements l<b, b0> {

        final c1 $p;
        f(c1 c1) {
            this.$p = c1;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(b b) {
            n.f(b, "it");
            b0 obj2 = (c1)b.h().get(this.$p.getIndex()).getType();
            n.e(obj2, "it.valueParameters[p.index].type");
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    static final class g extends p implements l<g1, Boolean> {

        public static final kotlin.i0.z.e.m0.d.a.j0.l.g a;
        static {
            l.g gVar = new l.g();
            l.g.a = gVar;
        }

        g() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(g1 g1) {
            n.f(g1, "it");
            return g1 instanceof h0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((g1)object));
        }
    }
    public l(c c, e e2, kotlin.i0.z.e.m0.d.a.j0.d d3) {
        n.f(c, "annotationTypeQualifierResolver");
        n.f(e2, "javaTypeEnhancementState");
        n.f(d3, "typeEnhancement");
        super();
        this.a = c;
        this.b = e2;
        this.c = d3;
    }

    public static final c a(kotlin.i0.z.e.m0.d.a.j0.l l) {
        return l.a;
    }

    public static final kotlin.i0.z.e.m0.d.a.j0.d b(kotlin.i0.z.e.m0.d.a.j0.l l) {
        return l.c;
    }

    private final kotlin.i0.z.e.m0.d.a.j0.i c(b b, c c2, boolean z3) {
        boolean contains;
        kotlin.i0.z.e.m0.d.a.j0.i obj2;
        Object obj3;
        boolean obj4;
        if (z.l().contains(b)) {
            obj2 = new i(h.NULLABLE, z3);
        } else {
            if (z.k().contains(b)) {
                obj2 = new i(h.NOT_NULL, z3);
            } else {
                if (n.b(b, z.f())) {
                    obj2 = j(c2, z3);
                } else {
                    if (n.b(b, z.d()) && this.b.c()) {
                        if (this.b.c()) {
                            obj2 = new i(h.NULLABLE, z3);
                        } else {
                            if (n.b(b, z.c()) && this.b.c()) {
                                if (this.b.c()) {
                                    obj2 = new i(h.NOT_NULL, z3);
                                } else {
                                    obj4 = 1;
                                    if (n.b(b, z.a())) {
                                        obj2 = new i(h.NOT_NULL, obj4);
                                    } else {
                                        if (n.b(b, z.b())) {
                                            obj2 = new i(h.NULLABLE, obj4);
                                        } else {
                                            obj2 = 0;
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
        }
        return obj2;
    }

    private final <D extends b> D d(D d, g g2) {
        b.a size2;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 obj5;
        Object r0Var;
        int size;
        Object obj4;
        Boolean valueOf3;
        a mETHOD_RETURN_TYPE;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 c0Var;
        Object obj;
        Boolean valueOf4;
        boolean size3;
        int i4;
        kotlin.i0.z.e.m0.d.a.j0.s sVar;
        Boolean valueOf2;
        int i5;
        int i8;
        boolean z;
        boolean iterator;
        Object next;
        Object next2;
        Boolean valueOf;
        boolean kVar;
        int i6;
        Boolean fALSE;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
        Boolean tRUE;
        int i2;
        a aVar;
        Object obj2;
        b0 type;
        int index;
        kotlin.i0.z.e.m0.d.a.j0.l.e lVar;
        Object obj3;
        int i;
        int tRUE2;
        int i3;
        int i7;
        final Object obj7 = this;
        obj3 = d;
        if (!obj3 instanceof b) {
            return obj3;
        }
        final Object obj8 = obj3;
        i = 1;
        if ((b)obj8.f() == b.a.FAKE_OVERRIDE && obj8.a().e().size() == i) {
            if (obj8.a().e().size() == i) {
                return obj3;
            }
        }
        g gVar = a.h(g2, d.getAnnotations());
        int i11 = 0;
        if (obj3 instanceof g) {
            obj5 = obj3;
            kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 c0Var2 = (g)obj5.P0();
            if (c0Var2 == null) {
                valueOf4 = i11;
            } else {
                valueOf4 = Boolean.valueOf(c0Var2.U());
            }
            if (n.b(valueOf4, Boolean.FALSE)) {
                obj5 = obj5.P0();
                n.d(obj5);
                next2 = obj5;
            } else {
                next2 = obj3;
            }
        } else {
        }
        if (obj8.m0() != null) {
            c0Var = !next2 instanceof x ? i11 : next2;
            if ((x)c0Var == null) {
                obj = i11;
            } else {
                obj = (x)c0Var.i0(f.X);
            }
            i3 = r0Var;
        } else {
            i3 = i11;
        }
        if (obj3 instanceof f) {
            size = obj3;
        } else {
            size = i11;
        }
        final int i13 = 0;
        if (size == 0) {
            i7 = i11;
        } else {
        }
        if (i7 == 0) {
        } else {
            size = i7.a().size();
            size3 = obj8.h().size();
        }
        List list2 = next2.h();
        n.e(list2, "annotationOwnerForMember.valueParameters");
        ArrayList arrayList2 = new ArrayList(p.r(list2, 10));
        Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            l.f fVar = new l.f((c1)next);
            if (i7 == 0) {
            } else {
            }
            i2 = i7.a();
            if (i2 == 0) {
            } else {
            }
            obj2 = p.a0(i2, next.getIndex());
            kotlin.i0.z.e.m0.d.a.j0.l.a aVar4 = obj7.n(obj3, next, gVar, fVar).e(obj2);
            if (aVar4.c()) {
            } else {
            }
            n.e(next.getType(), "p.type");
            n.e(next, "p");
            i2 = obj7.k(next, type);
            if (!aVar4.c()) {
            } else {
            }
            i4 = i;
            l.c cVar = new l.c(aVar4.b(), i2, i4, aVar4.a());
            arrayList2.add(cVar);
            index = 10;
            i = 1;
            if (i2 != next.t0()) {
            } else {
            }
            i4 = i13;
            type = aVar4.b();
            obj2 = i11;
        }
        obj4 = !obj3 instanceof o0 ? i11 : obj3;
        if ((o0)obj4 == null) {
            valueOf3 = i11;
        } else {
            valueOf3 = Boolean.valueOf(c.a((o0)obj4));
        }
        tRUE2 = Boolean.TRUE;
        mETHOD_RETURN_TYPE = n.b(valueOf3, tRUE2) ? a.FIELD : a.METHOD_RETURN_TYPE;
        if (i7 == 0) {
            sVar = 0;
        } else {
            sVar = i7.b();
        }
        kotlin.i0.z.e.m0.d.a.j0.l.a aVar2 = this.m(d, next2, true, gVar, mETHOD_RETURN_TYPE, l.e.a).e(sVar);
        if (i3 == 0) {
            valueOf2 = 0;
        } else {
            valueOf2 = Boolean.valueOf(i3.a());
        }
        if (!n.b(valueOf2, tRUE2) && !aVar2.a()) {
            if (!aVar2.a()) {
                if (arrayList2.isEmpty()) {
                    z = i13;
                } else {
                    iterator = arrayList2.iterator();
                    for (l.c next4 : iterator) {
                    }
                }
                if (z != 0) {
                    i5 = 1;
                } else {
                    i5 = i13;
                }
            } else {
            }
        } else {
        }
        if (i3 == 0) {
            valueOf = 0;
        } else {
            valueOf = Boolean.valueOf(i3.c());
        }
        if (!n.b(valueOf, Boolean.TRUE) && !aVar2.c()) {
            if (!aVar2.c()) {
                if (arrayList2.isEmpty()) {
                    tRUE2 = i13;
                } else {
                    kVar = arrayList2.iterator();
                    for (l.c next5 : kVar) {
                    }
                }
                if (tRUE2 == 0 && i5 != 0) {
                    if (i5 != 0) {
                    }
                    return obj3;
                }
            }
        }
        if (i5 != 0) {
            kVar = new k(obj3);
            i8 = u.a(a.a(), kVar);
        } else {
            i8 = 0;
        }
        if (i3 == 0) {
            i6 = 0;
        } else {
            i6 = i3.b();
        }
        ArrayList arrayList = new ArrayList(p.r(arrayList2, 10));
        Iterator iterator3 = arrayList2.iterator();
        for (l.c next7 : iterator3) {
            lVar = new l(next7.b(), next7.d());
            arrayList.add(lVar);
        }
        return obj8.v(i6, arrayList, aVar2.b(), i8);
    }

    private final kotlin.i0.z.e.m0.d.a.j0.i i(c c, boolean z2, boolean z3) {
        boolean z;
        Object obj5;
        int obj6;
        kotlin.i0.z.e.m0.d.a.j0.i obj7;
        final b bVar = c.d();
        final int i = 0;
        if (bVar == null) {
            return i;
        }
        final int i2 = 1;
        if (c instanceof e) {
            if (!(e)c.k()) {
                if (z3 && !z2) {
                    obj6 = !z2 ? i2 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        if (l(bVar) == null && c(bVar, c, obj6) == null) {
            if (c(bVar, c, obj6) == null) {
                return i;
            }
        }
        if (!obj7.d() && c instanceof i && (i)c.f()) {
            if (c instanceof i) {
                if ((i)c.f()) {
                    obj7 = i.b(obj7, i, i2, i2, i);
                }
            }
        }
        return obj7;
    }

    private final kotlin.i0.z.e.m0.d.a.j0.i j(c c, boolean z2) {
        String str;
        int iVar;
        kotlin.i0.z.e.m0.i.q.g obj3;
        if (obj3 instanceof j) {
        } else {
            obj3 = iVar;
        }
        if (obj3 == null) {
            obj3 = new i(h.NOT_NULL, z2);
            return obj3;
        }
        switch (obj3) {
            case "MAYBE":
                iVar = new i(h.NULLABLE, z2);
                break;
            case "NEVER":
                iVar = new i(h.NULLABLE, z2);
                break;
            case "UNKNOWN":
                iVar = new i(h.FORCE_FLEXIBILITY, z2);
                break;
            case "ALWAYS":
                iVar = new i(h.NOT_NULL, z2);
                break;
            default:
        }
        return iVar;
    }

    private final boolean k(c1 c1, b0 b02) {
        Object aVar;
        boolean z;
        int i;
        c1 obj5;
        int obj6;
        aVar = k.b(c1);
        final int i2 = 0;
        if (aVar instanceof j) {
            obj6 = d0.a(b02, (j)aVar.a()) != null ? i : i2;
            if (obj6 != null && c1.e().isEmpty()) {
                if (c1.e().isEmpty()) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        } else {
            if (n.b(aVar, h.a)) {
                obj6 = c1.b(b02);
            } else {
                if (aVar != null) {
                } else {
                    obj6 = c1.t0();
                }
            }
        }
        obj5 = new NoWhenBranchMatchedException();
        throw obj5;
    }

    private final kotlin.i0.z.e.m0.d.a.j0.i l(b b) {
        int i;
        b z;
        int iVar;
        boolean obj4;
        if (this.b.e() == h.IGNORE) {
            return null;
        }
        i = this.b.e() == h.WARN ? 1 : 0;
        if (n.b(b, z.h())) {
            iVar = new i(h.NULLABLE, i);
        } else {
            if (n.b(b, z.i())) {
                iVar = new i(h.FORCE_FLEXIBILITY, i);
            }
        }
        return iVar;
    }

    private final kotlin.i0.z.e.m0.d.a.j0.l.b m(b b, a a2, boolean z3, g g4, a a5, l<? super b, ? extends b0> l6) {
        int invoke;
        String str;
        Object obj = b;
        Object obj2 = l6;
        Collection collection = b.e();
        n.e(collection, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(p.r(collection, 10));
        Iterator iterator = collection.iterator();
        for (b next2 : iterator) {
            n.e(next2, "it");
            arrayList.add((b0)obj2.invoke(next2));
        }
        super(this, a2, (b0)obj2.invoke(b), arrayList, z3, a.h(g4, (b0)obj2.invoke(b).getAnnotations()), a5, 0, 64, 0);
        return bVar;
    }

    private final kotlin.i0.z.e.m0.d.a.j0.l.b n(b b, c1 c12, g g3, l<? super b, ? extends b0> l4) {
        g gVar2;
        g gVar;
        if (c12 == null) {
            gVar = g3;
        } else {
            gVar2 = a.h(g3, c12.getAnnotations());
            if (gVar2 == null) {
            } else {
                gVar = gVar2;
            }
        }
        return this.m(b, c12, false, gVar, a.VALUE_PARAMETER, l4);
    }

    public final <D extends b> Collection<D> e(g g, Collection<? extends D> collection2) {
        int i;
        n.f(g, "c");
        n.f(collection2, "platformSignatures");
        ArrayList arrayList = new ArrayList(p.r(collection2, 10));
        final Iterator obj4 = collection2.iterator();
        for (b next2 : obj4) {
            arrayList.add(d(next2, g));
        }
        return arrayList;
    }

    public final b0 f(b0 b0, g g2) {
        n.f(b0, "type");
        n.f(g2, "context");
        super(this, 0, b0, p.g(), 0, g2, a.TYPE_USE, 0, 64, 0);
        int obj13 = 0;
        return l.b.f(bVar, obj13, 1, obj13).b();
    }

    public final List<b0> g(z0 z0, List<? extends b0> list2, g g3) {
        int i;
        int i2;
        int i3;
        Object obj3;
        Object obj;
        List list;
        int i4;
        Object obj2;
        a tYPE_PARAMETER_BOUNDS;
        int i5;
        n.f(z0, "typeParameter");
        n.f(list2, "bounds");
        n.f(g3, "context");
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj13 = list2.iterator();
        while (obj13.hasNext()) {
            obj = next2;
            if (a.b((b0)obj, l.g.a)) {
            } else {
            }
            super(this, z0, obj, p.g(), 0, g3, a.TYPE_PARAMETER_BOUNDS, 1);
            i3 = 0;
            obj = l.b.f(bVar, i3, 1, i3).b();
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final kotlin.i0.z.e.m0.d.a.j0.i h(c c, boolean z2, boolean z3) {
        kotlin.i0.z.e.m0.d.a.j0.i i;
        boolean obj4;
        int obj6;
        n.f(c, "annotationDescriptor");
        kotlin.i0.z.e.m0.d.a.j0.i iVar = i(c, z2, z3);
        c cVar2 = this.a.m(c);
        i = 0;
        if (iVar == null && cVar2 == null) {
            cVar2 = this.a.m(c);
            i = 0;
            if (cVar2 == null) {
                return i;
            }
            obj4 = this.a.j(c);
            if (obj4.isIgnore()) {
                return i;
            }
            final kotlin.i0.z.e.m0.d.a.j0.i obj5 = i(cVar2, z2, z3);
            if (obj5 == null) {
            } else {
                i = i.b(obj5, i, obj4.isWarning(), 1, i);
            }
            return i;
        }
        return iVar;
    }
}
