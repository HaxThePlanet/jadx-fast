package zendesk.messaging.components.bot;

import f.g.e.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.Timer;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public class BotMessageDispatcher<T>  {

    private static final int TYPING_INDICATOR_DELAY;
    private final zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier<T> messageIdentifier;
    private boolean messageProcessing = false;
    private Queue<zendesk.messaging.components.bot.BotMessageDispatcher.Dispatch<T>> messageQueue;
    private List<T> messages;
    private boolean showTypingIndicator;
    private final ActionListener<zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState<T>> stateActionListener;
    private Timer.Factory timerFactory;
    private final ActionListener<Update> updateActionListener;

    public static class ConversationState {

        private final List<T> messages;
        private final boolean typingIndicator;
        ConversationState(List<T> list, boolean z2) {
            super();
            this.messages = list;
            this.typingIndicator = z2;
        }

        public List<T> getMessages() {
            return this.messages;
        }

        public boolean shouldShowTypingIndicator() {
            return this.typingIndicator;
        }
    }

    static class Dispatch {

        private final zendesk.messaging.components.bot.BotMessageDispatcher.DispatchListener dispatchListener;
        private final List<T> messages;
        private final List<Update> updates;
        Dispatch(List<T> list, zendesk.messaging.components.bot.BotMessageDispatcher.DispatchListener botMessageDispatcher$DispatchListener2, List<Update> list3) {
            super();
            this.messages = list;
            this.dispatchListener = dispatchListener2;
            this.updates = list3;
        }

        static List access$000(zendesk.messaging.components.bot.BotMessageDispatcher.Dispatch botMessageDispatcher$Dispatch) {
            return dispatch.messages;
        }

        static List access$200(zendesk.messaging.components.bot.BotMessageDispatcher.Dispatch botMessageDispatcher$Dispatch) {
            return dispatch.updates;
        }

        static zendesk.messaging.components.bot.BotMessageDispatcher.DispatchListener access$600(zendesk.messaging.components.bot.BotMessageDispatcher.Dispatch botMessageDispatcher$Dispatch) {
            return dispatch.dispatchListener;
        }
    }

    public interface DispatchListener {
        public abstract void onDispatch();
    }

    public interface MessageIdentifier {
        public abstract String getId(T t);
    }
    static {
        BotMessageDispatcher.TYPING_INDICATOR_DELAY = (int)millis;
    }

    public BotMessageDispatcher(zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier<T> botMessageDispatcher$MessageIdentifier, ActionListener<zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState<T>> actionListener2, ActionListener<Update> actionListener3, Timer.Factory timer$Factory4) {
        super();
        ArrayList arrayList = new ArrayList();
        this.messages = arrayList;
        LinkedList linkedList = new LinkedList();
        this.messageQueue = linkedList;
        int i = 0;
        this.messageIdentifier = messageIdentifier;
        this.stateActionListener = actionListener2;
        this.updateActionListener = actionListener3;
        this.timerFactory = factory4;
    }

    static List access$100(zendesk.messaging.components.bot.BotMessageDispatcher botMessageDispatcher) {
        return botMessageDispatcher.messages;
    }

    static boolean access$302(zendesk.messaging.components.bot.BotMessageDispatcher botMessageDispatcher, boolean z2) {
        botMessageDispatcher.messageProcessing = z2;
        return z2;
    }

    static boolean access$402(zendesk.messaging.components.bot.BotMessageDispatcher botMessageDispatcher, boolean z2) {
        botMessageDispatcher.showTypingIndicator = z2;
        return z2;
    }

    static void access$500(zendesk.messaging.components.bot.BotMessageDispatcher botMessageDispatcher) {
        botMessageDispatcher.processMessage();
    }

    private List<T> getCopyOfMessages() {
        return a.c(this.messages);
    }

    private void processMessage() {
        Object create;
        zendesk.messaging.components.bot.BotMessageDispatcher.1 anon;
        int tYPING_INDICATOR_DELAY;
        create = this.messageQueue.poll();
        if ((BotMessageDispatcher.Dispatch)create != null) {
            int i = 1;
            this.messageProcessing = i;
            this.showTypingIndicator = i;
            dispatchState();
            anon = new BotMessageDispatcher.1(this, (BotMessageDispatcher.Dispatch)create);
            this.timerFactory.create(anon, BotMessageDispatcher.TYPING_INDICATOR_DELAY).start();
        }
    }

    public void addMessage(T t) {
        List messages;
        if (t != null) {
            this.messages.add(t);
        }
        dispatchState();
    }

    public void addMessageWithTypingIndicator(T t, Update... update2Arr2) {
        addMessagesWithTypingIndicator(Collections.singletonList(t), 0, update2Arr2);
    }

    public void addMessagesWithTypingIndicator(List<T> list, zendesk.messaging.components.bot.BotMessageDispatcher.DispatchListener botMessageDispatcher$DispatchListener2, Update... update3Arr3) {
        BotMessageDispatcher.Dispatch dispatch = new BotMessageDispatcher.Dispatch(list, dispatchListener2, Arrays.asList(update3Arr3));
        this.messageQueue.add(dispatch);
        if (!this.messageProcessing) {
            processMessage();
        }
    }

    public void addMessagesWithTypingIndicator(List<T> list, Update... update2Arr2) {
        addMessagesWithTypingIndicator(list, 0, update2Arr2);
    }

    public void dispatchState() {
        BotMessageDispatcher.ConversationState conversationState = new BotMessageDispatcher.ConversationState(getCopyOfMessages(), this.showTypingIndicator);
        this.stateActionListener.onAction(conversationState);
    }

    public void dispatchUpdate(Update update) {
        this.updateActionListener.onAction(update);
    }

    public T getLastMessage() {
        if (a.g(this.messages)) {
            return 0;
        }
        List messages2 = this.messages;
        return messages2.get(size--);
    }

    public T getMessageById(String string) {
        Object next;
        boolean equals;
        Iterator iterator = this.messages.iterator();
        for (Object next : iterator) {
        }
        return 0;
    }

    public void removeLastMessages(int i) {
        int messages;
        int i2;
        int i3;
        List obj4;
        if (i <= 0) {
        }
        if (this.messages.size() < i) {
            this.messages.clear();
        } else {
            messages = this.messages;
            this.messages = messages.subList(0, size -= i);
        }
        dispatchState();
    }

    public void removeMessage(String string) {
        Object next;
        boolean equals;
        List obj4;
        Iterator iterator = this.messages.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (string.equals(this.messageIdentifier.getId(next))) {
                break;
            } else {
            }
        }
    }

    public void replaceMessage(String string, T t2) {
        removeMessage(string);
        this.messages.add(t2);
        dispatchState();
    }
}
