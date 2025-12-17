package net.time4j.calendar;

import android.app.ActivityManager.MemoryInfo;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.calendar.t.f;
import net.time4j.calendar.t.g;
import net.time4j.engine.d;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.i0;
import net.time4j.engine.k;
import net.time4j.engine.l0;
import net.time4j.engine.m;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.s;
import net.time4j.engine.v;
import net.time4j.engine.y;
import net.time4j.g0;
import net.time4j.g1.c;
import net.time4j.g1.h;
import net.time4j.g1.t;
import net.time4j.tz.f;
import net.time4j.tz.p;
import net.time4j.x0;
import net.time4j.z0;

/* loaded from: classes3.dex */
@c("dangi")
public final class KoreanCalendar extends net.time4j.calendar.f<net.time4j.calendar.KoreanCalendar.e, net.time4j.calendar.KoreanCalendar> implements h {

    public static final p<Integer> A = null;
    public static final p<Integer> B = null;
    public static final t<net.time4j.calendar.c> C = null;
    public static final p<net.time4j.calendar.o> D = null;
    public static final t<net.time4j.calendar.h> E = null;
    public static final net.time4j.calendar.p<Integer, net.time4j.calendar.KoreanCalendar> F = null;
    public static final net.time4j.calendar.p<Integer, net.time4j.calendar.KoreanCalendar> G = null;
    public static final net.time4j.calendar.p<Integer, net.time4j.calendar.KoreanCalendar> H = null;
    public static final net.time4j.calendar.p<x0, net.time4j.calendar.KoreanCalendar> I = null;
    private static final net.time4j.calendar.q<net.time4j.calendar.KoreanCalendar> J = null;
    private static final net.time4j.calendar.d<net.time4j.calendar.KoreanCalendar> K = null;
    private static final f0<net.time4j.calendar.KoreanCalendar.e, net.time4j.calendar.KoreanCalendar> L = null;
    private static final long serialVersionUID = -4284841131270593971L;
    private static final int[] y;
    public static final p<net.time4j.calendar.k> z;

    private static class SPX implements Externalizable {

        private static final long serialVersionUID = 1L;
        private transient Object a;
        SPX(Object object) {
            super();
            this.a = object;
        }

        private net.time4j.calendar.KoreanCalendar a(ObjectInput objectInput) {
            net.time4j.calendar.h hVar;
            if (objectInput.readBoolean()) {
                hVar = h.f(objectInput.readByte()).i();
            }
            return KoreanCalendar.r0(objectInput.readByte(), objectInput.readByte(), hVar, objectInput.readByte());
        }

        private void b(ObjectOutput objectOutput) {
            Object obj = this.a;
            objectOutput.writeByte((f)obj.Y());
            objectOutput.writeByte(obj.i0().getNumber());
            objectOutput.writeByte(obj.e0().getNumber());
            objectOutput.writeBoolean(obj.e0().e());
            objectOutput.writeByte(obj.q());
        }

        private Object readResolve() {
            return this.a;
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) {
            if (objectInput.readByte() != 15) {
            } else {
                this.a = a(objectInput);
            }
            InvalidObjectException obj3 = new InvalidObjectException("Unknown calendar type.");
            throw obj3;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) {
            objectOutput.writeByte(15);
            b(objectOutput);
        }
    }

    static class a implements s<net.time4j.calendar.KoreanCalendar, k<net.time4j.calendar.KoreanCalendar>> {
        public k<net.time4j.calendar.KoreanCalendar> a(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return KoreanCalendar.n0();
        }

        @Override // net.time4j.engine.s
        public Object apply(Object object) {
            return a((KoreanCalendar)object);
        }
    }

    private static class b implements y<net.time4j.calendar.KoreanCalendar, net.time4j.calendar.k> {
        b(net.time4j.calendar.KoreanCalendar.a koreanCalendar$a) {
            super();
        }

