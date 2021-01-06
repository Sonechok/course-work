package codingcity.entity.enums;

import codingcity.entity.Stats;

import java.util.ArrayList;
import java.util.List;

public enum Status {
    inProgress,
    done,
    toDo,
    none;

    public static List<Stats> valuesString(){
        List<Stats> values = new ArrayList<>();
        values.add(new Stats(Status.done.toString()));
        values.add(new Stats(Status.inProgress.toString()));
        values.add(new Stats(Status.toDo.toString()));
        values.add(new Stats(Status.none.toString()));
        return values;
    }
}
