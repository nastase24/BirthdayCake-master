package cs301.birthdaycake;

import android.util.Log;
import android.view.View;

public class CakeController implements View.OnClickListener{
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cv){
        cakeView = cv;
        cakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("OnClick: ", "pressed");
    }
}
