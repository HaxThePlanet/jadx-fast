package zendesk.messaging;

import android.app.ActivityManager.MemoryInfo;
import android.content.res.Resources;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import o.a.a;

/* loaded from: classes3.dex */
class MessagingModel implements zendesk.messaging.MessagingApi, zendesk.messaging.EventListener, zendesk.messaging.Engine.UpdateObserver {

    private static final zendesk.messaging.AttachmentSettings DEFAULT_ATTACHMENT_SETTINGS;
    private static final zendesk.messaging.Update DEFAULT_INPUT_STATE_UPDATE;
    private static final zendesk.messaging.Update DEFAULT_MENU_ITEMS;
    private final List<a> configurations;
    private final zendesk.messaging.MessagingConversationLog conversationLog;
    private zendesk.messaging.Engine currentEngine;
    private final zendesk.messaging.AgentDetails defaultAgentDetails;
    private final Map<zendesk.messaging.Engine, List<zendesk.messaging.MessagingItem>> engineItems;
    private final List<zendesk.messaging.Engine> engines;
    private final x<zendesk.messaging.AttachmentSettings> liveAttachmentSettings;
    private final x<Boolean> liveComposerEnabled;
    private final x<String> liveComposerHint;
    private final x<zendesk.messaging.ConnectionState> liveConnection;
    private final zendesk.messaging.SingleLiveEvent<zendesk.messaging.DialogContent> liveDialogUpdates;
    private final zendesk.messaging.SingleLiveEvent<zendesk.messaging.Banner> liveInterfaceUpdates;
    private final x<Integer> liveKeyboardInputType;
    private final x<List<zendesk.messaging.MenuItem>> liveMenuItems;
    private final x<List<zendesk.messaging.MessagingItem>> liveMessagingItems;
    private final zendesk.messaging.SingleLiveEvent<zendesk.messaging.Update.Action.Navigation> liveNavigationUpdates;
    private final x<zendesk.messaging.Typing> liveTyping;
    static {
        final int i2 = 0;
        AttachmentSettings attachmentSettings = new AttachmentSettings(0, obj2, i2);
        MessagingModel.DEFAULT_ATTACHMENT_SETTINGS = attachmentSettings;
        Update.State.UpdateInputFieldState updateInputFieldState = new Update.State.UpdateInputFieldState("", Boolean.TRUE, attachmentSettings, 131073);
        MessagingModel.DEFAULT_INPUT_STATE_UPDATE = updateInputFieldState;
        Update.ApplyMenuItems applyMenuItems = new Update.ApplyMenuItems(new MenuItem[i2]);
        MessagingModel.DEFAULT_MENU_ITEMS = applyMenuItems;
    }

    MessagingModel(Resources resources, List<zendesk.messaging.Engine> list2, zendesk.messaging.MessagingConfiguration messagingConfiguration3, zendesk.messaging.MessagingConversationLog messagingConversationLog4) {
        ArrayList arrayList;
        int engines;
        super();
        arrayList = new ArrayList(list2.size());
        this.engines = arrayList;
        Iterator obj4 = list2.iterator();
        while (obj4.hasNext()) {
            arrayList = obj4.next();
            if ((Engine)arrayList != null) {
            }
            this.engines.add((Engine)arrayList);
        }
        this.conversationLog = messagingConversationLog4;
        this.configurations = messagingConfiguration3.getConfigurations();
        this.defaultAgentDetails = messagingConfiguration3.getBotAgentDetails(resources);
        LinkedHashMap obj3 = new LinkedHashMap();
        this.engineItems = obj3;
        obj3 = new x();
        this.liveMessagingItems = obj3;
        obj3 = new x();
        this.liveMenuItems = obj3;
        obj3 = new x();
        this.liveTyping = obj3;
        obj3 = new x();
        this.liveConnection = obj3;
        obj3 = new x();
        this.liveComposerHint = obj3;
        obj3 = new x();
        this.liveKeyboardInputType = obj3;
        obj3 = new x();
        this.liveComposerEnabled = obj3;
        obj3 = new x();
        this.liveAttachmentSettings = obj3;
        obj3 = new SingleLiveEvent();
        this.liveNavigationUpdates = obj3;
        obj3 = new SingleLiveEvent();
        this.liveInterfaceUpdates = obj3;
        obj3 = new SingleLiveEvent();
        this.liveDialogUpdates = obj3;
    }

