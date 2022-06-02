package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmpleadoInfo implements Question<String> {
    public static EmpleadoInfo is() {
        return new EmpleadoInfo();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.recall("Employee").toString();
    }
}
