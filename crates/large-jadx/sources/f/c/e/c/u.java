package f.c.e.c;

import android.accounts.Account;
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
public final class u extends z<f.c.e.c.u, f.c.e.c.u.b> implements u0 {

    private static final f.c.e.c.u DEFAULT_INSTANCE = null;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile d1<f.c.e.c.u> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private boolean once_;
    private int resumeTypeCase_ = 0;
    private Object resumeType_;
    private int targetId_;
    private int targetTypeCase_ = 0;
    private Object targetType_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            u.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            u.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            u.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            u.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            u.a.a[z.f.GET_PARSER.ordinal()] = 5;
            u.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            u.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.u, f.c.e.c.u.b> implements u0 {
        private b() {
            super(u.b());
        }

        b(f.c.e.c.u.a u$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.u.b b(f.c.e.c.u.c u$c) {
            copyOnWrite();
            u.d((u)this.instance, c);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.u.b c(f.c.e.c.u.d u$d) {
            copyOnWrite();
            u.c((u)this.instance, d);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.u.b d(r1 r1) {
            copyOnWrite();
            u.f((u)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.u.b e(j j) {
            copyOnWrite();
            u.e((u)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.u.b f(int i) {
            copyOnWrite();
            u.g((u)this.instance, i);
            return this;
        }
    }

    public static final class c extends z<f.c.e.c.u.c, f.c.e.c.u.c.a> implements u0 {

        private static final f.c.e.c.u.c DEFAULT_INSTANCE = null;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile d1<f.c.e.c.u.c> PARSER;
        private c0.j<String> documents_;
        static {
            u.c cVar = new u.c();
            u.c.DEFAULT_INSTANCE = cVar;
            z.registerDefaultInstance(u.c.class, cVar);
        }

        private c() {
            super();
            this.documents_ = z.emptyProtobufList();
        }

        static f.c.e.c.u.c b() {
            return u.c.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.u.c u$c, String string2) {
            c.d(string2);
        }

        private void d(String string) {
            string.getClass();
            e();
            this.documents_.add(string);
        }

        private void e() {
            c0.j mutableCopy;
            mutableCopy = this.documents_;
            if (!mutableCopy.c2()) {
                this.documents_ = z.mutableCopy(mutableCopy);
            }
        }

        public static f.c.e.c.u.c f() {
            return u.c.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.u.c.a i() {
            return (u.c.a)u.c.DEFAULT_INSTANCE.createBuilder();
        }

        public static f.c.e.c.u.c.a j(f.c.e.c.u.c u$c) {
            return (u.c.a)u.c.DEFAULT_INSTANCE.createBuilder(c);
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj1;
            int obj2;
            int obj3;
            obj2 = 1;
            obj3 = 0;
            switch (obj1) {
                case 1:
                    obj1 = new u.c();
                    return obj1;
                case 2:
                    obj1 = new u.c.a(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "documents_";
                    return z.newMessageInfo(u.c.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", obj1);
                case 4:
                    return u.c.DEFAULT_INSTANCE;
                case 5:
                    return obj1;
                case 6:
                    return Byte.valueOf(obj2);
                case 7:
                    return obj3;
                default:
                    obj1 = new UnsupportedOperationException();
                    throw obj1;
            }
            obj2 = u.c.class;
            synchronized (obj2) {
                obj1 = new z.b(u.c.DEFAULT_INSTANCE);
                u.c.PARSER = obj1;
            }
        }

        @Override // com.google.protobuf.z
        public String g(int i) {
            return (String)this.documents_.get(i);
        }

        @Override // com.google.protobuf.z
        public int h() {
            return this.documents_.size();
        }
    }

    public static final class d extends z<f.c.e.c.u.d, f.c.e.c.u.d.a> implements u0 {

        private static final f.c.e.c.u.d DEFAULT_INSTANCE = null;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile d1<f.c.e.c.u.d> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private String parent_;
        private int queryTypeCase_ = 0;
        private Object queryType_;
        static {
            u.d dVar = new u.d();
            u.d.DEFAULT_INSTANCE = dVar;
            z.registerDefaultInstance(u.d.class, dVar);
        }

        private d() {
            super();
            int i = 0;
            this.parent_ = "";
        }

        static void b(f.c.e.c.u.d u$d, f.c.e.c.t t2) {
            d.k(t2);
        }

        static f.c.e.c.u.d c() {
            return u.d.DEFAULT_INSTANCE;
        }

        static void d(f.c.e.c.u.d u$d, String string2) {
            d.j(string2);
        }

        public static f.c.e.c.u.d e() {
            return u.d.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.u.d.a h() {
            return (u.d.a)u.d.DEFAULT_INSTANCE.createBuilder();
        }

        public static f.c.e.c.u.d.a i(f.c.e.c.u.d u$d) {
            return (u.d.a)u.d.DEFAULT_INSTANCE.createBuilder(d);
        }

        private void j(String string) {
            string.getClass();
            this.parent_ = string;
        }

        private void k(f.c.e.c.t t) {
            t.getClass();
            this.queryType_ = t;
            this.queryTypeCase_ = 2;
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
                    obj2 = new u.d();
                    return obj2;
                case 2:
                    obj2 = new u.d.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[4];
                    obj2[obj3] = "queryTypeCase_";
                    obj2[2] = "parent_";
                    obj2[3] = t.class;
                    return z.newMessageInfo(u.d.DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", obj2);
                case 4:
                    return u.d.DEFAULT_INSTANCE;
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
            obj3 = u.d.class;
            synchronized (obj3) {
                obj2 = new z.b(u.d.DEFAULT_INSTANCE);
                u.d.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public String f() {
            return this.parent_;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t g() {
            if (this.queryTypeCase_ == 2) {
                return (t)this.queryType_;
            }
            return t.m();
        }
    }
    static {
        u uVar = new u();
        u.DEFAULT_INSTANCE = uVar;
        z.registerDefaultInstance(u.class, uVar);
    }

    private u() {
        super();
        final int i = 0;
    }

    static f.c.e.c.u b() {
        return u.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.u u, f.c.e.c.u.d u$d2) {
        u.setQuery(d2);
    }

    static void d(f.c.e.c.u u, f.c.e.c.u.c u$c2) {
        u.setDocuments(c2);
    }

    static void e(f.c.e.c.u u, j j2) {
        u.setResumeToken(j2);
    }

    static void f(f.c.e.c.u u, r1 r12) {
        u.setReadTime(r12);
    }

    static void g(f.c.e.c.u u, int i2) {
        u.setTargetId(i2);
    }

    public static f.c.e.c.u.b h() {
        return (u.b)u.DEFAULT_INSTANCE.createBuilder();
    }

    private void setDocuments(f.c.e.c.u.c u$c) {
        c.getClass();
        this.targetType_ = c;
        this.targetTypeCase_ = 3;
    }

    private void setQuery(f.c.e.c.u.d u$d) {
        d.getClass();
        this.targetType_ = d;
        this.targetTypeCase_ = 2;
    }

    private void setReadTime(r1 r1) {
        r1.getClass();
        this.resumeType_ = r1;
        this.resumeTypeCase_ = 11;
    }

    private void setResumeToken(j j) {
        j.getClass();
        this.resumeTypeCase_ = 4;
        this.resumeType_ = j;
    }

    private void setTargetId(int i) {
        this.targetId_ = i;
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
                obj2 = new u();
                return obj2;
            case 2:
                obj2 = new u.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[9];
                obj2[obj3] = "targetTypeCase_";
                obj2[2] = "resumeType_";
                obj2[3] = "resumeTypeCase_";
                obj2[4] = u.d.class;
                obj2[5] = u.c.class;
                obj2[6] = "targetId_";
                obj2[7] = "once_";
                obj2[8] = r1.class;
                return z.newMessageInfo(u.DEFAULT_INSTANCE, "\u0000\u0006\u0002\u0000\u0002\u000b\u0006\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001", obj2);
            case 4:
                return u.DEFAULT_INSTANCE;
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
        obj3 = u.class;
        synchronized (obj3) {
            obj2 = new z.b(u.DEFAULT_INSTANCE);
            u.PARSER = obj2;
        }
    }
}
