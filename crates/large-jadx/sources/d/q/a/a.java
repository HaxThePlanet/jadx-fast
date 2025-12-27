package d.q.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {

    private static final Object f = new Object();
    private static a g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<a.c>> b = new HashMap<>();
    private final HashMap<String, ArrayList<a.c>> c = new HashMap<>();
    private final ArrayList<a.b> d = new ArrayList<>();
    private final Handler e = new a$a();

    class a extends Handler {

        final /* synthetic */ a a;
        a(Looper looper) {
            this.a = aVar;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                this.a.a();
            }
        }
    }

    private static final class b {

        final Intent a;
        final ArrayList<a.c> b;
        b(Intent intent, ArrayList<a.c> arrayList) {
            super();
            this.a = intent;
            this.b = arrayList;
        }
    }

    private static final class c {

        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;
        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            super();
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.b);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.a);
            if (this.d) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    private a(Context context) {
        super();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        this.a = context;
        d.q.a.a.a aVar = new a.a(this, context.getMainLooper());
    }

    public static a b(Context context) {
        final Object obj2 = a.f;
        synchronized (obj2) {
            try {
                if (a.g == null) {
                    a.g = new a(context.getApplicationContext());
                }
                return a.g;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    void a() {
        int i;
        Object item;
        boolean z;
        Intent intent;
        synchronized (map) {
            try {
                int size2 = this.d.size();
                return;
            } catch (Throwable th) {
            }
        }
        i = 0;
        while (i < this.d) {
            d.q.a.a.b bVar = arr[i];
            while (i < bVar.b.size()) {
                item = bVar.b.get(i);
                i = i + 1;
            }
            i = i + 1;
            item = bVar.b.get(i);
            i = i + 1;
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Object value;
        HashMap map;
        HashMap map2;
        int i = 0;
        synchronized (map3) {
            try {
                final d.q.a.a.c cVar = new a.c(intentFilter, broadcastReceiver);
                final int i2 = 1;
                if ((ArrayList)this.b.get(broadcastReceiver) == null) {
                    this.b.put(broadcastReceiver, new ArrayList(i2));
                }
                while (i < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i);
                    if ((ArrayList)this.c.get(action) == null) {
                        this.c.put(action, new ArrayList(i2));
                    }
                    map.add(cVar);
                    i = i + 1;
                }
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public boolean d(Intent intent) {
        int i2 = 0;
        boolean z;
        int match;
        String str;
        String action;
        String resolveTypeIfNeeded;
        Object item;
        int i4 = 0;
        String scheme;
        String str3;
        String str4;
        IntentFilter intentFilter;
        int i5 = 1;
        int i6 = 0;
        final Object intent3 = this;
        String intent2 = intent;
        synchronized (map) {
            try {
                action = intent.getAction();
                resolveTypeIfNeeded = intent2.resolveTypeIfNeeded(intent3.a.getContentResolver());
                scheme = intent.getScheme();
                i = intent.getFlags() & 8;
                int r16 = intent.getFlags() & 8 != 0 ? 1 : 0;
                if (i6 != 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str12 = "Resolving type ";
                    String str13 = " scheme ";
                    resolveTypeIfNeeded = " of intent ";
                    str2 = str12 + resolveTypeIfNeeded + str13 + scheme + resolveTypeIfNeeded + intent2;
                    Log.v("LocalBroadcastManager", str2);
                }
                str3 = intent3.c.get(intent.getAction());
                if (str3 != null && i6 != 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    resolveTypeIfNeeded = "Action list: ";
                    action = resolveTypeIfNeeded + str3;
                    Log.v("LocalBroadcastManager", action);
                    match = 0;
                    i4 = 0;
                    while (i4 < str3.size()) {
                        i4 = i4 + 1;
                    }
                    ArrayList list2 = match;
                    int i8 = 1;
                    if (list2 != null) {
                        i2 = 0;
                        while (intent3.c < list2.size()) {
                            resolveTypeIfNeeded = null;
                            (a.c)list2.get(i2).c = resolveTypeIfNeeded;
                            i2 = i2 + 1;
                        }
                        intent3.d.add(new a.b(intent2, list2));
                        if (!intent3.e.hasMessages(i8)) {
                            intent3.e.sendEmptyMessage(i8);
                        }
                        return true;
                    }
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        int i;
        int i2 = 0;
        int countActions;
        Object value;
        int i3;
        Object item2;
        BroadcastReceiver broadcastReceiver2;
        synchronized (map) {
            try {
                Object remove = this.b.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                while (i >= 0) {
                    Object item = remove.get(i);
                    item.d = true;
                    i2 = 0;
                    while (i2 < item.a.countActions()) {
                        String action = item.a.getAction(i2);
                        value = this.c.get(action);
                        if (value != null) {
                            i3 = value.size() - i4;
                            while (i3 >= 0) {
                                item2 = value.get(i3);
                                i3 = i3 - 1;
                            }
                            if (value.size() <= 0) {
                                this.c.remove(action);
                            }
                        }
                        i2 = i2 + 1;
                    }
                    i = i - 1;
                    action = item.a.getAction(i2);
                    value = this.c.get(action);
                    i2 = i2 + 1;
                }
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
