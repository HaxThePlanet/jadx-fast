package zendesk.support;

import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
class ServiceModule {
    static zendesk.support.ZendeskRequestService provideZendeskRequestService(zendesk.support.RequestService requestService) {
        ZendeskRequestService zendeskRequestService = new ZendeskRequestService(requestService);
        return zendeskRequestService;
    }

    static zendesk.support.ZendeskUploadService provideZendeskUploadService(zendesk.support.UploadService uploadService) {
        ZendeskUploadService zendeskUploadService = new ZendeskUploadService(uploadService);
        return zendeskUploadService;
    }

    static zendesk.support.RequestService providesRequestService(RestServiceProvider restServiceProvider) {
        return (RequestService)restServiceProvider.createRestService(RequestService.class, "5.0.3", "Support");
    }

    static zendesk.support.UploadService providesUploadService(RestServiceProvider restServiceProvider) {
        return (UploadService)restServiceProvider.createRestService(UploadService.class, "5.0.3", "Support");
    }
}
