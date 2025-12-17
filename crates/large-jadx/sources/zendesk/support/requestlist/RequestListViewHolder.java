package zendesk.support.requestlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView.e0;
import com.squareup.picasso.t;
import f.g.d.a;
import f.g.d.c;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zendesk.support.UiUtils;
import zendesk.support.ZendeskAvatarView;

/* loaded from: classes3.dex */
class RequestListViewHolder extends RecyclerView.e0 {

    private final int avatarRadius;
    private final ZendeskAvatarView avatarView;
    private final TextView commentText;
    private final Context context;
    private final zendesk.support.requestlist.RequestListView.OnItemClick listener;
    private final t picasso;
    private final TextView subjectText;
    private final TextView timeText;
    private final TextView userText;
    private RequestListViewHolder(View view, zendesk.support.requestlist.RequestListView.OnItemClick requestListView$OnItemClick2, t t3) {
        super(view);
        this.listener = onItemClick2;
        this.picasso = t3;
        Context obj2 = view.getContext();
        this.context = obj2;
        this.avatarView = (ZendeskAvatarView)view.findViewById(f.e0);
        this.timeText = (TextView)view.findViewById(f.h0);
        this.userText = (TextView)view.findViewById(f.i0);
        this.subjectText = (TextView)view.findViewById(f.g0);
        this.commentText = (TextView)view.findViewById(f.f0);
        this.avatarRadius = obj2.getResources().getDimensionPixelOffset(d.d);
    }

    static zendesk.support.requestlist.RequestListView.OnItemClick access$000(zendesk.support.requestlist.RequestListViewHolder requestListViewHolder) {
        return requestListViewHolder.listener;
    }

    private void bindAvatar(boolean z, List<String> list2, String string3) {
        int avatarRadius;
        t picasso;
        ZendeskAvatarView obj3;
        Object obj4;
        if (z) {
            avatarRadius = 0;
            if (g.c(string3)) {
                this.avatarView.showUserWithAvatarImage(this.picasso, string3, (String)list2.get(avatarRadius), this.avatarRadius);
            } else {
                this.avatarView.showUserWithName((String)list2.get(avatarRadius));
            }
        } else {
            this.avatarView.showUserWithIdentifier(Integer.valueOf(j.m));
        }
    }

    static zendesk.support.requestlist.RequestListViewHolder create(Context context, ViewGroup viewGroup2, zendesk.support.requestlist.RequestListView.OnItemClick requestListView$OnItemClick3, t t4) {
        RequestListViewHolder obj3 = new RequestListViewHolder(LayoutInflater.from(context).inflate(h.m, viewGroup2, false), onItemClick3, t4);
        return obj3;
    }

    private String generateUserText(String string, List<String> list2) {
        ArrayList arrayList = new ArrayList(list2);
        arrayList.add(string);
        return TextUtils.join(", ", arrayList);
    }

    private java.lang.CharSequence getDateTimeString(Date date) {
        return DateUtils.getRelativeTimeSpanString(this.context, date.getTime(), obj2);
    }

    private void style(boolean z, boolean z2, boolean z3) {
        Context context;
        int i;
        TextView obj3;
        int obj4;
        int obj5;
        if (z) {
            obj5 = 1;
            this.subjectText.setTypeface(Typeface.defaultFromStyle(obj5));
            this.userText.setTypeface(Typeface.defaultFromStyle(obj5));
            this.commentText.setTextColor(a.d(this.context, c.B));
            this.timeText.setTextColor(UiUtils.themeAttributeToColor(a.b, this.context, c.C));
        } else {
            obj5 = 0;
            this.subjectText.setTypeface(Typeface.defaultFromStyle(obj5));
            this.userText.setTypeface(Typeface.defaultFromStyle(obj5));
            context = c.C;
            this.commentText.setTextColor(a.d(this.context, context));
            this.timeText.setTextColor(a.d(this.context, context));
        }
        if (z2 != 0) {
            this.commentText.setTextColor(a.d(this.context, c.z));
        }
        this.itemView.setBackgroundColor(a.d(this.context, c.D));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    void bind(zendesk.support.requestlist.RequestListItem requestListItem) {
        TextView commentText;
        Object dateTimeString;
        String firstMessage;
        String lastMessage;
        List lastCommentingAgentNames;
        Object[] arr;
        int i;
        String firstMessage2;
        this.userText.setText(generateUserText(this.context.getString(j.m), requestListItem.getLastCommentingAgentNames()));
        if (requestListItem.hasAgentReplied()) {
            arr = new Object[1];
            firstMessage = this.context.getString(j.n, requestListItem.getFirstMessage());
        } else {
            firstMessage = requestListItem.getFirstMessage();
        }
        this.subjectText.setText(firstMessage);
        if (requestListItem.isClosed()) {
            this.commentText.setText(j.o);
        } else {
            if (requestListItem.isFailed()) {
                this.commentText.setText(j.a);
            } else {
                this.commentText.setText(requestListItem.getLastMessage());
            }
        }
        Date lastUpdated = requestListItem.getLastUpdated();
        if (lastUpdated != null) {
            dateTimeString = getDateTimeString(lastUpdated);
        } else {
            dateTimeString = "";
        }
        this.timeText.setText(dateTimeString);
        bindAvatar(requestListItem.hasAgentReplied(), requestListItem.getLastCommentingAgentNames(), requestListItem.getAvatar());
        style(requestListItem.isUnread(), requestListItem.isFailed(), requestListItem.isClosed());
        RequestListViewHolder.1 anon = new RequestListViewHolder.1(this, requestListItem);
        this.itemView.setOnClickListener(anon);
    }
}
