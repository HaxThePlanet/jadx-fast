package f.c.e.c;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
import com.google.protobuf.c0.g;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.g.a;
import java.util.List;

/* loaded from: classes2.dex */
public final class v extends z<f.c.e.c.v, f.c.e.c.v.b> implements u0 {

    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final f.c.e.c.v DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.v> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private a cause_;
    private r1 readTime_;
    private j resumeToken_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private c0.g targetIds_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            v.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            v.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            v.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            v.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            v.a.a[z.f.GET_PARSER.ordinal()] = 5;
            v.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            v.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c implements c0.c {

        NO_CHANGE(false),
        ADD(true),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);

        private final int value;
        public static f.c.e.c.v.c forNumber(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return v.c.RESET;
                        }
                        return v.c.CURRENT;
                    }
                    return v.c.REMOVE;
                }
                return v.c.ADD;
            }
            return v.c.NO_CHANGE;
        }

        public static c0.d<f.c.e.c.v.c> internalGetValueMap() {
            return v.c.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return v.c.b.a;
        }

        @Deprecated
        public static f.c.e.c.v.c valueOf(int i) {
            return v.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == v.c.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public static final class b extends z.a<f.c.e.c.v, f.c.e.c.v.b> implements u0 {
        private b() {
            super(v.b());
        }

        b(f.c.e.c.v.a v$a) {
            super();
        }
    }
    static {
        v vVar = new v();
        v.DEFAULT_INSTANCE = vVar;
        z.registerDefaultInstance(v.class, vVar);
    }

    private v() {
        super();
        int i = -1;
        this.targetIds_ = z.emptyIntList();
        this.resumeToken_ = j.a;
    }

    static f.c.e.c.v b() {
        return v.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.v d() {
        return v.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public a c() {
        a cause_;
        if (this.cause_ == null) {
            cause_ = a.d();
        }
        return cause_;
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
                obj2 = new v();
                return obj2;
            case 2:
                obj2 = new v.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "targetIds_";
                obj2[2] = "cause_";
                obj2[3] = "resumeToken_";
                obj2[4] = "readTime_";
                return z.newMessageInfo(v.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0006\u0005\u0000\u0001\u0000\u0001\u000c\u0002'\u0003\t\u0004\n\u0006\t", obj2);
            case 4:
                return v.DEFAULT_INSTANCE;
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
        obj3 = v.class;
        synchronized (obj3) {
            obj2 = new z.b(v.DEFAULT_INSTANCE);
            v.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.v.c e() {
        f.c.e.c.v.c uNRECOGNIZED;
        if (v.c.forNumber(this.targetChangeType_) == null) {
            uNRECOGNIZED = v.c.UNRECOGNIZED;
        }
        return uNRECOGNIZED;
    }

    @Override // com.google.protobuf.z
    public int f() {
        return this.targetIds_.size();
    }

    public List<Integer> g() {
        return this.targetIds_;
    }

    @Override // com.google.protobuf.z
    public r1 getReadTime() {
        r1 readTime_;
        if (this.readTime_ == null) {
            readTime_ = r1.e();
        }
        return readTime_;
    }

    @Override // com.google.protobuf.z
    public j getResumeToken() {
        return this.resumeToken_;
    }
}
