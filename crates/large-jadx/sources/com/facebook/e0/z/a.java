package com.facebook.e0.z;

import android.util.Patterns;
import com.facebook.internal.g0.i.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0008\u0010#\u001a\u00020\u000fH\u0007J)\u0010$\u001a\u00020\u000f2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00060&2\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010(J0\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J(\u00100\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0002J(\u00109\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010:\u001a\u00060;j\u0002`<2\n\u0010=\u001a\u00060;j\u0002`<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006>", d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "()V", "NUM_OF_FEATURES", "", "REGEX_ADD_TO_CART_BUTTON_TEXT", "", "REGEX_ADD_TO_CART_PAGE_TITLE", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_CR_PASSWORD_FIELD", "eventInfo", "", "initialized", "", "languageInfo", "rules", "Lorg/json/JSONObject;", "textTypeInfo", "getDenseFeatures", "", "viewHierarchy", "appName", "getInteractedNode", "view", "getTextFeature", "buttonText", "activityName", "initialize", "", "file", "Ljava/io/File;", "isButton", "node", "isInitialized", "matchIndicators", "indicators", "", "values", "([Ljava/lang/String;[Ljava/lang/String;)Z", "nonparseFeatures", "siblings", "Lorg/json/JSONArray;", "screenName", "formFieldsJSON", "parseFeatures", "pruneTree", "regexMatched", "pattern", "matchText", "language", "event", "textType", "sum", "a", "b", "updateHintAndTextRecursively", "textSB", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "hintSB", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static Map<String, String> a;
    private static Map<String, String> b;
    private static Map<String, String> c;
    private static JSONObject d;
    private static boolean e;
    public static final com.facebook.e0.z.a f;
    static {
        a aVar = new a();
        a.f = aVar;
    }

    public static final float[] a(JSONObject jSONObject, String string2) {
        int i;
        int i2;
        final int i4 = 0;
        if (a.d(a.class)) {
            return i4;
        }
        n.f(jSONObject, "viewHierarchy");
        n.f(string2, "appName");
        if (!a.e) {
            return i4;
        }
        int i3 = 30;
        final float[] fArr2 = new float[i3];
        i = 0;
        while (i < i3) {
            fArr2[i] = 0;
            i++;
        }
        final String lowerCase = string2.toLowerCase();
        n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        JSONObject obj11 = new JSONObject(jSONObject.optJSONObject("view").toString());
        final String optString = jSONObject.optString("screenname");
        JSONArray jSONArray = new JSONArray();
        final com.facebook.e0.z.a obj10 = a.f;
        obj10.j(obj11, jSONArray);
        obj10.m(fArr2, obj10.i(obj11));
        JSONObject jSONObject2 = obj10.b(obj11);
        if (jSONObject2 != null) {
            n.e(optString, "screenName");
            final String string3 = obj11.toString();
            n.e(string3, "viewTree.toString()");
            obj10.m(fArr2, obj10.h(jSONObject2, jSONArray, optString, string3, lowerCase));
            return fArr2;
        }
        return i4;
    }

    private final JSONObject b(JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2;
        String str;
        JSONArray obj6;
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        if (jSONObject.optBoolean("is_interacted")) {
            return jSONObject;
        }
        obj6 = jSONObject.optJSONArray("childviews");
        if (obj6 != null) {
            i = 0;
            while (i < obj6.length()) {
                JSONObject jSONObject3 = obj6.getJSONObject(i);
                n.e(jSONObject3, "children.getJSONObject(i)");
                jSONObject2 = b(jSONObject3);
                i++;
            }
            return i2;
        }
        return i2;
    }

    public static final String c(String string, String string2, String string3) {
        if (a.d(a.class)) {
            return null;
        }
        n.f(string, "buttonText");
        n.f(string2, "activityName");
        n.f(string3, "appName");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(" | ");
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string);
        String obj3 = stringBuilder.toString();
        if (obj3 == null) {
        } else {
            obj3 = obj3.toLowerCase();
            n.e(obj3, "(this as java.lang.String).toLowerCase()");
            return obj3;
        }
        obj3 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        throw obj3;
    }

    public static final void d(File file) {
        String str = "4";
        String str2 = "3";
        String str4 = "2";
        String str6 = "1";
        if (a.d(a.class)) {
        }
        JSONObject jSONObject = new JSONObject();
        a.d = jSONObject;
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] obj13 = new byte[fileInputStream.available()];
        fileInputStream.read(obj13);
        fileInputStream.close();
        String string = new String(obj13, d.a);
        JSONObject jSONObject2 = new JSONObject(string);
        a.d = jSONObject2;
        obj13 = 4;
        kotlin.o[] arr = new o[obj13];
        int i6 = 0;
        arr[i6] = u.a("ENGLISH", str6);
        final int i7 = 1;
        arr[i7] = u.a("GERMAN", str4);
        final int i8 = 2;
        arr[i8] = u.a("SPANISH", str2);
        final int i9 = 3;
        arr[i9] = u.a("JAPANESE", str);
        a.a = j0.k(arr);
        kotlin.o[] arr2 = new o[9];
        arr2[i6] = u.a("VIEW_CONTENT", "0");
        arr2[i7] = u.a("SEARCH", str6);
        arr2[i8] = u.a("ADD_TO_CART", str4);
        arr2[i9] = u.a("ADD_TO_WISHLIST", str2);
        arr2[obj13] = u.a("INITIATE_CHECKOUT", str);
        arr2[5] = u.a("ADD_PAYMENT_INFO", "5");
        arr2[6] = u.a("PURCHASE", "6");
        arr2[7] = u.a("LEAD", "7");
        arr2[8] = u.a("COMPLETE_REGISTRATION", "8");
        a.b = j0.k(arr2);
        obj13 = new o[obj13];
        obj13[i6] = u.a("BUTTON_TEXT", str6);
        obj13[i7] = u.a("PAGE_TITLE", str4);
        obj13[i8] = u.a("RESOLVED_DOCUMENT_LINK", str2);
        obj13[i9] = u.a("BUTTON_ID", str);
        a.c = j0.k(obj13);
        a.e = i7;
    }

    private final boolean e(JSONObject jSONObject) {
        int i;
        if (a.d(this)) {
            return 0;
        }
        int i2 = 1;
        if (obj3 <<= 5 > 0) {
            i = i2;
        }
        return i;
    }

    public static final boolean f() {
        if (a.d(a.class)) {
            return 0;
        }
        return a.e;
    }

    private final boolean g(String[] stringArr, String[] string2Arr2) {
        int i;
        Object obj;
        int length;
        int i3;
        boolean z;
        int i4;
        int i2;
        final int i5 = 0;
        if (a.d(this)) {
            return i5;
        }
        i = i5;
        while (i < stringArr.length) {
            i3 = i5;
            while (i3 < string2Arr2.length) {
                i3++;
            }
            i++;
            i3++;
        }
        return i5;
    }

    private final float[] h(JSONObject jSONObject, JSONArray jSONArray2, String string3, String string4, String string5) {
        int i;
        int i8;
        int i7;
        int i17;
        int i4;
        int i15;
        int i3;
        int i5;
        int i6;
        boolean z;
        int i11;
        int i16;
        int i12;
        int i9;
        int i2;
        int i13;
        JSONObject jSONObject2;
        int i14;
        int i18;
        int i19;
        int i10;
        final Object obj = this;
        java.lang.CharSequence charSequence = string4;
        String str = "LEAD";
        String str2 = "PURCHASE";
        final String str5 = "PAGE_TITLE";
        final String str6 = "BUTTON_TEXT";
        String str7 = "COMPLETE_REGISTRATION";
        final String str8 = "ENGLISH";
        if (a.d(this)) {
            return null;
        }
        int i31 = 30;
        final float[] fArr = new float[i31];
        final int i36 = 0;
        i9 = i36;
        i13 = 0;
        while (i9 < i31) {
            fArr[i9] = i13;
            i9++;
            i13 = 0;
        }
        int length = jSONArray2.length();
        final int i43 = 1065353216;
        i5 = length > 1 ? f - i43 : i13;
        fArr[3] = i5;
        i2 = i36;
        while (i2 < jSONArray2.length()) {
            jSONObject2 = jSONArray2.getJSONObject(i2);
            n.e(jSONObject2, "siblings.getJSONObject(i)");
            if (obj.e(jSONObject2)) {
            }
            i2++;
            i6 = 0;
            i13 = 0;
            z = 9;
            fArr[z] = f2 += i43;
        }
        int i34 = -1082130432;
        fArr[13] = i34;
        fArr[14] = i34;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append('|');
        stringBuilder.append(string5);
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        obj.n(jSONObject, stringBuilder3, stringBuilder2);
        String string2 = stringBuilder2.toString();
        n.e(string2, "hintSB.toString()");
        String string6 = stringBuilder3.toString();
        n.e(string6, "textSB.toString()");
        i19 = obj.l(str8, str7, str6, string6) ? i43 : 0;
        fArr[15] = i19;
        i10 = obj.l(str8, str7, str5, string) ? i43 : 0;
        fArr[16] = i10;
        i15 = obj.l(str8, str7, "BUTTON_ID", string2) ? i43 : 0;
        fArr[17] = i15;
        i11 = l.R(charSequence, "password", i36, 2, 0) ? i43 : 0;
        fArr[18] = i11;
        if (obj.k("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", charSequence)) {
            try {
                i16 = i43;
                i16 = 0;
                fArr[19] = i16;
                if (obj.k("(?i)(sign in)|login|signIn", charSequence)) {
                } else {
                }
                i12 = i43;
                i12 = 0;
                fArr[20] = i12;
                if (obj.k("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", charSequence) != null) {
                } else {
                }
                i = i43;
                i = 0;
                fArr[21] = i;
                if (obj.l(str8, str2, str6, string6)) {
                } else {
                }
                i3 = i43;
                i3 = 0;
                fArr[22] = i3;
                if (obj.l(str8, str2, str5, string)) {
                } else {
                }
                i8 = i43;
                i8 = 0;
                fArr[24] = i8;
                if (obj.k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", string6)) {
                } else {
                }
                i7 = i43;
                i7 = 0;
                fArr[25] = i7;
                if (obj.k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", string)) {
                } else {
                }
                i17 = i43;
                i17 = 0;
                fArr[27] = i17;
                if (obj.l(str8, str, str6, string6)) {
                } else {
                }
                i4 = i43;
                i4 = 0;
                fArr[28] = i4;
                if (obj.l(str8, str, str5, string)) {
                } else {
                }
                i14 = i43;
                i14 = 0;
                fArr[29] = i14;
                return fArr;
                a.b(th, obj1);
                return null;
            } catch (org.json.JSONException jSON) {
            } catch (Throwable th1) {
            }
        } else {
        }
    }

    private final float[] i(JSONObject jSONObject) {
        boolean optInt;
        boolean z3;
        boolean z5;
        boolean z6;
        String lowerCase;
        int i3;
        int i;
        String lowerCase2;
        int i5;
        boolean z2;
        boolean z;
        boolean z4;
        boolean z7;
        int i4;
        int i2;
        String[] strArr;
        String str = "(this as java.lang.String).toLowerCase()";
        final int i7 = 0;
        if (a.d(this)) {
            return i7;
        }
        int i6 = 30;
        final float[] fArr = new float[i6];
        i3 = 0;
        i = i3;
        while (i < i6) {
            fArr[i] = 0;
            i++;
        }
        String optString = jSONObject.optString("text");
        n.e(optString, "node.optString(TEXT_KEY)");
        String str10 = "null cannot be cast to non-null type java.lang.String";
        if (optString == null) {
        } else {
            lowerCase = optString.toLowerCase();
            n.e(lowerCase, str);
            String optString2 = jSONObject.optString("hint");
            n.e(optString2, "node.optString(HINT_KEY)");
            if (optString2 == null) {
            } else {
                String lowerCase3 = optString2.toLowerCase();
                n.e(lowerCase3, str);
                String optString3 = jSONObject.optString("classname");
                n.e(optString3, "node.optString(CLASS_NAME_KEY)");
                if (optString3 == null) {
                } else {
                    lowerCase2 = optString3.toLowerCase();
                    n.e(lowerCase2, str);
                    optInt = jSONObject.optInt("inputtype", -1);
                    int i9 = 2;
                    strArr = new String[i9];
                    strArr[i3] = lowerCase;
                    final int i10 = 1;
                    strArr[i10] = lowerCase3;
                    int i11 = 1065353216;
                    if (g(/* result */, strArr)) {
                        fArr[i3] = f3 += i11;
                    }
                    if (g(/* result */, strArr)) {
                        fArr[i10] = f7 += i11;
                    }
                    try {
                        if (g(/* result */, strArr)) {
                        }
                        fArr[i9] = f6 += i11;
                        if (g(/* result */, strArr)) {
                        }
                        z7 = 4;
                        fArr[z7] = f8 += i11;
                        if (optInt >= 0) {
                        }
                        z7 = 5;
                        fArr[z7] = f10 += i11;
                        if (optInt != 3) {
                        } else {
                        }
                        if (optInt == i9) {
                        }
                        i4 = 6;
                        fArr[i4] = f9 += i11;
                        if (optInt != 32) {
                        } else {
                        }
                        if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                        }
                        optInt = 7;
                        fArr[optInt] = f5 += i11;
                        if (l.R(lowerCase2, "checkbox", i3, i9, i7)) {
                        }
                        z3 = 8;
                        fArr[z3] = f4 += i11;
                        String[] strArr7 = new String[i10];
                        strArr7[i3] = lowerCase;
                        if (g(/* result */, strArr7)) {
                        }
                        z5 = 10;
                        fArr[z5] = f2 += i11;
                        if (l.R(lowerCase2, "radio", i3, i9, i7) && l.R(lowerCase2, "button", i3, i9, i7)) {
                        }
                        if (l.R(lowerCase2, "button", i3, i9, i7)) {
                        }
                        z6 = 12;
                        fArr[z6] = f += i11;
                        JSONArray obj14 = jSONObject.optJSONArray("childviews");
                        while (i3 < obj14.length()) {
                            JSONObject jSONObject2 = obj14.getJSONObject(i3);
                            n.e(jSONObject2, "childViews.getJSONObject(i)");
                            m(fArr, i(jSONObject2));
                            i3++;
                        }
                        jSONObject2 = obj14.getJSONObject(i3);
                        n.e(jSONObject2, "childViews.getJSONObject(i)");
                        m(fArr, i(jSONObject2));
                        i3++;
                        return fArr;
                    } catch (org.json.JSONException jSON) {
                    } catch (Throwable th1) {
                    }
                }
                obj14 = new NullPointerException(str10);
                throw obj14;
            }
            obj14 = new NullPointerException(str10);
            throw obj14;
        }
        obj14 = new NullPointerException(str10);
        throw obj14;
    }

    private final boolean j(JSONObject jSONObject, JSONArray jSONArray2) {
        int str;
        int jSONObject3;
        int i;
        int i2;
        boolean optBoolean;
        JSONObject jSONObject2;
        boolean z;
        int obj11;
        str = "childviews";
        String str2 = "is_interacted";
        final int i3 = 0;
        if (a.d(this)) {
            return i3;
        }
        final int i4 = 1;
        if (jSONObject.optBoolean(str2)) {
            return i4;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        i2 = i3;
        while (i2 < optJSONArray.length()) {
            i2++;
        }
        jSONObject3 = i3;
        i = jSONObject3;
        JSONArray jSONArray = new JSONArray();
        if (jSONObject3 != 0) {
            str = i3;
            try {
                while (str < optJSONArray.length()) {
                    jSONArray2.put(optJSONArray.getJSONObject(str));
                    str++;
                }
                jSONArray2.put(optJSONArray.getJSONObject(str));
                str++;
                optBoolean = i3;
                while (optBoolean < optJSONArray.length()) {
                    jSONObject2 = optJSONArray.getJSONObject(optBoolean);
                    n.e(jSONObject2, "child");
                    if (j(jSONObject2, jSONArray2)) {
                    }
                    optBoolean++;
                    jSONArray.put(jSONObject2);
                    i = i4;
                }
                jSONObject2 = optJSONArray.getJSONObject(optBoolean);
                n.e(jSONObject2, "child");
                if (j(jSONObject2, jSONArray2)) {
                }
                jSONArray.put(jSONObject2);
                i = i4;
                optBoolean++;
                jSONObject.put(str, jSONArray);
                return i;
                a.b(jSONObject, this);
                return obj3;
            }
        } else {
        }
    }

    private final boolean k(String string, String string2) {
        if (a.d(this)) {
            return 0;
        }
        return Pattern.compile(string).matcher(string2).find();
    }

    private final boolean l(String string, String string2, String string3, String string4) {
        Object optJSONObject;
        boolean i;
        int optString;
        Object str;
        Object obj5;
        Object obj6;
        if (a.d(this)) {
            return 0;
        }
        JSONObject jSONObject = a.d;
        optString = 0;
        if (jSONObject == null) {
        } else {
            optJSONObject = jSONObject.optJSONObject("rulesForLanguage");
            if (optJSONObject != null) {
                str = a.a;
                if (str == null) {
                } else {
                    obj5 = optJSONObject.optJSONObject((String)str.get(string));
                    obj5 = obj5.optJSONObject("rulesForEvent");
                    if (obj5 != null && obj5 != null) {
                        obj5 = obj5.optJSONObject("rulesForEvent");
                        if (obj5 != null) {
                            optJSONObject = a.b;
                            if (optJSONObject == null) {
                            } else {
                                try {
                                    obj5 = obj5.optJSONObject((String)optJSONObject.get(string2));
                                    obj5 = obj5.optJSONObject("positiveRules");
                                    if (obj5 != null && obj5 != null) {
                                    }
                                    obj5 = obj5.optJSONObject("positiveRules");
                                    if (obj5 != null) {
                                    }
                                    obj6 = a.c;
                                    if (obj6 == null) {
                                    } else {
                                    }
                                    optString = obj5.optString((String)obj6.get(string3));
                                    n.w("textTypeInfo");
                                    throw optString;
                                    n.w("eventInfo");
                                    throw optString;
                                    n.w("languageInfo");
                                    throw optString;
                                    if (optString == null) {
                                    } else {
                                    }
                                    i = k(optString, string4);
                                    return i;
                                    n.w("rules");
                                    throw optString;
                                    a.b(string, this);
                                    return obj1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final void m(float[] fArr, float[] f2Arr2) {
        int i;
        int i2;
        int i3;
        if (a.d(this)) {
        }
        i = 0;
        while (i < fArr.length) {
            fArr[i] = i4 += i3;
            i++;
        }
    }

    private final void n(JSONObject jSONObject, StringBuilder stringBuilder2, StringBuilder stringBuilder3) {
        int i3;
        String length;
        String jSONObject2;
        String lowerCase;
        int i;
        int i2;
        String str = "(this as java.lang.String).toLowerCase()";
        String str2 = "";
        if (a.d(this)) {
        }
        String optString2 = jSONObject.optString("text", str2);
        n.e(optString2, "view.optString(TEXT_KEY, \"\")");
        String str5 = "null cannot be cast to non-null type java.lang.String";
        if (optString2 == null) {
        } else {
            lowerCase = optString2.toLowerCase();
            n.e(lowerCase, str);
            String optString = jSONObject.optString("hint", str2);
            n.e(optString, "view.optString(HINT_KEY, \"\")");
            if (optString == null) {
            } else {
                jSONObject2 = optString.toLowerCase();
                n.e(jSONObject2, str);
                i2 = 0;
                i3 = lowerCase.length() > 0 ? i : i2;
                final String str8 = " ";
                if (i3 != 0) {
                    stringBuilder2.append(lowerCase);
                    stringBuilder2.append(str8);
                }
                if (jSONObject2.length() > 0) {
                } else {
                    try {
                        i = i2;
                        if (i != 0) {
                        }
                        stringBuilder3.append(jSONObject2);
                        stringBuilder3.append(str8);
                        JSONArray obj7 = jSONObject.optJSONArray("childviews");
                        if (obj7 != null) {
                        }
                        while (i2 < obj7.length()) {
                            jSONObject2 = obj7.getJSONObject(i2);
                            n.e(jSONObject2, "currentChildView");
                            n(jSONObject2, stringBuilder2, stringBuilder3);
                            i2++;
                        }
                        jSONObject2 = obj7.getJSONObject(i2);
                        n.e(jSONObject2, "currentChildView");
                        n(jSONObject2, stringBuilder2, stringBuilder3);
                        i2++;
                        obj7 = new NullPointerException(str5);
                        throw obj7;
                        obj7 = new NullPointerException(str5);
                        throw obj7;
                        a.b(jSONObject, this);
                    } catch (org.json.JSONException jSON) {
                    } catch (Throwable th1) {
                    }
                }
            }
        }
    }
}
