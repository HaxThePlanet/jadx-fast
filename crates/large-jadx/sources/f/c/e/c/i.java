package f.c.e.c;

import com.google.protobuf.c0.g;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class i extends z<f.c.e.c.i, f.c.e.c.i.b> implements u0 {

    private static final f.c.e.c.i DEFAULT_INSTANCE = null;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.c.i> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private f.c.e.c.h document_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private c0.g removedTargetIds_;
    private int targetIdsMemoizedSerializedSize = -1;
    private c0.g targetIds_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            i.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            i.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            i.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            i.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            i.a.a[z.f.GET_PARSER.ordinal()] = 5;
            i.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            i.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.i, f.c.e.c.i.b> implements u0 {
        private b() {
            super(i.b());
        }

        b(f.c.e.c.i.a i$a) {
            super();
        }
    }
    static {
        i iVar = new i();
        i.DEFAULT_INSTANCE = iVar;
        z.registerDefaultInstance(i.class, iVar);
    }

    private i() {
        super();
        int i = -1;
        this.targetIds_ = z.emptyIntList();
        this.removedTargetIds_ = z.emptyIntList();
    }

    static f.c.e.c.i b() {
        return i.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.i c() {
        return i.DEFAULT_INSTANCE;
    }

    public List<Integer> d() {
        return this.removedTargetIds_;
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
                obj2 = new i();
                return obj2;
            case 2:
                obj2 = new i.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "targetIds_";
                obj2[2] = "removedTargetIds_";
                return z.newMessageInfo(i.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0006\u0003\u0000\u0002\u0000\u0001\t\u0005'\u0006'", obj2);
            case 4:
                return i.DEFAULT_INSTANCE;
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
        obj3 = i.class;
        synchronized (obj3) {
            obj2 = new z.b(i.DEFAULT_INSTANCE);
            i.PARSER = obj2;
        }
    }

    public List<Integer> e() {
        return this.targetIds_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.h getDocument() {
        f.c.e.c.h document_;
        if (this.document_ == null) {
            document_ = h.f();
        }
        return document_;
    }
}
