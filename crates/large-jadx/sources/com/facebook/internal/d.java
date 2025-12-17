package com.facebook.internal;

import android.content.Intent;
import com.facebook.k;
import com.facebook.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/internal/CallbackManagerImpl;", "Lcom/facebook/CallbackManager;", "()V", "callbacks", "", "", "Lcom/facebook/internal/CallbackManagerImpl$Callback;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "registerCallback", "", "callback", "unregisterCallback", "Callback", "Companion", "RequestCodeOffset", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d implements k {

    private static final Map<Integer, com.facebook.internal.d.a> b;
    public static final com.facebook.internal.d.b c;
    private final Map<Integer, com.facebook.internal.d.a> a;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0008", d2 = {"Lcom/facebook/internal/CallbackManagerImpl$Callback;", "", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract boolean a(int i, Intent intent2);
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0008\u001a\u00020\u0005H\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\"\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0003R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/internal/CallbackManagerImpl$Companion;", "", "()V", "staticCallbacks", "", "", "Lcom/facebook/internal/CallbackManagerImpl$Callback;", "getStaticCallback", "requestCode", "registerStaticCallback", "", "callback", "runStaticCallback", "", "resultCode", "data", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public static final boolean a(com.facebook.internal.d.b d$b, int i2, int i3, Intent intent4) {
            return b.d(i2, i3, intent4);
        }

        private final com.facebook.internal.d.a b(int i) {
            return (d.a)d.b().get(Integer.valueOf(i));
            synchronized (this) {
                return (d.a)d.b().get(Integer.valueOf(i));
            }
        }

        private final boolean d(int i, int i2, Intent intent3) {
            boolean obj1;
            obj1 = b(i);
            if (obj1 != null) {
                obj1 = obj1.a(i2, intent3);
            } else {
                obj1 = 0;
            }
            return obj1;
        }

        public final void c(int i, com.facebook.internal.d.a d$a2) {
            n.f(a2, "callback");
            synchronized (this) {
                try {
                    d.b().put(Integer.valueOf(i), a2);
                    throw i;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0013\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015¨\u0006\u0016", d2 = {"Lcom/facebook/internal/CallbackManagerImpl$RequestCodeOffset;", "", "offset", "", "(Ljava/lang/String;II)V", "toRequestCode", "Login", "Share", "Message", "Like", "GameRequest", "AppGroupCreate", "AppGroupJoin", "AppInvite", "DeviceShare", "GamingFriendFinder", "GamingGroupIntegration", "Referral", "GamingContextCreate", "GamingContextSwitch", "GamingContextChoose", "TournamentShareDialog", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum c {

        Login(false),
        Share(false),
        Message(false),
        Like(false),
        GameRequest(false),
        AppGroupCreate(false),
        AppGroupJoin(false),
        AppInvite(false),
        DeviceShare(false),
        GamingFriendFinder(false),
        GamingGroupIntegration(false),
        Referral(false),
        GamingContextCreate(false),
        GamingContextSwitch(false),
        GamingContextChoose(false),
        TournamentShareDialog(false);

        private final int offset;
        @Override // java.lang.Enum
        public final int toRequestCode() {
            return i += offset;
        }
    }
    static {
        d.b bVar = new d.b(0);
        d.c = bVar;
        HashMap hashMap = new HashMap();
        d.b = hashMap;
    }

    public d() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public static final Map b() {
        return d.b;
    }

    public static final void d(int i, com.facebook.internal.d.a d$a2) {
        final Class<com.facebook.internal.d> obj = d.class;
        d.c.c(i, a2);
        return;
        synchronized (obj) {
            obj = d.class;
            d.c.c(i, a2);
        }
    }

    @Override // com.facebook.k
    public boolean a(int i, int i2, Intent intent3) {
        Object obj;
        boolean obj3;
        obj = this.a.get(Integer.valueOf(i));
        if ((d.a)obj != null) {
            obj3 = (d.a)obj.a(i2, intent3);
        } else {
            obj3 = d.b.a(d.c, i, i2, intent3);
        }
        return obj3;
    }

    @Override // com.facebook.k
    public final void c(int i, com.facebook.internal.d.a d$a2) {
        n.f(a2, "callback");
        this.a.put(Integer.valueOf(i), a2);
    }
}
