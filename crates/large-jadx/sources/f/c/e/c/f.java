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
public final class f extends z<f.c.e.c.f, f.c.e.c.f.b> implements u0 {

    public static final int COMMIT_TIME_FIELD_NUMBER = 2;
    private static final f.c.e.c.f DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.f> PARSER = null;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 1;
    private r1 commitTime_;
    private c0.j<f.c.e.c.c0> writeResults_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            f.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            f.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            f.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            f.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            f.a.a[z.f.GET_PARSER.ordinal()] = 5;
            f.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            f.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.f, f.c.e.c.f.b> implements u0 {
        private b() {
            super(f.b());
        }

        b(f.c.e.c.f.a f$a) {
            super();
        }
    }
    static {
        f fVar = new f();
        f.DEFAULT_INSTANCE = fVar;
        z.registerDefaultInstance(f.class, fVar);
    }

    private f() {
        super();
        this.writeResults_ = z.emptyProtobufList();
    }

    static f.c.e.c.f b() {
        return f.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.f d() {
        return f.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public r1 c() {
        r1 commitTime_;
        if (this.commitTime_ == null) {
            commitTime_ = r1.e();
        }
        return commitTime_;
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
                obj2 = new f();
                return obj2;
            case 2:
                obj2 = new f.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = c0.class;
                obj2[2] = "commitTime_";
                return z.newMessageInfo(f.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\t", obj2);
            case 4:
                return f.DEFAULT_INSTANCE;
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
        obj3 = f.class;
        synchronized (obj3) {
            obj2 = new z.b(f.DEFAULT_INSTANCE);
            f.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.c0 e(int i) {
        return (c0)this.writeResults_.get(i);
    }

    @Override // com.google.protobuf.z
    public int f() {
        return this.writeResults_.size();
    }
}
