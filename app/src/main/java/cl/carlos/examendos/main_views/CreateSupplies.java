package cl.carlos.examendos.main_views;

import cl.carlos.examendos.models.Supplies;

/**
 * Created by diazt on 04-03-2017.
 */

public class CreateSupplies {

    private SuppliesCallback callback;

    public CreateSupplies(SuppliesCallback callback) {
        this.callback = callback;
    }

    public void validation(String name){
        if(name.trim().length() > 0){
            Supplies supplies = new Supplies();
            supplies.setName(name);
            supplies.setDone(false);
            supplies.save();
            callback.created(supplies);
        } else {
            callback.noName();
        }
    }
}
