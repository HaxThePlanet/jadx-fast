package zendesk.support.request;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.d;
import f.g.d.f;
import f.g.d.j;
import f.g.e.a;
import o.b.a;
import o.b.k;
import zendesk.support.CommentsResponse;

/* loaded from: classes3.dex */
class RequestAccessibilityHerald implements k<a<?>> {

    private final View view;
    RequestAccessibilityHerald(View view) {
        super();
        this.view = view;
    }

    private void announce(int i, Object... object2Arr2) {
        this.view.announceForAccessibility(this.view.getContext().getString(i, object2Arr2));
    }

    static zendesk.support.request.RequestAccessibilityHerald create(zendesk.support.request.RequestActivity requestActivity) {
        RequestAccessibilityHerald requestAccessibilityHerald = new RequestAccessibilityHerald(requestActivity.findViewById(f.j));
        return requestAccessibilityHerald;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((a)object);
    }

    public void update(a<?> a) {
        String actionType;
        int arr;
        int i;
        String obj6;
        actionType.hashCode();
        final int i2 = 1;
        final int i3 = 0;
        i = -1;
        switch (actionType) {
            case "CREATE_COMMENT_SUCCESS":
                i = i3;
                break;
            case "CREATE_COMMENT_ERROR":
                i = i2;
                break;
            case "LOAD_COMMENT_INITIAL":
                i = 2;
                break;
            default:
        }
        switch (i) {
            case 0:
                arr = new Object[i2];
                arr[i3] = (ActionCreateComment.CreateCommentResult)a.getData().getMessage().getPlainBody();
                announce(j.I, arr);
                break;
            case 1:
                arr = new Object[i2];
                arr[i3] = (StateMessage)a.getData().getPlainBody();
                announce(j.J, arr);
                break;
            case 2:
                obj6 = a.getData();
                obj6 = obj6.a;
                announce(j.K, new Object[i3]);
                break;
            default:
        }
    }
}
