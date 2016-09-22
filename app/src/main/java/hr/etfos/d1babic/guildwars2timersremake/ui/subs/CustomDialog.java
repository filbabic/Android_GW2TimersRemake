package hr.etfos.d1babic.guildwars2timersremake.ui.subs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.etfos.d1babic.guildwars2timersremake.R;

/**
 * Created by DominikZoran on 22.09.2016..
 */
public class CustomDialog extends Dialog {

    @OnClick(R.id.dismiss_dialog_button)
    public void dismissDialog() {
        dismiss();
    }

    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }
}
