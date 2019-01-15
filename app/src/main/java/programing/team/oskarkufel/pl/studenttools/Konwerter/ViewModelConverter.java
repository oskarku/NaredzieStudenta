package programing.team.oskarkufel.pl.studenttools.Konwerter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class ViewModelConverter extends AndroidViewModel {
    private MutableLiveData<Boolean> isCorrengeWalute = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLenght = new MutableLiveData<>();
    private MutableLiveData<Boolean> isWeight=new MutableLiveData<>();
    private MutableLiveData<Boolean> isVolume=new MutableLiveData<>();

    public ViewModelConverter(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<Boolean> getIsCorrengeWalute() {
        return isCorrengeWalute;
    }

    public MutableLiveData<Boolean> getIsLenght() {
        return isLenght;
    }

    public MutableLiveData<Boolean> getIsWeight() {
        return isWeight;
    }

    public MutableLiveData<Boolean> getIsVolume() {
        return isVolume;
    }

    public void setIsCorrengeWalute (boolean isTrue){
        isCorrengeWalute.postValue(isTrue);
    }

    public void setIsLenght (boolean isTrue){
        isLenght.postValue(isTrue);
    }
    public void setIsWeight (boolean isTrue){
        isWeight.postValue(isTrue);
    }
    public void setIsVolume (boolean isTrue){
        isVolume.postValue(isTrue);
    }





}
