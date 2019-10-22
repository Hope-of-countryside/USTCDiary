//package com.grouptwo.ustcdiary.main;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.DialogFragment;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//
//public class nameAndImageFragment extends DialogFragment implements View.OnClickListener {
//
//    public interface fragmentCallback {
//        void updateName();
//    }
//    private fragmentCallback callback;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        try{
//            callback = (fragmentCallback) context;
//        }catch(ClassCastException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        return dialog;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        this.getDialog().setCanceledOnTouchOutside(true);
////        View rootview = inflater.inflate();
//
//
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//}
