package integrations;

import models.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static utils.UrlServices.SELECT_EMPLOYEE;

public class ConsultEmployee implements Task {

    private String id;

    public ConsultEmployee(String id) {
        this.id = id;
    }

    public static ConsultEmployee byId(String id) {
        return Tasks.instrumented(ConsultEmployee.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("ID que llego: " + id.toString());
        actor.attemptsTo(Get.resource(SELECT_EMPLOYEE + id.toString()));

        SerenityRest.lastResponse().prettyPrint();
        Employee employee = SerenityRest.lastResponse().jsonPath().getObject("data", Employee.class);
        actor.remember("Employee", employee);

        actor.remember("status", SerenityRest.lastResponse().jsonPath().getString("status"));
    }
}
