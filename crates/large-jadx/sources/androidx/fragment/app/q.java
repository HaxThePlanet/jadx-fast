package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.e0;
import androidx.lifecycle.g0;
import androidx.lifecycle.g0.b;
import androidx.lifecycle.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class q extends e0 {

    private static final g0.b h;
    private final HashMap<String, androidx.fragment.app.Fragment> a;
    private final HashMap<String, androidx.fragment.app.q> b;
    private final HashMap<String, i0> c;
    private final boolean d;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;

    class a implements g0.b {
        public <T extends e0> T a(Class<T> class) {
            q obj2 = new q(1);
            return obj2;
        }
    }
    static {
        q.a aVar = new q.a();
        q.h = aVar;
    }

    q(boolean z) {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.b = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.c = hashMap3;
        int i = 0;
        this.d = z;
    }

    static androidx.fragment.app.q l(i0 i0) {
        g0 g0Var = new g0(i0, q.h);
        return (q)g0Var.a(q.class);
    }

    @Override // androidx.lifecycle.e0
    public boolean equals(Object object) {
        int i;
        HashMap equals;
        Class<androidx.fragment.app.q> obj;
        HashMap map;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (q.class != object.getClass()) {
            } else {
                if (this.a.equals(object.a) && this.b.equals(object.b) && this.c.equals(object.c)) {
                    if (this.b.equals(object.b)) {
                        if (this.c.equals(object.c)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.lifecycle.e0
    void h(androidx.fragment.app.Fragment fragment) {
        boolean stringBuilder;
        int str;
        boolean obj5;
        final String str2 = "FragmentManager";
        str = 2;
        if (this.g && n.I0(str)) {
            if (n.I0(str)) {
                Log.v(str2, "Ignoring addRetainedFragment as the state is already saved");
            }
        }
        if (this.a.containsKey(fragment.mWho)) {
        }
        this.a.put(fragment.mWho, fragment);
        if (n.I0(str)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Updating retained Fragments: Added ");
            stringBuilder.append(fragment);
            Log.v(str2, stringBuilder.toString());
        }
    }

    @Override // androidx.lifecycle.e0
    public int hashCode() {
        return i4 += i7;
    }

    @Override // androidx.lifecycle.e0
    void i(androidx.fragment.app.Fragment fragment) {
        boolean string;
        Object obj;
        Object obj2;
        String str;
        String mWho;
        Object obj3;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Clearing non-config state for ");
            stringBuilder.append(fragment);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        obj = this.b.get(fragment.mWho);
        if ((q)obj != null) {
            (q)obj.onCleared();
            this.b.remove(fragment.mWho);
        }
        obj2 = this.c.get(fragment.mWho);
        if ((i0)obj2 != null) {
            (i0)obj2.a();
            this.c.remove(fragment.mWho);
        }
    }

    @Override // androidx.lifecycle.e0
    androidx.fragment.app.Fragment j(String string) {
        return (Fragment)this.a.get(string);
    }

    @Override // androidx.lifecycle.e0
    androidx.fragment.app.q k(androidx.fragment.app.Fragment fragment) {
        Object qVar;
        Object mWho;
        Object obj3;
        if ((q)this.b.get(fragment.mWho) == null) {
            qVar = new q(this.d);
            this.b.put(fragment.mWho, qVar);
        }
        return qVar;
    }

    Collection<androidx.fragment.app.Fragment> m() {
        ArrayList arrayList = new ArrayList(this.a.values());
        return arrayList;
    }

    @Override // androidx.lifecycle.e0
    i0 n(androidx.fragment.app.Fragment fragment) {
        Object i0Var;
        Object mWho;
        Object obj3;
        if ((i0)this.c.get(fragment.mWho) == null) {
            i0Var = new i0();
            this.c.put(fragment.mWho, i0Var);
        }
        return i0Var;
    }

    @Override // androidx.lifecycle.e0
    boolean o() {
        return this.e;
    }

    @Override // androidx.lifecycle.e0
    protected void onCleared() {
        boolean string;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onCleared called for ");
            stringBuilder.append(this);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        this.e = true;
    }

    @Override // androidx.lifecycle.e0
    void p(androidx.fragment.app.Fragment fragment) {
        int stringBuilder;
        int str;
        boolean obj5;
        final String str2 = "FragmentManager";
        str = 2;
        if (this.g && n.I0(str)) {
            if (n.I0(str)) {
                Log.v(str2, "Ignoring removeRetainedFragment as the state is already saved");
            }
        }
        stringBuilder = this.a.remove(fragment.mWho) != null ? 1 : 0;
        if (stringBuilder != null && n.I0(str)) {
            if (n.I0(str)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Updating retained Fragments: Removed ");
                stringBuilder.append(fragment);
                Log.v(str2, stringBuilder.toString());
            }
        }
    }

    @Override // androidx.lifecycle.e0
    void q(boolean z) {
        this.g = z;
    }

    @Override // androidx.lifecycle.e0
    boolean r(androidx.fragment.app.Fragment fragment) {
        int i = 1;
        if (!this.a.containsKey(fragment.mWho)) {
            return i;
        }
        if (this.d) {
            return this.e;
        }
        return obj2 ^= i;
    }

    @Override // androidx.lifecycle.e0
    public String toString() {
        boolean next;
        boolean next2;
        boolean next3;
        String str;
        StringBuilder stringBuilder = new StringBuilder("FragmentManagerViewModel{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("} Fragments (");
        Iterator iterator = this.a.values().iterator();
        str = ", ";
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
            }
            str = ", ";
            stringBuilder.append(str);
        }
        stringBuilder.append(") Child Non Config (");
        Iterator iterator2 = this.b.keySet().iterator();
        while (iterator2.hasNext()) {
            stringBuilder.append((String)iterator2.next());
            if (iterator2.hasNext()) {
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(") ViewModelStores (");
        Iterator iterator3 = this.c.keySet().iterator();
        while (iterator3.hasNext()) {
            stringBuilder.append((String)iterator3.next());
            if (iterator3.hasNext()) {
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
