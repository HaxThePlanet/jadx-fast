@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 3 extends kotlin.d0.d.p implements kotlin.d0.c.l<app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo) {
        SubscriptionViewModel.this.getOnZendeskOpen().postValue(zendeskConfigurationInfo);
    }

    3(SubscriptionViewModel subscriptionViewModel) {
        super(1);
    }
}
