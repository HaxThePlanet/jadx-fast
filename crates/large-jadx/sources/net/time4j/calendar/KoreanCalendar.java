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
import net.time4j.calendar.t.g;
import net.time4j.engine.d;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.i0;
import net.time4j.engine.k;
import net.time4j.engine.l0;
import net.time4j.engine.m;
import net.time4j.engine.q;
import net.time4j.engine.s;
import net.time4j.engine.v;
import net.time4j.engine.y;
import net.time4j.g0;
import net.time4j.g1.c;
import net.time4j.g1.h;
import net.time4j.g1.t;
import net.time4j.x0;
import net.time4j.z0;

/* compiled from: KoreanCalendar.java */
@c("dangi")
/* loaded from: classes3.dex */
public final class KoreanCalendar extends f<KoreanCalendar.e, KoreanCalendar> implements h {

    public static final net.time4j.engine.p<Integer> A;
    public static final net.time4j.engine.p<Integer> B;
    public static final t<c> C;
    public static final net.time4j.engine.p<o> D;
    public static final t<h> E;
    public static final p<Integer, KoreanCalendar> F;
    public static final p<Integer, KoreanCalendar> G;
    public static final p<Integer, KoreanCalendar> H;
    public static final p<x0, KoreanCalendar> I = null;
    private static final q<KoreanCalendar> J = null;
    private static final d<KoreanCalendar> K = null;
    private static final f0<KoreanCalendar.e, KoreanCalendar> L;
    private static final long serialVersionUID = -4284841131270593971L;
    private static final int[] y;
    public static final net.time4j.engine.p<k> z;

    private static class SPX implements Externalizable {

        private static final long serialVersionUID = 1L;
        private transient Object a;
        private KoreanCalendar a(ObjectInput objectInput) {
            net.time4j.calendar.h hVar;
            if (objectInput.readBoolean()) {
                hVar = h.f(objectInput.readByte()).i();
            }
            return KoreanCalendar.r0(objectInput.readByte(), objectInput.readByte(), hVar, objectInput.readByte());
        }

        private void b(ObjectOutput objectOutput) {
            objectOutput.writeByte(obj.Y());
            objectOutput.writeByte(obj.i0().getNumber());
            objectOutput.writeByte(obj.e0().getNumber());
            objectOutput.writeBoolean(obj.e0().e());
            objectOutput.writeByte(obj.q());
        }

        private Object readResolve() {
            return this.a;
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws InvalidObjectException {
            if (objectInput.readByte() != 15) {
                throw new InvalidObjectException("Unknown calendar type.");
            } else {
                this.a = a(objectInput);
                return;
            }
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) {
            objectOutput.writeByte(15);
            b(objectOutput);
        }

        SPX(Object object) {
            super();
            this.a = object;
        }
    }

    static class a implements s<KoreanCalendar, k<KoreanCalendar>> {
        a() {
            super();
        }

        public k<KoreanCalendar> a(KoreanCalendar koreanCalendar) {
            return KoreanCalendar.K;
        }
    }

    private static class b implements y<KoreanCalendar, k> {
        private b() {
            super();
        }

        public net.time4j.engine.p<?> b(KoreanCalendar koreanCalendar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public net.time4j.engine.p<?> d(KoreanCalendar koreanCalendar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public k e(KoreanCalendar koreanCalendar) {
            return k.DANGI;
        }

        public k f(KoreanCalendar koreanCalendar) {
            return k.DANGI;
        }

        public k g(KoreanCalendar koreanCalendar) {
            return k.DANGI;
        }

        public boolean h(KoreanCalendar koreanCalendar, k kVar) {
            boolean z = true;
            koreanCalendar = kVar == k.DANGI ? 1 : 0;
            return (kVar == k.DANGI ? 1 : 0);
        }

        public KoreanCalendar i(KoreanCalendar koreanCalendar, k kVar, boolean z) {
            if (!h(koreanCalendar, kVar)) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Invalid Korean era: ";
                kVar = str + kVar;
                throw new IllegalArgumentException(kVar);
            } else {
                return koreanCalendar;
            }
        }

        /* synthetic */ b(KoreanCalendar.a aVar) {
            this();
        }
    }

    public enum e implements v {

