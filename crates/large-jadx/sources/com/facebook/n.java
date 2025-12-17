package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.b0;
import com.facebook.internal.h;
import com.facebook.internal.h.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u0000 @2\u00020\u0001:\u0003?@AB!\u0008\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u000f\u0008\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B\u0081\u0001\u0008\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0008\u00109\u001a\u00020\tH\u0016J\u0008\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\tH\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010+R\"\u0010\u0004\u001a\u0004\u0018\u00010\u001c2\u0008\u00101\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00105R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010)R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010)¨\u0006B", d2 = {"Lcom/facebook/FacebookRequestError;", "Landroid/os/Parcelable;", "connection", "Ljava/net/HttpURLConnection;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V", "errorCode", "", "errorType", "", "errorMessage", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestStatusCode", "subErrorCode", "errorMessageField", "errorUserTitle", "errorUserMessage", "requestResultBody", "Lorg/json/JSONObject;", "requestResult", "batchRequestResult", "", "exceptionField", "Lcom/facebook/FacebookException;", "errorIsTransient", "", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;Z)V", "getBatchRequestResult", "()Ljava/lang/Object;", "category", "Lcom/facebook/FacebookRequestError$Category;", "getCategory", "()Lcom/facebook/FacebookRequestError$Category;", "getConnection", "()Ljava/net/HttpURLConnection;", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "errorRecoveryMessage", "getErrorRecoveryMessage", "getErrorType", "getErrorUserMessage", "getErrorUserTitle", "<set-?>", "getException", "()Lcom/facebook/FacebookException;", "getRequestResult", "()Lorg/json/JSONObject;", "getRequestResultBody", "getRequestStatusCode", "getSubErrorCode", "describeContents", "toString", "writeToParcel", "", "out", "flags", "Category", "Companion", "Range", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class n implements Parcelable {

    private static final com.facebook.n.d C;
    public static final Parcelable.Creator<com.facebook.n> CREATOR;
    public static final com.facebook.n.c D;
    private final String A;
    private final Object B;
    private final String a;
    private com.facebook.FacebookException b;
    private final com.facebook.n.a c;
    private final int v;
    private final int w;
    private final int x;
    private final String y;
    private final String z;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lcom/facebook/FacebookRequestError$Category;", "", "(Ljava/lang/String;I)V", "LOGIN_RECOVERABLE", "OTHER", "TRANSIENT", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;
    }

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/FacebookRequestError$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/FacebookRequestError;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/FacebookRequestError;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements Parcelable.Creator<com.facebook.n> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.n a(Parcel parcel) {
            n.f(parcel, "parcel");
            n nVar = new n(parcel, 0);
            return nVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.n[] b(int i) {
            return new n[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    @Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\u00082\u0006\u0010 \u001a\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010\u00012\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006%", d2 = {"Lcom/facebook/FacebookRequestError$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/FacebookRequestError;", "ERROR_CODE_FIELD_KEY", "ERROR_CODE_KEY", "ERROR_IS_TRANSIENT_KEY", "ERROR_KEY", "ERROR_MESSAGE_FIELD_KEY", "ERROR_MSG_KEY", "ERROR_REASON_KEY", "ERROR_SUB_CODE_KEY", "ERROR_TYPE_FIELD_KEY", "ERROR_USER_MSG_KEY", "ERROR_USER_TITLE_KEY", "HTTP_RANGE_SUCCESS", "Lcom/facebook/FacebookRequestError$Range;", "getHTTP_RANGE_SUCCESS$facebook_core_release", "()Lcom/facebook/FacebookRequestError$Range;", "INVALID_ERROR_CODE", "", "INVALID_HTTP_STATUS_CODE", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "checkResponseAndCreateError", "singleResult", "Lorg/json/JSONObject;", "batchResult", "connection", "Ljava/net/HttpURLConnection;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c {
        public c(g g) {
            super();
        }

        public final com.facebook.n a(JSONObject jSONObject, Object object2, HttpURLConnection httpURLConnection3) {
            String optInt2;
            boolean z;
            boolean optString4;
            int str2;
            String optString5;
            boolean int;
            Object obj;
            int optInt;
            int optString3;
            int i2;
            int optString;
            int optBoolean;
            int optInt3;
            int i;
            int optString2;
            int str;
            Object obj12 = jSONObject;
            optInt2 = "error_code";
            optString4 = "error";
            String str4 = "FACEBOOK_NON_JSON_RESULT";
            String str5 = "body";
            str2 = "code";
            n.f(obj12, "singleResult");
            final int i32 = 0;
            int = obj12.getInt(str2);
            obj = b0.I(obj12, str5, str4);
            if (obj12.has(str2) && obj != null && obj instanceof JSONObject != null) {
                int = obj12.getInt(str2);
                obj = b0.I(obj12, str5, str4);
                if (obj != null) {
                    if (obj instanceof JSONObject != null) {
                        int i19 = 1;
                        String str10 = "error_subcode";
                        optBoolean = 0;
                        optInt3 = -1;
                        if ((JSONObject)obj.has(optString4)) {
                            optInt2 = b0.I((JSONObject)obj, optString4, i32);
                            if ((JSONObject)optInt2 != null) {
                                optString4 = (JSONObject)optInt2.optString("type", i32);
                            } else {
                                optString4 = i32;
                            }
                            if (optInt2 != null) {
                                optString3 = optInt2.optString("message", i32);
                            } else {
                                optString3 = i32;
                            }
                            if (optInt2 != null) {
                                optString5 = optInt2.optInt(str2, optInt3);
                            } else {
                                optString5 = optInt3;
                            }
                            if (optInt2 != null) {
                                optInt3 = optInt2.optInt(str10, optInt3);
                            }
                            if (optInt2 != null) {
                                optString = optInt2.optString("error_user_msg", i32);
                            } else {
                                optString = i32;
                            }
                            try {
                                if (optInt2 != null) {
                                } else {
                                }
                                optString2 = optInt2.optString("error_user_title", i32);
                                optString2 = i32;
                                if (optInt2 != null) {
                                }
                                optBoolean = optInt2.optBoolean("is_transient", optBoolean);
                                str = optBoolean;
                                optBoolean = i19;
                                i2 = optString3;
                                optInt = optInt3;
                                optInt3 = optString5;
                                String str6 = "error_msg";
                                String str8 = "error_reason";
                                if (!(JSONObject)obj.has(optInt2) && !(JSONObject)obj.has(str6)) {
                                } else {
                                }
                                if (!(JSONObject)obj.has(str6)) {
                                } else {
                                }
                                if ((JSONObject)obj.has(str8)) {
                                } else {
                                }
                                str = optBoolean;
                                optInt = optInt3;
                                optString2 = optString;
                                optString4 = (JSONObject)obj.optString(str8, i32);
                                optInt = (JSONObject)obj.optInt(str10, optInt3);
                                optInt3 = optInt2;
                                str = optBoolean;
                                optString2 = optString;
                                optBoolean = i19;
                                i2 = optString5;
                                str2 = optString4;
                                if (optBoolean != 0) {
                                }
                                super(int, optInt3, optInt, str2, i2, optString2, optString, (JSONObject)obj, jSONObject, object2, httpURLConnection3, 0, str, 0);
                                return nVar3;
                                if (!c().a(int)) {
                                }
                                if (obj12.has(str5)) {
                                } else {
                                }
                                i = z;
                                i = i32;
                                super(int, -1, -1, 0, 0, 0, 0, i, jSONObject, object2, httpURLConnection3, 0, 0, 0);
                                return nVar4;
                                return i32;
                            }
                        } else {
                        }
                    }
                }
            }
        }

        public final h b() {
            p pVar = q.j(o.g());
            synchronized (this) {
                try {
                    return pVar.c();
                    return h.h.b();
                    throw th;
                }
            }
        }

        public final com.facebook.n.d c() {
            return n.a();
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003H\u0086\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lcom/facebook/FacebookRequestError$Range;", "", "start", "", "end", "(II)V", "contains", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        private final int a;
        private final int b;
        public d(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }

        public final boolean a(int i) {
            int obj3;
            if (this.a > i) {
                obj3 = 0;
            } else {
                if (this.b >= i) {
                    obj3 = 1;
                } else {
                }
            }
            return obj3;
        }
    }
    static {
        n.c cVar = new n.c(0);
        n.D = cVar;
        n.d dVar = new n.d(200, 299);
        n.C = dVar;
        n.b bVar = new n.b();
        n.CREATOR = bVar;
    }

    private n(int i, int i2, int i3, String string4, String string5, String string6, String string7, JSONObject jSONObject8, JSONObject jSONObject9, Object object10, HttpURLConnection httpURLConnection11, com.facebook.FacebookException facebookException12, boolean z13) {
        int obj1;
        String obj4;
        super();
        this.v = i;
        this.w = i2;
        this.x = i3;
        this.y = string4;
        this.z = string6;
        this.A = string7;
        this.B = object10;
        this.a = string5;
        if (facebookException12 != null) {
            this.b = facebookException12;
            obj1 = 1;
        } else {
            obj1 = new FacebookServiceException(this, c());
            this.b = obj1;
            obj1 = 0;
        }
        if (obj1 != null) {
            obj1 = n.a.OTHER;
        } else {
            obj1 = n.D.b().c(i2, i3, z13);
        }
        this.c = obj1;
        n.D.b().d(obj1);
    }

    public n(int i, int i2, int i3, String string4, String string5, String string6, String string7, JSONObject jSONObject8, JSONObject jSONObject9, Object object10, HttpURLConnection httpURLConnection11, com.facebook.FacebookException facebookException12, boolean z13, g g14) {
        super(i, i2, i3, string4, string5, string6, string7, jSONObject8, jSONObject9, object10, httpURLConnection11, facebookException12, z13);
    }

    public n(int i, String string2, String string3) {
        super(-1, i, -1, string2, string3, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    private n(Parcel parcel) {
        super(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), 0, 0, 0, 0, 0, 0);
    }

    public n(Parcel parcel, g g2) {
        super(parcel);
    }

    public n(HttpURLConnection httpURLConnection, Exception exception2) {
        boolean facebookException;
        Object obj;
        final Object obj2 = exception2;
        if (obj2 instanceof FacebookException != null) {
            obj = obj2;
        } else {
            facebookException = new FacebookException((FacebookException)obj2);
            obj = facebookException;
        }
        super(-1, -1, -1, 0, 0, 0, 0, 0, 0, 0, httpURLConnection, obj, 0);
    }

    public static final com.facebook.n.d a() {
        return n.C;
    }

    @Override // android.os.Parcelable
    public final int b() {
        return this.w;
    }

    @Override // android.os.Parcelable
    public final String c() {
        String localizedMessage;
        if (this.a != null) {
        } else {
            com.facebook.FacebookException exc = this.b;
            if (exc != null) {
                localizedMessage = exc.getLocalizedMessage();
            } else {
                localizedMessage = 0;
            }
        }
        return localizedMessage;
    }

    @Override // android.os.Parcelable
    public final String d() {
        return this.y;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final com.facebook.FacebookException e() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int f() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public final int g() {
        return this.x;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{HttpStatus: ");
        stringBuilder.append(this.v);
        stringBuilder.append(", errorCode: ");
        stringBuilder.append(this.w);
        stringBuilder.append(", subErrorCode: ");
        stringBuilder.append(this.x);
        stringBuilder.append(", errorType: ");
        stringBuilder.append(this.y);
        stringBuilder.append(", errorMessage: ");
        stringBuilder.append(c());
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder(\"{HttpStat…(\"}\")\n        .toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeString(c());
        parcel.writeString(this.z);
        parcel.writeString(this.A);
    }
}
