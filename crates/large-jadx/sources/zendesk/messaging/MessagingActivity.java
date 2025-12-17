package zendesk.messaging;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.t;
import f.g.c.a;
import f.g.e.a;
import java.util.Iterator;
import java.util.List;
import o.a.b;
import zendesk.commonui.a;
import zendesk.messaging.ui.MessagingCellFactory;
import zendesk.messaging.ui.MessagingComposer;
import zendesk.messaging.ui.MessagingState;
import zendesk.messaging.ui.MessagingView;

/* loaded from: classes3.dex */
public class MessagingActivity extends d {

    zendesk.messaging.EventFactory eventFactory;
    MessagingCellFactory messagingCellFactory;
    MessagingComposer messagingComposer;
    zendesk.messaging.MessagingDialog messagingDialog;
    private MessagingView messagingView;
    t picasso;
    zendesk.messaging.MessagingViewModel viewModel;
    static MessagingView access$000(zendesk.messaging.MessagingActivity messagingActivity) {
        return messagingActivity.messagingView;
    }

    public static zendesk.messaging.MessagingConfiguration.Builder builder() {
        MessagingConfiguration.Builder builder = new MessagingConfiguration.Builder();
        return builder;
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent3) {
        zendesk.messaging.EventFactory eventFactory;
        int obj3;
        super.onActivityResult(i, i2, intent3);
        final zendesk.messaging.MessagingViewModel viewModel = this.viewModel;
        if (viewModel != null) {
            viewModel.onEvent(this.eventFactory.onActivityResult(i, i2, intent3));
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        int messagingViewModel;
        Object applicationContext;
        Object build;
        boolean z;
        super.onCreate(bundle);
        getTheme().applyStyle(R.style.ZendeskActivityDefaultTheme, true);
        b obj7 = new b();
        obj7 = obj7.f(getIntent().getExtras(), MessagingConfiguration.class);
        messagingViewModel = 0;
        applicationContext = "MessagingActivity";
        if ((MessagingConfiguration)obj7 == null) {
            a.e(applicationContext, "No configuration found. Please use MessagingActivity.builder()", new Object[messagingViewModel]);
            finish();
        }
        final a aVar = a.B1(this);
        final String str3 = "messaging_component";
        List engines = (MessagingConfiguration)obj7.getEngines();
        if ((MessagingComponent)aVar.C1(str3) == null && a.g(engines)) {
            engines = obj7.getEngines();
            if (a.g(engines)) {
                a.e(applicationContext, "No Engines found in MessagingConfiguration. Please use MessagingActivity.builder()", new Object[messagingViewModel]);
                finish();
            }
            zendesk.messaging.MessagingComponent.Builder builder = DaggerMessagingComponent.builder();
            builder.appContext(getApplicationContext());
            builder.engines(engines);
            builder.messagingConfiguration(obj7);
            build = builder.build();
            build.messagingViewModel().start();
            aVar.E1(str3, build);
        }
        zendesk.messaging.MessagingActivityComponent.Builder builder2 = DaggerMessagingActivityComponent.builder();
        builder2.messagingComponent(build);
        builder2.activity(this);
        builder2.build().inject(this);
        setContentView(R.layout.zui_activity_messaging);
        this.messagingView = (MessagingView)findViewById(R.id.zui_view_messaging);
        View viewById2 = findViewById(R.id.zui_toolbar);
        setSupportActionBar((Toolbar)viewById2);
        MessagingActivity.1 anon = new MessagingActivity.1(this);
        viewById2.setNavigationOnClickListener(anon);
        viewById2.setTitle(obj7.getToolbarTitle(getResources()));
        this.messagingComposer.bind((InputBox)findViewById(R.id.zui_input_box));
    }

    @Override // androidx.appcompat.app.d
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean labelId;
        int itemId;
        super.onCreateOptionsMenu(menu);
        final int i = 0;
        if (this.viewModel == null) {
            return i;
        }
        menu.clear();
        Object value = this.viewModel.getLiveMenuItems().getValue();
        final String str3 = "MessagingActivity";
        if (a.g((List)value)) {
            a.b(str3, "Menu: no items, hiding...", new Object[i]);
            return i;
        }
        Iterator iterator = value.iterator();
        for (MenuItem next2 : iterator) {
            menu.add(i, next2.getItemId(), i, next2.getLabelId());
        }
        a.b(str3, "Menu: items updated.", new Object[i]);
        return 1;
    }

    @Override // androidx.appcompat.app.d
    protected void onDestroy() {
        zendesk.messaging.MessagingViewModel viewModel;
        String str;
        String str2;
        super.onDestroy();
        if (isChangingConfigurations()) {
        }
        if (this.viewModel != null) {
            a.b("MessagingActivity", "onDestroy() called, clearing...", new Object[0]);
            this.viewModel.onCleared();
        }
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        this.viewModel.onEvent(this.eventFactory.menuItemClicked(menuItem.getItemId()));
        return 1;
    }

    @Override // androidx.appcompat.app.d
    protected void onStart() {
        Object dialogUpdates;
        zendesk.messaging.MessagingDialog messagingDialog;
        super.onStart();
        dialogUpdates = this.viewModel;
        if (dialogUpdates != null) {
            MessagingActivity.2 anon = new MessagingActivity.2(this);
            dialogUpdates.getLiveMessagingState().observe(this, anon);
            MessagingActivity.3 anon2 = new MessagingActivity.3(this);
            this.viewModel.getLiveNavigationStream().observe(this, anon2);
            MessagingActivity.4 anon3 = new MessagingActivity.4(this);
            this.viewModel.getLiveInterfaceUpdateItems().observe(this, anon3);
            MessagingActivity.5 anon4 = new MessagingActivity.5(this);
            this.viewModel.getLiveMenuItems().observe(this, anon4);
            this.viewModel.getDialogUpdates().observe(this, this.messagingDialog);
        }
    }
}
