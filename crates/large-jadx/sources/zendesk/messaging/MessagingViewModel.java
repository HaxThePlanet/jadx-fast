package zendesk.messaging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.util.List;
import zendesk.messaging.ui.MessagingState;
import zendesk.messaging.ui.MessagingState.Builder;
import zendesk.messaging.ui.MessagingState.TypingState;

/* loaded from: classes3.dex */
public class MessagingViewModel extends e0 implements zendesk.messaging.EventListener {

    private final v<zendesk.messaging.Banner> liveBannersState;
    private final v<MessagingState> liveMessagingState;
    private final LiveData<zendesk.messaging.Update.Action.Navigation> liveNavigationStream;
    private final zendesk.messaging.MessagingModel messagingModel;
    MessagingViewModel(zendesk.messaging.MessagingModel messagingModel) {
        super();
        this.messagingModel = messagingModel;
        v vVar = new v();
        this.liveMessagingState = vVar;
        this.liveNavigationStream = messagingModel.getLiveNavigationUpdates();
        MessagingState.Builder builder = new MessagingState.Builder();
        builder.withEnabled(true);
        vVar.setValue(builder.build());
        v vVar2 = new v();
        this.liveBannersState = vVar2;
        v vVar3 = new v();
        MessagingViewModel.1 anon2 = new MessagingViewModel.1(this);
        vVar.b(messagingModel.getLiveMessagingItems(), anon2);
        MessagingViewModel.2 anon3 = new MessagingViewModel.2(this);
        vVar.b(messagingModel.getLiveComposerEnabled(), anon3);
        MessagingViewModel.3 anon4 = new MessagingViewModel.3(this);
        vVar.b(messagingModel.getLiveTyping(), anon4);
        MessagingViewModel.4 anon5 = new MessagingViewModel.4(this);
        vVar.b(messagingModel.getLiveConnection(), anon5);
        MessagingViewModel.5 anon6 = new MessagingViewModel.5(this);
        vVar.b(messagingModel.getLiveComposerHint(), anon6);
        MessagingViewModel.6 anon7 = new MessagingViewModel.6(this);
        vVar.b(messagingModel.getLiveKeyboardInputType(), anon7);
        MessagingViewModel.7 anon8 = new MessagingViewModel.7(this);
        vVar.b(messagingModel.getLiveAttachmentSettings(), anon8);
        MessagingViewModel.8 anon = new MessagingViewModel.8(this);
        vVar2.b(messagingModel.getLiveInterfaceUpdates(), anon);
    }

    static v access$000(zendesk.messaging.MessagingViewModel messagingViewModel) {
        return messagingViewModel.liveMessagingState;
    }

    static v access$100(zendesk.messaging.MessagingViewModel messagingViewModel) {
        return messagingViewModel.liveBannersState;
    }

    zendesk.messaging.SingleLiveEvent<zendesk.messaging.DialogContent> getDialogUpdates() {
        return this.messagingModel.getLiveDialogUpdates();
    }

    zendesk.messaging.SingleLiveEvent<zendesk.messaging.Banner> getLiveInterfaceUpdateItems() {
        return this.messagingModel.getLiveInterfaceUpdates();
    }

    LiveData<List<zendesk.messaging.MenuItem>> getLiveMenuItems() {
        return this.messagingModel.getLiveMenuItems();
    }

    public LiveData<MessagingState> getLiveMessagingState() {
        return this.liveMessagingState;
    }

    LiveData<zendesk.messaging.Update.Action.Navigation> getLiveNavigationStream() {
        return this.liveNavigationStream;
    }

    @Override // androidx.lifecycle.e0
    protected void onCleared() {
        this.messagingModel.stop();
    }

    @Override // androidx.lifecycle.e0
    public void onEvent(zendesk.messaging.Event event) {
        this.messagingModel.onEvent(event);
    }

    @Override // androidx.lifecycle.e0
    void start() {
        this.messagingModel.start();
    }
}
