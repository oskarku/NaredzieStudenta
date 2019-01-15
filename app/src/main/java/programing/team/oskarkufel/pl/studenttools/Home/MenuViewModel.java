package programing.team.oskarkufel.pl.studenttools.Home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class MenuViewModel extends ViewModel {

    private MutableLiveData<Boolean> isNotatniko  = new MutableLiveData<>();


    public LiveData<Boolean> getIsNotatniko() {
        return isNotatniko;
    }


    public void changeIsNotatniko(Boolean check) {
        this.isNotatniko.postValue(check);
    }


    public void setValueNotatnik(Boolean check){
        this.isNotatniko.setValue(check);
    }

    private MutableLiveData<String>nameMenu;

    public LiveData<String> getNameChose(){
        return nameMenu;
    }

    public void changeNameChose(String newChose){
        this.nameMenu.postValue(newChose);
    }

    public void setNameMenu(String newChose) {
        this.nameMenu.setValue(newChose);
    }
}