        CYCLES,
        DAYS,
        MONTHS,
        WEEKS,
        YEARS;

        private final transient double length;
        @Override // java.lang.Enum
        public int between(KoreanCalendar koreanCalendar, KoreanCalendar koreanCalendar2) {
            return (int)(koreanCalendar.N(koreanCalendar2, this));
        }

        @Override // java.lang.Enum
        public double getLength() {
            return this.length;
        }

        @Override // java.lang.Enum
        public boolean isCalendrical() {
            return true;
        }
    }

    private static class f implements y<KoreanCalendar, Integer> {
        private f() {
            super();
        }

        private int e(KoreanCalendar koreanCalendar) {
            return (koreanCalendar.Y() * 60) + koreanCalendar.i0().getNumber() - 364;
        }

        public net.time4j.engine.p<?> b(KoreanCalendar koreanCalendar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public net.time4j.engine.p<?> d(KoreanCalendar koreanCalendar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public Integer f(KoreanCalendar koreanCalendar) {
            return 5332;
        }

        public Integer g(KoreanCalendar koreanCalendar) {
            return 3978;
        }

        public Integer h(KoreanCalendar koreanCalendar) {
            return Integer.valueOf(e(koreanCalendar));
        }

        public boolean i(KoreanCalendar koreanCalendar, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            if (integer.intValue() >= g(koreanCalendar).intValue() && integer.intValue() <= f(koreanCalendar).intValue()) {
                int i = 1;
            }
            return z;
        }

        public KoreanCalendar j(KoreanCalendar koreanCalendar, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing year of era.");
            } else {
                if (!i(koreanCalendar, integer)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Invalid year of era: ";
                    integer = str + integer;
                    throw new IllegalArgumentException(integer);
                } else {
                    int i2 = e(koreanCalendar);
                    return (KoreanCalendar)koreanCalendar.M((long)(integer.intValue() - i2), KoreanCalendar.e.YEARS);
                }
            }
        }

        /* synthetic */ f(KoreanCalendar.a aVar) {
            this();
        }
    }

    private static class c extends a<KoreanCalendar> {
        c() {
            super(KoreanCalendar.class);
        }

        @Override // net.time4j.calendar.a
        public KoreanCalendar h(q<?> qVar, d dVar, boolean z, boolean z2) {
            net.time4j.calendar.j jVar;
            int i5 = qVar.e(b.a);
            int z32 = 0;
            int i2 = Integer.MIN_VALUE;
            if (i5 != Integer.MIN_VALUE) {
                jVar = j.b(i5);
            } else {
                t tVar2 = KoreanCalendar.C;
                if (qVar.v(tVar2)) {
                    net.time4j.engine.p pVar2 = KoreanCalendar.A;
                    if (qVar.v(pVar2)) {
                        jVar = (c)qVar.p(KoreanCalendar.C).r(qVar.e(KoreanCalendar.A));
                    } else {
                        int i6 = qVar.e(k.DANGI.yearOfEra());
                        if (i6 != Integer.MIN_VALUE) {
                            jVar = j.a(i6);
                        } else {
                        }
                    }
                }
            }
            if (k.DANGI == null) {
                qVar.G(l0.ERROR_MESSAGE, "Cannot determine East Asian year.");
                return null;
            }
            t tVar = KoreanCalendar.E;
            if (qVar.v(tVar)) {
                int i = qVar.e(KoreanCalendar.G);
                if (i != Integer.MIN_VALUE) {
                    return KoreanCalendar.s0(jVar, (h)qVar.p(KoreanCalendar.E), i);
                }
            } else {
                i = qVar.e(KoreanCalendar.H);
                if (i != Integer.MIN_VALUE && i >= i2) {
                    return (KoreanCalendar)KoreanCalendar.s0(jVar, h.f(i2), i2).M((long)(i - i2), KoreanCalendar.e.DAYS);
                }
            }
            return z32;
        }
    }

    private static class d extends d<KoreanCalendar> {

