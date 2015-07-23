package criminalintent.mirland.xmartlabs.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by mirland on 22/07/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}