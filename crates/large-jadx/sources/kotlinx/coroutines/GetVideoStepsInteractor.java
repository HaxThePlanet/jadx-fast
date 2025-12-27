package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData;
import app.dogo.com.dogo_android.repository.domain.VideoSteps;
import app.dogo.com.dogo_android.s.b.q1;
import app.dogo.com.dogo_android.service.r2;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* compiled from: GetVideoStepsInteractor.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetVideoStepsInteractor;", "", "videoRepository", "Lapp/dogo/com/dogo_android/repository/local/VideoRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/repository/local/VideoRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "addVimeoDataIfAvailable", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "trick", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoSteps", "Lapp/dogo/com/dogo_android/repository/domain/VideoSteps;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c3, reason: from kotlin metadata */
public final class GetVideoStepsInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final q1 remoteConfigService;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetVideoStepsInteractor", f = "GetVideoStepsInteractor.kt", l = 24, m = "addVimeoDataIfAvailable")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super c3.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c3.this.a(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetVideoStepsInteractor", f = "GetVideoStepsInteractor.kt", l = 13, m = "getVideoSteps")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super c3.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c3.this.b(null, this);
        }
    }
    public c3(q1 q1Var, r2 r2Var) {
        n.f(q1Var, "videoRepository");
        n.f(r2Var, "remoteConfigService");
        super();
        this.remoteConfigService = q1Var;
    }

    public final Object a(TrickItem trickItem, kotlin.b0.d<? super TrickItem> dVar) {
        TrickItem trickItem2;
        TrickItem copy$default;
        Object result2;
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        final app.dogo.com.dogo_android.s.a.c3 trickItem4 = this;
        Object dVar23 = trickItem;
        dVar22 = dVar;
        z = dVar22 instanceof kotlinx.coroutines.c3.a;
        if (dVar22 instanceof kotlinx.coroutines.c3.a) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.c3.a aVar = new kotlinx.coroutines.c3.a(trickItem4, dVar22);
            }
        }
        Object obj2 = b.d();
        int i8 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i8) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                TrickItem trickItem3 = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                boolean z2 = false;
                int i3 = 0;
                java.util.List list = null;
                java.util.List list2 = null;
                boolean z3 = false;
                int i4 = 0;
                java.util.List list3 = null;
                app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickCategory = null;
                boolean z4 = false;
                boolean z5 = false;
                String str5 = null;
                java.util.List list4 = null;
                String str6 = null;
                int i5 = 0;
                int i6 = 1032191;
                Object obj = null;
                copy$default = TrickItem.copy$default(trickItem2, trickItem3, str, str2, str3, str4, z2, i3, list, list2, z3, i4, list3, trickCategory, z4, trickItem_VimeoData, z5, str5, list4, str6, i5, i6, obj);
                return copy$default;
            }
        }
        q.b(dVar22.result);
    }

    public final Object b(TrickItem trickItem, kotlin.b0.d<? super VideoSteps> dVar) {
        app.dogo.com.dogo_android.s.a.c3.b bVar;
        int label2;
        int i = -2147483648;
        int i3;
        Object obj2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.c3.b;
        if (dVar instanceof kotlinx.coroutines.c3.b) {
            Object dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i3 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                bVar = new kotlinx.coroutines.c3.b(this, dVar);
            }
        }
        final Object obj4 = bVar;
        Object obj3 = b.d();
        int i2 = 1;
        if (obj4.label != 0 && obj4.label == i2) {
            q.b(obj4.result);
            return new VideoSteps(obj2.getVideoSteps(), result2.getVideoUrl(), result2.getImageUrl());
        }
        q.b(obj4.result);
        long videoId = trickItem.getVideoId();
        int i5 = 2;
        Object obj = null;
        obj4.L$0 = trickItem;
        obj4.label = i2;
        if (VideoRepository.g(this.remoteConfigService, videoId, 0, obj4, i5, obj) == obj3) {
            return obj3;
        }
    }
}
