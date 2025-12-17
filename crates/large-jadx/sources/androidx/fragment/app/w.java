package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.j.c;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class w {

    ArrayList<androidx.fragment.app.w.a> a;
    int b;
    int c;
    int d;
    int e;
    int f;
    boolean g;
    boolean h = true;
    String i;
    int j;
    java.lang.CharSequence k;
    int l;
    java.lang.CharSequence m;
    ArrayList<String> n;
    ArrayList<String> o;
    boolean p = false;
    ArrayList<Runnable> q;

    static final class a {

        int a;
        androidx.fragment.app.Fragment b;
        int c;
        int d;
        int e;
        int f;
        j.c g;
        j.c h;
        a(int i, androidx.fragment.app.Fragment fragment2) {
            super();
            this.a = i;
            this.b = fragment2;
            final j.c obj1 = j.c.RESUMED;
            this.g = obj1;
            this.h = obj1;
        }
    }
    w(androidx.fragment.app.j j, java.lang.ClassLoader classLoader2) {
        super();
        ArrayList obj1 = new ArrayList();
        this.a = obj1;
        obj1 = 1;
        obj1 = 0;
    }

    public androidx.fragment.app.w b(int i, androidx.fragment.app.Fragment fragment2, String string3) {
        l(i, fragment2, string3, 1);
        return this;
    }

    androidx.fragment.app.w c(ViewGroup viewGroup, androidx.fragment.app.Fragment fragment2, String string3) {
        fragment2.mContainer = viewGroup;
        b(viewGroup.getId(), fragment2, string3);
        return this;
    }

    public androidx.fragment.app.w d(androidx.fragment.app.Fragment fragment, String string2) {
        l(0, fragment, string2, 1);
        return this;
    }

    void e(androidx.fragment.app.w.a w$a) {
        this.a.add(a);
        a.c = this.b;
        a.d = this.c;
        a.e = this.d;
        a.f = this.e;
    }

    public androidx.fragment.app.w f(String string) {
        if (!this.h) {
        } else {
            this.g = true;
            this.i = string;
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        throw obj2;
    }

    public abstract int g();

    public abstract int h();

    public abstract void i();

    public abstract void j();

    public androidx.fragment.app.w k() {
        if (this.g) {
        } else {
            this.h = false;
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This transaction is already being added to the back stack");
        throw illegalStateException;
    }

    void l(int i, androidx.fragment.app.Fragment fragment2, String string3, int i4) {
        int modifiers;
        boolean anonymousClass;
        String obj6;
        Class class = fragment2.getClass();
        modifiers = class.getModifiers();
        if (class.isAnonymousClass()) {
        } else {
            if (!Modifier.isPublic(modifiers)) {
            } else {
                if (class.isMemberClass() && Modifier.isStatic(modifiers)) {
                    if (!Modifier.isStatic(modifiers)) {
                    } else {
                        String str = " now ";
                        String str3 = ": was ";
                        anonymousClass = fragment2.mTag;
                        if (string3 != null && anonymousClass != null) {
                            anonymousClass = fragment2.mTag;
                            if (anonymousClass != null) {
                                if (!string3.equals(anonymousClass)) {
                                } else {
                                }
                                StringBuilder obj7 = new StringBuilder();
                                obj7.append("Can't change tag of fragment ");
                                obj7.append(fragment2);
                                obj7.append(str3);
                                obj7.append(fragment2.mTag);
                                obj7.append(str);
                                obj7.append(string3);
                                IllegalStateException obj4 = new IllegalStateException(obj7.toString());
                                throw obj4;
                            }
                            fragment2.mTag = string3;
                        }
                        if (i != 0) {
                            if (i == -1) {
                            } else {
                                obj6 = fragment2.mFragmentId;
                                if (obj6 != null) {
                                    if (obj6 != i) {
                                    } else {
                                    }
                                    obj7 = new StringBuilder();
                                    obj7.append("Can't change container ID of fragment ");
                                    obj7.append(fragment2);
                                    obj7.append(str3);
                                    obj7.append(fragment2.mFragmentId);
                                    obj7.append(str);
                                    obj7.append(i);
                                    obj6 = new IllegalStateException(obj7.toString());
                                    throw obj6;
                                }
                                fragment2.mFragmentId = i;
                                fragment2.mContainerId = i;
                            }
                            obj7 = new StringBuilder();
                            obj7.append("Can't add fragment ");
                            obj7.append(fragment2);
                            obj7.append(" with tag ");
                            obj7.append(string3);
                            obj7.append(" to container view with no id");
                            obj4 = new IllegalArgumentException(obj7.toString());
                            throw obj4;
                        }
                    }
                } else {
                }
                obj4 = new w.a(i4, fragment2);
                e(obj4);
            }
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("Fragment ");
        obj5.append(class.getCanonicalName());
        obj5.append(" must be a public static class to be  properly recreated from instance state.");
        obj4 = new IllegalStateException(obj5.toString());
        throw obj4;
    }

    public androidx.fragment.app.w m(androidx.fragment.app.Fragment fragment) {
        w.a aVar = new w.a(4, fragment);
        e(aVar);
        return this;
    }

    public androidx.fragment.app.w n(androidx.fragment.app.Fragment fragment) {
        w.a aVar = new w.a(3, fragment);
        e(aVar);
        return this;
    }

    public androidx.fragment.app.w o(int i, androidx.fragment.app.Fragment fragment2) {
        p(i, fragment2, 0);
        return this;
    }

    public androidx.fragment.app.w p(int i, androidx.fragment.app.Fragment fragment2, String string3) {
        if (i == 0) {
        } else {
            l(i, fragment2, string3, 2);
            return this;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Must use non-zero containerViewId");
        throw obj2;
    }

    public androidx.fragment.app.w q(int i, int i2) {
        final int i3 = 0;
        r(i, i2, i3, i3);
        return this;
    }

    public androidx.fragment.app.w r(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        return this;
    }

    public androidx.fragment.app.w s(boolean z) {
        this.p = z;
        return this;
    }

    public androidx.fragment.app.w t(androidx.fragment.app.Fragment fragment) {
        w.a aVar = new w.a(5, fragment);
        e(aVar);
        return this;
    }
}
