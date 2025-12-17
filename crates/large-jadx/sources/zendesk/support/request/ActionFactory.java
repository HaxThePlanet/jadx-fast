package zendesk.support.request;

import com.zendesk.service.a;
import d.h.k.d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import o.b.a;
import zendesk.belvedere.a;
import zendesk.belvedere.s;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;
import zendesk.support.CommentsResponse;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.UploadProvider;

/* loaded from: classes3.dex */
class ActionFactory {

    static final String ANDROID_ON_PAUSE = "ANDROID_ON_PAUSE";
    static final String ANDROID_ON_RESUME = "ANDROID_ON_RESUME";
    static final String ATTACHMENTS_DESELECTED = "ATTACHMENTS_DESELECTED";
    static final String ATTACHMENTS_SELECTED = "ATTACHMENTS_SELECTED";
    static final String ATTACHMENT_DOWNLOADED = "ATTACHMENT_DOWNLOADED";
    static final String CLEAR_ATTACHMENTS = "CLEAR_ATTACHMENTS";
    static final String CLEAR_MESSAGES = "CLEAR_MESSAGES";
    static final String CREATE_COMMENT = "CREATE_COMMENT";
    static final String CREATE_COMMENT_ERROR = "CREATE_COMMENT_ERROR";
    static final String CREATE_COMMENT_SUCCESS = "CREATE_COMMENT_SUCCESS";
    static final String CREATE_REQUEST = "CREATE_REQUEST";
    static final String CREATE_REQUEST_ERROR = "CREATE_REQUEST_ERROR";
    static final String CREATE_REQUEST_SUCCESS = "CREATE_REQUEST_SUCCESS";
    static final String DELETE_MESSAGE = "DELETE_MESSAGE";
    static final String DIALOG_DISMISSED = "DIALOG_DISMISSED";
    static final String LOAD_COMMENTS_FROM_CACHE = "LOAD_COMMENTS_FROM_CACHE";
    static final String LOAD_COMMENTS_FROM_CACHE_ERROR = "LOAD_COMMENTS_FROM_CACHE_ERROR";
    static final String LOAD_COMMENTS_FROM_CACHE_SUCCESS = "LOAD_COMMENTS_FROM_CACHE_SUCCESS";
    static final String LOAD_COMMENTS_INITIAL = "LOAD_COMMENT_INITIAL";
    static final String LOAD_COMMENTS_INITIAL_ERROR = "LOAD_COMMENTS_INITIAL_ERROR";
    static final String LOAD_COMMENTS_INITIAL_SUCCESS = "LOAD_COMMENTS_INITIAL_SUCCESS";
    static final String LOAD_COMMENTS_UPDATE = "LOAD_COMMENTS_UPDATE";
    static final String LOAD_COMMENTS_UPDATE_ERROR = "LOAD_COMMENTS_UPDATE_ERROR";
    static final String LOAD_COMMENTS_UPDATE_SUCCESS = "LOAD_COMMENTS_UPDATE_SUCCESS";
    static final String LOAD_REQUEST = "LOAD_REQUEST";
    static final String LOAD_REQUEST_ERROR = "LOAD_REQUEST_ERROR";
    static final String LOAD_REQUEST_SUCCESS = "LOAD_REQUEST_SUCCESS";
    static final String LOAD_SETTINGS = "LOAD_SETTINGS";
    static final String LOAD_SETTINGS_ERROR = "LOAD_SETTINGS_ERROR";
    static final String LOAD_SETTINGS_SUCCESS = "LOAD_SETTINGS_SUCCESS";
    static final String REQUEST_CLOSED = "REQUEST_CLOSED";
    static final String SHOW_RETRY_DIALOG = "SHOW_RETRY_DIALOG";
    static final String SKIP_ACTION = "SKIP_ACTION";
    static final String START_CONFIG = "START_CONFIG";
    private final AuthenticationProvider authProvider;
    private final a belvedere;
    private final Executor executorService;
    private final Executor mainThreadExecutor;
    private final RequestProvider requestProvider;
    private final String sdkVersion;
    private final SupportSettingsProvider settingsProvider;
    private final SupportBlipsProvider supportBlipsProvider;
    private final SupportUiStorage supportUiStorage;
    private final UploadProvider uploadProvider;
    private final Zendesk zendesk;

    static class ErrorAction extends a<E> {

        private final a errorResponse;
        ErrorAction(String string, a a2) {
            super(string, a2, 0);
        }

        ErrorAction(String string, a a2, E e3) {
            super(string, e3);
            this.errorResponse = a2;
        }

