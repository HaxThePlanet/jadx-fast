package d.p.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.g0;
import androidx.lifecycle.g0.b;
import androidx.lifecycle.i0;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import d.e.h;
import d.h.k.b;
import d.p.b.b;
import d.p.b.b.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
class b extends d.p.a.a {

    static boolean c = false;
    private final q a;
    private final d.p.a.b.c b;

    static class b implements y<D> {

        private final b<D> a;
        private final d.p.a.a.a<D> b;
        private boolean c = false;
        b(b<D> b, d.p.a.a.a<D> a$a2) {
            super();
            final int i = 0;
            this.a = b;
            this.b = a2;
        }

        @Override // androidx.lifecycle.y
        public void a(String string, PrintWriter printWriter2) {
            printWriter2.print(string);
            printWriter2.print("mDeliveredData=");
            printWriter2.println(this.c);
        }

        @Override // androidx.lifecycle.y
        boolean b() {
            return this.c;
        }

        @Override // androidx.lifecycle.y
        void c() {
            boolean string;
            boolean z;
            String str;
            if (this.c && b.c) {
                if (b.c) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Resetting: ");
                    stringBuilder.append(this.a);
                    Log.v("LoaderManager", stringBuilder.toString());
                }
                this.b.c(this.a);
            }
        }

        public void onChanged(D d) {
            boolean string;
            String str;
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  onLoadFinished in ");
                stringBuilder.append(this.a);
                stringBuilder.append(": ");
                stringBuilder.append(this.a.d(d));
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        @Override // androidx.lifecycle.y
        public String toString() {
            return this.b.toString();
        }
    }

    static class c extends e0 {

        private static final g0.b c;
        private h<d.p.a.b.a> a;
        private boolean b = false;
        static {
            b.c.a aVar = new b.c.a();
            b.c.c = aVar;
        }

        c() {
            super();
            h hVar = new h();
            this.a = hVar;
            int i = 0;
        }

        static d.p.a.b.c j(i0 i0) {
            g0 g0Var = new g0(i0, b.c.c);
            return (b.c)g0Var.a(b.c.class);
        }

        @Override // androidx.lifecycle.e0
        public void h(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
            int string2;
            int i;
            Object obj;
            String string3;
            if (this.a.k() > 0) {
                printWriter3.print(string);
                printWriter3.println("Loaders:");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("    ");
                i = 0;
                while (i < this.a.k()) {
                    obj = this.a.l(i);
                    printWriter3.print(string);
                    printWriter3.print("  #");
                    printWriter3.print(this.a.h(i));
                    printWriter3.print(": ");
                    printWriter3.println((b.a)obj.toString());
                    obj.c(stringBuilder.toString(), fileDescriptor2, printWriter3, string4Arr4);
                    i++;
                }
            }
        }

        @Override // androidx.lifecycle.e0
        void i() {
            this.b = false;
        }

        <D> d.p.a.b.a<D> k(int i) {
            return (b.a)this.a.e(i);
        }

        @Override // androidx.lifecycle.e0
        boolean l() {
            return this.b;
        }

        @Override // androidx.lifecycle.e0
        void m() {
            int i;
            Object obj;
            i = 0;
            while (i < this.a.k()) {
                (b.a)this.a.l(i).e();
                i++;
            }
        }

        @Override // androidx.lifecycle.e0
        void n(int i, d.p.a.b.a b$a2) {
            this.a.j(i, a2);
        }

        @Override // androidx.lifecycle.e0
        void o() {
            this.b = true;
        }

        @Override // androidx.lifecycle.e0
        protected void onCleared() {
            int i2;
            Object obj;
            int i;
            super.onCleared();
            i2 = 0;
            while (i2 < this.a.k()) {
                (b.a)this.a.l(i2).b(true);
                i2++;
            }
            this.a.b();
        }
    }

    public static class a extends x<D> implements b.b<D> {

        private final int a;
        private final Bundle b;
        private final b<D> c;
        private q d;
        private d.p.a.b.b<D> e;
        private b<D> f;
        a(int i, Bundle bundle2, b<D> b3, b<D> b4) {
            super();
            this.a = i;
            this.b = bundle2;
            this.c = b3;
            this.f = b4;
            b3.q(i, this);
        }

        public void a(b<D> b, D d2) {
            String str;
            boolean obj3;
            final String str2 = "LoaderManager";
            if (b.c) {
                obj3 = new StringBuilder();
                obj3.append("onLoadComplete: ");
                obj3.append(this);
                Log.v(str2, obj3.toString());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d2);
            } else {
                if (b.c) {
                    Log.w(str2, "onLoadComplete was incorrectly called on a background thread");
                }
                postValue(d2);
            }
        }

        b<D> b(boolean z) {
            boolean string;
            d.p.a.b.b bVar;
            String str;
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Destroying: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.c.b();
            this.c.a();
            bVar = this.e;
            removeObserver(bVar);
            if (bVar != null && z) {
                removeObserver(bVar);
                if (z) {
                    bVar.c();
                }
            }
            this.c.v(this);
            if (bVar != null) {
                if (bVar.b() && z) {
                    if (z) {
                    }
                }
                this.c.r();
                return this.f;
            } else {
            }
            return this.c;
        }

