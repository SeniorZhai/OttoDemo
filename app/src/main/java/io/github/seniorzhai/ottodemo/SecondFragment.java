package io.github.seniorzhai.ottodemo;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

public class SecondFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    private View mView;
    private ObjectAnimator objectAnimator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mView = view.findViewById(R.id.view);
        objectAnimator = ObjectAnimator.ofFloat(mView, "RotationY", 720f).setDuration(3000);
        return view;
    }

    @Subscribe
    public void onEvent(BusEvent busEvent) {
        objectAnimator.start();
    }


}
