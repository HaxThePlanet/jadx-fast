package kotlin.i0.z.e.m0.e.y;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a extends a {

    public static final kotlin.i0.z.e.m0.e.y.a.a f;
    public static final kotlin.i0.z.e.m0.e.y.a g;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.e.y.a a(InputStream inputStream) {
            int valueOf;
            n.f(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            f obj4 = new f(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(p.r(obj4, 10));
            obj4 = obj4.iterator();
            while (obj4.hasNext()) {
                (h0)obj4.d();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            obj4 = p.K0(arrayList);
            int[] iArr = new int[obj4.length];
            int i3 = 0;
            System.arraycopy(obj4, i3, iArr, i3, obj4.length);
            obj4 = new a(iArr);
            return obj4;
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.f = aVar;
        int[] iArr = new int[3];
        iArr = new int[]{1, 0, 7};
        a aVar2 = new a(iArr);
        a.g = aVar2;
        a aVar3 = new a(new int[0]);
    }

    public a(int... iArr) {
        n.f(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        final int i = 0;
        System.arraycopy(iArr, i, iArr2, i, iArr.length);
        super(iArr2);
    }

    @Override // kotlin.i0.z.e.m0.e.z.a
    public boolean h() {
        return f(a.g);
    }
}
