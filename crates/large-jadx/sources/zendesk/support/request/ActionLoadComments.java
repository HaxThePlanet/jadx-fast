package zendesk.support.request;

import android.os.Handler;
import android.os.Looper;
import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.g;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import o.b.f;
import o.b.j;
import zendesk.belvedere.a;
import zendesk.belvedere.s;
import zendesk.support.Attachment;
import zendesk.support.CommentResponse;
import zendesk.support.CommentsResponse;
import zendesk.support.RequestProvider;

/* loaded from: classes3.dex */
class ActionLoadComments implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final zendesk.support.request.ActionFactory actionFactory;
    private final a belvedere;
    private final Handler handler;
    private final boolean initialLoad;
    private final RequestProvider requestProvider;

    private static abstract class MinimumTimeCallback extends f<E> {

        private final Handler handler;
        private final long minTime;
        private final TimeUnit minTimeUnit;
        private final long start;
        MinimumTimeCallback(Handler handler, long l2, TimeUnit timeUnit3) {
            super();
            this.start = System.nanoTime();
            this.handler = handler;
            this.minTime = l2;
            this.minTimeUnit = obj6;
        }

        private long remainingTime() {
            nanoTime -= start;
            TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
            long convert2 = nANOSECONDS.convert(this.minTime, obj4);
            if (Long.compare(i, convert2) < 0) {
                return TimeUnit.MILLISECONDS.convert(convert2 -= i, obj4);
            }
            return 0;
        }

        @Override // com.zendesk.service.f
        public abstract void onDelayedError(a a);

        public abstract void onDelayedSuccess(E e);

        @Override // com.zendesk.service.f
        public void onError(a a) {
            ActionLoadComments.MinimumTimeCallback.2 anon = new ActionLoadComments.MinimumTimeCallback.2(this, a);
            this.handler.postDelayed(anon, remainingTime());
        }

        public void onSuccess(E e) {
            ActionLoadComments.MinimumTimeCallback.1 anon = new ActionLoadComments.MinimumTimeCallback.1(this, e);
            this.handler.postDelayed(anon, remainingTime());
        }
    }
    ActionLoadComments(zendesk.support.request.ActionFactory actionFactory, RequestProvider requestProvider2, a a3, Handler handler4, boolean z5) {
        super();
        this.actionFactory = actionFactory;
        this.requestProvider = requestProvider2;
        this.belvedere = a3;
        this.handler = handler4;
        this.initialLoad = z5;
    }

    ActionLoadComments(zendesk.support.request.ActionFactory actionFactory, RequestProvider requestProvider2, a a3, boolean z4) {
        Handler handler = new Handler(Looper.getMainLooper());
        super(actionFactory, requestProvider2, a3, handler, z4);
    }

    static RequestProvider access$000(zendesk.support.request.ActionLoadComments actionLoadComments) {
        return actionLoadComments.requestProvider;
    }

    static Map access$100(zendesk.support.request.ActionLoadComments actionLoadComments, String string2, CommentsResponse commentsResponse3) {
        return actionLoadComments.findAttachments(string2, commentsResponse3);
    }

    static boolean access$200(zendesk.support.request.ActionLoadComments actionLoadComments) {
        return actionLoadComments.initialLoad;
    }

    static zendesk.support.request.ActionFactory access$300(zendesk.support.request.ActionLoadComments actionLoadComments) {
        return actionLoadComments.actionFactory;
    }

    private zendesk.support.request.StateMessage find2ndLastDeliveredMessage(List<zendesk.support.request.StateMessage> list) {
        int i2;
        Object previous;
        int status;
        int i;
        ListIterator obj5 = list.listIterator(list.size());
        i2 = 0;
        while (obj5.hasPrevious()) {
            previous = obj5.previous();
            i = 2;
        }
        return null;
    }

    private Map<Long, s> findAttachments(String string, CommentsResponse commentsResponse2) {
        Iterator iterator;
        boolean next;
        s localFile;
        int cmp;
        long length;
        HashMap hashMap = new HashMap();
        Iterator obj10 = commentsResponse2.getComments().iterator();
        for (CommentResponse next3 : obj10) {
            iterator = next3.getAttachments().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                localFile = UtilsAttachment.getLocalFile(this.belvedere, string, (Attachment)next.getId().longValue(), obj5);
                if (Long.compare(longValue2, length) == 0) {
                }
                hashMap.put(next.getId(), localFile);
            }
            next = iterator.next();
            localFile = UtilsAttachment.getLocalFile(this.belvedere, string, (Attachment)next.getId().longValue(), obj5);
            if (Long.compare(longValue2, length) == 0) {
            }
            hashMap.put(next.getId(), localFile);
        }
        return hashMap;
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
        f.c(this.actionFactory.loadComments(this.initialLoad));
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        Object obj12;
        String obj13;
        RequestProvider obj14;
        obj13 = StateConversation.fromState(j2.getState());
        final int i2 = 0;
        if (!g.c(obj13.getRemoteId())) {
            a.b("RequestActivity", "Skip loading comments. No remote id found.", new Object[i2]);
            f.c(this.actionFactory.skipAction());
            callback3.done();
        }
        super(this, this.handler, 1, obj4, TimeUnit.SECONDS, obj13, f, callback3);
        obj12 = find2ndLastDeliveredMessage(obj13.getMessages());
        if (obj12 != null) {
            this.requestProvider.getCommentsSince(obj13.getRemoteId(), obj12.getDate(), i2, anon2);
        } else {
            this.requestProvider.getComments(obj13.getRemoteId(), anon2);
        }
    }
}
