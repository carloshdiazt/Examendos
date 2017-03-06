package cl.carlos.examendos.data;

import java.util.ArrayList;
import java.util.List;

import cl.carlos.examendos.models.Supplies;

/**
 * Created by diazt on 28-02-2017.
 */

public class Queries {

    public List<Supplies> notDone(){
        List<Supplies> suppliess = new ArrayList<>();
        List<Supplies> suppliesList = Supplies.find(Supplies.class, "done = 0");

        if(suppliesList != null && suppliesList.size() > 0){
            suppliess.addAll(suppliesList);
        }
        return suppliess;
    }
}
