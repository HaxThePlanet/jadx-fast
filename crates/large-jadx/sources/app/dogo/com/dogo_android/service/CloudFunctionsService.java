package app.dogo.com.dogo_android.service;

import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedProgramsKt;
import com.google.android.gms.tasks.RuntimeExecutionException;
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
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.q;
import kotlin.u;
import kotlin.y.j0;

/* compiled from: CloudFunctionsService.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\u0008\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tJ\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nJ(\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000c2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "", "firebaseFunctions", "Lcom/google/firebase/functions/FirebaseFunctions;", "(Lcom/google/firebase/functions/FirebaseFunctions;)V", "checkIfEntryUpdateIsValid", "Lcom/google/android/gms/tasks/Task;", "Lapp/dogo/com/dogo_android/util/responses/EntryValidationResponse;", "payload", "", "", "requestCertificateProgram", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "programId", "dogId", "requestRecommendedProgram", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestTranslation", "text", "originalLanguage", "targetLanguage", "localePath", "resetRecapInformation", "", "userId", "submitRecommendedProgram", "answers", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i2, reason: from kotlin metadata */
public final class CloudFunctionsService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i2.a INSTANCE = new i2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseFunctions firebaseFunctions;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/service/CloudFunctionsService$Companion;", "", "()V", "CERTIFICATE_REQUEST_FUNCTION", "", "RECOMMENDED_PROGRAM_REQUEST_FUNCTION", "RECOMMENDED_PROGRAM_SUBMIT_FUNCTION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.service.CloudFunctionsService", f = "CloudFunctionsService.kt", l = 95, m = "requestRecommendedProgram")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super i2.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return i2.this.l(null, this);
        }
    }
    public i2(FirebaseFunctions firebaseFunctions) {
        n.f(firebaseFunctions, "firebaseFunctions");
        super();
        this.firebaseFunctions = firebaseFunctions;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final app.dogo.com.dogo_android.util.o0.a checkIfEntryUpdateIsValid(j payload) {
        n.f(payload, "task");
        Object result = payload.getResult();
        n.d(result);
        return new a(result.getData());
    }

    private static final void j(i2 i2Var, Map map, String str, c0 c0Var) {
        n.f(i2Var, "this$0");
        n.f(map, "$payload");
        n.f(str, "$programId");
        n.f(c0Var, "emitter");
        i2Var.firebaseFunctions.getHttpsCallable("certificates-generateProgramCertificateOnCall").call(map).addOnCompleteListener(new e0(c0Var, str));
    }

    private static final void k(c0 c0Var, String str, j jVar) {
        int i = 0;
        Object value;
        Object data;
        n.f(c0Var, "$emitter");
        n.f(str, "$programId");
        n.f(jVar, "task");
        if (jVar.isSuccessful()) {
            Object result = jVar.getResult();
            i = 0;
            if (result == null) {
            } else {
                data = result.getData();
            }
            z = data instanceof Map;
            if (data instanceof Map) {
                String r1 = data.get("certificateImageUrl") instanceof String ? (String)data.get("certificateImageUrl") : i;
                str = "";
                String r5 = value == null ? str : value;
                Object jVar32 = data.get("certificatePdfUrl");
                z = jVar32 instanceof String;
                if (jVar32 instanceof String) {
                }
                String r6 = i == 0 ? str : i;
                app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = null;
                int i2 = 8;
                g gVar = null;
                CertificateInfo jVar33 = new CertificateInfo(str, str, (i == 0 ? str : i), null, 8, null);
                c0Var.onSuccess(jVar33);
            } else {
                str3 = "unexpected results encountered";
                c0Var.a(new Exception(str3));
            }
        } else {
            Exception exception = jVar.getException();
            n.d(exception);
            c0Var.a(exception);
        }
    }

    /* renamed from: n, reason: from kotlin metadata */
    private static final String submitRecommendedProgram(String dogId, j answers) {
        n.f(dogId, "$text");
        n.f(answers, "task");
        try {
            Object result = answers.getResult();
            n.d(result);
        } catch (com.google.android.gms.tasks.RuntimeExecutionException runtimeExecution) {
            a.d(runtimeExecution);
            return dogId;
        }
        return String.valueOf(result.getData());
    }

    private static final void q(i2 i2Var, Map map, String str, c0 c0Var) {
        n.f(i2Var, "this$0");
        n.f(map, "$payload");
        n.f(str, "$dogId");
        n.f(c0Var, "emitter");
        i2Var.firebaseFunctions.getHttpsCallable("submitOnboardingSurveyAnswers").call(map).addOnCompleteListener(new f0(c0Var, str));
    }

    private static final void r(c0 c0Var, String str, j jVar) {
        Object data = null;
        n.f(c0Var, "$emitter");
        n.f(str, "$dogId");
        n.f(jVar, "task");
        if (jVar.isSuccessful()) {
            Object result = jVar.getResult();
            if (result == null) {
                int i = 0;
            } else {
                data = result.getData();
            }
            successful = data instanceof Map;
            if (data instanceof Map) {
                Gson gson = new Gson();
                com.google.gson.JsonElement jsonTree = gson.toJsonTree(data);
                n.e(jsonTree, "gson.toJsonTree(response)");
                obj = SurveyAnswerResponseModel.class;
                Object json = gson.fromJson(jsonTree, obj);
                n.e(json, "gson.fromJson(jsonElement, SurveyAnswerResponseModel::class.java)");
                c0Var.onSuccess(RecommendedOrderedProgramsKt.toRecommendedOrderedPrograms(json, str));
            } else {
                str = "unexpected results encountered";
                c0Var.a(new Exception(str));
            }
        } else {
            Exception exception = jVar.getException();
            n.d(exception);
            c0Var.a(exception);
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final j<app.dogo.com.dogo_android.util.o0.a> resetRecapInformation(Map<String, ? extends Object> userId) {
        j continueWith = this.firebaseFunctions.getHttpsCallable("challengeEntryUploadCallback").call(userId).continueWith(d0.a);
        n.e(continueWith, "firebaseFunctions\n            .getHttpsCallable(\"challengeEntryUploadCallback\")\n            .call(payload)\n            .continueWith { task: Task<HttpsCallableResult> -> EntryValidationResponse(task.result!!.data) }");
        return continueWith;
    }

    public final a0<CertificateInfo> i(String str, String str2) {
        String str3 = "programId";
        n.f(str, str3);
        String str4 = "dogId";
        n.f(str2, str4);
        o[] arr = new o[2];
        final a0 a0Var = a0.create(new h0(this, j0.k(new o[] { u.a(str4, str2), u.a(str3, str) }), str));
        n.e(a0Var, "create { emitter: SingleEmitter<CertificateInfo> ->\n            firebaseFunctions\n                .getHttpsCallable(CERTIFICATE_REQUEST_FUNCTION)\n                .call(payload)\n                .addOnCompleteListener { task: Task<HttpsCallableResult> ->\n                    if (task.isSuccessful) {\n                        val response = task.result?.data\n                        if (response is Map<*, *>) {\n                            val imageUrl = response[\"certificateImageUrl\"] as? String ?: \"\"\n                            val pdfUrl = response[\"certificatePdfUrl\"] as? String ?: \"\"\n                            emitter.onSuccess(\n                                CertificateInfo(\n                                    programId = programId,\n                                    certificateImageUrl = imageUrl,\n                                    certificatePdfUrl = pdfUrl\n                                )\n                            )\n                        } else {\n                            @Suppress(\"UnstableApiUsage\")\n                            emitter.tryOnError(Exception(\"unexpected results encountered\"))\n                        }\n                    } else {\n                        @Suppress(\"UnstableApiUsage\")\n                        emitter.tryOnError(task.exception!!)\n                    }\n                }\n        }");
        return a0Var;
    }

    public final Object l(String str, kotlin.b0.d<? super RecommendedOrderedPrograms> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        String str8;
        Object result2;
        z = dVar instanceof i2.b;
        if (dVar instanceof i2.b) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.service.i2.b bVar = new i2.b(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                Object data = (HttpsCallableResult)result2.getData();
                if (!(data instanceof Map)) {
                    throw new IllegalArgumentException(n.o("Received non map response :", data));
                } else {
                    Gson gson = new Gson();
                    com.google.gson.JsonElement jsonTree = gson.toJsonTree(data);
                    n.e(jsonTree, "gson.toJsonTree(response)");
                    Object json = gson.fromJson(jsonTree, SurveyAnswerResponseModel.class);
                    n.e(json, "gson.fromJson(jsonElement, SurveyAnswerResponseModel::class.java)");
                    return RecommendedOrderedProgramsKt.toRecommendedOrderedPrograms(json, str8);
                }
            }
        }
        q.b(dVar22.result);
        str2 = "getProgramRecommendations";
        j call = this.firebaseFunctions.getHttpsCallable(str2).call(j0.e(new Pair("dogId", str)));
        n.e(call, "firebaseFunctions\n            .getHttpsCallable(RECOMMENDED_PROGRAM_REQUEST_FUNCTION)\n            .call(payload)");
        dVar22.L$0 = str;
        dVar22.label = i3;
        if (a.a(call, dVar22) == obj) {
            return obj;
        }
    }

    public final j<String> m(String str, String str2, String str3, String str4) {
        String str5 = "text";
        n.f(str, str5);
        final String str7 = "targetLanguage";
        n.f(str3, str7);
        final String str8 = "localePath";
        n.f(str4, str8);
        final HashMap hashMap = new HashMap();
        hashMap.put(str5, str);
        hashMap.put("originalLanguage", str2);
        hashMap.put(str7, Locale.forLanguageTag(str3).getLanguage());
        hashMap.put(str8, str4);
        final j continueWith = this.firebaseFunctions.getHttpsCallable("getTranslationHttpRequest").call(hashMap).continueWith(new g0(str));
        n.e(continueWith, "firebaseFunctions\n            .getHttpsCallable(\"getTranslationHttpRequest\")\n            .call(data)\n            .continueWith { task: Task<HttpsCallableResult> ->\n                try {\n                    return@continueWith task.result!!.data.toString()\n                } catch (e: RuntimeExecutionException) {\n                    Timber.e(e)\n                    return@continueWith text\n                }\n            }");
        return continueWith;
    }

    public final void o(String str) {
        String str2 = "userId";
        n.f(str, str2);
        final HashMap hashMap = new HashMap();
        hashMap.put(str2, str);
        this.firebaseFunctions.getHttpsCallable("resetRecapInformation").call(hashMap);
    }

    public final a0<RecommendedOrderedPrograms> p(String str, Map<String, String> map) {
        String str2 = "dogId";
        n.f(str, str2);
        final String str3 = "answers";
        n.f(map, str3);
        o[] arr = new o[2];
        final a0 a0Var = a0.create(new i0(this, j0.k(new o[] { new Pair(str2, str), new Pair(str3, map) }), str));
        n.e(a0Var, "create { emitter: SingleEmitter<RecommendedOrderedPrograms> ->\n            firebaseFunctions\n                .getHttpsCallable(RECOMMENDED_PROGRAM_SUBMIT_FUNCTION)\n                .call(payload)\n                .addOnCompleteListener { task: Task<HttpsCallableResult> ->\n                    if (task.isSuccessful) {\n                        val response = task.result?.data\n                        if (response is Map<*, *>) {\n                            val gson = Gson()\n                            val jsonElement: JsonElement = gson.toJsonTree(response)\n                            val item: SurveyAnswerResponseModel = gson.fromJson(jsonElement, SurveyAnswerResponseModel::class.java)\n                            emitter.onSuccess(item.toRecommendedOrderedPrograms(dogId))\n                        } else {\n                            @Suppress(\"UnstableApiUsage\")\n                            emitter.tryOnError(Exception(\"unexpected results encountered\"))\n                        }\n                    } else {\n                        @Suppress(\"UnstableApiUsage\")\n                        emitter.tryOnError(task.exception!!)\n                    }\n                }\n        }");
        return a0Var;
    }


    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ public static /* synthetic */ app.dogo.com.dogo_android.util.o0.a requestRecommendedProgram(j dogId) {
        return CloudFunctionsService.checkIfEntryUpdateIsValid(dogId);
    }

    public static /* synthetic */ void d(c0 c0Var, String str, j jVar) {
        CloudFunctionsService.k(c0Var, str, jVar);
    }

    public static /* synthetic */ void e(c0 c0Var, String str, j jVar) {
        CloudFunctionsService.r(c0Var, str, jVar);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static /* synthetic */ String requestCertificateProgram(String programId, j dogId) {
        return CloudFunctionsService.submitRecommendedProgram(programId, dogId);
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static /* synthetic */ void requestTranslation(i2 text, Map originalLanguage, String targetLanguage, c0 localePath) {
        CloudFunctionsService.j(text, originalLanguage, targetLanguage, localePath);
    }

    public static /* synthetic */ void h(i2 i2Var, Map map, String str, c0 c0Var) {
        CloudFunctionsService.q(i2Var, map, str, c0Var);
    }
}
