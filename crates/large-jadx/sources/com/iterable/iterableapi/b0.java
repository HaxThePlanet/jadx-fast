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
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableInAppFileStorage.java */
/* loaded from: classes2.dex */
public class b0 implements h0, g0.e {

    private final Context a;
    private Map<String, g0> b;
    private final HandlerThread c = new HandlerThread("FileOperationThread");
    b0.a d = new b0$a();

    class a extends Handler {

        final /* synthetic */ b0 a;
        a(Looper looper) {
            this.a = b0Var;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                this.a.t();
            }
        }
    }
    b0(Context context) {
        super();
        this.b = Collections.synchronizedMap(new LinkedHashMap());
        HandlerThread handlerThread = new HandlerThread("FileOperationThread");
        this.a = context;
        handlerThread.start();
        final com.iterable.iterableapi.b0.a aVar = new b0.a(this, handlerThread.getLooper());
        o();
    }

    static /* synthetic */ void g(b0 b0Var) {
        b0Var.t();
    }

    private synchronized void h() {
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            com.iterable.iterableapi.g0.e eVar = null;
            (g0)(Map.Entry)it.next().getValue().x(eVar);
        }
        this.b.clear();
    }

    private File i(String str) {
        File file2 = k(str);
        final int i = 0;
        if (file2.isDirectory() && file.exists()) {
            j0.h("IterableInAppFileStorage", "Directory with file already exists. No need to store again");
            return null;
        }
        return file2.mkdir() != null ? file2 : i;
    }

    private File j(String str) {
        return new File(k(str), "index.html");
    }

    private File k(String str) {
        return new File(m(), str);
    }

    private File l() {
        return new File(z0.g(this.a), "itbl_inapp.json");
    }

    private File m() {
        return z0.e(z0.f(this.a), "IterableInAppFileStorage");
    }

    private File n() {
        return new File(m(), "itbl_inapp.json");
    }

    private void o() throws JSONException {
        try {
            File file = n();
            p(new JSONObject(z0.j(file)));
            p(new JSONObject(z0.j(l())));
        } catch (Exception e) {
            j0.d("IterableInAppFileStorage", "Error while loading in-app messages from file", e);
        }
    }

    private void p(JSONObject jSONObject) {
        int i = 0;
        JSONObject optJSONObject;
        Map map;
        String str2;
        h();
        str = "inAppMessages";
        final JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            i = 0;
            while (i < optJSONArray.length()) {
                optJSONObject = optJSONArray.optJSONObject(i);
                i = i + 1;
            }
        }
    }

    private synchronized void s() {
        String str;
        Iterator it = this.b.values().iterator();
        Object item = it.next();
        r(item.i(), item.e().a);
        boolean z = false;
        item.w(z);
    }

    private synchronized void t() {
        s();
        v();
    }

    private void u() {
        final int i = 100;
        if (!this.d.hasMessages(i)) {
            long l = 100L;
            this.d.sendEmptyMessageDelayed(i, l);
        }
    }

    private synchronized void v() {
        try {
            z0.m(n(), w().toString());
        } catch (Throwable th) {
        }
    }

    private JSONObject w() {
        final JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                jSONArray.put((g0)(Map.Entry)it.next().getValue().A());
            }
            str = "inAppMessages";
            jSONObject2.putOpt(str, jSONArray);
        } catch (org.json.JSONException jSON) {
            j0.d("IterableInAppFileStorage", "Error while serializing messages", jSON);
        }
        return jSONObject2;
    }

    public synchronized List<g0> a() {
        return new ArrayList(this.b.values());
    }

    public synchronized void b(g0 g0Var) {
        g0Var.x(null);
        q(g0Var.i());
        this.b.remove(g0Var.i());
        u();
    }

    public String c(String str) {
        return z0.j(j(str));
    }

    public synchronized g0 d(String str) {
        return (g0)this.b.get(str);
    }

    public void e(g0 g0Var) {
        u();
    }

    public synchronized void f(g0 g0Var) {
        this.b.put(g0Var.i(), g0Var);
        g0Var.x(this);
        u();
    }

    public void q(String str) {
        int i = 0;
        final File file2 = k(str);
        final File[] listFiles = file2.listFiles();
        if (listFiles == null) {
            return;
        }
        i = 0;
        for (File file : listFiles) {
            file.delete();
        }
        file2.delete();
    }

    public void r(String str, String str2) {
        File file2 = i(str);
        final String str3 = "IterableInAppFileStorage";
        if (file2 == null) {
            j0.c(str3, "Failed to create folder for HTML content");
            return;
        }
        if (z0.m(new File(file2, "index.html"), str2) == null) {
            j0.c(str3, "Failed to store HTML content");
        }
    }
}
