package manza.coordinatordemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.text);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) textView.getLayoutParams();
        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
        behavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(final View view) {
                view.setVisibility(View.GONE);
                Snackbar.make(view, R.string.hasdeleted, Snackbar.LENGTH_LONG)
                        .setAction(R.string.recover, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                view.setVisibility(View.VISIBLE);
                                ViewPropertyAnimatorCompat animate = ViewCompat.animate(textView);
                                animate.alpha(1);
                                animate.rotationX(180);
                                animate.rotationY(180);
                                animate.rotationBy(50);
                            }
                        }).show();
            }

            @Override
            public void onDragStateChanged(int state) {

            }
        });
        params.setBehavior(behavior);
    }
}
