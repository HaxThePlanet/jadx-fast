package f.c.e.c;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class b0 extends z<f.c.e.c.b0, f.c.e.c.b0.b> implements u0 {

    public static final int COMMIT_TIME_FIELD_NUMBER = 4;
    private static final f.c.e.c.b0 DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.b0> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
    private r1 commitTime_;
    private String streamId_;
    private j streamToken_;
    private c0.j<f.c.e.c.c0> writeResults_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b0.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            b0.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            b0.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            b0.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            b0.a.a[z.f.GET_PARSER.ordinal()] = 5;
            b0.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            b0.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.b0, f.c.e.c.b0.b> implements u0 {
        private b() {
            super(b0.b());
        }

        b(f.c.e.c.b0.a b0$a) {
            super();
        }
    }
    static {
        b0 b0Var = new b0();
        b0.DEFAULT_INSTANCE = b0Var;
        z.registerDefaultInstance(b0.class, b0Var);
    }

    private b0() {
        super();
        this.streamId_ = "";
        this.streamToken_ = j.a;
        this.writeResults_ = z.emptyProtobufList();
    }

    static f.c.e.c.b0 b() {
        return b0.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.b0 d() {
        return b0.DEFAULT_INSTANCE;
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
                obj2 = new b0();
                return obj2;
            case 2:
                obj2 = new b0.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "streamToken_";
                obj2[2] = "writeResults_";
                obj2[3] = c0.class;
                obj2[4] = "commitTime_";
                return z.newMessageInfo(b0.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\n\u0003\u001b\u0004\t", obj2);
            case 4:
                return b0.DEFAULT_INSTANCE;
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
        obj3 = b0.class;
        synchronized (obj3) {
            obj2 = new z.b(b0.DEFAULT_INSTANCE);
            b0.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public j e() {
        return this.streamToken_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.c0 f(int i) {
        return (c0)this.writeResults_.get(i);
    }

    @Override // com.google.protobuf.z
    public int g() {
        return this.writeResults_.size();
    }
}
