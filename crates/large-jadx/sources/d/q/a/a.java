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

/* loaded from: classes.dex */
public final class a {

    private static final Object f;
    private static d.q.a.a g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<d.q.a.a.c>> b;
    private final HashMap<String, ArrayList<d.q.a.a.c>> c;
    private final ArrayList<d.q.a.a.b> d;
    private final Handler e;

    class a extends Handler {

        final d.q.a.a a;
        a(d.q.a.a a, Looper looper2) {
            this.a = a;
            super(looper2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj3;
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                this.a.a();
            }
        }
    }

    private static final class b {

        final Intent a;
        final ArrayList<d.q.a.a.c> b;
        b(Intent intent, ArrayList<d.q.a.a.c> arrayList2) {
            super();
            this.a = intent;
            this.b = arrayList2;
        }
    }

    private static final class c {

        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;
        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver2) {
            super();
            this.a = intentFilter;
            this.b = broadcastReceiver2;
        }

        public String toString() {
            boolean str;
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
    static {
        Object object = new Object();
        a.f = object;
    }

    private a(Context context) {
        super();
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.a = context;
        a.a aVar = new a.a(this, context.getMainLooper());
        this.e = aVar;
    }

    public static d.q.a.a b(Context context) {
        d.q.a.a aVar;
        Object obj2;
        final Object obj = a.f;
        synchronized (obj) {
            aVar = new a(context.getApplicationContext());
            a.g = aVar;
            return a.g;
        }
    }

    void a() {
        int i;
        d.q.a.a.b bVar;
        int size;
        int i2;
        Object obj;
        boolean z;
        Intent intent;
        HashMap map = this.b;
        int size2 = this.d.size();
        synchronized (map) {
        }
        try {
            while (i < size2) {
                bVar = arr[i];
                i2 = i3;
                while (i2 < bVar.b.size()) {
                    obj = bVar.b.get(i2);
                    if (!obj.d) {
                    }
                    i2++;
                    obj.b.onReceive(this.a, bVar.a);
                }
                i++;
                obj = bVar.b.get(i2);
                if (!obj.d) {
                }
                i2++;
                obj.b.onReceive(this.a, bVar.a);
            }
            bVar = arr[i];
            i2 = i3;
            while (i2 < bVar.b.size()) {
                obj = bVar.b.get(i2);
                if (!obj.d) {
                }
                i2++;
                obj.b.onReceive(this.a, bVar.a);
            }
            obj = bVar.b.get(i2);
            if (!obj.d) {
            }
            obj.b.onReceive(this.a, bVar.a);
            i2++;
            i++;
            throw th;
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter2) {
        Object arrayList;
        HashMap arrayList2;
        HashMap map;
        int obj7;
        final HashMap map2 = this.b;
        a.c cVar = new a.c(intentFilter2, broadcastReceiver);
        final int i = 1;
        synchronized (map2) {
            arrayList = new ArrayList(i);
            this.b.put(broadcastReceiver, arrayList);
            arrayList.add(cVar);
            obj7 = 0;
            try {
                while (obj7 < intentFilter2.countActions()) {
                    arrayList = intentFilter2.getAction(obj7);
                    if ((ArrayList)this.c.get(arrayList) == null) {
                    }
                    arrayList2.add(cVar);
                    obj7++;
                    arrayList2 = new ArrayList(i);
                    this.c.put(arrayList, arrayList2);
                }
                arrayList = intentFilter2.getAction(obj7);
                if ((ArrayList)this.c.get(arrayList) == null) {
                }
                arrayList2 = new ArrayList(i);
                this.c.put(arrayList, arrayList2);
                arrayList2.add(cVar);
                obj7++;
                throw broadcastReceiver;
            }
        }
    }

    public boolean d(Intent intent) {
        boolean messages;
        int str7;
        Object size;
        int string;
        int i;
        Object str;
        String str2;
        String string2;
        String action2;
        int i6;
        String stringBuilder;
        int str3;
        int arrayList;
        Object obj3;
        IntentFilter str5;
        String action;
        int i4;
        String resolveTypeIfNeeded;
        int i2;
        Object obj;
        int i3;
        int i5;
        String str4;
        Object obj2;
        String str6;
        final Object obj5 = this;
        Object obj4 = intent;
        final HashMap map = obj5.b;
        action = intent.getAction();
        final String scheme = intent.getScheme();
        synchronized (map) {
            i3 = 1;
            if (i3 != 0) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Resolving type ");
                stringBuilder4.append(obj4.resolveTypeIfNeeded(obj5.a.getContentResolver()));
                stringBuilder4.append(" scheme ");
                stringBuilder4.append(scheme);
                stringBuilder4.append(" of intent ");
                stringBuilder4.append(obj4);
                Log.v("LocalBroadcastManager", stringBuilder4.toString());
            }
            obj3 = size;
            if ((ArrayList)obj3 != null && i3 != 0) {
                if (i3 != 0) {
                    try {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Action list: ");
                        stringBuilder3.append((ArrayList)obj3);
                        Log.v("LocalBroadcastManager", stringBuilder3.toString());
                        arrayList = string;
                        str3 = 0;
                        while (str3 < obj3.size()) {
                            stringBuilder = str;
                            if (i3 != 0) {
                            }
                            if (stringBuilder.c) {
                            } else {
                            }
                            obj = stringBuilder;
                            i5 = str3;
                            str4 = action;
                            i4 = arrayList;
                            obj2 = obj3;
                            str6 = resolveTypeIfNeeded;
                            string = stringBuilder.a.match(action, resolveTypeIfNeeded, scheme, intent.getData(), intent.getCategories(), "LocalBroadcastManager");
                            if (string >= 0) {
                            } else {
                            }
                            if (i3 != 0) {
                            }
                            arrayList = i4;
                            str3 = i5 + 1;
                            action = str4;
                            obj3 = obj2;
                            resolveTypeIfNeeded = str6;
                            if (string != -4) {
                            } else {
                            }
                            str2 = "category";
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("  Filter did not match: ");
                            stringBuilder.append(str2);
                            Log.v("LocalBroadcastManager", stringBuilder.toString());
                            if (string != -3) {
                            } else {
                            }
                            str2 = "action";
                            if (string != -2) {
                            } else {
                            }
                            str2 = "data";
                            if (string != -1) {
                            } else {
                            }
                            str2 = "type";
                            str2 = "unknown reason";
                            if (i3 != 0) {
                            }
                            if (i4 == 0) {
                            } else {
                            }
                            arrayList = i4;
                            arrayList.add(obj);
                            obj.c = true;
                            arrayList = new ArrayList();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("  Filter matched!  match=0x");
                            stringBuilder.append(Integer.toHexString(string));
                            Log.v("LocalBroadcastManager", stringBuilder.toString());
                            if (i3 != 0) {
                            }
                            i5 = str3;
                            obj2 = obj3;
                            str4 = action;
                            str6 = resolveTypeIfNeeded;
                            i2 = 1;
                            i4 = arrayList;
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Matching against filter ");
                            stringBuilder2.append(stringBuilder.a);
                            Log.v("LocalBroadcastManager", stringBuilder2.toString());
                        }
                        stringBuilder = str;
                        if (i3 != 0) {
                        }
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Matching against filter ");
                        stringBuilder2.append(stringBuilder.a);
                        Log.v("LocalBroadcastManager", stringBuilder2.toString());
                        if (stringBuilder.c) {
                        } else {
                        }
                        if (i3 != 0) {
                        }
                        Log.v("LocalBroadcastManager", "  Filter's target already added");
                        i5 = str3;
                        obj2 = obj3;
                        str4 = action;
                        str6 = resolveTypeIfNeeded;
                        i2 = 1;
                        i4 = arrayList;
                        obj = stringBuilder;
                        i5 = str3;
                        str4 = action;
                        i4 = arrayList;
                        obj2 = obj3;
                        str6 = resolveTypeIfNeeded;
                        string = stringBuilder.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (string >= 0) {
                        } else {
                        }
                        if (i3 != 0) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("  Filter matched!  match=0x");
                        stringBuilder.append(Integer.toHexString(string));
                        Log.v("LocalBroadcastManager", stringBuilder.toString());
                        if (i4 == 0) {
                        } else {
                        }
                        arrayList = new ArrayList();
                        arrayList = i4;
                        arrayList.add(obj);
                        obj.c = true;
                        if (i3 != 0) {
                        }
                        if (string != -4) {
                        } else {
                        }
                        if (string != -3) {
                        } else {
                        }
                        if (string != -2) {
                        } else {
                        }
                        if (string != -1) {
                        } else {
                        }
                        str2 = "unknown reason";
                        str2 = "type";
                        str2 = "data";
                        str2 = "action";
                        str2 = "category";
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("  Filter did not match: ");
                        stringBuilder.append(str2);
                        Log.v("LocalBroadcastManager", stringBuilder.toString());
                        arrayList = i4;
                        str3 = i5 + 1;
                        action = str4;
                        obj3 = obj2;
                        resolveTypeIfNeeded = str6;
                        action = arrayList;
                        resolveTypeIfNeeded = 1;
                        if (action != 0) {
                        }
                        i = 0;
                        while (i < action.size()) {
                            action2.c = null;
                            i++;
                        }
                        action2.c = null;
                        i++;
                        a.b bVar = new a.b(obj4, action);
                        obj5.d.add(bVar);
                        if (!obj5.e.hasMessages(resolveTypeIfNeeded)) {
                        }
                        obj5.e.sendEmptyMessage(resolveTypeIfNeeded);
                        return resolveTypeIfNeeded;
                        return 0;
                        throw th;
                    }
                }
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        int i2;
        Object obj;
        int i;
        int countActions;
        Object size;
        int i3;
        Object obj2;
        BroadcastReceiver broadcastReceiver2;
        final HashMap map = this.b;
        Object remove = this.b.remove(broadcastReceiver);
        synchronized (map) {
        }
    }
}