        @Override // o.b.a
        public a getErrorResponse() {
            return this.errorResponse;
        }
    }
    ActionFactory(RequestProvider requestProvider, UploadProvider uploadProvider2, SupportSettingsProvider supportSettingsProvider3, a a4, SupportUiStorage supportUiStorage5, Executor executor6, String string7, AuthenticationProvider authenticationProvider8, Zendesk zendesk9, SupportBlipsProvider supportBlipsProvider10, Executor executor11) {
        super();
        this.requestProvider = requestProvider;
        this.uploadProvider = uploadProvider2;
        this.settingsProvider = supportSettingsProvider3;
        this.belvedere = a4;
        this.supportUiStorage = supportUiStorage5;
        this.executorService = executor6;
        this.mainThreadExecutor = executor11;
        this.sdkVersion = string7;
        this.authProvider = authenticationProvider8;
        this.zendesk = zendesk9;
        this.supportBlipsProvider = supportBlipsProvider10;
    }

    a androidOnPause() {
        a aVar = new a("ANDROID_ON_PAUSE");
        return aVar;
    }

    a androidOnResume() {
        a aVar = new a("ANDROID_ON_RESUME");
        return aVar;
    }

    a attachmentDownloaded(zendesk.support.request.StateRequestAttachment stateRequestAttachment, s s2) {
        a aVar = new a("ATTACHMENT_DOWNLOADED", d.a(stateRequestAttachment, s2));
        return aVar;
    }

    a clearAttachments() {
        a aVar = new a("CLEAR_ATTACHMENTS");
        return aVar;
    }

    a clearMessages() {
        a aVar = new a("CLEAR_MESSAGES");
        return aVar;
    }

    a createComment(zendesk.support.request.StateMessage stateMessage) {
        a aVar = new a("CREATE_COMMENT", stateMessage);
        return aVar;
    }

    a createCommentAsync(String string, List<zendesk.support.request.StateRequestAttachment> list2) {
        AttachmentUploadService attachmentUploadService = new AttachmentUploadService(this.uploadProvider, this.belvedere, list2);
        StateMessage stateMessage = new StateMessage(string, list2);
        ActionCreateComment actionCreateComment = new ActionCreateComment(this, this.requestProvider, attachmentUploadService, stateMessage);
        return AsyncMiddleware.createAction(actionCreateComment);
    }

    a createCommentError(a a, zendesk.support.request.StateMessage stateMessage2) {
        ActionFactory.ErrorAction errorAction = new ActionFactory.ErrorAction("CREATE_COMMENT_ERROR", a, stateMessage2);
        return errorAction;
    }

    a createCommentSuccess(zendesk.support.request.ActionCreateComment.CreateCommentResult actionCreateComment$CreateCommentResult) {
        a aVar = new a("CREATE_COMMENT_SUCCESS", createCommentResult);
        return aVar;
    }

    a createRequestError(a a, zendesk.support.request.StateMessage stateMessage2) {
        ActionFactory.ErrorAction errorAction = new ActionFactory.ErrorAction("CREATE_REQUEST_ERROR", a, stateMessage2);
        return errorAction;
    }

    a createRequestSuccess(zendesk.support.request.ActionCreateComment.CreateCommentResult actionCreateComment$CreateCommentResult) {
        a aVar = new a("CREATE_REQUEST_SUCCESS", createCommentResult);
        return aVar;
    }

    a deleteMessage(zendesk.support.request.StateMessage stateMessage) {
        a aVar = new a("DELETE_MESSAGE", stateMessage);
        return aVar;
    }

    a deselectAttachment(List<s> list) {
        a aVar = new a("ATTACHMENTS_DESELECTED", list);
        return aVar;
    }

    a initialLoadCommentsAsync() {
        ActionLoadComments actionLoadComments = new ActionLoadComments(this, this.requestProvider, this.belvedere, 1);
        return AsyncMiddleware.createAction(actionLoadComments);
    }

    a installStartConfigAsync(zendesk.support.request.RequestConfiguration requestConfiguration) {
        super(this.supportUiStorage, requestConfiguration, this.executorService, this.mainThreadExecutor, this, this.supportBlipsProvider);
        return AsyncMiddleware.createAction(actionInstallConfiguration2);
    }

    a loadComments(boolean z) {
        if (z) {
            a obj2 = new a("LOAD_COMMENT_INITIAL");
            return obj2;
        }
        obj2 = new a("LOAD_COMMENTS_UPDATE");
        return obj2;
    }

