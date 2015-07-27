package criminalintent.mirland.xmartlabs.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by mirland on 24/07/15.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}