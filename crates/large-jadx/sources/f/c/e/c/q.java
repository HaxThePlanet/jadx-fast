package f.c.e.c;

import android.accounts.Account;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class q extends z<f.c.e.c.q, f.c.e.c.q.b> implements u0 {

    private static final f.c.e.c.q DEFAULT_INSTANCE = null;
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 5;
    private static volatile d1<f.c.e.c.q> PARSER = null;
    public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            q.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            q.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            q.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            q.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            q.a.a[z.f.GET_PARSER.ordinal()] = 5;
            q.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            q.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c {

        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(false);

        private final int value;
        public static f.c.e.c.q.c forNumber(int i) {
            if (i != 0 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    return null;
                                }
                                return q.c.DOCUMENT_REMOVE;
                            }
                            return q.c.FILTER;
                        }
                        return q.c.DOCUMENT_DELETE;
                    }
                    return q.c.DOCUMENT_CHANGE;
                }
                return q.c.TARGET_CHANGE;
            }
            return q.c.RESPONSETYPE_NOT_SET;
        }

        @Deprecated
        public static f.c.e.c.q.c valueOf(int i) {
            return q.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class b extends z.a<f.c.e.c.q, f.c.e.c.q.b> implements u0 {
        private b() {
            super(q.b());
        }

        b(f.c.e.c.q.a q$a) {
            super();
        }
    }
    static {
        q qVar = new q();
        q.DEFAULT_INSTANCE = qVar;
        z.registerDefaultInstance(q.class, qVar);
    }

    private q() {
        super();
        final int i = 0;
    }

    static f.c.e.c.q b() {
        return q.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.q c() {
        return q.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.i d() {
        if (this.responseTypeCase_ == 3) {
            return (i)this.responseType_;
        }
        return i.c();
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
                obj2 = new q();
                return obj2;
            case 2:
                obj2 = new q.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[7];
                obj2[obj3] = "responseTypeCase_";
                obj2[2] = v.class;
                obj2[3] = i.class;
                obj2[4] = j.class;
                obj2[5] = n.class;
                obj2[6] = l.class;
                return z.newMessageInfo(q.DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0002\u0006\u0005\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", obj2);
            case 4:
                return q.DEFAULT_INSTANCE;
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
        obj3 = q.class;
        synchronized (obj3) {
            obj2 = new z.b(q.DEFAULT_INSTANCE);
            q.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.j e() {
        if (this.responseTypeCase_ == 4) {
            return (j)this.responseType_;
        }
        return j.c();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.l f() {
        if (this.responseTypeCase_ == 6) {
            return (l)this.responseType_;
        }
        return l.c();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.n g() {
        if (this.responseTypeCase_ == 5) {
            return (n)this.responseType_;
        }
        return n.c();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.q.c h() {
        return q.c.forNumber(this.responseTypeCase_);
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.v i() {
        if (this.responseTypeCase_ == 2) {
            return (v)this.responseType_;
        }
        return v.d();
    }
}