        private static final List<net.time4j.tz.p> d;
        private static final long e = 0L;
        private static final long f = 0L;
        private static final long g = 0L;
        private static final long h = 0L;
        static {
            ArrayList arrayList = new ArrayList(5);
            net.time4j.tz.f aHEAD_OF_UTC2 = f.AHEAD_OF_UTC;
            arrayList.add(p.e(aHEAD_OF_UTC2, 126, 58, 0.0d));
            int i10 = 8;
            int i12 = 30;
            arrayList.add(p.t(aHEAD_OF_UTC2, i10, i12));
            int i16 = 9;
            final int i17 = 0;
            arrayList.add(p.t(aHEAD_OF_UTC2, i16, i17));
            arrayList.add(p.t(aHEAD_OF_UTC2, i10, i12));
            arrayList.add(p.t(aHEAD_OF_UTC2, i16, i17));
            KoreanCalendar.d.d = Collections.unmodifiableList(arrayList);
            int i13 = 1;
            KoreanCalendar.d.e = g0.K0(1908, 4, i13).c();
            KoreanCalendar.d.f = g0.K0(1912, i13, i13).c();
            KoreanCalendar.d.g = g0.K0(1954, 3, 21).c();
            KoreanCalendar.d.h = g0.K0(1961, i10, 10).c();
        }

        private d() {
            super();
        }

        @Override // net.time4j.calendar.d
        int[] h() {
            return KoreanCalendar.y;
        }

        @Override // net.time4j.calendar.d
        net.time4j.tz.p i(long j) {
            long l = KoreanCalendar.d.e;
            if (j < KoreanCalendar.d.e) {
                return (p)KoreanCalendar.d.d.get(0);
            }
            long l2 = KoreanCalendar.d.f;
            if (KoreanCalendar.d.d < KoreanCalendar.d.f) {
                return (p)KoreanCalendar.d.d.get(1);
            }
            long l3 = KoreanCalendar.d.g;
            if (KoreanCalendar.d.d < KoreanCalendar.d.g) {
                return (p)KoreanCalendar.d.d.get(2);
            }
            long l4 = KoreanCalendar.d.h;
            if (KoreanCalendar.d.d < KoreanCalendar.d.h) {
                return (p)KoreanCalendar.d.d.get(3);
            }
            return (p)KoreanCalendar.d.d.get(4);
        }

        @Override // net.time4j.calendar.d
        KoreanCalendar x(int i, int i2, h hVar, int i3, long j) {
            KoreanCalendar koreanCalendar = new KoreanCalendar(i, i2, hVar, i3, j, aVar, 0);
            return koreanCalendar;
        }

