package com.example.zjjx.southlakebaoan.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zjjx.southlakebaoan.R;

/**
 * Created by Administrator on 2018/2/25.
 */

public class UpAppDialog extends DialogFragment {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private View.OnClickListener positiveCallback;
    private String description;
    private OnDialogButtonClickListener buttonClickListner;
    //实现回调功能
    public interface OnDialogButtonClickListener {
         void okButtonClick();
         void cancelButtonClick();

    }
    public static UpAppDialog getInstance(String description) {
        Bundle bundle = new Bundle();
        bundle.putString(DESCRIPTION, description);
        UpAppDialog versionDialogFragment = new UpAppDialog();
        versionDialogFragment.setArguments(bundle);
        return versionDialogFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            if (dialog.getWindow() != null) {
                dialog.getWindow().setLayout((int) (dm.widthPixels * 0.7), ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            }
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        description = bundle.getString(DESCRIPTION);
    }

    public void show(FragmentManager fragmentManager, OnDialogButtonClickListener buttonClickListner) {
        this.buttonClickListner = buttonClickListner;
        show(fragmentManager, "VersionDialogFragment");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.update_app_dialog, null);
        TextView tv_cancel =  view.findViewById(R.id.btn_cancel);
        TextView tv_upgrade =  view.findViewById(R.id.btn_upgrade);
        TextView tv_description = view.findViewById(R.id.tv_description);
        tv_description.setText(description);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickListner.cancelButtonClick();
            }
        });
        tv_upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickListner.okButtonClick();
            }
        });
//        tv_upgrade.setOnClickListener(positiveCallback);
        builder.setView(view);
        return builder.create();
    }

    public void setOnButtonClickListener(OnDialogButtonClickListener listener) {
        this.buttonClickListner = listener;
    }
}
