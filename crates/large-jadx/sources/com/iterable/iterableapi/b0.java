package com.iterable.iterableapi;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b0 implements com.iterable.iterableapi.h0, com.iterable.iterableapi.g0.e {

    private final Context a;
    private Map<String, com.iterable.iterableapi.g0> b;
    private final HandlerThread c;
    com.iterable.iterableapi.b0.a d;

    class a extends Handler {

        final com.iterable.iterableapi.b0 a;
        a(com.iterable.iterableapi.b0 b0, Looper looper2) {
            this.a = b0;
            super(looper2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int obj2;
            if (message.what == 100) {
                b0.g(this.a);
            }
        }
    }
    b0(Context context) {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.b = Collections.synchronizedMap(linkedHashMap);
        HandlerThread handlerThread = new HandlerThread("FileOperationThread");
        this.c = handlerThread;
        this.a = context;
        handlerThread.start();
        b0.a obj3 = new b0.a(this, handlerThread.getLooper());
        this.d = obj3;
        o();
    }

    static void g(com.iterable.iterableapi.b0 b0) {
        b0.t();
    }

    private void h() {
        Object value;
        int i;
        Iterator iterator = this.b.entrySet().iterator();
        synchronized (this) {
            try {
                for (Map.Entry next2 : iterator) {
                    (g0)next2.getValue().x(0);
                }
                (g0)(Map.Entry)iterator.next().getValue().x(0);
                this.b.clear();
                throw th;
            }
        }
    }

    private File i(String string) {
        boolean directory;
        String str;
        File obj4 = k(string);
        final int i = 0;
        File file = new File(obj4, "index.html");
        if (obj4.isDirectory() != null && file.exists() != null) {
            file = new File(obj4, "index.html");
            if (file.exists() != null) {
                j0.h("IterableInAppFileStorage", "Directory with file already exists. No need to store again");
                return i;
            }
        }
        if (obj4.mkdir()) {
            return obj4;
        }
        return i;
    }

    private File j(String string) {
        File file = new File(k(string), "index.html");
        return file;
    }

    private File k(String string) {
        File file = new File(m(), string);
        return file;
    }

    private File l() {
        File file = new File(z0.g(this.a), "itbl_inapp.json");
        return file;
    }

    private File m() {
        return z0.e(z0.f(this.a), "IterableInAppFileStorage");
    }

    private File n() {
        File file = new File(m(), "itbl_inapp.json");
        return file;
    }

    private void o() {
        String jSONObject2;
        JSONObject jSONObject;
        String str;
        try {
            File file = n();
            if (file.exists() != null) {
            } else {
            }
            jSONObject = new JSONObject(z0.j(file));
            p(jSONObject);
            if (l().exists()) {
            }
            jSONObject2 = new JSONObject(z0.j(l()));
            p(jSONObject2);
            j0.d("IterableInAppFileStorage", "Error while loading in-app messages from file", th);
        }
    }

    private void p(JSONObject jSONObject) {
        String str;
        int optJSONObject;
        Map map;
        String str2;
        h();
        final JSONArray obj5 = jSONObject.optJSONArray("inAppMessages");
        if (obj5 != null) {
            str = 0;
            while (str < obj5.length()) {
                optJSONObject = obj5.optJSONObject(str);
                optJSONObject = g0.d(optJSONObject, this);
                if (optJSONObject != null && optJSONObject != null) {
                }
                str++;
                optJSONObject = g0.d(optJSONObject, this);
                if (optJSONObject != null) {
                }
                optJSONObject.x(this);
                this.b.put(optJSONObject.i(), optJSONObject);
            }
        }
    }

    private void s() {
        Object next;
        boolean z;
        String str;
        Iterator iterator = this.b.values().iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((g0)next.m()) {
                    }
                    r(next.i(), aVar.a);
                    next.w(false);
                }
                next = iterator.next();
                if ((g0)next.m()) {
                }
                r(next.i(), aVar.a);
                next.w(false);
                throw th;
            }
        }
    }

    private void t() {
        s();
        v();
        return;
        synchronized (this) {
            s();
            v();
        }
    }

    private void u() {
        boolean messages;
        int i;
        final int i2 = 100;
        if (!this.d.hasMessages(i2)) {
            this.d.sendEmptyMessageDelayed(i2, 100);
        }
    }

    private void v() {
        File file;
        String string;
        String str;
        z0.m(n(), w().toString());
        synchronized (this) {
        }
    }

    private JSONObject w() {
        JSONArray jSONArray;
        String str2;
        Object str;
        boolean next;
        JSONObject jSONObject = new JSONObject();
        jSONArray = new JSONArray();
        Iterator iterator = this.b.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            jSONArray.put((g0)next2.getValue().A());
        }
        jSONObject.putOpt("inAppMessages", jSONArray);
        return jSONObject;
    }

    public List<com.iterable.iterableapi.g0> a() {
        ArrayList arrayList = new ArrayList(this.b.values());
        return arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.b.values());
            return arrayList;
        }
    }

    @Override // com.iterable.iterableapi.h0
    public void b(com.iterable.iterableapi.g0 g0) {
        g0.x(0);
        q(g0.i());
        this.b.remove(g0.i());
        u();
        return;
        synchronized (this) {
            g0.x(0);
            q(g0.i());
            this.b.remove(g0.i());
            u();
        }
    }

    @Override // com.iterable.iterableapi.h0
    public String c(String string) {
        return z0.j(j(string));
    }

    @Override // com.iterable.iterableapi.h0
    public com.iterable.iterableapi.g0 d(String string) {
        return (g0)this.b.get(string);
        synchronized (this) {
            return (g0)this.b.get(string);
        }
    }

    @Override // com.iterable.iterableapi.h0
    public void e(com.iterable.iterableapi.g0 g0) {
        u();
    }

    @Override // com.iterable.iterableapi.h0
    public void f(com.iterable.iterableapi.g0 g0) {
        this.b.put(g0.i(), g0);
        g0.x(this);
        u();
        return;
        synchronized (this) {
            this.b.put(g0.i(), g0);
            g0.x(this);
            u();
        }
    }

    @Override // com.iterable.iterableapi.h0
    public void q(String string) {
        int i;
        File file;
        final File obj5 = k(string);
        final File[] listFiles = obj5.listFiles();
        if (listFiles == null) {
        }
        i = 0;
        while (i < listFiles.length) {
            listFiles[i].delete();
            i++;
        }
        obj5.delete();
    }

    @Override // com.iterable.iterableapi.h0
    public void r(String string, String string2) {
        boolean obj4;
        obj4 = i(string);
        final String str = "IterableInAppFileStorage";
        if (obj4 == null) {
            j0.c(str, "Failed to create folder for HTML content");
        }
        File file = new File(obj4, "index.html");
        if (z0.m(file, string2) == null) {
            j0.c(str, "Failed to store HTML content");
        }
    }
}