        /* synthetic */ d(KoreanCalendar.a aVar) {
            this();
        }
    }
    static {
        int i;
        boolean z;
        Object obj18;
        java.util.Iterator it;
        KoreanCalendar.y = new int[] { 4281, 5, 4284, 4, 4287, 1, 4289, 6, 4292, 5, 4295, 3, 4297, 7, 4300, 6, 4303, 4, 4306, 2, 4308, 7, 4311, 5, 4314, 3, 4316, 8, 4319, 6, 4322, 4, 4325, 3, 4327, 7, 4330, 5, 4333, 3, 4335, 7, 4338, 6, 4341, 4, 4344, 3, 4346, 7, 4349, 5, 4352, 3, 4354, 8, 4357, 6, 4360, 4, 4363, 2, 4365, 7, 4368, 5, 4371, 3, 4373, 9, 4376, 6, 4379, 4, 4382, 3, 4384, 7, 4387, 5, 4390, 4, 4392, 9, 4395, 6, 4398, 5, 4401, 2, 4403, 7, 4406, 5, 4409, 3, 4411, 10, 4414, 6, 4417, 5, 4420, 3, 4422, 7, 4425, 6, 4428, 4, 4431, 2, 4433, 6, 4436, 4, 4439, 3, 4441, 6, 4444, 5, 4447, 3, 4450, 2, 4452, 6, 4455, 4, 4458, 3, 4460, 7, 4463, 5, 4466, 4, 4468, 9, 4471, 6, 4474, 4, 4477, 3, 4479, 7, 4482, 5, 4485, 4, 4487, 11, 4490, 7, 4493, 5, 4496, 3, 4498, 8, 4501, 5, 4504, 4, 4506, 10, 4509, 6, 4512, 5, 4515, 3, 4517, 7, 4520, 5, 4523, 4, 4525, 12, 4528, 6, 4531, 5, 4534, 3, 4536, 8, 4539, 5, 4542, 4, 4545, 2, 4547, 6, 4550, 5, 4553, 2, 4555, 7, 4558, 5, 4561, 4, 4564, 2, 4566, 6, 4569, 5, 4572, 3, 4574, 7, 4577, 6, 4580, 4, 4583, 2, 4585, 7, 4588, 5, 4591, 3, 4593, 8, 4596, 6, 4599, 4, 4602, 3, 4604, 7, 4607, 5, 4610, 4, 4612, 8, 4615, 6, 4618, 4, 4620, 10, 4623, 6, 4626, 5, 4629, 3, 4631, 8, 4634, 5, 4637, 4, 4640, 2, 4642, 7, 4645, 5, 4648, 3, 4650, 9, 4653, 5, 4656, 4, 4659, 2, 4661, 6, 4664, 5, 4667, 3, 4669, 11, 4672, 6, 4675, 5, 4678, 2, 4680, 7, 4683, 5, 4686, 3, 4688, 8, 4691, 6, 4694, 4, 4697, 3, 4699, 7, 4702, 5, 4705, 4, 4707, 8, 4710, 6, 4713, 4, 4716, 3, 4718, 7, 4721, 5, 4724, 4, 4726, 8, 4729, 6, 4732, 4, 4735, 3, 4737, 7, 4740, 5, 4743, 4, 4745, 9, 4748, 6, 4751, 4, 4754, 3, 4756, 7, 4759, 5, 4762, 4, 4764, 9, 4767, 6, 4770, 5, 4773, 2, 4775, 7, 4778, 5, 4781, 4, 4783, 11, 4786, 6, 4789, 5, 4792, 3, 4794, 7, 4797, 6, 4800, 4, 4802, 10, 4805, 6, 4808, 4, 4811, 3, 4813, 7, 4816, 6, 4819, 4, 4822, 2, 4824, 7, 4827, 5, 4830, 3, 4832, 7, 4835, 6, 4838, 4, 4840, 9, 4843, 6, 4846, 4, 4849, 3, 4851, 7, 4854, 5, 4857, 4, 4859, 9, 4862, 7, 4865, 5, 4868, 3, 4870, 8, 4873, 5, 4876, 4, 4878, 11, 4881, 6, 4884, 5, 4887, 3, 4889, 8, 4892, 6, 4895, 4, 4898, 1, 4900, 6, 4903, 5, 4906, 3, 4908, 8, 4911, 6, 4914, 4, 4917, 2, 4919, 6, 4922, 5, 4925, 3, 4927, 7, 4930, 6, 4933, 4, 4936, 2, 4938, 6, 4941, 5, 4944, 3, 4946, 7, 4949, 6, 4952, 4, 4955, 2, 4957, 7, 4960, 5, 4963, 3, 4965, 8, 4968, 6, 4971, 4, 4974, 3, 4976, 7, 4979, 5, 4982, 4, 4984, 8, 4987, 6, 4990, 5, 4993, 2, 4995, 7, 4998, 5, 5001, 4, 5003, 8, 5006, 6, 5009, 5, 5012, 2, 5014, 7, 5017, 5, 5020, 4, 5022, 10, 5025, 6, 5028, 4, 5031, 2, 5033, 6, 5036, 5, 5039, 3, 5041, 8, 5044, 6, 5047, 5, 5050, 2, 5052, 7, 5055, 5, 5058, 3, 5060, 8, 5063, 6, 5066, 4, 5069, 3, 5071, 7, 5074, 5, 5077, 4, 5079, 8, 5082, 6, 5085, 5, 5088, 3, 5090, 8, 5093, 5, 5096, 4, 5098, 8, 5101, 6, 5104, 5, 5107, 3, 5109, 7, 5112, 5, 5115, 4, 5117, 8, 5120, 6, 5123, 5, 5126, 3, 5128, 7, 5131, 5, 5134, 4, 5136, 10, 5139, 6, 5142, 5, 5145, 2, 5147, 7, 5150, 5, 5153, 4, 5156, 2, 5158, 6, 5161, 5, 5164, 3, 5166, 7, 5169, 6, 5172, 4, 5175, 1, 5177, 7, 5180, 5, 5183, 3, 5185, 8, 5188, 6, 5191, 4, 5193, 8, 5196, 7, 5199, 5, 5202, 4, 5204, 8, 5207, 6, 5210, 4, 5212, 8, 5215, 7, 5218, 5, 5221, 3, 5223, 7, 5226, 6, 5229, 4, 5231, 10, 5234, 7, 5237, 5, 5240, 3, 5242, 8, 5245, 5, 5248, 4, 5250, 11, 5253, 6, 5256, 5, 5259, 3, 5261, 8, 5264, 6, 5267, 5, 5270, 1, 5272, 7, 5275, 5, 5278, 3, 5280, 8, 5283, 6, 5286, 4, 5289, 2, 5291, 7, 5294, 5, 5297, 3, 5299, 8, 5302, 6, 5305, 4, 5308, 3, 5310, 7, 5313, 5, 5316, 3, 5318, 7, 5321, 6, 5324, 4, 5327, 3, 5329, 7, 5332, 5, 5335, 3, 5337, 8, 5340, 6, 5343, 4, 5345, 10, 5348, 7, 5351, 5, 5354, 4, 5356, 9, 5359, 6, 5362, 5, 5364, 11, 5367, 7, 5370, 5, 5373, 4, 5375, 9, 5378, 6, 5381, 5, 5384, 1, 5386, 7, 5389, 6, 5392, 4, 5394, 8, 5397, 6, 5400, 5, 5403, 3, 5405, 7, 5408, 6, 5411, 4, 5413, 8, 5416, 6, 5419, 5, 5422, 3, 5424, 7, 5427, 6, 5430, 3, 5432, 8, 5435, 6, 5438, 4, 5441, 3, 5443, 7, 5446, 6, 5449, 4, 5451, 9, 5454, 7, 5457, 5, 5460, 3, 5462, 8, 5465, 5, 5468, 4, 5470, 9, 5473, 6, 5476, 5, 5479, 3, 5481, 8, 5484, 6, 5487, 4, 5489, 9, 5492, 6, 5495, 5, 5498, 3, 5500, 7, 5503, 6, 5506, 4, 5508, 10, 5511, 6, 5514, 5, 5517, 3, 5519, 7, 5522, 6, 5525, 4, 5527, 10, 5530, 6, 5533, 5, 5536, 3, 5538, 7, 5541, 6, 5544, 4, 5546, 11, 5549, 7, 5552, 5, 5555, 3, 5557, 8, 5560, 6, 5563, 4, 5565, 9, 5568, 7, 5571, 5, 5574, 4, 5576, 8, 5579, 6, 5582, 4, 5584, 11, 5587, 7, 5590, 5, 5593, 4, 5595, 8, 5598, 6, 5601, 5, 5603, 10, 5606, 7, 5609, 5, 5612, 3, 5614, 8, 5617, 6, 5620, 4, 5622, 10, 5625, 6, 5628, 5, 5631, 4, 5633, 9, 5636, 6 };
        net.time4j.calendar.k dANGI2 = k.DANGI;
        net.time4j.engine.p pVar2 = dANGI2.era();
        KoreanCalendar.z = pVar2;
        f fVar = new f("CYCLE", KoreanCalendar.class, 72, 94, '\0', null, null);
        KoreanCalendar.A = fVar;
        net.time4j.engine.p yearOfEra = dANGI2.yearOfEra();
        KoreanCalendar.B = yearOfEra;
        net.time4j.calendar.e eVar = e.a;
        KoreanCalendar.C = eVar;
        net.time4j.calendar.i iVar2 = i.h();
        KoreanCalendar.D = iVar2;
        net.time4j.calendar.g gVar2 = g.a;
        KoreanCalendar.E = gVar2;
        int i13 = 1;
        f fVar2 = new f("MONTH_AS_ORDINAL", KoreanCalendar.class, i13, 12, '\0', null, null);
        KoreanCalendar.F = fVar2;
        final String str4 = "DAY_OF_MONTH";
        f fVar3 = new f(str4, KoreanCalendar.class, 1, 30, 'd');
        KoreanCalendar.G = fVar3;
        f fVar4 = new f("DAY_OF_YEAR", KoreanCalendar.class, i13, 355, 'D');
        KoreanCalendar.H = fVar4;
        g gVar3 = new g(KoreanCalendar.class, KoreanCalendar.q0());
        KoreanCalendar.I = gVar3;
        net.time4j.calendar.q qVar = new q(KoreanCalendar.class, fVar3, gVar3);
        KoreanCalendar.J = qVar;
        net.time4j.calendar.KoreanCalendar.a aVar2 = null;
        net.time4j.calendar.KoreanCalendar.d dVar = new KoreanCalendar.d(aVar2);
        KoreanCalendar.K = dVar;
        f0.b bVar = f0.b.j(KoreanCalendar.e.class, KoreanCalendar.class, new KoreanCalendar.c(), dVar);
        bVar.d(pVar2, new KoreanCalendar.b(aVar2));
        bVar.d(fVar, f.Z(eVar));
        net.time4j.calendar.KoreanCalendar.e yEARS2 = KoreanCalendar.e.YEARS;
        bVar.e(yearOfEra, new KoreanCalendar.f(aVar2), yEARS2);
        bVar.e(eVar, f.j0(gVar2), yEARS2);
        bVar.d(iVar2, i.h());
        net.time4j.calendar.KoreanCalendar.e mONTHS2 = KoreanCalendar.e.MONTHS;
        bVar.e(gVar2, f.g0(fVar3), mONTHS2);
        bVar.e(fVar2, f.f0(fVar3), mONTHS2);
        net.time4j.calendar.KoreanCalendar.e dAYS2 = KoreanCalendar.e.DAYS;
        bVar.e(fVar3, f.a0(), dAYS2);
        bVar.e(fVar4, f.c0(), dAYS2);
        bVar.e(gVar3, new r(KoreanCalendar.q0(), new KoreanCalendar.a()), dAYS2);
        bVar.d(qVar, q.u(qVar));
        bVar.d(b.a, new m(dVar, fVar4));
        net.time4j.calendar.KoreanCalendar.e cYCLES2 = KoreanCalendar.e.CYCLES;
        bVar.g(cYCLES2, f.h0(0), cYCLES2.getLength(), Collections.singleton(yEARS2));
        bVar.g(yEARS2, f.h0(1), yEARS2.getLength(), Collections.singleton(cYCLES2));
        bVar.g(mONTHS2, f.h0(2), mONTHS2.getLength(), Collections.emptySet());
        net.time4j.calendar.KoreanCalendar.e wEEKS2 = KoreanCalendar.e.WEEKS;
        bVar.g(wEEKS2, f.h0(3), wEEKS2.getLength(), Collections.singleton(dAYS2));
        bVar.g(dAYS2, f.h0(4), dAYS2.getLength(), Collections.singleton(wEEKS2));
        bVar.f(new b.g(KoreanCalendar.class, fVar3, fVar4, KoreanCalendar.q0()));
        KoreanCalendar.L = bVar.h();
    }

