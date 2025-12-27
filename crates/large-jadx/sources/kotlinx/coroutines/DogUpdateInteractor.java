package app.dogo.com.dogo_android.s.a;

import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.externalmodel.model.requests.DogUpdateRequest;
import app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData;
import app.dogo.externalmodel.model.responses.DogUpdateResponse;
import app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DogUpdateInteractor.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u001d\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u001f\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J#\u0010'\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010(\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "clearProperty", "Lapp/dogo/externalmodel/model/responses/DogUpdateResponse;", "dogId", "", "propertyName", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor$DogWritableProperties;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor$DogWritableProperties;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAvatarUrl", "", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBirthday", "birthday", "isExact", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBreedId", "breedId", "updateCustomBreed", "customBreed", "updateGender", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/enums/DogGender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalUserData", "dogApiModel", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "(Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateName", "name", "DogWritableProperties", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g2, reason: from kotlin metadata */
public final class DogUpdateInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final DogoApiClient authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final u2 dispatcher;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 dogoApiClient;
    /* renamed from: d, reason: from kotlin metadata */
    private final h0 userLocalCacheService;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor$DogWritableProperties;", "", "fieldName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFieldName", "()Ljava/lang/String;", "NAME", "BREED_ID", "CUSTOM_BREED", "BIRTHDAY", "BIRTHDAY_EXACT", "GENDER", "AVATAR_URL", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum a {

        AVATAR_URL,
        BIRTHDAY,
        BIRTHDAY_EXACT,
        BREED_ID,
        CUSTOM_BREED,
        GENDER,
        NAME;

        private final String fieldName;
        @Override // java.lang.Enum
        public final String getFieldName() {
            return this.fieldName;
        }

        private static final /* synthetic */ g2.a[] $values() {
            app.dogo.com.dogo_android.s.a.g2.a[] arr = new g2.a[7];
            return new g2.a[] { DogUpdateInteractor_DogWritableProperties.NAME, DogUpdateInteractor_DogWritableProperties.BREED_ID, DogUpdateInteractor_DogWritableProperties.CUSTOM_BREED, DogUpdateInteractor_DogWritableProperties.BIRTHDAY, DogUpdateInteractor_DogWritableProperties.BIRTHDAY_EXACT, DogUpdateInteractor_DogWritableProperties.GENDER, DogUpdateInteractor_DogWritableProperties.AVATAR_URL };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {90, 92, 101}, m = "updateAvatarUrl")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super g2.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return g2.this.d(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {56, 57, 59, 69}, m = "updateBirthday")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super g2.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return g2.this.e(str, str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {22, 24, 25, 34}, m = "updateBreedId")
    static final class d extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super g2.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return g2.this.g(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {39, 41, 42, 51}, m = "updateCustomBreed")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super g2.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return g2.this.h(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {74, 76, 85}, m = "updateGender")
    static final class f extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        f(kotlin.b0.d<? super g2.f> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return g2.this.i(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {106, 108, 117}, m = "updateName")
    static final class h extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        h(kotlin.b0.d<? super g2.h> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return g2.this.k(str, str, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor$updateLocalUserData$2", f = "DogUpdateInteractor.kt", l = {}, m = "invokeSuspend")
    static final class g extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ UserApiModel.DogApiModel $dogApiModel;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                g2.this.dispatcher.a0(g2.this.dogoApiClient.v(), this.$dogApiModel).e();
                return w.a;
            }
        }

        g(UserApiModel.DogApiModel dogApiModel, kotlin.b0.d<? super g2.g> dVar) {
            this.$dogApiModel = dogApiModel;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.g2.g)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.g2.g(g2.this, this.$dogApiModel, dVar);
        }
    }
    public g2(DogoApiClient dogoApiClient, u2 u2Var, h2 h2Var, h0 h0Var) {
        n.f(dogoApiClient, "dogoApiClient");
        n.f(u2Var, "userLocalCacheService");
        n.f(h2Var, "authService");
        n.f(h0Var, "dispatcher");
        super();
        this.authService = dogoApiClient;
        this.dispatcher = u2Var;
        this.dogoApiClient = h2Var;
        this.userLocalCacheService = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ h2 updateLocalUserData(g2 dogApiModel) {
        return dogApiModel.dogoApiClient;
    }

    public static final /* synthetic */ u2 b(g2 g2Var) {
        return g2Var.dispatcher;
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ private final Object updateBirthday(String dogId, g2.a birthday, kotlin.b0.d<? super DogUpdateResponse> isExact) {
        return this.authService.clearDogProperty(dogId, birthday.getFieldName(), isExact);
    }

    public static /* synthetic */ Object f(g2 g2Var, String str, String str2, Boolean boolean, kotlin.b0.d dVar, int i, Object object) {
        Boolean bool = null;
        if (i & 4 != 0) {
            i = 0;
        }
        return g2Var.e(str, str2, bool, dVar);
    }

    /* renamed from: j, reason: from kotlin metadata */
    /* suspend */ private final Object clearProperty(UserApiModel.DogApiModel dogId, kotlin.b0.d<? super w> propertyName) {
        Object obj = kotlinx.coroutines.internal.k.e(this.userLocalCacheService, new kotlinx.coroutines.g2.g(this, dogId, null), propertyName);
        if (obj == b.d()) {
            return obj;
        }
        return w.a;
    }

    public final Object d(String str, String str2, kotlin.b0.d<? super w> dVar) {
        app.dogo.com.dogo_android.s.a.g2 g2Var;
        Object dogData;
        Object dVar32;
        int label2;
        int i = -2147483648;
        DogUpdateRequest dogUpdateRequest;
        int i2;
        DogUpdateRequest.WritableDogData dogUpdateRequest_WritableDogData;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        String str8 = null;
        String str22;
        int i3 = 63;
        g gVar = null;
        g2Var = this;
        String str3 = str;
        dVar32 = dVar;
        z = dVar32 instanceof kotlinx.coroutines.g2.b;
        if (dVar32 instanceof kotlinx.coroutines.g2.b) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.g2.b bVar = new kotlinx.coroutines.g2.b(g2Var, dVar32);
            }
        }
        Object obj = b.d();
        final int i6 = 2;
        int i7 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i7) {
                if (dVar32.label != i6) {
                    if (dVar32.label != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar32.result);
                        return w.a;
                    }
                }
                q.b(dVar32.result);
            } else {
                q.b(dVar32.result);
            }
        } else {
            q.b(dVar32.result);
            if (str2 == null) {
                dVar32.L$0 = g2Var;
                dVar32.label = i7;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.AVATAR_URL, dVar32) == obj) {
                    return obj;
                }
            } else {
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                bool = null;
                str8 = null;
                i3 = 63;
                gVar = null;
                dogUpdateRequest_WritableDogData = new DogUpdateRequest_WritableDogData(str4, str5, str6, str7, bool, str8, str2, i3, gVar);
                dVar32.L$0 = g2Var;
                dVar32.label = i6;
                if (g2Var.authService.updateDogData(str3, new DogUpdateRequest(dogUpdateRequest_WritableDogData), dVar32) == obj) {
                    return obj;
                }
            }
        }
        dVar32.L$0 = null;
        int label22 = 3;
        dVar32.label = label22;
        if (g2Var.clearProperty(dogData.getDog(), dVar32) == obj) {
            return obj;
        }
    }

    public final Object e(String str, String str2, Boolean boolean, kotlin.b0.d<? super w> dVar) {
        Object obj;
        String str9;
        Object dogData;
        Object dVar42;
        int label2;
        int i = -2147483648;
        int label22;
        int i2;
        int i3 = 2;
        int i4 = 1;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str22;
        Boolean boolean32;
        String str7 = null;
        String str8 = null;
        int i5 = 103;
        g gVar = null;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str3 = str;
        dVar42 = dVar;
        z = dVar42 instanceof kotlinx.coroutines.g2.c;
        if (dVar42 instanceof kotlinx.coroutines.g2.c) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar42.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.g2.c cVar = new kotlinx.coroutines.g2.c(g2Var, dVar42);
            }
        }
        Object obj2 = b.d();
        Object obj3 = null;
        final int i6 = 4;
        final int i7 = 3;
        i3 = 2;
        i4 = 1;
        if (dVar42.label != 0) {
            if (dVar42.label != i4) {
                if (dVar42.label != i3) {
                    if (dVar42.label != i7) {
                        if (dVar42.label != i6) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar42.result);
                            return w.a;
                        }
                    }
                    q.b(dVar42.result);
                } else {
                    q.b(dVar42.result);
                }
            } else {
                q.b(dVar42.result);
                dVar42.L$0 = obj;
                dVar42.L$1 = obj3;
                dVar42.label = i3;
                if (obj.updateBirthday(str9, DogUpdateInteractor_DogWritableProperties.BIRTHDAY_EXACT, dVar42) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(dVar42.result);
            if (str2 == null) {
                dVar42.L$0 = g2Var;
                dVar42.L$1 = str3;
                dVar42.label = i4;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.BIRTHDAY, dVar42) == obj2) {
                    return obj2;
                }
            } else {
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                i5 = 103;
                gVar = null;
                DogUpdateRequest_WritableDogData dogUpdateRequest_WritableDogData = new DogUpdateRequest_WritableDogData(str4, str5, str6, str2, boolean, str7, str8, i5, gVar);
                dVar42.L$0 = g2Var;
                dVar42.label = i7;
                if (g2Var.authService.updateDogData(str3, new DogUpdateRequest(dogUpdateRequest_WritableDogData), dVar42) == obj2) {
                    return obj2;
                }
            }
        }
        dVar42.L$0 = obj3;
        dVar42.label = i6;
        if (obj.clearProperty(dogData.getDog(), dVar42) == obj2) {
            return obj2;
        }
    }

    public final Object g(String str, String str2, kotlin.b0.d<? super w> dVar) {
        String str3;
        Object obj;
        DogoApiClient authService2;
        app.dogo.com.dogo_android.s.a.g2.a bREED_ID2;
        Object dogData;
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        DogUpdateRequest.WritableDogData dogUpdateRequest_WritableDogData;
        String str4 = null;
        String str5;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        String str8 = null;
        String str9 = null;
        int i4 = 125;
        g gVar = null;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str3 = str;
        str22 = str2;
        dVar32 = dVar;
        z = dVar32 instanceof kotlinx.coroutines.g2.d;
        if (dVar32 instanceof kotlinx.coroutines.g2.d) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                dVar = new kotlinx.coroutines.g2.d(g2Var, dVar32);
            }
        }
        Object obj3 = b.d();
        int i5 = 4;
        final int i6 = 3;
        int i3 = 2;
        final int i7 = 1;
        final Object obj4 = null;
        if (dVar32.label != 0) {
            if (dVar32.label != i7) {
                if (dVar32.label != i3) {
                    if (dVar32.label != i6) {
                        if (dVar32.label != i5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    str4 = null;
                    str6 = null;
                    str7 = null;
                    bool = null;
                    str8 = null;
                    str9 = null;
                    i4 = 125;
                    gVar = null;
                    dogUpdateRequest_WritableDogData = new DogUpdateRequest_WritableDogData(str4, str5, str6, str7, bool, str8, str9, i4, gVar);
                    dVar32.L$0 = obj;
                    dVar32.L$1 = obj4;
                    dVar32.L$2 = obj4;
                    dVar32.label = i6;
                    if (obj.authService.updateDogData(str3, new DogUpdateRequest(dogUpdateRequest_WritableDogData), dVar32) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(dVar32.result);
            }
        } else {
            q.b(dVar32.result);
            if (obj.authService == null) {
                dVar32.L$0 = g2Var;
                dVar32.label = i7;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.BREED_ID, dVar32) == obj3) {
                    return obj3;
                }
            } else {
                dVar32.L$0 = g2Var;
                dVar32.L$1 = str3;
                dVar32.L$2 = str22;
                dVar32.label = i3;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.CUSTOM_BREED, dVar32) == obj3) {
                    return obj3;
                }
            }
        }
        dVar32.L$0 = obj4;
        dVar32.label = i5;
        if (obj.clearProperty(dogData.getDog(), dVar32) == obj3) {
            return obj3;
        }
    }

    public final Object h(String str, String str2, kotlin.b0.d<? super w> dVar) {
        String str3;
        Object obj;
        DogoApiClient authService2;
        app.dogo.com.dogo_android.s.a.g2.a cUSTOM_BREED2;
        Object dogData;
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        DogUpdateRequest.WritableDogData dogUpdateRequest_WritableDogData;
        String str4 = null;
        String str5 = null;
        String str6;
        String str7 = null;
        Boolean bool = null;
        String str8 = null;
        String str9 = null;
        int i4 = 123;
        g gVar = null;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str3 = str;
        str22 = str2;
        dVar32 = dVar;
        z = dVar32 instanceof kotlinx.coroutines.g2.e;
        if (dVar32 instanceof kotlinx.coroutines.g2.e) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.g2.e eVar = new kotlinx.coroutines.g2.e(g2Var, dVar32);
            }
        }
        Object obj3 = b.d();
        int i5 = 4;
        final int i6 = 3;
        int i3 = 2;
        final int i7 = 1;
        final Object obj4 = null;
        if (dVar32.label != 0) {
            if (dVar32.label != i7) {
                if (dVar32.label != i3) {
                    if (dVar32.label != i6) {
                        if (dVar32.label != i5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    str4 = null;
                    str5 = null;
                    str7 = null;
                    bool = null;
                    str8 = null;
                    str9 = null;
                    i4 = 123;
                    gVar = null;
                    dogUpdateRequest_WritableDogData = new DogUpdateRequest_WritableDogData(str4, str5, str6, str7, bool, str8, str9, i4, gVar);
                    dVar32.L$0 = obj;
                    dVar32.L$1 = obj4;
                    dVar32.L$2 = obj4;
                    dVar32.label = i6;
                    if (obj.authService.updateDogData(str3, new DogUpdateRequest(dogUpdateRequest_WritableDogData), dVar32) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(dVar32.result);
            }
        } else {
            q.b(dVar32.result);
            if (obj.authService == null) {
                dVar32.L$0 = g2Var;
                dVar32.label = i7;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.CUSTOM_BREED, dVar32) == obj3) {
                    return obj3;
                }
            } else {
                dVar32.L$0 = g2Var;
                dVar32.L$1 = str3;
                dVar32.L$2 = str22;
                dVar32.label = i3;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.BREED_ID, dVar32) == obj3) {
                    return obj3;
                }
            }
        }
        dVar32.L$0 = obj4;
        dVar32.label = i5;
        if (obj.clearProperty(dogData.getDog(), dVar32) == obj3) {
            return obj3;
        }
    }

    public final Object i(String str, app.dogo.com.dogo_android.k.d dVar, kotlin.b0.d<? super w> dVar2) {
        app.dogo.com.dogo_android.s.a.g2 g2Var;
        Object dogData;
        Object dVar32;
        int label2;
        int i = -2147483648;
        DogUpdateRequest dogUpdateRequest;
        int i2;
        DogUpdateRequest.WritableDogData dogUpdateRequest_WritableDogData;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Boolean bool = null;
        String trackTag;
        int i3;
        int i4;
        g gVar;
        int i5 = 0;
        g2Var = this;
        String str2 = str;
        dVar32 = dVar2;
        z = dVar32 instanceof kotlinx.coroutines.g2.f;
        if (dVar32 instanceof kotlinx.coroutines.g2.f) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.g2.f fVar = new kotlinx.coroutines.g2.f(g2Var, dVar32);
            }
        }
        Object obj = b.d();
        final int i8 = 2;
        int i9 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i9) {
                if (dVar32.label != i8) {
                    if (dVar32.label != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar32.result);
                        return w.a;
                    }
                }
                q.b(dVar32.result);
            } else {
                q.b(dVar32.result);
            }
        } else {
            q.b(dVar32.result);
            if (dVar == null) {
                dVar32.L$0 = g2Var;
                dVar32.label = i9;
                if (g2Var.updateBirthday(str2, DogUpdateInteractor_DogWritableProperties.GENDER, dVar32) == obj) {
                    return obj;
                }
            } else {
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                bool = null;
                i5 = 0;
                dogUpdateRequest_WritableDogData = new DogUpdateRequest_WritableDogData(str3, str4, str5, str6, bool, dVar.getTrackTag(), null, 95, i5);
                dVar32.L$0 = g2Var;
                dVar32.label = i8;
                if (g2Var.authService.updateDogData(str2, new DogUpdateRequest(dogUpdateRequest_WritableDogData), dVar32) == obj) {
                    return obj;
                }
            }
        }
        dVar32.L$0 = null;
        int label22 = 3;
        dVar32.label = label22;
        if (g2Var.clearProperty(dogData.getDog(), dVar32) == obj) {
            return obj;
        }
    }

    public final Object k(String str, String str2, kotlin.b0.d<? super w> dVar) {
        app.dogo.com.dogo_android.s.a.g2 g2Var;
        Object dogData;
        Object dVar32;
        int label2;
        int i = -2147483648;
        DogUpdateRequest dogUpdateRequest;
        int i2;
        DogUpdateRequest.WritableDogData dogUpdateRequest_WritableDogData;
        String str22;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Boolean bool = null;
        String str7 = null;
        int i3;
        int i4;
        g gVar;
        int i5 = 0;
        g2Var = this;
        String str3 = str;
        dVar32 = dVar;
        z = dVar32 instanceof kotlinx.coroutines.g2.h;
        if (dVar32 instanceof kotlinx.coroutines.g2.h) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.g2.h hVar = new kotlinx.coroutines.g2.h(g2Var, dVar32);
            }
        }
        Object obj = b.d();
        final int i8 = 2;
        int i9 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i9) {
                if (dVar32.label != i8) {
                    if (dVar32.label != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar32.result);
                        return w.a;
                    }
                }
                q.b(dVar32.result);
            } else {
                q.b(dVar32.result);
            }
        } else {
            q.b(dVar32.result);
            if (str2 == null) {
                dVar32.L$0 = g2Var;
                dVar32.label = i9;
                if (g2Var.updateBirthday(str3, DogUpdateInteractor_DogWritableProperties.NAME, dVar32) == obj) {
                    return obj;
                }
            } else {
                str4 = null;
                str5 = null;
                str6 = null;
                bool = null;
                str7 = null;
                i5 = 0;
                dogUpdateRequest_WritableDogData = new DogUpdateRequest_WritableDogData(str2, str4, str5, str6, bool, str7, null, 126, i5);
                dVar32.L$0 = g2Var;
                dVar32.label = i8;
                if (g2Var.authService.updateDogData(str3, new DogUpdateRequest(dogUpdateRequest_WritableDogData), dVar32) == obj) {
                    return obj;
                }
            }
        }
        dVar32.L$0 = null;
        int label22 = 3;
        dVar32.label = label22;
        if (g2Var.clearProperty(dogData.getDog(), dVar32) == obj) {
            return obj;
        }
    }

    public /* synthetic */ g2(DogoApiClient dogoApiClient, u2 u2Var, h2 h2Var, h0 h0Var, int i, g gVar) {
        if (i & 8 != 0) {
            h0Var = Dispatchers.b();
        }
        this(dogoApiClient, u2Var, h2Var, h0Var);
    }
}
