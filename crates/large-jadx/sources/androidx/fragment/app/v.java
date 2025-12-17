package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class v {

    private final ArrayList<androidx.fragment.app.Fragment> a;
    private final HashMap<String, androidx.fragment.app.u> b;
    private androidx.fragment.app.q c;
    v() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
    }

    void a(androidx.fragment.app.Fragment fragment) {
        if (this.a.contains(fragment)) {
        } else {
            ArrayList list2 = this.a;
            this.a.add(fragment);
            fragment.mAdded = true;
            return;
            synchronized (list2) {
                list2 = this.a;
                this.a.add(fragment);
                fragment.mAdded = true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment already added: ");
        stringBuilder.append(fragment);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    void b() {
        this.b.values().removeAll(Collections.singleton(0));
    }

    boolean c(String string) {
        int obj2;
        obj2 = this.b.get(string) != null ? 1 : 0;
        return obj2;
    }

    void d(int i) {
        Object next;
        Iterator iterator = this.b.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((u)next != null) {
            }
            (u)next.t(i);
        }
    }

    void e(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        String string2;
        boolean iterator;
        boolean next;
        int obj7;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("    ");
        if (!this.b.isEmpty()) {
            printWriter3.print(string);
            printWriter3.println("Active Fragments:");
            iterator = this.b.values().iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                printWriter3.print(string);
                if ((u)next2 != null) {
                } else {
                }
                printWriter3.println("null");
                next = (u)next2.k();
                printWriter3.println(next);
                next.dump(stringBuilder.toString(), fileDescriptor2, printWriter3, string4Arr4);
            }
        }
        int obj5 = this.a.size();
        if (obj5 > 0) {
            printWriter3.print(string);
            printWriter3.println("Added Fragments:");
            obj7 = 0;
            while (obj7 < obj5) {
                printWriter3.print(string);
                printWriter3.print("  #");
                printWriter3.print(obj7);
                printWriter3.print(": ");
                printWriter3.println((Fragment)this.a.get(obj7).toString());
                obj7++;
            }
        }
    }

    androidx.fragment.app.Fragment f(String string) {
        Object obj2 = this.b.get(string);
        if ((u)obj2 != null) {
            return (u)obj2.k();
        }
        return null;
    }

    androidx.fragment.app.Fragment g(int i) {
        int i2;
        Object next;
        int mFragmentId;
        size--;
        while (i2 >= 0) {
            next = this.a.get(i2);
            i2--;
        }
        Iterator iterator = this.b.values().iterator();
        for (u next : iterator) {
            next = next.k();
        }
        return null;
    }

    androidx.fragment.app.Fragment h(String string) {
        int iterator;
        Object next;
        boolean equals;
        if (string != null) {
            size--;
            while (iterator >= 0) {
                next = this.a.get(iterator);
                iterator--;
            }
        }
        if (string != null) {
            iterator = this.b.values().iterator();
            for (u next : iterator) {
                next = next.k();
            }
        }
        return null;
    }

    androidx.fragment.app.Fragment i(String string) {
        Object fragmentByWho;
        Iterator iterator = this.b.values().iterator();
        for (u fragmentByWho : iterator) {
            fragmentByWho = fragmentByWho.k().findFragmentByWho(string);
        }
        return null;
    }

    int j(androidx.fragment.app.Fragment fragment) {
        int mView;
        Object mContainer;
        ViewGroup mContainer2;
        int obj6;
        final ViewGroup mContainer3 = fragment.mContainer;
        final int i = -1;
        if (mContainer3 == null) {
            return i;
        }
        mView = obj6 + -1;
        while (mView >= 0) {
            mContainer = this.a.get(mView);
            mView--;
            mContainer = mContainer.mView;
        }
        obj6++;
        while (obj6 < this.a.size()) {
            mView = this.a.get(obj6);
            obj6++;
            mView = mView.mView;
        }
        return i;
    }

    List<androidx.fragment.app.u> k() {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.b.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((u)next != null) {
            }
            arrayList.add((u)next);
        }
        return arrayList;
    }

    List<androidx.fragment.app.Fragment> l() {
        androidx.fragment.app.Fragment fragment;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.b.values().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if ((u)next2 != null) {
            } else {
            }
            arrayList.add(0);
            arrayList.add((u)next2.k());
        }
        return arrayList;
    }

    androidx.fragment.app.u m(String string) {
        return (u)this.b.get(string);
    }

    List<androidx.fragment.app.Fragment> n() {
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList list2 = this.a;
        ArrayList arrayList = new ArrayList(this.a);
        return arrayList;
        synchronized (list2) {
            list2 = this.a;
            arrayList = new ArrayList(this.a);
            return arrayList;
        }
    }

    androidx.fragment.app.q o() {
        return this.c;
    }

    void p(androidx.fragment.app.u u) {
        Object str2;
        Object str;
        boolean obj4;
        str2 = u.k();
        if (c(str2.mWho)) {
        }
        this.b.put(str2.mWho, u);
        if (str2.mRetainInstanceChangedWhileDetached) {
            if (str2.mRetainInstance != null) {
                this.c.h(str2);
            } else {
                this.c.p(str2);
            }
            str2.mRetainInstanceChangedWhileDetached = false;
        }
        if (n.I0(2)) {
            obj4 = new StringBuilder();
            obj4.append("Added fragment to active set ");
            obj4.append(str2);
            Log.v("FragmentManager", obj4.toString());
        }
    }

    void q(androidx.fragment.app.u u) {
        boolean mRetainInstance;
        boolean str;
        String mWho;
        Object obj4;
        obj4 = u.k();
        if (obj4.mRetainInstance != null) {
            this.c.p(obj4);
        }
        if ((u)this.b.put(obj4.mWho, 0) == null) {
        }
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removed fragment from active set ");
            stringBuilder.append(obj4);
            Log.v("FragmentManager", stringBuilder.toString());
        }
    }

    void r() {
        Object obj;
        boolean next;
        HashMap map;
        androidx.fragment.app.Fragment inBackStack;
        boolean mRemoving;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            obj = this.b.get(next2.mWho);
            if ((u)obj != null) {
            }
            (u)obj.m();
        }
        Iterator iterator2 = this.b.values().iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if ((u)next) {
            }
            (u)next.m();
            inBackStack = next.k();
            if (inBackStack.mRemoving && !inBackStack.isInBackStack()) {
            } else {
            }
            map = 0;
            if (map != null) {
            }
            q(next);
            if (!inBackStack.isInBackStack()) {
            } else {
            }
            map = 1;
        }
    }

    void s(androidx.fragment.app.Fragment fragment) {
        ArrayList list = this.a;
        this.a.remove(fragment);
        fragment.mAdded = false;
        return;
        synchronized (list) {
            list = this.a;
            this.a.remove(fragment);
            fragment.mAdded = false;
        }
    }

    void t() {
        this.b.clear();
    }

    void u(List<String> list) {
        ArrayList string;
        androidx.fragment.app.Fragment fragment;
        boolean str2;
        String str;
        Iterator obj5;
        this.a.clear();
        if (list != null) {
            obj5 = list.iterator();
            for (String string : obj5) {
                fragment = f(string);
                if (n.I0(2)) {
                }
                a(fragment);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("restoreSaveState: added (");
                stringBuilder2.append(string);
                stringBuilder2.append("): ");
                stringBuilder2.append(fragment);
                Log.v("FragmentManager", stringBuilder2.toString());
            }
        }
    }

    ArrayList<androidx.fragment.app.t> v() {
        Object string;
        Object str;
        boolean stringBuilder;
        String str2;
        ArrayList arrayList = new ArrayList(this.b.size());
        Iterator iterator = this.b.values().iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            string = string.r();
            arrayList.add(string);
            if (string != null && n.I0(2)) {
            }
            string = string.r();
            arrayList.add(string);
            if (n.I0(2)) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Saved state of ");
            stringBuilder.append(string.k());
            stringBuilder.append(": ");
            stringBuilder.append(string.E);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        return arrayList;
    }

    ArrayList<String> w() {
        Object string;
        boolean str;
        StringBuilder stringBuilder;
        String str2;
        final ArrayList list = this.a;
        synchronized (list) {
            return 0;
        }
    }

    void x(androidx.fragment.app.q q) {
        this.c = q;
    }
}