    /* synthetic */ KoreanCalendar(int i, int i2, h hVar, int i3, long j, KoreanCalendar.a aVar) {
        this(i, i2, hVar, i3, j, r6);
    }

    static /* synthetic */ d n0() {
        return KoreanCalendar.K;
    }

    static /* synthetic */ int[] o0() {
        return KoreanCalendar.y;
    }

    public static z0 q0() {
        return z0.j(new Locale("ko", "KR"));
    }

    static KoreanCalendar r0(int i, int i2, h hVar, int i3) {
        KoreanCalendar koreanCalendar = new KoreanCalendar(i, i2, hVar, i3, KoreanCalendar.K.t(i, i2, hVar, i3), obj);
        return koreanCalendar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public static KoreanCalendar s0(j jVar, h hVar, int i) {
        return KoreanCalendar.r0(jVar.c(), jVar.e().getNumber(), hVar, i);
    }

    private Object writeReplace() {
        return new KoreanCalendar.SPX(this);
    }

    @Override // net.time4j.calendar.f
    protected f0<KoreanCalendar.e, KoreanCalendar> J() {
        return KoreanCalendar.L;
    }

    @Override // net.time4j.calendar.f
    d<KoreanCalendar> X() {
        return KoreanCalendar.K;
    }

    private KoreanCalendar(int i, int i2, h hVar, int i3, long j) {
        super(i, i2, hVar, i3, j, r6);
    }

    @Override // net.time4j.calendar.f
    protected KoreanCalendar p0() {
        return this;
    }
}
