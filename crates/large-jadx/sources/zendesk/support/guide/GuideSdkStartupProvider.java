package zendesk.support.guide;

import android.content.Context;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.SdkStartUpProvider;
import zendesk.core.Zendesk;

/* loaded from: classes3.dex */
public class GuideSdkStartupProvider extends SdkStartUpProvider {

    zendesk.support.guide.ViewArticleActionHandler articleActionHandler;
    @Override // zendesk.core.SdkStartUpProvider
    protected void onStartUp(Context context) {
        ActionHandlerRegistry obj2 = Zendesk.INSTANCE.actionHandlerRegistry();
        zendesk.support.guide.ViewArticleActionHandler articleActionHandler = this.articleActionHandler;
        if (articleActionHandler != null) {
            obj2.remove(articleActionHandler);
        }
        ViewArticleActionHandler viewArticleActionHandler = new ViewArticleActionHandler();
        this.articleActionHandler = viewArticleActionHandler;
        obj2.add(viewArticleActionHandler);
    }
}