    a loadCommentsError(boolean z, a a2) {
        if (z) {
            ActionFactory.ErrorAction obj2 = new ActionFactory.ErrorAction("LOAD_COMMENTS_INITIAL_ERROR", a2);
            return obj2;
        }
        obj2 = new ActionFactory.ErrorAction("LOAD_COMMENTS_UPDATE_ERROR", a2);
        return obj2;
    }

    a loadCommentsFromCache() {
        a aVar = new a("LOAD_COMMENTS_FROM_CACHE");
        return aVar;
    }

    a loadCommentsFromCacheAsync() {
        super(this, this.supportUiStorage, this.belvedere, this.executorService, this.sdkVersion);
        return AsyncMiddleware.createAction(actionLoadCachedComments2);
    }

    a loadCommentsFromCacheError() {
        a aVar = new a("LOAD_COMMENTS_FROM_CACHE_ERROR");
        return aVar;
    }

    a loadCommentsFromCacheSuccess(zendesk.support.request.StateConversation stateConversation) {
        a aVar = new a("LOAD_COMMENTS_FROM_CACHE_SUCCESS", stateConversation);
        return aVar;
    }

    a loadCommentsSuccess(boolean z, CommentsResponse commentsResponse2, Map<Long, s> map3) {
        d dVar = new d(commentsResponse2, map3);
        if (z) {
            a obj2 = new a("LOAD_COMMENTS_INITIAL_SUCCESS", dVar);
            return obj2;
        }
        obj2 = new a("LOAD_COMMENTS_UPDATE_SUCCESS", dVar);
        return obj2;
    }

    a loadRequest() {
        a aVar = new a("LOAD_REQUEST");
        return aVar;
    }

    a loadRequestAsync() {
        ActionLoadRequest actionLoadRequest = new ActionLoadRequest(this, this.requestProvider);
        return AsyncMiddleware.createAction(actionLoadRequest);
    }

    a loadRequestError(a a) {
        ActionFactory.ErrorAction errorAction = new ActionFactory.ErrorAction("LOAD_REQUEST_ERROR", a);
        return errorAction;
    }

    a loadRequestSuccess(Request request) {
        a aVar = new a("LOAD_REQUEST_SUCCESS", request);
        return aVar;
    }

    a loadSettings() {
        a aVar = new a("LOAD_SETTINGS");
        return aVar;
    }

    a loadSettingsAsync() {
        ActionLoadSettings actionLoadSettings = new ActionLoadSettings(this, this.settingsProvider, this.authProvider);
        return AsyncMiddleware.createAction(actionLoadSettings);
    }

    a loadSettingsError(a a) {
        ActionFactory.ErrorAction errorAction = new ActionFactory.ErrorAction("LOAD_SETTINGS_ERROR", a);
        return errorAction;
    }

    a loadSettingsSuccess(zendesk.support.request.StateSettings stateSettings) {
        a aVar = new a("LOAD_SETTINGS_SUCCESS", stateSettings);
        return aVar;
    }

    a onDialogDismissed() {
        a aVar = new a("DIALOG_DISMISSED");
        return aVar;
    }

    a requestClosed() {
        a aVar = new a("REQUEST_CLOSED");
        return aVar;
    }

    a resendCommentAsync(zendesk.support.request.StateMessage stateMessage) {
        AttachmentUploadService attachmentUploadService = new AttachmentUploadService(this.uploadProvider, this.belvedere, stateMessage.getAttachments());
        ActionCreateComment actionCreateComment = new ActionCreateComment(this, this.requestProvider, attachmentUploadService, stateMessage);
        return AsyncMiddleware.createAction(actionCreateComment);
    }

    a selectAttachment(List<s> list) {
        a aVar = new a("ATTACHMENTS_SELECTED", list);
        return aVar;
    }

    a showRetryDialog(List<zendesk.support.request.StateMessage> list) {
        a aVar = new a("SHOW_RETRY_DIALOG", list);
        return aVar;
    }

    a skipAction() {
        a aVar = new a("SKIP_ACTION");
        return aVar;
    }

    a startConfig(zendesk.support.request.RequestConfiguration requestConfiguration) {
        a aVar = new a("START_CONFIG", requestConfiguration);
        return aVar;
    }

    a updateCommentsAsync() {
        ActionLoadComments actionLoadComments = new ActionLoadComments(this, this.requestProvider, this.belvedere, 0);
        return AsyncMiddleware.createAction(actionLoadComments);
    }

    a updateNameEmailAsync(String string, String string2) {
        ActionUpdateNameEmail actionUpdateNameEmail = new ActionUpdateNameEmail(string, string2, this.authProvider, this.zendesk);
        return AsyncMiddleware.createAction(actionUpdateNameEmail);
    }
}
