package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 #2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001#B\u001b\u0008\u0016\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\u0008B\u0015\u0008\u0016\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nB\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cB%\u0008\u0016\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\u000fB\u001f\u0008\u0016\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\u0010B\u0017\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J)\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u001b\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u0006\"\u00020\u0002H\u0017¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u0008\u0010 \u001a\u00020\u001eH\u0017J\u0008\u0010!\u001a\u00020\"H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\u000e\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006$", d2 = {"Lcom/facebook/GraphRequestAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/facebook/GraphResponse;", "requests", "", "Lcom/facebook/GraphRequest;", "([Lcom/facebook/GraphRequest;)V", "", "(Ljava/util/Collection;)V", "Lcom/facebook/GraphRequestBatch;", "(Lcom/facebook/GraphRequestBatch;)V", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;[Lcom/facebook/GraphRequest;)V", "(Ljava/net/HttpURLConnection;Ljava/util/Collection;)V", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "getRequests", "()Lcom/facebook/GraphRequestBatch;", "doInBackground", "params", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "onPreExecute", "toString", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public class q extends AsyncTask<Void, Void, List<? extends com.facebook.s>> {

    private static final String d;
    private Exception a;
    private final HttpURLConnection b;
    private final com.facebook.r c;
    static {
        q.d = q.class.getCanonicalName();
    }

    public q(com.facebook.r r) {
        n.f(r, "requests");
        super(0, r);
    }

    public q(HttpURLConnection httpURLConnection, com.facebook.r r2) {
        n.f(r2, "requests");
        super();
        this.b = httpURLConnection;
        this.c = r2;
    }

    public List<com.facebook.s> a(Void... voidArr) {
        Object str;
        com.facebook.r rVar;
        List obj4;
        if (a.d(this)) {
            return 0;
        }
        n.f(voidArr, "params");
        obj4 = this.b;
        if (obj4 == null) {
            obj4 = this.c.i();
        } else {
            obj4 = p.t.m(obj4, this.c);
        }
        return obj4;
    }

    protected void b(List<com.facebook.s> list) {
        String str2;
        String str;
        int i;
        Object[] arr;
        int i2;
        Object obj6;
        if (a.d(this)) {
        }
        n.f(list, "result");
        super.onPostExecute(list);
        obj6 = this.a;
        if (obj6 != null) {
            f0 f0Var = f0.a;
            i = 1;
            arr = new Object[i];
            arr[0] = obj6.getMessage();
            obj6 = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(arr, i));
            n.e(obj6, "java.lang.String.format(format, *args)");
            b0.d0(q.d, obj6);
        }
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objectArr) {
        if (a.d(this)) {
            return null;
        }
        return a((Void[])objectArr);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object object) {
        if (a.d(this)) {
        }
        b((List)object);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        boolean z;
        Handler handler;
        String mainLooper;
        String str;
        Object[] arr;
        int i;
        if (a.d(this)) {
        }
        super.onPreExecute();
        if (o.v()) {
            f0 f0Var = f0.a;
            int i2 = 1;
            arr = new Object[i2];
            arr[0] = this;
            mainLooper = String.format("execute async task: %s", Arrays.copyOf(arr, i2));
            n.e(mainLooper, "java.lang.String.format(format, *args)");
            b0.d0(q.d, mainLooper);
        }
        if (this.c.t() == null) {
            if (currentThread instanceof HandlerThread) {
                handler = new Handler();
            } else {
                try {
                    handler = new Handler(Looper.getMainLooper());
                    this.c.G(handler);
                    a.b(th, this);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{RequestAsyncTask: ");
        stringBuilder.append(" connection: ");
        stringBuilder.append(this.b);
        stringBuilder.append(", requests: ");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return string;
    }
}
