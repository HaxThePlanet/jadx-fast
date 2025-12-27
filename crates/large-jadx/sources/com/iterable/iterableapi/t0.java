package com.iterable.iterableapi;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableRequestTask.java */
/* loaded from: classes2.dex */
class t0 extends AsyncTask<l, Void, m> {

    static String c;
    int a = 0;
    l b;

    class a implements Runnable {

        final /* synthetic */ t0 a;
        final /* synthetic */ t0 b;
        a(t0 t0Var) {
            this.b = t0Var;
            this.a = t0Var2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.iterable.iterableapi.l[] arr = new l[1];
            this.a.execute(new l[] { this.b.b });
        }
    }
    t0() {
        super();
    }

    private static String a(HttpURLConnection httpURLConnection) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nHeaders { \n");
        Iterator it = httpURLConnection.getRequestProperties().keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static m c(l lVar) {
        Throwable obj;
        com.iterable.iterableapi.l lVar3;
        Object lVar2;
        String str;
        String str4;
        Exception exc;
        int responseCode;
        JSONObject jSONObject7;
        int i = 0;
        com.iterable.iterableapi.m mVar = null;
        String string;
        int length = 200;
        int i8;
        Object instrument;
        String str6;
        Exception exc2;
        BufferedReader bufferedReader;
        String str8;
        int i2 = 500;
        java.io.InputStream errorStream;
        JSONObject jSONObject2;
        Iterator keys;
        Exception message;
        String str11 = null;
        lVar2 = lVar;
        str = "msg";
        str4 = "application/json";
        str = "======================================";
        if (lVar2 != null) {
            str4 = "IterableRequest";
            j0.h(str4, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
            String str34 = lVar2.b != null && !lVar2.b.isEmpty() ? lVar2.b : "https://api.iterable.com/api/";
            try {
                str10 = t0.c;
            } catch (Exception e) {
                i8 = 0;
                exc2 = null;
            } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds1) {
                i8 = 0;
                exc2 = null;
            } catch (java.io.IOException ioException2) {
                i8 = 0;
                exc2 = null;
            } catch (org.json.JSONException jSON3) {
                i8 = 0;
                exc2 = null;
            } catch (Throwable th4) {
                lVar3 = th4;
                jSONObject7 = null;
            }
            if (t0.c != null && !t0.c.isEmpty()) {
                str6 = t0.c;
            }
            try {
            } catch (Exception e) {
                i8 = 0;
                exc2 = null;
            } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds1) {
                i8 = 0;
                exc2 = null;
            } catch (java.io.IOException ioException2) {
                i8 = 0;
                exc2 = null;
            } catch (org.json.JSONException jSON3) {
                i8 = 0;
                exc2 = null;
            } catch (Throwable th4) {
                lVar3 = th4;
                jSONObject7 = null;
            }
            exc = th4;
            try {
                t0.e(lVar3, str34, exc);
                lVar3 = exc.getMessage();
                exc = null;
                jSONObject7 = null;
                lVar3 = m.a(exc, exc2, jSONObject7, lVar3);
                exc = th4;
                i8 = 0;
                exc2 = null;
                t0.e(lVar3, str34, exc);
                lVar3 = exc.getMessage();
                exc = null;
                jSONObject7 = null;
                lVar3 = m.a(exc, exc2, jSONObject7, lVar3);
                exc = th4;
                i8 = 0;
                exc2 = null;
                t0.e(lVar3, str34, exc);
                lVar3 = exc.getMessage();
                exc = null;
                jSONObject7 = null;
                lVar3 = m.a(exc, exc2, jSONObject7, lVar3);
                exc = th4;
                i8 = 0;
                exc2 = null;
                t0.e(lVar3, str34, exc);
                lVar3 = exc.getMessage();
                exc = null;
                jSONObject7 = null;
                lVar3 = m.a(exc, exc2, jSONObject7, lVar3);
            } catch (Throwable th) {
                lVar3 = th;
                jSONObject7 = i8;
            }
            jSONObject7 = lVar3;
            j0.h(str4, str);
        } else {
            i = 0;
        }
        return i;
    }

    private static boolean d(String str) {
        boolean equals;
        boolean z = false;
        if (!str.equals("Api-Key")) {
            str2 = "Authorization";
            if (str.equals(str2)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    private static void e(l lVar, String str, Exception exc) {
        final StringBuilder stringBuilder = new StringBuilder();
        str = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nException occurred for : ";
        str4 = str + str + lVar.c;
        final String str5 = "IterableRequest";
        j0.c(str5, str4);
        j0.d(str5, exc.getMessage(), exc);
    }

    private static boolean f(JSONObject jSONObject, String str) {
        str = "code";
        int i = 0;
        if (jSONObject != null && jSONObject.has(str)) {
            if (jSONObject.getString(str).equals(str)) {
                int i2 = 1;
            }
        }
        return z2;
    }

    @Override // android.os.AsyncTask
    protected m b(l... lVarArr) {
        if (lVarArr != null) {
            length = lVarArr.length;
            if (lVarArr.length > 0) {
                int length = 0;
                this.b = lVarArr[length];
            }
        }
        return t0.c(this.b);
    }

    @Override // android.os.AsyncTask
    protected void g(m mVar) {
        int i = 0;
        int i2 = 1;
        int i5 = 500;
        i2 = 1;
        if (!mVar.a) {
            i5 = 500;
            int r2 = mVar.b >= 500 ? i2 : 0;
        }
        if (this.a != 0 && this.a <= 5) {
            final com.iterable.iterableapi.t0 t0Var = new t0();
            t0Var.h(this.a + i2);
            i = 0;
            if (this.a > 2) {
                long l = 2000L * (long)i4;
            }
            new Handler().postDelayed(new t0.a(this, t0Var), i);
            return;
        }
        if (!mVar.a) {
            str = "InvalidJwtPayload";
            if (t0.f(mVar.d, str)) {
                j.s().m().i(true);
            }
            if (this.b.j != null) {
                this.b.j.a(mVar.e, mVar.d);
            }
        } else {
            j.s().m().j();
            if (this.b.i != null) {
                this.b.i.a(mVar.d);
            }
        }
        if (this.b.h != null) {
            this.b.h.a(mVar.c);
        }
        super.onPostExecute(mVar);
    }

    @Override // android.os.AsyncTask
    protected void h(int i) {
        this.a = i;
    }
}