    static void access$000(zendesk.messaging.MessagingModel messagingModel, zendesk.messaging.Engine engine2) {
        messagingModel.startEngine(engine2);
    }

    private void startEngine(zendesk.messaging.Engine engine) {
        zendesk.messaging.Engine currentEngine = this.currentEngine;
        if (currentEngine != null && currentEngine != engine) {
            if (currentEngine != engine) {
                stopEngine(currentEngine);
            }
        }
        this.currentEngine = engine;
        engine.registerObserver(this);
        update(MessagingModel.DEFAULT_INPUT_STATE_UPDATE);
        update(MessagingModel.DEFAULT_MENU_ITEMS);
        engine.start(this);
    }

    private void startInitialEngine(List<zendesk.messaging.Engine> list) {
        int size;
        zendesk.messaging.MessagingModel.2 anon;
        if (a.g(list)) {
        }
        if (list.size() == 1) {
            startEngine((Engine)list.get(0));
        }
        ArrayList arrayList = new ArrayList();
        MessagingModel.1 anon2 = new MessagingModel.1(this, arrayList, list);
        ObservableCounter observableCounter = new ObservableCounter(anon2);
        observableCounter.increment(list.size());
        Iterator obj5 = list.iterator();
        for (Engine size : obj5) {
            anon = new MessagingModel.2(this, arrayList, observableCounter);
            size.isConversationOngoing(anon);
        }
    }

    private void stopEngine(zendesk.messaging.Engine engine) {
        engine.stop();
        engine.unregisterObserver(this);
    }

    @Override // zendesk.messaging.MessagingApi
    public zendesk.messaging.AgentDetails getBotAgentDetails() {
        return this.defaultAgentDetails;
    }

    public List<a> getConfigurations() {
        return this.configurations;
    }

    @Override // zendesk.messaging.MessagingApi
    public zendesk.messaging.ConversationLog getConversationLog() {
        return this.conversationLog;
    }

    x<zendesk.messaging.AttachmentSettings> getLiveAttachmentSettings() {
        return this.liveAttachmentSettings;
    }

    x<Boolean> getLiveComposerEnabled() {
        return this.liveComposerEnabled;
    }

    x<String> getLiveComposerHint() {
        return this.liveComposerHint;
    }

    LiveData<zendesk.messaging.ConnectionState> getLiveConnection() {
        return this.liveConnection;
    }

    zendesk.messaging.SingleLiveEvent<zendesk.messaging.DialogContent> getLiveDialogUpdates() {
        return this.liveDialogUpdates;
    }

    zendesk.messaging.SingleLiveEvent<zendesk.messaging.Banner> getLiveInterfaceUpdates() {
        return this.liveInterfaceUpdates;
    }

    public x<Integer> getLiveKeyboardInputType() {
        return this.liveKeyboardInputType;
    }

    LiveData<List<zendesk.messaging.MenuItem>> getLiveMenuItems() {
        return this.liveMenuItems;
    }

    LiveData<List<zendesk.messaging.MessagingItem>> getLiveMessagingItems() {
        return this.liveMessagingItems;
    }

    zendesk.messaging.SingleLiveEvent<zendesk.messaging.Update.Action.Navigation> getLiveNavigationUpdates() {
        return this.liveNavigationUpdates;
    }

    LiveData<zendesk.messaging.Typing> getLiveTyping() {
        return this.liveTyping;
    }

    public List<zendesk.messaging.Engine.TransferOptionDescription> getTransferOptionDescriptions() {
        Object transferOptionDescription;
        boolean transferOptionDescription2;
        ArrayList arrayList = new ArrayList(this.engines.size());
        Iterator iterator = this.engines.iterator();
        while (iterator.hasNext()) {
            transferOptionDescription = iterator.next();
            if (!(Engine)transferOptionDescription.equals(this.currentEngine) && transferOptionDescription.getTransferOptionDescription() != null) {
            }
            if (transferOptionDescription.getTransferOptionDescription() != null) {
            }
            arrayList.add(transferOptionDescription.getTransferOptionDescription());
        }
        return arrayList;
    }

