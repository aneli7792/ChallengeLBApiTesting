package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseService implements Question<String> {

    public static ResponseService of() {
        return new ResponseService();
    }

    @Override
    public String answeredBy(Actor actor) {
        System.out.println(actor.recall("status").toString());
        return actor.recall("status").toString();
    }
}
