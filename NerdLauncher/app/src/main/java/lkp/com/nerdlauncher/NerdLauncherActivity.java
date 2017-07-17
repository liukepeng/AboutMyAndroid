package lkp.com.nerdlauncher;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/7/17.
 */

public class NerdLauncherActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return NerdLauncherFragment.newInstance();
    }
}
