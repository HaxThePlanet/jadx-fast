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

/* compiled from: ChainableAppScreen.kt */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008&\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentReturnTag", "", "(Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "lastChainableScreen", "", "getLastChainableScreen", "()Z", "setLastChainableScreen", "(Z)V", "nextScreen", "getNextScreen", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "setNextScreen", "(Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;)V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public abstract class ChainableAppScreen extends j implements Parcelable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final g.a INSTANCE = new g$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private j b;
    private boolean c;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/ChainableAppScreen$Companion;", "", "()V", "setupChain", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "screenChain", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final List<j> setupChain(List<? extends j> screenChain) {
            int i;
            boolean z;
            n.f(screenChain, "screenChain");
            List list = p.E(screenChain);
            final ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                Object item = it.next();
                i = i + 1;
                if (i < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
            return p.x0(arrayList);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public g(String str) {
        n.f(str, "fragmentReturnTag");
        super();
        this.fragmentReturnTag = str;
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
    public void d(j jVar) {
        this.b = jVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

}
