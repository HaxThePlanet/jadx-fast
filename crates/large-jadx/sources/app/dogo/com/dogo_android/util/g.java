package app.dogo.com.dogo_android.util;

import android.os.Parcelable;
import app.dogo.com.dogo_android.y.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008&\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentReturnTag", "", "(Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "lastChainableScreen", "", "getLastChainableScreen", "()Z", "setLastChainableScreen", "(Z)V", "nextScreen", "getNextScreen", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "setNextScreen", "(Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;)V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class g extends j implements Parcelable {

    public static final app.dogo.com.dogo_android.util.g.a Companion;
    private final String a;
    private j b;
    private boolean c;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/ChainableAppScreen$Companion;", "", "()V", "setupChain", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "screenChain", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final List<j> a(List<? extends j> list) {
            int illegalStateException;
            Object next;
            int i;
            int i2;
            int str;
            boolean z;
            n.f(list, "screenChain");
            List list2 = p.E(list);
            ArrayList arrayList = new ArrayList(p.r(list2, 10));
            Iterator iterator = list2.iterator();
            int i5 = 0;
            illegalStateException = i5;
            for (Object next : iterator) {
                i2 = 1;
                if (illegalStateException == null) {
                } else {
                }
                str = i5;
                if (str != null) {
                } else {
                }
                if (next instanceof g) {
                } else {
                }
                illegalStateException = new IllegalStateException(n.o("Non chainable app screen passed to a chain flow, this will cause unexpected navigation results. Screen at fault ", (j)next.getClass()));
                a.d(illegalStateException);
                arrayList.add(next);
                illegalStateException = i;
                illegalStateException = list.get(i7 += i2);
                str = next;
                (g)str.c(i2 ^= z);
                str.d((j)illegalStateException);
                str = i2;
            }
            return p.x0(arrayList);
        }
    }
    static {
        g.a aVar = new g.a(0);
        g.Companion = aVar;
    }

    public g(String string) {
        n.f(string, "fragmentReturnTag");
        super();
        this.a = string;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean a() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public j b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void c(boolean z) {
        this.c = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void d(j j) {
        this.b = j;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.a;
    }
}
