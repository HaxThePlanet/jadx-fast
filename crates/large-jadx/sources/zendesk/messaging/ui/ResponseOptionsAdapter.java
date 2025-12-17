package zendesk.messaging.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.h.f;
import androidx.recyclerview.widget.q;
import java.util.List;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
class ResponseOptionsAdapter extends q<MessagingItem.Option, RecyclerView.e0> {

    private boolean canSelectOption = true;
    private zendesk.messaging.ui.ResponseOptionHandler responseOptionHandler;
    private MessagingItem.Option selectedOption = null;

    private static class ResponseOptionsDiffCallback extends h.f<MessagingItem.Option> {
        ResponseOptionsDiffCallback(zendesk.messaging.ui.ResponseOptionsAdapter.1 responseOptionsAdapter$1) {
            super();
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areContentsTheSame(Object object, Object object2) {
            return areContentsTheSame((MessagingItem.Option)object, (MessagingItem.Option)object2);
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areContentsTheSame(MessagingItem.Option messagingItem$Option, MessagingItem.Option messagingItem$Option2) {
            return option.equals(option2);
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areItemsTheSame(Object object, Object object2) {
            return areItemsTheSame((MessagingItem.Option)object, (MessagingItem.Option)object2);
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areItemsTheSame(MessagingItem.Option messagingItem$Option, MessagingItem.Option messagingItem$Option2) {
            return option.equals(option2);
        }
    }
    ResponseOptionsAdapter() {
        ResponseOptionsAdapter.ResponseOptionsDiffCallback responseOptionsDiffCallback = new ResponseOptionsAdapter.ResponseOptionsDiffCallback(0);
        super(responseOptionsDiffCallback);
        int i = 1;
    }

    static boolean access$100(zendesk.messaging.ui.ResponseOptionsAdapter responseOptionsAdapter) {
        return responseOptionsAdapter.canSelectOption;
    }

    static boolean access$102(zendesk.messaging.ui.ResponseOptionsAdapter responseOptionsAdapter, boolean z2) {
        responseOptionsAdapter.canSelectOption = z2;
        return z2;
    }

    static zendesk.messaging.ui.ResponseOptionHandler access$200(zendesk.messaging.ui.ResponseOptionsAdapter responseOptionsAdapter) {
        return responseOptionsAdapter.responseOptionHandler;
    }

    private void notifyItemChanged(MessagingItem.Option messagingItem$Option) {
        int i;
        boolean equals;
        i = 0;
        while (i < getItemCount()) {
            i++;
        }
    }

    @Override // androidx.recyclerview.widget.q
    public int getItemViewType(int i) {
        if ((MessagingItem.Option)getItem(i) == this.selectedOption) {
            return R.layout.zui_response_options_selected_option;
        }
        return R.layout.zui_response_options_option;
    }

    @Override // androidx.recyclerview.widget.q
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        final Object obj4 = getItem(i2);
        (TextView)e0.itemView.findViewById(R.id.zui_response_option_text).setText((MessagingItem.Option)obj4.getText());
        ResponseOptionsAdapter.2 anon = new ResponseOptionsAdapter.2(this, e0, obj4);
        e0.itemView.setOnClickListener(anon);
    }

    @Override // androidx.recyclerview.widget.q
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        ResponseOptionsAdapter.1 obj4 = new ResponseOptionsAdapter.1(this, LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
        return obj4;
    }

    @Override // androidx.recyclerview.widget.q
    void setResponseOptionHandler(zendesk.messaging.ui.ResponseOptionHandler responseOptionHandler) {
        this.responseOptionHandler = responseOptionHandler;
    }

    @Override // androidx.recyclerview.widget.q
    void setSelectedOption(MessagingItem.Option messagingItem$Option) {
        this.selectedOption = option;
        notifyItemChanged(option);
    }

    public void submitList(List<MessagingItem.Option> list) {
        super.submitList(list);
        this.canSelectOption = true;
        this.selectedOption = 0;
    }
}