    @Override // zendesk.messaging.MessagingApi
    public void onEvent(zendesk.messaging.Event event) {
        Object currentEngine;
        String next;
        boolean equals;
        String str;
        this.conversationLog.addEvent(event);
        if (event.getType().equals("transfer_option_clicked")) {
            currentEngine = this.engines.iterator();
            while (currentEngine.hasNext()) {
                next = currentEngine.next();
                if ((Event.EngineSelection)event.getSelectedEngine().getEngineId().equals((Engine)next.getId())) {
                    break;
                } else {
                }
            }
        } else {
            currentEngine = this.currentEngine;
            if (currentEngine != null) {
                currentEngine.onEvent(event);
            }
        }
    }

    @Override // zendesk.messaging.MessagingApi
    void start() {
        update(Update.State.UpdateInputFieldState.updateInputFieldEnabled(false));
        startInitialEngine(this.engines);
    }

    @Override // zendesk.messaging.MessagingApi
    void stop() {
        zendesk.messaging.Engine currentEngine;
        currentEngine = this.currentEngine;
        if (currentEngine != null) {
            currentEngine.stop();
            this.currentEngine.unregisterObserver(this);
        }
    }

    @Override // zendesk.messaging.MessagingApi
    public void update(zendesk.messaging.Update update) {
        boolean liveKeyboardInputType;
        String liveAttachmentSettings;
        zendesk.messaging.Engine currentEngine3;
        int iterator;
        boolean next;
        boolean currentEngine2;
        boolean transferResponse;
        zendesk.messaging.MessagingItem.TransferResponse currentEngine;
        java.util.Date timestamp;
        String str;
        int agentDetails;
        String message;
        List engineOptions;
        int i;
        Object obj15;
        liveKeyboardInputType.hashCode();
        final int i3 = 1;
        final int i5 = 0;
        iterator = -1;
        switch (liveKeyboardInputType) {
            case "update_input_field_state":
                iterator = i5;
                break;
            case "apply_messaging_items":
                iterator = i3;
                break;
            case "show_banner":
                iterator = 2;
                break;
            case "hide_typing":
                iterator = 3;
                break;
            case "show_dialog":
                iterator = 4;
                break;
            case "apply_menu_items":
                iterator = 5;
                break;
            case "show_typing":
                iterator = 6;
                break;
            case "update_connection_state":
                iterator = 7;
                break;
            case "navigation":
                iterator = 8;
                break;
            default:
        }
        switch (iterator) {
            case 0:
                String hint = (Update.State.UpdateInputFieldState)update.getHint();
                this.liveComposerHint.postValue(hint);
                Boolean enabled = update.isEnabled();
                this.liveComposerEnabled.postValue(enabled);
                zendesk.messaging.AttachmentSettings attachmentSettings = update.getAttachmentSettings();
                this.liveAttachmentSettings.postValue(attachmentSettings);
                obj15 = update.getInputType();
                this.liveKeyboardInputType.postValue(obj15);
                this.liveKeyboardInputType.postValue(131073);
                break;
            case 1:
                this.engineItems.put(this.currentEngine, (Update.State.ApplyMessagingItems)update.getMessagingItems());
                obj15 = new ArrayList();
                Iterator iterator2 = this.engineItems.entrySet().iterator();
                currentEngine3 = iterator2.next();
                iterator = (List)(Map.Entry)currentEngine3.getValue().iterator();
                next = iterator.next();
                i = i3;
                i = i5;
                super((MessagingItem)next.getTimestamp(), next.getId(), (MessagingItem.TransferResponse)next.getAgentDetails(), next.getMessage(), next.getEngineOptions(), i);
                next = transferResponse;
                obj15.add(next);
                this.liveMessagingItems.postValue(obj15);
                this.conversationLog.setMessagingItems(obj15);
                break;
            case 2:
                this.liveInterfaceUpdates.postValue((Update.ShowBanner)update.getBanner());
                break;
            case 3:
                liveKeyboardInputType = new Typing(i5);
                this.liveTyping.postValue(liveKeyboardInputType);
                break;
            case 4:
                this.liveDialogUpdates.postValue((Update.ShowDialog)update.getDialogContent());
                break;
            case 5:
                this.liveMenuItems.postValue((Update.ApplyMenuItems)update.getMenuItems());
                break;
            case 6:
                liveAttachmentSettings = new Typing(i3, (Update.State.ShowTyping)update.getAgentDetails());
                this.liveTyping.postValue(liveAttachmentSettings);
                break;
            case 7:
                this.liveConnection.postValue((Update.State.UpdateConnectionState)update.getConnectionState());
                break;
            case 8:
                this.liveNavigationUpdates.postValue((Update.Action.Navigation)update);
                break;
            default:
        }
    }
}