        public p<?> b(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        public p<?> d(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public net.time4j.calendar.k e(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return k.DANGI;
        }

        @Override // net.time4j.engine.y
        public net.time4j.calendar.k f(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return k.DANGI;
        }

        @Override // net.time4j.engine.y
        public net.time4j.calendar.k g(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return k.DANGI;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            b((KoreanCalendar)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            d((KoreanCalendar)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((KoreanCalendar)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((KoreanCalendar)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((KoreanCalendar)object);
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.calendar.KoreanCalendar koreanCalendar, net.time4j.calendar.k k2) {
            int obj1;
            obj1 = k2 == k.DANGI ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.y
        public net.time4j.calendar.KoreanCalendar i(net.time4j.calendar.KoreanCalendar koreanCalendar, net.time4j.calendar.k k2, boolean z3) {
            if (!h(koreanCalendar, k2)) {
            } else {
                return koreanCalendar;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Invalid Korean era: ");
            obj4.append(k2);
            IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((KoreanCalendar)object, (k)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            i((KoreanCalendar)object, (k)object2, z3);
            return object;
        }
    }

    public static enum e implements v {

        CYCLES(4745728368231688700, true),
        YEARS(4719236207816660851, 2),
        MONTHS(4702733593205858777, 3),
        WEEKS(4693442404533927936, 4),
        DAYS(4680673776000565248, /* unknown */);

        private final transient double length;
        @Override // java.lang.Enum
        public int between(net.time4j.calendar.KoreanCalendar koreanCalendar, net.time4j.calendar.KoreanCalendar koreanCalendar2) {
            return (int)obj1;
        }

        @Override // java.lang.Enum
        public double getLength() {
            return this.length;
        }

        @Override // java.lang.Enum
        public boolean isCalendrical() {
            return 1;
        }
    }

    private static class f implements y<net.time4j.calendar.KoreanCalendar, Integer> {
        f(net.time4j.calendar.KoreanCalendar.a koreanCalendar$a) {
            super();
        }

        private int e(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return i3 += -364;
        }

        public p<?> b(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        public p<?> d(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public Integer f(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return 5332;
        }

        @Override // net.time4j.engine.y
        public Integer g(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return 3978;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            b((KoreanCalendar)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            d((KoreanCalendar)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((KoreanCalendar)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((KoreanCalendar)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((KoreanCalendar)object);
        }

        @Override // net.time4j.engine.y
        public Integer h(net.time4j.calendar.KoreanCalendar koreanCalendar) {
            return Integer.valueOf(e(koreanCalendar));
        }

        @Override // net.time4j.engine.y
        public boolean i(net.time4j.calendar.KoreanCalendar koreanCalendar, Integer integer2) {
            int i;
            int obj5;
            if (integer2 == 0) {
                return 0;
            }
            if (integer2.intValue() >= g(koreanCalendar).intValue() && integer2.intValue() <= f(koreanCalendar).intValue()) {
                if (integer2.intValue() <= f(koreanCalendar).intValue()) {
                    i = 1;
                }
            }
            return i;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((KoreanCalendar)object, (Integer)object2);
        }

        @Override // net.time4j.engine.y
        public net.time4j.calendar.KoreanCalendar j(net.time4j.calendar.KoreanCalendar koreanCalendar, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                if (!i(koreanCalendar, integer2)) {
                } else {
                    int obj4 = e(koreanCalendar);
                    return (KoreanCalendar)koreanCalendar.M((long)obj3, obj4);
                }
                obj4 = new StringBuilder();
                obj4.append("Invalid year of era: ");
                obj4.append(integer2);
                IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
                throw obj2;
            }
            obj2 = new IllegalArgumentException("Missing year of era.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return j((KoreanCalendar)object, (Integer)object2, z3);
        }
    }

    private static class c extends net.time4j.calendar.a<net.time4j.calendar.KoreanCalendar> {
        c() {
            super(KoreanCalendar.class);
        }

        @Override // net.time4j.calendar.a
        public Object c(q q, d d2, boolean z3, boolean z4) {
            return h(q, d2, z3, z4);
        }

        public net.time4j.calendar.KoreanCalendar h(q<?> q, d d2, boolean z3, boolean z4) {
            boolean z;
            Object obj;
            boolean z2;
            net.time4j.calendar.p z5;
            int obj3;
            int obj4;
            int obj6;
            obj4 = q.e(b.a);
            int obj5 = 0;
            obj6 = Integer.MIN_VALUE;
            if (obj4 == obj6) {
                obj4 = KoreanCalendar.C;
                z = KoreanCalendar.A;
                if (q.v(obj4) && q.v(z)) {
                    z = KoreanCalendar.A;
                    if (q.v(z)) {
                        obj4 = (c)q.p(obj4).r(q.e(z));
                    } else {
                        obj4 = q.e(k.DANGI.yearOfEra());
                        if (obj4 != obj6) {
                            obj4 = j.a(obj4);
                        } else {
                            obj4 = obj5;
                        }
                    }
                } else {
                }
            } else {
                obj4 = j.b(obj4);
            }
            if (obj4 == null) {
                q.G(l0.ERROR_MESSAGE, "Cannot determine East Asian year.");
                return obj5;
            }
            t tVar = KoreanCalendar.E;
            if (q.v(tVar)) {
                obj3 = q.e(KoreanCalendar.G);
                if (obj3 != obj6) {
                    return KoreanCalendar.s0(obj4, (h)q.p(tVar), obj3);
                }
            } else {
                obj3 = q.e(KoreanCalendar.H);
                obj6 = 1;
                if (obj3 != obj6 && obj3 >= obj6) {
                    obj6 = 1;
                    if (obj3 >= obj6) {
                        return (KoreanCalendar)KoreanCalendar.s0(obj4, h.f(obj6), obj6).M((long)obj3, obj6);
                    }
                }
            }
            return obj5;
        }
    }

    private static class d extends net.time4j.calendar.d<net.time4j.calendar.KoreanCalendar> {

        private static final List<p> d;
        private static final long e;
        private static final long f;
        private static final long g;
        private static final long h;
        static {
            ArrayList arrayList = new ArrayList(5);
            f aHEAD_OF_UTC = f.AHEAD_OF_UTC;
            arrayList.add(p.e(aHEAD_OF_UTC, 126, 58, 0));
            int i10 = 8;
            int i12 = 30;
            arrayList.add(p.t(aHEAD_OF_UTC, i10, i12));
            int i16 = 9;
            final int i17 = 0;
            arrayList.add(p.t(aHEAD_OF_UTC, i16, i17));
            arrayList.add(p.t(aHEAD_OF_UTC, i10, i12));
            arrayList.add(p.t(aHEAD_OF_UTC, i16, i17));
            KoreanCalendar.d.d = Collections.unmodifiableList(arrayList);
            int i13 = 1;
            KoreanCalendar.d.e = g0.K0(1908, 4, i13).c();
            KoreanCalendar.d.f = g0.K0(1912, i13, i13).c();
            KoreanCalendar.d.g = g0.K0(1954, 3, 21).c();
            KoreanCalendar.d.h = g0.K0(1961, i10, 10).c();
        }

        d(net.time4j.calendar.KoreanCalendar.a koreanCalendar$a) {
            super();
        }

        @Override // net.time4j.calendar.d
        net.time4j.calendar.f e(int i, int i2, net.time4j.calendar.h h3, int i4, long l5) {
            return x(i, i2, h3, i4, l5);
        }

        @Override // net.time4j.calendar.d
        int[] h() {
            return KoreanCalendar.o0();
        }

        @Override // net.time4j.calendar.d
        p i(long l) {
            if (Long.compare(l, l2) < 0) {
                return (p)KoreanCalendar.d.d.get(0);
            }
            if (Long.compare(l, l3) < 0) {
                return (p)KoreanCalendar.d.d.get(1);
            }
            if (Long.compare(l, l4) < 0) {
                return (p)KoreanCalendar.d.d.get(2);
            }
            if (Long.compare(l, l5) < 0) {
                return (p)KoreanCalendar.d.d.get(3);
            }
            return (p)KoreanCalendar.d.d.get(4);
        }

        @Override // net.time4j.calendar.d
        net.time4j.calendar.KoreanCalendar x(int i, int i2, net.time4j.calendar.h h3, int i4, long l5) {
            super(i, i2, h3, i4, l5, obj6, 0);
            return koreanCalendar;
        }
    }
    static {
        int i8;
        int i;
        int i5;
        int i4;
        int i2;
        java.util.Iterator it;
        int i7;
        int i6;
        int[] iArr = new int[1000];
        iArr = new int[]{
            4281, 5, 4284, 4, 4287, 1, 4289, 6, 4292, 5,
            4295, 3, 4297, 7, 4300, 6, 4303, 4, 4306, 2,
            4308, 7, 4311, 5, 4314, 3, 4316, 8, 4319, 6,
            4322, 4, 4325, 3, 4327, 7, 4330, 5, 4333, 3,
            4335, 7, 4338, 6, 4341, 4, 4344, 3, 4346, 7,
            4349, 5, 4352, 3, 4354, 8, 4357, 6, 4360, 4,
            4363, 2, 4365, 7, 4368, 5, 4371, 3, 4373, 9,
            4376, 6, 4379, 4, 4382, 3, 4384, 7, 4387, 5,
            4390, 4, 4392, 9, 4395, 6, 4398, 5, 4401, 2,
            4403, 7, 4406, 5, 4409, 3, 4411, 10, 4414, 6,
            4417, 5, 4420, 3, 4422, 7, 4425, 6, 4428, 4,
            4431, 2, 4433, 6, 4436, 4, 4439, 3, 4441, 6,
            4444, 5, 4447, 3, 4450, 2, 4452, 6, 4455, 4,
            4458, 3, 4460, 7, 4463, 5, 4466, 4, 4468, 9,
            4471, 6, 4474, 4, 4477, 3, 4479, 7, 4482, 5,
            4485, 4, 4487, 11, 4490, 7, 4493, 5, 4496, 3,
            4498, 8, 4501, 5, 4504, 4, 4506, 10, 4509, 6,
            4512, 5, 4515, 3, 4517, 7, 4520, 5, 4523, 4,
            4525, 12, 4528, 6, 4531, 5, 4534, 3, 4536, 8,
            4539, 5, 4542, 4, 4545, 2, 4547, 6, 4550, 5,
            4553, 2, 4555, 7, 4558, 5, 4561, 4, 4564, 2,
            4566, 6, 4569, 5, 4572, 3, 4574, 7, 4577, 6,
            4580, 4, 4583, 2, 4585, 7, 4588, 5, 4591, 3,
            4593, 8, 4596, 6, 4599, 4, 4602, 3, 4604, 7,
            4607, 5, 4610, 4, 4612, 8, 4615, 6, 4618, 4,
            4620, 10, 4623, 6, 4626, 5, 4629, 3, 4631, 8,
            4634, 5, 4637, 4, 4640, 2, 4642, 7, 4645, 5,
            4648, 3, 4650, 9, 4653, 5, 4656, 4, 4659, 2,
            4661, 6, 4664, 5, 4667, 3, 4669, 11, 4672, 6,
            4675, 5, 4678, 2, 4680, 7, 4683, 5, 4686, 3,
            4688, 8, 4691, 6, 4694, 4, 4697, 3, 4699, 7,
            4702, 5, 4705, 4, 4707, 8, 4710, 6, 4713, 4,
            4716, 3, 4718, 7, 4721, 5, 4724, 4, 4726, 8,
            4729, 6, 4732, 4, 4735, 3, 4737, 7, 4740, 5,
            4743, 4, 4745, 9, 4748, 6, 4751, 4, 4754, 3,
            4756, 7, 4759, 5, 4762, 4, 4764, 9, 4767, 6,
            4770, 5, 4773, 2, 4775, 7, 4778, 5, 4781, 4,
            4783, 11, 4786, 6, 4789, 5, 4792, 3, 4794, 7,
            4797, 6, 4800, 4, 4802, 10, 4805, 6, 4808, 4,
            4811, 3, 4813, 7, 4816, 6, 4819, 4, 4822, 2,
            4824, 7, 4827, 5, 4830, 3, 4832, 7, 4835, 6,
            4838, 4, 4840, 9, 4843, 6, 4846, 4, 4849, 3,
            4851, 7, 4854, 5, 4857, 4, 4859, 9, 4862, 7,
            4865, 5, 4868, 3, 4870, 8, 4873, 5, 4876, 4,
            4878, 11, 4881, 6, 4884, 5, 4887, 3, 4889, 8,
            4892, 6, 4895, 4, 4898, 1, 4900, 6, 4903, 5,
            4906, 3, 4908, 8, 4911, 6, 4914, 4, 4917, 2,
            4919, 6, 4922, 5, 4925, 3, 4927, 7, 4930, 6,
            4933, 4, 4936, 2, 4938, 6, 4941, 5, 4944, 3,
            4946, 7, 4949, 6, 4952, 4, 4955, 2, 4957, 7,
            4960, 5, 4963, 3, 4965, 8, 4968, 6, 4971, 4,
            4974, 3, 4976, 7, 4979, 5, 4982, 4, 4984, 8,
            4987, 6, 4990, 5, 4993, 2, 4995, 7, 4998, 5,
            5001, 4, 5003, 8, 5006, 6, 5009, 5, 5012, 2,
            5014, 7, 5017, 5, 5020, 4, 5022, 10, 5025, 6,
            5028, 4, 5031, 2, 5033, 6, 5036, 5, 5039, 3,
            5041, 8, 5044, 6, 5047, 5, 5050, 2, 5052, 7,
            5055, 5, 5058, 3, 5060, 8, 5063, 6, 5066, 4,
            5069, 3, 5071, 7, 5074, 5, 5077, 4, 5079, 8,
            5082, 6, 5085, 5, 5088, 3, 5090, 8, 5093, 5,
            5096, 4, 5098, 8, 5101, 6, 5104, 5, 5107, 3,
            5109, 7, 5112, 5, 5115, 4, 5117, 8, 5120, 6,
            5123, 5, 5126, 3, 5128, 7, 5131, 5, 5134, 4,
            5136, 10, 5139, 6, 5142, 5, 5145, 2, 5147, 7,
            5150, 5, 5153, 4, 5156, 2, 5158, 6, 5161, 5,
            5164, 3, 5166, 7, 5169, 6, 5172, 4, 5175, 1,
            5177, 7, 5180, 5, 5183, 3, 5185, 8, 5188, 6,
            5191, 4, 5193, 8, 5196, 7, 5199, 5, 5202, 4,
            5204, 8, 5207, 6, 5210, 4, 5212, 8, 5215, 7,
            5218, 5, 5221, 3, 5223, 7, 5226, 6, 5229, 4,
            5231, 10, 5234, 7, 5237, 5, 5240, 3, 5242, 8,
            5245, 5, 5248, 4, 5250, 11, 5253, 6, 5256, 5,
            5259, 3, 5261, 8, 5264, 6, 5267, 5, 5270, 1,
            5272, 7, 5275, 5, 5278, 3, 5280, 8, 5283, 6,
            5286, 4, 5289, 2, 5291, 7, 5294, 5, 5297, 3,
            5299, 8, 5302, 6, 5305, 4, 5308, 3, 5310, 7,
            5313, 5, 5316, 3, 5318, 7, 5321, 6, 5324, 4,
            5327, 3, 5329, 7, 5332, 5, 5335, 3, 5337, 8,
            5340, 6, 5343, 4, 5345, 10, 5348, 7, 5351, 5,
            5354, 4, 5356, 9, 5359, 6, 5362, 5, 5364, 11,
            5367, 7, 5370, 5, 5373, 4, 5375, 9, 5378, 6,
            5381, 5, 5384, 1, 5386, 7, 5389, 6, 5392, 4,
            5394, 8, 5397, 6, 5400, 5, 5403, 3, 5405, 7,
            5408, 6, 5411, 4, 5413, 8, 5416, 6, 5419, 5,
            5422, 3, 5424, 7, 5427, 6, 5430, 3, 5432, 8,
            5435, 6, 5438, 4, 5441, 3, 5443, 7, 5446, 6,
            5449, 4, 5451, 9, 5454, 7, 5457, 5, 5460, 3,
            5462, 8, 5465, 5, 5468, 4, 5470, 9, 5473, 6,
            5476, 5, 5479, 3, 5481, 8, 5484, 6, 5487, 4,
            5489, 9, 5492, 6, 5495, 5, 5498, 3, 5500, 7,
            5503, 6, 5506, 4, 5508, 10, 5511, 6, 5514, 5,
            5517, 3, 5519, 7, 5522, 6, 5525, 4, 5527, 10,
            5530, 6, 5533, 5, 5536, 3, 5538, 7, 5541, 6,
            5544, 4, 5546, 11, 5549, 7, 5552, 5, 5555, 3,
            5557, 8, 5560, 6, 5563, 4, 5565, 9, 5568, 7,
            5571, 5, 5574, 4, 5576, 8, 5579, 6, 5582, 4,
            5584, 11, 5587, 7, 5590, 5, 5593, 4, 5595, 8,
            5598, 6, 5601, 5, 5603, 10, 5606, 7, 5609, 5,
            5612, 3, 5614, 8, 5617, 6, 5620, 4, 5622, 10,
            5625, 6, 5628, 5, 5631, 4, 5633, 9, 5636, 6
        };
        KoreanCalendar.y = iArr;
        net.time4j.calendar.k dANGI = k.DANGI;
        p pVar2 = dANGI.era();
        KoreanCalendar.z = pVar2;
        super("CYCLE", KoreanCalendar.class, 72, 94, 0, 0, 0);
        KoreanCalendar.A = fVar6;
        p yearOfEra = dANGI.yearOfEra();
        KoreanCalendar.B = yearOfEra;
        net.time4j.calendar.e eVar = e.a;
        KoreanCalendar.C = eVar;
        net.time4j.calendar.i iVar2 = i.h();
        KoreanCalendar.D = iVar2;
        net.time4j.calendar.g gVar2 = g.a;
        KoreanCalendar.E = gVar2;
        int i24 = 1;
        super("MONTH_AS_ORDINAL", KoreanCalendar.class, i24, 12, 0, 0, 0);
        KoreanCalendar.F = fVar3;
        final String str4 = "DAY_OF_MONTH";
        super(str4, KoreanCalendar.class, 1, 30, 100);
        KoreanCalendar.G = fVar4;
        super("DAY_OF_YEAR", KoreanCalendar.class, i24, 355, 68);
        KoreanCalendar.H = fVar5;
        g gVar3 = new g(KoreanCalendar.class, KoreanCalendar.q0());
        KoreanCalendar.I = gVar3;
        q qVar = new q(KoreanCalendar.class, fVar4, gVar3);
        KoreanCalendar.J = qVar;
        int i23 = 0;
        KoreanCalendar.d dVar = new KoreanCalendar.d(i23);
        KoreanCalendar.K = dVar;
        KoreanCalendar.c cVar = new KoreanCalendar.c();
        f0.b bVar = f0.b.j(KoreanCalendar.e.class, KoreanCalendar.class, cVar, dVar);
        KoreanCalendar.b bVar2 = new KoreanCalendar.b(i23);
        bVar.d(pVar2, bVar2);
        bVar.d(fVar6, f.Z(eVar));
        KoreanCalendar.f fVar = new KoreanCalendar.f(i23);
        net.time4j.calendar.KoreanCalendar.e yEARS = KoreanCalendar.e.YEARS;
        bVar.e(yearOfEra, fVar, yEARS);
        bVar.e(eVar, f.j0(gVar2), yEARS);
        bVar.d(iVar2, i.h());
        net.time4j.calendar.KoreanCalendar.e mONTHS = KoreanCalendar.e.MONTHS;
        bVar.e(gVar2, f.g0(fVar4), mONTHS);
        bVar.e(fVar3, f.f0(fVar4), mONTHS);
        net.time4j.calendar.KoreanCalendar.e dAYS = KoreanCalendar.e.DAYS;
        bVar.e(fVar4, f.a0(), dAYS);
        bVar.e(fVar5, f.c0(), dAYS);
        KoreanCalendar.a aVar = new KoreanCalendar.a();
        r rVar = new r(KoreanCalendar.q0(), aVar);
        bVar.e(gVar3, rVar, dAYS);
        bVar.d(qVar, q.u(qVar));
        m mVar = new m(dVar, fVar5);
        bVar.d(b.a, mVar);
        net.time4j.calendar.KoreanCalendar.e cYCLES = KoreanCalendar.e.CYCLES;
        f0.b bVar3 = bVar;
        bVar3.g(cYCLES, f.h0(0), cYCLES.getLength(), str4);
        bVar3.g(yEARS, f.h0(1), yEARS.getLength(), str4);
        bVar3.g(mONTHS, f.h0(2), mONTHS.getLength(), str4);
        net.time4j.calendar.KoreanCalendar.e wEEKS = KoreanCalendar.e.WEEKS;
        bVar3.g(wEEKS, f.h0(3), wEEKS.getLength(), str4);
        bVar3.g(dAYS, f.h0(4), dAYS.getLength(), str4);
        b.g gVar = new b.g(KoreanCalendar.class, fVar4, fVar5, KoreanCalendar.q0());
        bVar.f(gVar);
        KoreanCalendar.L = bVar.h();
    }

    private KoreanCalendar(int i, int i2, net.time4j.calendar.h h3, int i4, long l5) {
        super(i, i2, h3, i4, l5, obj6);
    }

    KoreanCalendar(int i, int i2, net.time4j.calendar.h h3, int i4, long l5, net.time4j.calendar.KoreanCalendar.a koreanCalendar$a6) {
        super(i, i2, h3, i4, l5, a6);
    }

    static net.time4j.calendar.d n0() {
        return KoreanCalendar.K;
    }

    static int[] o0() {
        return KoreanCalendar.y;
    }

    public static z0 q0() {
        Locale locale = new Locale("ko", "KR");
        return z0.j(locale);
    }

    static net.time4j.calendar.KoreanCalendar r0(int i, int i2, net.time4j.calendar.h h3, int i4) {
        super(i, i2, h3, i4, KoreanCalendar.K.t(i, i2, h3, i4), obj7);
        return koreanCalendar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    public static net.time4j.calendar.KoreanCalendar s0(net.time4j.calendar.j j, net.time4j.calendar.h h2, int i3) {
        return KoreanCalendar.r0(j.c(), j.e().getNumber(), h2, i3);
    }

    private Object writeReplace() {
        KoreanCalendar.SPX spx = new KoreanCalendar.SPX(this);
        return spx;
    }

    protected f0<net.time4j.calendar.KoreanCalendar.e, net.time4j.calendar.KoreanCalendar> J() {
        return KoreanCalendar.L;
    }

    net.time4j.calendar.d<net.time4j.calendar.KoreanCalendar> X() {
        return KoreanCalendar.K;
    }

    @Override // net.time4j.calendar.f
    protected net.time4j.calendar.KoreanCalendar p0() {
        return this;
    }

    @Override // net.time4j.calendar.f
    protected q z() {
        p0();
        return this;
    }
}
