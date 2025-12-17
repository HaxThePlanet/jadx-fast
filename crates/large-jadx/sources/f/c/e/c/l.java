package f.c.e.c;

import com.google.protobuf.c0.g;
import com.google.protobuf.d1;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class l extends z<f.c.e.c.l, f.c.e.c.l.b> implements u0 {

    private static final f.c.e.c.l DEFAULT_INSTANCE = null;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.c.l> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 2;
    private String document_;
    private r1 readTime_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private c0.g removedTargetIds_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            l.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            l.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            l.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            l.a.a[z.f.GET_PARSER.ordinal()] = 5;
            l.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            l.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.l, f.c.e.c.l.b> implements u0 {
        private b() {
            super(l.b());
        }

        b(f.c.e.c.l.a l$a) {
            super();
        }
    }
    static {
        l lVar = new l();
        l.DEFAULT_INSTANCE = lVar;
        z.registerDefaultInstance(l.class, lVar);
    }

    private l() {
        super();
        int i = -1;
        this.document_ = "";
        this.removedTargetIds_ = z.emptyIntList();
    }

    static f.c.e.c.l b() {
        return l.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.l c() {
        return l.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public String d() {
        return this.document_;
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
                obj2 = new l();
                return obj2;
            case 2:
                obj2 = new l.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "removedTargetIds_";
                obj2[2] = "readTime_";
                return z.newMessageInfo(l.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0004\u0003\u0000\u0001\u0000\u0001Ȉ\u0002'\u0004\t", obj2);
            case 4:
                return l.DEFAULT_INSTANCE;
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
        obj3 = l.class;
        synchronized (obj3) {
            obj2 = new z.b(l.DEFAULT_INSTANCE);
            l.PARSER = obj2;
        }
    }

    public List<Integer> e() {
        return this.removedTargetIds_;
    }
}
