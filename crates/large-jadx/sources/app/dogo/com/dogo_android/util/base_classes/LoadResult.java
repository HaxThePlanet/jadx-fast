package app.dogo.com.dogo_android.util.e0;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LoadResult.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0006\u0007\u0008B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016\u0082\u0001\u0003\t\n\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "R", "", "()V", "toString", "", "Error", "Loading", "Success", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Success;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Error;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Loading;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y, reason: from kotlin metadata */
public abstract /* sealed */ class LoadResult<out R> {

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0011\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\u0008¢\u0006\u0002\u0010\tJ\r\u0010\u000c\u001a\u00060\u0007j\u0002`\u0008HÆ\u0003J\u0017\u0010\r\u001a\u00020\u00002\u000c\u0008\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\u0008HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0006\u001a\u00060\u0007j\u0002`\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Error;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "throwable", "", "(Ljava/lang/Throwable;)V", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends y {

        /* renamed from: a, reason: from kotlin metadata */
        private final Exception exception;
        public a(Exception exc) {
            n.f(exc, "exception");
            super(null);
            this.exception = exc;
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final Exception component1() {
            return this.exception;
        }

        public a(Throwable th) {
            n.f(th, "throwable");
            this(new Exception(th));
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof LoadResult_Error)) {
                return false;
            }
            return !n.b(this.exception, other.exception) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Error(exception=";
            str = str2 + this.exception + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Loading;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends y {

        public static final y.b a = new y$b();
        private b() {
            super(null);
        }

    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0008\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Success;", "T", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lapp/dogo/com/dogo_android/util/base_classes/LoadResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c<out T> extends y<T> {

        /* renamed from: a, reason: from kotlin metadata */
        private final T data;
        public c(T t) {
            super(null);
            this.data = t;
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final T component1() {
            return this.data;
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof LoadResult_Success)) {
                return false;
            }
            return !n.b(this.data, other.data) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        public int hashCode() {
            int i = 0;
            if (this.data == null) {
                i = 0;
            } else {
                i = this.data.hashCode();
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.util.e0.y
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Success(data=";
            str = str2 + this.data + 41;
            return str;
        }
    }
    private y() {
        super();
    }

    public String toString() throws NoWhenBranchMatchedException {
        String str;
        final char c = ']';
        if (this instanceof LoadResult_Success) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str3 = "Success[data=";
            Object component12 = (LoadResult_Success)this.component1();
            str = str3 + component12 + c;
            return str;
        } else {
            if (this instanceof LoadResult_Error) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Error[exception=";
                Exception component1 = (LoadResult_Error)this.component1();
                str = str2 + component1 + c;
            } else {
                if (n.b(this, LoadResult_Loading.a)) {
                    str = "Loading";
                }
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ y(g gVar) {
        this();
    }
}
