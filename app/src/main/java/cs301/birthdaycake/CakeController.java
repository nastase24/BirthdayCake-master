package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cv){
        cakeView = cv;
        cakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("OnClick: ", "pressed");
        cakeModel.candlesLit = !cakeModel.candlesLit;
        cakeView.invalidate();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d("OnCheck", "checked");
        cakeModel.candlesVisible = b;
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d("OnProgressChanged", "seekbar progress changed to " + i);
        cakeModel.numCandles = i;
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
            cakeModel.balloonX = event.getX();
            cakeModel.balloonY = event.getY();
            cakeModel.balloonVis = true;
            cakeView.invalidate();
            return true;

        }
        return false;
    }
}
