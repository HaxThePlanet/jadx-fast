package zendesk.support.guide;

import g.b.b;
import g.b.d;
import zendesk.core.ActionHandler;

/* loaded from: classes3.dex */
public final class GuideSdkModule_ViewArticleActionHandlerFactory implements b<ActionHandler> {

    private static final zendesk.support.guide.GuideSdkModule_ViewArticleActionHandlerFactory INSTANCE;
    static {
        GuideSdkModule_ViewArticleActionHandlerFactory guideSdkModule_ViewArticleActionHandlerFactory = new GuideSdkModule_ViewArticleActionHandlerFactory();
        GuideSdkModule_ViewArticleActionHandlerFactory.INSTANCE = guideSdkModule_ViewArticleActionHandlerFactory;
    }

    public static zendesk.support.guide.GuideSdkModule_ViewArticleActionHandlerFactory create() {
        return GuideSdkModule_ViewArticleActionHandlerFactory.INSTANCE;
    }

    public static ActionHandler viewArticleActionHandler() {
        final ActionHandler viewArticleActionHandler = GuideSdkModule.viewArticleActionHandler();
        d.c(viewArticleActionHandler, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionHandler)viewArticleActionHandler;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ActionHandler get() {
        return GuideSdkModule_ViewArticleActionHandlerFactory.viewArticleActionHandler();
    }
}
