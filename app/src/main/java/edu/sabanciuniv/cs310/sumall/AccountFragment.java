package edu.sabanciuniv.cs310.sumall;

import android.accounts.Account;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Cemges on 5/6/2018.
 */

public class AccountFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tt = (Button) getView().findViewById(R.id.email_sign_in_button);
        tt.setOnClickListener(this);

        Button register = (Button) getView().findViewById(R.id.newaccount);

        register.setOnClickListener(this);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_login, container, false);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                fragment = new AccountInfoFragment();
                break;
            case R.id.newaccount:
                fragment = new RegisterFragment();
                break;


        }
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }






}
