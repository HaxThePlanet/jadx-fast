package com.facebook.e0.v;

import android.os.AsyncTask;
import com.facebook.internal.g0.i.a;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\u00042\u0016\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00020\r\"\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "uriStr", "destFile", "Ljava/io/File;", "onSuccess", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "(Ljava/lang/String;Ljava/io/File;Lcom/facebook/appevents/internal/FileDownloadTask$Callback;)V", "doInBackground", "args", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "onPostExecute", "", "isSuccess", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f extends AsyncTask<String, Void, Boolean> {

    private final String a;
    private final File b;
    private final com.facebook.e0.v.f.a c;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "", "onComplete", "", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a(File file);
    }
    public f(String string, File file2, com.facebook.e0.v.f.a f$a3) {
        n.f(string, "uriStr");
        n.f(file2, "destFile");
        n.f(a3, "onSuccess");
        super();
        this.a = string;
        this.b = file2;
        this.c = a3;
    }

    @Override // android.os.AsyncTask
    public Boolean a(String... stringArr) {
        if (a.d(this)) {
            return null;
        }
        n.f(stringArr, "args");
        URL obj5 = new URL(this.a);
        Object instrument = FirebasePerfUrlConnection.instrument(obj5.openConnection());
        n.e((URLConnection)instrument, "conn");
        DataInputStream dataInputStream = new DataInputStream(FirebasePerfUrlConnection.openStream(obj5));
        obj5 = new byte[instrument.getContentLength()];
        dataInputStream.readFully(obj5);
        dataInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(this.b);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.write(obj5);
        dataOutputStream.flush();
        dataOutputStream.close();
        return Boolean.TRUE;
    }

    @Override // android.os.AsyncTask
    protected void b(boolean z) {
        boolean z2;
        Object obj2;
        if (a.d(this)) {
        }
        if (z != null) {
            this.c.a(this.b);
        }
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objectArr) {
        if (a.d(this)) {
            return null;
        }
        return a((String[])objectArr);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object object) {
        if (a.d(this)) {
        }
        b((Boolean)object.booleanValue());
    }
}
