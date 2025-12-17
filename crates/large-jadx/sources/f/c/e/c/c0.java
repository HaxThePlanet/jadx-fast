package f.c.e.c;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class c0 extends z<f.c.e.c.c0, f.c.e.c.c0.b> implements u0 {

    private static final f.c.e.c.c0 DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.c0> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private c0.j<f.c.e.c.x> transformResults_;
    private r1 updateTime_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c0.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            c0.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            c0.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            c0.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            c0.a.a[z.f.GET_PARSER.ordinal()] = 5;
            c0.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            c0.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.c0, f.c.e.c.c0.b> implements u0 {
        private b() {
            super(c0.b());
        }

        b(f.c.e.c.c0.a c0$a) {
            super();
        }
    }
    static {
        c0 c0Var = new c0();
        c0.DEFAULT_INSTANCE = c0Var;
        z.registerDefaultInstance(c0.class, c0Var);
    }

    private c0() {
        super();
        this.transformResults_ = z.emptyProtobufList();
    }

    static f.c.e.c.c0 b() {
        return c0.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.x c(int i) {
        return (x)this.transformResults_.get(i);
    }

    @Override // com.google.protobuf.z
    public int d() {
        return this.transformResults_.size();
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new c0();
                return obj2;
            case 2:
                obj2 = new c0.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "transformResults_";
                obj2[2] = x.class;
                return z.newMessageInfo(c0.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", obj2);
            case 4:
                return c0.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = c0.class;
        synchronized (obj3) {
            obj2 = new z.b(c0.DEFAULT_INSTANCE);
            c0.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public r1 e() {
        r1 updateTime_;
        if (this.updateTime_ == null) {
            updateTime_ = r1.e();
        }
        return updateTime_;
    }
}
