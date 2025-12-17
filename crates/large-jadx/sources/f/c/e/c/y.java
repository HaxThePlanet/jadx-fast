package f.c.e.c;

import android.accounts.Account;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class y extends z<f.c.e.c.y, f.c.e.c.y.b> implements f.c.e.c.z {

    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final f.c.e.c.y DEFAULT_INSTANCE = null;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile d1<f.c.e.c.y> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int UPDATE_TRANSFORMS_FIELD_NUMBER = 7;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private f.c.e.c.s currentDocument_;
    private int operationCase_ = 0;
    private Object operation_;
    private f.c.e.c.k updateMask_;
    private c0.j<f.c.e.c.m.c> updateTransforms_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            y.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            y.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            y.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            y.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            y.a.a[z.f.GET_PARSER.ordinal()] = 5;
            y.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            y.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c {

        UPDATE(true),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(false);

        private final int value;
        public static f.c.e.c.y.c forNumber(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 5 && i != 6) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 5) {
                            if (i != 6) {
                                return null;
                            }
                            return y.c.TRANSFORM;
                        }
                        return y.c.VERIFY;
                    }
                    return y.c.DELETE;
                }
                return y.c.UPDATE;
            }
            return y.c.OPERATION_NOT_SET;
        }

        @Deprecated
        public static f.c.e.c.y.c valueOf(int i) {
            return y.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class b extends z.a<f.c.e.c.y, f.c.e.c.y.b> implements f.c.e.c.z {
        private b() {
            super(y.b());
        }

        b(f.c.e.c.y.a y$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.y.b b(f.c.e.c.m.c m$c) {
            copyOnWrite();
            y.d((y)this.instance, c);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.y.b c(f.c.e.c.s s) {
            copyOnWrite();
            y.f((y)this.instance, s);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.y.b d(String string) {
            copyOnWrite();
            y.g((y)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.y.b e(f.c.e.c.h h) {
            copyOnWrite();
            y.e((y)this.instance, h);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.y.b f(f.c.e.c.k k) {
            copyOnWrite();
            y.c((y)this.instance, k);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.y.b g(String string) {
            copyOnWrite();
            y.h((y)this.instance, string);
            return this;
        }
    }
    static {
        y yVar = new y();
        y.DEFAULT_INSTANCE = yVar;
        z.registerDefaultInstance(y.class, yVar);
    }

    private y() {
        super();
        int i = 0;
        this.updateTransforms_ = z.emptyProtobufList();
    }

    private void A(String string) {
        string.getClass();
        this.operationCase_ = 2;
        this.operation_ = string;
    }

    private void B(f.c.e.c.h h) {
        h.getClass();
        this.operation_ = h;
        this.operationCase_ = 1;
    }

    private void C(f.c.e.c.k k) {
        k.getClass();
        this.updateMask_ = k;
    }

    private void D(String string) {
        string.getClass();
        this.operationCase_ = 5;
        this.operation_ = string;
    }

    static f.c.e.c.y b() {
        return y.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.y y, f.c.e.c.k k2) {
        y.C(k2);
    }

    static void d(f.c.e.c.y y, f.c.e.c.m.c m$c2) {
        y.i(c2);
    }

    static void e(f.c.e.c.y y, f.c.e.c.h h2) {
        y.B(h2);
    }

    static void f(f.c.e.c.y y, f.c.e.c.s s2) {
        y.z(s2);
    }

    static void g(f.c.e.c.y y, String string2) {
        y.A(string2);
    }

    static void h(f.c.e.c.y y, String string2) {
        y.D(string2);
    }

    private void i(f.c.e.c.m.c m$c) {
        c.getClass();
        j();
        this.updateTransforms_.add(c);
    }

    private void j() {
        c0.j updateTransforms_;
        updateTransforms_ = this.updateTransforms_;
        if (!updateTransforms_.c2()) {
            this.updateTransforms_ = z.mutableCopy(updateTransforms_);
        }
    }

    public static f.c.e.c.y.b w() {
        return (y.b)y.DEFAULT_INSTANCE.createBuilder();
    }

    public static f.c.e.c.y.b x(f.c.e.c.y y) {
        return (y.b)y.DEFAULT_INSTANCE.createBuilder(y);
    }

    public static f.c.e.c.y y(byte[] bArr) {
        return (y)z.parseFrom(y.DEFAULT_INSTANCE, bArr);
    }

    private void z(f.c.e.c.s s) {
        s.getClass();
        this.currentDocument_ = s;
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
                obj2 = new y();
                return obj2;
            case 2:
                obj2 = new y.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[8];
                obj2[obj3] = "operationCase_";
                obj2[2] = h.class;
                obj2[3] = "updateMask_";
                obj2[4] = "currentDocument_";
                obj2[5] = m.class;
                obj2[6] = "updateTransforms_";
                obj2[7] = m.c.class;
                return z.newMessageInfo(y.DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\t\u0004\t\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", obj2);
            case 4:
                return y.DEFAULT_INSTANCE;
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
        obj3 = y.class;
        synchronized (obj3) {
            obj2 = new z.b(y.DEFAULT_INSTANCE);
            y.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.s k() {
        f.c.e.c.s currentDocument_;
        if (this.currentDocument_ == null) {
            currentDocument_ = s.f();
        }
        return currentDocument_;
    }

    @Override // com.google.protobuf.z
    public String l() {
        Object operation_;
        if (this.operationCase_ == 2) {
            operation_ = this.operation_;
        } else {
            operation_ = "";
        }
        return operation_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.y.c m() {
        return y.c.forNumber(this.operationCase_);
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.m n() {
        if (this.operationCase_ == 6) {
            return (m)this.operation_;
        }
        return m.c();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.h o() {
        if (this.operationCase_ == 1) {
            return (h)this.operation_;
        }
        return h.f();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.k p() {
        f.c.e.c.k updateMask_;
        if (this.updateMask_ == null) {
            updateMask_ = k.f();
        }
        return updateMask_;
    }

    public List<f.c.e.c.m.c> q() {
        return this.updateTransforms_;
    }

    @Override // com.google.protobuf.z
    public String r() {
        Object operation_;
        if (this.operationCase_ == 5) {
            operation_ = this.operation_;
        } else {
            operation_ = "";
        }
        return operation_;
    }

    @Override // com.google.protobuf.z
    public boolean s() {
        int i;
        i = this.currentDocument_ != null ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean t() {
        int i;
        i = this.operationCase_ == 6 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean u() {
        int i;
        if (this.operationCase_ == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean v() {
        int i;
        i = this.updateMask_ != null ? 1 : 0;
        return i;
    }
}
