package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.goodexamples.GoodTrickExampleModel;
import app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import app.dogo.com.dogo_android.s.b.q1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* compiled from: GetTrickVideoGoodExamplesInteractor.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetTrickVideoGoodExamplesInteractor;", "", "videoRepository", "Lapp/dogo/com/dogo_android/repository/local/VideoRepository;", "(Lapp/dogo/com/dogo_android/repository/local/VideoRepository;)V", "getTrickVideos", "", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "trickId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVimeoUrl", "video", "Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "(Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b3, reason: from kotlin metadata */
public final class GetTrickVideoGoodExamplesInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final q1 videoRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetTrickVideoGoodExamplesInteractor", f = "GetTrickVideoGoodExamplesInteractor.kt", l = {11, 12}, m = "getTrickVideos")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super b3.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return b3.this.b(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetTrickVideoGoodExamplesInteractor", f = "GetTrickVideoGoodExamplesInteractor.kt", l = 16, m = "getVimeoUrl")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super b3.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return b3.this.c(0, this);
        }
    }
    public b3(q1 q1Var) {
        n.f(q1Var, "videoRepository");
        super();
        this.videoRepository = q1Var;
    }

    public static final /* synthetic */ Object a(b3 b3Var, GoodTrickExampleModel goodTrickExampleModel, kotlin.b0.d dVar) {
        return b3Var.c(goodTrickExampleModel, dVar);
    }

    private final Object c(GoodTrickExampleModel goodTrickExampleModel, kotlin.b0.d<? super GoodTrickExample> dVar) {
        app.dogo.com.dogo_android.s.a.b3.b bVar;
        int label2;
        int i = -2147483648;
        Object obj4;
        int i2;
        Object obj2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.b3.b;
        if (dVar instanceof kotlinx.coroutines.b3.b) {
            Object dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                bVar = new kotlinx.coroutines.b3.b(this, dVar);
            }
        }
        Object obj5 = bVar;
        Object obj3 = b.d();
        int i5 = 1;
        if (obj5.label != 0 && obj5.label == i5) {
            q.b(obj5.result);
            GoodTrickExample goodTrickExample = new GoodTrickExample(obj2.getContentId(), obj4, obj2.getDogName(), result2.getVideoUrl(), result2.getImageUrl());
            return goodTrickExample;
        }
        q.b(obj5.result);
        long contentId2 = goodTrickExampleModel.getContentId();
        int i4 = 2;
        Object obj = null;
        obj5.L$0 = goodTrickExampleModel;
        obj5.label = i5;
        if (VideoRepository.g(this.videoRepository, contentId2, 0, obj5, i4, obj) == obj3) {
            return obj3;
        }
    }

    public final Object b(String str, kotlin.b0.d<? super List<GoodTrickExample>> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        Iterator dVar23;
        int i2;
        ArrayList str2;
        app.dogo.com.dogo_android.s.a.b3 str3;
        Object result2;
        Iterable iterable;
        z = dVar instanceof kotlinx.coroutines.b3.a;
        if (dVar instanceof kotlinx.coroutines.b3.a) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.b3.a aVar = new kotlinx.coroutines.b3.a(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 2;
        int i5 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i5) {
                if (dVar22.label != i4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar22.result);
                    str2.add((GoodTrickExample)result2);
                    if (dVar23.hasNext()) {
                        dVar22.L$0 = str3;
                        dVar22.L$1 = str2;
                        dVar22.L$2 = dVar23;
                        dVar22.L$3 = str2;
                        dVar22.label = i4;
                        if (str3.c((GoodTrickExampleModel)dVar23.next(), dVar22) == obj) {
                            return obj;
                        }
                    }
                    return str2;
                }
            }
            q.b(dVar22.result);
        } else {
            q.b(dVar22.result);
            dVar22.L$0 = this;
            dVar22.label = i5;
            if (this.videoRepository.h(str, dVar22) == obj) {
                return obj;
            }
            str3 = this;
        }
    }
}
