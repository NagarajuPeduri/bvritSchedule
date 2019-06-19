package org.bvrit.bvritschedule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class dialogHandle extends AppCompatDialogFragment {

    EditText tsubject;
    EditText troom;
    EditText tyear;
    EditText tclass;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogue_box, null);

        tsubject = view.findViewById(R.id.tsubject);
        troom = view.findViewById(R.id.troomNumber);
        tclass = view.findViewById(R.id.tclass);
        tyear = view.findViewById(R.id.tyear);

        builder.setView(view)
                .setTitle("Enter details")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String subject = tsubject.getText().toString();
                        String room = troom.getText().toString();
                        String clas = tclass.getText().toString();
                        String year = tyear.getText().toString();

                        listener.applyTexts(subject, room, clas, year);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String subject, String room, String clas, String year);
    }

}
