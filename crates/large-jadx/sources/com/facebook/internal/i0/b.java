package com.facebook.internal.i0;

import android.util.Base64;
import android.util.Log;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.d0.d.b0;
import kotlin.d0.d.n;
import kotlin.io.h;
import kotlin.k0.d;
import kotlin.k0.l;
import kotlin.w;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/internal/security/OidcSecurityUtil;", "", "()V", "OPENID_KEYS_PATH", "", "getOPENID_KEYS_PATH", "()Ljava/lang/String;", "SIGNATURE_ALGORITHM_SHA256", "TIMEOUT_IN_MILLISECONDS", "", "getPublicKeyFromString", "Ljava/security/PublicKey;", "key", "getRawKeyFromEndPoint", "kid", "verify", "", "publicKey", "data", "signature", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final String a = "/.well-known/oauth/openid/keys/";
    public static final com.facebook.internal.i0.b b;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final URL a;
        final b0 b;
        final String c;
        final ReentrantLock v;
        final Condition w;
        a(URL uRL, b0 b02, String string3, ReentrantLock reentrantLock4, Condition condition5) {
            this.a = uRL;
            this.b = b02;
            this.c = string3;
            this.v = reentrantLock4;
            this.w = condition5;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReentrantLock reentrantLock;
            Throwable th;
            w wVar;
            BufferedReader bufferedReader;
            Object inputStreamReader;
            if (a.d(this)) {
            }
            Object instrument = FirebasePerfUrlConnection.instrument(this.a.openConnection());
            if ((URLConnection)instrument == null) {
            } else {
                InputStream inputStream = (HttpURLConnection)(URLConnection)instrument.getInputStream();
                n.e(inputStream, "connection.inputStream");
                inputStreamReader = new InputStreamReader(inputStream, d.a);
                if (inputStreamReader instanceof BufferedReader) {
                } else {
                    bufferedReader = new BufferedReader((BufferedReader)inputStreamReader, 8192);
                    inputStreamReader = bufferedReader;
                }
                instrument.getInputStream().close();
                JSONObject jSONObject = new JSONObject(h.c(inputStreamReader));
                b0Var.element = jSONObject.optString(this.c);
                instrument.disconnect();
                this.v.lock();
                this.w.signal();
                wVar = w.a;
                try {
                    reentrantLock.unlock();
                    reentrantLock2.unlock();
                    throw th;
                    com.facebook.internal.i0.b bVar = b.b;
                    bVar = bVar.getClass();
                    bVar = bVar.getName();
                    th = th.getMessage();
                    if (th != null) {
                    } else {
                    }
                    th = "Error getting public key";
                    Log.d(bVar, th);
                    reentrantLock2.disconnect();
                    ReentrantLock reentrantLock2 = this.v;
                    reentrantLock2.lock();
                    th = this.w;
                    th.signal();
                    th = w.a;
                    reentrantLock2.unlock();
                    throw th;
                    reentrantLock2.disconnect();
                    reentrantLock2 = this.v;
                    reentrantLock2.lock();
                    bVar = this.w;
                    bVar.signal();
                    bVar = w.a;
                    reentrantLock2.unlock();
                    throw th;
                    reentrantLock2.unlock();
                    throw th;
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    throw nullPointerException;
                    a.b(reentrantLock2, this);
                } catch (Exception e) {
                } catch (Throwable th1) {
                }
            }
        }
    }
    static {
        b bVar = new b();
        b.b = bVar;
    }

    public static final PublicKey a(String string) {
        n.f(string, "key");
        byte[] obj13 = Base64.decode(l.G(l.G(l.G(string, "\n", "", false, 4, 0), "-----BEGIN PUBLIC KEY-----", "", false, 4, 0), "-----END PUBLIC KEY-----", "", false, 4, 0), 0);
        n.e(obj13, "Base64.decode(pubKeyString, Base64.DEFAULT)");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(obj13);
        obj13 = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        n.e(obj13, "kf.generatePublic(x509publicKey)");
        return obj13;
    }

    public static final String b(String string) {
        n.f(string, "kid");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("www.");
        stringBuilder.append(o.o());
        URL url = new URL("https", stringBuilder.toString(), b.a);
        ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition2 = reentrantLock.newCondition();
        b0 b0Var2 = new b0();
        b0Var2.element = 0;
        super(url, b0Var2, string, reentrantLock, condition2);
        o.n().execute(aVar2);
        reentrantLock.lock();
        condition2.await(5000, url);
        reentrantLock.unlock();
        return (String)b0Var2.element;
    }

    public static final boolean c(PublicKey publicKey, String string2, String string3) {
        n.f(publicKey, "publicKey");
        n.f(string2, "data");
        n.f(string3, "signature");
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initVerify(publicKey);
        byte[] obj1 = string2.getBytes(d.a);
        n.e(obj1, "(this as java.lang.String).getBytes(charset)");
        instance.update(obj1);
        obj1 = Base64.decode(string3, 8);
        n.e(obj1, "Base64.decode(signature, Base64.URL_SAFE)");
        return instance.verify(obj1);
    }
}
