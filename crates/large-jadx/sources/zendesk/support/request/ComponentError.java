package zendesk.support.request;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import f.g.d.f;
import f.g.d.j;
import o.b.f;
import o.b.k;
import o.b.o;
import o.b.p;

/* loaded from: classes3.dex */
class ComponentError implements k<zendesk.support.request.ComponentError.ErrorStateModel> {

    private final zendesk.support.request.ActionFactory af;
    private final CoordinatorLayout container;
    private final f dispatcher;
    private zendesk.support.request.StateError.ErrorType errorState;
    private Snackbar snackbar;

    static class ErrorStateModel {

        private final boolean conversationsEnabled;
        private final String errorMessage;
        private final zendesk.support.request.StateError.ErrorType errorState;
        ErrorStateModel(zendesk.support.request.StateError.ErrorType stateError$ErrorType, String string2, boolean z3) {
            super();
            this.errorState = errorType;
            this.errorMessage = string2;
            this.conversationsEnabled = z3;
        }

        static zendesk.support.request.StateError.ErrorType access$000(zendesk.support.request.ComponentError.ErrorStateModel componentError$ErrorStateModel) {
            return errorStateModel.errorState;
        }

        String getErrorMessage() {
            return this.errorMessage;
        }

        zendesk.support.request.StateError.ErrorType getErrorState() {
            return this.errorState;
        }

        boolean isConversationsEnabled() {
            return this.conversationsEnabled;
        }
    }

    static class ErrorStateSelector implements p<zendesk.support.request.ComponentError.ErrorStateModel> {
        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentError.ErrorStateModel selectData(o o) {
            zendesk.support.request.StateError state = StateError.fromState(o);
            ComponentError.ErrorStateModel errorStateModel = new ComponentError.ErrorStateModel(state.getState(), state.getMessage(), StateConfig.fromState(o).getSettings().isConversationsEnabled());
            return errorStateModel;
        }
    }
    private ComponentError(CoordinatorLayout coordinatorLayout, f f2, zendesk.support.request.ActionFactory actionFactory3) {
        super();
        this.container = coordinatorLayout;
        this.dispatcher = f2;
        this.af = actionFactory3;
    }

    static zendesk.support.request.StateError.ErrorType access$102(zendesk.support.request.ComponentError componentError, zendesk.support.request.StateError.ErrorType stateError$ErrorType2) {
        componentError.errorState = errorType2;
        return errorType2;
    }

    static zendesk.support.request.ActionFactory access$200(zendesk.support.request.ComponentError componentError) {
        return componentError.af;
    }

    static f access$300(zendesk.support.request.ComponentError componentError) {
        return componentError.dispatcher;
    }

    static zendesk.support.request.ComponentError create(Activity activity, f f2, zendesk.support.request.ActionFactory actionFactory3) {
        ComponentError componentError = new ComponentError((CoordinatorLayout)activity.findViewById(f.a), f2, actionFactory3);
        return componentError;
    }

    static p<zendesk.support.request.ComponentError.ErrorStateModel> getSelector() {
        ComponentError.ErrorStateSelector errorStateSelector = new ComponentError.ErrorStateSelector();
        return errorStateSelector;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((ComponentError.ErrorStateModel)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.ComponentError.ErrorStateModel componentError$ErrorStateModel) {
        int th;
        zendesk.support.request.ComponentError.1 noError;
        int i;
        Snackbar obj4;
        if (ComponentError.ErrorStateModel.access$000(errorStateModel) == this.errorState) {
        }
        this.errorState = ComponentError.ErrorStateModel.access$000(errorStateModel);
        if (ComponentError.ErrorStateModel.access$000(errorStateModel) != StateError.ErrorType.NoError) {
            this.snackbar = Snackbar.e0(this.container, errorStateModel.getErrorMessage(), -2);
            th = ComponentError.2.$SwitchMap$zendesk$support$request$StateError$ErrorType[errorStateModel.getErrorState().ordinal()];
            if (th != 1) {
                if (th != 2) {
                } else {
                    if (!errorStateModel.isConversationsEnabled()) {
                        this.snackbar.i0(j.i);
                        this.snackbar.T();
                    }
                }
            } else {
                this.snackbar.i0(j.j);
                noError = new ComponentError.1(this);
                this.snackbar.g0(j.x, noError);
                this.snackbar.T();
            }
        } else {
            obj4 = this.snackbar;
            if (obj4 != null) {
                obj4.u();
            }
        }
    }
}