        @Override // androidx.lifecycle.x
        public void c(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
            d.p.a.b.b obj5;
            String[] obj7;
            printWriter3.print(string);
            printWriter3.print("mId=");
            printWriter3.print(this.a);
            printWriter3.print(" mArgs=");
            printWriter3.println(this.b);
            printWriter3.print(string);
            printWriter3.print("mLoader=");
            printWriter3.println(this.c);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            final String str4 = "  ";
            stringBuilder.append(str4);
            this.c.g(stringBuilder.toString(), fileDescriptor2, printWriter3, string4Arr4);
            if (this.e != null) {
                printWriter3.print(string);
                printWriter3.print("mCallbacks=");
                printWriter3.println(this.e);
                obj7 = new StringBuilder();
                obj7.append(string);
                obj7.append(str4);
                this.e.a(obj7.toString(), printWriter3);
            }
            printWriter3.print(string);
            printWriter3.print("mData=");
            printWriter3.println(d().d(getValue()));
            printWriter3.print(string);
            printWriter3.print("mStarted=");
            printWriter3.println(hasActiveObservers());
        }

        b<D> d() {
            return this.c;
        }

        @Override // androidx.lifecycle.x
        void e() {
            final q qVar = this.d;
            final d.p.a.b.b bVar = this.e;
            if (qVar != null && bVar != null) {
                if (bVar != null) {
                    super.removeObserver(bVar);
                    observe(qVar, bVar);
                }
            }
        }

        b<D> f(q q, d.p.a.a.a<D> a$a2) {
            b.b bVar = new b.b(this.c, a2);
            observe(q, bVar);
            final d.p.a.b.b obj4 = this.e;
            if (obj4 != null) {
                removeObserver(obj4);
            }
            this.d = q;
            this.e = bVar;
            return this.c;
        }

        @Override // androidx.lifecycle.x
        protected void onActive() {
            boolean string;
            String str;
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Starting: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.c.t();
        }

        @Override // androidx.lifecycle.x
        protected void onInactive() {
            boolean string;
            String str;
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Stopping: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.c.u();
        }

        public void removeObserver(y<? super D> y) {
            super.removeObserver(y);
            final int obj1 = 0;
            this.d = obj1;
            this.e = obj1;
        }

        public void setValue(D d) {
            b obj1;
            super.setValue(d);
            obj1 = this.f;
            if (obj1 != null) {
                obj1.r();
                this.f = 0;
            }
        }

        @Override // androidx.lifecycle.x
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.a);
            stringBuilder.append(" : ");
            b.a(this.c, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }
    static {
    }

    b(q q, i0 i02) {
        super();
        this.a = q;
        this.b = b.c.j(i02);
    }

    private <D> b<D> e(int i, Bundle bundle2, d.p.a.a.a<D> a$a3, b<D> b4) {
        Object str;
        boolean memberClass;
        boolean obj4;
        Object obj6;
        try {
            this.b.o();
            str = a3.b(i, bundle2);
            if (str == null) {
            } else {
            }
            if (str.getClass().isMemberClass()) {
            }
            if (!Modifier.isStatic(str.getClass().getModifiers())) {
            } else {
            }
            obj4 = new StringBuilder();
            obj4.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
            obj4.append(str);
            IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
            throw obj3;
            b.a aVar = new b.a(i, bundle2, str, b4);
            if (b.c) {
            }
            obj6 = new StringBuilder();
            obj6.append("  Created new loader ");
            obj6.append(aVar);
            Log.v("LoaderManager", obj6.toString());
            this.b.n(i, aVar);
            this.b.i();
            return aVar.f(this.a, a3);
            obj3 = new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            throw obj3;
            bundle2 = this.b;
            bundle2.i();
            throw i;
        }
    }

    @Deprecated
    public void a(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        this.b.h(string, fileDescriptor2, printWriter3, string4Arr4);
    }

    public <D> b<D> c(int i, Bundle bundle2, d.p.a.a.a<D> a$a3) {
        boolean string;
        String str;
        boolean obj5;
        Object obj6;
        if (this.b.l()) {
        } else {
            if (Looper.getMainLooper() != Looper.myLooper()) {
            } else {
                d.p.a.b.a aVar = this.b.k(i);
                final String str2 = "LoaderManager";
                if (b.c) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("initLoader in ");
                    stringBuilder.append(this);
                    stringBuilder.append(": args=");
                    stringBuilder.append(bundle2);
                    Log.v(str2, stringBuilder.toString());
                }
                if (aVar == null) {
                    return e(i, bundle2, a3, 0);
                }
                if (b.c) {
                    obj5 = new StringBuilder();
                    obj5.append("  Re-using existing loader ");
                    obj5.append(aVar);
                    Log.v(str2, obj5.toString());
                }
                return aVar.f(this.a, a3);
            }
            obj5 = new IllegalStateException("initLoader must be called on the main thread");
            throw obj5;
        }
        obj5 = new IllegalStateException("Called while creating a loader");
        throw obj5;
    }

    @Override // d.p.a.a
    public void d() {
        this.b.m();
    }

    @Override // d.p.a.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        b.a(this.a, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
