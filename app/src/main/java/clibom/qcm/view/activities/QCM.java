package clibom.qcm.view.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import clibom.qcm.R;
import clibom.qcm.view.dictionnary.FragmentBackStackIdentifier;
import clibom.qcm.view.fragments.QCMFragment;

public class QCM extends AppCompatActivity {

    private static final String TAG = "QCMActivity";
    private TextView mTextMessage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if (findViewById(R.id.qcm_frame_layout) != null) {
            if (savedInstanceState != null) {
                return;
            }

            try {
                QCMFragment qcmFragment = new QCMFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.qcm_frame_layout, qcmFragment, QCMFragment.TAG);
                transaction.addToBackStack(FragmentBackStackIdentifier.QCM_FRAGMENT);
                transaction.commit();
            } catch (IllegalStateException e) {
                Log.e(TAG, Log.getStackTraceString(e));
                getSupportFragmentManager().popBackStack();
//                displayToastMessage(this, R.string.failed_fragment_transaction);
            }
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
