package integrations;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static utils.UrlServices.DELETE_EMPLOYEE;

public class DeleteEmployee implements Task {

    private String id;

    public DeleteEmployee(String id) {
        this.id = id;
    }

    public static DeleteEmployee byId(String id) {
        return Tasks.instrumented(DeleteEmployee.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(DELETE_EMPLOYEE + id));
        SerenityRest.lastResponse().prettyPrint();
        actor.remember("status", SerenityRest.lastResponse().jsonPath().getString("status"));
    }
}
