package androidx.versionedparcelable;

import android.os.Parcelable;
import d.e.a;
import d.e.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class VersionedParcel {

    protected final a<String, Method> a;
    protected final a<String, Method> b;
    protected final a<String, Class> c;

    public static class ParcelException extends RuntimeException {
    }
    public VersionedParcel(a<String, Method> a, a<String, Method> a2, a<String, Class> a3) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
    }

    private void N(androidx.versionedparcelable.c c) {
        try {
            I(c(c.getClass()).getName());
            StringBuilder stringBuilder = new StringBuilder();
            c = c.getClass();
            c = c.getSimpleName();
            stringBuilder.append(c);
            c = " does not have a Parcelizer";
            stringBuilder.append(c);
            c = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(c, th);
            throw runtimeException;
        }
    }

    private Class c(Class<? extends androidx.versionedparcelable.c> class) {
        Object forName;
        Object name;
        int i;
        String simpleName;
        String obj5;
        if ((Class)this.c.get(class.getName()) == null) {
            Object[] arr = new Object[2];
            i = 0;
            arr[i] = class.getPackage().getName();
            arr[1] = class.getSimpleName();
            this.c.put(class.getName(), Class.forName(String.format("%s.%sParcelizer", arr), i, class.getClassLoader()));
        }
        return forName;
    }

    private Method d(String string) {
        Class<androidx.versionedparcelable.VersionedParcel> obj;
        Object declaredMethod;
        Class[] arr;
        int i;
        obj = VersionedParcel.class;
        if ((Method)this.a.get(string) == null) {
            System.currentTimeMillis();
            int i2 = 1;
            arr = new Class[i2];
            arr[0] = obj;
            this.a.put(string, Class.forName(string, i2, obj.getClassLoader()).getDeclaredMethod("read", arr));
        }
        return declaredMethod;
    }

    private Method e(Class class) {
        Object declaredMethod;
        Object name;
        String str;
        Class<androidx.versionedparcelable.VersionedParcel> obj;
        Object obj5;
        if ((Method)this.b.get(class.getName()) == null) {
            System.currentTimeMillis();
            Class[] arr = new Class[2];
            this.b.put(class.getName(), c(class).getDeclaredMethod("write", class, VersionedParcel.class));
        }
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    protected abstract void C(java.lang.CharSequence charSequence);

    public void D(java.lang.CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    protected abstract void E(int i);

    public void F(int i, int i2) {
        w(i2);
        E(i);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    protected abstract void I(String string);

    public void J(String string, int i2) {
        w(i2);
        I(string);
    }

    protected <T extends androidx.versionedparcelable.c> void K(T t, androidx.versionedparcelable.VersionedParcel versionedParcel2) {
        try {
            Object[] arr = new Object[2];
            e(t.getClass()).invoke(0, t, versionedParcel2);
            String str = "VersionedParcel encountered ClassNotFoundException";
            versionedParcel2 = new RuntimeException(str, t);
            throw versionedParcel2;
            str = "VersionedParcel encountered NoSuchMethodException";
            versionedParcel2 = new RuntimeException(str, t);
            throw versionedParcel2;
            versionedParcel2 = t.getCause();
            versionedParcel2 = versionedParcel2 instanceof RuntimeException;
            if (versionedParcel2 != null) {
            }
            t = t.getCause();
            throw (RuntimeException)t;
            str = "VersionedParcel encountered InvocationTargetException";
            versionedParcel2 = new RuntimeException(str, t);
            throw versionedParcel2;
            str = "VersionedParcel encountered IllegalAccessException";
            versionedParcel2 = new RuntimeException(str, t);
            throw versionedParcel2;
        }
    }

    protected void L(androidx.versionedparcelable.c c) {
        if (c == null) {
            I(0);
        }
        N(c);
        final androidx.versionedparcelable.VersionedParcel versionedParcel = b();
        K(c, versionedParcel);
        versionedParcel.a();
    }

    public void M(androidx.versionedparcelable.c c, int i2) {
        w(i2);
        L(c);
    }

    protected abstract void a();

    protected abstract androidx.versionedparcelable.VersionedParcel b();

    public boolean f() {
        return 0;
    }

    protected abstract boolean g();

    public boolean h(boolean z, int i2) {
        if (!m(i2)) {
            return z;
        }
        return g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        if (!m(i2)) {
            return bArr;
        }
        return i();
    }

    protected abstract java.lang.CharSequence k();

    public java.lang.CharSequence l(java.lang.CharSequence charSequence, int i2) {
        if (!m(i2)) {
            return charSequence;
        }
        return k();
    }

    protected abstract boolean m(int i);

    protected <T extends androidx.versionedparcelable.c> T n(String string, androidx.versionedparcelable.VersionedParcel versionedParcel2) {
        try {
            Object[] arr = new Object[1];
            return (c)d(string).invoke(0, versionedParcel2);
            String str = "VersionedParcel encountered ClassNotFoundException";
            versionedParcel2 = new RuntimeException(str, string);
            throw versionedParcel2;
            str = "VersionedParcel encountered NoSuchMethodException";
            versionedParcel2 = new RuntimeException(str, string);
            throw versionedParcel2;
            versionedParcel2 = string.getCause();
            versionedParcel2 = versionedParcel2 instanceof RuntimeException;
            if (versionedParcel2 != null) {
            }
            string = string.getCause();
            throw (RuntimeException)string;
            str = "VersionedParcel encountered InvocationTargetException";
            versionedParcel2 = new RuntimeException(str, string);
            throw versionedParcel2;
            str = "VersionedParcel encountered IllegalAccessException";
            versionedParcel2 = new RuntimeException(str, string);
            throw versionedParcel2;
        }
    }

    protected abstract int o();

    public int p(int i, int i2) {
        if (!m(i2)) {
            return i;
        }
        return o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t, int i2) {
        if (!m(i2)) {
            return t;
        }
        return q();
    }

    protected abstract String s();

    public String t(String string, int i2) {
        if (!m(i2)) {
            return string;
        }
        return s();
    }

    protected <T extends androidx.versionedparcelable.c> T u() {
        String str = s();
        if (str == null) {
            return 0;
        }
        return n(str, b());
    }

    public <T extends androidx.versionedparcelable.c> T v(T t, int i2) {
        if (!m(i2)) {
            return t;
        }
        return u();
    }

    protected abstract void w(int i);

    public void x(boolean z, boolean z2) {
    }

    protected abstract void y(boolean z);

    public void z(boolean z, int i2) {
        w(i2);
        y(z);
    }
}
