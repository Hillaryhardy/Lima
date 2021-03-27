package com.first.lima.authentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.first.lima.R;
import com.first.lima.activities.MainDashboard;

import java.util.Arrays;
import java.util.List;

public class FirebaseLogin extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 1234;//this can be any number you want
    List<AuthUI.IdpConfig> providers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_login);

        //init provider
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),//email builder
                new AuthUI.IdpConfig.PhoneBuilder().build(),//phone builder
                new AuthUI.IdpConfig.FacebookBuilder().build(),//facebook builder
                new AuthUI.IdpConfig.GoogleBuilder().build()//google builder
        );
        showSignInOptions();
    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.iconbig)
                        .setTheme(R.style.MyTheme)
                        .build(),MY_REQUEST_CODE

        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK)
            {
//                //get user
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                //show email on toast
//                Toast.makeText(this, ""+user.getEmail(), Toast.LENGTH_SHORT).show();
//                //enable sign out
////                btnsignout.setEnabled(true);
                Intent intent = new Intent (FirebaseLogin.this, MainDashboard.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
