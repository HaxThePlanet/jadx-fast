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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetTrickVideoGoodExamplesInteractor;", "", "videoRepository", "Lapp/dogo/com/dogo_android/repository/local/VideoRepository;", "(Lapp/dogo/com/dogo_android/repository/local/VideoRepository;)V", "getTrickVideos", "", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "trickId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVimeoUrl", "video", "Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "(Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b3 {

    private final q1 a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetTrickVideoGoodExamplesInteractor", f = "GetTrickVideoGoodExamplesInteractor.kt", l = {11, 12}, m = "getTrickVideos")
    static final class a extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.b3 this$0;
        a(app.dogo.com.dogo_android.s.a.b3 b3, d<? super app.dogo.com.dogo_android.s.a.b3.a> d2) {
            this.this$0 = b3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetTrickVideoGoodExamplesInteractor", f = "GetTrickVideoGoodExamplesInteractor.kt", l = 16, m = "getVimeoUrl")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.b3 this$0;
        b(app.dogo.com.dogo_android.s.a.b3 b3, d<? super app.dogo.com.dogo_android.s.a.b3.b> d2) {
            this.this$0 = b3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return b3.a(this.this$0, 0, this);
        }
    }
    public b3(q1 q1) {
        n.f(q1, "videoRepository");
        super();
        this.a = q1;
    }

    public static final Object a(app.dogo.com.dogo_android.s.a.b3 b3, GoodTrickExampleModel goodTrickExampleModel2, d d3) {
        return b3.c(goodTrickExampleModel2, d3);
    }

    private final Object c(GoodTrickExampleModel goodTrickExampleModel, d<? super GoodTrickExample> d2) {
        boolean bVar;
        int label;
        int label2;
        int i5;
        int i4;
        int contentId;
        int i;
        int i3;
        int i2;
        Object obj9;
        Object obj10;
        bVar = d2;
        label = bVar.label;
        i5 = Integer.MIN_VALUE;
        if (d2 instanceof b3.b && label & i5 != 0) {
            bVar = d2;
            label = bVar.label;
            i5 = Integer.MIN_VALUE;
            if (label & i5 != 0) {
                bVar.label = label -= i5;
            } else {
                bVar = new b3.b(this, d2);
            }
        } else {
        }
        app.dogo.com.dogo_android.s.a.b3.b bVar2 = bVar;
        obj10 = bVar2.result;
        Object obj = b.d();
        label2 = bVar2.label;
        i4 = 1;
        if (label2 != 0) {
            if (label2 != i4) {
            } else {
                obj9 = bVar2.L$0;
                q.b(obj10);
                super(obj9.getContentId(), i4, obj9.getDogName(), (VimeoVideoModel)obj10.getVideoUrl(), obj10.getImageUrl());
                return goodTrickExample2;
            }
            obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj9;
        }
        q.b(obj10);
        contentId = goodTrickExampleModel.getContentId();
        bVar2.L$0 = goodTrickExampleModel;
        bVar2.label = i4;
        if (q1.g(this.a, contentId, contentId, 0, bVar2, 2) == obj) {
            return obj;
        }
    }

    public final Object b(String string, d<? super List<GoodTrickExample>> d2) {
        boolean aVar;
        int label;
        int i2;
        Iterator l$2;
        int i;
        int l$1;
        app.dogo.com.dogo_android.s.a.b3 l$0;
        ArrayList obj7;
        Object obj8;
        aVar = d2;
        label = aVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof b3.a && label & i2 != 0) {
            aVar = d2;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                aVar.label = label -= i2;
            } else {
                aVar = new b3.a(this, d2);
            }
        } else {
        }
        obj8 = aVar.result;
        Object obj = b.d();
        int label2 = aVar.label;
        int i3 = 2;
        int i4 = 1;
        if (label2 != 0) {
            if (label2 != i4) {
                if (label2 != i3) {
                } else {
                    obj7 = aVar.L$3;
                    l$2 = aVar.L$2;
                    l$1 = aVar.L$1;
                    l$0 = aVar.L$0;
                    q.b(obj8);
                    obj7.add((GoodTrickExample)obj8);
                    obj7 = l$1;
                    if (l$2.hasNext()) {
                        aVar.L$0 = l$0;
                        aVar.L$1 = obj7;
                        aVar.L$2 = l$2;
                        aVar.L$3 = obj7;
                        aVar.label = i3;
                        if (l$0.c((GoodTrickExampleModel)l$2.next(), aVar) == obj) {
                            return obj;
                        } else {
                        }
                    }
                    return (List)obj7;
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            obj7 = aVar.L$0;
            q.b(obj8);
        } else {
            q.b(obj8);
            aVar.L$0 = this;
            aVar.label = i4;
            if (this.a.h(string, aVar) == obj) {
                return obj;
            }
            obj7 = this;
        }
        ArrayList arrayList = new ArrayList(p.r((List)obj8, 10));
        l$0 = obj7;
        obj7 = arrayList;
        l$2 = obj8;
    }
}
