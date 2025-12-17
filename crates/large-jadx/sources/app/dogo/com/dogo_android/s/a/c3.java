package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData;
import app.dogo.com.dogo_android.repository.domain.VideoSteps;
import app.dogo.com.dogo_android.s.b.q1;
import app.dogo.com.dogo_android.service.r2;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetVideoStepsInteractor;", "", "videoRepository", "Lapp/dogo/com/dogo_android/repository/local/VideoRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/repository/local/VideoRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "addVimeoDataIfAvailable", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "trick", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoSteps", "Lapp/dogo/com/dogo_android/repository/domain/VideoSteps;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c3 {

    private final q1 a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetVideoStepsInteractor", f = "GetVideoStepsInteractor.kt", l = 24, m = "addVimeoDataIfAvailable")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.c3 this$0;
        a(app.dogo.com.dogo_android.s.a.c3 c3, d<? super app.dogo.com.dogo_android.s.a.c3.a> d2) {
            this.this$0 = c3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetVideoStepsInteractor", f = "GetVideoStepsInteractor.kt", l = 13, m = "getVideoSteps")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.c3 this$0;
        b(app.dogo.com.dogo_android.s.a.c3 c3, d<? super app.dogo.com.dogo_android.s.a.c3.b> d2) {
            this.this$0 = c3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(0, this);
        }
    }
    public c3(q1 q1, r2 r22) {
        n.f(q1, "videoRepository");
        n.f(r22, "remoteConfigService");
        super();
        this.a = q1;
    }

    public final Object a(TrickItem trickItem, d<? super TrickItem> d2) {
        Object copy$default;
        Object result;
        String imageUrl;
        boolean videoUrl;
        int label2;
        int i13;
        Object label;
        int i5;
        int i21;
        int i8;
        int i18;
        int i15;
        int i14;
        int i4;
        int i10;
        int i;
        int i11;
        int i23;
        int i12;
        int i16;
        int i6;
        int i17;
        TrickItem.VimeoData vimeoData;
        int i9;
        int i19;
        int i2;
        int i3;
        int i22;
        int i7;
        int i20;
        final app.dogo.com.dogo_android.s.a.c3 c3Var = this;
        copy$default = trickItem;
        Object obj = d2;
        videoUrl = obj;
        label2 = videoUrl.label;
        i13 = Integer.MIN_VALUE;
        if (obj instanceof c3.a && label2 & i13 != 0) {
            videoUrl = obj;
            label2 = videoUrl.label;
            i13 = Integer.MIN_VALUE;
            if (label2 & i13 != 0) {
                videoUrl.label = label2 -= i13;
            } else {
                videoUrl = new c3.a(c3Var, obj);
            }
        } else {
        }
        result = videoUrl.result;
        Object obj2 = b.d();
        label = videoUrl.label;
        i21 = 1;
        if (label != 0) {
            if (label != i21) {
            } else {
                copy$default = videoUrl.L$0;
                q.b(result);
                TrickItem.VimeoData vimeoData2 = new TrickItem.VimeoData((VideoSteps)result.getVideoUrl(), result.getImageUrl());
                copy$default = TrickItem.copy$default(copy$default, 0, 0, 0, 0, false, 0, 0, 0, 0, obj15, 0, 0, 0, false, 0, vimeoData2, 0, 0, 0, 0, 0, 1032191);
                return copy$default;
            }
            IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw illegalStateException;
        }
        q.b(result);
        if (empty ^= i21 != 0) {
        }
    }

    public final Object b(TrickItem trickItem, d<? super VideoSteps> d2) {
        boolean bVar;
        int label2;
        int label;
        int i;
        int i3;
        int videoId;
        int i4;
        int i5;
        int i2;
        Object obj9;
        Object obj10;
        bVar = d2;
        label2 = bVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof c3.b && label2 & i != 0) {
            bVar = d2;
            label2 = bVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                bVar.label = label2 -= i;
            } else {
                bVar = new c3.b(this, d2);
            }
        } else {
        }
        final app.dogo.com.dogo_android.s.a.c3.b bVar2 = bVar;
        obj10 = bVar2.result;
        Object obj = b.d();
        label = bVar2.label;
        i3 = 1;
        if (label != 0) {
            if (label != i3) {
            } else {
                obj9 = bVar2.L$0;
                q.b(obj10);
                VideoSteps videoSteps = new VideoSteps(obj9.getVideoSteps(), (VimeoVideoModel)obj10.getVideoUrl(), obj10.getImageUrl());
                return videoSteps;
            }
            obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj9;
        }
        q.b(obj10);
        videoId = trickItem.getVideoId();
        bVar2.L$0 = trickItem;
        bVar2.label = i3;
        if (q1.g(this.a, videoId, videoId, 0, bVar2, 2) == obj) {
            return obj;
        }
    }
}
