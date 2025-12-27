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
import d.p.b.b.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
class b extends a {

    static boolean c = false;
    private final q a;
    private final b.c b;

    static class b<D> implements y<D> {

        private final d.p.b.b<D> a;
        private final a.a<D> b;
        private boolean c = false;
        b(d.p.b.b<D> bVar, a.a<D> aVar) {
            super();
            this.a = bVar;
            this.b = aVar;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean b() {
            return this.c;
        }

        void c() {
            if (this.c && b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "  Resetting: ";
                str2 = str3 + this.a;
                str = "LoaderManager";
                Log.v(str, str2);
                this.b.c(this.a);
            }
        }

        public void onChanged(D d) {
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "  onLoadFinished in ";
                String str4 = ": ";
                String str5 = this.a.d(d);
                str2 = str3 + this.a + str4 + str5;
                str = "LoaderManager";
                Log.v(str, str2);
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.b.toString();
        }
    }

    static class c extends e0 {

        private static final g0.b c = new b$c$a();
        private h<b.a> a = new h<>();
        private boolean b = false;

        c() {
            super();
            h hVar = new h();
        }

        static b.c j(i0 i0Var) {
            return (b.c)new g0(i0Var, b.c.c).a(b.c.class);
        }

        @Override // androidx.lifecycle.e0
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            int i2 = 0;
            String aVar;
            if (this.a.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "    ";
                str3 = str + str4;
                i2 = 0;
                while (i2 < this.a.k()) {
                    Object obj = this.a.l(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.a.h(i2));
                    printWriter.print(": ");
                    printWriter.println(obj.toString());
                    obj.c(str3, fileDescriptor, printWriter, strArr);
                    i2 = i2 + 1;
                }
            }
        }

        @Override // androidx.lifecycle.e0
        void i() {
            this.b = false;
        }

        @Override // androidx.lifecycle.e0
        <D> b.a<D> k(int i) {
            return (b.a)this.a.e(i);
        }

        @Override // androidx.lifecycle.e0
        boolean l() {
            return this.b;
        }

        @Override // androidx.lifecycle.e0
        void m() {
            int i = 0;
            i = 0;
            while (i < this.a.k()) {
                (b.a)this.a.l(i).e();
                i = i + 1;
            }
        }

        @Override // androidx.lifecycle.e0
        void n(int i, b.a aVar) {
            this.a.j(i, aVar);
        }

        @Override // androidx.lifecycle.e0
        void o() {
            this.b = true;
        }

        @Override // androidx.lifecycle.e0
        protected void onCleared() {
            int i = 0;
            super.onCleared();
            i = 0;
            while (i < this.a.k()) {
                boolean z = true;
                (b.a)this.a.l(i).b(z);
                i = i + 1;
            }
            this.a.b();
        }
    }

    public static class a<D> extends x<D> implements b.b<D> {

        private final int a;
        private final Bundle b;
        private final d.p.b.b<D> c;
        private q d;
        private b.b<D> e;
        private d.p.b.b<D> f;
        a(int i, Bundle bundle, d.p.b.b<D> bVar, d.p.b.b<D> bVar2) {
            super();
            this.a = i;
            this.b = bundle;
            this.c = bVar;
            this.f = bVar2;
            bVar.q(i, this);
        }

        @Override // androidx.lifecycle.x
        public void a(d.p.b.b<D> bVar, D d) {
            boolean z2;
            final String str2 = "LoaderManager";
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                str = "onLoadComplete: ";
                str4 = str + this;
                Log.v(str2, str4);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
            } else {
                if (b.c) {
                    Log.w(str2, "onLoadComplete was incorrectly called on a background thread");
                }
                postValue(d);
            }
        }

