package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import com.facebook.internal.t;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.internal.z;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.l;
import kotlin.y.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0018\u0000 b2\u00020\u0001:\t`abcdefghBO\u0008\u0017\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rB\u0019\u0008\u0010\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0008\u0010G\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u001eH\u0002J\u0006\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020OJ\n\u0010P\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0008\u0010S\u001a\u00020\u001eH\u0002J\u0008\u0010T\u001a\u00020\u001eH\u0002J$\u0010U\u001a\u00020H2\u0006\u0010V\u001a\u00020W2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Z0YH\u0002J\u000e\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\u001eJ\u0010\u0010]\u001a\u00020H2\u0006\u0010=\u001a\u00020\u001eH\u0007J\u0008\u0010^\u001a\u00020\u001eH\u0002J\u0008\u0010_\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017\"\u0004\u0008\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R(\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R\u000e\u0010'\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010\u0017\"\u0004\u0008/\u0010\u0019R\u0016\u00100\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00081\u0010\u0017R(\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u00102\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u00104\"\u0004\u00085\u00106R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u00108\"\u0004\u00089\u0010:R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008<\u0010\u0017R\u000e\u0010=\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010@\"\u0004\u0008A\u0010BR\u0011\u0010C\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008D\u0010\u0017R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010\u0017\"\u0004\u0008F\u0010\u0019¨\u0006i", d2 = {"Lcom/facebook/GraphRequest;", "", "accessToken", "Lcom/facebook/AccessToken;", "graphPath", "", "parameters", "Landroid/os/Bundle;", "httpMethod", "Lcom/facebook/HttpMethod;", "callback", "Lcom/facebook/GraphRequest$Callback;", "version", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", "overriddenURL", "Ljava/net/URL;", "(Lcom/facebook/AccessToken;Ljava/net/URL;)V", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "batchEntryDependsOn", "getBatchEntryDependsOn", "()Ljava/lang/String;", "setBatchEntryDependsOn", "(Ljava/lang/String;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryOmitResultOnSuccess", "", "getBatchEntryOmitResultOnSuccess", "()Z", "setBatchEntryOmitResultOnSuccess", "(Z)V", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "forceApplicationRequest", "graphObject", "Lorg/json/JSONObject;", "getGraphObject", "()Lorg/json/JSONObject;", "setGraphObject", "(Lorg/json/JSONObject;)V", "getGraphPath", "setGraphPath", "graphPathWithVersion", "getGraphPathWithVersion", "value", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", "relativeUrlForBatchedRequest", "getRelativeUrlForBatchedRequest", "skipClientToken", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "urlForSingleRequest", "getUrlForSingleRequest", "getVersion", "setVersion", "addCommonParameters", "", "appendParametersToBaseUrl", "baseUrl", "isBatch", "executeAndWait", "Lcom/facebook/GraphResponse;", "executeAsync", "Lcom/facebook/GraphRequestAsyncTask;", "getAccessTokenToUseForRequest", "getClientTokenForRequest", "getUrlWithGraphPath", "isApplicationRequest", "isValidGraphRequestForDomain", "serializeToBatch", "batch", "Lorg/json/JSONArray;", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "setForceApplicationRequest", "forceOverride", "setSkipClientToken", "shouldForceClientTokenForRequest", "toString", "Attachment", "Callback", "Companion", "GraphJSONArrayCallback", "GraphJSONObjectCallback", "KeyValueSerializer", "OnProgressCallback", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class p {

    public static final String o;
    private static final String p;
    private static String q;
    private static final Pattern r;
    private static volatile String s;
    public static final com.facebook.p.c t;
    private com.facebook.a a;
    private String b;
    private JSONObject c;
    private String d;
    private String e;
    private boolean f;
    private Bundle g;
    private Object h;
    private String i;
    private com.facebook.p.b j;
    private com.facebook.t k;
    private boolean l;
    private boolean m;
    private String n;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class a {

        private final com.facebook.p a;
        private final Object b;
        public a(com.facebook.p p, Object object2) {
            n.f(p, "request");
            super();
            this.a = p;
            this.b = object2;
        }

        public final com.facebook.p a() {
            return this.a;
        }

        public final Object b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/GraphRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface b {
        public abstract void b(com.facebook.s s);
    }

    @Metadata(d1 = "\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0007J\u0016\u0010A\u001a\u0008\u0012\u0004\u0012\u00020>0B2\u0006\u0010C\u001a\u00020DH\u0007J'\u0010A\u001a\u0008\u0012\u0004\u0012\u00020>0B2\u0012\u0010C\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020@0E\"\u00020@H\u0007¢\u0006\u0002\u0010FJ\u001c\u0010A\u001a\u0008\u0012\u0004\u0012\u00020>0B2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020@0GH\u0007J\u0010\u0010H\u001a\u00020I2\u0006\u0010C\u001a\u00020DH\u0007J!\u0010H\u001a\u00020I2\u0012\u0010C\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020@0E\"\u00020@H\u0007¢\u0006\u0002\u0010JJ\u0016\u0010H\u001a\u00020I2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020@0GH\u0007J\u001e\u0010K\u001a\u0008\u0012\u0004\u0012\u00020>0B2\u0006\u0010L\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J$\u0010K\u001a\u0008\u0012\u0004\u0012\u00020>0B2\u0006\u0010L\u001a\u00020:2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020@0GH\u0007J\"\u0010M\u001a\u00020I2\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010L\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J\u0018\u0010M\u001a\u00020I2\u0006\u0010L\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J\u0010\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020DH\u0002J\n\u0010R\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010S\u001a\u00020\u00042\u0008\u0010T\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010U\u001a\u00020V2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010W\u001a\u00020V2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020\u0004H\u0002J\u0012\u0010Z\u001a\u00020V2\u0008\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\\\u001a\u00020V2\u0008\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010]\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020a2\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007J.\u0010]\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020a2\u0008\u0010d\u001a\u0004\u0018\u00010\u00042\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007J&\u0010e\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010f\u001a\u0004\u0018\u00010\u00042\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007J&\u0010g\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010T\u001a\u0004\u0018\u00010\u00042\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007J\u001c\u0010h\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010b\u001a\u0004\u0018\u00010iH\u0007J\u001c\u0010j\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010b\u001a\u0004\u0018\u00010kH\u0007J@\u0010l\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020 2\u0006\u0010p\u001a\u00020 2\u0008\u0010q\u001a\u0004\u0018\u00010\u00042\u0008\u0010b\u001a\u0004\u0018\u00010kH\u0007J0\u0010r\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010T\u001a\u0004\u0018\u00010\u00042\u0008\u0010s\u001a\u0004\u0018\u00010t2\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007JD\u0010u\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010T\u001a\u0004\u0018\u00010\u00042\u0008\u0010v\u001a\u0004\u0018\u00010w2\u0008\u0010x\u001a\u0004\u0018\u00010\u00042\u0008\u0010y\u001a\u0004\u0018\u00010z2\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007JB\u0010u\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010T\u001a\u0004\u0018\u00010\u00042\u0006\u0010{\u001a\u00020|2\u0008\u0010x\u001a\u0004\u0018\u00010\u00042\u0008\u0010y\u001a\u0004\u0018\u00010z2\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007JD\u0010u\u001a\u00020@2\u0008\u0010^\u001a\u0004\u0018\u00010_2\u0008\u0010T\u001a\u0004\u0018\u00010\u00042\u0008\u0010}\u001a\u0004\u0018\u00010~2\u0008\u0010x\u001a\u0004\u0018\u00010\u00042\u0008\u0010y\u001a\u0004\u0018\u00010z2\u0008\u0010b\u001a\u0004\u0018\u00010cH\u0007J\u0012\u0010\u007f\u001a\u00020\u00042\u0008\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010s\u001a\u00020t2\u0006\u0010Y\u001a\u00020\u00042\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J.\u0010\u0084\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0086\u0001\u001a\u00020VH\u0002JB\u0010\u0087\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020D2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0008\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020VH\u0002J'\u0010\u008e\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020D2\r\u0010\u008f\u0001\u001a\u0008\u0012\u0004\u0012\u00020>0BH\u0001¢\u0006\u0003\u0008\u0090\u0001J+\u0010\u0091\u0001\u001a\u00030\u0081\u00012\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0095\u0001H\u0002J%\u0010\u0096\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0097\u0001\u001a\u00020z2\u0008\u0010\u0082\u0001\u001a\u00030\u0095\u00012\u0006\u0010?\u001a\u00020@H\u0002J9\u0010\u0098\u0001\u001a\u00030\u0081\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0095\u00012\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020@0G2\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0094\u00010\u0099\u0001H\u0002J \u0010\u009a\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020D2\u0006\u0010L\u001a\u00020:H\u0001¢\u0006\u0003\u0008\u009b\u0001J\u001b\u0010\u009c\u0001\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020:2\u0007\u0010\u008d\u0001\u001a\u00020VH\u0002J\u0014\u0010\u009d\u0001\u001a\u00030\u0081\u00012\u0008\u0010d\u001a\u0004\u0018\u00010\u0004H\u0007J\u0011\u0010\u009e\u0001\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J#\u0010\u009e\u0001\u001a\u00020:2\u0012\u0010C\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020@0E\"\u00020@H\u0007¢\u0006\u0003\u0010\u009f\u0001J\u0017\u0010\u009e\u0001\u001a\u00020:2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020@0GH\u0007J\u0018\u0010 \u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0003\u0008¡\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008*\u0010\u0002R\u000e\u0010+\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R\u001e\u00102\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u00101\"\u0004\u00084\u00105R\u0016\u00106\u001a\n 8*\u0004\u0018\u00010707X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001", d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "()V", "ACCEPT_LANGUAGE_HEADER", "", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", "SEARCH", "TAG", "getTAG$facebook_core_release$annotations", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "mimeContentType", "getMimeContentType", "()Ljava/lang/String;", "userAgent", "getUserAgent", "setUserAgent", "(Ljava/lang/String;)V", "versionPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "createConnection", "Ljava/net/HttpURLConnection;", "url", "Ljava/net/URL;", "executeAndWait", "Lcom/facebook/GraphResponse;", "request", "Lcom/facebook/GraphRequest;", "executeBatchAndWait", "", "requests", "Lcom/facebook/GraphRequestBatch;", "", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "", "executeBatchAsync", "Lcom/facebook/GraphRequestAsyncTask;", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "connection", "executeConnectionAsync", "callbackHandler", "Landroid/os/Handler;", "getBatchAppId", "batch", "getDefaultBatchApplicationId", "getDefaultPhotoPathIfNull", "graphPath", "hasOnProgressCallbacks", "", "isGzipCompressible", "isMeRequest", "path", "isSupportedAttachmentType", "value", "isSupportedParameterType", "newCustomAudienceThirdPartyIdRequest", "accessToken", "Lcom/facebook/AccessToken;", "context", "Landroid/content/Context;", "callback", "Lcom/facebook/GraphRequest$Callback;", "applicationId", "newDeleteObjectRequest", "id", "newGraphPathRequest", "newMeRequest", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMyFriendsRequest", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newPlacesSearchRequest", "location", "Landroid/location/Location;", "radiusInMeters", "resultsLimit", "searchText", "newPostRequest", "graphObject", "Lorg/json/JSONObject;", "newUploadPhotoRequest", "image", "Landroid/graphics/Bitmap;", "caption", "params", "Landroid/os/Bundle;", "photoUri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "parameterToString", "processGraphObject", "", "serializer", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "processGraphObjectProperty", "key", "passByValue", "processRequest", "logger", "Lcom/facebook/internal/Logger;", "numRequests", "outputStream", "Ljava/io/OutputStream;", "shouldUseGzip", "runCallbacks", "responses", "runCallbacks$facebook_core_release", "serializeAttachments", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "Lcom/facebook/GraphRequest$Serializer;", "serializeParameters", "bundle", "serializeRequestsAsJSON", "", "serializeToUrlConnection", "serializeToUrlConnection$facebook_core_release", "setConnectionContentType", "setDefaultBatchApplicationId", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "validateFieldsParamForGetRequests", "validateFieldsParamForGetRequests$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c {
        public c(g g) {
            super();
        }

        private final void A(String string, Object object2, com.facebook.p.e p$e3, boolean z4) {
            int length;
            int assignableFrom2;
            boolean assignableFrom;
            String format;
            Object str2;
            String str;
            Object obj10;
            boolean obj12;
            length = object2.getClass();
            final int i = 2;
            final int i2 = 1;
            final int i3 = 0;
            if (JSONObject.class.isAssignableFrom(length)) {
                Objects.requireNonNull(object2, "null cannot be cast to non-null type org.json.JSONObject");
                if (z4) {
                    length = (JSONObject)object2.keys();
                    for (String next : length) {
                        f0 f0Var2 = f0.a;
                        Object[] arr = new Object[i];
                        arr[i3] = string;
                        arr[i2] = next;
                        format = String.format("%s[%s]", Arrays.copyOf(arr, i));
                        n.e(format, "java.lang.String.format(format, *args)");
                        assignableFrom = object2.opt(next);
                        n.e(assignableFrom, "jsonObject.opt(propertyName)");
                        A(format, assignableFrom, e3, z4);
                    }
                } else {
                    String str5 = "id";
                    if (object2.has(str5)) {
                        obj10 = object2.optString(str5);
                        n.e(obj10, "jsonObject.optString(\"id\")");
                        A(string, obj10, e3, z4);
                    } else {
                        String str6 = "url";
                        if (object2.has(str6)) {
                            obj10 = object2.optString(str6);
                            n.e(obj10, "jsonObject.optString(\"url\")");
                            A(string, obj10, e3, z4);
                        } else {
                            if (object2.has("fbsdk:create_object")) {
                                obj10 = object2.toString();
                                n.e(obj10, "jsonObject.toString()");
                                A(string, obj10, e3, z4);
                            }
                        }
                    }
                }
            } else {
                if (JSONArray.class.isAssignableFrom(length)) {
                    Objects.requireNonNull(object2, "null cannot be cast to non-null type org.json.JSONArray");
                    assignableFrom2 = i3;
                    while (assignableFrom2 < (JSONArray)object2.length()) {
                        f0 f0Var = f0.a;
                        Object[] arr2 = new Object[i];
                        arr2[i3] = string;
                        arr2[i2] = Integer.valueOf(assignableFrom2);
                        format = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(arr2, i));
                        n.e(format, "java.lang.String.format(locale, format, *args)");
                        str2 = object2.opt(assignableFrom2);
                        n.e(str2, "jsonArray.opt(i)");
                        A(format, str2, e3, z4);
                        assignableFrom2++;
                    }
                } else {
                    if (!String.class.isAssignableFrom(length) && !Number.class.isAssignableFrom(length)) {
                        if (!Number.class.isAssignableFrom(length)) {
                            if (Boolean.TYPE.isAssignableFrom(length)) {
                                e3.a(string, object2.toString());
                            } else {
                                if (Date.class.isAssignableFrom(length)) {
                                    Objects.requireNonNull(object2, "null cannot be cast to non-null type java.util.Date");
                                    obj12 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
                                    obj10 = obj12.format((Date)object2);
                                    n.e(obj10, "iso8601DateFormat.format(date)");
                                    e3.a(string, obj10);
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }

        private final void B(com.facebook.r r, v v2, int i3, URL uRL4, OutputStream outputStream5, boolean z6) {
            int next;
            Object obj;
            boolean aVar;
            Object obj5;
            Object obj6;
            Object obj7;
            String obj8;
            int obj10;
            p.h hVar = new p.h(outputStream5, v2, z6);
            final String obj9 = "  Attachments:\n";
            next = 1;
            if (i3 == next) {
                obj5 = r.q(0);
                obj7 = new HashMap();
                obj10 = obj5.s().keySet().iterator();
                while (obj10.hasNext()) {
                    next = obj10.next();
                    obj = obj5.s().get((String)next);
                    if (t(obj)) {
                    }
                    n.e(next, "key");
                    aVar = new p.a(obj5, obj);
                    obj7.put(next, aVar);
                }
                if (v2 != null) {
                    v2.b("  Parameters:\n");
                }
                E(obj5.s(), hVar, obj5);
                if (v2 != null) {
                    v2.b(obj9);
                }
                D(obj7, hVar);
                obj5 = obj5.o();
                if (obj5 != null) {
                    obj6 = uRL4.getPath();
                    n.e(obj6, "url.path");
                    z(obj5, obj6, hVar);
                }
            } else {
                obj7 = n(r);
                if (obj7.length() == 0) {
                    obj10 = next;
                }
                if (obj10 != null) {
                } else {
                    hVar.a("batch_app_id", obj7);
                    obj7 = new HashMap();
                    F(hVar, r, obj7);
                    if (v2 != null) {
                        v2.b(obj9);
                    }
                    D(obj7, hVar);
                }
            }
            obj5 = new FacebookException("App ID was not specified at the request or Settings.");
            throw obj5;
        }

        private final void D(Map<String, com.facebook.p.a> map, com.facebook.p.h p$h2) {
            Object next;
            boolean key;
            Object obj;
            Iterator obj4 = map.entrySet().iterator();
            while (obj4.hasNext()) {
                next = obj4.next();
                if (p.t.t((p.a)(Map.Entry)next.getValue().b())) {
                }
                h2.j((String)next.getKey(), (p.a)next.getValue().b(), (p.a)next.getValue().a());
            }
        }

        private final void E(Bundle bundle, com.facebook.p.h p$h2, com.facebook.p p3) {
            Object next;
            Object obj;
            boolean str;
            Iterator iterator = bundle.keySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                obj = bundle.get((String)next);
                if (u(obj)) {
                }
                n.e(next, "key");
                h2.j(next, obj, p3);
            }
        }

        private final void F(com.facebook.p.h p$h, Collection<com.facebook.p> collection2, Map<String, com.facebook.p.a> map3) {
            Object next;
            JSONArray jSONArray = new JSONArray();
            final Iterator iterator = collection2.iterator();
            for (p next : iterator) {
                p.e(next, jSONArray, map3);
            }
            h.l("batch", jSONArray, collection2);
        }

        private final void H(HttpURLConnection httpURLConnection, boolean z2) {
            String str;
            String obj3;
            str = "Content-Type";
            if (z2) {
                httpURLConnection.setRequestProperty(str, "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            } else {
                httpURLConnection.setRequestProperty(str, o());
            }
        }

        public static final boolean a(com.facebook.p.c p$c, Object object2) {
            return c.t(object2);
        }

        public static final boolean b(com.facebook.p.c p$c, Object object2) {
            return c.u(object2);
        }

        public static final String c(com.facebook.p.c p$c, Object object2) {
            return c.y(object2);
        }

        public static final void d(com.facebook.p.c p$c, JSONObject jSONObject2, String string3, com.facebook.p.e p$e4) {
            c.z(jSONObject2, string3, e4);
        }

        private final HttpURLConnection e(URL uRL) {
            Object obj3 = FirebasePerfUrlConnection.instrument(uRL.openConnection());
            Objects.requireNonNull((URLConnection)obj3, "null cannot be cast to non-null type java.net.HttpURLConnection");
            (HttpURLConnection)obj3.setRequestProperty("User-Agent", p());
            obj3.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            obj3.setChunkedStreamingMode(0);
            return obj3;
        }

        private final String n(com.facebook.r r) {
            String str;
            boolean length;
            int i2;
            int i;
            String obj4;
            str = r.s();
            if (str != null && empty ^= i2 != 0) {
                if (empty ^= i2 != 0) {
                    return str;
                }
            }
            obj4 = r.iterator();
            for (p next : obj4) {
                str = next.k();
            }
            obj4 = p.a();
            if (obj4 != null) {
                if (obj4.length() > 0) {
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                } else {
                    obj4 = o.g();
                }
            } else {
            }
            return obj4;
        }

        private final String o() {
            f0 f0Var = f0.a;
            int i = 1;
            Object[] arr = new Object[i];
            arr[0] = p.b();
            String format = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(format, *args)");
            return format;
        }

        private final String p() {
            String format;
            String str;
            boolean rOOT;
            int i;
            int i2;
            Object[] arr;
            String str2;
            f0 f0Var = f0.a;
            format = 2;
            Object[] arr2 = new Object[format];
            i = 0;
            arr2[i] = "FBAndroidSDK";
            i2 = 1;
            arr2[i2] = "12.3.0";
            String format2 = String.format("%s.%s", Arrays.copyOf(arr2, format));
            n.e(format2, "java.lang.String.format(format, *args)");
            p.f(format2);
            str = t.a();
            if (p.c() == null && !b0.W(str)) {
                f0Var = f0.a;
                format = 2;
                arr2 = new Object[format];
                i = 0;
                arr2[i] = "FBAndroidSDK";
                i2 = 1;
                arr2[i2] = "12.3.0";
                format2 = String.format("%s.%s", Arrays.copyOf(arr2, format));
                n.e(format2, "java.lang.String.format(format, *args)");
                p.f(format2);
                str = t.a();
                if (!b0.W(str)) {
                    arr = new Object[format];
                    arr[i] = p.c();
                    arr[i2] = str;
                    format = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(arr, format));
                    n.e(format, "java.lang.String.format(locale, format, *args)");
                    p.f(format);
                }
            }
            return p.c();
        }

        private final boolean q(com.facebook.r r) {
            Iterator iterator;
            boolean z;
            int i;
            iterator = r.u().iterator();
            i = 1;
            for (r.a next4 : iterator) {
                i = 1;
            }
            Iterator obj4 = r.iterator();
            for (p next2 : obj4) {
            }
            return 0;
        }

        private final boolean r(com.facebook.r r) {
            Object next2;
            Iterator iterator;
            boolean next;
            Bundle bundle;
            Iterator obj5 = r.iterator();
            for (p next2 : obj5) {
                iterator = next2.s().keySet().iterator();
                for (String next4 : iterator) {
                }
            }
            return 1;
        }

        private final boolean s(String string) {
            Object matcher;
            boolean str;
            int i;
            Object obj6;
            matcher = p.d().matcher(string);
            if (matcher.matches()) {
                n.e(matcher.group(1), "matcher.group(1)");
            }
            int i2 = 0;
            final int i3 = 2;
            final int i4 = 0;
            if (!l.M(obj6, "me/", i2, i3, i4)) {
                if (l.M(obj6, "/me/", i2, i3, i4)) {
                } else {
                    i = i2;
                }
            }
            return i;
        }

        private final boolean t(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof Bitmap == null && !object instanceof byte[] && !object instanceof Uri && object instanceof ParcelFileDescriptor == null) {
                if (!object instanceof byte[]) {
                    if (!object instanceof Uri) {
                        if (object instanceof ParcelFileDescriptor == null) {
                            if (object instanceof p.g) {
                                obj2 = 1;
                            } else {
                                obj2 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        private final boolean u(Object object) {
            boolean z;
            int obj2;
            if (object instanceof String == null && !object instanceof Boolean && !object instanceof Number) {
                if (!object instanceof Boolean) {
                    if (!object instanceof Number) {
                        if (object instanceof Date) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        private final String y(Object object) {
            boolean z;
            if (object instanceof String != null) {
                return (String)object;
            }
            if (!object instanceof Boolean) {
                if (object instanceof Number) {
                } else {
                    if (!object instanceof Date) {
                    } else {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
                        String obj4 = simpleDateFormat.format((Date)object);
                        n.e(obj4, "iso8601DateFormat.format(value)");
                        return obj4;
                    }
                }
                obj4 = new IllegalArgumentException("Unsupported parameter type.");
                throw obj4;
            }
            return object.toString();
        }

        private final void z(JSONObject jSONObject, String string2, com.facebook.p.e p$e3) {
            boolean z;
            int next;
            String str;
            int i;
            int str2;
            int i2;
            int i3;
            int obj11;
            final int i4 = 1;
            final int i5 = 0;
            i = 0;
            str2 = 0;
            i2 = 6;
            i3 = 0;
            String str3 = string2;
            z = l.e0(str3, ":", i, str2, i2, i3);
            obj11 = l.e0(str3, "?", i, str2, i2, i3);
            if (s(string2) && z > 3) {
                i = 0;
                str2 = 0;
                i2 = 6;
                i3 = 0;
                str3 = string2;
                z = l.e0(str3, ":", i, str2, i2, i3);
                obj11 = l.e0(str3, "?", i, str2, i2, i3);
                if (z > 3) {
                    if (obj11 != -1) {
                        obj11 = z < obj11 ? i4 : i5;
                    } else {
                    }
                } else {
                }
            } else {
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                next = keys.next();
                str = jSONObject.opt((String)next);
                if (obj11 != null && l.x(next, "image", i4)) {
                } else {
                }
                i = i5;
                n.e(next, "key");
                n.e(str, "value");
                A(next, str, e3, i);
                if (l.x(next, "image", i4)) {
                } else {
                }
                i = i4;
            }
        }

        public final void C(com.facebook.r r, List<com.facebook.s> list2) {
            int i;
            com.facebook.p pVar;
            com.facebook.p.b pair;
            Object obj;
            Object obj7;
            int obj8;
            n.f(r, "requests");
            n.f(list2, "responses");
            ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < r.size()) {
                pVar = r.q(i);
                if (pVar.m() != null) {
                }
                i++;
                pair = new Pair(pVar.m(), list2.get(i));
                arrayList.add(pair);
            }
            if (arrayList.size() > 0) {
                obj8 = new p.c.b(arrayList, r);
                obj7 = r.t();
                if (obj7 != null) {
                    obj7.post(obj8);
                } else {
                    obj8.run();
                }
            }
        }

        public final void G(com.facebook.r r, HttpURLConnection httpURLConnection2) {
            int i;
            boolean a0Var;
            Object obj;
            int i3;
            int i2;
            com.facebook.t pOST2;
            Object pOST;
            String requestProperty;
            Object str;
            com.facebook.z zVar;
            boolean z;
            Object obj15;
            n.f(r, "requests");
            n.f(httpURLConnection2, "connection");
            v vVar = new v(v.REQUESTS, "Request");
            final int size = r.size();
            final boolean z3 = r(r);
            i2 = 1;
            if (size == i2) {
                pOST2 = r.q(0).r();
            } else {
                pOST2 = i3;
            }
            if (pOST2 != null) {
            } else {
                pOST2 = t.POST;
            }
            httpURLConnection2.setRequestMethod(pOST2.name());
            H(httpURLConnection2, z3);
            final URL uRL = httpURLConnection2.getURL();
            vVar.b("Request:\n");
            vVar.d("Id", r.v());
            n.e(uRL, "url");
            vVar.d("URL", uRL);
            String requestMethod = httpURLConnection2.getRequestMethod();
            n.e(requestMethod, "connection.requestMethod");
            vVar.d("Method", requestMethod);
            String str9 = "User-Agent";
            String requestProperty2 = httpURLConnection2.getRequestProperty(str9);
            n.e(requestProperty2, "connection.getRequestProperty(\"User-Agent\")");
            vVar.d(str9, requestProperty2);
            String str10 = "Content-Type";
            requestProperty = httpURLConnection2.getRequestProperty(str10);
            n.e(requestProperty, "connection.getRequestProperty(\"Content-Type\")");
            vVar.d(str10, requestProperty);
            httpURLConnection2.setConnectTimeout(r.z());
            httpURLConnection2.setReadTimeout(r.z());
            if (pOST2 == t.POST) {
                i = i2;
            }
            if (i == 0) {
                vVar.e();
            }
            httpURLConnection2.setDoOutput(i2);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection2.getOutputStream());
            if (z3) {
                obj15 = new GZIPOutputStream(bufferedOutputStream);
            } else {
                obj15 = bufferedOutputStream;
            }
            if (q(r)) {
                z zVar2 = new z(r.t());
                str = uRL;
                this.B(r, 0, size, str, zVar2, z3);
                super(obj15, r, zVar2.f(), (long)i4, str);
                obj15 = a0Var;
            }
            this.B(r, vVar, size, uRL, obj15, z3);
            obj15.close();
            vVar.e();
        }

        public final HttpURLConnection I(com.facebook.r r) {
            String str;
            URL url;
            final String str2 = "could not construct request body";
            n.f(r, "requests");
            J(r);
            if (r.size() == 1) {
                url = new URL(r.q(0).v());
            } else {
                url = new URL(z.g());
            }
            int i = 0;
            HttpURLConnection connection = e(url);
            G(r, connection);
            return connection;
        }

        public final void J(com.facebook.r r) {
            String string;
            String str;
            com.facebook.t gET;
            Object dEVELOPER_ERRORS;
            int i;
            String str2;
            String str3;
            n.f(r, "requests");
            final Iterator obj7 = r.iterator();
            while (obj7.hasNext()) {
                string = obj7.next();
                if (t.GET == (p)string.r() && b0.W(string.s().getString("fields"))) {
                }
                if (b0.W(string.s().getString("fields"))) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("GET requests for /");
                if (string.p() != null) {
                } else {
                }
                str = "";
                stringBuilder.append(str);
                stringBuilder.append(" should contain an explicit \"fields\" parameter.");
                v.f.a(v.DEVELOPER_ERRORS, 5, "Request", stringBuilder.toString());
            }
        }

        public final com.facebook.s f(com.facebook.p p) {
            n.f(p, "request");
            int i = 1;
            com.facebook.p[] arr = new p[i];
            final int i2 = 0;
            arr[i2] = p;
            List obj4 = i(arr);
            if (obj4.size() != i) {
            } else {
                return (s)obj4.get(i2);
            }
            obj4 = new FacebookException("invalid state: expected a single response");
            throw obj4;
        }

        public final List<com.facebook.s> g(com.facebook.r r) {
            List i;
            HttpURLConnection connection;
            int i2;
            com.facebook.s.a aVar;
            List list;
            com.facebook.FacebookException facebookException;
            List obj7;
            String str = "requests";
            n.f(r, str);
            c0.i(r, str);
            i = 0;
            connection = I(r);
            i2 = i;
            if (connection != null) {
                obj7 = m(connection, r);
            } else {
                facebookException = new FacebookException(i2);
                i = s.g.a(r.w(), i, facebookException);
                C(r, i);
                obj7 = i;
            }
            b0.p(connection);
            return obj7;
        }

        public final List<com.facebook.s> h(Collection<com.facebook.p> collection) {
            n.f(collection, "requests");
            r rVar = new r(collection);
            return g(rVar);
        }

        public final List<com.facebook.s> i(com.facebook.p... pArr) {
            n.f(pArr, "requests");
            return h(i.a0(pArr));
        }

        public final com.facebook.q j(com.facebook.r r) {
            String str = "requests";
            n.f(r, str);
            c0.i(r, str);
            q qVar = new q(r);
            qVar.executeOnExecutor(o.n(), new Void[0]);
            return qVar;
        }

        public final com.facebook.q k(Collection<com.facebook.p> collection) {
            n.f(collection, "requests");
            r rVar = new r(collection);
            return j(rVar);
        }

        public final com.facebook.q l(com.facebook.p... pArr) {
            n.f(pArr, "requests");
            return k(i.a0(pArr));
        }

        public final List<com.facebook.s> m(HttpURLConnection httpURLConnection, com.facebook.r r2) {
            n.f(httpURLConnection, "connection");
            n.f(r2, "requests");
            List list = s.g.f(httpURLConnection, r2);
            b0.p(httpURLConnection);
            int obj6 = r2.size();
            if (obj6 != list.size()) {
            } else {
                C(r2, list);
                d.g.e().f();
                return list;
            }
            f0 f0Var = f0.a;
            final int i2 = 2;
            final Object[] arr = new Object[i2];
            arr[0] = Integer.valueOf(list.size());
            arr[1] = Integer.valueOf(obj6);
            obj6 = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(arr, i2));
            n.e(obj6, "java.lang.String.format(locale, format, *args)");
            FacebookException obj7 = new FacebookException(obj6);
            throw obj7;
        }

        public final com.facebook.p v(com.facebook.a a, String string2, com.facebook.p.b p$b3) {
            super(a, string2, 0, 0, b3, 0, 32, 0);
            return pVar2;
        }

        public final com.facebook.p w(com.facebook.a a, com.facebook.p.d p$d2) {
            p.c.a aVar2 = new p.c.a(d2);
            super(a, "me", 0, 0, aVar2, 0, 32, 0);
            return obj11;
        }

        public final com.facebook.p x(com.facebook.a a, String string2, JSONObject jSONObject3, com.facebook.p.b p$b4) {
            super(a, string2, 0, t.POST, b4, 0, 32, 0);
            pVar2.D(jSONObject3);
            return pVar2;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0008", d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "", "onCompleted", "", "obj", "Lorg/json/JSONObject;", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface d {
        public abstract void a(JSONObject jSONObject, com.facebook.s s2);
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008â\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "writeString", "", "key", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private interface e {
        public abstract void a(String string, String string2);
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 \u0015*\n\u0008\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001\u0015B\u0019\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\u0008\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0016", d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "RESOURCE", "Landroid/os/Parcelable;", "resource", "mimeType", "", "(Landroid/os/Parcelable;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMimeType", "()Ljava/lang/String;", "getResource", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "out", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class g implements Parcelable {

        public static final Parcelable.Creator<com.facebook.p.g<?>> CREATOR;
        private final String a;
        private final RESOURCE b;
        static {
            p.g.a aVar = new p.g.a();
            p.g.CREATOR = aVar;
        }

        private g(Parcel parcel) {
            super();
            this.a = parcel.readString();
            this.b = parcel.readParcelable(o.f().getClassLoader());
        }

        public g(Parcel parcel, g g2) {
            super(parcel);
        }

        public g(RESOURCE resource, String string2) {
            super();
            this.a = string2;
            this.b = resource;
        }

        @Override // android.os.Parcelable
        public final String a() {
            return this.a;
        }

        public final RESOURCE b() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i2);
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lcom/facebook/GraphRequest$OnProgressCallback;", "Lcom/facebook/GraphRequest$Callback;", "onProgress", "", "current", "", "max", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface f extends com.facebook.p.b {
        @Override // com.facebook.p$b
        public abstract void a(long l, long l2);
    }

    @Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00102\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0008\u0010 \u001a\u0004\u0018\u00010\u00122\u0008\u0010!\u001a\u0004\u0018\u00010\u0012J \u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u0012J \u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0008\u0010%\u001a\u0004\u0018\u00010\u0012J+\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\"\u0010*\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0008\u0010+\u001a\u0004\u0018\u00010\u00152\u0008\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0010J$\u0010/\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u00020-03J\u0018\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u00060\u000bj\u0002`\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065", d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "outputStream", "Ljava/io/OutputStream;", "logger", "Lcom/facebook/internal/Logger;", "useUrlEncode", "", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "firstWrite", "invalidTypeError", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "write", "", "format", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeBitmap", "key", "bitmap", "Landroid/graphics/Bitmap;", "writeBytes", "bytes", "", "writeContentDisposition", "name", "filename", "contentType", "writeContentUri", "contentUri", "Landroid/net/Uri;", "mimeType", "writeFile", "descriptor", "Landroid/os/ParcelFileDescriptor;", "writeLine", "writeObject", "value", "request", "Lcom/facebook/GraphRequest;", "writeRecordBoundary", "writeRequestsAsJson", "requestJsonArray", "Lorg/json/JSONArray;", "requests", "", "writeString", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class h implements com.facebook.p.e {

        private boolean a = true;
        private final boolean b;
        private final OutputStream c;
        private final v d;
        public h(OutputStream outputStream, v v2, boolean z3) {
            n.f(outputStream, "outputStream");
            super();
            this.c = outputStream;
            this.d = v2;
            final int obj2 = 1;
            this.b = z3;
        }

        private final RuntimeException b() {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("value is not a supported type.");
            return illegalArgumentException;
        }

        @Override // com.facebook.p$e
        public void a(String string, String string2) {
            Object stringBuilder;
            String str;
            Object obj4;
            n.f(string, "key");
            n.f(string2, "value");
            int i = 0;
            f(string, i, i);
            Object[] arr = new Object[1];
            i("%s", string2);
            k();
            v vVar = this.d;
            if (vVar != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(string);
                vVar.d(stringBuilder.toString(), string2);
            }
        }

        @Override // com.facebook.p$e
        public final void c(String string, Object... object2Arr2) {
            boolean z;
            OutputStream outputStream;
            byte[] bytes;
            int length2;
            String length;
            byte[] obj6;
            java.nio.charset.Charset obj7;
            n.f(string, "format");
            n.f(object2Arr2, "args");
            final String str3 = "null cannot be cast to non-null type java.lang.String";
            final String str4 = "(this as java.lang.String).getBytes(charset)";
            if (!this.b) {
                if (this.a) {
                    java.nio.charset.Charset charset = d.a;
                    byte[] bytes2 = "--".getBytes(charset);
                    n.e(bytes2, str4);
                    this.c.write(bytes2);
                    String str6 = p.b();
                    Objects.requireNonNull(str6, str3);
                    byte[] bytes3 = str6.getBytes(charset);
                    n.e(bytes3, str4);
                    this.c.write(bytes3);
                    bytes = "\r\n".getBytes(charset);
                    n.e(bytes, str4);
                    this.c.write(bytes);
                    this.a = false;
                }
                f0 f0Var = f0.a;
                obj7 = Arrays.copyOf(object2Arr2, object2Arr2.length);
                obj6 = String.format(string, Arrays.copyOf(obj7, obj7.length));
                n.e(obj6, "java.lang.String.format(format, *args)");
                Objects.requireNonNull(obj6, str3);
                obj6 = obj6.getBytes(d.a);
                n.e(obj6, str4);
                this.c.write(obj6);
            } else {
                f0 f0Var2 = f0.a;
                obj7 = Arrays.copyOf(object2Arr2, object2Arr2.length);
                obj6 = String.format(Locale.US, string, Arrays.copyOf(obj7, obj7.length));
                n.e(obj6, "java.lang.String.format(locale, format, *args)");
                obj6 = URLEncoder.encode(obj6, "UTF-8");
                n.e(obj6, "URLEncoder.encode(String… format, *args), \"UTF-8\")");
                Objects.requireNonNull(obj6, str3);
                obj6 = obj6.getBytes(d.a);
                n.e(obj6, str4);
                this.c.write(obj6);
            }
        }

        @Override // com.facebook.p$e
        public final void d(String string, Bitmap bitmap2) {
            String str;
            Object str2;
            Object obj4;
            n.f(string, "key");
            n.f(bitmap2, "bitmap");
            f(string, string, "image/png");
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, this.c);
            i("", new Object[0]);
            k();
            v obj5 = this.d;
            if (obj5 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(string);
                obj5.d(stringBuilder.toString(), "<Image>");
            }
        }

        @Override // com.facebook.p$e
        public final void e(String string, byte[] b2Arr2) {
            int str;
            Object rOOT;
            int i;
            Object[] arr;
            Object obj6;
            Object obj7;
            n.f(string, "key");
            n.f(b2Arr2, "bytes");
            f(string, string, "content/unknown");
            this.c.write(b2Arr2);
            str = 0;
            i("", new Object[str]);
            k();
            v vVar = this.d;
            if (vVar != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(string);
                f0 f0Var = f0.a;
                i = 1;
                arr = new Object[i];
                arr[str] = Integer.valueOf(b2Arr2.length);
                obj7 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(arr, i));
                n.e(obj7, "java.lang.String.format(locale, format, *args)");
                vVar.d(stringBuilder.toString(), obj7);
            }
        }

        @Override // com.facebook.p$e
        public final void f(String string, String string2, String string3) {
            String str;
            byte[] obj4;
            Object obj5;
            Object obj6;
            final int i = 1;
            final int i2 = 0;
            if (!this.b) {
                str = new Object[i];
                str[i2] = string;
                c("Content-Disposition: form-data; name=\"%s\"", str);
                if (string2 != null) {
                    obj4 = new Object[i];
                    obj4[i2] = string2;
                    c("; filename=\"%s\"", obj4);
                }
                obj5 = "";
                i(obj5, new Object[i2]);
                if (string3 != null) {
                    obj4 = new Object[2];
                    obj4[i2] = "Content-Type";
                    obj4[i] = string3;
                    i("%s: %s", obj4);
                }
                i(obj5, new Object[i2]);
            } else {
                obj6 = f0.a;
                obj6 = new Object[i];
                obj6[i2] = string;
                obj4 = String.format("%s=", Arrays.copyOf(obj6, i));
                n.e(obj4, "java.lang.String.format(format, *args)");
                Objects.requireNonNull(obj4, "null cannot be cast to non-null type java.lang.String");
                obj4 = obj4.getBytes(d.a);
                n.e(obj4, "(this as java.lang.String).getBytes(charset)");
                this.c.write(obj4);
            }
        }

        @Override // com.facebook.p$e
        public final void g(String string, Uri uri2, String string3) {
            int str;
            OutputStream outputStream;
            Object rOOT;
            int i;
            Object[] arr;
            Object obj5;
            int obj6;
            String obj7;
            n.f(string, "key");
            n.f(uri2, "contentUri");
            if (string3 == null) {
                obj7 = "content/unknown";
            }
            f(string, string, obj7);
            obj7 = obj7 instanceof z;
            str = 0;
            if (obj7 != null) {
                (z)this.c.c(b0.w(uri2));
                obj6 = str;
            } else {
                obj6 += str;
            }
            i("", new Object[str]);
            k();
            obj7 = this.d;
            if (obj7 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(string);
                f0 f0Var = f0.a;
                i = 1;
                arr = new Object[i];
                arr[str] = Integer.valueOf(obj6);
                obj6 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(arr, i));
                n.e(obj6, "java.lang.String.format(locale, format, *args)");
                obj7.d(stringBuilder.toString(), obj6);
            }
        }

        @Override // com.facebook.p$e
        public final void h(String string, ParcelFileDescriptor parcelFileDescriptor2, String string3) {
            String str2;
            int str;
            long statSize;
            Object[] arr;
            Object obj5;
            int obj6;
            String obj7;
            n.f(string, "key");
            n.f(parcelFileDescriptor2, "descriptor");
            if (string3 == null) {
                obj7 = "content/unknown";
            }
            f(string, string, obj7);
            obj7 = this.c;
            str = 0;
            if (obj7 instanceof z) {
                (z)obj7.c(parcelFileDescriptor2.getStatSize());
                obj6 = str;
            } else {
                obj7 = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor2);
                obj6 += str;
            }
            i("", new Object[str]);
            k();
            obj7 = this.d;
            if (obj7 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(string);
                f0 f0Var = f0.a;
                statSize = 1;
                arr = new Object[statSize];
                arr[str] = Integer.valueOf(obj6);
                obj6 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(arr, statSize));
                n.e(obj6, "java.lang.String.format(locale, format, *args)");
                obj7.d(stringBuilder.toString(), obj6);
            }
        }

        @Override // com.facebook.p$e
        public final void i(String string, Object... object2Arr2) {
            boolean obj2;
            Object[] obj3;
            n.f(string, "format");
            n.f(object2Arr2, "args");
            c(string, Arrays.copyOf(object2Arr2, object2Arr2.length));
            if (!this.b) {
                c("\r\n", new Object[0]);
            }
        }

        @Override // com.facebook.p$e
        public final void j(String string, Object object2, com.facebook.p p3) {
            boolean z;
            boolean str;
            Object obj4;
            com.facebook.p.c obj5;
            n.f(string, "key");
            OutputStream outputStream = this.c;
            if (outputStream instanceof b0) {
                Objects.requireNonNull(outputStream, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
                (b0)outputStream.a(p3);
            }
            obj5 = p.t;
            if (p.c.b(obj5, object2)) {
                a(string, p.c.c(obj5, object2));
            } else {
                if (object2 instanceof Bitmap != null) {
                    d(string, (Bitmap)object2);
                } else {
                    if (object2 instanceof byte[]) {
                        e(string, (byte[])object2);
                    } else {
                        z = 0;
                        if (object2 instanceof Uri) {
                            g(string, (Uri)object2, z);
                        } else {
                            if (object2 instanceof ParcelFileDescriptor != null) {
                                h(string, (ParcelFileDescriptor)object2, z);
                            } else {
                                if (!object2 instanceof p.g) {
                                } else {
                                    obj5 = (p.g)object2.b();
                                    obj4 = object2.a();
                                    if (obj5 instanceof ParcelFileDescriptor != null) {
                                        h(string, (ParcelFileDescriptor)obj5, obj4);
                                    } else {
                                        if (!obj5 instanceof Uri) {
                                        } else {
                                            g(string, (Uri)obj5, obj4);
                                        }
                                    }
                                    throw b();
                                }
                            }
                        }
                    }
                }
            }
            throw b();
        }

        @Override // com.facebook.p$e
        public final void k() {
            Object[] arr;
            String bytes;
            String str;
            if (!this.b) {
                arr = new Object[1];
                i("--%s", p.b());
            } else {
                bytes = "&".getBytes(d.a);
                n.e(bytes, "(this as java.lang.String).getBytes(charset)");
                this.c.write(bytes);
            }
        }

        public final void l(String string, JSONArray jSONArray2, Collection<com.facebook.p> collection3) {
            Object stringBuilder;
            int str;
            int i;
            String str2;
            String str3;
            Object obj7;
            Object obj8;
            n.f(string, "key");
            n.f(jSONArray2, "requestJsonArray");
            n.f(collection3, "requests");
            OutputStream outputStream = this.c;
            final String str8 = "requestJsonArray.toString()";
            if (!outputStream instanceof b0) {
                obj8 = jSONArray2.toString();
                n.e(obj8, str8);
                a(string, obj8);
            }
            Objects.requireNonNull(outputStream, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
            int i2 = 0;
            f(string, i2, i2);
            str = 0;
            c("[", new Object[str]);
            Iterator obj9 = collection3.iterator();
            i = str;
            while (obj9.hasNext()) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                (b0)outputStream.a((p)obj9.next());
                int i3 = 1;
                if (i > 0) {
                } else {
                }
                str2 = new Object[i3];
                str2[str] = jSONObject.toString();
                c("%s", str2);
                i++;
                str2 = new Object[i3];
                str2[str] = jSONObject.toString();
                c(",%s", str2);
            }
            c("]", new Object[str]);
            obj9 = this.d;
            if (obj9 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(string);
                obj8 = jSONArray2.toString();
                n.e(obj8, str8);
                obj9.d(stringBuilder.toString(), obj8);
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class i implements com.facebook.p.b {

        final com.facebook.p.b a;
        i(com.facebook.p.b p$b) {
            this.a = b;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(com.facebook.s s) {
            int optJSONObject;
            int optJSONArray;
            String str;
            int length;
            int optString2;
            int optString3;
            int optString;
            boolean stringBuilder;
            String gRAPH_API_DEBUG_INFO;
            String str2;
            n.f(s, "response");
            JSONObject jSONObject = s.c();
            final int i = 0;
            if (jSONObject != null) {
                optJSONObject = jSONObject.optJSONObject("__debug__");
            } else {
                optJSONObject = i;
            }
            if (optJSONObject != null) {
                optJSONArray = optJSONObject.optJSONArray("messages");
            } else {
                optJSONArray = i;
            }
            if (optJSONArray != null) {
                str = 0;
                while (str < optJSONArray.length()) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(str);
                    if (optJSONObject2 != null) {
                    } else {
                    }
                    optString3 = i;
                    if (optJSONObject2 != null) {
                    } else {
                    }
                    optString = i;
                    if (optJSONObject2 != null) {
                    } else {
                    }
                    optString2 = i;
                    gRAPH_API_DEBUG_INFO = v.GRAPH_API_DEBUG_INFO;
                    if (optString3 != 0 && optString != null && n.b(optString, "warning")) {
                    }
                    str++;
                    if (optString != null) {
                    }
                    gRAPH_API_DEBUG_INFO = v.GRAPH_API_DEBUG_INFO;
                    if (n.b(optString, "warning")) {
                    }
                    if (!b0.W(optString2)) {
                    }
                    v.f.b(gRAPH_API_DEBUG_INFO, p.o, optString3);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(optString3);
                    stringBuilder.append(" Link: ");
                    stringBuilder.append(optString2);
                    optString3 = stringBuilder.toString();
                    gRAPH_API_DEBUG_INFO = v.GRAPH_API_DEBUG_WARNING;
                    optString2 = optJSONObject2.optString("link");
                    optString = optJSONObject2.optString("type");
                    optString3 = optJSONObject2.optString("message");
                }
            }
            com.facebook.p.b bVar = this.a;
            if (bVar != null) {
                bVar.b(s);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"com/facebook/GraphRequest$serializeToBatch$1", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "writeString", "", "key", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class j implements com.facebook.p.e {

        final ArrayList a;
        j(ArrayList arrayList) {
            this.a = arrayList;
            super();
        }

        @Override // com.facebook.p$e
        public void a(String string, String string2) {
            n.f(string, "key");
            n.f(string2, "value");
            f0 f0Var = f0.a;
            final int i = 2;
            final Object[] arr = new Object[i];
            arr[0] = string;
            arr[1] = URLEncoder.encode(string2, "UTF-8");
            String obj6 = String.format(Locale.US, "%s=%s", Arrays.copyOf(arr, i));
            n.e(obj6, "java.lang.String.format(locale, format, *args)");
            this.a.add(obj6);
        }
    }
    static {
        int i;
        char c;
        p.c cVar = new p.c(0);
        p.t = cVar;
        String simpleName = p.class.getSimpleName();
        n.e(simpleName, "GraphRequest::class.java.simpleName");
        p.o = simpleName;
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        n.e(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        i = 0;
        while (i < nextInt += 30) {
            stringBuilder.append(charArray[secureRandom.nextInt(charArray.length)]);
            i++;
        }
        String string = stringBuilder.toString();
        n.e(string, "buffer.toString()");
        p.p = string;
        p.r = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    public p() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public p(com.facebook.a a, String string2, Bundle bundle3, com.facebook.t t4, com.facebook.p.b p$b5) {
        super(a, string2, bundle3, t4, b5, 0, 32, 0);
    }

    public p(com.facebook.a a, String string2, Bundle bundle3, com.facebook.t t4, com.facebook.p.b p$b5, String string6) {
        Bundle obj2;
        super();
        this.f = true;
        this.a = a;
        this.b = string2;
        this.i = string6;
        B(b5);
        E(t4);
        if (bundle3 != null) {
            obj2 = new Bundle(bundle3);
            this.g = obj2;
        } else {
            obj2 = new Bundle();
            this.g = obj2;
        }
        if (this.i == null) {
            this.i = o.p();
        }
    }

    public p(com.facebook.a a, String string2, Bundle bundle3, com.facebook.t t4, com.facebook.p.b p$b5, String string6, int i7, g g8) {
        int i2;
        int i4;
        int i;
        int i3;
        int obj12;
        int obj13;
        final int i5 = 0;
        obj13 = i7 & 1 != 0 ? i5 : a;
        i2 = i7 & 2 != 0 ? i5 : string2;
        i4 = i7 & 4 != 0 ? i5 : bundle3;
        i = i7 & 8 != 0 ? i5 : t4;
        i3 = i7 & 16 != 0 ? i5 : b5;
        obj12 = i7 & 32 != 0 ? i5 : string6;
        super(obj13, i2, i4, i, i3, obj12);
    }

    private final void A(JSONArray jSONArray, Map<String, com.facebook.p.a> map2) {
        String str3;
        String str;
        String str5;
        Object aVar;
        Object arrayList;
        Object str2;
        Object iterator;
        Object obj;
        boolean jVar;
        boolean format;
        com.facebook.p.a aVar2;
        String str4;
        int i;
        Integer valueOf;
        boolean obj12;
        JSONObject jSONObject = new JSONObject();
        str3 = this.d;
        if (str3 != null) {
            jSONObject.put("name", str3);
            jSONObject.put("omit_response_on_success", this.f);
        }
        String str6 = this.e;
        if (str6 != null) {
            jSONObject.put("depends_on", str6);
        }
        str = t();
        jSONObject.put("relative_url", str);
        jSONObject.put("method", this.k);
        aVar = this.a;
        if (aVar != null) {
            v.f.d(aVar.m());
        }
        arrayList = new ArrayList();
        iterator = this.g.keySet().iterator();
        while (iterator.hasNext()) {
            obj = this.g.get((String)iterator.next());
            if (p.c.a(p.t, obj)) {
            }
            f0 f0Var = f0.a;
            int i2 = 2;
            Object[] arr = new Object[i2];
            arr[0] = "file";
            arr[1] = Integer.valueOf(map2.size());
            format = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(arr, i2));
            n.e(format, "java.lang.String.format(locale, format, *args)");
            arrayList.add(format);
            aVar2 = new p.a(this, obj);
            map2.put(format, aVar2);
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        obj12 = this.c;
        if (obj12 != null) {
            arrayList = new ArrayList();
            jVar = new p.j(arrayList);
            p.c.d(p.t, obj12, str, jVar);
            jSONObject.put("body", TextUtils.join("&", arrayList));
        }
        jSONArray.put(jSONObject);
    }

    private final boolean I() {
        String str;
        int i;
        boolean z;
        String str2;
        str = l();
        final int i2 = 0;
        final int i3 = 2;
        final int i4 = 0;
        if (str != null) {
            z = l.R(str, "|", i4, i3, i2);
        } else {
            z = i4;
        }
        final int i5 = 1;
        if (str != null && l.M(str, "IG", i4, i3, i2) && !z) {
            if (l.M(str, "IG", i4, i3, i2)) {
                i = !z ? i5 : i4;
            } else {
            }
        } else {
        }
        if (i != 0 && x()) {
            if (x()) {
                return i5;
            }
        }
        if (!y() && !z) {
            if (!z) {
                return i5;
            }
        }
        return i4;
    }

    public static final String a() {
        return p.q;
    }

    public static final String b() {
        return p.p;
    }

    public static final String c() {
        return p.s;
    }

    public static final Pattern d() {
        return p.r;
    }

    public static final void e(com.facebook.p p, JSONArray jSONArray2, Map map3) {
        p.A(jSONArray2, map3);
    }

    public static final void f(String string) {
        p.s = string;
    }

    private final void g() {
        boolean z;
        String str3;
        boolean key;
        boolean str;
        String str2;
        final Bundle bundle = this.g;
        str2 = "access_token";
        if (!this.l && I()) {
            if (I()) {
                bundle.putString(str2, n());
            } else {
                str3 = l();
                if (str3 != null) {
                    bundle.putString(str2, str3);
                }
            }
        } else {
        }
        if (!bundle.containsKey(str2) && b0.W(o.l())) {
            if (b0.W(o.l())) {
                Log.w(p.o, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString("sdk", "android");
        bundle.putString("format", "json");
        String str9 = "debug";
        if (o.A(v.GRAPH_API_DEBUG_INFO)) {
            bundle.putString(str9, "info");
        } else {
            if (o.A(v.GRAPH_API_DEBUG_WARNING)) {
                bundle.putString(str9, "warning");
            }
        }
    }

    private final String h(String string, boolean z2) {
        com.facebook.t pOST;
        Object string2;
        Object gET;
        boolean z;
        com.facebook.t obj6;
        if (z2 == null && this.k == t.POST) {
            if (this.k == t.POST) {
                return string;
            }
        }
        Uri.Builder obj5 = Uri.parse(string).buildUpon();
        obj6 = this.g.keySet().iterator();
        while (obj6.hasNext()) {
            pOST = obj6.next();
            if (this.g.get((String)pOST) == null) {
            }
            gET = p.t;
            obj5.appendQueryParameter(pOST, p.c.c(gET, string2).toString());
            string2 = "";
        }
        obj5 = obj5.toString();
        n.e(obj5, "uriBuilder.toString()");
        return obj5;
    }

    private final String l() {
        boolean key;
        boolean key2;
        key = this.a;
        String str3 = "access_token";
        if (key != null) {
            if (!this.g.containsKey(str3)) {
                String str2 = key.m();
                v.f.d(str2);
                return str2;
            }
        } else {
            if (!this.l && !this.g.containsKey(str3)) {
                if (!this.g.containsKey(str3)) {
                    return n();
                }
            }
        }
        return this.g.getString(str3);
    }

    private final String n() {
        int string;
        String str;
        boolean stringBuilder;
        String str2;
        String str3 = o.g();
        str = o.l();
        if (!b0.W(str3) && !b0.W(str)) {
            if (!b0.W(str)) {
                stringBuilder = new StringBuilder();
                str2 = "Required value was null.";
                if (str3 == null) {
                } else {
                    stringBuilder.append(str3);
                    stringBuilder.append("|");
                    if (str == null) {
                    } else {
                        stringBuilder.append(str);
                        string = stringBuilder.toString();
                        return string;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException(str2.toString());
                    throw illegalStateException;
                }
                IllegalStateException illegalStateException2 = new IllegalStateException(str2.toString());
                throw illegalStateException2;
            }
        }
        b0.d0(p.o, "Warning: Request without access token missing application ID or client token.");
        string = 0;
    }

    private final String q() {
        String format;
        String str2;
        int i;
        String str;
        if (p.r.matcher(this.b).matches()) {
            format = this.b;
        } else {
            f0 f0Var = f0.a;
            int i2 = 2;
            Object[] arr = new Object[i2];
            arr[0] = this.i;
            arr[1] = this.b;
            n.e(String.format("%s/%s", Arrays.copyOf(arr, i2)), "java.lang.String.format(format, *args)");
        }
        return format;
    }

    private final String w(String string) {
        String obj4;
        if (!y()) {
            obj4 = z.f();
        }
        f0 f0Var = f0.a;
        int i = 2;
        final Object[] arr = new Object[i];
        arr[0] = obj4;
        arr[1] = q();
        obj4 = String.format("%s/%s", Arrays.copyOf(arr, i));
        n.e(obj4, "java.lang.String.format(format, *args)");
        return obj4;
    }

    private final boolean x() {
        String matches;
        int i;
        boolean str;
        if (this.b == null) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^/?");
        stringBuilder.append(o.g());
        stringBuilder.append("/?.*");
        if (!this.m && !Pattern.matches(stringBuilder.toString(), this.b)) {
            if (!Pattern.matches(matches, this.b)) {
                if (Pattern.matches("^/?app/?.*", this.b)) {
                    i = 1;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean y() {
        int i3 = 1;
        if (z ^= i3 != 0) {
            return i3;
        }
        return z2 ^= i3;
    }

    public static final com.facebook.p z(com.facebook.a a, String string2, JSONObject jSONObject3, com.facebook.p.b p$b4) {
        return p.t.x(a, string2, jSONObject3, b4);
    }

    public final void B(com.facebook.p.b p$b) {
        boolean iVar;
        if (!o.A(v.GRAPH_API_DEBUG_INFO)) {
            if (o.A(v.GRAPH_API_DEBUG_WARNING)) {
                iVar = new p.i(b);
                this.j = iVar;
            } else {
                this.j = b;
            }
        } else {
        }
    }

    public final void C(boolean z) {
        this.m = z;
    }

    public final void D(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public final void E(com.facebook.t t) {
        Object gET;
        com.facebook.t obj2;
        if (this.n != null) {
            if (t != t.GET) {
            } else {
            }
            obj2 = new FacebookException("Can't change HTTP method on request with overridden URL.");
            throw obj2;
        }
        if (t != null) {
        } else {
            obj2 = t.GET;
        }
        this.k = obj2;
    }

    public final void F(Bundle bundle) {
        n.f(bundle, "<set-?>");
        this.g = bundle;
    }

    public final void G(boolean z) {
        this.l = z;
    }

    public final void H(Object object) {
        this.h = object;
    }

    public final com.facebook.s i() {
        return p.t.f(this);
    }

    public final com.facebook.q j() {
        com.facebook.p[] arr = new p[1];
        return p.t.l(this);
    }

    public final com.facebook.a k() {
        return this.a;
    }

    public final com.facebook.p.b m() {
        return this.j;
    }

    public final JSONObject o() {
        return this.c;
    }

    public final String p() {
        return this.b;
    }

    public final com.facebook.t r() {
        return this.k;
    }

    public final Bundle s() {
        return this.g;
    }

    public final String t() {
        if (this.n != null) {
        } else {
            g();
            int i = 1;
            Uri parse = Uri.parse(h(w(z.g()), i));
            f0 f0Var = f0.a;
            int i2 = 2;
            final Object[] arr = new Object[i2];
            n.e(parse, "uri");
            arr[0] = parse.getPath();
            arr[i] = parse.getQuery();
            String format = String.format("%s?%s", Arrays.copyOf(arr, i2));
            n.e(format, "java.lang.String.format(format, *args)");
            return format;
        }
        FacebookException facebookException = new FacebookException("Can't override URL for a batch request");
        throw facebookException;
    }

    public String toString() {
        Object str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Request: ");
        stringBuilder.append(" accessToken: ");
        if (this.a == null) {
            str = "null";
        }
        stringBuilder.append(str);
        stringBuilder.append(", graphPath: ");
        stringBuilder.append(this.b);
        stringBuilder.append(", graphObject: ");
        stringBuilder.append(this.c);
        stringBuilder.append(", httpMethod: ");
        stringBuilder.append(this.k);
        stringBuilder.append(", parameters: ");
        stringBuilder.append(this.g);
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return string;
    }

    public final Object u() {
        return this.h;
    }

    public final String v() {
        String str2;
        String str;
        int tVar;
        int pOST;
        String str3;
        String str4 = this.n;
        if (str4 != null) {
            return String.valueOf(str4);
        }
        str = this.b;
        final int i = 0;
        if (this.k == t.POST && str != null && l.w(str, "/videos", i, 2, 0)) {
            if (str != null) {
                if (l.w(str, "/videos", i, 2, 0)) {
                    str2 = z.i();
                } else {
                    str2 = z.h(o.q());
                }
            } else {
            }
        } else {
        }
        g();
        return h(w(str2), i);
    }
}
