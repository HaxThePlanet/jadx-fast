package com.facebook;

import android.util.Log;
import com.facebook.internal.b0;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B+\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rB!\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010BA\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000c\u0012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0012J\u0008\u0010!\u001a\u0004\u0018\u00010\u000cJ\u0008\u0010\"\u001a\u0004\u0018\u00010\tJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020%J\u0008\u0010&\u001a\u00020\u0007H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 ¨\u0006)", d2 = {"Lcom/facebook/GraphResponse;", "", "request", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "rawResponse", "", "graphObject", "Lorg/json/JSONObject;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;)V", "graphObjects", "Lorg/json/JSONArray;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONArray;)V", "error", "Lcom/facebook/FacebookRequestError;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V", "graphObjectArray", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lcom/facebook/FacebookRequestError;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "getError", "()Lcom/facebook/FacebookRequestError;", "jsonArray", "getJsonArray", "()Lorg/json/JSONArray;", "jsonObject", "getJsonObject", "()Lorg/json/JSONObject;", "getRawResponse", "()Ljava/lang/String;", "getRequest", "()Lcom/facebook/GraphRequest;", "getJSONArray", "getJSONObject", "getRequestForPagedResults", "direction", "Lcom/facebook/GraphResponse$PagingDirection;", "toString", "Companion", "PagingDirection", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class s {

    private static final String f = "com.facebook.s";
    public static final com.facebook.s.a g;
    private final JSONObject a;
    private final HttpURLConnection b;
    private final JSONObject c;
    private final JSONArray d;
    private final com.facebook.n e;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000b2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J*\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002J.\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J/\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0008\u001cJ-\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0008\u001fJ#\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0008!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lcom/facebook/GraphResponse$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "NON_JSON_RESPONSE_PROPERTY", "RESPONSE_LOG_TAG", "SUCCESS_KEY", "TAG", "constructErrorResponses", "", "Lcom/facebook/GraphResponse;", "requests", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "error", "Lcom/facebook/FacebookException;", "createResponseFromObject", "request", "sourceObject", "originalResult", "createResponsesFromObject", "createResponsesFromStream", "stream", "Ljava/io/InputStream;", "Lcom/facebook/GraphRequestBatch;", "createResponsesFromStream$facebook_core_release", "createResponsesFromString", "responseString", "createResponsesFromString$facebook_core_release", "fromHttpConnection", "fromHttpConnection$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final com.facebook.s b(com.facebook.p p, HttpURLConnection httpURLConnection2, Object object3, Object object4) {
            int i;
            boolean str;
            int obj5;
            Object obj6;
            final int i2 = 0;
            obj6 = n.D.a((JSONObject)object3, object4, httpURLConnection2);
            Log.e(s.a(), obj6.toString());
            if (object3 instanceof JSONObject != null && obj6 != null && obj6.b() == 190 && b0.S(p.k())) {
                obj6 = n.D.a((JSONObject)object3, object4, httpURLConnection2);
                if (obj6 != null) {
                    Log.e(s.a(), obj6.toString());
                    if (obj6.b() == 190) {
                        if (b0.S(p.k())) {
                            if (obj6.g() != 493) {
                                a.H.h(i2);
                            } else {
                                obj5 = a.H;
                                i = obj5.e();
                                if (i != null && !i.p()) {
                                    if (!i.p()) {
                                        obj5.d();
                                    }
                                }
                            }
                        }
                    }
                    obj5 = new s(p, httpURLConnection2, obj6);
                    return obj5;
                }
                obj5 = b0.I(object3, "body", "FACEBOOK_NON_JSON_RESULT");
                if (obj5 instanceof JSONObject != null) {
                    obj6 = new s(p, httpURLConnection2, obj5.toString(), (JSONObject)obj5);
                    return obj6;
                }
                if (obj5 instanceof JSONArray != null) {
                    obj6 = new s(p, httpURLConnection2, obj5.toString(), (JSONArray)obj5);
                    return obj6;
                }
                n.e(JSONObject.NULL, "JSONObject.NULL");
            }
            if (obj5 != JSONObject.NULL) {
            } else {
                obj6 = new s(p, httpURLConnection2, obj5.toString(), i2);
                return obj6;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Got unexpected object type in response, class: ");
            obj4.append(obj5.getClass().getSimpleName());
            FacebookException obj3 = new FacebookException(obj4.toString());
            throw obj3;
        }

        private final List<com.facebook.s> c(HttpURLConnection httpURLConnection, List<com.facebook.p> list2, Object object3) {
            int i2;
            int i;
            boolean z;
            Throwable jSONObject;
            com.facebook.s sVar2;
            int responseCode;
            Object jSONArray;
            com.facebook.n sVar;
            com.facebook.n nVar;
            int size = list2.size();
            ArrayList arrayList = new ArrayList(size);
            if (size == 1) {
                i = list2.get(0);
                jSONObject = new JSONObject();
                jSONObject.put("body", object3);
                if (httpURLConnection != null) {
                    responseCode = httpURLConnection.getResponseCode();
                } else {
                    responseCode = 200;
                }
                jSONObject.put("code", responseCode);
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            } else {
                jSONArray = object3;
            }
            if (jSONArray instanceof JSONArray == null) {
            } else {
                z = jSONArray;
                if ((JSONArray)z.length() != size) {
                } else {
                    while (i2 < z.length()) {
                        Object obj2 = (JSONArray)jSONArray.get(i2);
                        n.e(obj2, "obj");
                        arrayList.add(b((p)list2.get(i2), httpURLConnection, obj2, object3));
                        i2++;
                        nVar = new n(httpURLConnection, jSONObject);
                        sVar = new s(obj3, httpURLConnection, nVar);
                        obj1.add(sVar);
                        nVar = new n(httpURLConnection, jSONObject);
                        sVar = new s(obj3, httpURLConnection, nVar);
                        obj1.add(sVar);
                    }
                    return arrayList;
                }
            }
            FacebookException obj9 = new FacebookException("Unexpected number of results");
            throw obj9;
        }

        public final List<com.facebook.s> a(List<com.facebook.p> list, HttpURLConnection httpURLConnection2, com.facebook.FacebookException facebookException3) {
            int next;
            com.facebook.s sVar;
            com.facebook.n nVar;
            n.f(list, "requests");
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            final Iterator obj5 = list.iterator();
            for (p next : obj5) {
                nVar = new n(httpURLConnection2, facebookException3);
                sVar = new s(next, httpURLConnection2, nVar);
                arrayList.add(sVar);
            }
            return arrayList;
        }

        public final List<com.facebook.s> d(InputStream inputStream, HttpURLConnection httpURLConnection2, com.facebook.r r3) {
            n.f(r3, "requests");
            String obj6 = b0.m0(inputStream);
            Object[] arr = new Object[2];
            v.f.c(v.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(obj6.length()), obj6);
            return e(obj6, httpURLConnection2, r3);
        }

        public final List<com.facebook.s> e(String string, HttpURLConnection httpURLConnection2, com.facebook.r r3) {
            n.f(string, "responseString");
            n.f(r3, "requests");
            JSONTokener jSONTokener = new JSONTokener(string);
            Object nextValue = jSONTokener.nextValue();
            n.e(nextValue, "resultObject");
            final List obj6 = c(httpURLConnection2, r3, nextValue);
            Object[] arr = new Object[3];
            v.f.c(v.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", r3.v(), Integer.valueOf(string.length()), obj6);
            return obj6;
        }

        public final List<com.facebook.s> f(HttpURLConnection httpURLConnection, com.facebook.r r2) {
            String str;
            int i;
            InputStream inputStream;
            int responseCode;
            int i2;
            com.facebook.v rEQUESTS;
            List obj9;
            str = "Response <Error>: %s";
            final String str2 = "Response";
            n.f(httpURLConnection, "connection");
            n.f(r2, "requests");
            int i3 = 0;
            i = 1;
            int i4 = 0;
            if (!o.x()) {
            } else {
                if (httpURLConnection.getResponseCode() >= 400) {
                    inputStream = httpURLConnection.getErrorStream();
                } else {
                    inputStream = httpURLConnection.getInputStream();
                }
                obj9 = d(inputStream, httpURLConnection, r2);
                b0.i(inputStream);
                return obj9;
            }
            String str5 = "GraphRequest can't be used when Facebook SDK isn't fully initialized";
            Log.e(s.a(), str5);
            FacebookException facebookException2 = new FacebookException(str5);
            throw facebookException2;
        }
    }
    static {
        s.a aVar = new s.a(0);
        s.g = aVar;
    }

    public s(com.facebook.p p, HttpURLConnection httpURLConnection2, com.facebook.n n3) {
        n.f(p, "request");
        n.f(n3, "error");
        super(p, httpURLConnection2, 0, 0, 0, n3);
    }

    public s(com.facebook.p p, HttpURLConnection httpURLConnection2, String string3, JSONArray jSONArray4) {
        n.f(p, "request");
        n.f(string3, "rawResponse");
        n.f(jSONArray4, "graphObjects");
        super(p, httpURLConnection2, string3, 0, jSONArray4, 0);
    }

    public s(com.facebook.p p, HttpURLConnection httpURLConnection2, String string3, JSONObject jSONObject4) {
        n.f(p, "request");
        n.f(string3, "rawResponse");
        super(p, httpURLConnection2, string3, jSONObject4, 0, 0);
    }

    public s(com.facebook.p p, HttpURLConnection httpURLConnection2, String string3, JSONObject jSONObject4, JSONArray jSONArray5, com.facebook.n n6) {
        n.f(p, "request");
        super();
        this.b = httpURLConnection2;
        this.c = jSONObject4;
        this.d = jSONArray5;
        this.e = n6;
        this.a = jSONObject4;
    }

    public static final String a() {
        return s.f;
    }

    public final com.facebook.n b() {
        return this.e;
    }

    public final JSONObject c() {
        return this.c;
    }

    public final JSONObject d() {
        return this.a;
    }

    public String toString() {
        String format;
        int responseCode;
        try {
            f0 f0Var = f0.a;
            int i = 1;
            final Object[] arr = new Object[i];
            HttpURLConnection connection = this.b;
            if (connection != null) {
            } else {
            }
            responseCode = connection.getResponseCode();
            responseCode = 200;
            arr[0] = Integer.valueOf(responseCode);
            n.e(String.format(Locale.US, "%d", Arrays.copyOf(arr, i)), "java.lang.String.format(locale, format, *args)");
            String str = "unknown";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{Response: ");
            stringBuilder.append(" responseCode: ");
            stringBuilder.append(format);
            stringBuilder.append(", graphObject: ");
            stringBuilder.append(this.c);
            stringBuilder.append(", error: ");
            stringBuilder.append(this.e);
            stringBuilder.append("}");
            String string = stringBuilder.toString();
            n.e(string, "StringBuilder()\n        …(\"}\")\n        .toString()");
            return string;
        }
    }
}
