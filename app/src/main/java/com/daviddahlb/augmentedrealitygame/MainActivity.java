package com.daviddahlb.augmentedrealitygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

    public class MainActivity extends AppCompatActivity{

        private SnackbarHelper snackbarHelper = new SnackbarHelper();
        private ModelRenderable cupRenderable;
        ArFragment arFragment;

        int selected = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            arFragment = (ArFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.sceneform_ux_fragment);


            setupModel();
            arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
                @Override
                public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                    {
                        Anchor anchor = hitResult.createAnchor();
                        AnchorNode anchorNode = new AnchorNode(anchor);
                        anchorNode.setParent(arFragment.getArSceneView().getScene());
                        createModel(anchorNode, selected);
                    }
                }
            });
        }

        private void setupModel() {
            ModelRenderable.builder()
                    .setSource(this, R.raw.cup)
                    .build().thenAccept(renderable -> cupRenderable = renderable)
                    .exceptionally(
                            throwable -> {
                                Log.e("Main", "ERROR LOADING RENDERABLE", throwable);
                                return null;
                            });
        }

        private void createModel(AnchorNode anchorNode, int selected) {
            if (selected == 1) {
                TransformableNode cup = new TransformableNode(arFragment.getTransformationSystem());
                cup.setParent(anchorNode);
                cup.setRenderable(cupRenderable);
                cup.select();
            }
        }
}