        @Override // androidx.lifecycle.x
        d.p.b.b<D> b(boolean z) {
            d.p.a.b.b bVar;
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "  Destroying: ";
                str2 = str3 + this;
                str = "LoaderManager";
                Log.v(str, str2);
            }
            this.c.b();
            this.c.a();
            if (this.e != null && z) {
                this.e.c();
            }
            this.c.v(this);
            if (this.e == null || this.e.b()) {
                if (z) {
                    this.c.r();
                    return this.f;
                }
            }
            return this.c;
        }

        @Override // androidx.lifecycle.x
        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.c);
            StringBuilder stringBuilder = new StringBuilder();
            final String str7 = "  ";
            str6 = str + str7;
            this.c.g(str6, fileDescriptor, printWriter, strArr);
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                StringBuilder stringBuilder2 = new StringBuilder();
                str2 = str + str7;
                this.e.a(str2, printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(d().d(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        @Override // androidx.lifecycle.x
        d.p.b.b<D> d() {
            return this.c;
        }

        @Override // androidx.lifecycle.x
        void e() {
            if (this.d != null && this.e != null) {
                super.removeObserver(this.e);
                observe(this.d, this.e);
            }
        }

        @Override // androidx.lifecycle.x
        d.p.b.b<D> f(q qVar, a.a<D> aVar) {
            final d.p.a.b.b bVar = new b.b(this.c, aVar);
            observe(qVar, bVar);
            if (this.e != null) {
                removeObserver(this.e);
            }
            this.d = qVar;
            this.e = bVar;
            return this.c;
        }

        @Override // androidx.lifecycle.x
        protected void onActive() {
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "  Starting: ";
                str2 = str3 + this;
                str = "LoaderManager";
                Log.v(str, str2);
            }
            this.c.t();
        }

        @Override // androidx.lifecycle.x
        protected void onInactive() {
            if (b.c) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "  Stopping: ";
                str2 = str3 + this;
                str = "LoaderManager";
                Log.v(str, str2);
            }
            this.c.u();
        }

        @Override // androidx.lifecycle.x
        public void removeObserver(y<? super D> yVar) {
            super.removeObserver(yVar);
            final q qVar = null;
            this.d = qVar;
            this.e = qVar;
        }

        @Override // androidx.lifecycle.x
        public void setValue(D d) {
            super.setValue(d);
            if (this.f != null) {
                this.f.r();
                d.p.b.b bVar = null;
                this.f = bVar;
            }
        }

        @Override // androidx.lifecycle.x
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            String str2 = "LoaderInfo{";
            String str3 = Integer.toHexString(System.identityHashCode(this));
            String str4 = " #";
            String str5 = " : ";
            b.a(this.c, stringBuilder);
            String str6 = "}}";
            str = 64 + str2 + str3 + str4 + this.a + str5 + str6;
            return str;
        }
    }
    b(q qVar, i0 i0Var) {
        super();
        this.a = qVar;
        this.b = b.c.j(i0Var);
    }

    private <D> d.p.b.b<D> e(int i, Bundle bundle, a.a<D> aVar, d.p.b.b<D> bVar) {
        try {
            this.b.o();
            bVar = aVar.b(i, bundle);
            if (bVar.getClass().isMemberClass()) {
                if (!Modifier.isStatic(bVar.getClass().getModifiers())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    final String str5 = "Object returned from onCreateLoader must not be a non-static inner member class: ";
                    bundle = str5 + bVar;
                    throw new IllegalArgumentException(bundle);
                }
            }
            aVar = new b.a(i, bundle, bVar, bVar);
            if (b.c) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str2 = "  Created new loader ";
                str = str2 + aVar;
                Log.v("LoaderManager", str);
            }
            this.b.n(i, aVar);
        } finally {
            this.b.i();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        try {
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } finally {
            this.b.i();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
    }

    @Deprecated
    @Override // d.p.a.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.h(str, fileDescriptor, printWriter, strArr);
    }

    @Override // d.p.a.a
    public <D> d.p.b.b<D> c(int i, Bundle bundle, a.a<D> aVar) {
        if (this.b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        } else {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                throw new IllegalStateException("initLoader must be called on the main thread");
            } else {
                aVar = this.b.k(i);
                final String str4 = "LoaderManager";
                if (b.c) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "initLoader in ";
                    str = ": args=";
                    str3 = str5 + this + str + bundle;
                    Log.v(str4, str3);
                }
                if (aVar == null) {
                    return e(i, bundle, aVar, null);
                }
                if (b.c) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    str2 = "  Re-using existing loader ";
                    str6 = str2 + aVar;
                    Log.v(str4, str6);
                }
                return aVar.f(this.a, aVar);
            }
        }
    }

    @Override // d.p.a.a
    public void d() {
        this.b.m();
    }

    @Override // d.p.a.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        String str2 = "LoaderManager{";
        String str3 = Integer.toHexString(System.identityHashCode(this));
        String str4 = " in ";
        b.a(this.a, stringBuilder);
        String str5 = "}}";
        str = 128 + str2 + str3 + str4 + str5;
        return str;
    }

}
