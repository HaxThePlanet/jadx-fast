package app.dogo.com.dogo_android.service;

import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedProgramsKt;
import app.dogo.com.dogo_android.util.o0.a;
import com.google.android.gms.tasks.j;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableReference;
import com.google.firebase.functions.HttpsCallableResult;
import com.google.gson.Gson;
import i.b.a0;
import i.b.c0;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.q;
import kotlin.u;
import kotlin.y.j0;
import kotlinx.coroutines.e3.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\u0008\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tJ\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nJ(\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000c2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "", "firebaseFunctions", "Lcom/google/firebase/functions/FirebaseFunctions;", "(Lcom/google/firebase/functions/FirebaseFunctions;)V", "checkIfEntryUpdateIsValid", "Lcom/google/android/gms/tasks/Task;", "Lapp/dogo/com/dogo_android/util/responses/EntryValidationResponse;", "payload", "", "", "requestCertificateProgram", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "programId", "dogId", "requestRecommendedProgram", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestTranslation", "text", "originalLanguage", "targetLanguage", "localePath", "resetRecapInformation", "", "userId", "submitRecommendedProgram", "answers", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i2 {

    public static final app.dogo.com.dogo_android.service.i2.a Companion;
    private final FirebaseFunctions a;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/service/CloudFunctionsService$Companion;", "", "()V", "CERTIFICATE_REQUEST_FUNCTION", "", "RECOMMENDED_PROGRAM_REQUEST_FUNCTION", "RECOMMENDED_PROGRAM_SUBMIT_FUNCTION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.service.CloudFunctionsService", f = "CloudFunctionsService.kt", l = 95, m = "requestRecommendedProgram")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.service.i2 this$0;
        b(app.dogo.com.dogo_android.service.i2 i2, d<? super app.dogo.com.dogo_android.service.i2.b> d2) {
            this.this$0 = i2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.l(0, this);
        }
    }
    static {
        i2.a aVar = new i2.a(0);
        i2.Companion = aVar;
    }

    public i2(FirebaseFunctions firebaseFunctions) {
        n.f(firebaseFunctions, "firebaseFunctions");
        super();
        this.a = firebaseFunctions;
    }

    private static final a b(j j) {
        n.f(j, "task");
        Object obj1 = j.getResult();
        n.d(obj1);
        a aVar = new a((HttpsCallableResult)obj1.getData());
        return aVar;
    }

    public static a c(j j) {
        return i2.b(j);
    }

    public static void d(c0 c0, String string2, j j3) {
        i2.k(c0, string2, j3);
    }

    public static void e(c0 c0, String string2, j j3) {
        i2.r(c0, string2, j3);
    }

    public static String f(String string, j j2) {
        return i2.n(string, j2);
    }

    public static void g(app.dogo.com.dogo_android.service.i2 i2, Map map2, String string3, c0 c04) {
        i2.j(i2, map2, string3, c04);
    }

    public static void h(app.dogo.com.dogo_android.service.i2 i2, Map map2, String string3, c0 c04) {
        i2.q(i2, map2, string3, c04);
    }

    private static final void j(app.dogo.com.dogo_android.service.i2 i2, Map map2, String string3, c0 c04) {
        n.f(i2, "this$0");
        n.f(map2, "$payload");
        n.f(string3, "$programId");
        n.f(c04, "emitter");
        e0 obj2 = new e0(c04, string3);
        i2.a.getHttpsCallable("certificates-generateProgramCertificateOnCall").call(map2).addOnCompleteListener(obj2);
    }

    private static final void k(c0 c0, String string2, j j3) {
        int successful;
        Object obj;
        boolean z;
        String str2;
        CertificateInfo certificateInfo;
        Object obj2;
        Object obj3;
        String str;
        int i;
        int i2;
        int i3;
        Object obj11;
        Object obj12;
        n.f(c0, "$emitter");
        n.f(string2, "$programId");
        n.f(j3, "task");
        if (j3.isSuccessful()) {
            obj12 = j3.getResult();
            successful = 0;
            if ((HttpsCallableResult)obj12 == null) {
                obj12 = successful;
            } else {
                obj12 = (HttpsCallableResult)obj12.getData();
            }
            if (obj12 instanceof Map != null) {
                if (obj instanceof String != null) {
                } else {
                    obj = successful;
                }
                str2 = "";
                obj3 = obj == null ? str2 : obj;
                obj12 = obj12.get("certificatePdfUrl");
                if (obj12 instanceof String != null) {
                    successful = obj12;
                }
                str = successful == 0 ? str2 : successful;
                super(string2, obj3, str, 0, 8, 0);
                c0.onSuccess(obj12);
            } else {
                obj11 = new Exception("unexpected results encountered");
                c0.a(obj11);
            }
        } else {
            obj11 = j3.getException();
            n.d(obj11);
            c0.a(obj11);
        }
    }

    private static final String n(String string, j j2) {
        n.f(string, "$text");
        n.f(j2, "task");
        Object obj2 = j2.getResult();
        n.d(obj2);
        return String.valueOf((HttpsCallableResult)obj2.getData());
    }

    private static final void q(app.dogo.com.dogo_android.service.i2 i2, Map map2, String string3, c0 c04) {
        n.f(i2, "this$0");
        n.f(map2, "$payload");
        n.f(string3, "$dogId");
        n.f(c04, "emitter");
        f0 obj2 = new f0(c04, string3);
        i2.a.getHttpsCallable("submitOnboardingSurveyAnswers").call(map2).addOnCompleteListener(obj2);
    }

    private static final void r(c0 c0, String string2, j j3) {
        boolean successful;
        Class<app.dogo.externalmodel.model.SurveyAnswerResponseModel> obj;
        Object obj3;
        Object obj4;
        n.f(c0, "$emitter");
        n.f(string2, "$dogId");
        n.f(j3, "task");
        if (j3.isSuccessful()) {
            obj4 = j3.getResult();
            if ((HttpsCallableResult)obj4 == null) {
                obj4 = 0;
            } else {
                obj4 = (HttpsCallableResult)obj4.getData();
            }
            if (obj4 instanceof Map != null) {
                Gson gson = new Gson();
                obj4 = gson.toJsonTree(obj4);
                n.e(obj4, "gson.toJsonTree(response)");
                obj4 = gson.fromJson(obj4, SurveyAnswerResponseModel.class);
                n.e(obj4, "gson.fromJson(jsonElement, SurveyAnswerResponseModel::class.java)");
                c0.onSuccess(RecommendedOrderedProgramsKt.toRecommendedOrderedPrograms((SurveyAnswerResponseModel)obj4, string2));
            } else {
                obj3 = new Exception("unexpected results encountered");
                c0.a(obj3);
            }
        } else {
            obj3 = j3.getException();
            n.d(obj3);
            c0.a(obj3);
        }
    }

    public final j<a> a(Map<String, ? extends Object> map) {
        j obj3 = this.a.getHttpsCallable("challengeEntryUploadCallback").call(map).continueWith(d0.a);
        n.e(obj3, "firebaseFunctions\n            .getHttpsCallable(\"challengeEntryUploadCallback\")\n            .call(payload)\n            .continueWith { task: Task<HttpsCallableResult> -> EntryValidationResponse(task.result!!.data) }");
        return obj3;
    }

    public final a0<CertificateInfo> i(String string, String string2) {
        String str = "programId";
        n.f(string, str);
        String str2 = "dogId";
        n.f(string2, str2);
        o[] arr = new o[2];
        h0 h0Var = new h0(this, j0.k(u.a(str2, string2), u.a(str, string)), string);
        final a0 obj4 = a0.create(h0Var);
        n.e(obj4, "create { emitter: SingleEmitter<CertificateInfo> ->\n            firebaseFunctions\n                .getHttpsCallable(CERTIFICATE_REQUEST_FUNCTION)\n                .call(payload)\n                .addOnCompleteListener { task: Task<HttpsCallableResult> ->\n                    if (task.isSuccessful) {\n                        val response = task.result?.data\n                        if (response is Map<*, *>) {\n                            val imageUrl = response[\"certificateImageUrl\"] as? String ?: \"\"\n                            val pdfUrl = response[\"certificatePdfUrl\"] as? String ?: \"\"\n                            emitter.onSuccess(\n                                CertificateInfo(\n                                    programId = programId,\n                                    certificateImageUrl = imageUrl,\n                                    certificatePdfUrl = pdfUrl\n                                )\n                            )\n                        } else {\n                            @Suppress(\"UnstableApiUsage\")\n                            emitter.tryOnError(Exception(\"unexpected results encountered\"))\n                        }\n                    } else {\n                        @Suppress(\"UnstableApiUsage\")\n                        emitter.tryOnError(task.exception!!)\n                    }\n                }\n        }");
        return obj4;
    }

    public final Object l(String string, d<? super RecommendedOrderedPrograms> d2) {
        boolean bVar;
        int label;
        int i2;
        int label2;
        int i;
        String str;
        Object obj6;
        Object obj7;
        bVar = d2;
        label = bVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof i2.b && label & i2 != 0) {
            bVar = d2;
            label = bVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                bVar.label = label -= i2;
            } else {
                bVar = new i2.b(this, d2);
            }
        } else {
        }
        obj7 = bVar.result;
        Object obj = b.d();
        label2 = bVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj6 = bVar.L$0;
                q.b(obj7);
                obj7 = (HttpsCallableResult)obj7.getData();
                if (obj7 instanceof Map == null) {
                } else {
                    Gson gson = new Gson();
                    obj7 = gson.toJsonTree(obj7);
                    n.e(obj7, "gson.toJsonTree(response)");
                    obj7 = gson.fromJson(obj7, SurveyAnswerResponseModel.class);
                    n.e(obj7, "gson.fromJson(jsonElement, SurveyAnswerResponseModel::class.java)");
                    return RecommendedOrderedProgramsKt.toRecommendedOrderedPrograms((SurveyAnswerResponseModel)obj7, obj6);
                }
                obj6 = new IllegalArgumentException(n.o("Received non map response :", obj7));
                throw obj6;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj7);
        obj7 = new o("dogId", string);
        obj7 = this.a.getHttpsCallable("getProgramRecommendations").call(j0.e(obj7));
        n.e(obj7, "firebaseFunctions\n            .getHttpsCallable(RECOMMENDED_PROGRAM_REQUEST_FUNCTION)\n            .call(payload)");
        bVar.L$0 = string;
        bVar.label = i3;
        if (a.a(obj7, bVar) == obj) {
            return obj;
        }
    }

    public final j<String> m(String string, String string2, String string3, String string4) {
        String str = "text";
        n.f(string, str);
        final String str3 = "targetLanguage";
        n.f(string3, str3);
        final String str4 = "localePath";
        n.f(string4, str4);
        HashMap hashMap = new HashMap();
        hashMap.put(str, string);
        hashMap.put("originalLanguage", string2);
        hashMap.put(str3, Locale.forLanguageTag(string3).getLanguage());
        hashMap.put(str4, string4);
        g0 obj7 = new g0(string);
        final j obj5 = this.a.getHttpsCallable("getTranslationHttpRequest").call(hashMap).continueWith(obj7);
        n.e(obj5, "firebaseFunctions\n            .getHttpsCallable(\"getTranslationHttpRequest\")\n            .call(data)\n            .continueWith { task: Task<HttpsCallableResult> ->\n                try {\n                    return@continueWith task.result!!.data.toString()\n                } catch (e: RuntimeExecutionException) {\n                    Timber.e(e)\n                    return@continueWith text\n                }\n            }");
        return obj5;
    }

    public final void o(String string) {
        String str = "userId";
        n.f(string, str);
        HashMap hashMap = new HashMap();
        hashMap.put(str, string);
        this.a.getHttpsCallable("resetRecapInformation").call(hashMap);
    }

    public final a0<RecommendedOrderedPrograms> p(String string, Map<String, String> map2) {
        String str = "dogId";
        n.f(string, str);
        final String str2 = "answers";
        n.f(map2, str2);
        o[] arr = new o[2];
        o oVar2 = new o(str, string);
        o oVar = new o(str2, map2);
        i0 i0Var = new i0(this, j0.k(oVar2, oVar), string);
        final a0 obj5 = a0.create(i0Var);
        n.e(obj5, "create { emitter: SingleEmitter<RecommendedOrderedPrograms> ->\n            firebaseFunctions\n                .getHttpsCallable(RECOMMENDED_PROGRAM_SUBMIT_FUNCTION)\n                .call(payload)\n                .addOnCompleteListener { task: Task<HttpsCallableResult> ->\n                    if (task.isSuccessful) {\n                        val response = task.result?.data\n                        if (response is Map<*, *>) {\n                            val gson = Gson()\n                            val jsonElement: JsonElement = gson.toJsonTree(response)\n                            val item: SurveyAnswerResponseModel = gson.fromJson(jsonElement, SurveyAnswerResponseModel::class.java)\n                            emitter.onSuccess(item.toRecommendedOrderedPrograms(dogId))\n                        } else {\n                            @Suppress(\"UnstableApiUsage\")\n                            emitter.tryOnError(Exception(\"unexpected results encountered\"))\n                        }\n                    } else {\n                        @Suppress(\"UnstableApiUsage\")\n                        emitter.tryOnError(task.exception!!)\n                    }\n                }\n        }");
        return obj5;
    }
}
