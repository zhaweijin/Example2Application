package com.example2.test.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

public class AndFixManager {

    private static AndFixManager instance;
    private static PatchManager patchManager;

    AndFixManager(){
    }


    public static AndFixManager getInstance(){
        if(instance==null){
            synchronized (AndFixManager.class){
                if(instance==null){
                    instance = new AndFixManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context){
        patchManager = new PatchManager(context);
        patchManager.init("1.0");//current version
        patchManager.loadPatch();
    }

    public static void addPatch(String patch_path){
        try {
            patchManager.addPatch(patch_path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
