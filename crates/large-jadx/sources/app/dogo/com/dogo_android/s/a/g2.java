package app.dogo.com.dogo_android.s.a;

import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.externalmodel.model.requests.DogUpdateRequest;
import app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData;
import app.dogo.externalmodel.model.responses.DogUpdateResponse;
import app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel;
import i.b.b;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u001d\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u001f\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J#\u0010'\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010(\u001a\u0004\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "clearProperty", "Lapp/dogo/externalmodel/model/responses/DogUpdateResponse;", "dogId", "", "propertyName", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor$DogWritableProperties;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor$DogWritableProperties;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAvatarUrl", "", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBirthday", "birthday", "isExact", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBreedId", "breedId", "updateCustomBreed", "customBreed", "updateGender", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/enums/DogGender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalUserData", "dogApiModel", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "(Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateName", "name", "DogWritableProperties", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g2 {

    private final DogoApiClient a;
    private final u2 b;
    private final h2 c;
    private final h0 d;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor$DogWritableProperties;", "", "fieldName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFieldName", "()Ljava/lang/String;", "NAME", "BREED_ID", "CUSTOM_BREED", "BIRTHDAY", "BIRTHDAY_EXACT", "GENDER", "AVATAR_URL", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static enum a {

        NAME("name"),
        BREED_ID("name"),
        CUSTOM_BREED("name"),
        BIRTHDAY("name"),
        BIRTHDAY_EXACT("name"),
        GENDER("name"),
        AVATAR_URL("name");

        private final String fieldName;
        private static final app.dogo.com.dogo_android.s.a.g2.a[] $values() {
            app.dogo.com.dogo_android.s.a.g2.a[] arr = new g2.a[7];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getFieldName() {
            return this.fieldName;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {90, 92, 101}, m = "updateAvatarUrl")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        b(app.dogo.com.dogo_android.s.a.g2 g2, d<? super app.dogo.com.dogo_android.s.a.g2.b> d2) {
            this.this$0 = g2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.d(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {56, 57, 59, 69}, m = "updateBirthday")
    static final class c extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        c(app.dogo.com.dogo_android.s.a.g2 g2, d<? super app.dogo.com.dogo_android.s.a.g2.c> d2) {
            this.this$0 = g2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.e(i2, i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {22, 24, 25, 34}, m = "updateBreedId")
    static final class d extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        d(app.dogo.com.dogo_android.s.a.g2 g2, d<? super app.dogo.com.dogo_android.s.a.g2.d> d2) {
            this.this$0 = g2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.g(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {39, 41, 42, 51}, m = "updateCustomBreed")
    static final class e extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        e(app.dogo.com.dogo_android.s.a.g2 g2, d<? super app.dogo.com.dogo_android.s.a.g2.e> d2) {
            this.this$0 = g2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.h(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {74, 76, 85}, m = "updateGender")
    static final class f extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        f(app.dogo.com.dogo_android.s.a.g2 g2, d<? super app.dogo.com.dogo_android.s.a.g2.f> d2) {
            this.this$0 = g2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.i(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor", f = "DogUpdateInteractor.kt", l = {106, 108, 117}, m = "updateName")
    static final class h extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        h(app.dogo.com.dogo_android.s.a.g2 g2, d<? super app.dogo.com.dogo_android.s.a.g2.h> d2) {
            this.this$0 = g2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.k(i2, i2, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogUpdateInteractor$updateLocalUserData$2", f = "DogUpdateInteractor.kt", l = {}, m = "invokeSuspend")
    static final class g extends k implements p<m0, d<? super w>, Object> {

        final UserApiModel.DogApiModel $dogApiModel;
        int label;
        final app.dogo.com.dogo_android.s.a.g2 this$0;
        g(app.dogo.com.dogo_android.s.a.g2 g2, UserApiModel.DogApiModel userApiModel$DogApiModel2, d<? super app.dogo.com.dogo_android.s.a.g2.g> d3) {
            this.this$0 = g2;
            this.$dogApiModel = dogApiModel2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g2.g)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g2.g obj3 = new g2.g(this.this$0, this.$dogApiModel, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                g2.b(this.this$0).a0(g2.a(this.this$0).v(), this.$dogApiModel).e();
                return w.a;
            }
            IllegalStateException obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj3;
        }
    }
    public g2(DogoApiClient dogoApiClient, u2 u22, h2 h23, h0 h04) {
        n.f(dogoApiClient, "dogoApiClient");
        n.f(u22, "userLocalCacheService");
        n.f(h23, "authService");
        n.f(h04, "dispatcher");
        super();
        this.a = dogoApiClient;
        this.b = u22;
        this.c = h23;
        this.d = h04;
    }

    public g2(DogoApiClient dogoApiClient, u2 u22, h2 h23, h0 h04, int i5, g g6) {
        h0 obj4;
        if (i5 &= 8 != 0) {
            obj4 = c1.b();
        }
        super(dogoApiClient, u22, h23, obj4);
    }

    public static final h2 a(app.dogo.com.dogo_android.s.a.g2 g2) {
        return g2.c;
    }

    public static final u2 b(app.dogo.com.dogo_android.s.a.g2 g2) {
        return g2.b;
    }

    private final Object c(String string, app.dogo.com.dogo_android.s.a.g2.a g2$a2, d<? super DogUpdateResponse> d3) {
        return this.a.clearDogProperty(string, a2.getFieldName(), d3);
    }

    public static Object f(app.dogo.com.dogo_android.s.a.g2 g2, String string2, String string3, Boolean boolean4, d d5, int i6, Object object7) {
        int obj3;
        if (i6 &= 4 != 0) {
            obj3 = 0;
        }
        return g2.e(string2, string3, obj3, d5);
    }

    private final Object j(UserApiModel.DogApiModel userApiModel$DogApiModel, d<? super w> d2) {
        g2.g gVar = new g2.g(this, dogApiModel, 0);
        Object obj4 = k.e(this.d, gVar, d2);
        if (obj4 == b.d()) {
            return obj4;
        }
        return w.a;
    }

    public final Object d(String string, String string2, d<? super w> d3) {
        Object l$0;
        Object str;
        Object dogData;
        boolean bVar;
        int label;
        int i5;
        DogUpdateRequest dogUpdateRequest;
        int i11;
        DogUpdateRequest.WritableDogData i6;
        DogUpdateRequest.WritableDogData i2;
        int i7;
        int i8;
        int i3;
        int i9;
        int i10;
        int i4;
        String str2;
        int i;
        int i12;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str = string;
        Object obj = d3;
        bVar = obj;
        label = bVar.label;
        i5 = Integer.MIN_VALUE;
        if (obj instanceof g2.b && label & i5 != 0) {
            bVar = obj;
            label = bVar.label;
            i5 = Integer.MIN_VALUE;
            if (label & i5 != 0) {
                bVar.label = label -= i5;
            } else {
                bVar = new g2.b(g2Var, obj);
            }
        } else {
        }
        dogData = bVar.result;
        Object obj2 = b.d();
        dogUpdateRequest = bVar.label;
        final int i14 = 2;
        i2 = 1;
        if (dogUpdateRequest != null) {
            if (dogUpdateRequest != i2) {
                if (dogUpdateRequest != i14) {
                    if (dogUpdateRequest != 3) {
                    } else {
                        q.b(dogData);
                        return w.a;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                l$0 = bVar.L$0;
                q.b(dogData);
            } else {
                l$0 = bVar.L$0;
                q.b(dogData);
            }
        } else {
            q.b(dogData);
            if (string2 == null) {
                bVar.L$0 = g2Var;
                bVar.label = i2;
                if (g2Var.c(str, g2.a.AVATAR_URL, bVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            } else {
                super(0, 0, 0, 0, 0, 0, string2, 63, 0);
                dogUpdateRequest = new DogUpdateRequest(writableDogData);
                bVar.L$0 = g2Var;
                bVar.label = i14;
                if (g2Var.a.updateDogData(str, dogUpdateRequest, bVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            }
        }
        bVar.L$0 = 0;
        bVar.label = 3;
        if (l$0.j(dogData.getDog(), bVar) == obj2) {
            return obj2;
        }
    }

    public final Object e(String string, String string2, Boolean boolean3, d<? super w> d4) {
        Object l$0;
        Object l$1;
        Object dogData;
        boolean cVar;
        int label;
        int i9;
        int dogUpdateRequest;
        int i;
        int writableDogData;
        int i5;
        int i4;
        int i3;
        int i6;
        String str;
        Boolean bool;
        int i2;
        int i10;
        int i7;
        int i8;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        l$1 = string;
        Object obj = d4;
        cVar = obj;
        label = cVar.label;
        i9 = Integer.MIN_VALUE;
        if (obj instanceof g2.c && label & i9 != 0) {
            cVar = obj;
            label = cVar.label;
            i9 = Integer.MIN_VALUE;
            if (label & i9 != 0) {
                cVar.label = label -= i9;
            } else {
                cVar = new g2.c(g2Var, obj);
            }
        } else {
        }
        dogData = cVar.result;
        Object obj2 = b.d();
        dogUpdateRequest = cVar.label;
        int i11 = 0;
        final int i12 = 4;
        final int i13 = 3;
        writableDogData = 2;
        i5 = 1;
        if (dogUpdateRequest != null) {
            if (dogUpdateRequest != i5) {
                if (dogUpdateRequest != writableDogData) {
                    if (dogUpdateRequest != i13) {
                        if (dogUpdateRequest != i12) {
                        } else {
                            q.b(dogData);
                            return w.a;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    l$0 = cVar.L$0;
                    q.b(dogData);
                } else {
                    l$0 = cVar.L$0;
                    q.b(dogData);
                }
            } else {
                l$1 = cVar.L$1;
                dogUpdateRequest = cVar.L$0;
                q.b(dogData);
                cVar.L$0 = dogUpdateRequest;
                cVar.L$1 = i11;
                cVar.label = writableDogData;
                if (dogUpdateRequest.c(l$1, g2.a.BIRTHDAY_EXACT, cVar) == obj2) {
                    return obj2;
                }
                l$0 = dogUpdateRequest;
            }
        } else {
            q.b(dogData);
            if (string2 == null) {
                cVar.L$0 = g2Var;
                cVar.L$1 = l$1;
                cVar.label = i5;
                if (g2Var.c(l$1, g2.a.BIRTHDAY, cVar) == obj2) {
                    return obj2;
                }
                dogUpdateRequest = g2Var;
            } else {
                super(0, 0, 0, string2, boolean3, 0, 0, 103, 0);
                dogUpdateRequest = new DogUpdateRequest(writableDogData);
                cVar.L$0 = g2Var;
                cVar.label = i13;
                if (g2Var.a.updateDogData(l$1, dogUpdateRequest, cVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            }
        }
        cVar.L$0 = i11;
        cVar.label = i12;
        if (l$0.j(dogData.getDog(), cVar) == obj2) {
            return obj2;
        }
    }

    public final Object g(String string, String string2, d<? super w> d3) {
        Object str;
        Object l$0;
        Object bREED_ID;
        Object dogData;
        boolean dVar;
        int label;
        int i6;
        Object label2;
        int i4;
        DogUpdateRequest.WritableDogData writableDogData;
        DogUpdateRequest.WritableDogData request;
        int i;
        Object obj;
        int i9;
        int i2;
        int i7;
        int i10;
        int i3;
        int i8;
        int i5;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str = string;
        bREED_ID = string2;
        Object obj2 = d3;
        dVar = obj2;
        label = dVar.label;
        i6 = Integer.MIN_VALUE;
        if (obj2 instanceof g2.d && label & i6 != 0) {
            dVar = obj2;
            label = dVar.label;
            i6 = Integer.MIN_VALUE;
            if (label & i6 != 0) {
                dVar.label = label -= i6;
            } else {
                dVar = new g2.d(g2Var, obj2);
            }
        } else {
        }
        dogData = dVar.result;
        Object obj3 = b.d();
        label2 = dVar.label;
        int i11 = 4;
        final int i12 = 3;
        writableDogData = 2;
        final int i13 = 1;
        final int i14 = 0;
        if (label2 != 0) {
            if (label2 != i13) {
                if (label2 != writableDogData) {
                    if (label2 != i12) {
                        if (label2 != i11) {
                        } else {
                            q.b(dogData);
                            return w.a;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    l$0 = dVar.L$0;
                    q.b(dogData);
                } else {
                    label2 = dVar.L$0;
                    q.b(dogData);
                    obj = l$2;
                    str = bREED_ID;
                    super(0, obj, 0, 0, 0, 0, 0, 125, 0);
                    DogUpdateRequest dogUpdateRequest = new DogUpdateRequest(writableDogData);
                    dVar.L$0 = label2;
                    dVar.L$1 = i14;
                    dVar.L$2 = i14;
                    dVar.label = i12;
                    if (label2.a.updateDogData(str, dogUpdateRequest, dVar) == obj3) {
                        return obj3;
                    }
                    l$0 = label2;
                }
            } else {
                l$0 = dVar.L$0;
                q.b(dogData);
            }
        } else {
            q.b(dogData);
            if (bREED_ID == null) {
                dVar.L$0 = g2Var;
                dVar.label = i13;
                if (g2Var.c(str, g2.a.BREED_ID, dVar) == obj3) {
                    return obj3;
                }
                l$0 = g2Var;
            } else {
                dVar.L$0 = g2Var;
                dVar.L$1 = str;
                dVar.L$2 = bREED_ID;
                dVar.label = writableDogData;
                if (g2Var.c(str, g2.a.CUSTOM_BREED, dVar) == obj3) {
                    return obj3;
                }
                label2 = g2Var;
                obj = bREED_ID;
            }
        }
        dVar.L$0 = i14;
        dVar.label = i11;
        if (l$0.j(dogData.getDog(), dVar) == obj3) {
            return obj3;
        }
    }

    public final Object h(String string, String string2, d<? super w> d3) {
        Object str;
        Object l$0;
        Object cUSTOM_BREED;
        Object dogData;
        boolean eVar;
        int label2;
        int i9;
        Object label;
        int i3;
        DogUpdateRequest.WritableDogData writableDogData;
        DogUpdateRequest.WritableDogData request;
        int i6;
        int i7;
        Object obj;
        int i2;
        int i8;
        int i4;
        int i10;
        int i5;
        int i;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str = string;
        cUSTOM_BREED = string2;
        Object obj2 = d3;
        eVar = obj2;
        label2 = eVar.label;
        i9 = Integer.MIN_VALUE;
        if (obj2 instanceof g2.e && label2 & i9 != 0) {
            eVar = obj2;
            label2 = eVar.label;
            i9 = Integer.MIN_VALUE;
            if (label2 & i9 != 0) {
                eVar.label = label2 -= i9;
            } else {
                eVar = new g2.e(g2Var, obj2);
            }
        } else {
        }
        dogData = eVar.result;
        Object obj3 = b.d();
        label = eVar.label;
        int i11 = 4;
        final int i12 = 3;
        writableDogData = 2;
        final int i13 = 1;
        final int i14 = 0;
        if (label != 0) {
            if (label != i13) {
                if (label != writableDogData) {
                    if (label != i12) {
                        if (label != i11) {
                        } else {
                            q.b(dogData);
                            return w.a;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    l$0 = eVar.L$0;
                    q.b(dogData);
                } else {
                    label = eVar.L$0;
                    q.b(dogData);
                    obj = l$2;
                    str = cUSTOM_BREED;
                    super(0, 0, obj, 0, 0, 0, 0, 123, 0);
                    DogUpdateRequest dogUpdateRequest = new DogUpdateRequest(writableDogData);
                    eVar.L$0 = label;
                    eVar.L$1 = i14;
                    eVar.L$2 = i14;
                    eVar.label = i12;
                    if (label.a.updateDogData(str, dogUpdateRequest, eVar) == obj3) {
                        return obj3;
                    }
                    l$0 = label;
                }
            } else {
                l$0 = eVar.L$0;
                q.b(dogData);
            }
        } else {
            q.b(dogData);
            if (cUSTOM_BREED == null) {
                eVar.L$0 = g2Var;
                eVar.label = i13;
                if (g2Var.c(str, g2.a.CUSTOM_BREED, eVar) == obj3) {
                    return obj3;
                }
                l$0 = g2Var;
            } else {
                eVar.L$0 = g2Var;
                eVar.L$1 = str;
                eVar.L$2 = cUSTOM_BREED;
                eVar.label = writableDogData;
                if (g2Var.c(str, g2.a.BREED_ID, eVar) == obj3) {
                    return obj3;
                }
                label = g2Var;
                obj = cUSTOM_BREED;
            }
        }
        eVar.L$0 = i14;
        eVar.label = i11;
        if (l$0.j(dogData.getDog(), eVar) == obj3) {
            return obj3;
        }
    }

    public final Object i(String string, d d2, d<? super w> d3) {
        Object l$0;
        Object str;
        Object dogData;
        boolean fVar;
        int label;
        int i8;
        DogUpdateRequest dogUpdateRequest;
        int i10;
        DogUpdateRequest.WritableDogData i12;
        DogUpdateRequest.WritableDogData i11;
        int i13;
        int i6;
        int i9;
        int i3;
        int i;
        String trackTag;
        int i2;
        int i4;
        int i5;
        int i7;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str = string;
        Object obj = d3;
        fVar = obj;
        label = fVar.label;
        i8 = Integer.MIN_VALUE;
        if (obj instanceof g2.f && label & i8 != 0) {
            fVar = obj;
            label = fVar.label;
            i8 = Integer.MIN_VALUE;
            if (label & i8 != 0) {
                fVar.label = label -= i8;
            } else {
                fVar = new g2.f(g2Var, obj);
            }
        } else {
        }
        dogData = fVar.result;
        Object obj2 = b.d();
        dogUpdateRequest = fVar.label;
        final int i15 = 2;
        i11 = 1;
        if (dogUpdateRequest != null) {
            if (dogUpdateRequest != i11) {
                if (dogUpdateRequest != i15) {
                    if (dogUpdateRequest != 3) {
                    } else {
                        q.b(dogData);
                        return w.a;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                l$0 = fVar.L$0;
                q.b(dogData);
            } else {
                l$0 = fVar.L$0;
                q.b(dogData);
            }
        } else {
            q.b(dogData);
            if (d2 == null) {
                fVar.L$0 = g2Var;
                fVar.label = i11;
                if (g2Var.c(str, g2.a.GENDER, fVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            } else {
                super(0, 0, 0, 0, 0, d2.getTrackTag(), 0, 95, 0);
                dogUpdateRequest = new DogUpdateRequest(writableDogData);
                fVar.L$0 = g2Var;
                fVar.label = i15;
                if (g2Var.a.updateDogData(str, dogUpdateRequest, fVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            }
        }
        fVar.L$0 = 0;
        fVar.label = 3;
        if (l$0.j(dogData.getDog(), fVar) == obj2) {
            return obj2;
        }
    }

    public final Object k(String string, String string2, d<? super w> d3) {
        Object l$0;
        Object str;
        Object dogData;
        boolean hVar;
        int label;
        int i12;
        DogUpdateRequest dogUpdateRequest;
        int i3;
        DogUpdateRequest.WritableDogData i11;
        DogUpdateRequest.WritableDogData i4;
        String str2;
        int i6;
        int i7;
        int i5;
        int i8;
        int i9;
        int i10;
        int i;
        int i13;
        int i2;
        final app.dogo.com.dogo_android.s.a.g2 g2Var = this;
        str = string;
        Object obj = d3;
        hVar = obj;
        label = hVar.label;
        i12 = Integer.MIN_VALUE;
        if (obj instanceof g2.h && label & i12 != 0) {
            hVar = obj;
            label = hVar.label;
            i12 = Integer.MIN_VALUE;
            if (label & i12 != 0) {
                hVar.label = label -= i12;
            } else {
                hVar = new g2.h(g2Var, obj);
            }
        } else {
        }
        dogData = hVar.result;
        Object obj2 = b.d();
        dogUpdateRequest = hVar.label;
        final int i15 = 2;
        i4 = 1;
        if (dogUpdateRequest != null) {
            if (dogUpdateRequest != i4) {
                if (dogUpdateRequest != i15) {
                    if (dogUpdateRequest != 3) {
                    } else {
                        q.b(dogData);
                        return w.a;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                l$0 = hVar.L$0;
                q.b(dogData);
            } else {
                l$0 = hVar.L$0;
                q.b(dogData);
            }
        } else {
            q.b(dogData);
            if (string2 == null) {
                hVar.L$0 = g2Var;
                hVar.label = i4;
                if (g2Var.c(str, g2.a.NAME, hVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            } else {
                super(string2, 0, 0, 0, 0, 0, 0, 126, 0);
                dogUpdateRequest = new DogUpdateRequest(writableDogData);
                hVar.L$0 = g2Var;
                hVar.label = i15;
                if (g2Var.a.updateDogData(str, dogUpdateRequest, hVar) == obj2) {
                    return obj2;
                }
                l$0 = g2Var;
            }
        }
        hVar.L$0 = 0;
        hVar.label = 3;
        if (l$0.j(dogData.getDog(), hVar) == obj2) {
            return obj2;
        }
    }
}
