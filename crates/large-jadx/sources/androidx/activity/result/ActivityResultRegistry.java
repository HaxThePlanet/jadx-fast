package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.f.a;
import androidx.core.app.b;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    private Random a;
    private final Map<Integer, String> b;
    final Map<String, Integer> c;
    private final Map<String, androidx.activity.result.ActivityResultRegistry.d> d;
    ArrayList<String> e;
    final transient Map<String, androidx.activity.result.ActivityResultRegistry.c<?>> f;
    final Map<String, Object> g;
    final Bundle h;

    private static class c {

        final androidx.activity.result.b<O> a;
        final a<?, O> b;
        c(androidx.activity.result.b<O> b, a<?, O> a2) {
            super();
            this.a = b;
            this.b = a2;
        }
    }

    private static class d {

        final j a;
        private final ArrayList<n> b;
        d(j j) {
            super();
            this.a = j;
            ArrayList obj1 = new ArrayList();
            this.b = obj1;
        }

        void a(n n) {
            this.a.a(n);
            this.b.add(n);
        }

        void b() {
            Object next;
            j jVar;
            Iterator iterator = this.b.iterator();
            for (n next : iterator) {
                this.a.c(next);
            }
            this.b.clear();
        }
    }

    class a extends androidx.activity.result.c<I> {

        final String a;
        final int b;
        final a c;
        final androidx.activity.result.ActivityResultRegistry d;
        a(androidx.activity.result.ActivityResultRegistry activityResultRegistry, String string2, int i3, a a4) {
            this.d = activityResultRegistry;
            this.a = string2;
            this.b = i3;
            this.c = a4;
            super();
        }

        public void b(I i, b b2) {
            int intValue;
            activity.e.add(this.a);
            Object obj = activity2.c.get(this.a);
            if ((Integer)obj != null) {
                intValue = (Integer)obj.intValue();
            } else {
                intValue = this.b;
            }
            this.d.f(intValue, this.c, i, b2);
        }

        @Override // androidx.activity.result.c
        public void c() {
            this.d.l(this.a);
        }
    }

    class b extends androidx.activity.result.c<I> {

        final String a;
        final int b;
        final a c;
        final androidx.activity.result.ActivityResultRegistry d;
        b(androidx.activity.result.ActivityResultRegistry activityResultRegistry, String string2, int i3, a a4) {
            this.d = activityResultRegistry;
            this.a = string2;
            this.b = i3;
            this.c = a4;
            super();
        }

        public void b(I i, b b2) {
            int intValue;
            activity.e.add(this.a);
            Object obj = activity2.c.get(this.a);
            if ((Integer)obj != null) {
                intValue = (Integer)obj.intValue();
            } else {
                intValue = this.b;
            }
            this.d.f(intValue, this.c, i, b2);
        }

        @Override // androidx.activity.result.c
        public void c() {
            this.d.l(this.a);
        }
    }
    public ActivityResultRegistry() {
        super();
        Random random = new Random();
        this.a = random;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.d = hashMap3;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        HashMap hashMap4 = new HashMap();
        this.f = hashMap4;
        HashMap hashMap5 = new HashMap();
        this.g = hashMap5;
        Bundle bundle = new Bundle();
        this.h = bundle;
    }

    private void a(int i, String string2) {
        this.b.put(Integer.valueOf(i), string2);
        this.c.put(string2, Integer.valueOf(i));
    }

    private <O> void d(String string, int i2, Intent intent3, androidx.activity.result.ActivityResultRegistry.c<O> activityResultRegistry$c4) {
        androidx.activity.result.b aVar;
        Object obj2;
        Object obj5;
        aVar = c4.a;
        if (c4 != null && aVar != null) {
            aVar = c4.a;
            if (aVar != null) {
                aVar.a(c4.b.c(i2, intent3));
            } else {
                this.g.remove(string);
                aVar = new a(i2, intent3);
                this.h.putParcelable(string, aVar);
            }
        } else {
        }
    }

    private int e() {
        int nextInt;
        boolean key;
        Integer valueOf;
        final int i2 = 2147418112;
        nextInt = this.a.nextInt(i2);
        nextInt += i3;
        while (this.b.containsKey(Integer.valueOf(i))) {
            nextInt = this.a.nextInt(i2);
            nextInt += i3;
        }
        return i;
    }

    private int k(String string) {
        Object obj = this.c.get(string);
        if ((Integer)obj != null) {
            return (Integer)obj.intValue();
        }
        int i = e();
        a(i, string);
        return i;
    }

    public final boolean b(int i, int i2, Intent intent3) {
        Object obj2 = this.b.get(Integer.valueOf(i));
        if ((String)obj2 == null) {
            return 0;
        }
        this.e.remove((String)obj2);
        d(obj2, i2, intent3, (ActivityResultRegistry.c)this.f.get(obj2));
        return 1;
    }

    public final <O> boolean c(int i, O o2) {
        Object obj;
        Object obj2 = this.b.get(Integer.valueOf(i));
        if ((String)obj2 == null) {
            return 0;
        }
        this.e.remove((String)obj2);
        obj = this.f.get(obj2);
        if ((ActivityResultRegistry.c)obj != null) {
            obj = obj.a;
            if (obj == null) {
                this.h.remove(obj2);
                this.g.put(obj2, o2);
            } else {
                obj.a(o2);
            }
        } else {
        }
        return 1;
    }

    public abstract <I, O> void f(int i, a<I, O> a2, I i3, b b4);

    public final void g(Bundle bundle) {
        Bundle intValue;
        Object key;
        int size;
        String str;
        boolean remove;
        Bundle bundle2;
        int obj6;
        if (bundle == null) {
        }
        ArrayList integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null) {
            if (integerArrayList == null) {
            } else {
                this.e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.a = (Random)bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                obj6 = 0;
                while (obj6 < stringArrayList.size()) {
                    key = stringArrayList.get(obj6);
                    if (this.c.containsKey((String)key) && !this.h.containsKey(key)) {
                    }
                    a((Integer)integerArrayList.get(obj6).intValue(), (String)stringArrayList.get(obj6));
                    obj6++;
                    if (!this.h.containsKey(key)) {
                    }
                    this.b.remove((Integer)this.c.remove(key));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        ArrayList arrayList = new ArrayList(this.c.values());
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", arrayList);
        ArrayList arrayList2 = new ArrayList(this.c.keySet());
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", arrayList2);
        ArrayList arrayList3 = new ArrayList(this.e);
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", arrayList3);
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle)this.h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    public final <I, O> androidx.activity.result.c<I> i(String string, a<I, O> a2, androidx.activity.result.b<O> b3) {
        boolean key;
        Object parcelable;
        Object cVar;
        cVar = new ActivityResultRegistry.c(b3, a2);
        this.f.put(string, cVar);
        if (this.g.containsKey(string)) {
            this.g.remove(string);
            b3.a(this.g.get(string));
        }
        parcelable = this.h.getParcelable(string);
        if ((a)parcelable != null) {
            this.h.remove(string);
            b3.a(a2.c((a)parcelable.b(), parcelable.a()));
        }
        ActivityResultRegistry.b obj6 = new ActivityResultRegistry.b(this, string, k(string), a2);
        return obj6;
    }

    public final <I, O> androidx.activity.result.c<I> j(String string, q q2, a<I, O> a3, androidx.activity.result.b<O> b4) {
        Object dVar;
        j lifecycle = q2.getLifecycle();
        if (lifecycle.b().isAtLeast(j.c.STARTED)) {
        } else {
            if ((ActivityResultRegistry.d)this.d.get(string) == null) {
                dVar = new ActivityResultRegistry.d(lifecycle);
            }
            ActivityResultRegistry.1 anon = new ActivityResultRegistry.1(this, string, b4, a3);
            dVar.a(anon);
            this.d.put(string, dVar);
            ActivityResultRegistry.a obj7 = new ActivityResultRegistry.a(this, string, k(string), a3);
            return obj7;
        }
        StringBuilder obj6 = new StringBuilder();
        obj6.append("LifecycleOwner ");
        obj6.append(q2);
        obj6.append(" is attempting to register while current state is ");
        obj6.append(lifecycle.b());
        obj6.append(". LifecycleOwners must call register before they are STARTED.");
        IllegalStateException obj4 = new IllegalStateException(obj6.toString());
        throw obj4;
    }

    final void l(String string) {
        boolean contains;
        boolean key2;
        boolean key;
        Object obj;
        Map map;
        Object parcelable;
        Object obj2;
        contains = this.c.remove(string);
        if (!this.e.contains(string) && (Integer)contains != null) {
            contains = this.c.remove(string);
            if ((Integer)(Integer)contains != null) {
                this.b.remove((Integer)(Integer)contains);
            }
        }
        this.f.remove(string);
        parcelable = ": ";
        final String str = "Dropping pending result for request ";
        final String str2 = "ActivityResultRegistry";
        if (this.g.containsKey(string)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(string);
            stringBuilder2.append(parcelable);
            stringBuilder2.append(this.g.get(string));
            Log.w(str2, stringBuilder2.toString());
            this.g.remove(string);
        }
        if (this.h.containsKey(string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(string);
            stringBuilder.append(parcelable);
            stringBuilder.append(this.h.getParcelable(string));
            Log.w(str2, stringBuilder.toString());
            this.h.remove(string);
        }
        obj = this.d.get(string);
        if ((ActivityResultRegistry.d)obj != null) {
            (ActivityResultRegistry.d)obj.b();
            this.d.remove(string);
        }
    }
}
