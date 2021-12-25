package idnp.grupo_uno.proyecto_final.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import idnp.grupo_uno.proyecto_final.entidades.EventDetail;


public class TourDetailViewModel extends ViewModel {
    private MutableLiveData<EventDetail> eventDetail;
    private MutableLiveData<Integer> eventId;

    public LiveData<EventDetail> getEventDetail() {
        if (eventDetail == null) {
            eventDetail = new MutableLiveData<>();
            loadEventDetail(1);
        }
        return eventDetail;
    }

    public LiveData<Integer> getEventId() {
        return null;
    }

    public void loadEventDetail(int id) {

    }
}
